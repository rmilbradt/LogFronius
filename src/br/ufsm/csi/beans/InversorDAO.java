package br.ufsm.csi.beans;

import br.ufsm.csi.model.Inversor;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 201420240 on 14/08/2015.
 */

@Repository
public class InversorDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public void gravaInversor(Inversor inversor) {
        sessionFactory.getCurrentSession().save(inversor);
    }

    @Transactional
    public List<Inversor> findInversores() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Inversor.class);
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

}
