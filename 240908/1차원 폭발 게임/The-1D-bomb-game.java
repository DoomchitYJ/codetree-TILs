import java.util.*;

public class Main {
    public static int n, m, origin_size, size;
    public static int[] arr = new int[100];
    public static int[] new_arr = new int[100];
    public static ArrayList bombRange = new ArrayList();

    public static boolean bomb(){
        if (origin_size == 0) return false; // 만약 폭탄이 없다면 더이상 터질 폭탄이 없다는 의미이므로 바로 false 반환

        int bomb_num = 0; // 터질 폭탄의 개수
        int cnt = 1; // 연속하는 폭탄의 개수
        for (int i=1; i<origin_size; i++){ // 1번째 폭탄부터 확인한다. 이전 폭탄과 같은 값이면 cnt++
            if (arr[i-1] == arr[i]) cnt++;
            
            /* 만약 이번 폭탄과 이전 폭탄이 다를 경우, (s, e)로 폭탄의 range를 저장한다. 
            -> size를 cnt만큼 줄여 터진 후의 폭탄 개수를 저장한다.
            -> 터지는 폭탄 구간의 수를 저장한다.
            */
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
        
        // new_arr에 arr 복사.
        for (int i=0; i<origin_size; i++){
            new_arr[i] = arr[i];
        }

        // 폭발 구간을 확인하며 해당 구간을 0으로 바꾼다.
        for (int i=0; i<2*bomb_num; i+=2){
            int s = (int)bombRange.get(i);
            int e = (int)bombRange.get(i+1);
            for(int j=s; j<=e; j++) new_arr[j] = 0;
        }
        
        // 0인 구간을 제외한 숫자만 arr에 다시 저장한다.
        int tmp = 0;
        for (int i=0; i<origin_size; i++){
            if (new_arr[i] != 0) arr[tmp++] = new_arr[i]; 
        }

        // 이제 폭탄이 터졌으므로 origin_size가 곧 size가 되고 폭발 구간 저장 array를 초기화한다.
        origin_size = size;
        bombRange = new ArrayList();

        // 만약 폭발 구간의 수가 0이라면 터질 폭탄이 없다는 의미이므로 false 반환.
        if (bomb_num == 0) return false;
        else return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        origin_size = n; // 폭탄이 터지기 전 총 개수
        size = n; // 폭탄이 터진 후 총 개수

        for (int i=0; i<n; i++) arr[i] = sc.nextInt();

        boolean check = true; // bomb이라는 함수를 실행할텐데 true면 터질 것이 있다, false면 터질 것이 없다 -> 종료

        while (check){
            check = bomb(); // bomb의 반환형은 boolean
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