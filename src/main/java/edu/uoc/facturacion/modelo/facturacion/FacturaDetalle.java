package edu.uoc.facturacion.modelo.facturacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entidad de la tabla FAC_FACTURA_DETALLE
 * @author Christian Juiña
 */
@Entity
@Table(name = "FAC_FACTURA_DETALLE")
public class FacturaDetalle implements Serializable {
    private static final long serialVersionUID = -2026735195817468243L;

    @Id
    @SequenceGenerator(name = "seq_fac_factura_detalle", sequenceName = "seq_fac_factura_detalle", allocationSize = 1)
    @GeneratedValue(generator = "seq_fac_factura_detalle", strategy = GenerationType.SEQUENCE)
    private Long id;

    private int cantidad;

    private Double precio;

    @ManyToOne
    @JoinColumn(name="id_producto", nullable = false, foreignKey = @ForeignKey(name = "producto_2_pk"))
    @RestResource(exported = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name="id_factura", nullable = false, foreignKey = @ForeignKey(name = "factura_2_pk"))
    @RestResource(exported = false)
    private Factura factura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
