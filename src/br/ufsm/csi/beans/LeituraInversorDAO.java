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
            dataIn.set(Calendar.HOUR_OF_DAY, dataIn.getActualMinimum(dataIn.HOUR_OF_DAY));
            dataIn.set(Calendar.MINUTE, dataIn.getActualMinimum(dataIn.MINUTE));
            dataIn.set(Calendar.SECOND, dataIn.getActualMinimum(dataIn.SECOND));
            dataIn.set(Calendar.MILLISECOND, dataIn.getActualMinimum(dataIn.MILLISECOND));

            dataFim.setTime(dataFinal);
            dataFim.set(Calendar.HOUR_OF_DAY, dataFim.getActualMaximum(dataIn.HOUR_OF_DAY));
            dataFim.set(Calendar.MINUTE, dataFim.getActualMaximum(dataIn.MINUTE));
            dataFim.set(Calendar.SECOND, dataFim.getActualMaximum(dataIn.SECOND));
            dataFim.set(Calendar.MILLISECOND, dataFim.getActualMaximum(dataIn.MILLISECOND));

            criteria.add(Restrictions.between("dataHoraLeitura", dataIn, dataFim));
        }else if (dataInicial != null) {
            criteria.add(Restrictions.ge("dataHoraLeitura", dataInicial));

        } else if (dataFinal != null) {
            criteria.add(Restrictions.le("dataHoraLeitura", dataFinal));
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
