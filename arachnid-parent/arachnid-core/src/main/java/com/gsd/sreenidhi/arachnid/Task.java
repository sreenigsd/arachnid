package com.gsd.sreenidhi.arachnid;

/**
 * Interface for identifying different tasks.<br>
 *
 * @author sreenidhi.gsd@gmail.com 
 * @see com.gsd.sreenidhi.arachnid.scheduler.Scheduler
 * @see com.gsd.sreenidhi.arachnid.pipeline.Pipeline
 */
public interface Task {

    /**
     * unique id for a task.
     *
     * @return uuid
     */
    public String getUUID();

    /**
     * site of a task
     *
     * @return site
     */
    public Site getSite();

}
