import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int n, t;
    public static int[] belt = new int[400];
    public static ArrayList new_belt = new ArrayList();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();

        for (int i=0; i<2*n; i++){
            belt[i] = sc.nextInt();
        }

        int nt = t % (2*n);

        for (int i=2*n-nt; i<2*n; i++){
            new_belt.add(belt[i]);
        }

        for (int i=0; i<2*n-nt; i++){
            new_belt.add(belt[i]);
        }

        for (int i=0; i<2; i++){
            System.out.printf("%d ", new_belt.get(3*i));
            System.out.printf("%d ", new_belt.get(3*i+1));
            System.out.printf("%d\n", new_belt.get(3*i+2));
        }
    }
}

// 123651