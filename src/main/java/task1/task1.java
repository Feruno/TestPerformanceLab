package task1;

import java.util.Arrays;
import java.util.Scanner;

public class task1 {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество элементов в массиве: ");
        int n = sc.nextInt();
        System.out.print("Введите длину интервала: ");
        int m = sc.nextInt();

        int[] arr = new int[n];
        Arrays.setAll(arr, i -> ++i);

        int current = 0;
        System.out.print("Полученный путь: ");
        do {
            System.out.print(arr[current]);
            current = (current + m - 1) % n;
        } while (current != 0);
    }
}
