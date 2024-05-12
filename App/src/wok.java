import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class wok {
    public static void main(String[] args) {
        int[] jiechen = new int[10000];
        int now = 1;
        for (int i = 1; i < 10000; i++) {
            now *= i;
            jiechen[i] = now;
        }
        Scanner sc = new Scanner(System.in);
        double ans = 0;
        int n; n = sc.nextInt();
        now = 1;
        while(now <= n){
            ans += (double)1/(double)jiechen[now];
            now++;
        }
        System.out.println(ans);
    }
}


