package deventerprise.proyectos;

import deventerprise.personal.EmpleadoBase;

import java.util.ArrayList;
import java.util.List;

/** Empleado que además observa las tareas del proyecto. */
public class LiderProyecto extends EmpleadoBase implements ObservadorTarea {

    public LiderProyecto(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public List<String> getPermisos() {
        return new ArrayList<>(List.of("ver_proyecto", "gestionar_proyecto", "aprobar_entregables"));
    }

    @Override
    public void actualizar(Tarea t) {
        System.out.println("  [LiderProyecto] " + nombre + " recibe aviso: la tarea '" + t.getNombre()
                + "' está " + t.getEstado() + ". Revisando entregable...");
    }
}
