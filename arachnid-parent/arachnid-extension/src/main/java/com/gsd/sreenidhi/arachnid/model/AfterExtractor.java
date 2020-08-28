package com.gsd.sreenidhi.arachnid.model;

import com.gsd.sreenidhi.arachnid.Page;

/**
 * Interface to be implemented by page models that need to do something after fields are extracted.<br>
 *
 * @author sreenidhi.gsd@gmail.com 
 */
public interface AfterExtractor {

    public void afterProcess(Page page);
}
