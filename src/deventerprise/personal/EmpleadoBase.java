package deventerprise.personal;

import deventerprise.proyectos.Proyecto;

import java.util.List;

/** Componente concreto del Decorator y contexto del State (delega las transiciones al estado). */
public abstract class EmpleadoBase implements Empleado {
    protected String nombre;
    protected double salarioBase;
    private EstadoEmpleado estado;

    public EmpleadoBase(String nombre, double salario) {
        this.nombre = nombre;
        this.salarioBase = salario;
        this.estado = new Disponible();
        System.out.println("[" + getClass().getSimpleName() + "] Creado '" + nombre + "' salario $" + salario
                + " estado " + estado.getNombre());
    }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public double getSalario() { return salarioBase; }

    /** Abstracto en el diagrama: cada tipo de empleado define sus permisos base. */
    @Override
    public abstract List<String> getPermisos();

    @Override
    public String getDescripcion() { return getClass().getSimpleName() + " " + nombre; }

    @Override
    public EstadoEmpleado getEstado() { return estado; }

    @Override
    public void setEstado(EstadoEmpleado e) {
        System.out.println("  [EmpleadoBase] " + nombre + ": " + estado.getNombre() + " -> " + e.getNombre());
        this.estado = e;
    }

    @Override
    public boolean puedeRecibirAsignacion() { return estado.puedeRecibirAsignacion(); }

    @Override
    public void asignarAProyecto(Proyecto p) { estado.asignar(this, p); }

    @Override
    public void liberar() { estado.liberar(this); }

    @Override
    public void iniciarLicencia() { estado.iniciarLicencia(this); }
}
