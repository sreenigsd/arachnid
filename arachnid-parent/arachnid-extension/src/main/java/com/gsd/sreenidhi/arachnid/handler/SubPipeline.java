package com.gsd.sreenidhi.arachnid.handler;

import com.gsd.sreenidhi.arachnid.ResultItems;
import com.gsd.sreenidhi.arachnid.Task;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public interface SubPipeline extends RequestMatcher {

    /**
     * process the page, extract urls to fetch, extract the data and store
     *
     * @param resultItems resultItems
     * @param task task
     * @return whether continue to match
     */
    public MatchOther processResult(ResultItems resultItems, Task task);

}
