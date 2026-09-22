package deventerprise.bitacora;

import java.util.ArrayList;
import java.util.List;

/** Acta de reunión: agrupa los comandos de cambio pedidos; si no se firma, se deshacen. */
public class ActaReunion {
    private String fecha;
    private String asunto;
    private boolean firmada;
    private List<Comando> cambios = new ArrayList<>();

    public ActaReunion(String fecha, String asunto) {
        this.fecha = fecha;
        this.asunto = asunto;
        System.out.println("[ActaReunion] Nueva acta '" + asunto + "' (" + fecha + ")");
    }

    public void agregarCambio(Comando c) {
        cambios.add(c);
        System.out.println("[ActaReunion] Cambio anotado: " + c.getDescripcion());
    }

    public void firmar() {
        firmada = true;
        System.out.println("[ActaReunion] Acta '" + asunto + "' FIRMADA con " + cambios.size() + " cambio(s)");
    }

    public void anular() {
        firmada = false;
        System.out.println("[ActaReunion] Acta '" + asunto + "' NO firmada: deshaciendo sus cambios");
        for (int i = cambios.size() - 1; i >= 0; i--) {
            cambios.get(i).deshacer();
        }
    }

    public boolean isFirmada() { return firmada; }

    public List<Comando> getCambios() { return cambios; }

    public String getAsunto() { return asunto; }

    @Override
    public String toString() {
        return "'" + asunto + "' " + fecha + " [" + (firmada ? "firmada" : "anulada") + ", " + cambios.size() + " cambio(s)]";
    }
}
