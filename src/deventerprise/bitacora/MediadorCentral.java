package deventerprise.bitacora;

/** Mediator concreto: decide qué colega reacciona ante cada evento. */
public class MediadorCentral implements MediadorProyecto {
    private BitacoraReuniones bitacora;
    private Cronograma cronograma;
    private NotificadorDesarrolladores notificador;

    public void registrarColegas(BitacoraReuniones b, Cronograma c, NotificadorDesarrolladores n) {
        this.bitacora = b;
        this.cronograma = c;
        this.notificador = n;
        b.setMediador(this);
        c.setMediador(this);
        n.setMediador(this);
        System.out.println("[MediadorCentral] Colegas registrados: BitacoraReuniones, Cronograma, NotificadorDesarrolladores");
    }

    @Override
    public void notificar(String emisor, String evento) {
        System.out.println("[MediadorCentral] Evento de " + emisor + ": " + evento);
        if (evento.startsWith("REUNION_AGENDADA")) {
            notificador.notificarEquipo("Nueva reunión -> " + evento.substring(evento.indexOf(':') + 1));
        } else if (evento.startsWith("ACTA_FIRMADA")) {
            cronograma.ajustarFechas("cambios aprobados en acta '" + evento.substring(evento.indexOf(':') + 1) + "'");
        } else if (evento.startsWith("ACTA_ANULADA")) {
            notificador.notificarEquipo("Acta no firmada, cambios revertidos -> "
                    + evento.substring(evento.indexOf(':') + 1) + " (actas registradas: " + bitacora.getActas().size() + ")");
        } else if (evento.startsWith("FECHAS_AJUSTADAS")) {
            notificador.notificarEquipo("Cronograma actualizado. Hitos: " + cronograma.getHitos());
        } else {
            System.out.println("[MediadorCentral] Evento sin destinatario, se ignora");
        }
    }
}
