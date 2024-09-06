import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int n, t;
    public static ArrayList belt = new ArrayList();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();

        for (int i=0; i<3; i++){
            for (int j=0; j<n; j++){
                belt.add(sc.nextInt());
            }
        }

        int nt = t % (3*n);

        ArrayList new_belt = new ArrayList();

        for (int i=3*n - nt; i<3*n; i++){
            new_belt.add(belt.get(i));
        }
        
        for (int i=0; i<3*n - nt; i++){
            new_belt.add(belt.get(i));
        }

        for (int i=0; i<3; i++){
            for (int j=0; j<n; j++){
                System.out.printf("%d ", new_belt.get(n*i + j));
            }
            System.out.printf("\n");
        }
    }
}


// 124
// 593
// 651

// 1 2 4 5 9 3 6 5 1
// 1 1 2 4 5 9 3 6 5