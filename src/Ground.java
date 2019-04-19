public class Ground {
    private int m;
    private int n;
    String[][] ground;
    private String status = "keep playing";

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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPlace(int x, int y, String kind){
        ground[x][y] = kind;
    }

    public String[][] getGround() {
        return ground;
    }
    public void print(){
        for(int k = 0 ; k < (2*m)+1 ;k++){
            System.out.print("-");
        }
        System.out.println();
        for(int i= 0 ; i < n;i++){
            //System.out.println();
            for (int j = 0; j < m ; j++){
                System.out.print("|" + ground[j][i]);
            }
            System.out.println("|");
        }
        for(int k = 0 ; k < (2*m)+1 ;k++){
            System.out.print("-");
        }
        System.out.println();
    }
   public void moveThief(int x,int y,int nextX,int nextY){
        if(ground[nextX][nextY].equals("P")){
            setStatus("stop");
        }else {
            setPlace(x,y,"-");
            setPlace(nextX,nextY,"D");

        }

   }
   public void Clear(){
       System.out.print("\033[H\033[2J");
       System.out.flush();
   }
    public void movePolice(int x,int y,int nextX,int nextY){

        if(ground[nextX][nextY].equals("D")){
            setStatus("stop");
        }else{
            setPlace(x,y,"-");
            setPlace(nextX,nextY,"P");


        }

    }

}
