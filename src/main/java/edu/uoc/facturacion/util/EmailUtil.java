package edu.uoc.facturacion.util;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.lang3.CharEncoding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * @author Christian Juiña
 */
public class EmailUtil {
	
    private static JavaMailSenderImpl mailSender;

	private static final Logger log = LogManager.getLogger(EmailUtil.class);

	public static void enviarEmail(String asunto, String mensaje, String para, ByteArrayDataSource comprobante) {
		try {
			Properties properties = new Properties();
	    	properties.put("mail.smtp.host", ConstantesUtil.EMAIL_HOST);
	    	properties.put("mail.smtp.port", ConstantesUtil.EMAIL_PORT);
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.starttls.required", "true");
	    	properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.socketFactory.fallback", "false");

			if (mailSender == null) {
				mailSender = new JavaMailSenderImpl();
			}
			mailSender.setUsername(ConstantesUtil.EMAIL_USUARIO);
			mailSender.setPassword(ConstantesUtil.EMAIL_PASSWORD);
			mailSender.setJavaMailProperties(properties);

			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, CharEncoding.UTF_8);

			message.setFrom(ConstantesUtil.EMAIL_USUARIO);
			message.setTo(para);
			message.setSubject(asunto);
			message.setText(mensaje,true);

			if (comprobante != null) {
				message.addAttachment("comprobante-electrónico.pdf", comprobante);
			}

			mailSender.send(mimeMessage);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public static boolean esEmail(String correo) {
		Pattern pat = null;
		Matcher mat = null;
		pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
		mat = pat.matcher(correo);
		if (mat.find()) {
			return true;
		}else{
			return false;
		}
	}
}
