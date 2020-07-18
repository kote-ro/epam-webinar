package com.epam.task1;

public class Part2 {

    public static void main(String[] args) {

        int result = 0;

        for(int i = 0; i < args.length; i++){
            try {
                result += Integer.parseInt(args[i]);
            }catch (NumberFormatException e){}
        }

        System.out.print(result);

    }
	
}
