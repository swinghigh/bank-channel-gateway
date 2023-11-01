package com.jkf.channel.gateway.wrapper;

/**
 * Created by nmcmd on 16/6/13.
 */
import java.io.FilterWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggingWriter extends FilterWriter {

	//private StringBuilder buffer;
	public LoggingWriter(PrintWriter writer, StringBuilder log) {

		super(writer);
		//buffer = new StringBuilder();
		mLog = log;
	}

	@Override
	public void write(char cbuf[], int off, int len) throws IOException {

		//mLog.debug(new String(cbuf, off, len));
		char[] dest = new char[len];
		System.arraycopy(cbuf, off, dest, 0, len);
		mLog.append(dest);

		super.write(cbuf, off, len);
	}

	@Override
	public void write(String str, int off, int len) throws IOException {

		mLog.append(str.substring(off, off + len));
		//mLog.debug(str.substring(off, off + len));
		super.write(str, off, len);
	}

	public String getContent() {
		return mLog.toString();
	}

	private StringBuilder mLog;
}