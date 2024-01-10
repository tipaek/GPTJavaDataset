package com.yeshj.pacman.utils;

import org.apache.commons.lang3.StringUtils;

public final class NumericHelper {

	public static int safeParseInt(String str) {
		return safeParseInt(str, 0);
	}

	public static int safeParseInt(String str, int defaultValue) {
		try {
			defaultValue = Integer.parseInt(str);
		} catch (NumberFormatException ignored) {
		}
		return defaultValue;
	}

	public static boolean isNumeric(String str) {
		return StringUtils.isNumeric(str);
	}
}
