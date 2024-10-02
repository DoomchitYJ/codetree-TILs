import java.util.*;

public class Main {
    public static int n, m, ans = -1;
    public static int[][] grid = new int[20][20];

    public static boolean check(int x1, int y1, int x2, int y2) {
        for (int i=x1; i<=x2; i++) {
            for (int j=y1; j<=y2; j++) {
                if (grid[i][j] <= 0) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                grid[i][j] = sc.nextInt();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                for (int k=i; k<n; k++) {
                    for (int l=j; l<m; l++) {
                        if (check(i, j, k, l)) ans = Math.max(ans, (k-i+1)*(l-j+1));
                    }
                }
            }
        }
        
        System.out.print(ans);
    }
}