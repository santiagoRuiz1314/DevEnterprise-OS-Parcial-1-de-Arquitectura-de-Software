package deventerprise.calidad;

/** Abstract Factory concreta: familia de pruebas Web. */
public class FabricaWeb implements FabricaPruebas {
    @Override
    public String getTecnologia() { return "Web"; }

    @Override
    public PaqueteUnitario crearPaqueteUnitario() {
        System.out.println("  [FabricaWeb] crea PaqueteUnitarioWeb");
        return new PaqueteUnitarioWeb();
    }

    @Override
    public PaqueteIntegracion crearPaqueteIntegracion() {
        System.out.println("  [FabricaWeb] crea PaqueteIntegracionWeb");
        return new PaqueteIntegracionWeb();
    }

    @Override
    public PaqueteSeguridad crearPaqueteSeguridad() {
        System.out.println("  [FabricaWeb] crea PaqueteSeguridadWeb");
        return new PaqueteSeguridadWeb();
    }
}
