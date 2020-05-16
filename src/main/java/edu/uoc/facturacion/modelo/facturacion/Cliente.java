package edu.uoc.facturacion.modelo.facturacion;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Entidad de la tabla FAC_CLIENTE
 * @author Christian Juiña
 */
@Entity
@Table(name = "FAC_CLIENTE")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 814027279583001327L;

    @Id
    @SequenceGenerator(name = "seq_fac_cliente", sequenceName = "seq_fac_cliente", allocationSize = 1)
    @GeneratedValue(generator = "seq_fac_cliente", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    private String telefono;

    private String celular;

    @NotNull
    private String email;

    @NotNull
    private String direccion;

    @OneToOne
    @JoinColumn(name="id_empresa", foreignKey = @ForeignKey(name = "empresa_2_pk"))
    private Empresa empresa;

    @OneToMany(mappedBy = "cliente")
    private List<Identificacion> listaIdentificaciones;

    public Cliente() {

    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Identificacion> getListaIdentificaciones() {
        return listaIdentificaciones;
    }

    public void setListaIdentificaciones(List<Identificacion> listaIdentificaciones) {
        this.listaIdentificaciones = listaIdentificaciones;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
