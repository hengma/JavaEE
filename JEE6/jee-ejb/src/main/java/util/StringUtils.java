package util;

public class StringUtils {

	public static String nullIfEmpty(String str) {
		if("".equals(str)) {
			return null;
		} else {
			return str;
		}
	}
}
