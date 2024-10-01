import java.util.*;

class Pair implements Comparable<Pair> {
    int first, second;

    public Pair(){}

    public Pair(int x, int y) {
        this.first = x; this.second = y;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.first == p.first) {
            return Integer.compare(this.second, p.second);
        } else return Integer.compare(this.first, p.first);
    }
}

public class Main {
    public static int n, m, dist_max;
    public static int ans = Integer.MAX_VALUE;
    public static Pair[] dots = new Pair[20];
    public static ArrayList<Pair> selected_dots = new ArrayList<Pair>();
    public static boolean[] visited = new boolean[20];

    public static void comb2(int start, int r) {
        if (r == 0) {
            ArrayList<Pair> a = new ArrayList<Pair>();

            for (int i=0; i<m; i++) {
                if (visited[i]) a.add(selected_dots.get(i));
            }
            int dist = (int) (Math.pow((a.get(0).first - a.get(1).first), 2) + Math.pow((a.get(0).second - a.get(1).second), 2));
            dist_max = Math.max(dist_max, dist);
            return;
        }
        
        for (int i=start; i<selected_dots.size(); i++) {
            visited[i] = true;
            comb2(i+1, r-1);
            visited[i] = false;
        }
    }
    public static void comb(int start, int r) {
        if (r == 0) {
            comb2(0, 2);
            ans = Math.min(ans, dist_max);
            dist_max = 0;
            visited = new boolean[20];
            return;
        }

        for (int i=start; i<n; i++) {
            selected_dots.add(dots[i]);
            comb(i+1, r-1);
            selected_dots.remove(selected_dots.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            dots[i] = new Pair(x, y);
        }

        comb(0, m);
        System.out.print(ans);
    }
}


// 0 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0
// 0 1 0 0 0 0 0 0 1 0
// 0 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0
// 0 1 0 0 0 0 0 0 0 0