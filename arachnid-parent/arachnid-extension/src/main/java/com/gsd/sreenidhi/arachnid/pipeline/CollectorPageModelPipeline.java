package com.gsd.sreenidhi.arachnid.pipeline;

import com.gsd.sreenidhi.arachnid.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class CollectorPageModelPipeline<T> implements PageModelPipeline<T> {

    private List<T> collected = new ArrayList<T>();

    @Override
    public synchronized void process(T t, Task task) {
        collected.add(t);
    }

    public List<T> getCollected() {
        return collected;
    }
}
