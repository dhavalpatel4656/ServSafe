package com.servsafe.framework.configreader;

import java.util.Properties;

import com.servsafe.framework.interfaces.IconfigReader;
import com.servsafe.framework.utility.ResourceHelper;

public class PropertyFileReader implements IconfigReader {

	private Properties prop = null;

	public PropertyFileReader() {
		prop = new Properties();
		try {
			prop.load(ResourceHelper.getResourcePathInputStream("configfile/" + "config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public com.servsafe.framework.configuration.browser.BrowserType getBrowser() {
		return com.servsafe.framework.configuration.browser.BrowserType.valueOf(prop.getProperty("Browser"));
	}

	public String getWaitTime() {
		String time = prop.getProperty("wait.explicit.seconds");
		if (time != null)
			return time;
		else
			throw new RuntimeException("Time  is  not specified in the Configuration.properties file.");

	}

	@Override
	public String getURL() {
		return prop.getProperty("URL");
	}

	@Override
	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	@Override
	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplicitWait"));
	}

	@Override
	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	@Override
	public int getPollingTime() {
		return Integer.parseInt(prop.getProperty("PollingTime"));
	}

	@Override
	public String getGmailID() {
		return prop.getProperty("GmailID");
	}

	@Override
	public String getGmailPassword() {
		return prop.getProperty("GmailPassword");
	}

	@Override
	public String getGmailHost() {
		return prop.getProperty("GmailHost");
	}

	@Override
	public String getGmailStoreType() {
		return prop.getProperty("GmailStoreType");
	}

	@Override
	public String getCartURL() {
		return prop.getProperty("CartURL");
		}

}
