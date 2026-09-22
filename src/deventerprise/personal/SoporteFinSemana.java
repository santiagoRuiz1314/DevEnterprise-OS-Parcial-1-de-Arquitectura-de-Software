package deventerprise.personal;

import java.util.ArrayList;
import java.util.List;

/** Decorator concreto: responsabilidad "Soporte fin de semana" (+$300 de bono). */
public class SoporteFinSemana extends ResponsabilidadDecorator {
    private double bono = 300;

    public SoporteFinSemana(Empleado e) {
        super(e);
    }

    @Override
    public double getSalario() {
        return envuelto.getSalario() + bono;
    }

    @Override
    public List<String> getPermisos() {
        List<String> permisos = new ArrayList<>(envuelto.getPermisos());
        permisos.add("acceso_produccion");
        return permisos;
    }

    @Override
    public String getDescripcion() {
        return envuelto.getDescripcion() + " + Soporte fin de semana";
    }
}
