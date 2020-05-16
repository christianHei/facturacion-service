package edu.uoc.facturacion.repositorio;

import edu.uoc.facturacion.modelo.facturacion.FacturaDetalle;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Christian Juiña
 */
@RepositoryRestResource(collectionResourceRel = "facturas_detalle", path = "factura_detalle")
public interface FacturaDetalleRepositorio extends PagingAndSortingRepository<FacturaDetalle, Long> {
}
