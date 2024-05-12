package try2;

import java.util.Scanner;

public class yinhan {
    public static void main(String[] args) {
        int now = 1000;
        int get = 0;
        Scanner sc = new Scanner(System.in);
        do{
            int qu = sc.nextInt();
            while(qu>now){
                System.out.println("不够");
                System.out.print("输入取款：");
                qu = sc.nextInt();
            }
            now -= qu;
            System.out.println("剩余金额：" +now+ "是否继续('1',结束，‘2’：继续)");

            get = sc.nextInt();
            System.out.print(get);
        }while(get == 2);
    }
}
