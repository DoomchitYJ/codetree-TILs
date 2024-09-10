import java.util.*;

public class Main {
    public static int n;
    public static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        for (int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
        }
        System.out.println(dp[n]);
        
        // 여기에 코드를 작성해주세요.
    }
}