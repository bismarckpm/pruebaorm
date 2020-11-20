package interfaces;

import ucab.dsw.entidades.Solicitud;

import java.util.List;

public interface SolicitudDao {
    public List<Solicitud> findAll();
    public Solicitud find(Solicitud solicitud);
    public void insertSolicitud(Solicitud solicitud);
    public void updateSolicitud(Solicitud solicitud);
    public void deleteSolicitud(Solicitud solicitud);
}
