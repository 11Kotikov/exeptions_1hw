package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        //exceptionReadTester(); //какие ещё ошибки могут возникнуть?
        /* ошибки могут быть связаны с разрешенным доступом,
         введёнными недопустимыми символами
         */
        sumNum();
    }

    public static void exceptionReadTester() {
        try (BufferedReader readme = Files.newBufferedReader(Paths.get("./readme.txt"))) {
            String whatInside = readme.readLine();
        } catch (NoSuchFileException e) {
            System.out.println("The file doesn't exist, check the name: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Input/Output error: " + e.getMessage());
        }
    }

    public static void sumNum() {
        try {
            int a,b, prod;
            a = 2147483647;
            b = 2147483647;
            prod = a*b;
            System.out.println(prod);
        } catch (NumberFormatException e) {
            System.out.println("Only integers are allowed");
        } catch (ArithmeticException e) {
            System.out.println("From -2 147 483 648 to 2 147 483 647" + e.getMessage());
        }
    }
}