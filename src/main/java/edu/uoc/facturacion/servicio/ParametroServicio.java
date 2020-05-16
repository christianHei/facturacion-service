package edu.uoc.facturacion.servicio;

import com.google.common.collect.Lists;
import edu.uoc.facturacion.modelo.facturacion.Parametro;
import edu.uoc.facturacion.repositorio.ParametroRepositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio Usuario
 * @author Christian Juiña
 */
@Service
public class ParametroServicio {

    private ParametroRepositorio parametroRepositorio;

    @Autowired
    public void setInjectedBean(ParametroRepositorio parametroRepositorio) {
        this.parametroRepositorio = parametroRepositorio;
    }

    @PersistenceContext
    private EntityManager em;

    public List<Parametro> obtenerTodo(){
        return Lists.newArrayList(parametroRepositorio.findAll());
    }

    /**
     * Método que obtiene un Parametro por nombre.
     * @param nombre nombre del parámetro.
     * @return Parametro
     */
    public Parametro obtenerPorNombre(String nombre) {
        String consulta = "SELECT p FROM Parametro p WHERE p.nombre = :nombre";
        TypedQuery<Parametro> query = em.createQuery(consulta, Parametro.class);
        query.setParameter("nombre", nombre);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return  null;
        }
    }
}
