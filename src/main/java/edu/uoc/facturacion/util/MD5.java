package edu.uoc.facturacion.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	public static String hash(String cadena) {
		if (cadena == null) {
			return null;
		}
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(cadena.getBytes());
			return hexadecimal(md.digest());
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Error creando MessageDigest");
			return null;
		}
	}

	private static String hexadecimal(byte[] bytes) {
		StringBuffer buffer = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if (((int) bytes[i] & 0xff) < 0x10) {
				buffer.append("0");
			}
			buffer.append(Long.toString((int) bytes[i] & 0xff, 16));
		}
		return buffer.toString();
	}	
}
