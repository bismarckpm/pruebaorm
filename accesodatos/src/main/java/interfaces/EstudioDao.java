package interfaces;

import ucab.dsw.entidades.Estudio;

import java.util.List;

public interface EstudioDao {
    public List<Estudio> findAll();
    public Estudio find (Estudio estudio);
    public void insertEstudio(Estudio estudio);
    public void updateEstudio(Estudio estudio);
    public void deleteEstudio(Estudio estudio);
}
