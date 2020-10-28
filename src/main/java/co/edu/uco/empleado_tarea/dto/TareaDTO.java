package co.edu.uco.empleado_tarea.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class TareaDTO {

    private Integer idTarea;
    private String nombreTarea;
    private String descripcionTarea;
    private boolean activo;
}
