package interfaces;

import ucab.dsw.entidades.Subcategoria;

import java.util.List;

public interface SubcategoriaDao {
    public List<Subcategoria> findAll();
    public Subcategoria find(Subcategoria subcategoria);
    public void insertSubcategoria(Subcategoria subcategoria);
    public void updateSubcategoria(Subcategoria subcategoria);
    public void deleteSubcategoria(Subcategoria subcategoria);
}
