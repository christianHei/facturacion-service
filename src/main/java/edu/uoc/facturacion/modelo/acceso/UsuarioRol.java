package edu.uoc.facturacion.modelo.acceso;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entidad de la tabla FAC_USUARIO_ROL
 * @author Christian Juiña
 */
@Entity
@Table(name = "FAC_USUARIO_ROL")
public class UsuarioRol implements Serializable {
    private static final long serialVersionUID = 910728416233448244L;

    @Id
    @SequenceGenerator(name = "seq_fac_usuario_rol", sequenceName = "seq_fac_usuario_rol", allocationSize = 1)
    @GeneratedValue(generator = "seq_fac_usuario_rol", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "usuario_2_pk"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false, foreignKey = @ForeignKey(name = "rol_2_pk"))
    private Rol rol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
