package com.epam.task4;

import java.io.*;
import java.util.Scanner;

public class Part1 {
    // getting input string from the file
    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "Cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }
    // deleting the first two characters of each word with the length of 4 and more characters
    public static void convert() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("part1.txt"), "Cp1251"))) {

            String line;
            StringBuilder result = new StringBuilder();

            while ((line = in.readLine()) != null) {
                String[] wordsInLine = line.split("[.,!?\\-\\s\\n]+");

                for (String string : wordsInLine) {

                    if (isLongerThanFour(string)) {
                        result.append(string.substring(2) + " ");
                    } else {
                        result.append(string + " ");
                    }
                }
                result.deleteCharAt(result.length()-1);
                result.append("\n");
            }
            result.deleteCharAt(result.length()-1);

            System.out.println(result);
        }catch(IOException e){
            e.getMessage();
        }
    }
    // checking for right length of current word
    public static boolean isLongerThanFour(String string){
        return string.length() >= 4;
    }

    public static void main(String[] args){
        Part1.convert();
    }

}
