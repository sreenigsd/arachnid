package com.gsd.sreenidhi.arachnid.downloader;

import org.junit.Test;
import com.gsd.sreenidhi.arachnid.Page;
import com.gsd.sreenidhi.arachnid.Request;
import com.gsd.sreenidhi.arachnid.Site;
import com.gsd.sreenidhi.arachnid.Task;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class SSLCompatibilityTest {

    @Test
    public void test_tls12() throws Exception {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        Task task = Site.me().setCycleRetryTimes(5).toTask();
        Request request = new Request("https://github.com/");
        Page page = httpClientDownloader.download(request, task);
        assertThat(page.isDownloadSuccess()).isTrue();
    }
}
