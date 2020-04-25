package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class laba2
{
    public laba2()
    {
    }

    public static void main(String[] args)
    {
        //Scanner sc = new Scanner(System.in);

        String string = "https://google.com.ua";//sc.nextLine();
        if (string == null || string.length() == 0)
            try
            {
                throw new NullPointerException("The string is empty!");
            } catch (NullPointerException ex)
            {
                System.out.println(ex);
            }
        Pattern p1 = Pattern.compile("(http|ftp|https)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?");
        Matcher m1 = p1.matcher(string);
        boolean b = m1.matches();
        System.out.println(b);
        //System.out.println(string);

    }
}