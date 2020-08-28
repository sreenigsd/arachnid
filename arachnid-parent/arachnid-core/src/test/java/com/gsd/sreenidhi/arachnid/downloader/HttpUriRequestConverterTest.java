package com.gsd.sreenidhi.arachnid.downloader;

import org.junit.Test;
import com.gsd.sreenidhi.arachnid.Request;
import com.gsd.sreenidhi.arachnid.Site;
import com.gsd.sreenidhi.arachnid.utils.UrlUtils;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class HttpUriRequestConverterTest {

    @Test
    public void test_illegal_uri_correct() throws Exception {
        HttpUriRequestConverter httpUriRequestConverter = new HttpUriRequestConverter();
        HttpClientRequestContext requestContext = httpUriRequestConverter.convert(new Request(UrlUtils.fixIllegalCharacterInUrl("https://github.com/##")), Site.me(), null);
        assertThat(requestContext.getHttpUriRequest().getURI()).isEqualTo(new URI("http://github.com/#"));
    }
}