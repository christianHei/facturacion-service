package edu.uoc.facturacion.controlador;

import edu.uoc.facturacion.modelo.facturacion.Parametro;
import edu.uoc.facturacion.servicio.ParametroServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("parametro")
@Api(value = "Servicio Parametro")
public class ParametroControlador {

    ParametroServicio parametroServicio;

    @Autowired
    public void setInjectedBean(ParametroServicio parametroServicio) {
        this.parametroServicio = parametroServicio;
    }

    @GetMapping(path = "/", produces = "application/json")
    @ResponseBody
    public List<Parametro> obtenerTodo(){
        return parametroServicio.obtenerTodo();
    }

    @GetMapping(path = "/nombre/{nombre}", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Encuentra un Parametro por nombre", notes = "Retorna un Parametro")
    public Parametro obtenerPorNombre(@PathVariable("nombre") String nombre) {
        return parametroServicio.obtenerPorNombre(nombre);
    }
}
