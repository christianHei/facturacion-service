package edu.uoc.facturacion.modelo.facturacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Entidad de la tabla FAC_IDENTIFICACION
 * @author Christian Juiña
 */
@Entity
@Table(name = "FAC_IDENTIFICACION")
public class Identificacion implements Serializable {
    private static final long serialVersionUID = -7579107082801111348L;

    @Id
    @SequenceGenerator(name = "seq_fac_identificacion", sequenceName = "seq_fac_identificacion", allocationSize = 1)
    @GeneratedValue(generator = "seq_fac_identificacion", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @RestResource(exported = false)
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "cliente_2_pk"))
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_identificacion", nullable = false, foreignKey = @ForeignKey(name = "tipo_identificacion_2_pk"))
    private TipoIdentificacion tipoIdentificacion;

    public Identificacion() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
}
