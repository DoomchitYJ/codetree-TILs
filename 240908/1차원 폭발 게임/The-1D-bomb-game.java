import java.util.*;

public class Main {
    public static int n, m, origin_size, size;
    public static int[] arr = new int[100];
    public static int[] new_arr = new int[100];
    public static ArrayList bombRange = new ArrayList();

    public static boolean bomb(){
        if (origin_size == 0) return false;

        int bomb_num = 0;
        int cnt = 1;
        for (int i=1; i<origin_size; i++){
            if (arr[i-1] == arr[i]) cnt++;
            else {
                if (cnt >= m){
                    bombRange.add(i-cnt);
                    bombRange.add(i-1);
                    size -= cnt;
                    bomb_num++;
                }
                cnt = 1;
            }
        }
        if (cnt >= m){
            bombRange.add(origin_size-cnt);
            bombRange.add(origin_size-1);
            size -= cnt;
            bomb_num++;
        }
        
        for (int i=0; i<origin_size; i++){
            new_arr[i] = arr[i];
        }
        for (int i=0; i<2*bomb_num; i+=2){
            int s = (int)bombRange.get(i);
            int e = (int)bombRange.get(i+1);
            // System.out.printf("%d, %d\n", s, e);
            for(int j=s; j<=e; j++) new_arr[j] = 0;
        }
        // for (int i=0; i<origin_size; i++) System.out.print(new_arr[i]+" ");
        // System.out.println();
        
        int tmp = 0;
        for (int i=0; i<origin_size; i++){
            if (new_arr[i] != 0) arr[tmp++] = new_arr[i]; 
        }
        // for (int i=0; i<size; i++) System.out.print(arr[i]+" ");
        // System.out.println();

        origin_size = size;
        bombRange = new ArrayList();
        if (bomb_num != 0) return true;
        else return false;
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        origin_size = n;
        size = n;

        for (int i=0; i<n; i++) arr[i] = sc.nextInt();

        boolean check = true;

        while (check){
            check = bomb();
        }

        if (size == 0) System.out.println(0);
        else {
            System.out.println(size);
            for (int i=0; i<size; i++){
                System.out.println(arr[i]);
            }
        }
    }
}