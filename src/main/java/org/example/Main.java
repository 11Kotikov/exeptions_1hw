package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
//        exceptionReadTester(); //какие ещё ошибки могут возникнуть?
//        /* ошибки могут быть связаны с разрешенным доступом,
//         введёнными недопустимыми символами...
//         */
//        sumNum(); // я не знаю почему, но на 17й и 20й версии jdk выдаёт - "1" в консоль
//        //вместо ArithmeticException (>.<)
        canNotDivide();
    }

    public static void exceptionReadTester() {
        try (BufferedReader readme = Files.newBufferedReader(Paths.get("./readme.txt"))) {
            String whatInside = readme.readLine();
        } catch (NoSuchFileException e) {
            System.out.println("The file doesn't exist, check the name or path: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Input/Output error: " + e.getMessage());
        }
    }

    public static void sumNum() {
        try {
            int a,b, prod;
            a =  2_147_483_647;;
            b =  2_147_483_647;;
            prod = a*b;
            System.out.println(prod);
        } catch (ArithmeticException e) {
            System.out.println("From -2 147 483 647 to 2 147 483 647" + e.getMessage());
        }
    }

    public static void canNotDivide() {
        try {
            int result = 10 / 0;
            System.out.println("result: " + result);
        } catch (ArithmeticException e) {

            System.out.println("Error: dividing by 0 isn't appropriate");
        } finally {
            System.out.println("all 3 methods are done");
        }
    }

}
