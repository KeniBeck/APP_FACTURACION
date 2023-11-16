package com.api.gestion.facturacion.servicio;

import com.api.gestion.facturacion.DAO.EmpleadoRepository;
import com.api.gestion.facturacion.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
    @Autowired
    private static EmpleadoRepository empleadoRepository;

    public static Empleado guardarEmpleado(Empleado empleado) {
       return empleadoRepository.save(empleado);
    }
}
