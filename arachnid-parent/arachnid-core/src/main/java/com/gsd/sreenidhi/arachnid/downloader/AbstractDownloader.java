package com.gsd.sreenidhi.arachnid.downloader;

import com.gsd.sreenidhi.arachnid.Page;
import com.gsd.sreenidhi.arachnid.Request;
import com.gsd.sreenidhi.arachnid.Site;
import com.gsd.sreenidhi.arachnid.selector.Html;

/**
 * Base class of downloader with some common methods.
 *
 * @author sreenidhi.gsd@gmail.com
 * 
 */
public abstract class AbstractDownloader implements Downloader {

    /**
     * A simple method to download a url.
     *
     * @param url url
     * @return html
     */
    public Html download(String url) {
        return download(url, null);
    }

    /**
     * A simple method to download a url.
     *
     * @param url url
     * @param charset charset
     * @return html
     */
    public Html download(String url, String charset) {
        Page page = download(new Request(url), Site.me().setCharset(charset).toTask());
        return (Html) page.getHtml();
    }

    protected void onSuccess(Request request) {
    }

    protected void onError(Request request) {
    }

}
