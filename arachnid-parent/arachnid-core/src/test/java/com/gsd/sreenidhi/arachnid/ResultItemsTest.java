package com.gsd.sreenidhi.arachnid;

import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class ResultItemsTest {

    @Test
    public void testOrderOfEntries() throws Exception {
        ResultItems resultItems = new ResultItems();
        resultItems.put("a", "a");
        resultItems.put("b", "b");
        resultItems.put("c", "c");
        assertThat(resultItems.getAll().keySet()).containsExactly("a","b","c");

    }
}
