package com.gsd.sreenidhi.arachnid.model;

import com.gsd.sreenidhi.arachnid.model.annotation.ExtractBy;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class BaseRepo {

    @ExtractBy("//ul[@class='pagehead-actions']/li[1]//a[@class='social-count js-social-count']/text()")
    protected int star;
}
