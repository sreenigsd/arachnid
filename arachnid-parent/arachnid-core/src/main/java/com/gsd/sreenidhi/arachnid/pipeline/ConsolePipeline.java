package com.gsd.sreenidhi.arachnid.pipeline;

import com.gsd.sreenidhi.arachnid.ResultItems;
import com.gsd.sreenidhi.arachnid.Task;

import java.util.Map;

/**
 * Write results in console.<br>
 * Usually used in test.
 *
 * @author sreenidhi.gsd@gmail.com 
 */
public class ConsolePipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        System.out.println("get page: " + resultItems.getRequest().getUrl());
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            System.out.println(entry.getKey() + ":\t" + entry.getValue());
        }
    }
}
