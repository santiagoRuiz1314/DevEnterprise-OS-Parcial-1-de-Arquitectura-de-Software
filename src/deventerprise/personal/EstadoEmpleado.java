package deventerprise.personal;

import deventerprise.proyectos.Proyecto;

/** State: cada estado decide si acepta la operación y hacia qué estado transiciona. */
public interface EstadoEmpleado {
    String getNombre();
    boolean puedeRecibirAsignacion();
    void asignar(EmpleadoBase e, Proyecto p);
    void liberar(EmpleadoBase e);
    void iniciarLicencia(EmpleadoBase e);
}
