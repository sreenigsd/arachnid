package com.gsd.sreenidhi.arachnid.model;

import com.gsd.sreenidhi.arachnid.model.annotation.ExtractBy;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class GithubRepoApi {

    @ExtractBy(type = ExtractBy.Type.JsonPath, value = "$.name",source = ExtractBy.Source.RawText)
    private String name;

    public String getName() {
        return name;
    }
}
