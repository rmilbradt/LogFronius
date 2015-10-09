package br.ufsm.csi.beans;

import br.ufsm.csi.model.LeituraInversor;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by politecnico on 18/06/2015.
 */
@Repository
public class LeituraInversorDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public void gravaLeitura(LeituraInversor leitura) {
        sessionFactory.getCurrentSession().save(leitura);
    }

    @Transactional
    public List<LeituraInversor> findLeituras() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LeituraInversor.class);
        criteria.addOrder(Order.asc("dataHoraLeitura"));
        return criteria.list();
    }

    @Transactional
    public List<LeituraInversor> findLeiturasByData(Date dataInicial, Date dataFinal) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LeituraInversor.class);
        if (dataInicial!= null && dataFinal != null){
            Calendar dataFim = Calendar.getInstance();
            Calendar dataIn = Calendar.getInstance();

            dataIn.setTime(dataInicial);
            dataIn.set(Calendar.HOUR_OF_DAY, dataIn.getActualMinimum(Calendar.HOUR_OF_DAY));
            dataIn.set(Calendar.MINUTE, dataIn.getActualMinimum(Calendar.MINUTE));
            dataIn.set(Calendar.SECOND, dataIn.getActualMinimum(Calendar.SECOND));
            dataIn.set(Calendar.MILLISECOND, dataIn.getActualMinimum(Calendar.MILLISECOND));

            dataFim.setTime(dataFinal);
            dataFim.set(Calendar.HOUR_OF_DAY, dataFim.getActualMaximum(Calendar.HOUR_OF_DAY));
            dataFim.set(Calendar.MINUTE, dataFim.getActualMaximum(Calendar.MINUTE));
            dataFim.set(Calendar.SECOND, dataFim.getActualMaximum(Calendar.SECOND));
            dataFim.set(Calendar.MILLISECOND, dataFim.getActualMaximum(Calendar.MILLISECOND));

            criteria.add(Restrictions.between("dataHoraLeitura", dataIn.getTime(), dataFim.getTime()));
        }else if (dataInicial != null) {
            Calendar dataIn = Calendar.getInstance();

            dataIn.setTime(dataInicial);
            dataIn.set(Calendar.HOUR_OF_DAY, dataIn.getActualMinimum(Calendar.HOUR_OF_DAY));
            dataIn.set(Calendar.MINUTE, dataIn.getActualMinimum(Calendar.MINUTE));
            dataIn.set(Calendar.SECOND, dataIn.getActualMinimum(Calendar.SECOND));
            dataIn.set(Calendar.MILLISECOND, dataIn.getActualMinimum(Calendar.MILLISECOND));

            criteria.add(Restrictions.ge("dataHoraLeitura", dataIn.getTime()));

        } else if (dataFinal != null) {
            Calendar dataFim = Calendar.getInstance();

            dataFim.setTime(dataFinal);
            dataFim.set(Calendar.HOUR_OF_DAY, dataFim.getActualMaximum(Calendar.HOUR_OF_DAY));
            dataFim.set(Calendar.MINUTE, dataFim.getActualMaximum(Calendar.MINUTE));
            dataFim.set(Calendar.SECOND, dataFim.getActualMaximum(Calendar.SECOND));
            dataFim.set(Calendar.MILLISECOND, dataFim.getActualMaximum(Calendar.MILLISECOND));

            criteria.add(Restrictions.le("dataHoraLeitura", dataFim.getTime()));
        }
        criteria.addOrder(Order.asc("dataHoraLeitura"));
        return criteria.list();
    }

    @Transactional
    public List<LeituraInversor> findLeiturasUltimasHoras(int qtdHoras) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, -qtdHoras);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LeituraInversor.class);
        criteria.add(Restrictions.ge("dataHoraLeitura", cal.getTime()));
        criteria.addOrder(Order.asc("dataHoraLeitura"));
        return criteria.list();
    }

}
