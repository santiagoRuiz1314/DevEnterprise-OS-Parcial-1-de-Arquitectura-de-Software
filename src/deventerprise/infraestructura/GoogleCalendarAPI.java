package deventerprise.infraestructura;

import java.util.ArrayList;
import java.util.List;

/** Adaptee: API externa simulada de Google Calendar. */
public class GoogleCalendarAPI {
    private final List<String> eventos = new ArrayList<>();

    public void insertEvent(String summary, String start) {
        System.out.println("    [GoogleCalendarAPI] Conectando con Google Calendar... cargando (servicio simulado)");
        eventos.add(summary + " @ " + start);
        System.out.println("    [GoogleCalendarAPI] insertEvent(summary=\"" + summary + "\", start=\"" + start + "\")");
    }

    public List<String> getEventList() {
        System.out.println("    [GoogleCalendarAPI] getEventList() -> cargando eventos (servicio simulado)");
        return new ArrayList<>(eventos);
    }
}
