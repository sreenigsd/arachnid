package com.gsd.sreenidhi.arachnid.pipeline;

import org.junit.BeforeClass;
import org.junit.Test;
import com.gsd.sreenidhi.arachnid.Request;
import com.gsd.sreenidhi.arachnid.ResultItems;
import com.gsd.sreenidhi.arachnid.Site;
import com.gsd.sreenidhi.arachnid.Task;

import java.util.UUID;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class FilePipelineTest {

    private static ResultItems resultItems;
    private static Task task;

    @BeforeClass
    public static void before() {
        resultItems = new ResultItems();
        resultItems.put("content", "arachnid");
        Request request = new Request("https://www.github.com");
        resultItems.setRequest(request);

        task = new Task() {
            @Override
            public String getUUID() {
                return UUID.randomUUID().toString();
            }

            @Override
            public Site getSite() {
                return null;
            }
        };
    }
    @Test
    public void testProcess() {
        FilePipeline filePipeline = new FilePipeline();
        filePipeline.process(resultItems, task);
    }
}
