package deventerprise.calidad;

/** Cliente de la cadena de fases y de la fábrica abstracta. */
public class PipelinePruebas {
    private FasePrueba primeraFase;
    private FabricaPruebas fabrica;

    public PipelinePruebas(FabricaPruebas f) {
        this.fabrica = f;
        System.out.println("[PipelinePruebas] Creado con fábrica " + f.getTecnologia());
    }

    public void setFabrica(FabricaPruebas f) {
        System.out.println("[PipelinePruebas] Fábrica cambiada a " + f.getTecnologia());
        this.fabrica = f;
    }

    public void construirCadena() {
        System.out.println("[PipelinePruebas] Construyendo cadena de fases:");
        primeraFase = new AnalisisEstatico();
        primeraFase.setSiguiente(new PruebasUnitarias())
                .setSiguiente(new PruebasIntegracion())
                .setSiguiente(new PruebasSeguridad());
    }

    public boolean ejecutar() {
        if (primeraFase == null) {
            construirCadena();
        }
        System.out.println("[PipelinePruebas] Ejecutando pipeline para " + fabrica.getTecnologia());
        boolean resultado = primeraFase.ejecutar(fabrica);
        System.out.println("[PipelinePruebas] Resultado final: " + (resultado ? "APROBADO" : "RECHAZADO"));
        return resultado;
    }
}
