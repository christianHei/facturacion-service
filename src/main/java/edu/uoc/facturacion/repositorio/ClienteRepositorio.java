package edu.uoc.facturacion.repositorio;

import edu.uoc.facturacion.modelo.facturacion.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Christian Juiña
 */
@RepositoryRestResource(collectionResourceRel = "clientes", path = "cliente")
public interface ClienteRepositorio extends PagingAndSortingRepository<Cliente, Long> {
}
