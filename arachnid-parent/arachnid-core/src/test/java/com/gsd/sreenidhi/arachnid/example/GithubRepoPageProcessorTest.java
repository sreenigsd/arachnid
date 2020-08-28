package com.gsd.sreenidhi.arachnid.example;

import org.junit.Test;
import com.gsd.sreenidhi.arachnid.ResultItems;
import com.gsd.sreenidhi.arachnid.Spider;
import com.gsd.sreenidhi.arachnid.Task;
import com.gsd.sreenidhi.arachnid.downloader.MockGithubDownloader;
import com.gsd.sreenidhi.arachnid.pipeline.Pipeline;
import com.gsd.sreenidhi.arachnid.processor.example.GithubRepoPageProcessor;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class GithubRepoPageProcessorTest {

    @Test
    public void test_github() throws Exception {
        Spider.create(new GithubRepoPageProcessor()).addPipeline(new Pipeline() {
            @Override
            public void process(ResultItems resultItems, Task task) {
                assertThat(((String) resultItems.get("name")).trim()).isEqualTo("arachnid");
                assertThat(((String) resultItems.get("author")).trim()).isEqualTo("sreenigsd");
            }
        }).setDownloader(new MockGithubDownloader()).test("https://github.com/sreenigsd/arachnid");
    }
}
