package edu.uoc.facturacion.modelo.facturacion;

import edu.uoc.facturacion.modelo.acceso.Usuario;
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
 * Entidad de la tabla FAC_PRODUCTO
 * @author Christian Juiña
 */
@Entity
@Table(name = "FAC_PRODUCTO")
public class Producto extends Auditoria<Usuario> implements Serializable {
    private static final long serialVersionUID = -6355528466584098555L;

    @Id
    @SequenceGenerator(name = "seq_fac_producto", sequenceName = "seq_fac_producto", allocationSize = 1)
    @GeneratedValue(generator = "seq_fac_producto", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String codigo;

    @NotNull
    private String descripcion;

    @NotNull
    private Double precio;

    @OneToOne
    @JoinColumn(name="id_empresa", nullable = false, foreignKey = @ForeignKey(name = "empresa_2_pk"))
    @RestResource(exported = false)
    private Empresa empresa;

    @NotNull
    @Column(length = 1)
    private String eliminado;

    public Producto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getEliminado() {
        return eliminado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
    }
}
