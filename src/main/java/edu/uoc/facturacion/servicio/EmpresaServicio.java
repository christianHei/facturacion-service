package edu.uoc.facturacion.servicio;

import edu.uoc.facturacion.modelo.facturacion.Empresa;
import edu.uoc.facturacion.repositorio.EmpresaRepositorio;
import edu.uoc.facturacion.util.ConstantesUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio Empresa
 * @author Christian Juiña
 */
@Service
public class EmpresaServicio {

    private EmpresaRepositorio empresaRepositorio;

    @Autowired
    public void setInjectedBean(EmpresaRepositorio empresaRepositorio) {
        this.empresaRepositorio = empresaRepositorio;
    }

    @PersistenceContext
    private EntityManager em;

    /**
     * Método que guarda el objeto Empresa.
     * @param empresa objeto Empresa
     */
    public void guardar(Empresa empresa) {
        empresaRepositorio.save(empresa);
    }

    /**
     * Método que obtiene una Empresa por n�mero de ruc.
     * @param ruc RUC de la empresa
     * @return Empresa
     */
    public Empresa obtenerPorRuc(String ruc) {
        String consulta = "SELECT e FROM Empresa e WHERE e.ruc = :ruc AND e.activo = :activo";
        TypedQuery<Empresa> query = em.createQuery(consulta, Empresa.class);
        query.setParameter("ruc", ruc);
        query.setParameter("activo", ConstantesUtil.ESTADO_ACTIVO_S);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return  null;
        }
    }
}
