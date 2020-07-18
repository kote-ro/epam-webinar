package com.epam.task3;

import java.util.Random;

public class Part1 {

    public static void main(String[] args) {

    }

    private static String[] content(String input){
        String[] res = new String[3];

        int n = 0;
        int m = 0;

        for (int i = 0; i < 3; i++) {
            m = input.indexOf(';', n);
            if (m == -1) m = input.length();
            res[i] = input.substring(n, m);
            n = m + 1;
        }

        return res;
    }

    public static String convert1(String input) {

        StringBuilder sb = new StringBuilder();
        final String compareString = "Login;Name;Email";

        for (String s : input.split("\n")) {
            if (s.contentEquals(compareString)) continue;
            String[] o = content(s);
            sb.append(o[0] + ": " + o[2] + "\n");
        }

        return sb.toString();
    }

    public static String convert2(String input) {
        StringBuilder sb = new StringBuilder();
        final String compareString = "Login;Name;Email";

        for (String s : input.split("\n")) {
            if (s.contentEquals(compareString)) continue;
            String[] o = content(s);
            sb.append(o[1].substring(o[1].indexOf(' ') + 1));
            sb.append(' ');
            sb.append(o[1].substring(0, o[1].indexOf(' ')));
            sb.append(" (email: ");
            sb.append(o[2]);
            sb.append(")\n");
        }
        return sb.toString();
    }

    public static String convert3(String input) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (String ignored : input.split("\n")) {
            count++;
        }
        String[] domens = new String[count];
        int items = 0;
        boolean added = false;
        for (String s : input.split("\n")) {
            if (s.contentEquals("Login;Name;Email")) continue;
            String domen = content(s)[2].substring(content(s)[2].indexOf('@') + 1);
            added = false;
            for (int i = 0; i < items; i++){
                if (domens[i].contentEquals(domen)) added = true;
            }
            if (!added){
                domens[items] = domen;
                items++;
            }
        }
        for (int i = 0; i < items; i++){
            sb.append(domens[i]);
            sb.append(" ==> ");
            for (String s : input.split("\n")) {
                if (s.contentEquals("Login;Name;Email")) continue;
                if (content(s)[2].substring(content(s)[2].indexOf('@') + 1).contentEquals(domens[i])){
                    sb.append(content(s)[0]);
                    sb.append(", ");
                }
            }
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String convert4(String input) {
        StringBuilder sb = new StringBuilder();
        int diff = 9;
        Random random = new Random();
        int n = 0;
        for (String s : input.split("\n")) {
            sb.append(s);
            sb.append(";");
            if (s.contentEquals("Login;Name;Email")) {
                sb.append("Password");
            }
            else {
                for (int i = 0; i < 4; i++) {
                    n = random.nextInt(diff + 1);
                    sb.append(n);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}