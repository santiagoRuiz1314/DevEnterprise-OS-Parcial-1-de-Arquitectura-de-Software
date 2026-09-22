package deventerprise.calidad;

/** Abstract Factory: producto abstracto de la familia de pruebas. */
public interface PaqueteUnitario {
    boolean ejecutar();
    String getDescripcion();
}
