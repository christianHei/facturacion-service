package edu.uoc.facturacion.modelo.facturacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entidad de la tabla FAC_PARAMETRO
 * @author Christian Juiña
 */
@Entity
@Table(name = "FAC_PARAMETRO")
public class Parametro implements Serializable {
    private static final long serialVersionUID = -4764641341955087729L;

    @Id
    @SequenceGenerator(name = "seq_fac_parametro", sequenceName = "seq_fac_parametro", allocationSize = 1)
    @GeneratedValue(generator = "seq_fac_parametro", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private String valor;

    private String descripcion;

    public Parametro() {

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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
