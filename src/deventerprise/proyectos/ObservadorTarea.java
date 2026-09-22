package deventerprise.proyectos;

/** Observer: interesados en los cambios de una Tarea. */
public interface ObservadorTarea {
    void actualizar(Tarea t);
}
