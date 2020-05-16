package edu.uoc.facturacion.modelo.facturacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entidad de la tabla FAC_TIPO_IDENTIFICACION
 * @author Christian Juiña
 */
@Entity
@Table(name = "FAC_TIPO_IDENTIFICACION")
public class TipoIdentificacion implements Serializable {
    private static final long serialVersionUID = -3157830153354221594L;

    @Id
    @SequenceGenerator(name = "seq_fac_tipo_identificacion", sequenceName = "seq_fac_tipo_identificacion", allocationSize = 1)
    @GeneratedValue(generator = "seq_fac_tipo_identificacion", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String tipo;

    private String descripcion;

    public TipoIdentificacion() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
