package deventerprise.calidad;

public class PaqueteUnitarioWeb implements PaqueteUnitario {
    @Override
    public boolean ejecutar() {
        System.out.println("    [PaqueteUnitarioWeb] Cargando entorno de pruebas... (integración simulada)");
        System.out.println("    [PaqueteUnitarioWeb] Ejecutando casos... 100% completado");
        System.out.println("    [PaqueteUnitarioWeb] Todas las pruebas pasaron");
        return true;
    }

    @Override
    public String getDescripcion() { return "pruebas unitarias Web (Jest sobre componentes)"; }
}
