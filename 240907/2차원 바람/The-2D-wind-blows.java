import java.util.Scanner;

public class Main {
    public static int n, m, q;
    public static int[][] grid = new int[100][100];

    public static void rotate(int r1, int c1, int r2, int c2){
        // ->
        int tmp = grid[r1-1][c2-1];
        for (int i=c2-1; i>c1-1; i--){
            grid[r1-1][i] = grid[r1-1][i-1];
        }

        // ^
        for (int i=r1-1; i<r2-1; i++){
            grid[i][c1-1] = grid[i+1][c1-1];
        }

        // <-
        for (int i=c1-1; i<c2-1; i++){
            grid[r2-1][i] = grid[r2-1][i+1];
        }

        // v
        for (int i=r2-1; i>r1; i--){
            grid[i][c2-1] = grid[i-1][c2-1];
        }
        grid[r1][c2-1] = tmp;

        // for (int i=0; i<n; i++){
        //     for (int j=0; j<m; j++){
        //         System.out.printf("%d ", grid[i][j]);
        //     }
        //     System.out.printf("\n");
        // } System.out.printf("\n");
    }

    public static boolean isRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    public static void avg(int r1, int c1, int r2, int c2, int[][] ans_grid){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i=r1-1; i<r2; i++){
            for (int j=c1-1; j<c2; j++){
                int sum = grid[i][j];
                int cnt = 1;
                for (int k=0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (isRange(nx, ny)) {
                        sum += grid[nx][ny];
                        cnt++;
                    }
                }
                ans_grid[i][j] = sum / cnt;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        for (int i=0; i<q; i++){
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();
            rotate(r1, c1, r2, c2);
            
            int[][] ans_grid = new int[100][100];
            for(int j = 0; j < grid.length; j++) {
			    ans_grid[j] = grid[j].clone();
		    }
            avg(r1, c1, r2, c2, ans_grid);

            for(int j= 0; j < grid.length; j++) {
			    grid[j] = ans_grid[j].clone();
		    }
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                System.out.printf("%d ", grid[i][j]);
            }
            System.out.printf("\n");
        }
    }
}