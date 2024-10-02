import java.util.*;

public class Main {
    public static int n;
    public static ArrayList<Integer> arr = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i=1; i<n+1; i++) {
            arr.add(sc.nextInt());
            
            if (i%2 == 1) {
                Collections.sort(arr);
                int idx = i/2;
                System.out.printf("%d ", arr.get(idx));
            }
        }
    }
}