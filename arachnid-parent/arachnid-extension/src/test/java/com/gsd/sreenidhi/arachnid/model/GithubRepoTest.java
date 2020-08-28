package com.gsd.sreenidhi.arachnid.model;

import org.junit.Test;
import com.gsd.sreenidhi.arachnid.Site;
import com.gsd.sreenidhi.arachnid.Task;
import com.gsd.sreenidhi.arachnid.downloader.MockGithubDownloader;
import com.gsd.sreenidhi.arachnid.example.GithubRepo;
import com.gsd.sreenidhi.arachnid.pipeline.PageModelPipeline;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sreenidhi.gsd@gmail.com <br>
 */
public class GithubRepoTest {

    @Test
    public void test() {
        OOSpider.create(Site.me().setSleepTime(0)
                , new PageModelPipeline<GithubRepo>() {
            @Override
            public void process(GithubRepo o, Task task) {
                assertThat(o.getStar()).isEqualTo(86);
                assertThat(o.getFork()).isEqualTo(70);
            }
        }, GithubRepo.class).addUrl("https://github.com/sreenigsd/arachnid").setDownloader(new MockGithubDownloader()).test("https://github.com/sreenigsd/arachnid");
    }

}
