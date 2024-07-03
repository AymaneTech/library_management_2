package com.geek.Utils;

import java.util.Scanner;

public class Helpers {
    public static String readString(String key, Scanner scanner) {
        System.out.print("\t\t\t" + key + ": ");
        return scanner.nextLine();
    }

    public static Long readLong(String key, Scanner scanner) {
        System.out.print("\t\t\t" + key + ": ");
        Long value = scanner.nextLong();
        scanner.nextLine();
        return value;
    }

    public static void log(String str) {
        System.out.println("\t\t\t" + str);
    }

    public static int readInt(String key, Scanner scanner) {
        System.out.print("\t\t\t" + key + ": ");
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
