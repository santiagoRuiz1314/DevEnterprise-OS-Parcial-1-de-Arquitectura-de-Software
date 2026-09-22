package deventerprise.personal;

import deventerprise.proyectos.Proyecto;

import java.util.List;

/** Componente del Decorator: lo implementan EmpleadoBase y los decoradores de responsabilidad. */
public interface Empleado {
    String getNombre();
    double getSalario();
    List<String> getPermisos();
    String getDescripcion();
    EstadoEmpleado getEstado();
    void setEstado(EstadoEmpleado e);
    boolean puedeRecibirAsignacion();
    void asignarAProyecto(Proyecto p);
    void liberar();
    void iniciarLicencia();
}
