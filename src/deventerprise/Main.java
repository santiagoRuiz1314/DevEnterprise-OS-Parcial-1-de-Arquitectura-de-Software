package deventerprise;

import deventerprise.infraestructura.DevEnterpriseFacade;
import deventerprise.personal.Desarrollador;
import deventerprise.personal.QA;
import deventerprise.proyectos.PorPuntosFuncion;

/** Demo: solo habla con la fachada. */
public class Main {
    public static void main(String[] args) {
        seccion("Inicialización (Singleton + Adapter + Mediator)");
        DevEnterpriseFacade sistema = new DevEnterpriseFacade();

        seccion("Bloque 1 · Composite: crear proyecto demo");
        sistema.crearProyectoDemo();

        seccion("Bloque 1 · Strategy: estimación por horas");
        sistema.mostrarEstimacion();

        seccion("Bloque 1 · Strategy: cambio a puntos de función en ejecución");
        sistema.cambiarEstrategia(new PorPuntosFuncion(120, 2.5));
        sistema.mostrarEstimacion();

        seccion("Bloque 1 · Observer: completar tarea");
        sistema.completarTarea("Backend");

        seccion("Bloque 2 · Decorator: contratar y asignar responsabilidades");
        sistema.contratarEmpleado(new Desarrollador("Carlos Pérez", 5000));
        sistema.contratarEmpleado(new QA("Ana Torres", 4200));
        sistema.asignarResponsabilidad(1, "liderTecnico");
        sistema.asignarResponsabilidad(1, "mentor");
        sistema.asignarResponsabilidad(2, "soporte");

        seccion("Bloque 2 · State: asignación de empleados al proyecto");
        sistema.asignarEmpleadoAProyecto(1);
        sistema.asignarEmpleadoAProyecto(1);
        sistema.asignarEmpleadoAProyecto(2);

        seccion("Bloque 3 · Chain of Responsibility + Abstract Factory: pipeline Web");
        sistema.ejecutarPipeline("Web");

        seccion("Bloque 3 · Pipeline Mobile");
        sistema.ejecutarPipeline("Mobile");

        seccion("Bloque 3 · Pipeline Cloud");
        sistema.ejecutarPipeline("Cloud");

        seccion("Bloque 4 · Command + Mediator: acta NO firmada (cambios revertidos)");
        sistema.registrarReunion("Revisión de alcance con el cliente", false);

        seccion("Bloque 5 · Adapter: cambiar calendario a Outlook");
        sistema.cambiarCalendario("Outlook");

        seccion("Bloque 4 · Command + Mediator: acta firmada (cambios aplicados)");
        sistema.registrarReunion("Aprobación de cambios de sprint", true);

        seccion("Bloque 4 · Command: deshacer último cambio");
        sistema.deshacerUltimoCambio();

        seccion("Fin de la demo");
    }

    private static void seccion(String titulo) {
        System.out.println();
        System.out.println("==================== " + titulo + " ====================");
    }
}
