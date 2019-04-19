import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<Police> polices = new ArrayList<>();
        int m = scan.nextInt();//tool
        int n = scan.nextInt();//arz
        Ground ground = new Ground(m,n);
        int numOfPolice = scan.nextInt();
        int firstXThief = rand.nextInt(m);
        int firstYThief = rand.nextInt(n);
        Thief thief = new Thief(firstXThief,firstYThief,m,n);
        ground.setPlace(firstXThief,firstYThief,"D");
        for(int i = 0 ;i < numOfPolice ;i++){
            int xP = rand.nextInt(m);
            int yP = rand.nextInt(n);
            if(ground.getGround()[xP][yP].equals("-")){
                Police police = new Police(xP,yP);
                ground.setPlace(xP,yP,"P");
                polices.add(police);
            }else {
                i--;
                continue;
            }
        }
        ground.print();
        Thread.sleep(2000);
        //while (true) {
            for (Police p : polices) {
                if (Math.abs(p.getX() - thief.getX()) <= 2 && Math.abs(p.getY() - thief.getY()) <= 2) {
                    p.setStatus("Yes");
                    break;
                }
            }
        //}
        thief.moveThief();
            ground.move(thief.getX(),thief.getY(),thief.getNextX(),thief.getNextY());
            ground.print();
    }
}
