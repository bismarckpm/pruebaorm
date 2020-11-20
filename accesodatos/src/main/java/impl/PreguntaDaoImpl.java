package impl;

import interfaces.PreguntaDao;
import ucab.dsw.entidades.Pregunta;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PreguntaDaoImpl implements PreguntaDao {
    @PersistenceContext(unitName = "TallerPU")
    EntityManager em;

    @Override
    public List<Pregunta> findAll() {
        return em.createNamedQuery("Pregunta.findAll").getResultList();
    }

    @Override
    public Pregunta find(Pregunta pregunta) {
        return em.find(Pregunta.class, pregunta.getId());
    }

    @Override
    public void insertPregunta(Pregunta pregunta) {
        em.persist(pregunta);
        em.flush();
    }

    @Override
    public void updatePregunta(Pregunta pregunta) {
        em.merge(pregunta);
    }

    @Override
    public void deletePregunta(Pregunta pregunta) {
        em.remove(em.merge(pregunta));
    }
}
