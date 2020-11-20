package impl;

import interfaces.TipoPreguntaDao;
import ucab.dsw.entidades.Tipopregunta;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TipoPreguntaDaoImpl implements TipoPreguntaDao {
    @PersistenceContext(unitName = "TallerPU")
    EntityManager em;

    @Override
    public List<Tipopregunta> findAll() {
        return em.createNamedQuery("Tipopregunta.findAll").getResultList();
    }

    @Override
    public Tipopregunta find(Tipopregunta tipopregunta) {
        return em.find(Tipopregunta.class, tipopregunta.getId());
    }

    @Override
    public void insertTipoPregunta(Tipopregunta tipopregunta) {
        em.persist(tipopregunta);
        em.flush();
    }

    @Override
    public void updateTipoPregunta(Tipopregunta tipopregunta) {
       em.merge(tipopregunta);
    }

    @Override
    public void deleteTipoPregunta(Tipopregunta tipopregunta) {
        em.remove(em.merge(tipopregunta));
    }
}
