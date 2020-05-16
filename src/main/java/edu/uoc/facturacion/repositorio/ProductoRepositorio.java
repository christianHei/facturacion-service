package edu.uoc.facturacion.repositorio;

import edu.uoc.facturacion.modelo.facturacion.Producto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Christian Juiña
 */
@RepositoryRestResource(collectionResourceRel = "productos", path = "producto")
public interface ProductoRepositorio extends PagingAndSortingRepository<Producto, Long> {
}
