package com.epam.task4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resources = "resources";
        while (true) {
            String str = scanner.nextLine();

            switch (str) {
                case "table en":
                    Locale localeEnTable = new Locale("en");
                    ResourceBundle resourceBundleEnTable = ResourceBundle.getBundle(resources, localeEnTable);
                    System.out.println(resourceBundleEnTable.getString("table"));
                    break;
                case "table ru":
                    Locale localeRuTable = new Locale("ru");
                    ResourceBundle resourceBundleRuTable = ResourceBundle.getBundle(resources, localeRuTable);
                    System.out.println(resourceBundleRuTable.getString("table"));
                    break;
                case "apple en":
                    Locale localeEnApple = new Locale("en");
                    ResourceBundle resourceBundleEnApple = ResourceBundle.getBundle(resources, localeEnApple);
                    System.out.println(resourceBundleEnApple.getString("apple"));
                    break;
                case "apple ru":
                    Locale localeRuApple = new Locale("ru");
                    ResourceBundle resourceBundleRuApple = ResourceBundle.getBundle(resources, localeRuApple);
                    System.out.println(resourceBundleRuApple.getString("apple"));
                    break;
            }
        }

    }
}
