package br.ufsm.csi.beans;

import br.ufsm.csi.model.LeituraInversor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by politecnico on 18/06/2015.
 */
@Repository
public class LeiruaInversorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void gravaLeitura(LeituraInversor leitura) {
        sessionFactory.getCurrentSession().save(leitura);
    }

}
