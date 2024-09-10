import java.util.*;

public class Main {
    public static int n, t;
    public static int[][] grid = new int[100][100];
    public static ArrayList command = new ArrayList();

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
        int cnt = grid[curX][curY];
        for (int i=0; i<t; i++){
            int[][] new_grid = new int[100][100];

            if ((char)command.get(i) == 'F'){
                curX--;
                if (curX < 0) curX++;
                else {
                    cnt += grid[curX][curY];
                }
                // System.out.printf("go %d, %d ... %d\n", curX, curY, grid[curX][curY]);
                continue;
            }
            else if ((char)command.get(i) == 'L') {
                // System.out.printf("left turn1 %d, %d ... %d\n", curX, curY, grid[curX][curY]);
                for (int j=0; j<n; j++){
                    for (int k=0; k<n; k++){
                        new_grid[j][k] = grid[n-1-k][j];
                    }
                }
                int a = curX; int b = curY;
                curX = b; curY = n-1-a;
                // System.out.printf("left turn2 %d, %d ... %d\n", curX, curY, new_grid[curX][curY]);
            }
            else if ((char)command.get(i) == 'R') {
                // System.out.printf("right turn1 %d, %d ... %d\n", curX, curY, grid[curX][curY]);
                for (int j=0; j<n; j++){
                    for (int k=0; k<n; k++){
                        new_grid[j][k] = grid[k][n-1-j];
                    }
                }
                int a = curX; int b = curY;
                curX = n-1-b; curY = a;
                // System.out.printf("right turn2 %d, %d ... %d\n", curX, curY, new_grid[curX][curY]);
            }
            // for (int j=0; j<n; j++){
            //     for (int k=0; k<n; k++){
            //         grid[j][k] = new_grid[j][k];
            //         System.out.print(grid[j][k]+" ");
            //     }
            //     System.out.println();
            // }
        }
        System.out.println(cnt);
    }
}