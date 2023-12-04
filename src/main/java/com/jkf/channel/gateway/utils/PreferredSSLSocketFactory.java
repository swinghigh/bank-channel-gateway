package com.jkf.channel.gateway.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;

/**
	 * @Author qazhang
	 * @Description SSL网关如果配置为单向通信时，客户端应该配置套件"TLS_SM2PKEA_SM2DSA_WITH_SM4_CBC_SM3"优先（不应该配置双向套件"TLS_ECDHE_SM2DSA_WITH_SM4_CBC_SM3"）
	 *              客户端单向通信时如果配置套件顺序为"TLS_ECDHE_SM2DSA_WITH_SM4_CBC_SM3","TLS_SM2PKEA_SM2DSA_WITH_SM4_CBC_SM3"，则将客户导致SSL网关握手失败。（有时成功，有时失败）
	 * @CodeReviewer liujiancheng
	 *
	 */
public class PreferredSSLSocketFactory extends SSLSocketFactory {

		private static final Logger logger = LoggerFactory.getLogger("ssl.socketFactory");

		private final SSLSocketFactory delegate;

		private String[] defaultCipherSuites;

		private String[] supportedCipherSuites;

		public PreferredSSLSocketFactory(SSLSocketFactory delegate) {
			this.delegate = delegate;
			this.defaultCipherSuites = new String[] { "TLS_SM2PKEA_SM2DSA_WITH_SM4_CBC_SM3" };
			this.supportedCipherSuites = new String[] { "TLS_ECDHE_SM2DSA_WITH_SM4_CBC_SM3" };
			System.err.println("EnabledCipherSuites: " + Arrays.asList(supportedCipherSuites));

		}

		public void setEnabledCipherSuites(String[] enabledCipherSuites) {
			if (enabledCipherSuites == null || enabledCipherSuites.length == 0) {
				throw new SecurityException("enabledCipherSuites is null or length==0");
			}
			this.defaultCipherSuites = enabledCipherSuites.clone();
			this.supportedCipherSuites = enabledCipherSuites.clone();
			System.err.println("EnabledCipherSuites: " + Arrays.asList(supportedCipherSuites));
		}

		@Override
		public String[] getDefaultCipherSuites() {
			return defaultCipherSuites;
		}

		@Override
		public String[] getSupportedCipherSuites() {
			return supportedCipherSuites;
		}

		@Override
		public Socket createSocket(String host, int port) throws IOException {
			logger.debug("createSocket#1 running...");
			Socket socket = this.delegate.createSocket(host, port);
			((SSLSocket) socket).setEnabledCipherSuites(defaultCipherSuites);
			logger.debug("createSocket#1 finished");
			return socket;
		}

		@Override
		public Socket createSocket(InetAddress host, int port) throws IOException {
			logger.debug("createSocket#2 running...");
			Socket socket = this.delegate.createSocket(host, port);
			((SSLSocket) socket).setEnabledCipherSuites(defaultCipherSuites);
			logger.debug("createSocket#2 finished");
			return socket;
		}

		@Override
		public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
			logger.debug("createSocket#3 running...");
			Socket socket = this.delegate.createSocket(s, host, port, autoClose);
			((SSLSocket) socket).setEnabledCipherSuites(defaultCipherSuites);
			logger.debug("createSocket#3 finished");
			return socket;
		}

		@Override
		public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
			logger.debug("createSocket#4 running...");
			Socket socket = this.delegate.createSocket(host, port, localHost, localPort);
			((SSLSocket) socket).setEnabledCipherSuites(defaultCipherSuites);
			logger.debug("createSocket#4 finished");
			return socket;
		}

		@Override
		public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
			logger.debug("createSocket#5 running...");
			Socket socket = this.delegate.createSocket(address, port, localAddress, localPort);
			((SSLSocket) socket).setEnabledCipherSuites(defaultCipherSuites);
			logger.debug("createSocket#5 finished");
			return socket;
		}

	}