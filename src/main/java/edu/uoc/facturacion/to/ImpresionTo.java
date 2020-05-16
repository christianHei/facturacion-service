package edu.uoc.facturacion.to;

import edu.uoc.facturacion.modelo.facturacion.Factura;
import edu.uoc.facturacion.modelo.facturacion.FacturaDetalle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Juiña
 */
public class ImpresionTo implements Serializable {

	private static final long serialVersionUID = -7462907646843134983L;

	public ImpresionTo impresionTo = this;
	public Factura factura = new Factura();

	public ImpresionTo() {
		super();
	}

	public ImpresionTo(Factura factura) {
		super();
		this.factura = factura;
	}

	public ImpresionTo getImpresionTo() {
		return impresionTo;
	}

	public void setImpresionTo(ImpresionTo impresionTo) {
		this.impresionTo = impresionTo;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
}
