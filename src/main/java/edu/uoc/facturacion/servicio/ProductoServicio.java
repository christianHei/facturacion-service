package edu.uoc.facturacion.servicio;

import edu.uoc.facturacion.modelo.facturacion.Producto;
import edu.uoc.facturacion.repositorio.ProductoRepositorio;
import edu.uoc.facturacion.util.ConstantesUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio Producto
 * @author Christian Juiña
 */
@Service
public class ProductoServicio {

    ProductoRepositorio productoRepositorio;

    @Autowired
    public void setInjectedBean(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @PersistenceContext
    private EntityManager em;

    /**
     * Método que guarda un Producto
     * @param producto objeto Producto
     */
    public void guardar(Producto producto) {
        producto.setEliminado(ConstantesUtil.ESTADO_ELIMINADO_N);
        productoRepositorio.save(producto);
    }

    /**
     * Método que cambia el estado de un producto a eliminado.
     * @param producto objeto Producto
     */
    public void eliminar(Producto producto) {
        producto.setEliminado(ConstantesUtil.ESTADO_ELIMINADO_S);
        productoRepositorio.save(producto);
    }

    /**
     * Método que obtiene la lista de productos de una Empresa
     * @param idEmpresa id de la Empresa
     * @return lista de Productos
     */
    public List<Producto> obtenerPorIdEmpresa(Long idEmpresa) {
        String consulta = "SELECT p FROM Producto p WHERE p.empresa.id = :idEmpresa and p.eliminado = :eliminado";
        TypedQuery<Producto> query = em.createQuery(consulta, Producto.class);
        query.setParameter("idEmpresa", idEmpresa);
        query.setParameter("eliminado", ConstantesUtil.ESTADO_ELIMINADO_N);
        return query.getResultList();
    }
}
