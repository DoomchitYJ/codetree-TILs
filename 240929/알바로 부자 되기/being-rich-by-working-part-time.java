import java.util.*;

public class Main {
    public static class Pair implements Comparable<Pair> {
        long first, second;

        public Pair() {}

        public Pair(long x, long y) {
            this.first = x; this.second = y;
        }

        @Override
        public int compareTo(Pair p) {
            return Long.compare(this.first, p.first);
        }
    }

    public static int n;
    public static long ans;
    public static Pair[] arr = new Pair[1000];
    public static int[] pay = new int[1000];
    public static long[] dp = new long[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            long s = sc.nextLong();
            long e = sc.nextLong();
            int p = sc.nextInt();
            arr[i] = new Pair(s, e);
            pay[i] = p;
        }

        Arrays.sort(arr, 0, n);
        for (int i=0; i<n; i++) {
            dp[i] = pay[i];
            long a = arr[i].first;
            for (int j=0; j<i; j++) {
                long b = arr[j].second;
                if (a > b) dp[i] = Math.max(dp[j]+pay[j], dp[i]);
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