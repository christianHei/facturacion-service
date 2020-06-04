package edu.uoc.facturacion.to;

import edu.uoc.facturacion.modelo.facturacion.Factura;
import edu.uoc.facturacion.modelo.facturacion.FacturaDetalle;

import java.util.List;

/**
 * @author Christian Juiña
 */
public class ImpresionTo {

	private ImpresionTo impresionTo = this;
	private Factura factura = new Factura();
	private List<FacturaDetalle> listaFacturaDetalle;

	public ImpresionTo() {
		super();
	}

	public ImpresionTo(Factura factura, List<FacturaDetalle> listaFacturaDetalle) {
		super();
		this.factura = factura;
		this.listaFacturaDetalle = listaFacturaDetalle;
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

	public List<FacturaDetalle> getListaFacturaDetalle() {
		return listaFacturaDetalle;
	}

	public void setListaFacturaDetalle(List<FacturaDetalle> listaFacturaDetalle) {
		this.listaFacturaDetalle = listaFacturaDetalle;
	}
}
