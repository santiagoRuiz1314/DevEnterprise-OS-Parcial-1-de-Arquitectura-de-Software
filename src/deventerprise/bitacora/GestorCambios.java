package deventerprise.bitacora;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/** Command (invocador): ejecuta comandos y guarda el historial como pila para deshacer. */
public class GestorCambios {
    private Deque<Comando> historial = new ArrayDeque<>();

    public void ejecutarComando(Comando c) {
        System.out.println("[GestorCambios] Ejecutando: " + c.getDescripcion());
        c.ejecutar();
        historial.push(c);
    }

    public void deshacerUltimo() {
        if (historial.isEmpty()) {
            System.out.println("[GestorCambios] No hay cambios para deshacer");
            return;
        }
        Comando c = historial.pop();
        System.out.println("[GestorCambios] Deshaciendo: " + c.getDescripcion());
        c.deshacer();
    }

    public List<Comando> getHistorial() { return new ArrayList<>(historial); }
}
