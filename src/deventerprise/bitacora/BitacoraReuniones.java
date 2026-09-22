package deventerprise.bitacora;

import deventerprise.infraestructura.ConfiguracionSistema;
import deventerprise.infraestructura.ServicioCalendario;

import java.util.ArrayList;
import java.util.List;

/** Colega del Mediator: guarda las actas y agenda reuniones en el calendario configurado. */
public class BitacoraReuniones {
    private List<ActaReunion> actas = new ArrayList<>();
    private MediadorProyecto mediador;

    public void setMediador(MediadorProyecto m) {
        this.mediador = m;
    }

    public void registrarActa(ActaReunion a) {
        actas.add(a);
        System.out.println("[BitacoraReuniones] Acta registrada: " + a);
        mediador.notificar("BitacoraReuniones", (a.isFirmada() ? "ACTA_FIRMADA:" : "ACTA_ANULADA:") + a.getAsunto());
    }

    public void agendarReunion(String titulo, String fecha) {
        ServicioCalendario calendario = ConfiguracionSistema.getInstancia().getCalendario();
        System.out.println("[BitacoraReuniones] Agendando '" + titulo + "' en " + calendario.getProveedor());
        calendario.crearEvento(titulo, fecha);
        mediador.notificar("BitacoraReuniones", "REUNION_AGENDADA:" + titulo + " (" + fecha + ")");
    }

    public List<ActaReunion> getActas() { return actas; }
}
