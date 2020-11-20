package interfaces;

import ucab.dsw.entidades.Pregunta;

import java.util.List;

public interface PreguntaDao {
    public List<Pregunta> findAll();
    public Pregunta find(Pregunta pregunta);
    public void insertPregunta(Pregunta pregunta);
    public void updatePregunta(Pregunta pregunta);
    public void deletePregunta(Pregunta pregunta);
}
