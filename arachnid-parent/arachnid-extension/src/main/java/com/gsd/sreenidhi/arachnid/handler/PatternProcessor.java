package com.gsd.sreenidhi.arachnid.handler;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public abstract class PatternProcessor extends PatternRequestMatcher implements SubPipeline, SubPageProcessor {
    /**
     * @param pattern url pattern to handle
     */
    public PatternProcessor(String pattern) {
        super(pattern);
    }
}
