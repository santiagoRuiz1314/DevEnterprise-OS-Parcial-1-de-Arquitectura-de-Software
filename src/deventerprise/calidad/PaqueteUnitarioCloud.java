package deventerprise.calidad;

public class PaqueteUnitarioCloud implements PaqueteUnitario {
    @Override
    public boolean ejecutar() {
        System.out.println("    [PaqueteUnitarioCloud] Cargando entorno de pruebas... (integración simulada)");
        System.out.println("    [PaqueteUnitarioCloud] Ejecutando casos... 100% completado");
        System.out.println("    [PaqueteUnitarioCloud] Todas las pruebas pasaron");
        return true;
    }

    @Override
    public String getDescripcion() { return "pruebas unitarias Cloud (funciones serverless)"; }
}
