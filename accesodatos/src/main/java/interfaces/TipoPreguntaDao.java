package interfaces;

import ucab.dsw.entidades.Tipopregunta;

import java.util.List;

public interface TipoPreguntaDao {
    public List<Tipopregunta> findAll();
    public Tipopregunta find(Tipopregunta tipopregunta);
    public void insertTipoPregunta(Tipopregunta tipopregunta);
    public void updateTipoPregunta(Tipopregunta tipopregunta);
    public void deleteTipoPregunta(Tipopregunta tipopregunta);
}
