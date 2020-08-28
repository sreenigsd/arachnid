package com.gsd.sreenidhi.arachnid.pipeline;

import java.util.List;

/**
 * Pipeline that can collect and store results. <br>
 * Used for {@link com.gsd.sreenidhi.arachnid.Spider#getAll(java.util.Collection)}
 *
 * @author sreenidhi.gsd@gmail.com
 */
public interface CollectorPipeline<T> extends Pipeline {

    /**
     * Get all results collected.
     *
     * @return collected results
     */
    public List<T> getCollected();
}
