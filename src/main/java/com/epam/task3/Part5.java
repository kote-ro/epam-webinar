package com.epam.task3;

public class Part5 {

    public static void main(String[] args) {
        
    }

    public static String decimal2Roman(int input) {
        if (input < 1 || input > 100)
            return "Invalid Roman Number Value";
        StringBuilder s = new StringBuilder("");
        while (input >= 100) {
            s.append("C");
            input -= 100;
        }
        while (input >= 90) {
            s.append("XC");
            input -= 90;
        }
        while (input >= 50) {
            s.append("L");
            input -= 50;
        }
        while (input >= 40) {
            s.append("XL");
            input -= 40;
        }
        while (input >= 10) {
            s.append("X");
            input -= 10;
        }
        while (input >= 9) {
            s.append("IX");
            input -= 9;
        }
        while (input >= 5) {
            s.append("V");
            input -= 5;
        }
        while (input >= 4) {
            s.append("IV");
            input -= 4;
        }
        while (input >= 1) {
            s.append("I");
            input -= 1;
        }
        return s.toString();
    }

    public static int roman2Decimal(String roman) {
        int i = 0; // position in the Roman string

        int current = 0;
        int previous = 0;
        int arabic = 0;

        while (i < roman.length()) {

            char letter = roman.charAt(i);

            switch (letter) {
                case ('I'):
                    current = 1;
                    break;
                case ('V'):
                    current = 5;
                    break;
                case ('X'):
                    current = 10;
                    break;
                case ('L'):
                    current = 50;
                    break;
                case ('C'):
                    current = 100;
                    break;
                default:
                    break;
            }

            if (current > previous) {
                arabic += current - (previous * 2);
            } else {
                arabic += current;
            }
            previous = current;
            i += 1;
        }

        return arabic;
    }

}
