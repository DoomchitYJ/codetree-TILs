import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int n;
    
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        ArrayList arr = new ArrayList();

        for (int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }

        for (int i=0; i<2; i++){
            ArrayList tmp = new ArrayList();

            int s = sc.nextInt()-1;
            int e = sc.nextInt()-1;

            for (int j=0; j<arr.size(); j++){

                if (s <= j && j <= e) continue;
                tmp.add(arr.get(j));
            }
            arr = tmp;
        }

        int size = arr.size();
        if (size == 0) System.out.println(0);
        else {
            System.out.println(size);
            for (int i=0; i<size; i++) System.out.println(arr.get(i));
        }
    }
}