package deventerprise.bitacora;

import deventerprise.proyectos.Proyecto;

public class EliminarRequerimiento implements Comando {
    private Proyecto proyecto;
    private String requerimiento;
    private boolean aplicado;

    public EliminarRequerimiento(Proyecto p, String r) {
        this.proyecto = p;
        this.requerimiento = r;
    }

    @Override
    public void ejecutar() {
        System.out.println("  [EliminarRequerimiento] ejecutar");
        proyecto.eliminarRequerimiento(requerimiento);
        aplicado = true;
    }

    @Override
    public void deshacer() {
        if (!aplicado) {
            System.out.println("  [EliminarRequerimiento] nada que deshacer (ya revertido)");
            return;
        }
        System.out.println("  [EliminarRequerimiento] deshacer");
        proyecto.agregarRequerimiento(requerimiento);
        aplicado = false;
    }

    @Override
    public String getDescripcion() { return "Eliminar requerimiento '" + requerimiento + "'"; }
}
