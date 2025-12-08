package util;

public class Util {

    public static String toTitleCase(String str) {
        if (str == null || str.isBlank()) {
            return str;
        }

        String[] words = str.trim().split(" ");
        StringBuilder result = new StringBuilder();

        for (String w : words) {
            if (w.isEmpty()) continue;
        result.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1).toLowerCase()).append(" ");
        }
        return result.toString();
    }
}
