package com.company;
//import java.util.Scanner;
import java.util.Stack;

public class laba3 {

    public static void main(String[] args)
    {
        //Scanner sc = new Scanner(System.in);

        //System.out.print("Введите положительное число:");
        String number = "-984894";//sc.next();
        try
        {
            int chislo = Integer.parseInt(number);
            if (chislo < 0)
                throw new IllegalArgumentException();
        } catch (NumberFormatException ex)
        {
            System.out.println("Это не число");
            System.exit(-1);
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println("Задано отрицательное число. Но не унывайте. Мы возьмём его по модулю)");
            number = number.substring(1);
        }

        Stack<Integer> nums = new Stack<Integer>();
        System.out.print("Введённое число: ");
        int i = 0;
        for (char num : number.toCharArray())
        {
            nums.push(Character.getNumericValue(num));
            System.out.print(num + " ");
            i++;
        }
        System.out.println();
        System.out.print("Результат: ");
        for (int a = 0;a<i;a++)
        {
            System.out.print(nums.pop() + " ");
        }
    }
}
