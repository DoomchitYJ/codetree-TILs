import java.util.*;

public class Main {
    public static int n, t;
    public static int[][] grid = new int[100][100];
    public static ArrayList command = new ArrayList();
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int dir = 1;
    // 1: 상 2: 우 3: 하 4: 좌  기본은 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        String str = sc.next();
        for (int i=0; i<t; i++) command.add(str.charAt(i));
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) grid[i][j] = sc.nextInt();
        }

        int curX = n/2; int curY = n/2;
        int dirX = 0; int dirY = 0;
        int cnt = grid[curX][curY];
        for (int i=0; i<t; i++){
            if ((char)command.get(i) == 'F') {
                curX += dx[dirX]; curY += dy[dirY];
                if (0 <= curX && curX < n && 0 <= curY && curY < n) cnt += grid[curX][curY];
                else {
                    curX -= dx[dirX]; curY -= dy[dirY];
                }
            }
            else if ((char)command.get(i) == 'L') {
                dirX--; dirY--;
                if (dirX == -1) {
                    dirX = 3; dirY = 3;
                }
            }
            else if ((char)command.get(i) == 'R') {
                dirX++; dirY++;
                if (dirX == 4) {
                    dirX = 0; dirY = 0;
                }
            }
        }
        System.out.println(cnt);
    }