package deventerprise.proyectos;

import java.util.ArrayList;
import java.util.List;

/** Composite (agrupa subtareas) y sujeto del Observer: avisa al pasar a COMPLETADO. */
public class Tarea extends ComponenteCompuesto {
    private EstadoTarea estado = EstadoTarea.PENDIENTE;
    private List<ObservadorTarea> observadores = new ArrayList<>();

    public Tarea(String nombre) {
        super(nombre);
        System.out.println("[Tarea] Creada '" + nombre + "' en estado " + estado);
    }

    public void suscribir(ObservadorTarea o) {
        observadores.add(o);
        System.out.println("[Tarea] '" + nombre + "' suscribe observador " + o.getClass().getSimpleName());
    }

    public void desuscribir(ObservadorTarea o) {
        observadores.remove(o);
        System.out.println("[Tarea] '" + nombre + "' desuscribe observador " + o.getClass().getSimpleName());
    }

    public void cambiarEstado(EstadoTarea nuevo) {
        System.out.println("[Tarea] '" + nombre + "': " + estado + " -> " + nuevo);
        this.estado = nuevo;
        if (nuevo == EstadoTarea.COMPLETADO) {
            notificar();
        }
    }

    public EstadoTarea getEstado() { return estado; }

    private void notificar() {
        System.out.println("[Tarea] Notificando a " + observadores.size() + " observador(es)...");
        for (ObservadorTarea o : observadores) {
            o.actualizar(this);
        }
    }
}
