package deventerprise.proyectos;

/** Strategy concreta: costo = horas x tarifa. */
public class PorHoras implements EstrategiaEstimacion {
    private double tarifaHora;

    public PorHoras(double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    @Override
    public String getNombre() { return "PorHoras($" + tarifaHora + "/h)"; }

    @Override
    public double calcularCosto(SubTarea s) {
        double costo = s.getHoras() * tarifaHora;
        System.out.println("    [PorHoras] costo '" + s.getNombre() + "' = " + s.getHoras() + " h x " + tarifaHora + " = " + costo);
        return costo;
    }

    @Override
    public double calcularTiempo(SubTarea s) {
        System.out.println("    [PorHoras] tiempo '" + s.getNombre() + "' = " + s.getHoras() + " h");
        return s.getHoras();
    }
}
