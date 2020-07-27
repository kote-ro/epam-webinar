package com.epam.task4;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Part2 {

    public static void showResult(int[] array, String keyWord){
        StringBuilder sb = new StringBuilder();
        sb.append(keyWord+" ==> ");
        for(int i : array){
            sb.append(i+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

    public static void processing1(){

        int[] array = new int[10];

        for (int i=0;i<array.length;i++) {
            array[i] = (int) (Math.random() * 50);
        }

        showResult(array, "input");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("part2.txt"))) {
            for (int i=0;i<array.length;i++) {
                final String s = Integer.toString(array[i]);
                bw.write(s+" ");
            }
        } catch(IOException ex){
            ex.getMessage();
        }
    }

    public static void processing2() {
        try(FileWriter fileWriter = new FileWriter("part2_sorted.txt")){
            Scanner scanner = new Scanner(new File("part2.txt"));
            int [] array = new int [10];
            int i = 0;

            while(scanner.hasNextInt()) {
                array[i++] = scanner.nextInt();
            }

            Arrays.sort(array);

            showResult(array, "output");

            for (int j = 0; j < array.length; j++) {
               fileWriter.write(array[j] + " ");
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Part2.processing1();
        Part2.processing2();
    }

}
