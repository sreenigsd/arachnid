package com.gsd.sreenidhi.arachnid.handler;

import com.gsd.sreenidhi.arachnid.Request;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public interface RequestMatcher {

    /**
     * Check whether to process the page.<br><br>
     * Please DO NOT change page status in this method.
     *
     * @param page page
     *
     * @return whether matches
     */
    public boolean match(Request page);

    public enum MatchOther {
        YES, NO
    }
}
