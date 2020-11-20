package impl;

import interfaces.EncuestaDao;
import ucab.dsw.entidades.Encuesta;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EncuestaDaoImpl implements EncuestaDao {
    @PersistenceContext(unitName = "TallerPU")
    EntityManager em;

    @Override
    public List<Encuesta> findAll() {
        return em.createNamedQuery("Encuesta.findAll", Encuesta.class).getResultList();
    }

    @Override
    public Encuesta find(Encuesta encuesta) {
        return em.find(Encuesta.class, encuesta.getId());
    }

    @Override
    public void insertEncuesta(Encuesta encuesta) {
        em.persist(encuesta);
        em.flush();
    }

    @Override
    public void updateEncuesta(Encuesta encuesta) {
        em.merge(encuesta);
    }

    @Override
    public void deleteEncuesta(Encuesta encuesta) {
        em.remove(em.merge(encuesta));
    }
}
