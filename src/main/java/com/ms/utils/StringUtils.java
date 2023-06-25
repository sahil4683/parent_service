package com.ms.utils;
public class StringUtils {

    // Method to check if a string is null or empty
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    // Method to check if a string is null, empty, or consists only of whitespace
    public static boolean isNullOrWhitespace(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Method to reverse a string
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    // Method to count the occurrences of a character in a string
    public static int countOccurrences(String str, char c) {
        if (str == null) {
            return 0;
        }
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }

    // Method to truncate a string to a specified length and append ellipsis if necessary
    public static String truncateWithEllipsis(String str, int maxLength) {
        if (str == null || str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength) + "...";
    }

    // Method to convert a string to title case
    public static String toTitleCase(String str) {
        if (isNullOrWhitespace(str)) {
            return str;
        }
        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!isNullOrWhitespace(word)) {
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1).toLowerCase());
                result.append(" ");
            }
        }
        return result.toString().trim();
    }

    // Method to remove all occurrences of a specified substring from a string
    public static String removeSubstring(String str, String substring) {
        if (isNullOrWhitespace(str) || isNullOrWhitespace(substring)) {
            return str;
        }
        return str.replace(substring, "");
    }

    // Method to pad a string with a specified character to a specified length
    public static String padString(String str, int length, char paddingChar) {
        if (isNullOrWhitespace(str) || length <= str.length()) {
            return str;
        }
        StringBuilder padded = new StringBuilder(str);
        while (padded.length() < length) {
            padded.append(paddingChar);
        }
        return padded.toString();
    }

    // Additional utility methods can be added here

}
