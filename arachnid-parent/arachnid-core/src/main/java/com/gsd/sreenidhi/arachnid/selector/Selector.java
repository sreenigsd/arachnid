package com.gsd.sreenidhi.arachnid.selector;

import java.util.List;

/**
 * Selector(extractor) for text.<br>
 *
 * @author sreenidhi.gsd@gmail.com 
 */
public interface Selector {

    /**
     * Extract single result in text.<br>
     * If there are more than one result, only the first will be chosen.
     *
     * @param text text
     * @return result
     */
    public String select(String text);

    /**
     * Extract all results in text.<br>
     *
     * @param text text
     * @return results
     */
    public List<String> selectList(String text);

}
