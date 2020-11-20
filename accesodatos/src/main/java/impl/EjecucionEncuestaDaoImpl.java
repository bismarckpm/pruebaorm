package impl;

import interfaces.EjecucionEncuestaDao;
import ucab.dsw.entidades.Ejecucionencuesta;
import ucab.dsw.entidades.Encuesta;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EjecucionEncuestaDaoImpl implements EjecucionEncuestaDao {
    @PersistenceContext(unitName = "TallerPU")
    EntityManager em;

    @Override
    public List<Ejecucionencuesta> findAll() {
        return em.createNamedQuery("Ejecucionencuesta.findAll").getResultList();
    }

    @Override
    public List<Ejecucionencuesta> findBySurvey(Integer idEncuesta) {
        Encuesta encuesta = em.find(Encuesta.class, idEncuesta);
        return em.createNamedQuery("Ejecucionencuesta.findBySurvey")
                .setParameter("idEncuesta", encuesta)
                .getResultList();
    }

    @Override
    public Ejecucionencuesta find(Ejecucionencuesta ejecucionEncuesta) {
        return em.find(Ejecucionencuesta.class, ejecucionEncuesta.getId());
    }

    @Override
    public void insertEjecucionEncuesta(Ejecucionencuesta ejecucionencuesta) {
        em.persist(ejecucionencuesta);
        em.flush();
    }

    @Override
    public void updateEjecucionEncuesta(Ejecucionencuesta ejecucionencuesta) {
        em.merge(ejecucionencuesta);
    }

    @Override
    public void deleteEjecucionEncuesta(Ejecucionencuesta ejecucionencuesta) {
        em.remove(em.merge(ejecucionencuesta));
    }
}
