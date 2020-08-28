package com.gsd.sreenidhi.arachnid;

import org.junit.Test;
import com.gsd.sreenidhi.arachnid.utils.HttpConstant;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sreenidhi.gsd@gmail.com
 *         Date: 17/3/11
 */
public class RequestTest {

    @Test
    public void testEqualsAndHashCode() throws Exception {
        Request requestA = new Request("http://www.google.com/");
        Request requestB = new Request("http://www.google.com/");
        assertThat(requestA.hashCode()).isEqualTo(requestB.hashCode());
        assertThat(requestA).isEqualTo(requestB);
        requestA.setMethod(HttpConstant.Method.GET);
        requestA.setMethod(HttpConstant.Method.POST);
        assertThat(requestA).isNotEqualTo(requestB);
        assertThat(requestA.hashCode()).isNotEqualTo(requestB.hashCode());
    }
}
