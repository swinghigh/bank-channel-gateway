package com.jkf.channel.gateway.wrapper;

/**
 * Created by nmcmd on 16/6/13.
 */

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;

public class LoggingServletOutputStream extends ServletOutputStream {

	//StringBuilder stringBuilder;
	public LoggingServletOutputStream(ServletOutputStream outputStream, StringBuilder log) {

		mOutputStream = outputStream;
		//this.stringBuilder = new StringBuilder();
		mLog = log;
	}

	@Override
	public void write(int b) throws IOException {
		mOutputStream.write(b);
		mLog.append(new String(new byte[] { (byte) b }, "UTF-8"));
	}

	@Override
	public void write(byte b[], int off, int len) throws IOException {
		mOutputStream.write(b, off, len);
		mLog.append(new String(b, off, len, "UTF-8"));
	}

	@Override
	public String toString() {
		return mLog.toString();
	}

	private ServletOutputStream mOutputStream;

	//private ByteArrayOutputStream mOutputStream2;
	private StringBuilder mLog;

	@Override
	public boolean isReady() {
		// TODO
		return false;

	}

	@Override
	public void setWriteListener(WriteListener writeListener) {
		// TODO

	}
}