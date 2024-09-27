import java.util.*;

public class Main {
    public static int n, ans;
    public static int[] arr = new int[1000];
    public static int[] dp1 = new int[1000];
    public static int[] dp2 = new int[1000];
    public static boolean check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) arr[i] = sc.nextInt();

        for (int i=0; i<n; i++) {
            dp1[i] = 1;

            for (int j=0; j<i; j++) {
                if (arr[j] < arr[i]) dp1[i] = Math.max(dp1[i], dp1[j]+1);
            }

            for (int j=i; j<n; j++) {
                dp2[j] = 1;
                for (int k=i; k<j; k++){
                    if (arr[j] < arr[k]) {
                        dp2[j] = Math.max(dp2[j], dp2[k]+1);
                    }
                }
            }

            int cnt1 = 0;
            int cnt2 = 0;
            for (int j=0; j<n; j++) {
                cnt1 = Math.max(dp1[j], cnt1);
                cnt2 = Math.max(dp2[j], cnt2);
                ans = Math.max(cnt1+cnt2, ans);
            }

            // dp2 = new int[1000];
        }
        System.out.println(ans-1);
    }
}