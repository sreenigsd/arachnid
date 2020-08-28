package com.gsd.sreenidhi.arachnid.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gsd.sreenidhi.arachnid.proxy.Proxy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Pooled Proxy Object
 * 
 * @author sreenidhi.gsd@gmail.com
 */

public class ProxyUtils {

	private static final Logger logger = LoggerFactory.getLogger(ProxyUtils.class);

	public static boolean validateProxy(Proxy p) {
		Socket socket = null;
		try {
			socket = new Socket();
			InetSocketAddress endpointSocketAddr = new InetSocketAddress(p.getHost(), p.getPort());
			socket.connect(endpointSocketAddr, 3000);
			return true;
		} catch (IOException e) {
			logger.warn("FAILRE - cannot connect!  remote: " + p);
			return false;
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					logger.warn("Error occurred while closing socket of validating proxy", e);
				}
			}
		}

	}

}
