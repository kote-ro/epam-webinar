package com.epam.task5;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Part5 {
    // creates string before writing to the file
    public static String createString(int integer){
        StringBuilder result = new StringBuilder("");

        for(int i = 0; i < 20; i++){
            result.append(integer);
        }

        result.append("\n");
        return result.toString();
    }

    public static void main(final String[] args)  {
        try(RandomAccessFile file = new RandomAccessFile("part5.txt", "rw")) {
            Part5 part5 = new Part5();
            for (int i = 0; i <= 9; i++) {
                Thread thread = new Thread(part5.new NumberWriter(i, file));
                thread.start();
            }
        }catch (IOException ex){
            ex.getMessage();
        }
    }

    private class NumberWriter implements Runnable {
        int number;
        RandomAccessFile file;

        public NumberWriter(int number, RandomAccessFile file) {
            this.number = number;
            this.file = file;
        }


        public void run() {
            try {
                int seek = this.number * 20 + number;

                file.seek(seek);
                file.write((createString(this.number)).getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

