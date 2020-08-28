package com.gsd.sreenidhi.arachnid.handler;

import com.gsd.sreenidhi.arachnid.Page;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public interface SubPageProcessor extends RequestMatcher {

	/**
	 * process the page, extract urls to fetch, extract the data and store
	 *
	 * @param page page
	 *
	 * @return whether continue to match
	 */
	public MatchOther processPage(Page page);

}
