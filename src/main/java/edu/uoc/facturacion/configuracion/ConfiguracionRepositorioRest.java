package edu.uoc.facturacion.configuracion;

import edu.uoc.facturacion.modelo.acceso.Usuario;
import edu.uoc.facturacion.modelo.facturacion.Cliente;
import edu.uoc.facturacion.modelo.facturacion.Empresa;
import edu.uoc.facturacion.modelo.facturacion.Factura;
import edu.uoc.facturacion.modelo.facturacion.FacturaDetalle;
import edu.uoc.facturacion.modelo.facturacion.Identificacion;
import edu.uoc.facturacion.modelo.facturacion.Parametro;
import edu.uoc.facturacion.modelo.facturacion.Producto;
import edu.uoc.facturacion.modelo.facturacion.TipoIdentificacion;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class ConfiguracionRepositorioRest implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Usuario.class);
        config.exposeIdsFor(Producto.class);
        config.exposeIdsFor(Empresa.class);
        config.exposeIdsFor(Cliente.class);
        config.exposeIdsFor(TipoIdentificacion.class);
        config.exposeIdsFor(Cliente.class);
        config.exposeIdsFor(Identificacion.class);
        config.exposeIdsFor(Parametro.class);
        config.exposeIdsFor(Producto.class);
    }
}
