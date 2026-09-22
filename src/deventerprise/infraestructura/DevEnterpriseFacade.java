package deventerprise.infraestructura;

import deventerprise.bitacora.ActaReunion;
import deventerprise.bitacora.AgregarRequerimiento;
import deventerprise.bitacora.BitacoraReuniones;
import deventerprise.bitacora.Comando;
import deventerprise.bitacora.Cronograma;
import deventerprise.bitacora.EliminarRequerimiento;
import deventerprise.bitacora.GestorCambios;
import deventerprise.bitacora.MediadorCentral;
import deventerprise.bitacora.MediadorProyecto;
import deventerprise.bitacora.ModificarRequerimiento;
import deventerprise.bitacora.NotificadorDesarrolladores;
import deventerprise.calidad.FabricaCloud;
import deventerprise.calidad.FabricaMobile;
import deventerprise.calidad.FabricaPruebas;
import deventerprise.calidad.FabricaWeb;
import deventerprise.calidad.PipelinePruebas;
import deventerprise.personal.Empleado;
import deventerprise.personal.LiderTecnico;
import deventerprise.personal.Mentor;
import deventerprise.personal.SoporteFinSemana;
import deventerprise.proyectos.Cliente;
import deventerprise.proyectos.ComponenteCompuesto;
import deventerprise.proyectos.ComponenteProyecto;
import deventerprise.proyectos.EstadoTarea;
import deventerprise.proyectos.EstrategiaEstimacion;
import deventerprise.proyectos.Fase;
import deventerprise.proyectos.LiderProyecto;
import deventerprise.proyectos.PorHoras;
import deventerprise.proyectos.Proyecto;
import deventerprise.proyectos.SubTarea;
import deventerprise.proyectos.Tarea;

import java.util.ArrayList;
import java.util.List;

/** Facade: punto de entrada sencillo que coordina los cinco bloques del sistema. */
public class DevEnterpriseFacade {
    private Proyecto proyecto;
    private List<Empleado> empleados = new ArrayList<>();
    private PipelinePruebas pipeline;
    private GestorCambios gestorCambios;
    private BitacoraReuniones bitacora;
    private MediadorProyecto mediador;
    private ConfiguracionSistema config;

    public DevEnterpriseFacade() {
        System.out.println("[DevEnterpriseFacade] Inicializando subsistemas...");
        config = ConfiguracionSistema.getInstancia();
        config.setCalendario(new GoogleCalendarAdapter(new GoogleCalendarAPI()));
        gestorCambios = new GestorCambios();
        bitacora = new BitacoraReuniones();
        MediadorCentral central = new MediadorCentral();
        central.registrarColegas(bitacora, new Cronograma(), new NotificadorDesarrolladores());
        mediador = central;
        pipeline = new PipelinePruebas(new FabricaWeb());
        System.out.println("[DevEnterpriseFacade] Listo para " + config.getNombreEmpresa());
    }

    public void crearProyectoDemo() {
        System.out.println("[DevEnterpriseFacade] crearProyectoDemo()");
        proyecto = new Proyecto("Portal Bancario", new PorHoras(50));
        proyecto.agregarRequerimiento("Login con usuario y clave");
        proyecto.agregarRequerimiento("Consulta de saldos");

        Fase analisis = new Fase("Análisis");
        Tarea levantamiento = new Tarea("Levantamiento de requisitos");
        levantamiento.agregar(new SubTarea("Entrevistas con el cliente", 10, 4));
        levantamiento.agregar(new SubTarea("Documento de casos de uso", 6, 3));
        analisis.agregar(levantamiento);

        Fase desarrollo = new Fase("Desarrollo");
        Tarea backend = new Tarea("Backend");
        backend.agregar(new SubTarea("API de autenticación", 20, 8));
        backend.agregar(new SubTarea("API de saldos", 16, 6));
        Tarea frontend = new Tarea("Frontend");
        frontend.agregar(new SubTarea("Pantallas de login y saldos", 24, 10));
        desarrollo.agregar(backend);
        desarrollo.agregar(frontend);

        proyecto.agregar(analisis);
        proyecto.agregar(desarrollo);

        LiderProyecto lider = new LiderProyecto("Laura Gómez", 7000);
        Cliente cliente = new Cliente("Banco Andino", "pmo@bancoandino.com");
        for (Tarea t : List.of(levantamiento, backend, frontend)) {
            t.suscribir(lider);
            t.suscribir(cliente);
        }
        contratarEmpleado(lider);
    }

    public void cambiarEstrategia(EstrategiaEstimacion e) {
        System.out.println("[DevEnterpriseFacade] cambiarEstrategia(" + e.getNombre() + ")");
        proyecto.setEstrategia(e);
    }

    public void mostrarEstimacion() {
        System.out.println("[DevEnterpriseFacade] mostrarEstimacion()");
        proyecto.mostrar(0);
        double costo = proyecto.calcularCostoTotal();
        double tiempo = proyecto.calcularTiempoTotal();
        System.out.printf("[DevEnterpriseFacade] Estimación (%s): costo = $%.2f | tiempo = %.1f h%n",
                proyecto.getEstrategia().getNombre(), costo, tiempo);
    }

