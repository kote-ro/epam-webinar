package com.epam.task1;

public class Part7 {

    public static void main(String[] args) {
        String arrow = " ==> ";

        print("A"+arrow+str2int("A")+arrow+int2str(1));
        print("B"+arrow+str2int("B")+arrow+int2str(2));
        print("Z"+arrow+str2int("Z")+arrow+int2str(26));
        print("AA"+arrow+str2int("AA")+arrow+int2str(27));
        print("AZ"+arrow+str2int("AZ")+arrow+int2str(52));
        print("BA"+arrow+str2int("BA")+arrow+int2str(53));
        print("ZZ"+arrow+str2int("ZZ")+arrow+int2str(702));
        print("AAA"+arrow+str2int("AAA")+arrow+int2str(703));

    }

    public static int serialNumberDetermination(char ch){

        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L',
                'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for(int i = 0; i < alphabet.length; i++){
            if(ch == alphabet[i]){
                return i;
            }
        }

        return 0;

    }

    public static int str2int(String string) {

        int strLength = string.length()-1;
        int resultNum = 0;

        for(int i = strLength, j = 0; i >= 0 && j <= strLength; i-- , j++){
            resultNum += Math.pow(26, i)*(serialNumberDetermination(string.charAt(j))+1);
        }

        return resultNum;

    }


    public static String int2str(int number) {

        StringBuilder columnName = new StringBuilder();

        while (number > 0) {

            int rem = number % 26;

            if (rem == 0) {
                columnName.append("Z");
                number = (number / 26) - 1;
            }
            else
            {
                columnName.append((char)((rem - 1) + 'A'));
                number = number / 26;
            }
        }

        return columnName.reverse().toString();

    }

    public static String rightColumn(String string) {

        int result = str2int(string);
        result++;

        String stringResult = int2str(result);

        return stringResult;

    }

    public static void print(String string){
        System.out.print(string+"\n");
    }
}
