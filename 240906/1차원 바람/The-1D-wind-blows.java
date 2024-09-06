import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int n, m, q;
    public static ArrayList command = new ArrayList();
    public static int[][] grid = new int[100][100];

    // L == True
    // F == False

    public static boolean shift(int line, boolean dir){
        if (dir == true){
            int tmp = grid[line-1][m-1];
            for (int i=m-1; i>0; i--){
                grid[line-1][i] = grid[line-1][i-1];
            }
            grid[line-1][0] = tmp;
        }
        else{
            int tmp = grid[line-1][0];
            for (int i=0; i<m-1; i++){
                grid[line-1][i] = grid[line-1][i+1];
            }
            grid[line-1][m-1] = tmp;
        }

        // for (int i=0; i<n; i++){
        //     for (int j=0; j<m; j++){
        //         System.out.printf("%d ", grid[i][j]);                
        //     }
        //     System.out.printf("\n");
        // }

        return !dir;
    }

    public static boolean check(int line, String dir){
        if (dir == "up"){
            if (line == 1) return false;
            for (int i=0; i<m; i++){
                if (grid[line-1][i] == grid[line-2][i]) return true;
            }
        }
        else if (dir == "down"){
            if (line == n) return false;
            for (int i=0; i<m; i++){
                if (grid[line-1][i] == grid[line][i]) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                grid[i][j] = sc.nextInt();                
            }
        }

        for (int k=0; k<q; k++){
            int line = sc.nextInt();
            char dir = sc.next().charAt(0);
            boolean ddir = true;
            if (dir == 'R') ddir = false;
            
            // System.out.print(line);
            // System.out.print(dir);                

            // System.out.println(ddir);                

            boolean new_dir_up = shift(line, ddir);
            boolean new_dir_down = new_dir_up;

            for (int i=line; i>0; i--) {
                // System.out.println(i);
                if (check(i, "up")) new_dir_up = shift(i-1, new_dir_up);
                else break;
            }
            for (int i=line; i<n; i++) {
                // System.out.println(i);
                if (check(i, "down")) new_dir_down = shift(i+1, new_dir_down);
                else break;
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                System.out.printf("%d ", grid[i][j]);                
            }
            System.out.printf("\n");
        }
    }
}

/*
1. 옮기기
2. 확인하기
3. 반복
*/



// 재귀로 풀어보기 !!!!!!!!