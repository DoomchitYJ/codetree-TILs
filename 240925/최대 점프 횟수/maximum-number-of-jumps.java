import java.util.*;

public class Main {
    public static int n;
    public static int[] arr = new int[1000];
    public static int[] dp = new int[1000];
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = -1;
        }
        dp[0] = 0;
        for (int i=1; i<n; i++) {
            if (dp[i-1] == -1) continue;
            for (int j=0; j<i; j++) {
                if (j + arr[j] >= i) dp[i] = Math.max(dp[j]+1, dp[i]);
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
        // 여기에 코드를 작성해주세요.
    }
}