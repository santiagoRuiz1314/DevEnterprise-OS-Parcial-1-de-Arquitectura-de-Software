package deventerprise.bitacora;

/** Command: cambio de requerimiento ejecutable y reversible. */
public interface Comando {
    void ejecutar();
    void deshacer();
    String getDescripcion();
}
