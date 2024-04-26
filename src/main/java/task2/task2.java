package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class task2 {
    public static void main (String args[]){

        if (args.length != 2) {
            System.out.println("Неверное количество аргументов. Укажите путь до файлов c.txt, p.txt");
            return;
        }
        String c = args[0];
        String p = args[1];

        try {
            Scanner circleScanner = new Scanner(new File(c));
            double centerX = circleScanner.nextDouble();
            double centerY = circleScanner.nextDouble();
            double radius = circleScanner.nextDouble();
            circleScanner.close();

            Scanner pointScanner = new Scanner(new File(p));
            while (pointScanner.hasNextDouble()) {
                double pointX = pointScanner.nextDouble();
                double pointY = pointScanner.nextDouble();

                double distance = Math.sqrt(Math.pow(pointX - centerX, 2) + Math.pow(pointY - centerY, 2));

                if (distance < radius) {
                    System.out.println("0");
                } else if (distance > radius) {
                    System.out.println("2");
                    System.out.println("1");
                }
            }
            pointScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }

    }
}
