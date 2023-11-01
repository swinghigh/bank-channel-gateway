package com.jkf.channel.gateway.wrapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by nmcmd on 16/6/13.
 */

public class LoggingByteArrayServletOutputStream extends ServletOutputStream {

	public LoggingByteArrayServletOutputStream(ServletOutputStream outputStream, ByteArrayOutputStream byteArrayOutputStream) {
		this.superOutputStream = outputStream;
		this.byteArrayOutputStream = byteArrayOutputStream;
	}

	@Override
	public void write(int b) throws IOException {
		superOutputStream.write(b);
		byteArrayOutputStream.write(b);
	}

	@Override
	public void write(byte b[], int off, int len) throws IOException {
		superOutputStream.write(b, off, len);
		byteArrayOutputStream.write(b, off, len);
	}

	@Override
	public String toString() {
		//16进制
		StringBuffer sb = new StringBuffer("[");
		byte[] array = byteArrayOutputStream.toByteArray();
		for (int i = 0; i < array.length; i++) {
			String val = Integer.toHexString(array[i] & 0xFF);
			if (val.length() == 0) {
				val = "0" + val;
			}
			sb.append(val).append(",");
		}
		return sb.delete(sb.length() - 1, sb.length()).append("]").toString();
	}

	private ServletOutputStream superOutputStream;

	private ByteArrayOutputStream byteArrayOutputStream;

	@Override
	public boolean isReady() {
		return false;

	}

	@Override
	public void setWriteListener(WriteListener writeListener) {

	}
}