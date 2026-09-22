package deventerprise.proyectos;

import java.util.ArrayList;
import java.util.List;

/** Raíz del árbol Composite, contexto del Strategy y receptor de los comandos (Command). */
public class Proyecto extends ComponenteCompuesto {
    private EstrategiaEstimacion estrategia;
    private List<String> requerimientos = new ArrayList<>();

    public Proyecto(String nombre, EstrategiaEstimacion e) {
        super(nombre);
        this.estrategia = e;
        System.out.println("[Proyecto] Creado '" + nombre + "' con estrategia " + e.getNombre());
    }

    public void setEstrategia(EstrategiaEstimacion e) {
        System.out.println("[Proyecto] Estrategia cambiada: " + estrategia.getNombre() + " -> " + e.getNombre());
        this.estrategia = e;
    }

    public EstrategiaEstimacion getEstrategia() { return estrategia; }

    public double calcularCostoTotal() {
        System.out.println("[Proyecto] Calculando costo total con " + estrategia.getNombre());
        return calcularCosto(estrategia);
    }

    public double calcularTiempoTotal() {
        System.out.println("[Proyecto] Calculando tiempo total con " + estrategia.getNombre());
        return calcularTiempo(estrategia);
    }

    public void agregarRequerimiento(String r) {
        requerimientos.add(r);
        System.out.println("[Proyecto] Requerimiento agregado: '" + r + "' -> " + requerimientos);
    }

    public void modificarRequerimiento(String ant, String nuevo) {
        int i = requerimientos.indexOf(ant);
        if (i < 0) {
            System.out.println("[Proyecto] No existe el requerimiento '" + ant + "'");
            return;
        }
        requerimientos.set(i, nuevo);
        System.out.println("[Proyecto] Requerimiento modificado: '" + ant + "' -> '" + nuevo + "' -> " + requerimientos);
    }

    public void eliminarRequerimiento(String r) {
        requerimientos.remove(r);
        System.out.println("[Proyecto] Requerimiento eliminado: '" + r + "' -> " + requerimientos);
    }

    public List<String> getRequerimientos() { return requerimientos; }
}
