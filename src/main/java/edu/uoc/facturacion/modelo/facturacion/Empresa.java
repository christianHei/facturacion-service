package edu.uoc.facturacion.modelo.facturacion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Entidad de la tabla FAC_EMPRESA
 * @author Christian Juiña
 */
@Entity
@Table(name = "FAC_EMPRESA")
public class Empresa implements Serializable {
    private static final long serialVersionUID = -8759948226227112720L;

    @Id
    @SequenceGenerator(name = "seq_fac_empresa", sequenceName = "seq_fac_empresa", allocationSize = 1)
    @GeneratedValue(generator = "seq_fac_empresa", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 13)
    private String ruc;

    @NotNull
    private String razonSocial;

    @NotNull
    private String telefono;

    private String celular;

    @NotNull
    private String direccion;

    @NotNull
    @Column(length = 1)
    private String activo;

    public Empresa() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}
