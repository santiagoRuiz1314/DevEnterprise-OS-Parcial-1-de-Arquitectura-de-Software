package deventerprise.personal;

import deventerprise.proyectos.Proyecto;

public class Disponible implements EstadoEmpleado {
    @Override
    public String getNombre() { return "Disponible"; }

    @Override
    public boolean puedeRecibirAsignacion() { return true; }

    @Override
    public void asignar(EmpleadoBase e, Proyecto p) {
        System.out.println("  [Disponible] " + e.getNombre() + " asignado al proyecto '" + p.getNombre() + "'");
        e.setEstado(new AsignadoProyecto());
    }

    @Override
    public void liberar(EmpleadoBase e) {
        System.out.println("  [Disponible] " + e.getNombre() + " ya está disponible, no hay nada que liberar");
    }

    @Override
    public void iniciarLicencia(EmpleadoBase e) {
        System.out.println("  [Disponible] " + e.getNombre() + " inicia licencia");
        e.setEstado(new EnLicencia());
    }
}
