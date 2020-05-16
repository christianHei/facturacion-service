package edu.uoc.facturacion.controlador;

import com.google.gson.Gson;
import edu.uoc.facturacion.modelo.facturacion.Cliente;
import edu.uoc.facturacion.servicio.ClienteServicio;
import edu.uoc.facturacion.servicio.IdentificacionServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.persistence.EntityExistsException;
import java.util.List;

import org.hibernate.boot.jaxb.Origin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cliente")
@Api(value = "Servicio CLiente")
public class ClienteControlador {

    ClienteServicio clienteServicio;
    IdentificacionServicio identificacionServicio;

    @Autowired
    public void setInjectedBean(ClienteServicio clienteServicio, IdentificacionServicio identificacionServicio) {
        this.clienteServicio = clienteServicio;
        this.identificacionServicio = identificacionServicio;
    }

    @GetMapping(path = "/", produces = "application/json")
    //@RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json")
    public List<Cliente> obtenerTodo(){
        return clienteServicio.obtenerTodo();
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json", headers = {})
    @ResponseBody
    @ApiOperation(value = "Guarda un Cliente", notes = "Guarda un Cliente")
    public void guardar(@RequestBody String jsonCliente) throws EntityExistsException {
        Cliente cliente = new Gson().fromJson(jsonCliente, Cliente.class);
        Cliente clienteExiste = clienteServicio.obtenerPorIdentificacionEmpresa(cliente.getListaIdentificaciones().get(0).getNumero(),
                cliente.getEmpresa().getId());
        if (clienteExiste == null ) {
            clienteServicio.guardar(cliente);
        } else {
            clienteExiste.setApellido(cliente.getApellido());
            clienteExiste.setNombre(cliente.getNombre());
            clienteExiste.setDireccion(cliente.getDireccion());
            cliente.setEmail(cliente.getEmail());
            clienteServicio.guardar(clienteExiste);
        }
    }

    @GetMapping(path = "/identificacion_empresa/{identificacion}/{idEmpresa}", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Encuentra un Cliente por identificación y empresa", notes = "Retorna un Cliente")
    public Cliente obtenerPorIdentificaciónEmpresa(@PathVariable("identificacion") String identificacion,
                                                   @PathVariable("idEmpresa") Long idEmpresa) {
        return clienteServicio.obtenerPorIdentificacionEmpresa(identificacion, idEmpresa);
    }
}
