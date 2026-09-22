package deventerprise.bitacora;

import deventerprise.proyectos.Proyecto;

public class ModificarRequerimiento implements Comando {
    private Proyecto proyecto;
    private String anterior;
    private String nuevo;
    private boolean aplicado;

    public ModificarRequerimiento(Proyecto p, String ant, String nuevo) {
        this.proyecto = p;
        this.anterior = ant;
        this.nuevo = nuevo;
    }

    @Override
    public void ejecutar() {
        System.out.println("  [ModificarRequerimiento] ejecutar");
        proyecto.modificarRequerimiento(anterior, nuevo);
        aplicado = true;
    }

    @Override
    public void deshacer() {
        if (!aplicado) {
            System.out.println("  [ModificarRequerimiento] nada que deshacer (ya revertido)");
            return;
        }
        System.out.println("  [ModificarRequerimiento] deshacer");
        proyecto.modificarRequerimiento(nuevo, anterior);
        aplicado = false;
    }

    @Override
    public String getDescripcion() { return "Modificar requerimiento '" + anterior + "' -> '" + nuevo + "'"; }
}
