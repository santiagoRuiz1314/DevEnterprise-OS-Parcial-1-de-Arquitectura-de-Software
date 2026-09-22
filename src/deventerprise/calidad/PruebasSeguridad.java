package deventerprise.calidad;

public class PruebasSeguridad extends FasePrueba {
    public PruebasSeguridad() {
        super("PruebasSeguridad");
    }

    @Override
    protected boolean ejecutarFase(FabricaPruebas f) {
        PaqueteSeguridad paquete = f.crearPaqueteSeguridad();
        System.out.println("  [PruebasSeguridad] Ejecutando " + paquete.getDescripcion());
        return paquete.ejecutar();
    }
}
