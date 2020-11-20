package impl;

import interfaces.OpcionDao;
import ucab.dsw.entidades.Opcion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Stateless
public class OpcionDaoImpl implements OpcionDao {
    @PersistenceContext(unitName = "TallerPU")
    EntityManager em;

    @Override
    public List<Opcion> findAll() {
        return em.createNamedQuery("Opcion.findAll").getResultList();
    }

    @Override
    public Opcion find(Opcion opcion) {
        return em.find(Opcion.class, opcion.getId());
    }

    @Override
    public void insertOpcion(Opcion opcion) {
        em.persist(opcion);
        em.flush();
    }

    @Override
    public void updateOpcion(Opcion opcion) {
        em.merge(opcion);
    }

    @Override
    public void deleteOpcion(Opcion opcion) {
        em.remove(em.merge(opcion));
    }
}
