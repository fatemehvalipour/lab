import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int m = scan.nextInt();//tool
        int n = scan.nextInt();//arz
        int numOfPolice = scan.nextInt();
        int firstXThief = rand.nextInt(m);
        int firstYThief = rand.nextInt(n);
        Thief thief = new Thief(firstXThief,firstYThief);

    }
}
