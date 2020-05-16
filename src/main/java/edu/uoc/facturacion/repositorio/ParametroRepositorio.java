package edu.uoc.facturacion.repositorio;

import edu.uoc.facturacion.modelo.facturacion.Parametro;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Christian Juiña
 */
@RepositoryRestResource(collectionResourceRel = "parametros", path = "parametro")
public interface ParametroRepositorio extends PagingAndSortingRepository<Parametro, Long> {
}
