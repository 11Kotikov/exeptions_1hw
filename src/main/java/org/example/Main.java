package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        exceptionReadTester(); //какие ещё ошибки могут возникнуть?
        /* ошибки могут быть связаны с разрешенным доступом,
         введёнными недопустимыми символами
         */

    }

    public static void exceptionReadTester() {
        try (BufferedReader readme = Files.newBufferedReader(Paths.get("./readme.txt"))) {
            String whatInside = readme.readLine();
        }catch (NoSuchFileException e){
            System.out.println("The file doesn't exist, check the name: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Input/Output error: " + e.getMessage());
        }
    }
}