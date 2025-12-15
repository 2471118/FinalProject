package util;

public class Util {

    /**
     * changes the string to titlecase
     * @param str the targeted string
     * @return the string in titlecase
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) return str;

        String[] words = str.trim().split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (w.isEmpty()) continue;

            String formatted =
                    Character.toUpperCase(w.charAt(0)) +
                            w.substring(1).toLowerCase();

            result.append(formatted);
            if (i < words.length - 1) result.append(" ");
        }
        return result.toString();
    }
}
