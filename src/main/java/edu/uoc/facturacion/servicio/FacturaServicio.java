package edu.uoc.facturacion.servicio;

import edu.uoc.facturacion.modelo.facturacion.Cliente;
import edu.uoc.facturacion.modelo.facturacion.Factura;
import edu.uoc.facturacion.repositorio.FacturaRepositorio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio Factura
 * @author Christian Juiña
 */
@Service
public class FacturaServicio {

    private FacturaRepositorio facturaRepositorio;
    private FacturaDetalleServicio facturaDetalleServicio;
    private ClienteServicio clienteServicio;

    @Autowired
    public void setInjectedBean(FacturaRepositorio facturaRepositorio, FacturaDetalleServicio facturaDetalleServicio,
                                ClienteServicio clienteServicio) {
        this.facturaRepositorio = facturaRepositorio;
        this.facturaDetalleServicio = facturaDetalleServicio;
        this.clienteServicio = clienteServicio;
    }

    @PersistenceContext
    private EntityManager em;

    /**
     * Método que guarda el objeto Factura.
     * @param factura objeto Factura.
     */
    public void guardar(Factura factura) {
        Cliente cliente = factura.getCliente();
        Cliente clienteConsulta =
                    clienteServicio.obtenerPorIdentificacionEmpresa(factura.getCliente().getListaIdentificaciones().get(0).getNumero(),
                    factura.getCliente().getEmpresa().getId());
        if (clienteConsulta != null) {
            cliente = clienteConsulta;
        }
        factura.setCliente(cliente);
        facturaRepositorio.save(factura);
        factura.getListaFacturaDetalle().forEach(facturaDetalle -> {
            facturaDetalle.setFactura(factura);
            facturaDetalleServicio.guardar(facturaDetalle);
        });
    }
}
