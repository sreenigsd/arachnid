package com.gsd.sreenidhi.arachnid.model;

import org.junit.Test;
import com.gsd.sreenidhi.arachnid.Page;
import com.gsd.sreenidhi.arachnid.Request;
import com.gsd.sreenidhi.arachnid.model.annotation.ExtractBy;
import com.gsd.sreenidhi.arachnid.model.annotation.HelpUrl;
import com.gsd.sreenidhi.arachnid.model.annotation.TargetUrl;
import com.gsd.sreenidhi.arachnid.selector.PlainText;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sreenidhi.gsd@gmail.com
 * @date 14-4-4
 */
public class ModelPageProcessorTest {

    private PageMocker pageMocker = new PageMocker();

    @TargetUrl("http://sreenidhi-gsd.com/foo")
    public static class ModelFoo {

        @ExtractBy(value = "//div/@foo", notNull = true)
        private String foo;

    }

    @TargetUrl("http://sreenidhi-gsd.com/bar")
    public static class ModelBar {

        @ExtractBy(value = "//div/@bar", notNull = true)
        private String bar;

    }

    @TargetUrl(value = "http://sreenigsd.com/foo/\\d+",sourceRegion = "//li[@class='bar']")
    @HelpUrl(value = "http://sreenidhi-gsd.com/bar/\\d+",sourceRegion = "//li[@class='foo']")
    public static class MockModel {

    }

    @Test
    public void testMultiModel_should_not_skip_when_match() throws Exception {
        Page page = new Page();
        page.setRawText("<div foo='foo'></div>");
        page.setRequest(new Request("http://sreenidhi-gsd.com/foo"));
        page.setUrl(PlainText.create("http://sreenidhi-gsd.com/foo"));
        ModelPageProcessor modelPageProcessor = ModelPageProcessor.create(null, ModelFoo.class, ModelBar.class);
        modelPageProcessor.process(page);
        assertThat(page.getResultItems().isSkip()).isFalse();
    }

    @Test
    public void testExtractLinks() throws Exception {
        ModelPageProcessor modelPageProcessor = ModelPageProcessor.create(null, MockModel.class);
        Page page = pageMocker.getMockPage();
        modelPageProcessor.process(page);
        assertThat(page.getTargetRequests()).containsExactly(new Request("http://sreenidhi-gsd.com/bar/3"), new Request("http://sreenidhi-gsd.com/bar/4"), new Request("http://sreenidhi-gsd.com/foo/3"), new Request("http://sreenidhi-gsd.com/foo/4"));
    }

    @Test
    public void testExtractNoLinks() throws Exception {
        ModelPageProcessor modelPageProcessor = ModelPageProcessor.create(null, MockModel.class);
        Page page = pageMocker.getMockPage();
        modelPageProcessor.setExtractLinks(false);
        modelPageProcessor.process(page);
        assertThat(page.getTargetRequests()).isEmpty();
    }


}
