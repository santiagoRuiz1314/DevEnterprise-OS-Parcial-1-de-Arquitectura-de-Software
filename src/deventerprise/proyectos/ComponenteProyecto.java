package deventerprise.proyectos;

/** Composite: componente común para hojas (SubTarea) y compuestos (Proyecto, Fase, Tarea). */
public interface ComponenteProyecto {
    String getNombre();
    double calcularCosto(EstrategiaEstimacion e);
    double calcularTiempo(EstrategiaEstimacion e);
    void mostrar(int nivel);
}
