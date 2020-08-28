package com.gsd.sreenidhi.arachnid.downloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gsd.sreenidhi.arachnid.Page;
import com.gsd.sreenidhi.arachnid.Request;
import com.gsd.sreenidhi.arachnid.Task;
import com.gsd.sreenidhi.arachnid.selector.PlainText;

import java.io.*;

/**
 * this downloader is used to download pages which need to render the javascript
 *
 * @author sreenidhi.gsd@gmail.com
 */
public class PhantomJSDownloader extends AbstractDownloader {

    private static Logger logger = LoggerFactory.getLogger(PhantomJSDownloader.class);
    private static String crawlJsPath;
    private static String phantomJsCommand = "phantomjs"; // default

    private int retryNum;
    private int threadNum;

    public PhantomJSDownloader() {
        this.initPhantomjsCrawlPath();
    }
    
    /**
     * Add new constructor, support phantomjs custom command
     *
     * example:
     * phantomjs.exe supports windows environment
     * phantomjs --ignore-ssl-errors=yes ignore some errors when the crawling address is https
     * The absolute path of the /usr/local/bin/phantomjs command to avoid IOException caused by system environment variables
     *
     * @param phantomJsCommand phantomJsCommand
     */
    public PhantomJSDownloader(String phantomJsCommand) {
        this.initPhantomjsCrawlPath();
        PhantomJSDownloader.phantomJsCommand = phantomJsCommand;
    }
    
    /**
    * Added a new constructor to support crawl.js path customization, 
    * because when other projects rely on this jar package, runtime.exec() does not use crawl.js in the jar package 
    * when executing the phantomjs command   
    * <pre>
     * crawl.js start --
     * 
     *   var system = require('system');
     *   var url = system.args[1];
     *   
     *   var page = require('webpage').create();
     *   page.settings.loadImages = false;
     *   page.settings.resourceTimeout = 5000;
     *   
     *   page.open(url, function (status) {
     *       if (status != 'success') {
     *           console.log("HTTP request failed!");
     *       } else {
     *           console.log(page.content);
     *       }
     *   
     *       page.close();
     *       phantom.exit();
     *   });
     *   
     * -- crawl.js end
     * </pre>
     * For specific projects, you can copy the above js code to use
     *   
     * example:
     *    new PhantomJSDownloader("/your/path/phantomjs", "/your/path/crawl.js");
     * 
     * @param phantomJsCommand phantomJsCommand
     * @param crawlJsPath crawlJsPath
     */
    public PhantomJSDownloader(String phantomJsCommand, String crawlJsPath) {
      PhantomJSDownloader.phantomJsCommand = phantomJsCommand;
      PhantomJSDownloader.crawlJsPath = crawlJsPath;
    }
    
    private void initPhantomjsCrawlPath() {
        PhantomJSDownloader.crawlJsPath = new File(this.getClass().getResource("/").getPath()).getPath() + System.getProperty("file.separator") + "crawl.js ";
    }

    @Override
    public Page download(Request request, Task task) {
        if (logger.isInfoEnabled()) {
            logger.info("downloading page: " + request.getUrl());
        }
        String content = getPage(request);
        if (content.contains("HTTP request failed")) {
            for (int i = 1; i <= getRetryNum(); i++) {
                content = getPage(request);
                if (!content.contains("HTTP request failed")) {
                    break;
                }
            }
            if (content.contains("HTTP request failed")) {
                //when failed
                Page page = new Page();
                page.setRequest(request);
                return page;
            }
        }

        Page page = new Page();
        page.setRawText(content);
        page.setUrl(new PlainText(request.getUrl()));
        page.setRequest(request);
        page.setStatusCode(200);
        return page;
    }

    @Override
    public void setThread(int threadNum) {
        this.threadNum = threadNum;
    }

    protected String getPage(Request request) {
        try {
            String url = request.getUrl();
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(phantomJsCommand + " " + crawlJsPath + " " + url);
            InputStream is = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                stringBuffer.append(line).append("\n");
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int getRetryNum() {
        return retryNum;
    }

    public PhantomJSDownloader setRetryNum(int retryNum) {
        this.retryNum = retryNum;
        return this;
    }
}
