package interfaces;

import ucab.dsw.entidades.Ejecucionencuesta;

import java.util.List;

public interface EjecucionEncuestaDao {
    public List<Ejecucionencuesta> findAll();
    public Ejecucionencuesta find (Ejecucionencuesta ejecucionEncuesta);
    public void insertEjecucionEncuesta(Ejecucionencuesta ejecucionencuesta);
    public void updateEjecucionEncuesta(Ejecucionencuesta ejecucionencuesta);
    public void deleteEjecucionEncuesta(Ejecucionencuesta ejecucionencuesta);
}
