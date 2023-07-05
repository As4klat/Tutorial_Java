import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int a;
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un número");
        a = sc.nextInt();
        int b;

        System.out.println("Escribe un número");
        b = sc.nextInt();
        if (a > b) {
            System.out.println(a-b);
        }
        else {
            System.out.println(b-a);
        }
    }
}