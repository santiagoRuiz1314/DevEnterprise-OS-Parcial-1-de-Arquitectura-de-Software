package deventerprise.personal;

import deventerprise.proyectos.Proyecto;

public class AsignadoProyecto implements EstadoEmpleado {
    @Override
    public String getNombre() { return "AsignadoProyecto"; }

    @Override
    public boolean puedeRecibirAsignacion() { return false; }

    @Override
    public void asignar(EmpleadoBase e, Proyecto p) {
        System.out.println("  [AsignadoProyecto] RECHAZADO: " + e.getNombre()
                + " ya está asignado, no puede tomar '" + p.getNombre() + "'");
    }

    @Override
    public void liberar(EmpleadoBase e) {
        System.out.println("  [AsignadoProyecto] " + e.getNombre() + " liberado del proyecto");
        e.setEstado(new Disponible());
    }

    @Override
    public void iniciarLicencia(EmpleadoBase e) {
        System.out.println("  [AsignadoProyecto] " + e.getNombre() + " deja el proyecto e inicia licencia");
        e.setEstado(new EnLicencia());
    }
}
