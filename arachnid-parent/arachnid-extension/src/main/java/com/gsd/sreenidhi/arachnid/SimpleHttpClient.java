package com.gsd.sreenidhi.arachnid;

import com.gsd.sreenidhi.arachnid.downloader.HttpClientDownloader;
import com.gsd.sreenidhi.arachnid.model.PageMapper;
import com.gsd.sreenidhi.arachnid.proxy.ProxyProvider;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class SimpleHttpClient {

    private final HttpClientDownloader httpClientDownloader;

    private final Site site;

    public SimpleHttpClient() {
        this(Site.me());
    }

    public SimpleHttpClient(Site site) {
        this.site = site;
        this.httpClientDownloader = new HttpClientDownloader();
    }

    public void setProxyProvider(ProxyProvider proxyProvider){
        this.httpClientDownloader.setProxyProvider(proxyProvider);
    }

    public <T> T get(String url, Class<T> clazz) {
        return get(new Request(url), clazz);
    }

    public <T> T get(Request request, Class<T> clazz) {
        Page page = httpClientDownloader.download(request, site.toTask());
        if (!page.isDownloadSuccess()) {
            return null;
        }
        return new PageMapper<T>(clazz).get(page);
    }

    public Page get(String url) {
        return httpClientDownloader.download(new Request(url), site.toTask());
    }

    public Page get(Request request) {
        return httpClientDownloader.download(request, site.toTask());
    }

}
