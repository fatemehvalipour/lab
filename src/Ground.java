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

}
