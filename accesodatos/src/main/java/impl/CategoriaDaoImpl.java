package impl;

import interfaces.CategoriaDao;
import ucab.dsw.entidades.Categoria;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CategoriaDaoImpl implements CategoriaDao {
    @PersistenceContext(unitName = "TallerPU")
    EntityManager em;

    @Override
    public List<Categoria> findAll() {
        return em.createNamedQuery("Categoria.findAll", Categoria.class).getResultList();
    }

    @Override
    public Categoria find(Categoria categoria) {
        return null;
    }

    @Override
    public void insertCategoria(Categoria categoria) {

    }

    @Override
    public void updateCategoria(Categoria categoria) {

    }

    @Override
    public void deleteCategoria(Categoria categoria) {

    }
}
