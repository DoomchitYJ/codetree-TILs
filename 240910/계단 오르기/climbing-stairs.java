// 240909 23:57 ~ 

import java.util.*;

public class Main {
    public static int n;
    public static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i=4; i<=n; i++){
            dp[i] = dp[i-2] + dp[i-3];
        }

        System.out.println(dp[n]);
    }
}