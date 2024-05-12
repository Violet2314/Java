package try2;

import java.util.*;

public class tryso {

    static HashMap<Integer,String> mp = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        String[] hua = {"♠", "♥", "♣", "♦"};
        String[] num = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int now = 1;
        for (String s : num) {
            for (String c : hua) {
                list.add(now);
                mp.put(now, s + c);
                now++;
            }
        }
        list.add(now);
        mp.put(now, "小王");
        now++;
        list.add(now);
        mp.put(now, "大王");

        TreeSet<Integer> di = new TreeSet<>();
        TreeSet<Integer> user1 = new TreeSet<>();
        TreeSet<Integer> user2 = new TreeSet<>();
        TreeSet<Integer> user3 = new TreeSet<>();

        Collections.shuffle(list);

        for (int i = 0; i < list.size(); i++) {
            if (i <= 2) {
                di.add(list.get(i));
            } else {
                if (i % 3 == 0) user1.add(list.get(i));
                else if (i % 3 == 1) user2.add(list.get(i));
                else user3.add(list.get(i));
            }
        }

        print(di,"底牌");
        print(user1,"我");
        print(user2,"你");
        print(user3,"他");

    }

    static void print(TreeSet<Integer> now,String name){
        System.out.print(name + ": ");
        for (Integer i : now) {
           String s = mp.get(i);
           System.out.print(s + " ");
        }
        System.out.print("\n");
    }

}
