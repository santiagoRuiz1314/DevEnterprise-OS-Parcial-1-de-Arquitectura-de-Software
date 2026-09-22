package deventerprise.infraestructura;

/** Singleton: una sola configuración global y una sola conexión al calendario. */
public class ConfiguracionSistema {
    private static ConfiguracionSistema instancia;
    private String nombreEmpresa;
    private String zonaHoraria;
    private ServicioCalendario calendario;

    private ConfiguracionSistema() {
        this.nombreEmpresa = "DevEnterprise S.A.S.";
        this.zonaHoraria = "America/Bogota";
        System.out.println("[ConfiguracionSistema] Instancia única creada (" + nombreEmpresa + ", " + zonaHoraria + ")");
    }

    public static ConfiguracionSistema getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionSistema();
        }
        return instancia;
    }

    public String getNombreEmpresa() { return nombreEmpresa; }

    public String getZonaHoraria() { return zonaHoraria; }

    public ServicioCalendario getCalendario() { return calendario; }

    public void setCalendario(ServicioCalendario s) {
        System.out.println("[ConfiguracionSistema] Calendario configurado: " + s.getProveedor());
        this.calendario = s;
    }
}
