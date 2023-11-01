package com.jkf.channel.gateway.wrapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 获取返回数据
 * The class LoggingHttpServletResponseWrapper.
 *
 * Description:
 *
 * @author: lixiangyu
 * @since: 2018年11月16日
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
public class LoggingByteArrayHttpServletResponseWrapper extends HttpServletResponseWrapper {

	private LoggingByteArrayServletOutputStream outputStream;
	private ByteArrayOutputStream byteArrayOutputStream;

	public LoggingByteArrayHttpServletResponseWrapper(HttpServletResponse response, ByteArrayOutputStream byteArrayOutputStream) {
		super(response);
		this.byteArrayOutputStream = byteArrayOutputStream;
	}

	@Override
	public void setContentType(String type) {
		super.setContentType(type);
	}

	@Override
	public void addHeader(String name, String value) {
		super.addHeader(name, value);
	}

	@Override
	public void setHeader(String name, String value) {
		super.setHeader(name, value);
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return outputStream = new LoggingByteArrayServletOutputStream(super.getOutputStream(), byteArrayOutputStream);
	}

	@Override
	public void reset() {
		super.reset();
	}

	@Override
	public String toString() {
		return (outputStream != null) ? outputStream.toString() : "";
	}

}
