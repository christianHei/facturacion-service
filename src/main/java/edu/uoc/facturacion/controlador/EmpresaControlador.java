package edu.uoc.facturacion.controlador;

import edu.uoc.facturacion.modelo.facturacion.Empresa;
import edu.uoc.facturacion.servicio.EmpresaServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("empresa")
@Api(value = "Servicio Empresa")
public class EmpresaControlador {

    EmpresaServicio empresaServicio;

    @Autowired
    public void setInjectedBean(EmpresaServicio empresaServicio) {
        this.empresaServicio = empresaServicio;
    }

    @GetMapping(path = "/ruc/{ruc}", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Encuentra una Empresa por ruc", notes = "Retorna una Empresa")
    public Empresa obtenerPorRuc(@PathVariable("ruc") String ruc) {
        return empresaServicio.obtenerPorRuc(ruc);
    }
}
