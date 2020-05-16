package edu.uoc.facturacion.controlador;

import edu.uoc.facturacion.modelo.facturacion.TipoIdentificacion;
import edu.uoc.facturacion.servicio.TipoIdentificacionServicio;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tipo-identificacion")
@Api(value = "Servicio TipoIdentificacion")
public class TipoIdentificacionControlador {

    TipoIdentificacionServicio tipoIdentificacionServicio;

    @Autowired
    public void setInjectedBean(TipoIdentificacionServicio tipoIdentificacionServicio) {
        this.tipoIdentificacionServicio = tipoIdentificacionServicio;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/", produces = "application/json")
    public List<TipoIdentificacion> obtenerTodo(){
        return tipoIdentificacionServicio.obtenerTodo();
    }
}
