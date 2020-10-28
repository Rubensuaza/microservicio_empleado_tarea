package co.edu.uco.empleado_tarea.model.businessexception;

public class EmpleadoNoAsignadoException extends RuntimeException{
    public EmpleadoNoAsignadoException(String message) {
        super(message);
    }
}
