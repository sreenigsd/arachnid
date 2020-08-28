package com.gsd.sreenidhi.arachnid.scheduler;

import com.gsd.sreenidhi.arachnid.Task;

/**
 * The scheduler whose requests can be counted for monitor.
 *
 * @author sreenidhi.gsd@gmail.com
 */
public interface MonitorableScheduler extends Scheduler {

    public int getLeftRequestsCount(Task task);

    public int getTotalRequestsCount(Task task);

}