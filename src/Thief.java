import java.util.Random;

public class Thief {
    private int X;
    private int Y;
    private int mGround;
    private int nGround;
    private int nextX;
    private int nextY;
    private int previousX;
    private int previousY;
    Ground ground = new Ground(mGround,nGround);
    Random rand = new Random();
    public Thief(int x, int y,int m,int n) {
        X = x;
        Y = y;
        mGround = m;
        nGround = n;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getNextX() {
        return nextX;
    }

    public int getNextY() {
        return nextY;
    }

    public void moveThief(){
        while (true) {
            int randX = rand.nextInt(3);
            int randY = rand.nextInt(3);
            if (randX == 1 && randY == 1){
                continue;
            }
            if(randX == 0 && randY == 0){
                if(X - 1 >= 0 && Y - 1 >= 0){
                    nextX = X - 1;
                    nextY = Y - 1;
                    break;
                }
            }
            if(randX == 2 && randY == 2){
                if(X + 1 < mGround && Y + 1 < nGround){
                    nextX = X + 1;
                    nextY = Y + 1;
                    break;
                }
            }
            if(randX == 0 && randY == 1){
                if(X - 1 >= 0 ){
                    nextX = X - 1;
                    nextY = Y;
                    break;
                }
            }
            if(randX == 0 && randY == 2){
                if(X - 1 >= 0 && Y + 1 < nGround){
                    nextX = X - 1;
                    nextY = Y + 1;
                    break;
                }
            }
            if(randX == 1 && randY == 2){
                if(Y + 1 < nGround){
                    nextX = X;
                    nextY = Y + 1;
                    break;
                }
            }
            if(randX == 1 && randY == 0){
                if(Y - 1 >= 0){
                    nextX = X;
                    nextY = Y - 1;
                    break;
                }

            }
            if(randX == 2 && randY == 0){
                if(X + 1 < mGround && Y - 1 >= 0){
                    nextX = X + 1;
                    nextY = Y - 1;
                    break;
                }
            }
            if(randX == 2 && randY == 1){
                if(X + 1 < mGround ){
                    nextX = X + 1;
                    nextY = Y;
                    break;
                }
            }
        }

    }
}
