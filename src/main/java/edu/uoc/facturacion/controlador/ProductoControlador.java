package edu.uoc.facturacion.controlador;

import com.google.gson.Gson;
import edu.uoc.facturacion.modelo.facturacion.Producto;
import edu.uoc.facturacion.servicio.ProductoServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityExistsException;
import java.util.List;

@RestController
@RequestMapping("producto")
@Api(value = "Servicio Producto")
public class ProductoControlador {

    ProductoServicio productoServicio;

    @Autowired
    public void setInjectedBean(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Guarda un Producto", notes = "Guarda un Producto")
    public void guardar(@RequestBody String jsonProducto) throws EntityExistsException {
        Producto producto = new Gson().fromJson(jsonProducto, Producto.class);
        productoServicio.guardar(producto);
    }

    @PostMapping(path = "/eliminar/", consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Elimina un Producto", notes = "Elimina un Producto")
    public void eliminar(@RequestBody String jsonProducto) throws EntityExistsException {
        Producto producto = new Gson().fromJson(jsonProducto, Producto.class);
        productoServicio.eliminar(producto);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/empresa/{idEmpresa}", produces = "application/json")
    @ApiOperation(value = "Encuentra una lista de Productos por Empresa", notes = "Retorna un lista de Productos")
    public List<Producto> obtenerPorUsuario(@PathVariable("idEmpresa") Long idEmpresa){
        return productoServicio.obtenerPorIdEmpresa(idEmpresa);
    }
}
