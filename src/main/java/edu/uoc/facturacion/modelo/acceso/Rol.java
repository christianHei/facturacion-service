package edu.uoc.facturacion.modelo.acceso;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entidad de la tabla FAC_ROL
 * @author Christian Juiña
 */
@Entity
@Table(name = "FAC_ROL")
public class Rol implements Serializable {
    private static final long serialVersionUID = -1589095020130886039L;

    @Id
    @SequenceGenerator(name = "seq_fac_rol", sequenceName = "seq_fac_rol", allocationSize = 1)
    @GeneratedValue(generator = "seq_fac_rol", strategy = GenerationType.SEQUENCE)
    private Long id;

    private int codigo;

    private String desripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDesripcion() {
        return desripcion;
    }

    public void setDesripcion(String desripcion) {
        this.desripcion = desripcion;
    }
}
