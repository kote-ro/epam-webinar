package com.epam.task3;

public class Part3 {

    public static void main(String[] args) {
        convert("When I was younger I never needed");
    }

    public static String convert(String input) {
        StringBuilder sb = new StringBuilder();
        for (String s : input.split(" ")) {
            StringBuilder word = new StringBuilder(s);
            if (word.length() >= 3){
                char c = s.charAt(0);
                if (Character.isUpperCase(c)) c = Character.toLowerCase(c);
                else c = Character.toUpperCase(c);
                word = word.replace(0, 1, String.valueOf(c));
            }
            sb.append(word + " ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
