import java.util.*;

class Pair implements Comparable<Pair> {
    int height, weight, number;

    public Pair(int x, int y, int z) {
        this.height = x; this.weight = y; this.number = z;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.height == p.height) {
            return p.weight - this.weight;
        } else return this.height - p.height;
    }
}
public class Main {
    public static int n, h, w;
    public static ArrayList<Pair> arr = new ArrayList<Pair>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i=0; i<n; i++) {
            arr.add(new Pair(sc.nextInt(), sc.nextInt(), i+1));
        }
        Collections.sort(arr);

        for (int i=0; i<n; i++) {
            System.out.printf("%d %d %d\n", arr.get(i).height, arr.get(i).weight, arr.get(i).number);
        }
        // 여기에 코드를 작성해주세요.
    }
}