package com.epam.task1;

public class Part4 {

    public static int gcd(int firstNum, int secondNum) {

        return secondNum == 0 ? firstNum : gcd(secondNum, firstNum % secondNum);

    }

    public static void main(String[] args) {

        int firstNum = Integer.parseInt(args[0]);
        int secondNum = Integer.parseInt(args[1]);

        int result = gcd(firstNum, secondNum);

        System.out.print(result);

    }

}
