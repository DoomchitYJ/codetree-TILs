import java.util.*;

public class Main {
    public static int n, m;
    public static boolean[] visited = new boolean[10];

    public static void comb(int start, int r){
        if (r == 0) {
            for (int i=0; i<n; i++){
                if (visited[i]) System.out.printf("%d ", i+1);
            } System.out.println();
            return;
        } else {
            for (int i=start; i<n; i++){
                visited[i] = true;
                comb(i+1, r-1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        comb(0, m);
    }
}