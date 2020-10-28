package co.edu.uco.empleado_tarea.command;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class EmpleadoTareaCommand {


    private int idEmpleado;
    private int idTarea;

}
