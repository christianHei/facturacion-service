package edu.uoc.facturacion.controlador;

import edu.uoc.facturacion.util.EmailUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("email")
@Api(value = "Servicio Email")
public class EmailControlador {

    @GetMapping(path = "/validar/{email}", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Verifica si un email es válido", notes = "Retorna verdadero / falso")
    public Boolean validarEmail(@PathVariable("email") String email) {
        return EmailUtil.esEmail(email);
    }

    @GetMapping(path = "/enviar/email/{email}", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Verifica si un email es válido", notes = "Retorna verdadero / falso")
    public Boolean recuperarClave(@PathVariable("email") String email) {
        String mensaje =
                "<table>" +
                        "<tr>" +
                        "<td>Estimado Cliente: se ha generado la siguiente clave.</td>"+
                        "</tr>" +
                        "<br/>" +
                        "<tr>" +
                        "<td>" + "Clave:" + "</td>"+
                        "</tr>" +
                        "<tr>" +
                        "<td>" + String.format("%04d", new Random().nextInt(9999)) + "</td>"+
                        "</tr>" +
                        "</table>";
         EmailUtil.enviarEmail("Recuperar clave", mensaje, email, null);
         return true;
    }
}
