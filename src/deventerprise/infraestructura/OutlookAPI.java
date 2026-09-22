package deventerprise.infraestructura;

import java.util.ArrayList;
import java.util.List;

/** Adaptee: API externa simulada de Outlook. */
public class OutlookAPI {
    private final List<String> citas = new ArrayList<>();

    public void scheduleMeeting(String subject, String when) {
        System.out.println("    [OutlookAPI] Conectando con Microsoft Outlook... cargando (servicio simulado)");
        citas.add(subject + " @ " + when);
        System.out.println("    [OutlookAPI] scheduleMeeting(subject=\"" + subject + "\", when=\"" + when + "\")");
    }

    public List<String> fetchAppointments() {
        System.out.println("    [OutlookAPI] fetchAppointments() -> cargando citas (servicio simulado)");
        return new ArrayList<>(citas);
    }
}
