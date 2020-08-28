package com.gsd.sreenidhi.arachnid.monitor;

import org.junit.Test;
import com.gsd.sreenidhi.arachnid.Spider;
import com.gsd.sreenidhi.arachnid.processor.example.GithubRepoPageProcessor;
import com.gsd.sreenidhi.arachnid.processor.example.ZhihuPageProcessor;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class SpiderMonitorTest {

    @Test
    public void testInherit() throws Exception {
        SpiderMonitor spiderMonitor = new SpiderMonitor(){
            @Override
            protected SpiderStatusMXBean getSpiderStatusMBean(Spider spider, MonitorSpiderListener monitorSpiderListener) {
                return new CustomSpiderStatus(spider, monitorSpiderListener);
            }
        };

        Spider sreeSpider = Spider.create(new ZhihuPageProcessor())
                .addUrl("http://my.oschina.net/flashsword/blog").thread(2);
        Spider githubSpider = Spider.create(new GithubRepoPageProcessor())
                .addUrl("https://github.com/sreenigsd");

        spiderMonitor.register(zhihuSpider, githubSpider);

    }
}
