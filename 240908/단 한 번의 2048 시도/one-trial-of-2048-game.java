// 20:52 ~ 

import java.util.*;

public class Main {
    public static int[][] grid = new int[4][4];
    public static int[][] tmp = new int[4][4];
    public static char dir;

    public static void print(){
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                System.out.print(tmp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void shift(){
        if (dir == 'R'){
            // 오른쪽으로 먼저 몰기
            for (int i=0; i<4; i++){
                int col = 3;
                for (int j=3; j>=0; j--){
                    if (grid[i][j] != 0) {
                        tmp[i][col--] = grid[i][j];
                    }
                }
            }
            // print();
            
            // 합치기
            for (int i=0; i<4; i++){
                for (int j=3; j>0; j--){
                    if (tmp[i][j] == tmp[i][j-1]) {
                        tmp[i][j] = 2*tmp[i][j];
                        tmp[i][j-1] = 0;
                    }
                }
            }
            // print();


            // 다시 오른쪽으로 몰기
            for (int i=0; i<4; i++){
                for (int j=3; j>0; j--){
                    if (tmp[i][j] == 0) {
                        int temp = tmp[i][j];
                        tmp[i][j] = tmp[i][j-1];
                        tmp[i][j-1] = temp;
                    }
                }
            }
            // print();
        }

        else if (dir == 'L'){
            // 왼쪽으로 먼저 몰기
            for (int i=0; i<4; i++){
                int col = 0;
                for (int j=0; j<4; j++){
                    if (grid[i][j] != 0) {
                        tmp[i][col++] = grid[i][j];
                    }
                }
            }
            // print();
            
            // 합치기
            for (int i=0; i<4; i++){
                for (int j=0; j<3; j++){
                    if (tmp[i][j] == tmp[i][j+1]) {
                        tmp[i][j] *= 2;
                        tmp[i][j+1] = 0;
                    }
                }
            }
            // print();

            // 다시 왼쪽으로 몰기
            for (int i=0; i<4; i++){
                for (int j=0; j<3; j++){
                    if (tmp[i][j] == 0) {
                        int temp = tmp[i][j];
                        tmp[i][j] = tmp[i][j+1];
                        tmp[i][j+1] = temp;
                    }
                }
            }
            // print();
        }

        else if (dir == 'U'){
            // 위쪽으로 먼저 몰기
            for (int j=0; j<4; j++){
                int row = 0;
                for (int i=0; i<4; i++){
                    if (grid[i][j] != 0) {
                        tmp[row++][j] = grid[i][j];
                    }
                }
            }
            // print();
            
            // 합치기
            for (int j=0; j<4; j++){
                for (int i=0; i<3; i++){
                    if (tmp[i][j] == tmp[i+1][j]) {
                        tmp[i][j] *= 2;
                        tmp[i+1][j] = 0;
                    }
                }
            }
            // print();

            // 다시 위쪽으로 몰기
            for (int j=0; j<4; j++){
                for (int i=0; i<3; i++){
                    if (tmp[i][j] == 0) {
                        int temp = tmp[i][j];
                        tmp[i][j] = tmp[i+1][j];
                        tmp[i+1][j] = temp;
                    }
                }
            }
            // print();
        }

        if (dir == 'D'){
            // 아래쪽으로 먼저 몰기
            for (int j=0; j<4; j++){
                int row = 3;
                for (int i=3; i>=0; i--){
                    if (grid[i][j] != 0) {
                        tmp[row--][j] = grid[i][j];
                    }
                }
            }
            // print();
            
            // 합치기
            for (int j=0; j<4; j++){
                for (int i=3; i>0; i--){
                    if (tmp[i][j] == tmp[i-1][j]) {
                        tmp[i][j] = 2*tmp[i][j];
                        tmp[i-1][j] = 0;
                    }
                }
            }
            // print();

            // 다시 아래쪽으로 몰기
            for (int j=0; j<4; j++){
                for (int i=3; i>0; i--){
                    if (tmp[i][j] == 0) {
                        int temp = tmp[i][j];
                        tmp[i][j] = tmp[i-1][j];
                        tmp[i-1][j] = temp;
                    }
                }
            }
            // print();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                grid[i][j] = sc.nextInt();
                tmp[i][j] = -1;
            }
        }
        dir = sc.next().charAt(0);

        shift();

        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (tmp[i][j] < 0) System.out.print("0 ");
                else System.out.print(tmp[i][j]+" ");
            }
            System.out.println();
        }
    }
}