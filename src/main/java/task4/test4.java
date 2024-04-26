package task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class test4 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(args));

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите путь к файлу (в абсолютный формате): ");
        String filePath = sc.next();

        int count = 0; // счетчик строк

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) { //filePath вместо n
            String line;
            while ((line = reader.readLine()) != null) {
                count++;
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        int nums[] = new int[count];

        try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            int i = 0;
            //чтение построчно
            String s;
            while((s=br.readLine())!=null){
                nums[i] = Integer.parseInt(s);
                i += 1;
            }
        }
        catch(IOException ex){

            System.out.println(  ex.getMessage());
        }

        Arrays.sort(nums);
        //предварительная сортировка
        int result = 0;
        for (int value : nums) {
            result += Math.abs(value - nMedian(nums));
        }
        System.out.println(result);
    }
    public static double nMedian(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);

        if (sortedArr.length % 2 == 1) {
            return sortedArr[sortedArr.length / 2];
        } else {
            return Math.round ( 0.5 * (sortedArr[sortedArr.length / 2 - 1] + sortedArr[sortedArr.length / 2]) );
        }
    }
}
