package com.soundcenter.soundcenter.lib.util;

public class StringUtil {

	public static String cutForUdp(String string) {
		if (string.length() > 23) {
			return string.substring(0, 23);
		}
		return string;
	}
	
}
