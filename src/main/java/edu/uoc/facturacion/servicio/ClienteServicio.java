package edu.uoc.facturacion.servicio;

import com.google.common.collect.Lists;
import edu.uoc.facturacion.modelo.facturacion.Cliente;
import edu.uoc.facturacion.modelo.facturacion.Identificacion;
import edu.uoc.facturacion.repositorio.ClienteRepositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio Cliente
 * @author Christian Juiña
 */
@Service
public class ClienteServicio {

    private ClienteRepositorio clienteRepositorio;
    private IdentificacionServicio identificacionServicio;

    @Autowired
    public void setInjectedBean(ClienteRepositorio clienteRepositorio, IdentificacionServicio identificacionServicio) {
        this.clienteRepositorio = clienteRepositorio;
        this.identificacionServicio = identificacionServicio;
    }

    @PersistenceContext
    private EntityManager em;

    public List<Cliente> obtenerTodo(){
        return Lists.newArrayList(clienteRepositorio.findAll());
    }

    /**
     * Método que guarda el objeto Cliente.
     * @param cliente objeto Cliente.
     */
    public void guardar(Cliente cliente) {
        clienteRepositorio.save(cliente);
        Identificacion identificacion = cliente.getListaIdentificaciones().get(0);
        identificacion.setCliente(cliente);
        identificacionServicio.guardar(identificacion);
    }

    /**
     * Método que obtiene un Cliente por numero de identificación y id Empresa.
     * @param identificacionCliente numero de identificación.
     * @param idEmpresa id Empresa.
     * @return Cliente
     */
    public Cliente obtenerPorIdentificacionEmpresa(String identificacionCliente, Long idEmpresa) {
        String consulta = "SELECT c FROM Cliente c, Identificacion i WHERE i.numero = :identificacionCliente and " +
                "c.empresa.id = :idEmpresa and i.cliente.id = c.id";
        TypedQuery<Cliente> query = em.createQuery(consulta, Cliente.class);
        query.setParameter("identificacionCliente", identificacionCliente);
        query.setParameter("idEmpresa", idEmpresa);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return  null;
        }
    }
}
