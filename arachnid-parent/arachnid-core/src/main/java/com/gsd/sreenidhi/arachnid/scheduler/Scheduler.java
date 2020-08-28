package com.gsd.sreenidhi.arachnid.scheduler;

import com.gsd.sreenidhi.arachnid.Request;
import com.gsd.sreenidhi.arachnid.Task;

/**
 * Scheduler is the part of url management.<br>
 * You can implement interface Scheduler to do:
 * manage urls to fetch
 * remove duplicate urls
 *
 * @author sreenidhi.gsd@gmail.com 
 */
public interface Scheduler {

    /**
     * add a url to fetch
     *
     * @param request request
     * @param task task
     */
    public void push(Request request, Task task);

    /**
     * get an url to crawl
     *
     * @param task the task of spider
     * @return the url to crawl
     */
    public Request poll(Task task);

}
