package deventerprise.personal;

import java.util.ArrayList;
import java.util.List;

public class Desarrollador extends EmpleadoBase {
    public Desarrollador(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public List<String> getPermisos() {
        return new ArrayList<>(List.of("ver_proyecto", "commit_codigo"));
    }
}
