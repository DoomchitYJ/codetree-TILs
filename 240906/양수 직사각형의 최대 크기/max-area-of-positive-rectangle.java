import java.util.Scanner;

public class Main {
    public static int n, m;
    public static int[][] arr = new int[20][20];

    public static boolean inRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    public static boolean get_area(int x, int y, int w, int h){
        int sum = 0;
        for(int i=x; i<x+w; i++){
            for(int j=y; j<y+h; j++){
                if (!inRange(i, j)) break;
                sum += arr[i][j];
            }
        }
        if (sum > 0) return true;
        else return false;
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                for (int w=1; w<n+1; w++){
                    for (int h=1; h<m+1; h++){
                        if (get_area(i, j, w, h)) {
                            int tmp = w*h;
                            if (tmp > ans) ans = tmp;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}