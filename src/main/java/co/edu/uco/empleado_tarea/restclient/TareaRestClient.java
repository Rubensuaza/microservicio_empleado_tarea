package co.edu.uco.empleado_tarea.restclient;


import co.edu.uco.empleado_tarea.dto.TareaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="servicio.tareas", url="localhost:8082/tarea")
public interface TareaRestClient {

    @GetMapping("/v1/{id}/tarea")
    TareaDTO findById(@PathVariable Integer id);
}
