import java.util.*;

public class Main {
    public static class Triple implements Comparable<Triple> {
        long first, second;
        int third;

        public Triple() {}

        public Triple(long x, long y, int p) {
            this.first = x; this.second = y; this.third = p;
        }

        @Override
        public int compareTo(Triple t) {
            return Long.compare(this.first, t.first);
        }
    }

    public static int n;
    public static long ans;
    public static Triple[] arr = new Triple[1000];
    public static int[] pay = new int[1000];
    public static long[] dp = new long[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            long s = sc.nextLong();
            long e = sc.nextLong();
            int p = sc.nextInt();
            arr[i] = new Triple(s, e, p);
        }

        Arrays.sort(arr, 0, n);
        for (int i=0; i<n; i++) {
            dp[i] = arr[i].third;
            long a = arr[i].first;
            for (int j=0; j<i; j++) {
                long b = arr[j].second;
                if (a > b) dp[i] = Math.max(dp[j]+arr[i].third, dp[i]);
            }
        }
        for (int i=0; i<n; i++) {
            // System.out.printf("%d ", dp[i]);
            ans = Math.max(ans, dp[i]);
        }
        // System.out.println();
        System.out.println(ans);
    }
}