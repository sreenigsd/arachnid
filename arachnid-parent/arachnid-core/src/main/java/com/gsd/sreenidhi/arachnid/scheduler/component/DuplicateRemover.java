package com.gsd.sreenidhi.arachnid.scheduler.component;

import com.gsd.sreenidhi.arachnid.Request;
import com.gsd.sreenidhi.arachnid.Task;

/**
 * Remove duplicate requests.
 * @author sreenidhi.gsd@gmail.com
 */
public interface DuplicateRemover {
    /**
     *
     * Check whether the request is duplicate.
     *
     * @param request request
     * @param task task
     * @return true if is duplicate
     */
    public boolean isDuplicate(Request request, Task task);

    /**
     * Reset duplicate check.
     * @param task task
     */
    public void resetDuplicateCheck(Task task);

    /**
     * Get TotalRequestsCount for monitor.
     * @param task task
     * @return number of total request
     */
    public int getTotalRequestsCount(Task task);

}
