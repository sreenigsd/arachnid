package com.gsd.sreenidhi.arachnid.model;

import com.gsd.sreenidhi.arachnid.Site;
import com.gsd.sreenidhi.arachnid.model.annotation.ExtractBy;
import com.gsd.sreenidhi.arachnid.model.annotation.HelpUrl;
import com.gsd.sreenidhi.arachnid.model.annotation.TargetUrl;

/**
 * @author sreenidhi.gsd@gmail.com 
 */
@TargetUrl("https://github.com/\\w+/\\w+")
@HelpUrl({"https://github.com/\\w+\\?tab=repositories", "https://github.com/\\w+", "https://github.com/explore/*"})
public class GithubRepo extends BaseRepo{

    @ExtractBy("//ul[@class='pagehead-actions']/li[2]//a[@class='social-count']/text()")
    private int fork;

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(100)
                , new ConsolePageModelPipeline(), GithubRepo.class)
                .addUrl("https://github.com/sreenigsd").thread(10).run();
    }

    public int getStar() {
        return star;
    }

    public int getFork() {
        return fork;
    }
}
