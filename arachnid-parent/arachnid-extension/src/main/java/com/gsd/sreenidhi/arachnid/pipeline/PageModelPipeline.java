package com.gsd.sreenidhi.arachnid.pipeline;

import com.gsd.sreenidhi.arachnid.Task;

/**
 * Implements PageModelPipeline to persistent your page model.
 *
 * @author sreenidhi.gsd@gmail.com 
 */
public interface PageModelPipeline<T> {

    public void process(T t, Task task);

}
