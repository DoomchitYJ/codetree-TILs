// 240909 17:47 ~ 
import java.util.*;

public class Main {
    public static int n;
    public static int[] fibo = new int[45];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        fibo[0] = 1; fibo[1] = 1;
        for (int i=2; i<n; i++){
            fibo[i] = fibo[i-2] + fibo[i-1];
        }
        System.out.println(fibo[n-1]);
        // 여기에 코드를 작성해주세요.
    }
}