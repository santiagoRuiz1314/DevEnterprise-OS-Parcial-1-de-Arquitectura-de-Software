package deventerprise.calidad;

public class PaqueteIntegracionWeb implements PaqueteIntegracion {
    @Override
    public boolean ejecutar() {
        System.out.println("    [PaqueteIntegracionWeb] Cargando entorno de pruebas... (integración simulada)");
        System.out.println("    [PaqueteIntegracionWeb] Ejecutando casos... 100% completado");
        System.out.println("    [PaqueteIntegracionWeb] Todas las pruebas pasaron");
        return true;
    }

    @Override
    public String getDescripcion() { return "pruebas de integración Web (API REST + navegador)"; }
}
