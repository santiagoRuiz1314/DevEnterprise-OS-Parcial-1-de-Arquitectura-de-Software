package deventerprise.personal;

import java.util.ArrayList;
import java.util.List;

/** Decorator concreto: responsabilidad "Mentor" (+$200 de bono). */
public class Mentor extends ResponsabilidadDecorator {
    private double bono = 200;

    public Mentor(Empleado e) {
        super(e);
    }

    @Override
    public double getSalario() {
        return envuelto.getSalario() + bono;
    }

    @Override
    public List<String> getPermisos() {
        List<String> permisos = new ArrayList<>(envuelto.getPermisos());
        permisos.add("revisar_codigo_juniors");
        return permisos;
    }

    @Override
    public String getDescripcion() {
        return envuelto.getDescripcion() + " + Mentor";
    }
}
