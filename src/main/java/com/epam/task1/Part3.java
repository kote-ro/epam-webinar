package com.epam.task1;

public class Part3 {

    public static void main(String[] args) {

        StringBuilder result = new StringBuilder();
        if(args.length > 0) {
            for (int i = 0; i < args.length - 1; i++) {
                result.append(args[i] + " ");
            }

            result.append(args[args.length - 1]);
        }else{
            result.append("");
        }

        System.out.print(result);

    }
	
}
