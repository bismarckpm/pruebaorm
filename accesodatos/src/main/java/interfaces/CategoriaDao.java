package interfaces;

import ucab.dsw.entidades.Categoria;

import java.util.List;

public interface CategoriaDao {
    public List<Categoria> findAll();
    public Categoria find (Categoria categoria);
    public void insertCategoria (Categoria categoria);
    public void updateCategoria (Categoria categoria);
    public void deleteCategoria (Categoria categoria);
}
