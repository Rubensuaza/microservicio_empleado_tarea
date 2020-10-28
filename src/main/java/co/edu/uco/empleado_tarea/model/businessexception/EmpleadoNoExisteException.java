package co.edu.uco.empleado_tarea.model.businessexception;

public class EmpleadoNoExisteException extends RuntimeException{

    public EmpleadoNoExisteException(String message) {
        super(message);
    }
}
