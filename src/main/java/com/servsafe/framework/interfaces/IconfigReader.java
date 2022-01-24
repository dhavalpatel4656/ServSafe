
package com.servsafe.framework.interfaces;

import com.servsafe.framework.configuration.browser.BrowserType;

public interface IconfigReader {
	public BrowserType getBrowser();

	public String getURL();

	public int getPageLoadTimeOut();

	public int getImplicitWait();

	public int getExplicitWait();

	public int getPollingTime();

	public String getGmailID();

	public String getGmailPassword();

	public String getGmailHost();

	public String getGmailStoreType();

	public String getCartURL();

}
