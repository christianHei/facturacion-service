package edu.uoc.facturacion.modelo.acceso;

import edu.uoc.facturacion.modelo.facturacion.Auditoria;
import edu.uoc.facturacion.modelo.facturacion.Empresa;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Entidad de la tabla FAC_USUARIO
 * @author Christian Juiña
 */
@Entity
@Table(name = "FAC_USUARIO")
public class Usuario extends Auditoria<Usuario> implements Serializable {
    private static final long serialVersionUID = 5117023193819598942L;

    @Id
    @SequenceGenerator(name = "seq_fac_usuario", sequenceName = "seq_fac_usuario", allocationSize = 1)
    @GeneratedValue(generator = "seq_fac_usuario", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @NotNull
    private String email;

    @NotNull
    private String clave;

    @NotNull
    @Column(length = 1)
    private String activo;

    @OneToOne
    @JoinColumn(name="id_empresa", foreignKey = @ForeignKey(name = "empresa_2_pk"))
    @RestResource(exported = false)
    private Empresa empresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}
