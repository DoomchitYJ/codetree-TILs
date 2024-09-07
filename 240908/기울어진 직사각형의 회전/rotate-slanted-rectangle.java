import java.util.Scanner;

public class Main {
    public static int n, r, c, m1, m2, m3, m4, dir;
    public static int[][] grid = new int[100][100];
    public static boolean inRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    public static void rotate(){
        // 시계. 이 때 오히려 반시계로 돌아야함.
        if (dir == 1){
            int[] dx = {-1, -1, 1, 1};
            int[] dy = {1, -1, -1, 1};
            
            int nx = r - 1;
            int ny = c - 1;
            int tmp = grid[r - 1][c - 1];

            for (int i=0; i<m4; i++){
                nx += dx[0];
                ny += dy[0];
                if (inRange(nx, ny)) {
                    grid[nx - dx[0]][ny - dy[0]] = grid[nx][ny];
                }
            }
            for (int i=0; i<m3; i++){
                nx += dx[1];
                ny += dy[1];
                if (inRange(nx, ny)) {
                    grid[nx - dx[1]][ny - dy[1]] = grid[nx][ny];
                }
            }
            for (int i=0; i<m2; i++){
                nx += dx[2];
                ny += dy[2];
                if (inRange(nx, ny)) {
                    grid[nx - dx[2]][ny - dy[2]] = grid[nx][ny];
                }
            }
            for (int i=0; i<m1-1; i++){
                nx += dx[3];
                ny += dy[3];
                if (inRange(nx, ny)) {
                    grid[nx - dx[3]][ny - dy[3]] = grid[nx][ny];
                }
            }
            grid[nx][ny] = tmp;
        }

        // 반시계. 오히려 시계방향으로 돌아야함.
        else if (dir == 0){
            int[] dx = {-1, -1, 1, 1};
            int[] dy = {-1, 1, 1, -1};
            
            int nx = r - 1;
            int ny = c - 1;
            int tmp = grid[r - 1][c - 1];

            for (int i=0; i<m4; i++){
                nx += dx[0];
                ny += dy[0];
                if (inRange(nx, ny)) {
                    grid[nx - dx[0]][ny - dy[0]] = grid[nx][ny];
                }
            }
            for (int i=0; i<m3; i++){
                nx += dx[1];
                ny += dy[1];
                if (inRange(nx, ny)) {
                    grid[nx - dx[1]][ny - dy[1]] = grid[nx][ny];
                }
            }
            for (int i=0; i<m2; i++){
                nx += dx[2];
                ny += dy[2];
                if (inRange(nx, ny)) {
                    grid[nx - dx[2]][ny - dy[2]] = grid[nx][ny];
                }
            }
            for (int i=0; i<m1-1; i++){
                nx += dx[3];
                ny += dy[3];
                if (inRange(nx, ny)) {
                    grid[nx - dx[3]][ny - dy[3]] = grid[nx][ny];
                }
            }
            grid[nx][ny] = tmp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        r = sc.nextInt();
        c = sc.nextInt();
        m1 = sc.nextInt();
        m2 = sc.nextInt();
        m3 = sc.nextInt();
        m4 = sc.nextInt();
        dir = sc.nextInt();

        rotate();

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.printf("%d ", grid[i][j]);
            }
            System.out.printf("\n");
        }
    }
}