package interfaces;

import ucab.dsw.entidades.Encuesta;

import java.util.List;

public interface EncuestaDao {
    public List<Encuesta> findAll();
    public Encuesta find(Encuesta encuesta);
    public void insertEncuesta(Encuesta encuesta);
    public void updateEncuesta(Encuesta encuesta);
    public void deleteEncuesta(Encuesta encuesta);
}
