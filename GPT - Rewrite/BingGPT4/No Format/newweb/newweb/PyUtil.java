package com.newweb.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

public class PyUtil {

    private static final HanyuPinyinOutputFormat FORMAT;

    static {
        FORMAT = new HanyuPinyinOutputFormat();
        FORMAT.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        FORMAT.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        FORMAT.setVCharType(HanyuPinyinVCharType.WITH_V);
    }

    public static String getPinYin(String src) {
        StringBuilder result = new StringBuilder();
        for (char c : src.toCharArray()) {
            try {
                if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
                    result.append(PinyinHelper.toHanyuPinyinStringArray(c, FORMAT)[0]);
                } else {
                    result.append(c);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }

    public static String getPinYinHeadChar(String str) {
        StringBuilder convert = new StringBuilder();
        for (char word : str.toCharArray()) {
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word, FORMAT);
            if (pinyinArray != null) {
                convert.append(pinyinArray[0].charAt(0));
            } else {
                convert.append(word);
            }
        }
        return convert.toString();
    }

    public static String getCnASCII(String cnStr) {
        StringBuilder strBuf = new StringBuilder();
        for (byte b : cnStr.getBytes()) {
            strBuf.append(Integer.toHexString(b & 0xff));
        }
        return strBuf.toString();
    }
}
