package deventerprise.calidad;

public class PruebasIntegracion extends FasePrueba {
    public PruebasIntegracion() {
        super("PruebasIntegracion");
    }

    @Override
    protected boolean ejecutarFase(FabricaPruebas f) {
        PaqueteIntegracion paquete = f.crearPaqueteIntegracion();
        System.out.println("  [PruebasIntegracion] Ejecutando " + paquete.getDescripcion());
        return paquete.ejecutar();
    }
}
