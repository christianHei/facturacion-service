package edu.uoc.facturacion.repositorio;

import edu.uoc.facturacion.modelo.facturacion.Empresa;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Christian Juiña
 */
@RepositoryRestResource(collectionResourceRel = "empresas", path = "empresa")
public interface EmpresaRepositorio extends PagingAndSortingRepository<Empresa, Long> {
}
