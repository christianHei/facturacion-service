package edu.uoc.facturacion.repositorio;

import edu.uoc.facturacion.modelo.acceso.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Christian Juiña
 */
@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuario")
public interface UsuarioRepositorio extends PagingAndSortingRepository<Usuario, Long> {
}
