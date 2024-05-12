package App;

import java.util.ArrayList;

public class App {

    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        new GameJframe(users);
        fangxi wok = new fangxi();
        ArrayList<String> a = new ArrayList<>();
        String s = "2";
        wok.add(a,s);
    }
}
