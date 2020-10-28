package co.edu.uco.empleado_tarea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EmpleadoTareaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpleadoTareaApplication.class, args);
    }

}
