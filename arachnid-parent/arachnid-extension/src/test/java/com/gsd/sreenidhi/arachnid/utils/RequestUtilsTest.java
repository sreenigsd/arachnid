package com.gsd.sreenidhi.arachnid.utils;

import org.junit.Test;
import com.gsd.sreenidhi.arachnid.Request;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class RequestUtilsTest {

    @Test
    public void test_generate_range() throws Exception {
        List<Request> requests = RequestUtils.from("http://angularjs.com/api/article/latest?p=[1-3]&s=20");
        assertThat(requests).containsExactly(new Request("http://angularjs.com/api/article/latest?p=1&s=20"), new Request("http://angularjs.com/api/article/latest?p=2&s=20"), new Request("http://angularjs.com/api/article/latest?p=3&s=20"));
    }

    @Test
    public void test_generate_range_when_invalid_number() throws Exception {
        List<Request> requests = RequestUtils.from("http://angularjs.com/api/article/latest?p=[10-3]&s=20");
        assertThat(requests).isEmpty();
    }
}
