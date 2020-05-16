package edu.uoc.facturacion.servicio;

import edu.uoc.facturacion.modelo.facturacion.Identificacion;
import edu.uoc.facturacion.repositorio.IdentificacionRepositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio Identificacion
 * @author Christian Juiña
 */
@Service
public class IdentificacionServicio {

    private IdentificacionRepositorio identificacionRepositorio;

    @Autowired
    public void setInjectedBean(IdentificacionRepositorio identificacionRepositorio) {
        this.identificacionRepositorio = identificacionRepositorio;
    }

    @PersistenceContext
    private EntityManager em;

    /**
     * Método que guarda el objeto Identificacion.
     * @param identificacion Identificacion.
     */
    public void guardar(Identificacion identificacion) {
        identificacionRepositorio.save(identificacion);
    }

    /**
     * Retorna una Identificacion por número y id d empresa.
     * @param numero número de identificación.
     * @param idEmpresa id de empresa.
     * @return Identificacion.
     */
    public Identificacion buscarPorNumeroEmpresa(String numero, Long idEmpresa) {
        String consulta = "SELECT i FROM Identificacion i WHERE i.numero = :numero and i.cliente.empresa.id = :idEmpresa";
        TypedQuery<Identificacion> query = em.createQuery(consulta, Identificacion.class);
        query.setParameter("numero", numero);
        query.setParameter("idEmpresa", idEmpresa);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return  null;
        }
    }
}
