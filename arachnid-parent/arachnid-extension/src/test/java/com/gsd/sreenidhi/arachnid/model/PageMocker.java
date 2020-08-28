package com.gsd.sreenidhi.arachnid.model;

import org.apache.commons.io.IOUtils;
import com.gsd.sreenidhi.arachnid.Page;
import com.gsd.sreenidhi.arachnid.Request;
import com.gsd.sreenidhi.arachnid.selector.PlainText;

import java.io.IOException;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class PageMocker {

    public Page getMockJsonPage() throws IOException {
        Page page = new Page();
        page.setRawText(IOUtils.toString(PageMocker.class.getClassLoader().getResourceAsStream("json/mock-githubrepo.json")));
        page.setRequest(new Request("https://api.github.com/repos/sreenigsd/arachnid"));
        page.setUrl(new PlainText("https://api.github.com/repos/sreenigsd/arachnid"));
        return page;
    }

    public Page getMockPage() throws IOException {
        Page page = new Page();
        page.setRawText(IOUtils.toString(PageMocker.class.getClassLoader().getResourceAsStream("html/mockarachnid.html")));
        page.setRequest(new Request("http://github.com/sreenigsd/arachnid/list/0"));
        page.setUrl(new PlainText("http://github.com/sreenigsd/arachnid/list/0"));
        return page;
    }
}
