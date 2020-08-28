package com.gsd.sreenidhi.arachnid.monitor;

import org.junit.Test;
import com.gsd.sreenidhi.arachnid.Page;
import com.gsd.sreenidhi.arachnid.Site;
import com.gsd.sreenidhi.arachnid.Spider;
import com.gsd.sreenidhi.arachnid.processor.PageProcessor;

import javax.management.JMException;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class SeedUrlWithPortTest {

    @Test
    public void testSeedUrlWithPort() throws JMException {
        Spider spider = Spider.create(new TempProcessor()).addUrl("http://www.hndpf.org:8889/");
        SpiderMonitor.instance().register(spider);
        spider.run();
    }
}

class TempProcessor implements PageProcessor {

    @Override
    public void process(Page page) {

    }

    @Override
    public Site getSite() {
        return Site.me();
    }
}
