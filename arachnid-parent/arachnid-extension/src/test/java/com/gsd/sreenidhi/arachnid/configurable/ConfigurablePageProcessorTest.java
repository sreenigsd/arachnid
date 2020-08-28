package com.gsd.sreenidhi.arachnid.configurable;

import org.junit.Test;
import com.gsd.sreenidhi.arachnid.ResultItems;
import com.gsd.sreenidhi.arachnid.Site;
import com.gsd.sreenidhi.arachnid.Spider;
import com.gsd.sreenidhi.arachnid.downloader.MockGithubDownloader;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sreenidhi.gsd@gmail.com
 * @date 14-4-5
 */
public class ConfigurablePageProcessorTest {

    @Test
    public void test() throws Exception {
        List<ExtractRule> extractRules = new ArrayList<ExtractRule>();
        ExtractRule extractRule = new ExtractRule();
        extractRule.setExpressionType(ExpressionType.XPath);
        extractRule.setExpressionValue("//title");
        extractRule.setFieldName("title");
        extractRules.add(extractRule);
        extractRule = new ExtractRule();
        extractRule.setExpressionType(ExpressionType.XPath);
        extractRule.setExpressionValue("//ul[@class='pagehead-actions']/li[1]//a[@class='social-count js-social-count']/text()");
        extractRule.setFieldName("star");
        extractRules.add(extractRule);
        ResultItems resultItems = Spider.create(new ConfigurablePageProcessor(Site.me(), extractRules))
                .setDownloader(new MockGithubDownloader()).get("https://github.com/sreengsd/arachnid");
        assertThat(resultItems.getAll()).containsEntry("title", "<title>sreenigsd/arachnid · GitHub</title>");
        assertThat(resultItems.getAll()).containsEntry("star", " 86 ");

    }
}
