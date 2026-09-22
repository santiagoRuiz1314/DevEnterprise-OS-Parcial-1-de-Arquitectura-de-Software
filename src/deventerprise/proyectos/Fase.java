package deventerprise.proyectos;

/** Composite: nivel intermedio del árbol (agrupa tareas). */
public class Fase extends ComponenteCompuesto {
    public Fase(String nombre) {
        super(nombre);
        System.out.println("[Fase] Creada '" + nombre + "'");
    }
}
