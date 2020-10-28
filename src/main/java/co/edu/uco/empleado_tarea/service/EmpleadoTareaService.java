package co.edu.uco.empleado_tarea.service;

import co.edu.uco.empleado_tarea.command.EmpleadoTareaCommand;
import co.edu.uco.empleado_tarea.model.EmpleadoTarea;

public interface EmpleadoTareaService {


    String registrarTarea(EmpleadoTareaCommand empleadoTareaCommand);

    EmpleadoTarea finalizarTarea(int idEmpleado);
}
