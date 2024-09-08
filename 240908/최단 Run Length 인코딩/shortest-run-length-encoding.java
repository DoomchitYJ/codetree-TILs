import java.util.Scanner;

public class Main {
    public static String s;

    public static int program(String str){
        String ans = "";
        char prev = str.charAt(0);
        int cnt = 1;
        for (int i=1; i<str.length(); i++){
            char tmp = str.charAt(i);
            if(tmp == prev) cnt++;
            else {
                ans = ans + prev + Integer.toString(cnt);
                prev = tmp;
                cnt = 1;
            } 
        }
        ans = ans + prev + Integer.toString(cnt);
        // System.out.println(ans);
        return ans.length();
    }
    public static void shift(){
        int length = s.length();
        char tmp = s.charAt(length-1);
        String new_s = s.substring(0, length-1);
        s = tmp + new_s;
        // System.out.printf("%s, %s, %s\n", tmp, s, new_s);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();

        int min = program(s);
        for (int i=0; i<s.length()-1; i++){
            shift();
            int tmp = program(s);
            if (tmp < min) min = tmp;
        }
        System.out.println(min);
    }
}