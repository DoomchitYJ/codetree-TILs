// 24.09.08 23:02 ~

import java.util.*;

public class Main {
    public static int n, m;
    public static ArrayList[] graph = new ArrayList[1001];
    public static int[] cnt = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i=0; i<n; i++) graph[i] = new ArrayList();
        
        for (int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            cnt[a]++;
        }

        System.out.println(cnt[1]);
    }
}