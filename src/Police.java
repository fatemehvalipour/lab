import java.util.Random;

public class Police {
    private int x;
    private int y;
    private int m;
    private int n;
    private int nextX;
    private int nextY;
    private String seenStatus = "No";
    private String status = "keep playing";
    Random rand = new Random();
    public Police(int x, int y,int m,int n) {
        this.x = x;
        this.y = y;
        this.m = m;
        this.n = n;
    }

    public int getNextX() {
        return nextX;
    }

    public int getNextY() {
        return nextY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXY(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public String getStatus() {
        return status;
    }

    public void setNextX(int nextX) {
        this.nextX = nextX;
    }

    public void setNextY(int nextY) {
        this.nextY = nextY;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void movePoliceByChance() {
        while (true) {
            int randX = rand.nextInt(3);
            int randY = rand.nextInt(3);

            if (randX == 1 && randY == 1) {
                continue;
            }
            if (randX == 0 && randY == 0) {
                if (x - 1 >= 0 && y - 1 >= 0) {
                    nextX = x - 1;
                    nextY = y - 1;
                    break;
                }
                continue;
            }
            if (randX == 2 && randY == 2) {
                if (x + 1 < m && y + 1 < n) {
                    nextX = x + 1;
                    nextY = y + 1;
                    break;
                }
                continue;
            }
            if (randX == 0 && randY == 1) {
                if (x - 1 >= 0) {
                    nextX = x - 1;
                    nextY = y;
                    break;
                }
                continue;
            }
            if (randX == 0 && randY == 2) {
                if (x - 1 >= 0 && y + 1 < n) {
                    nextX = x - 1;
                    nextY = y + 1;
                    break;
                }
                continue;
            }
            if (randX == 1 && randY == 2) {
                if (y + 1 < n) {
                    nextX = x;
                    nextY = y + 1;
                    break;
                }
                continue;
            }
            if (randX == 1 && randY == 0) {
                if (y - 1 >= 0) {
                    nextX = x;
                    nextY = y - 1;
                    break;
                }
                continue;
            }
            if (randX == 2 && randY == 0) {
                if (x + 1 < m && y - 1 >= 0) {
                    nextX = x + 1;
                    nextY = y - 1;
                    break;
                }
                continue;
            }
            if (randX == 2 && randY == 1) {
                if (x + 1 < m) {
                    nextX = x + 1;
                    nextY = y;
                    break;
                }
                continue;
            }
        }
    }
    /*public void movePoliceIfSeen(int biggestX,int biggestY,int lowestX,int lowestY) {
        while (true) {
            int randX = rand.nextInt(3);
            int randY = rand.nextInt(3);

            if (randX == 1 && randY == 1) {
                continue;
            }
            if (randX == 0 && randY == 0) {
                if (x - 1 >= lowestX && y - 1 >= lowestY) {
                    nextX = x - 1;
                    nextY = y - 1;
                    break;
                }
                continue;
            }
            if (randX == 2 && randY == 2) {
                if (x + 1 < biggestX && y + 1 < biggestY) {
                    nextX = x + 1;
                    nextY = y + 1;
                    break;
                }
                continue;
            }
            if (randX == 0 && randY == 1) {
                if (x - 1 >= lowestX) {
                    nextX = x - 1;
                    nextY = y;
                    break;
                }
                continue;
            }
            if (randX == 0 && randY == 2) {
                if (x - 1 >= lowestX && y + 1 < biggestY) {
                    nextX = x - 1;
                    nextY = y + 1;
                    break;
                }
                continue;
            }
            if (randX == 1 && randY == 2) {
                if (y + 1 < biggestY) {
                    nextX = x;
                    nextY = y + 1;
                    break;
                }
                continue;
            }
            if (randX == 1 && randY == 0) {
                if (y - 1 >= lowestY) {
                    nextX = x;
                    nextY = y - 1;
                    break;
                }
                continue;
            }
            if (randX == 2 && randY == 0) {
                if (x + 1 < biggestX && y - 1 >= lowestY) {
                    nextX = x + 1;
                    nextY = y - 1;
                    break;
                }
                continue;
            }
            if (randX == 2 && randY == 1) {
                if (x + 1 < biggestX) {
                    nextX = x + 1;
                    nextY = y;
                    break;
                }
                continue;
            }
        }
    }*/

}
