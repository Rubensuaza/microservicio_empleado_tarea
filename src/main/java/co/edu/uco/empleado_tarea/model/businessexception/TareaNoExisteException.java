package co.edu.uco.empleado_tarea.model.businessexception;

public class TareaNoExisteException extends RuntimeException {

    public TareaNoExisteException(String message) {
        super(message);
    }
}
