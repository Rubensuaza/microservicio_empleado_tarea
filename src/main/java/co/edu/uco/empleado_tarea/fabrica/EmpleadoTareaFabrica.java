package co.edu.uco.empleado_tarea.fabrica;

import co.edu.uco.empleado_tarea.dto.EmpleadoDTO;
import co.edu.uco.empleado_tarea.dto.TareaDTO;
import co.edu.uco.empleado_tarea.entity.EmpleadoTareaEntity;
import co.edu.uco.empleado_tarea.model.Empleado;
import co.edu.uco.empleado_tarea.model.EmpleadoTarea;
import co.edu.uco.empleado_tarea.model.Tarea;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoTareaFabrica {

    public EmpleadoTarea entityToModel(EmpleadoTareaEntity empleadoTareaEntity, EmpleadoDTO empleadoDTO, TareaDTO tareaDTO){
        Empleado empleado=new Empleado.EmpleadoBuilder().
                setIdEmpleado(empleadoDTO.getIdEmpleado()).
                setNombre(empleadoDTO.getNombre()).
                setApellido(empleadoDTO.getApellido()).
                setCargo(empleadoDTO.getCargo()).
                setActivo(empleadoDTO.isActivo()).build();
        Tarea tarea=new Tarea.TareaBuilder().
                setIdTarea(tareaDTO.getIdTarea()).
                setNombreTarea(tareaDTO.getNombreTarea()).
                setDescripcionTarea(tareaDTO.getDescripcionTarea()).
                setActivo(tareaDTO.isActivo()).build();
        EmpleadoTarea empleadoTarea=new EmpleadoTarea.EmpleadoTareaBuilder().
                setIdEmpleadoTarea(empleadoTareaEntity.getIdEmpleadoTarea()).
                setEmpleado(empleado).
                setTarea(tarea).
                setFechaInicio(empleadoTareaEntity.getFechaInicio()).
                setFechaFin(empleadoTareaEntity.getFechaFin()).
                setActivo(empleadoTareaEntity.isFinalizado()).build();
        return empleadoTarea;
    }
}
