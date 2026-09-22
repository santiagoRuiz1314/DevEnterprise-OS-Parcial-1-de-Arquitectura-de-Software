package deventerprise.calidad;

/** Abstract Factory: crea la familia completa de paquetes de prueba de una tecnología. */
public interface FabricaPruebas {
    String getTecnologia();
    PaqueteUnitario crearPaqueteUnitario();
    PaqueteIntegracion crearPaqueteIntegracion();
    PaqueteSeguridad crearPaqueteSeguridad();
}
