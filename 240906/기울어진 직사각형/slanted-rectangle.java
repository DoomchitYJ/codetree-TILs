import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int n;
    public static int[][] arr = new int[20][20];

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static int get_sum(int x, int y, int width, int height) {
            int ret = 0;

            int[] dx = {1, 1, -1, -1};
            int[] dy = {1, -1, -1, 1};
            int[] length = {width, height, width, height};

            for(int i=0; i<4; i++){                
                for (int j=0; j<length[i]; j++){
                    x += dx[i];
                    y += dy[i];

                    if (!inRange(x, y)) {
                        return 0;
                    }

                    ret += arr[x][y];    
                } 
            }

            return ret;
        }


    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int width=1; width<n; width++){
                    for(int height=1; height<n; height++){
                        int tmp = get_sum(i, j, width, height);
                        if (tmp > ans) ans = tmp;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}