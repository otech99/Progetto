package progetto;

import java.util.Scanner;

public class Progetto {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);

        int numServizi = scan.nextInt();
        int numZone = scan.nextInt();
        int numServer = scan.nextInt();

        System.out.println(numServer + " " + numServizi + " " + numZone);

    }
}
