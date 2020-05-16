package edu.uoc.facturacion.servicio;

import edu.uoc.facturacion.modelo.facturacion.FacturaDetalle;
import edu.uoc.facturacion.repositorio.FacturaDetalleRepositorio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio FacturaDetalle
 * @author Christian Juiña
 */
@Service
public class FacturaDetalleServicio {

    FacturaDetalleRepositorio facturaDetalleRepositorio;

    @Autowired
    public void setInjectedBean(FacturaDetalleRepositorio facturaDetalleRepositorio) {
        this.facturaDetalleRepositorio = facturaDetalleRepositorio;
    }

    @PersistenceContext
    private EntityManager em;

    /**
     * Método que guarda el objeto FacturaDetalle.
     * @param facturaDetalle FacturaDetalle.
     */
    public void guardar(FacturaDetalle facturaDetalle) {
        facturaDetalleRepositorio.save(facturaDetalle);
    }
}
