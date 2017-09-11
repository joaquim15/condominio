package br.com.intera.util;

import java.text.MessageFormat;

public class StringUtils {

	public static String formatMessage(String message, Object... parameters) {
		if (message != null && parameters != null) {
			MessageFormat messageFormat = new MessageFormat(message);
			message = messageFormat.format(parameters, new StringBuffer(), null).toString();
		}
		return message;
	}
}
