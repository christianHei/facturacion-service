package edu.uoc.facturacion.repositorio;

import edu.uoc.facturacion.modelo.facturacion.Factura;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Christian Juiña
 */
@RepositoryRestResource(collectionResourceRel = "facturas", path = "factura")
public interface FacturaRepositorio extends PagingAndSortingRepository<Factura, Long> {
}
