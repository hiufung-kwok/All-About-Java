package com.util.logging;

import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Custom formatter for used in Java.Util.Formatter
 *
 */
public class SimpleFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("[" +  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(record.getMillis()) + "]-"  );
		sb.append(record.getLevel()).append(":   ");
		sb.append(record.getMessage()).append('\n');
		return sb.toString();
	}

}
