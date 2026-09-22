package deventerprise.bitacora;

import deventerprise.proyectos.Proyecto;

public class AgregarRequerimiento implements Comando {
    private Proyecto proyecto;
    private String requerimiento;
    private boolean aplicado;

    public AgregarRequerimiento(Proyecto p, String r) {
        this.proyecto = p;
        this.requerimiento = r;
    }

    @Override
    public void ejecutar() {
        System.out.println("  [AgregarRequerimiento] ejecutar");
        proyecto.agregarRequerimiento(requerimiento);
        aplicado = true;
    }

    @Override
    public void deshacer() {
        if (!aplicado) {
            System.out.println("  [AgregarRequerimiento] nada que deshacer (ya revertido)");
            return;
        }
        System.out.println("  [AgregarRequerimiento] deshacer");
        proyecto.eliminarRequerimiento(requerimiento);
        aplicado = false;
    }

    @Override
    public String getDescripcion() { return "Agregar requerimiento '" + requerimiento + "'"; }
}
