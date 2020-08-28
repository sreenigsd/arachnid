package com.gsd.sreenidhi.arachnid.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import com.gsd.sreenidhi.arachnid.Task;
import com.gsd.sreenidhi.arachnid.pipeline.PageModelPipeline;

/**
 * Print page model in console.<br>
 * Usually used in test.<br>
 * @author sreenidhi.gsd@gmail.com 
 */
public class ConsolePageModelPipeline implements PageModelPipeline {
    @Override
    public void process(Object o, Task task) {
        System.out.println(ToStringBuilder.reflectionToString(o));
    }
}
