package edu.uoc.facturacion.repositorio;

import edu.uoc.facturacion.modelo.facturacion.TipoIdentificacion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Christian Juiña
 */
@RepositoryRestResource(collectionResourceRel = "tipoIdentificaciones", path = "tipo-identificacion")
public interface TipoIdentificacionRepositorio extends PagingAndSortingRepository<TipoIdentificacion, Long> {
}
