package com.epam.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static void showList(List<String> list){
        StringBuilder sb = new StringBuilder();
        for(String string : list){
            sb.append(string + " ");
        }
        System.out.println(sb);
    }

    private static void showInts() {
        List<String> list = new ArrayList<>();
        String input = Part1.getInput("part3.txt");

        Matcher m = Pattern.compile("\\s+-?\\d+\\s+").matcher(input);
        while (m.find()) {
            list.add(m.group().trim());
        }
        showList(list);
    }

    private static void showDoubles() {
        List<String> list = new ArrayList<>();
        String input = Part1.getInput("part3.txt");

        Matcher m = Pattern.compile("\\d+\\.\\d+|\\.\\d+").matcher(input);
        while (m.find()) {
            list.add(m.group());
        }
        showList(list);
    }

    private static void showChars() {
        List<String> list = new ArrayList<>();
        String input = Part1.getInput("part3.txt");

        String regEx = "\\b[a-z,A-Z]\\b|\\b[\\u0410-\\u042F\\u0430-\\u044F\\u0451\\u0401\\u0407\\u0457\\u0406\\u0456\\u0404\\u0454\\u0490\\u0491]\\b|\\b[\\u0430-\\u044F,\\u0410-\\u042F]\\b";

        Matcher m = Pattern.compile(regEx).matcher(input);
        while (m.find()) {
            list.add(m.group().trim());
        }
        showList(list);
    }

    private static void showStrings() {
        List<String> list = new ArrayList<>();
        String input = Part1.getInput("part3.txt");
        String regEx = "\\b[a-z,A-Z]+\\b|\\b[\\u0410-\\u042F\\u0430-\\u044F\\u0451\\u0401\\u0407\\u0457\\u0406\\u0456\\u0404\\u0454\\u0490\\u0491]+\\b|\\b[\\u0430-\\u044F,\\u0410-\\u042F]+\\b";

        Matcher m = Pattern.compile(regEx).matcher(input);
        while (m.find()) {
            if(m.group().trim().length() > 1) {
                list.add(m.group());
            }
        }
        showList(list);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            String choice = scanner.nextLine();
            switch(choice){
                case "stop":
                    scanner.close();
                    return;
                case "String":
                    showStrings();
                    break;
                case "char":
                    showChars();
                    break;
                case "int":
                    showInts();
                    break;
                case "double":
                    showDoubles();
                    break;
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        }
    }

}
