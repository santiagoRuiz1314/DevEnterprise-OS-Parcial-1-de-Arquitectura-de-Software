package deventerprise.infraestructura;

import java.util.List;

/** Adapter (target): interfaz única de calendario que usa el sistema. */
public interface ServicioCalendario {
    void crearEvento(String titulo, String fecha);
    List<String> listarEventos();
    String getProveedor();
}
