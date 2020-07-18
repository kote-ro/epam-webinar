package com.epam.task3;

public class Part6 {

    public static void main(String[] args) {
        convert(Util.getInput("com\\epam\\task3\\input-data\\part6.txt"));
    }

    public static String convert(String input) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (String ignored : input.split("\\s")) {
            count++;
        }
        String[] words = new String[count / 2];
        int items = 0;
        boolean added = false;
        int index = 0;
        for (String currentWord : input.split("\\s")) {
            index += currentWord.length() + 1;
            if (index > input.length()) break;
            for (String s : input.substring(index).split("\\s")) {
                if (currentWord.contentEquals(s)) {
                    added = false;
                    for (int i = 0; i < items; i++) {
                        if (words[i].contentEquals(s)) added = true;
                    }
                    if (!added) {
                        words[items] = currentWord;
                        items++;
                        break;
                    }
                }
            }
        }
        for (String line : input.split("\n")) {
            for (String currentWord : line.split(" ")) {
                for (int i = 0; i < items; i++) {
                    if (words[i].contentEquals(currentWord)) {
                        sb.append("_");
                        break;
                    }
                }
                sb.append(currentWord + " ");
            }
            sb = new StringBuilder(sb.substring(0, sb.length() - 1));
            sb.append("\n");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
