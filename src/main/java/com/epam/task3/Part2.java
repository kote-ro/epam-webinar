package com.epam.task3;

import java.util.Arrays;

public class Part2 {

    public static void main(String[] args) {
        String string = Util.getInput("com\\epam\\task3\\input-data\\part2.txt");
        convert(string);
    }

    public static String convert(String input) {
        int maxWordsCounter = 0;
        int minWordsCounter = 0;

        int maxWordLength = Part2.getLongestLength(input);
        int minWordLength = Part2.getShortestLength(input);

        String[] strings = input.split("[\\s|'|,|\\n|\\r|-]+");

        for(int i = 0; i < strings.length; i++) {
            if (strings[i].length() == maxWordLength) {
                maxWordsCounter++;
            }
        }

        for(int i = 0; i < strings.length; i++) {
            if (strings[i].length() == minWordLength) {
                minWordsCounter++;
            }
        }

        String[] arrayOfMax = new String[maxWordsCounter];
        String[] arrayOfMin = new String[minWordsCounter];

        int k1 = 0;
        int k2 = 0;

        for(int i = 0; i < strings.length; i++) {
            if (strings[i].length() == maxWordLength) {
                arrayOfMax[k1] = strings[i];
                k1++;
            }
        }

        for(int i = 0; i < strings.length; i++) {
            if (strings[i].length() == minWordLength) {
                arrayOfMin[k2] = strings[i];
                k2++;
            }
        }

        arrayOfMax = Arrays.stream(arrayOfMax).distinct().toArray(String[]::new);;
        arrayOfMin = Arrays.stream(arrayOfMin).distinct().toArray(String[]::new);

        StringBuilder result = new StringBuilder("Min: ");

        for(int i = 0; i < arrayOfMin.length; i++)
            if(arrayOfMin.length == 1)
                result.append(arrayOfMin[i]);
            else if(i < arrayOfMin.length-1)
                result.append(arrayOfMin[i]+", ");
            else
                result.append(arrayOfMin[i]+" \n");

        result.append("Max: ");

        for(int i = 0; i < arrayOfMax.length; i++)
            if(arrayOfMax.length == 1)
                result.append(arrayOfMax[i]);
            else if(i < arrayOfMax.length-1)
                result.append(arrayOfMax[i]+", ");
            else
                result.append(arrayOfMax[i]);

        return result.toString();
    }

    public static int getLongestLength(String input){
        String w = "";
        String lw = "";

        input = input + " ";
        for (int i=0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(ch != ' ' && ch != '-'
                    && ch != '\'' && ch != '\r'
                    && ch != '\n' && ch != ','){
                w += ch;
            } else {
                if(w.length() > lw.length()) {
                    lw = w;
                }
                w = "";
            }
        }

        return lw.length();
    }

    public static int getShortestLength(String input){
        String[] lineUpdate = input.split("[\\s|'|,|\\n|\\r|-]+");
        int min = lineUpdate[0].length();

        for (int i=0; i< lineUpdate.length; i++) {
            if ( lineUpdate[i].length() < min)
                min = lineUpdate[i].length();
        }

        return min;
    }
}
