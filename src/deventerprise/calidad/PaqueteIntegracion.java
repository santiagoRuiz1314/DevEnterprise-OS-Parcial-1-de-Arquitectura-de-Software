package deventerprise.calidad;

/** Abstract Factory: producto abstracto de la familia de pruebas. */
public interface PaqueteIntegracion {
    boolean ejecutar();
    String getDescripcion();
}
