import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int tmp = get_sum(i, j, n, arr);
                if (tmp > ans) ans = tmp;
            }
        }
        System.out.println(ans);
    }

    public static int get_sum(int x, int y, int n, int[][] arr) {
            int ret = 0;

            for(int i=x+1, j=y; i<n-1; i++){
                j--;
                if(j > 0) {
                    ret += arr[i][j-1];
                    ret += arr[i+1][j];
                }
            }

            int[] dx = {-1, 0, 0, +1};
            int[] dy = {0, -1, +1, 0};
            
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(0<=nx && nx<n && 0<=ny && ny<n) {
                    ret += arr[nx][ny];
                } 
            }

            for(int i=x, j=y+1; j<n-1; j++){
                i--;
                if(i > 0) {
                    ret += arr[i][j+1];
                    ret += arr[i-1][j];
                }
            }


            return ret;
        }
}