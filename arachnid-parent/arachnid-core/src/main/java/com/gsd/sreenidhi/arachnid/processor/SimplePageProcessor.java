package com.gsd.sreenidhi.arachnid.processor;

import com.gsd.sreenidhi.arachnid.Page;
import com.gsd.sreenidhi.arachnid.Site;

import java.util.List;

/**
 * A simple PageProcessor.
 *
 * @author sreenidhi.gsd@gmail.com 
 */
public class SimplePageProcessor implements PageProcessor {

    private String urlPattern;

    private Site site;

    public SimplePageProcessor(String urlPattern) {
        this.site = Site.me();
        //compile "*" expression to regex
        this.urlPattern = "(" + urlPattern.replace(".", "\\.").replace("*", "[^\"'#]*") + ")";

    }

    @Override
    public void process(Page page) {
        List<String> requests = page.getHtml().links().regex(urlPattern).all();
        //add urls to fetch
        page.addTargetRequests(requests);
        //extract by XPath
        page.putField("title", page.getHtml().xpath("//title"));
        page.putField("html", page.getHtml().toString());
        //extract by Readability
        page.putField("content", page.getHtml().smartContent());
    }

    @Override
    public Site getSite() {
        //settings
        return site;
    }
}
