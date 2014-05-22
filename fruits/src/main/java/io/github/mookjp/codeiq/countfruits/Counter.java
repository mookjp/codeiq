package io.github.mookjp.codeiq.countfruits;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 */
public class Counter {

    public String origText;

    public String[] delimiterList = {"(", "[", "{"};

    public Counter(String text) {
        origText = text;
    }

    public int count() {
        int totalCount = 0;
        for (String delimiter : delimiterList) {
            int groupCount = getGroupCount(origText, delimiter);
            totalCount = groupCount > totalCount ? groupCount : totalCount;
        }
        return totalCount;
    }

    public static String getBuddy(String delimiter) {
        if (delimiter.equals("[")) return "]";
        if (delimiter.equals("(")) return ")";
        if (delimiter.equals("{")) return "}";
        return null;
    }

    public static String getRegex(String delimiter) {
        String closeDelimiter = getBuddy(delimiter);

        return String.format("\\%s(.+?)\\%s", delimiter, closeDelimiter);
    }

    public int getGroupCount(String text, String delimiter) {
        Pattern pattern = Pattern.compile(getRegex(delimiter));
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        if (matcher.find()) {
            int newCount = getGroupCount(matcher.group(1), delimiter);
            if (newCount > count) count = newCount;
        } else if (text.length() != origText.length()) {
            count = getFruitsCount(text);
        }
        return count;
    }

    public static int getFruitsCount(String text) {
        Pattern pattern = Pattern.compile("([a-z]+)");
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while(matcher.find()) {
            count++;
        }

        return count;
    }
}
