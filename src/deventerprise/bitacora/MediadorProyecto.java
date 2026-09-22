package deventerprise.bitacora;

/** Mediator: los colegas solo conocen esta interfaz. */
public interface MediadorProyecto {
    void notificar(String emisor, String evento);
}
