package deventerprise.personal;

import deventerprise.proyectos.Proyecto;

import java.util.List;

/** Decorator abstracto: envuelve un Empleado y delega todo; las subclases alteran salario y permisos. */
public abstract class ResponsabilidadDecorator implements Empleado {
    protected Empleado envuelto;

    public ResponsabilidadDecorator(Empleado e) {
        this.envuelto = e;
        System.out.println("[" + getClass().getSimpleName() + "] Envolviendo a " + e.getDescripcion());
    }

    @Override
    public String getNombre() { return envuelto.getNombre(); }

    @Override
    public double getSalario() { return envuelto.getSalario(); }

    @Override
    public List<String> getPermisos() { return envuelto.getPermisos(); }

    @Override
    public String getDescripcion() { return envuelto.getDescripcion(); }

    @Override
    public EstadoEmpleado getEstado() { return envuelto.getEstado(); }

    @Override
    public void setEstado(EstadoEmpleado e) { envuelto.setEstado(e); }

    @Override
    public boolean puedeRecibirAsignacion() { return envuelto.puedeRecibirAsignacion(); }

    @Override
    public void asignarAProyecto(Proyecto p) {
        System.out.println("  [" + getClass().getSimpleName() + "] delega asignarAProyecto");
        envuelto.asignarAProyecto(p);
    }

    @Override
    public void liberar() {
        System.out.println("  [" + getClass().getSimpleName() + "] delega liberar");
        envuelto.liberar();
    }

    @Override
    public void iniciarLicencia() {
        System.out.println("  [" + getClass().getSimpleName() + "] delega iniciarLicencia");
        envuelto.iniciarLicencia();
    }
}
