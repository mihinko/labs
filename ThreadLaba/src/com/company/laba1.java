package com.company;


public class laba1 {
    public static void main(String[] args) {
        System.out.print("Введите строку для изменения: ");
        String offer = "String for change";//sc.nextLine();
        int k = 4;
        char symbol = '8';
        System.out.printf("Дано: %s\nРезультат: %s", offer, replaceSymbol(offer, k, symbol));
        System.out.println();
    }

    public static String replaceSymbol(String offer, int index, char symbol) {
        StringBuilder sb = new StringBuilder();
        if (offer != null && offer.length() > 0 && index > 0) {
            boolean lengthb4 = false;
            for (String word : offer.split(" ")) {
                if (word.length() >= index) {
                    sb.append(word.substring(0, index - 1)).append(symbol).append(word.substring(index, word.length()));
                } else {
                    sb.append(word);
                }
                if (word.length()>=4)
                    lengthb4 = true;
                sb.append(" ");
            }
            if (!lengthb4)
                try
                {
                    throw new IllegalArgumentException("");
                } catch (IllegalArgumentException ex)
                {
                    System.out.println(ex);
                    System.exit(-2);
                }
        } else
            try
            {
                throw new NullPointerException("The string is empty!");
            } catch (NullPointerException ex)
            {
                System.out.println(ex);
                System.exit(-1);
            }
        return sb.toString();
    }
}
