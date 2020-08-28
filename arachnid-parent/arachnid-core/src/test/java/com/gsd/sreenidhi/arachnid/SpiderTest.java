package com.gsd.sreenidhi.arachnid;

import org.junit.Ignore;
import org.junit.Test;
import com.gsd.sreenidhi.arachnid.downloader.Downloader;
import com.gsd.sreenidhi.arachnid.pipeline.Pipeline;
import com.gsd.sreenidhi.arachnid.processor.PageProcessor;
import com.gsd.sreenidhi.arachnid.processor.SimplePageProcessor;
import com.gsd.sreenidhi.arachnid.scheduler.Scheduler;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class SpiderTest {

    @Ignore("long time")
    @Test
    public void testStartAndStop() throws InterruptedException {
        Spider spider = Spider.create(new SimplePageProcessor( "https://www.sreenidhi-gsd.com/*")).addPipeline(new Pipeline() {
            @Override
            public void process(ResultItems resultItems, Task task) {
                System.out.println(1);
            }
        }).thread(1).addUrl("https://www.sreenidhi-gsd.com/");
        spider.start();
        Thread.sleep(10000);
        spider.stop();
        Thread.sleep(10000);
        spider.start();
        Thread.sleep(10000);
    }

    @Ignore("long time")
    @Test
    public void testWaitAndNotify() throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            System.out.println("round " + i);
            testRound();
        }
    }

    private void testRound() {
        Spider spider = Spider.create(new PageProcessor() {

            private AtomicInteger count = new AtomicInteger();

            @Override
            public void process(Page page) {
                page.setSkip(true);
            }

            @Override
            public Site getSite() {
                return Site.me().setSleepTime(0);
            }
        }).setDownloader(new Downloader() {
            @Override
            public Page download(Request request, Task task) {
                return new Page().setRawText("");
            }

            @Override
            public void setThread(int threadNum) {

            }
        }).setScheduler(new Scheduler() {

            private AtomicInteger count = new AtomicInteger();

            private Random random = new Random();

            @Override
            public void push(Request request, Task task) {

            }

            @Override
            public synchronized Request poll(Task task) {
                if (count.incrementAndGet() > 1000) {
                    return null;
                }
                if (random.nextInt(100)>90){
                    return null;
                }
                return new Request("test");
            }
        }).thread(10);
        spider.run();
    }
}
