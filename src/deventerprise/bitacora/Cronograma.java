package deventerprise.bitacora;

import java.util.ArrayList;
import java.util.List;

/** Colega del Mediator. */
public class Cronograma {
    private MediadorProyecto mediador;
    private List<String> hitos = new ArrayList<>(List.of("Entrega MVP: 2026-10-30", "Salida a producción: 2026-12-15"));

    public void setMediador(MediadorProyecto m) {
        this.mediador = m;
    }

    public void ajustarFechas(String motivo) {
        System.out.println("  [Cronograma] Ajustando fechas por: " + motivo);
        hitos.add("Revisión de alcance: 2026-11-10");
        mediador.notificar("Cronograma", "FECHAS_AJUSTADAS");
    }

    public List<String> getHitos() { return hitos; }
}
