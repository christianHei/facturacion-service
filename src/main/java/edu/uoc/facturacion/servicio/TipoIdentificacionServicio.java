package edu.uoc.facturacion.servicio;

import com.google.common.collect.Lists;
import edu.uoc.facturacion.modelo.facturacion.TipoIdentificacion;
import edu.uoc.facturacion.repositorio.TipoIdentificacionRepositorio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio TipoIdentificacion
 * @author Christian Juiña
 */
@Service
public class TipoIdentificacionServicio {

    TipoIdentificacionRepositorio tipoIdentificacionRepositorio;

    @Autowired
    public void setInjectedBean(TipoIdentificacionRepositorio tipoIdentificacionRepositorio) {
        this.tipoIdentificacionRepositorio = tipoIdentificacionRepositorio;
    }

    @PersistenceContext
    private EntityManager em;

    public List<TipoIdentificacion> obtenerTodo(){
        return Lists.newArrayList(tipoIdentificacionRepositorio.findAll());
    }
}
