package com.gsd.sreenidhi.arachnid.downloader;

import org.apache.commons.io.IOUtils;
import com.gsd.sreenidhi.arachnid.Page;
import com.gsd.sreenidhi.arachnid.Request;
import com.gsd.sreenidhi.arachnid.Task;
import com.gsd.sreenidhi.arachnid.selector.PlainText;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class MockGithubDownloader implements Downloader {

    @Override
    public Page download(Request request, Task task) {
        Page page = new Page();
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/html/mock-github.html");
        try {
            page.setRawText(IOUtils.toString(resourceAsStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        page.setRequest(new Request("https://github.com/sreenigsd/arachnid"));
        page.setUrl(new PlainText("https://github.com/sreenigsd/arachnid"));
        return page;
    }

    @Override
    public void setThread(int threadNum) {
    }
}
