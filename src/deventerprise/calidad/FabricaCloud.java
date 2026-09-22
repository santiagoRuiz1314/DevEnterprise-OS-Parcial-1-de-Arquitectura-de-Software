package deventerprise.calidad;

/** Abstract Factory concreta: familia de pruebas Cloud. */
public class FabricaCloud implements FabricaPruebas {
    @Override
    public String getTecnologia() { return "Cloud"; }

    @Override
    public PaqueteUnitario crearPaqueteUnitario() {
        System.out.println("  [FabricaCloud] crea PaqueteUnitarioCloud");
        return new PaqueteUnitarioCloud();
    }

    @Override
    public PaqueteIntegracion crearPaqueteIntegracion() {
        System.out.println("  [FabricaCloud] crea PaqueteIntegracionCloud");
        return new PaqueteIntegracionCloud();
    }

    @Override
    public PaqueteSeguridad crearPaqueteSeguridad() {
        System.out.println("  [FabricaCloud] crea PaqueteSeguridadCloud");
        return new PaqueteSeguridadCloud();
    }
}
