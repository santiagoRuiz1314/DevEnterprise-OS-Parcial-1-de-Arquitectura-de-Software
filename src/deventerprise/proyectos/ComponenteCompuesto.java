package deventerprise.proyectos;

import java.util.ArrayList;
import java.util.List;

/** Composite (compuesto): suma el costo y el tiempo de sus hijos. */
public abstract class ComponenteCompuesto implements ComponenteProyecto {
    protected String nombre;
    protected List<ComponenteProyecto> hijos = new ArrayList<>();

    public ComponenteCompuesto(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ComponenteProyecto c) {
        hijos.add(c);
        System.out.println("[" + getClass().getSimpleName() + "] '" + nombre + "' agrega hijo '" + c.getNombre() + "'");
    }

    public void quitar(ComponenteProyecto c) {
        hijos.remove(c);
        System.out.println("[" + getClass().getSimpleName() + "] '" + nombre + "' quita hijo '" + c.getNombre() + "'");
    }

    public List<ComponenteProyecto> getHijos() { return hijos; }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public double calcularCosto(EstrategiaEstimacion e) {
        double total = 0;
        for (ComponenteProyecto hijo : hijos) {
            total += hijo.calcularCosto(e);
        }
        return total;
    }

    @Override
    public double calcularTiempo(EstrategiaEstimacion e) {
        double total = 0;
        for (ComponenteProyecto hijo : hijos) {
            total += hijo.calcularTiempo(e);
        }
        return total;
    }

    @Override
    public void mostrar(int nivel) {
        System.out.println("  ".repeat(nivel) + "+ " + getClass().getSimpleName() + ": " + nombre);
        for (ComponenteProyecto hijo : hijos) {
            hijo.mostrar(nivel + 1);
        }
    }
}
