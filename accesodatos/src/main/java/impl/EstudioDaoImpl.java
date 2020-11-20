package impl;

import interfaces.EstudioDao;
import ucab.dsw.entidades.Estudio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EstudioDaoImpl implements EstudioDao {
    @PersistenceContext(unitName = "TallerPU")
    EntityManager em;

    @Override
    public List<Estudio> findAll() {
        return em.createNamedQuery("Estudio.findAll").getResultList();
    }

    @Override
    public Estudio find(Estudio estudio) {
        return em.find(Estudio.class, estudio.getId());
    }

    @Override
    public void insertEstudio(Estudio estudio) {
        em.persist(estudio);
        em.flush();
    }

    @Override
    public void updateEstudio(Estudio estudio) {
        em.merge(estudio);
    }

    @Override
    public void deleteEstudio(Estudio estudio) {
        em.remove(em.merge(estudio));
    }
}
