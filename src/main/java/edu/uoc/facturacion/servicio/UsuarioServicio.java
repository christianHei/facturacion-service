package edu.uoc.facturacion.servicio;

import com.google.common.collect.Lists;
import edu.uoc.facturacion.modelo.acceso.Usuario;
import edu.uoc.facturacion.repositorio.UsuarioRepositorio;
import edu.uoc.facturacion.util.ConstantesUtil;
import edu.uoc.facturacion.util.MD5;

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
public class UsuarioServicio {

    private UsuarioRepositorio usuarioRepositorio;
    private EmpresaServicio empresaServicio;

    @Autowired
    public void setInjectedBean(EmpresaServicio empresaServicio, UsuarioRepositorio usuarioRepositorio) {
        this.empresaServicio = empresaServicio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @PersistenceContext
    private EntityManager em;

    public List<Usuario> obtenerTodo(){
        return Lists.newArrayList(usuarioRepositorio.findAll());
    }

    /**
     * Método que guarda el objeto Usuario.
     * @param usuario objeto Usuario.
     */
    public void guardar(Usuario usuario) {
        usuario.getEmpresa().setActivo(ConstantesUtil.ESTADO_ACTIVO_S);
        empresaServicio.guardar(usuario.getEmpresa());
        usuario.setActivo(ConstantesUtil.ESTADO_ACTIVO_S);
        usuario.setClave(MD5.hash(usuario.getClave()));
        usuarioRepositorio.save(usuario);
    }

    /**
     * Método que obtiene un Usuario por nombre de usuario, clave y empresa al cual pertenece.
     * @param nombreUsuario nombre de usuario.
     * @param clave clave de usuario.
     * @param ruc RUC de la empresa al que pertenece el usuario.
     * @return Usuario
     */
    public Usuario obtenerPorNombreUsuarioClaveRucEmpresa(String nombreUsuario, String clave, String ruc) {
        String consulta = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario AND u.clave = :clave AND u.empresa.ruc = :ruc " +
                "AND u.activo = :activo";
        TypedQuery<Usuario> query = em.createQuery(consulta, Usuario.class);
        query.setParameter("nombreUsuario", nombreUsuario);
        query.setParameter("clave", MD5.hash(clave));
        query.setParameter("ruc", ruc);
        query.setParameter("activo", ConstantesUtil.ESTADO_ACTIVO_S);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return  null;
        }
    }

    /**
     * Método que obtiene un Usuario por nombre de usuario y clave.
     * @param nombreUsuario nombre de usuario.
     * @param clave clave de usuario.
     * @return Usuario
     */
    public Usuario obtenerPorNombreUsuarioClave(String nombreUsuario, String clave) {
        String consulta = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario AND u.clave = :clave AND u.activo = :activo";
        TypedQuery<Usuario> query = em.createQuery(consulta, Usuario.class);
        query.setParameter("nombreUsuario", nombreUsuario);
        query.setParameter("clave", MD5.hash(clave));
        query.setParameter("activo", ConstantesUtil.ESTADO_ACTIVO_S);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return  null;
        }
    }

    /**
     * Método que obtiene un Usuario por email.
     * @param email email de usuario.
     * @return Usuario
     */
    public Usuario obtenerPorEmail(String email) {
        String consulta = "SELECT u FROM Usuario u WHERE u.email = :email";
        TypedQuery<Usuario> query = em.createQuery(consulta, Usuario.class);
        query.setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return  null;
        }
    }

    /**
     * Método que obtiene un Usuario por nombre de usuario.
     * @param nombreUsuario nombre de usuario.
     * @return Usuario
     */
    public Usuario obtenerPorNombreUsuario(String nombreUsuario) {
        String consulta = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario";
        TypedQuery<Usuario> query = em.createQuery(consulta, Usuario.class);
        query.setParameter("nombreUsuario", nombreUsuario);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return  null;
        }
    }
}
