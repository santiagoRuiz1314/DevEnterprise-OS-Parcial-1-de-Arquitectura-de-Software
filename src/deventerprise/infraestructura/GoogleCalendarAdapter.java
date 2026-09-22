package deventerprise.infraestructura;

import java.util.List;

public class GoogleCalendarAdapter implements ServicioCalendario {
    private GoogleCalendarAPI api;

    public GoogleCalendarAdapter(GoogleCalendarAPI api) {
        this.api = api;
    }

    @Override
    public void crearEvento(String titulo, String fecha) {
        System.out.println("  [GoogleCalendarAdapter] crearEvento -> insertEvent");
        api.insertEvent(titulo, fecha);
    }

    @Override
    public List<String> listarEventos() {
        System.out.println("  [GoogleCalendarAdapter] listarEventos -> getEventList");
        return api.getEventList();
    }

    @Override
    public String getProveedor() { return "Google Calendar"; }
}
