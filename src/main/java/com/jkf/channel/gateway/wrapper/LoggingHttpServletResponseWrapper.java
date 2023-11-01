package com.jkf.channel.gateway.wrapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

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
public class LoggingHttpServletResponseWrapper extends HttpServletResponseWrapper {

	private LoggingServletOutputStream mOutputStream;

	public LoggingHttpServletResponseWrapper(HttpServletResponse response, StringBuilder log) {
		super(response);
		mLog = log;
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
		return mOutputStream = new LoggingServletOutputStream(super.getOutputStream(), mLog);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		return new PrintWriter(new LoggingWriter(super.getWriter(), mLog));
	}

	@Override
	public void reset() {
		//mLog.debug("[Reset]\n");
		super.reset();
	}

	@Override
	public String toString() {
		return (mOutputStream != null) ? mOutputStream.toString() : "";
	}

	private StringBuilder mLog;
}
