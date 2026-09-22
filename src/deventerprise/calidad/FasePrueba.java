package deventerprise.calidad;

/** Chain of Responsibility: cada fase valida y, si pasa, cede el control a la siguiente. */
public abstract class FasePrueba {
    protected String nombre;
    protected FasePrueba siguiente;
    private boolean debeFallar;

    public FasePrueba(String nombre) {
        this.nombre = nombre;
    }

    /** Devuelve la fase recibida para encadenar: a.setSiguiente(b).setSiguiente(c). */
    public FasePrueba setSiguiente(FasePrueba f) {
        this.siguiente = f;
        System.out.println("  [FasePrueba] " + nombre + " -> " + f.nombre);
        return f;
    }

    public void setDebeFallar(boolean b) {
        this.debeFallar = b;
    }

    public boolean ejecutar(FabricaPruebas f) {
        System.out.println("[" + nombre + "] Iniciando fase (" + f.getTecnologia() + ")");
        boolean ok = !debeFallar && ejecutarFase(f);
        if (!ok) {
            System.out.println("[" + nombre + "] FALLÓ. Pipeline detenido.");
            return false;
        }
        System.out.println("[" + nombre + "] OK");
        if (siguiente == null) {
            return true;
        }
        return siguiente.ejecutar(f);
    }

    protected abstract boolean ejecutarFase(FabricaPruebas f);
}
