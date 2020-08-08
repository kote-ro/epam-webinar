package com.epam.task5;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {
    private static final Object M = new Object();

    public static int getColumns() {
        try {
            Scanner scanner = new Scanner(new File("part4.txt"));

            int columnCounter = 0;

            Pattern p = Pattern.compile("(\\d+)");
            Matcher m = p.matcher(scanner.nextLine());

            while (m.find()) {
                columnCounter++;
            }

            return columnCounter;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getRows() {
        try {
            FileReader fileReader = new FileReader(new File("part4.txt"));
            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

            int rowCounter = 0;

            while (lineNumberReader.readLine() != null && lineNumberReader.readLine() != "\n\n") {
                rowCounter++;
            }

            return rowCounter;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static int[][] getMatrix() {
        try {
            Scanner input = new Scanner(new BufferedReader(new FileReader("part4.txt")));
            int rows = Part4.getRows();
            int columns = Part4.getColumns();

            int[][] myArray = new int[rows][columns];

            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    if (input.hasNextInt()) {
                        myArray[i][j] = input.nextInt();
                    }
                }
            }

            return myArray;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    static class SingleThread implements Runnable {
        @Override
        public void run() {
            synchronized (this) {
                int[][] matrix = Part4.getMatrix();

                long m = System.currentTimeMillis();

                int maxValue = matrix[0][0];

                for (int i = 0; i < Part4.getRows(); ++i) {
                    for (int j = 0; j < Part4.getColumns(); ++j) {
                        if (matrix[i][j] > maxValue) {
                            maxValue = matrix[i][j];
                        }
                    }
                }

                System.out.println(maxValue);
                System.out.println((System.currentTimeMillis() - m));
            }

        }
    }

    static class MultiThread implements Runnable {
        private int[] array = new int[Part4.getRows()];
        private int counter = 0;

        public synchronized void process(int rowIndex) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    int[][] matrix = Part4.getMatrix();
                    int maxValue = matrix[rowIndex][0];

                    for (int j = 0; j < Part4.getColumns(); ++j) {
                        if (matrix[rowIndex][j] > maxValue) {
                            maxValue = matrix[rowIndex][j];
                        }
                    }

                    array[counter] = maxValue;
                    counter++;
                }
            };

            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            synchronized (this) {
                long m = System.currentTimeMillis();

                MultiThread multiThread = new MultiThread();

                for (int i = 0; i < Part4.getRows(); i++) {
                    multiThread.process(i);
                }

                showMaxValue(multiThread.array);

                System.out.println((System.currentTimeMillis() - m));
            }
        }

        public synchronized void showMaxValue(int[] array) {
            int max = array[0];

            for (int i = 0; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }

            System.out.println(max);
        }
    }

    public static void main(final String[] args) {
        SingleThread singleThread = new SingleThread();
        MultiThread multiThread = new MultiThread();

        singleThread.run();
        multiThread.run();
    }
}
