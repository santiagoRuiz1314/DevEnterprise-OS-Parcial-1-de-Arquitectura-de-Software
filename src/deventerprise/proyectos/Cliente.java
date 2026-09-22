package deventerprise.proyectos;

/** Observer concreto: el cliente recibe un correo simulado. */
public class Cliente implements ObservadorTarea {
    private String nombre;
    private String correo;

    public Cliente(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    @Override
    public void actualizar(Tarea t) {
        System.out.println("  [Cliente] Enviando correo a " + nombre + " <" + correo + ">: la tarea '"
                + t.getNombre() + "' está " + t.getEstado());
    }
}
