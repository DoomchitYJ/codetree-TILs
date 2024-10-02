import java.util.*;

class Set {
    String first, second, third;

    public Set(String x, String y, String z) {
        this.first = x; this.second = y; this.third = z;
    }
}
public class Main {
    public static int n;
    public static ArrayList<Set> arr = new ArrayList<Set>();

    public static void comp(String a, String b) {
        if (Integer.parseInt(a.substring(0, 4)) < Integer.parseInt(b.substring(0, 4))) arr.remove(1);
        else if (Integer.parseInt(a.substring(0, 4)) > Integer.parseInt(b.substring(0, 4))) arr.remove(0);
        else {
            if (Integer.parseInt(a.substring(5, 7)) < Integer.parseInt(b.substring(5, 7))) arr.remove(1);
            else if (Integer.parseInt(a.substring(5, 7)) > Integer.parseInt(b.substring(5, 7))) arr.remove(0);
            else {
                if (Integer.parseInt(a.substring(8, 10)) < Integer.parseInt(b.substring(8, 10))) arr.remove(1);
                else if (Integer.parseInt(a.substring(8, 10)) > Integer.parseInt(b.substring(8, 10))) arr.remove(0);
            }
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            String date = sc.next();
            String day = sc.next();
            String weather = sc.next();

            if (weather.equals("Rain")) arr.add(new Set(date, day, weather));
            while (arr.size() > 1) {
                comp(arr.get(0).first, arr.get(1).first);
            }

        }
        
        System.out.printf("%s %s %s", arr.get(0).first, arr.get(0).second, arr.get(0).third);
    }
}