package com.gsd.sreenidhi.arachnid.downloader;

import java.net.URI;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** *Support post 302 jump strategy implementation class 
 * HttpClient default jump: httpClientBuilder.setRedirectStrategy(new LaxRedirectStrategy()); 
 * The above code will not transmit the original requested data information in the case of post/redirect/post. 
 * So refer to the redirection strategy of SeimiCrawler. 
 * */
public class CustomRedirectStrategy extends LaxRedirectStrategy {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public HttpUriRequest getRedirect(HttpRequest request, HttpResponse response, HttpContext context) throws ProtocolException {
        URI uri = getLocationURI(request, response, context);
        String method = request.getRequestLine().getMethod();
        if ("post".equalsIgnoreCase(method)) {
            try {
                HttpRequestWrapper httpRequestWrapper = (HttpRequestWrapper) request;
                httpRequestWrapper.setURI(uri);
                httpRequestWrapper.removeHeaders("Content-Length");
                return httpRequestWrapper;
            } catch (Exception e) {
                logger.error("Error converting to HttpRequestWrapper");
            }
            return new HttpPost(uri);
        } else {
            return new HttpGet(uri);
        }
    }
}
