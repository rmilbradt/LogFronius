package br.ufsm.csi.beans;

import br.ufsm.csi.model.LeituraInversor;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
