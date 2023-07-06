package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Реализуйте 3 метода, чтобы в каждом из них получить разные исключения,
        //посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
//
// метод 1
        exceptionReadTester(); //какие ещё ошибки могут возникнуть?
//        /* Ошибки могут быть связаны с разрешенным доступом,
//         введёнными недопустимыми символами...
//         */
// метод 2
        sumNum(); // я не знаю почему, но на 17й и 20й версии jdk выдаёт - "1" в консоль
//        //вместо ArithmeticException (>.<)
// метод 3
        canNotDivide();

        //Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
        // и возвращающий новый массив, каждый элемент которого равен частному элементов
        // двух входящих массивов в той же ячейке.

        List<Integer> arr1 = new ArrayList<>();
        arr1.add(10);
        arr1.add(20);
        arr1.add(30);
        arr1.add(40);
        arr1.add(50);

        List<Integer> arr2 = new ArrayList<>();
        arr2.add(2);
        arr2.add(4);
        arr2.add(3);
        arr2.add(8);

        List<Double> resultArray = divideArrays(arr1, arr2);
        System.out.println(resultArray);
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
            int a, b, prod;
            a = 2_147_483_647;
            ;
            b = 2_147_483_647;
            ;
            prod = a + b;
            System.out.println(prod);
        } catch (ArithmeticException e) {
            System.out.println("From -2 147 483 647 to 2 147 483 647" + e.getMessage());
        }
    }

    public static void canNotDivide() {
        try {
            int result = 0 / 0;
            System.out.println("result: " + result);
        } catch (ArithmeticException e) {

            System.out.println("Error: dividing by 0 isn't appropriate");
        } finally {
            System.out.println("all 3 methods are done");
        }
    }

    public static List<Double> divideArrays(List<Integer> array1, List<Integer> array2) {
        List<Double> result = new ArrayList<>();
        try {
            for (int i = 0; i < array1.size(); i++) {
                if (array2.get(i) != 0) {
                    result.add((double) array1.get(i) / array2.get(i));
                } else {
                    throw new RuntimeException("can't be divided by 0");
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Index out of bounds, you can only divide arrays of the same size");
        }

    }

}
