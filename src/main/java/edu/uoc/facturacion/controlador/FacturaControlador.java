package edu.uoc.facturacion.controlador;

import com.google.gson.Gson;
import edu.uoc.facturacion.modelo.facturacion.Cliente;
import edu.uoc.facturacion.modelo.facturacion.Factura;
import edu.uoc.facturacion.servicio.FacturaServicio;
import edu.uoc.facturacion.servicio.ReporteServicio;
import edu.uoc.facturacion.util.ConstantesUtil;
import edu.uoc.facturacion.util.EmailUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.mail.util.ByteArrayDataSource;
import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("factura")
@Api(value = "Servicio Factura")
public class FacturaControlador {

    FacturaServicio facturaServicio;
    ReporteServicio reporteServicio;

    @Autowired
    public void setInjectedBean(FacturaServicio facturaServicio, ReporteServicio reporteServicio) {
        this.facturaServicio = facturaServicio;
        this.reporteServicio = reporteServicio;
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Guarda un Factura", notes = "Guarda un Factura")
    public void guardar(@RequestBody String jsonFactura) throws EntityExistsException {
        Factura factura = new Gson().fromJson(jsonFactura, Factura.class);
        facturaServicio.guardar(factura);
        enviarEmail(factura.getCliente(), reporteServicio.pdf(factura, "comprobante.jasper"));
    }

    /**
     * Enviar comprobante electrónico al cliente.
     * @param cliente Ciente
     * @param comprobante archivo
     */
    private void enviarEmail(Cliente cliente, ByteArrayDataSource comprobante) {
        String mensaje =
                "<table>" +
                "<tr>" +
                "<td>Estimado Cliente: Le informamos que ha sido generado un comprobante electrónico.</td>"+
                "</tr>" +
                "<tr>" +
                "<td>" + "Gracias por preferirnos." + "</td>"+
                "</tr>" +
                "<br/>" +
                "<tr>" +
                "<td>" + "Atentamente, " + cliente.getEmpresa().getRazonSocial() + ".</td>"+
                "</tr>" +
                "</table>";
        EmailUtil.enviarEmail(ConstantesUtil.EMAIL_ASUNTO_FACTURACION, mensaje, cliente.getEmail(), comprobante);
    }
}
