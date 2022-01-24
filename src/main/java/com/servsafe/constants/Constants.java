
package com.servsafe.constants;

import java.io.File;

import com.servsafe.framework.settings.ObjectRepo;

public class Constants {
	public static final int WAIT_EXPLICIT_SEC = ObjectRepo.reader.getExplicitWait();
	public static final int WAIT_POLLING_MS = ObjectRepo.reader.getPollingTime();
	public static final int LOADER_WAIT = 90;
	public static final boolean IS_HEADLESS = Boolean.parseBoolean(System.getProperty("isHeadless"));
	public static final String DOWNLOAD_DIR = System.getProperty("user.dir") + File.separator + "downloads";
	public static final String prefix = "Automation_Test_";
	public static final int BalanceLimit = 200000;
	public static int loginCounter = 0;
	public static String uploadPath = System.getProperty("user.dir") + "/src/main/resources/uploads/";
	public static String email;
	public static String password = "Automation@2022";
	public static String lastProduct;
}