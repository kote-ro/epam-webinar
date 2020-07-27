package com.epam.task4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void showSB(StringBuilder sb){
        System.out.println(sb);
    }

    private static void showCyrlWords() {
        String input = Part1.getInput("part6.txt");
        StringBuilder result = new StringBuilder("Cyrl: ");

        String regEx = "[\\u0410-\\u042F\\u0430-\\u044F\\u0451\\u0401\\u0407\\u0457\\u0406\\u0456\\u0404\\u0454\\u0490\\u0491]+|[\\u0430-\\u044F,\\u0410-\\u042F]+";

        Matcher m = Pattern.compile(regEx).matcher(input);

        while(m.find()){
            result.append(m.group()+" ");
        }

        showSB(result);
    }


    private static void showLatinWords() {
        String input = Part1.getInput("part6.txt");
        StringBuilder result = new StringBuilder("Latn: ");

        String regEx = "[a-z,A-Z]+";

        Matcher m = Pattern.compile(regEx).matcher(input);

        while(m.find()){
            result.append(m.group()+" ");
        }

        showSB(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            String choice = scanner.next();

            switch (choice) {
                case "stop":
                    scanner.close();
                    return;
                case "Cyrl":
                    showCyrlWords();
                    break;
                case "Latn":
                    showLatinWords();
                    break;
                default:
                    System.out.print("Incorrect input");
                    break;
            }
        }


    }
}
