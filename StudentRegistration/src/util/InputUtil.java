package util;

import java.util.Scanner;

public class InputUtil {

    public static String inputText(String title){
        System.out.print(title);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int inputNumber(String title){
        System.out.print(title);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
