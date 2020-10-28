package co.edu.uco.empleado_tarea.restclient;

import co.edu.uco.empleado_tarea.dto.EmpleadoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="servicio.empleados", url="localhost:8081/empleado")
public interface EmpleadoRestClient {

    @GetMapping("/v1/{id}/empleado")
    EmpleadoDTO findById(@PathVariable Integer id);
}
