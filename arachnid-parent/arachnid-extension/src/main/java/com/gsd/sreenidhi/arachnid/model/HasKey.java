package com.gsd.sreenidhi.arachnid.model;

import com.gsd.sreenidhi.arachnid.utils.Experimental;

/**
 * Interface to be implemented by page mode.<br>
 * Can be used to identify a page model, or be used as name of file storing the object.<br>
 * @author sreenidhi.gsd@gmail.com 
 */
@Experimental
public interface HasKey {

    /**
     *
     *
     * @return key
     */
    public String key();
}
