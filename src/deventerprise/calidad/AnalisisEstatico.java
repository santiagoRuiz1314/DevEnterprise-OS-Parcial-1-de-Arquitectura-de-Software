package deventerprise.calidad;

public class AnalisisEstatico extends FasePrueba {
    public AnalisisEstatico() {
        super("AnalisisEstatico");
    }

    @Override
    protected boolean ejecutarFase(FabricaPruebas f) {
        System.out.println("  [AnalisisEstatico] Revisando estilo, complejidad y code smells del código " + f.getTecnologia());
        return true;
    }
}
