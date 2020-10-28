package co.edu.uco.empleado_tarea.service.impl;

import co.edu.uco.empleado_tarea.command.EmpleadoTareaCommand;
import co.edu.uco.empleado_tarea.dto.EmpleadoDTO;
import co.edu.uco.empleado_tarea.dto.TareaDTO;
import co.edu.uco.empleado_tarea.entity.EmpleadoTareaEntity;
import co.edu.uco.empleado_tarea.fabrica.EmpleadoTareaFabrica;
import co.edu.uco.empleado_tarea.mensajes.MensajesException;
import co.edu.uco.empleado_tarea.model.EmpleadoTarea;
import co.edu.uco.empleado_tarea.model.businessexception.EmpleadoAsignadoException;
import co.edu.uco.empleado_tarea.model.businessexception.EmpleadoNoExisteException;
import co.edu.uco.empleado_tarea.model.businessexception.TareaNoExisteException;
import co.edu.uco.empleado_tarea.repository.EmpleadoTareaRepository;
import co.edu.uco.empleado_tarea.restclient.EmpleadoRestClient;
import co.edu.uco.empleado_tarea.restclient.TareaRestClient;
import co.edu.uco.empleado_tarea.service.EmpleadoTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmpleadoTareaServiceImpl implements EmpleadoTareaService {


    private static final String TAREA_ASIGNADA_EXISTOSAMENTE="La tarea ha sido asignada exitosamente!";

    @Autowired
    private EmpleadoRestClient empleadoRestClient;

    @Autowired
    private TareaRestClient tareaRestClient;

    @Autowired
    private EmpleadoTareaRepository empleadoTareaRepository;

    @Autowired
    private EmpleadoTareaFabrica empleadoTareaFabrica;


    @Override
    public String registrarTarea(EmpleadoTareaCommand empleadoTareaCommand) {
        validarEmpleado(empleadoTareaCommand.getIdEmpleado());
        validarTarea(empleadoTareaCommand.getIdTarea());
        validarEmpleadoAsignando(empleadoTareaCommand.getIdEmpleado());
        EmpleadoTareaEntity empleadoTareaEntity=new EmpleadoTareaEntity();
        empleadoTareaEntity.setIdEmpleado(empleadoTareaCommand.getIdEmpleado());
        empleadoTareaEntity.setIdTarea(empleadoTareaCommand.getIdTarea());
        empleadoTareaEntity.setFinalizado(false);
        empleadoTareaEntity.setFechaInicio(new Date());
        empleadoTareaRepository.save(empleadoTareaEntity);
        return TAREA_ASIGNADA_EXISTOSAMENTE;
    }

    @Override
    public EmpleadoTarea finalizarTarea(int idEmpleado) {
        EmpleadoTareaEntity empleadoTareaEntity=empleadoTareaRepository.findByIdEmpleadoAndFinalizado(idEmpleado,false);
        validarEmpleadoNoExiste(empleadoTareaEntity);
        empleadoTareaEntity.setFechaFin(new Date());
        empleadoTareaEntity.setFinalizado(true);
        empleadoTareaRepository.save(empleadoTareaEntity);
        EmpleadoDTO empleadoDTO= empleadoRestClient.findById(empleadoTareaEntity.getIdEmpleado());
        TareaDTO tareaDTO= tareaRestClient.findById(empleadoTareaEntity.getIdTarea());
        return empleadoTareaFabrica.entityToModel(empleadoTareaEntity,empleadoDTO,tareaDTO);
    }

    private void validarEmpleadoNoExiste(EmpleadoTareaEntity empleadoTareaEntity) {
        if (empleadoTareaEntity==null){
            throw new EmpleadoNoExisteException(MensajesException.MensajesEmpleadoExceptio.EMPLEADO_NO_ASIGANDO);
        }
    }

    private void validarEmpleadoAsignando(int idEmpleado) {
        if (empleadoTareaRepository.findByIdEmpleadoAndFinalizado(idEmpleado,false)!=null){
            throw new EmpleadoAsignadoException(MensajesException.MensajesEmpleadoExceptio.EMPLEADO_ASIGANDO);
        }

    }

    private void validarEmpleado(int idEmpleado){
       if (empleadoRestClient.findById(idEmpleado)==null){
           throw new EmpleadoNoExisteException(MensajesException.MensajesEmpleadoExceptio.EMPLEADO_NO_EXISTE);

       }
    }

    private void validarTarea(int idTarea){
        if (tareaRestClient.findById(idTarea)==null){
            throw new TareaNoExisteException("la tarea no existe");

        }
    }
}
