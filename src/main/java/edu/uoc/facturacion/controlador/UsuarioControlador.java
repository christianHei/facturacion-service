package edu.uoc.facturacion.controlador;

import com.google.gson.Gson;
import edu.uoc.facturacion.modelo.acceso.Usuario;
import edu.uoc.facturacion.servicio.UsuarioServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("usuario")
@Api(value = "Servicio Usuario")
public class UsuarioControlador {

    UsuarioServicio usuarioServicio;

    @Autowired
    public void setInjectedBean(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping(path = "/", produces = "application/json")
    public List<Usuario> obtenerTodo(){
        return usuarioServicio.obtenerTodo();
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Guarda un Usuario", notes = "Guarda un Usuario")
    public void guardar(@RequestBody String jsonUsuario) throws EntityExistsException {
        Usuario usuario = new Gson().fromJson(jsonUsuario, Usuario.class);
        usuarioServicio.guardar(usuario);
    }

    @GetMapping(path = "/{nombreUsuario}/{clave}", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Encuentra un Usuario por nombre de usuario y clave", notes = "Retorna un Usuario")
    public Usuario obtenerPorNombreUsuarioClave(@PathVariable("nombreUsuario") String nombreUsuario, @PathVariable("clave") String clave) {
        return usuarioServicio.obtenerPorNombreUsuarioClave(nombreUsuario, clave);
    }

    @GetMapping(path = "/usuario/nombre/usuario/{nombreUsuario}", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Encuentra un Usuario por nombre de usuario", notes = "Retorna un Usuario")
    public Usuario obtenerPorNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario) {
        return usuarioServicio.obtenerPorNombreUsuario(nombreUsuario.trim());
    }
}
