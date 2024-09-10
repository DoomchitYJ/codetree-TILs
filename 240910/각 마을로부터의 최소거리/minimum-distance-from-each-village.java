import java.util.*;

public class Main {
    public static int n;
    public static ArrayList x = new ArrayList();
    public static ArrayList a = new ArrayList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i=0; i<n; i++){
            x.add(sc.nextInt());
            a.add(sc.nextInt());
        }

        int min = 0;
        int idx = 0;
        for (int i=0; i<n; i++){
            int cnt = 0;
            for (int j=0; j<n; j++){
                if (i == j) continue;

                int dist = Math.abs((int)x.get(i)-(int)x.get(j))*(int)a.get(j);
                cnt += dist; 
            }
            if (i == 0) min = cnt;
            if (cnt < min) {
                min = cnt;
                idx = i;
            }
        }
        System.out.println(idx+1);
    }
}