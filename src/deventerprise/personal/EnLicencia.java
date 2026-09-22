package deventerprise.personal;

import deventerprise.proyectos.Proyecto;

public class EnLicencia implements EstadoEmpleado {
    @Override
    public String getNombre() { return "EnLicencia"; }

    @Override
    public boolean puedeRecibirAsignacion() { return false; }

    @Override
    public void asignar(EmpleadoBase e, Proyecto p) {
        System.out.println("  [EnLicencia] RECHAZADO: " + e.getNombre() + " está en licencia, no puede tomar '"
                + p.getNombre() + "'");
    }

    @Override
    public void liberar(EmpleadoBase e) {
        System.out.println("  [EnLicencia] " + e.getNombre() + " termina la licencia");
        e.setEstado(new Disponible());
    }

    @Override
    public void iniciarLicencia(EmpleadoBase e) {
        System.out.println("  [EnLicencia] " + e.getNombre() + " ya se encuentra en licencia");
    }
}
