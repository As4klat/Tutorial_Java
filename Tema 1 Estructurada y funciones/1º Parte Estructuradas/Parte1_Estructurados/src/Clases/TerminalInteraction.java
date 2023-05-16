package Clases;

import java.util.Scanner;

public class TerminalInteraction {
    public static void seeTextLn(String str){
        System.out.println(str);
    }

    public static void seeText(String str){
        System.out.print(str);
    }

    public static String getInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String getInput(String title,boolean addLn){
        if (addLn) {
            seeTextLn(title);
        } else {
            seeText(title);
        }
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
