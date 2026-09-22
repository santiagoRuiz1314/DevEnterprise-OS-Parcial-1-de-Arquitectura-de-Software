package deventerprise.calidad;

/** Abstract Factory concreta: familia de pruebas Mobile. */
public class FabricaMobile implements FabricaPruebas {
    @Override
    public String getTecnologia() { return "Mobile"; }

    @Override
    public PaqueteUnitario crearPaqueteUnitario() {
        System.out.println("  [FabricaMobile] crea PaqueteUnitarioMobile");
        return new PaqueteUnitarioMobile();
    }

    @Override
    public PaqueteIntegracion crearPaqueteIntegracion() {
        System.out.println("  [FabricaMobile] crea PaqueteIntegracionMobile");
        return new PaqueteIntegracionMobile();
    }

    @Override
    public PaqueteSeguridad crearPaqueteSeguridad() {
        System.out.println("  [FabricaMobile] crea PaqueteSeguridadMobile");
        return new PaqueteSeguridadMobile();
    }
}
