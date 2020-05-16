package edu.uoc.facturacion.modelo.facturacion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Entidad de la tabla FAC_FACTURA
 * @author Christian Juiña
 */
@Entity
@Table(name = "FAC_FACTURA")
public class Factura implements Serializable {
    private static final long serialVersionUID = -6811878053330117708L;

    @Id
    @SequenceGenerator(name = "seq_fac_factura", sequenceName = "seq_fac_factura", allocationSize = 1)
    @GeneratedValue(generator = "seq_fac_factura", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "numero_factura")
    private String numeroFactura;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    private Double subtotal;

    private Double subtotalIva;

    private Double iva;

    private Double total;

    @ManyToOne
    @JoinColumn(name="id_cliente", foreignKey = @ForeignKey(name = "cliente_2_pk"))
    private Cliente cliente;

    @OneToMany(mappedBy = "factura")
    private List<FacturaDetalle> listaFacturaDetalle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getSubtotalIva() {
        return subtotalIva;
    }

    public void setSubtotalIva(Double subtotalIva) {
        this.subtotalIva = subtotalIva;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<FacturaDetalle> getListaFacturaDetalle() {
        return listaFacturaDetalle;
    }

    public void setListaFacturaDetalle(List<FacturaDetalle> listaFacturaDetalle) {
        this.listaFacturaDetalle = listaFacturaDetalle;
    }
}
