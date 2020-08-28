package com.gsd.sreenidhi.arachnid.monitor;

import com.gsd.sreenidhi.arachnid.Spider;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class CustomSpiderStatus extends SpiderStatus implements CustomSpiderStatusMXBean {

    public CustomSpiderStatus(Spider spider, SpiderMonitor.MonitorSpiderListener monitorSpiderListener) {
        super(spider, monitorSpiderListener);
    }


    @Override
    public String getSchedulerName() {
        return spider.getScheduler().getClass().getName();
    }
}
