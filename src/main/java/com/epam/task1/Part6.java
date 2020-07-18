package com.epam.task1;


public class Part6 {

    public static boolean isPrimeBruteForce(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        if(args.length > 0) {
            int length = Integer.parseInt(args[0]);
            int counter = 1;
            int arrayCounter = 0;

            int[] array = new int[length];


            while (array[length - 1] == 0) {
                counter++;
                if (isPrimeBruteForce(counter)) {
                    array[arrayCounter] = counter;
                    arrayCounter++;
                }
            }

            for (int i = 0; i < array.length; i++) {
                if (i == array.length - 1) {
                    System.out.print((array[i]));
                } else {
                    System.out.print((array[i])+"/");
                }
            }
        }else{
            int[] array = new int[0];
            for(int i : array){
                System.out.print(i);
            }
        }

    }

}
