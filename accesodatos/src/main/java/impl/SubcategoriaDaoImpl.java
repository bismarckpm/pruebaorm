package impl;

import interfaces.SubcategoriaDao;
import ucab.dsw.entidades.Subcategoria;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class SubcategoriaDaoImpl implements SubcategoriaDao {
    @PersistenceContext(unitName = "TallerPU")
    EntityManager em;

    @Override
    public List<Subcategoria> findAll() {
        return em.createNamedQuery("Subcategoria.findAll", Subcategoria.class).getResultList();
    }

    @Override
    public Subcategoria find(Subcategoria subcategoria) {
        return em.find(Subcategoria.class, subcategoria.getId());
    }

    @Override
    public void insertSubcategoria(Subcategoria subcategoria) {
        em.persist(subcategoria);
        em.flush();
    }

    @Override
    public void updateSubcategoria(Subcategoria subcategoria) {
        em.merge(subcategoria);
    }

    @Override
    public void deleteSubcategoria(Subcategoria subcategoria) {
        em.remove(em.merge(subcategoria));
    }
}
