package utils;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BaseUtils {
    public static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    public static String removeAccents(String input) {
        if (input == null || input.length() < 1) {
            return "";
        }
        return (StringUtils.replaceChars(StringUtils.replaceChars(StringUtils.stripAccents(input), (char) 273, (char) 100), (char) 272, (char) 68));
    }

   
}
