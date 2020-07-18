package com.epam.task1;

public class Part5 {

    public static void main(String[] args) {

        String string = args[0];

        int sum = 0;
        int a = 0;

        for(int i = 0; i < args[0].length(); i++){
            a = Integer.parseInt(String.valueOf(string.charAt(i)));
            sum += a;
        }

        System.out.print(sum);

    }
	
}
