package edu.uoc.facturacion.repositorio;

import edu.uoc.facturacion.modelo.facturacion.Identificacion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Christian Juiña
 */
@RepositoryRestResource(collectionResourceRel = "identificaciones", path = "identificacion")
public interface IdentificacionRepositorio extends PagingAndSortingRepository<Identificacion, Long> {
}
