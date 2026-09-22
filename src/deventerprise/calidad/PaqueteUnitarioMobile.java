package deventerprise.calidad;

public class PaqueteUnitarioMobile implements PaqueteUnitario {
    @Override
    public boolean ejecutar() {
        System.out.println("    [PaqueteUnitarioMobile] Cargando entorno de pruebas... (integración simulada)");
        System.out.println("    [PaqueteUnitarioMobile] Ejecutando casos... 100% completado");
        System.out.println("    [PaqueteUnitarioMobile] Todas las pruebas pasaron");
        return true;
    }

    @Override
    public String getDescripcion() { return "pruebas unitarias Mobile (JUnit/XCTest)"; }
}
