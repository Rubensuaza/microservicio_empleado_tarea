package co.edu.uco.empleado_tarea.repository;

import co.edu.uco.empleado_tarea.entity.EmpleadoTareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoTareaRepository extends JpaRepository<EmpleadoTareaEntity, Integer> {



    EmpleadoTareaEntity findByIdEmpleadoAndFinalizado(int idEmpleado, boolean b);
}
