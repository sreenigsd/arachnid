package com.gsd.sreenidhi.arachnid.processor;

import com.gsd.sreenidhi.arachnid.Page;
import com.gsd.sreenidhi.arachnid.Site;

/**
 * Interface to be implemented to customize a crawler.<br>
 * <br>
 * In PageProcessor, you can customize:
 * <br>
 * start urls and other settings in {@link Site}<br>
 * how the urls to fetch are detected               <br>
 * how the data are extracted and stored             <br>
 *
 * @author sreenidhi.gsd@gmail.com <br>
 * @see Site
 * @see Page
 * 
 */
public interface PageProcessor {

    /**
     * process the page, extract urls to fetch, extract the data and store
     *
     * @param page page
     */
    public void process(Page page);

    /**
     * get the site settings
     *
     * @return site
     * @see Site
     */
    public Site getSite();
}
