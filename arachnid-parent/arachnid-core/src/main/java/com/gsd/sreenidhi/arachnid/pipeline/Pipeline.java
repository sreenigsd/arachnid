package com.gsd.sreenidhi.arachnid.pipeline;

import com.gsd.sreenidhi.arachnid.ResultItems;
import com.gsd.sreenidhi.arachnid.Task;

/**
 * Pipeline is the persistent and offline process part of crawler.<br>
 * The interface Pipeline can be implemented to customize ways of persistent.
 *
 * @author sreenidhi.gsd@gmail.com 
 * @see ConsolePipeline
 * @see FilePipeline
 */
public interface Pipeline {

    /**
     * Process extracted results.
     *
     * @param resultItems resultItems
     * @param task task
     */
    public void process(ResultItems resultItems, Task task);
}
