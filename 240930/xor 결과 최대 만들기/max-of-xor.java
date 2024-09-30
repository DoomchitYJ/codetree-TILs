import java.util.*;

public class Main {
    public static int n, m, ans;
    public static int[] arr = new int[20];
    public static boolean[] visited = new boolean[20];

    public static void comb(int start, int r) {
        if (r == 0) {
            int num = 0;
            for (int i=0; i<n; i++) {
                if (visited[i]) {
                    if (num == 0) num = arr[i];
                    else num ^= arr[i];
                }
            }
            ans = Math.max(ans, num);
            // System.out.println(ans);
            return;
        }
        else {
            for (int i=start; i<n; i++) {
                visited[i] = true;
                comb(i+1, r-1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i=0; i<n; i++) arr[i] = sc.nextInt();

        comb(0, m);
        System.out.print(ans);
    }
}