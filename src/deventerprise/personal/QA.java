package deventerprise.personal;

import java.util.ArrayList;
import java.util.List;

public class QA extends EmpleadoBase {
    public QA(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public List<String> getPermisos() {
        return new ArrayList<>(List.of("ver_proyecto", "ejecutar_pruebas", "reportar_defectos"));
    }
}
