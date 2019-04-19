public class Ground {
    private int m;
    private int n;
    String[][] ground;

    public Ground(int m, int n) {
        this.m = m;
        this.n = n;
        ground = new String[m][n];
        for(int i= 0 ; i < n;i++){
            for (int j = 0; j < m ; j++){
                ground[j][i] = "-";
            }
        }
    }
    public void setPlace(int x,int y,String kind){
        ground[x][y] = kind;
    }

    public String[][] getGround() {
        return ground;
    }
    public void print(){
        for(int i= 0 ; i < n;i++){
            for(int k = 0 ; k < (2*m)+1 ;k++){
                System.out.print("_");
            }
            System.out.println();
            for (int j = 0; j < m ; j++){
                System.out.print("|" + ground[j][i]);
                //ground[j][i] = "-";
            }
            System.out.println("|");
        }
        for(int k = 0 ; k < (2*m)+1 ;k++){
            System.out.print("_");
        }
        System.out.println();
    }
   public void move(int x,int y,int nextX,int nextY){
        ground[nextX][nextY] = "D";
        ground[x][y] = "-";

   }
}
