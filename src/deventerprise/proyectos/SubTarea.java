package deventerprise.proyectos;

/** Composite (hoja): delega el cálculo a la estrategia recibida. */
public class SubTarea implements ComponenteProyecto {
    private String nombre;
    private double horas;
    private int puntosFuncion;

    public SubTarea(String nombre, double horas, int puntos) {
        this.nombre = nombre;
        this.horas = horas;
        this.puntosFuncion = puntos;
        System.out.println("[SubTarea] Creada '" + nombre + "' (" + horas + " h, " + puntos + " PF)");
    }

    @Override
    public String getNombre() { return nombre; }

    public double getHoras() { return horas; }

    public int getPuntosFuncion() { return puntosFuncion; }

    @Override
    public double calcularCosto(EstrategiaEstimacion e) {
        return e.calcularCosto(this);
    }

    @Override
    public double calcularTiempo(EstrategiaEstimacion e) {
        return e.calcularTiempo(this);
    }

    @Override
    public void mostrar(int nivel) {
        System.out.println("  ".repeat(nivel) + "- SubTarea: " + nombre
                + " [" + horas + " h, " + puntosFuncion + " PF]");
    }
}
