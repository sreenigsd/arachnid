package com.gsd.sreenidhi.arachnid;

/**
 * Listener of Spider on page processing. Used for monitor and such on.
 *
 * @author sreenidhi.gsd@gmail.com
 */
public interface SpiderListener {

    public void onSuccess(Request request);

    public void onError(Request request);
}
