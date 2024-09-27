import java.util.*;

class Pair implements Comparable<Pair> {
    int first; int second;

    public Pair(int a, int b) {
        this.first = a; this.second = b;
    }

    @Override
    public int compareTo(Pair p) {
        return this.first - p.first;
    }
}
public class Main {
    public static int n;
    public static Pair[] lines = new Pair[1000];
    public static int[] dp = new int[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            lines[i] = new Pair(x1, x2);
        }

        Arrays.sort(lines, 0, n);

        for (int i=0; i<n; i++) {
            dp[i] = 1;

            for (int j=0; j<i; j++) {
                int a = lines[i].first;
                int b = lines[j].second;

                if (b < a)
                    dp[i] = Math.max(dp[j]+1, dp[i]);
            }
        }

        int ans = 0;
        for (int i=0; i<n; i++){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}