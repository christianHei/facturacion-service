package edu.uoc.facturacion.servicio;

import edu.uoc.facturacion.modelo.facturacion.Factura;
import edu.uoc.facturacion.to.ImpresionTo;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;

/**
 * 
 * @author Christian Juiña
 */
@Service
public class ReporteServicio implements Serializable {

	private static final long serialVersionUID = -5452652084432646382L;

	public ByteArrayDataSource pdf(Factura factura, String reporte) {
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("FACTURA", factura);
			InputStream urlJasper = new ClassPathResource("reporte/" + reporte).getInputStream();
			// ejecutar el reporte
			JasperPrint jasperPrint = JasperFillManager.fillReport(urlJasper, param);
			//return JasperExportManager.exportReportToPdf(jasperPrint);/

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
			return new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
