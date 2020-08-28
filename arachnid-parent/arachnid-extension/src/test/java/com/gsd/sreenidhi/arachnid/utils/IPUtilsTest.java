package com.gsd.sreenidhi.arachnid.utils;

import org.junit.Test;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class IPUtilsTest {

    @Test
    public void testGetFirstNoLoopbackIPAddresses() throws Exception {
        System.out.println(IPUtils.getFirstNoLoopbackIPAddresses());
    }
}
