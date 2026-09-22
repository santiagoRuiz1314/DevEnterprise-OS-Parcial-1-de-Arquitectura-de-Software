package deventerprise.personal;

import java.util.ArrayList;
import java.util.List;

/** Decorator concreto: responsabilidad "Líder Técnico" (+$800 de bono). */
public class LiderTecnico extends ResponsabilidadDecorator {
    private double bono = 800;

    public LiderTecnico(Empleado e) {
        super(e);
    }

    @Override
    public double getSalario() {
        return envuelto.getSalario() + bono;
    }

    @Override
    public List<String> getPermisos() {
        List<String> permisos = new ArrayList<>(envuelto.getPermisos());
        permisos.add("aprobar_pull_requests");
        permisos.add("definir_arquitectura");
        return permisos;
    }

    @Override
    public String getDescripcion() {
        return envuelto.getDescripcion() + " + Líder Técnico";
    }
}
