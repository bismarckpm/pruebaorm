package interfaces;

import ucab.dsw.entidades.Opcion;

import java.util.List;

public interface OpcionDao {
    public List<Opcion> findAll();
    public Opcion find(Opcion opcion);
    public void insertOpcion(Opcion opcion);
    public void updateOpcion(Opcion opcion);
    public void deleteOpcion(Opcion opcion);
}
