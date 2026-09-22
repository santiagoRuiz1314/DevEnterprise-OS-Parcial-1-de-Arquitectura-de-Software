package deventerprise.proyectos;

/** Strategy: metodología de estimación intercambiable en ejecución. */
public interface EstrategiaEstimacion {
    String getNombre();
    double calcularCosto(SubTarea s);
    double calcularTiempo(SubTarea s);
}
