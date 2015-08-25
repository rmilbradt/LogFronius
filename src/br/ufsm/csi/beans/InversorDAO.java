package br.ufsm.csi.beans;

import br.ufsm.csi.model.Inversor;
import br.ufsm.csi.model.LeituraInversor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 201420240 on 14/08/2015.
 */

@Repository
public class InversorDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public void gravaLeitura(Inversor leitura) {
        sessionFactory.getCurrentSession().save(leitura);
    }
}
