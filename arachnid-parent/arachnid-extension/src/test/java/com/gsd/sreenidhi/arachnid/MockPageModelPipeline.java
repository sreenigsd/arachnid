package com.gsd.sreenidhi.arachnid;

import junit.framework.Assert;
import com.gsd.sreenidhi.arachnid.pipeline.PageModelPipeline;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class MockPageModelPipeline implements PageModelPipeline{
    @Override
    public void process(Object o, Task task) {
        Assert.assertNotNull(o);
    }
}
