package deventerprise.infraestructura;

import java.util.List;

public class OutlookAdapter implements ServicioCalendario {
    private OutlookAPI api;

    public OutlookAdapter(OutlookAPI api) {
        this.api = api;
    }

    @Override
    public void crearEvento(String titulo, String fecha) {
        System.out.println("  [OutlookAdapter] crearEvento -> scheduleMeeting");
        api.scheduleMeeting(titulo, fecha);
    }

    @Override
    public List<String> listarEventos() {
        System.out.println("  [OutlookAdapter] listarEventos -> fetchAppointments");
        return api.fetchAppointments();
    }

    @Override
    public String getProveedor() { return "Outlook"; }
}
