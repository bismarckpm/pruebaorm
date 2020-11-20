package impl;

import interfaces.SolicitudDao;
import ucab.dsw.entidades.Solicitud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class SolicitudDaoImpl implements SolicitudDao {
    @PersistenceContext(unitName = "TallerPU")
    EntityManager em;

    @Override
    public List<Solicitud> findAll() {
        return em.createNamedQuery("Solicitud.findAll").getResultList();
    }

    @Override
    public Solicitud find(Solicitud solicitud) {
        return em.find(Solicitud.class, solicitud.getId());
    }

    @Override
    public void insertSolicitud(Solicitud solicitud) {
        em.persist(solicitud);
        em.flush();
    }

    @Override
    public void updateSolicitud(Solicitud solicitud) {
        em.merge(solicitud);
    }

    @Override
    public void deleteSolicitud(Solicitud solicitud) {
        em.remove(em.merge(solicitud));
    }
}
