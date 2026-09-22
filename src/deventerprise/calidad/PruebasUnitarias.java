package deventerprise.calidad;

public class PruebasUnitarias extends FasePrueba {
    public PruebasUnitarias() {
        super("PruebasUnitarias");
    }

    @Override
    protected boolean ejecutarFase(FabricaPruebas f) {
        PaqueteUnitario paquete = f.crearPaqueteUnitario();
        System.out.println("  [PruebasUnitarias] Ejecutando " + paquete.getDescripcion());
        return paquete.ejecutar();
    }
}
