package deventerprise.bitacora;

/** Colega del Mediator: solo notifica al equipo. */
public class NotificadorDesarrolladores {
    private MediadorProyecto mediador;

    public void setMediador(MediadorProyecto m) {
        this.mediador = m;
    }

    public void notificarEquipo(String mensaje) {
        System.out.println("  [NotificadorDesarrolladores] Mensaje al equipo de desarrollo: " + mensaje);
    }
}
