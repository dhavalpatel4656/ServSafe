package com.servsafe.framework.utility;

public class CommonHelper {
	public static String fetchOnlyDigits(String string) {
		return string.replaceAll("[^0-9]", "");
	}
}
