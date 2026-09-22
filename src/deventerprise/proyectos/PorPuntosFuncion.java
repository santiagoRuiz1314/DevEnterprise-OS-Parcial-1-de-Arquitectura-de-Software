package deventerprise.proyectos;

/** Strategy concreta: costo y tiempo derivados de los puntos de función. */
public class PorPuntosFuncion implements EstrategiaEstimacion {
    private double costoPorPunto;
    private double horasPorPunto;

    public PorPuntosFuncion(double costo, double horas) {
        this.costoPorPunto = costo;
        this.horasPorPunto = horas;
    }

    @Override
    public String getNombre() { return "PorPuntosFuncion($" + costoPorPunto + "/PF, " + horasPorPunto + " h/PF)"; }

    @Override
    public double calcularCosto(SubTarea s) {
        double costo = s.getPuntosFuncion() * costoPorPunto;
        System.out.println("    [PorPuntosFuncion] costo '" + s.getNombre() + "' = " + s.getPuntosFuncion() + " PF x " + costoPorPunto + " = " + costo);
        return costo;
    }

    @Override
    public double calcularTiempo(SubTarea s) {
        double tiempo = s.getPuntosFuncion() * horasPorPunto;
        System.out.println("    [PorPuntosFuncion] tiempo '" + s.getNombre() + "' = " + s.getPuntosFuncion() + " PF x " + horasPorPunto + " = " + tiempo + " h");
        return tiempo;
    }
}
