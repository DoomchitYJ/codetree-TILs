// 24.09.08 23:02 ~

import java.util.*;

public class Main {
    public static int n, m, cnt;
    public static ArrayList[] graph = new ArrayList[1001];
    public static boolean[] visited = new boolean[1001];

    public static void dfs(int x){
        visited[x] = true;

        for (int i=0; i<graph[x].size(); i++){
            int cur = (int)graph[x].get(i);
            if (!visited[cur]) {
                cnt++;
                dfs(cur);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i=0; i<=n; i++) graph[i] = new ArrayList();
        
        for (int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);
        System.out.print(cnt);
    }
}