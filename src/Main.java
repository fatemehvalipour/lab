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
        Ground ground = new Ground(m, n);
        int numOfPolice = scan.nextInt();
        int firstXThief = rand.nextInt(m);
        int firstYThief = rand.nextInt(n);
        Thief thief = new Thief(firstXThief, firstYThief, m, n);
        ground.setPlace(firstXThief, firstYThief, "D");
        for (int i = 0; i < numOfPolice; i++) {
            int xP = rand.nextInt(m);
            int yP = rand.nextInt(n);
            if (ground.getGround()[xP][yP].equals("-")) {
                Police police = new Police(xP, yP, m, n);
                ground.setPlace(xP, yP, "P");
                polices.add(police);
            } else {
                i--;
                continue;
            }
        }
        ground.print();
        //System.out.flush();
        Thread.sleep(2000);
        //System.out.flush();
        //System.out.print("\033[H\033[2J");
        //System.out.flush();
        //ground.Clear();
        while (true) {
            for (Police p : polices) {
                if (Math.abs(p.getX() - thief.getX()) <= 2 && Math.abs(p.getY() - thief.getY()) <= 2) {
                    p.setStatus("Yes");
                    break;
                }
            }
            thief.moveThief();
            ground.moveThief(thief.getX(), thief.getY(), thief.getNextX(), thief.getNextY());
            thief.setXY(thief.getNextX(), thief.getNextY());
            //System.out.println("ok1");
            boolean seen = false;
            for (Police p : polices) {
                if (p.getStatus().equals("Yes")) {
                    seen = true;
                    break;
                }
            }

            //System.out.println("ok2");
            //System.out.println(seen);
            if (seen) {
                for (Police p : polices) {
                    int nextX = p.getX();
                    int nextY = p.getY();
                    if (p.getX() < thief.getX()) {
                        nextX = p.getX() + 1;
                    } else if (p.getX() > thief.getX()) {
                        nextX = p.getX() - 1;
                    }
                    p.setNextX(nextX);
                    if (p.getY() > thief.getY()) {
                        nextY = p.getY() - 1;
                    } else if (p.getY() < thief.getY()) {
                        nextY = p.getY() + 1;
                    }
                    p.setNextY(nextY);
                    //p.movePoliceIfSeen(biggestX, biggestY, lowestX, lowestY);
                    //p.movePoliceByChance();
                    ground.movePolice(p.getX(), p.getY(), p.getNextX(), p.getNextY());
                    p.setXY(p.getNextX(), p.getNextY());
                }
            } else {
                for (Police p : polices) {
                    p.movePoliceByChance();
                    ground.movePolice(p.getX(), p.getY(), p.getNextX(), p.getNextY());
                    p.setXY(p.getNextX(), p.getNextY());
                }
            }
            //System.out.println("ok3");
            if (ground.getStatus().equals("stop")) {
                String finish = "The thief was arrested by the police";
                for (int i = 0; i < finish.length(); i++) {
                    System.out.print(finish.charAt(i));
                    Thread.sleep(100);
                }
                break;
            } else {
                ground.print();
                Thread.sleep(2000);
                //ground.Clear();
                //System.out.print("\033[H\033[2J");
                //System.out.flush();
            }
        }
    }
}