    public void completarTarea(String nombre) {
        System.out.println("[DevEnterpriseFacade] completarTarea(\"" + nombre + "\")");
        Tarea tarea = buscarTarea(proyecto, nombre);
        if (tarea == null) {
            System.out.println("[DevEnterpriseFacade] No existe la tarea '" + nombre + "'");
            return;
        }
        tarea.cambiarEstado(EstadoTarea.EN_PROGRESO);
        tarea.cambiarEstado(EstadoTarea.COMPLETADO);
    }

    public void contratarEmpleado(Empleado e) {
        empleados.add(e);
        System.out.println("[DevEnterpriseFacade] Contratado #" + (empleados.size() - 1) + ": " + resumen(e));
    }

    public void asignarResponsabilidad(int i, String tipo) {
        System.out.println("[DevEnterpriseFacade] asignarResponsabilidad(" + i + ", \"" + tipo + "\")");
        Empleado actual = empleados.get(i);
        Empleado decorado = switch (tipo.toLowerCase()) {
            case "lidertecnico" -> new LiderTecnico(actual);
            case "soporte" -> new SoporteFinSemana(actual);
            case "mentor" -> new Mentor(actual);
            default -> {
                System.out.println("[DevEnterpriseFacade] Responsabilidad desconocida: " + tipo);
                yield actual;
            }
        };
        empleados.set(i, decorado);
        System.out.println("[DevEnterpriseFacade] Resultado: " + resumen(decorado));
    }

    public void asignarEmpleadoAProyecto(int i) {
        Empleado e = empleados.get(i);
        System.out.println("[DevEnterpriseFacade] asignarEmpleadoAProyecto(" + i + "): " + e.getNombre()
                + " (estado " + e.getEstado().getNombre() + ", ¿puede recibir asignación? " + e.puedeRecibirAsignacion() + ")");
        e.asignarAProyecto(proyecto);
    }

    public void ejecutarPipeline(String tecnologia) {
        System.out.println("[DevEnterpriseFacade] ejecutarPipeline(\"" + tecnologia + "\")");
        FabricaPruebas fabrica = switch (tecnologia.toLowerCase()) {
            case "mobile" -> new FabricaMobile();
            case "cloud" -> new FabricaCloud();
            default -> new FabricaWeb();
        };
        pipeline.setFabrica(fabrica);
        pipeline.ejecutar();
    }

    public void registrarReunion(String asunto, boolean firmada) {
        System.out.println("[DevEnterpriseFacade] registrarReunion(\"" + asunto + "\", firmada=" + firmada + ")");
        String fecha = "2026-10-05 09:00 " + config.getZonaHoraria();
        bitacora.agendarReunion(asunto, fecha);

        ActaReunion acta = new ActaReunion(fecha, asunto);
        List<Comando> cambios = List.of(
                new AgregarRequerimiento(proyecto, "Transferencias entre cuentas"),
                new ModificarRequerimiento(proyecto, "Login con usuario y clave", "Login con doble factor"),
                new EliminarRequerimiento(proyecto, "Consulta de saldos"));
        for (Comando c : cambios) {
            acta.agregarCambio(c);
            gestorCambios.ejecutarComando(c);
        }
        if (firmada) {
            acta.firmar();
        } else {
            acta.anular();
        }
        bitacora.registrarActa(acta);
        System.out.println("[DevEnterpriseFacade] Requerimientos actuales: " + proyecto.getRequerimientos());
    }

    public void deshacerUltimoCambio() {
        System.out.println("[DevEnterpriseFacade] deshacerUltimoCambio()");
        gestorCambios.deshacerUltimo();
        System.out.println("[DevEnterpriseFacade] Requerimientos actuales: " + proyecto.getRequerimientos());
    }

    public void cambiarCalendario(String proveedor) {
        System.out.println("[DevEnterpriseFacade] cambiarCalendario(\"" + proveedor + "\")");
        if (proveedor.equalsIgnoreCase("outlook")) {
            config.setCalendario(new OutlookAdapter(new OutlookAPI()));
        } else {
            config.setCalendario(new GoogleCalendarAdapter(new GoogleCalendarAPI()));
        }
    }

    private Tarea buscarTarea(ComponenteCompuesto nodo, String nombre) {
        for (ComponenteProyecto hijo : nodo.getHijos()) {
            if (hijo instanceof Tarea t && t.getNombre().equals(nombre)) {
                return t;
            }
            if (hijo instanceof ComponenteCompuesto c) {
                Tarea encontrada = buscarTarea(c, nombre);
                if (encontrada != null) {
                    return encontrada;
                }
            }
        }
        return null;
    }

    private String resumen(Empleado e) {
        return e.getDescripcion() + " | salario $" + e.getSalario() + " | permisos " + e.getPermisos()
                + " | estado " + e.getEstado().getNombre();
    }
}
