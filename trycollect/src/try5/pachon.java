package try5;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pachon {
    public static void main(String[] args) throws IOException {

        String boynameweb= "http://www.haoming8.cn/baobao/10881.html";
        String xing = "https://www.yuwenmi.com/guoxue/baijiaxing/847430.html";
        String girlnameweb = "http://www.haoming8.cn/baobao/7641.html";

        String start = getdate(xing,"gb2312");
        String boyname = getdate(boynameweb,"utf-8");
        String girlname = getdate(girlnameweb,"utf-8");

        ArrayList<String> first1 = getname(start, "([\\u4E00-\\u9FA5]{4} ){3}....",0);
        ArrayList<String> boy = getname(boyname, "([\\u4E00-\\u9FA5][\\u4E00-\\u9FA5])、", 1);
        ArrayList<String> girl1 = getname(girlname,"(.. ){4}..",0);
        
        ArrayList<String> girl = new ArrayList<>();
        ArrayList<String> first = new ArrayList<>();
        for (String s : girl1) {
            String[] s1 = s.split(" ");
            for (String string : s1) {
                girl.add(string);
            }
        }
        for (String s : first1) {
            String[] s1 = s.split(" ");
            for (String string : s1) {
                for(int i = 0; i <= 3; i++){
                    first.add(string.charAt(i) + "");
                }
            }
        }


        ArrayList<String> sum = getsum(first,boy,girl,20,20);

        File so = new File("name.txt");
        //PrintStream file = new PrintStream(so)怎么改为续写,直接在里面创建一个
        //是字节流的一种
        PrintStream file = new PrintStream(new FileOutputStream(so, true));

        for (String s : sum) {
            file.println(s);
        }

        file.close();
    }

    public static String getdate(String src,String bian) throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(src);
        URLConnection conn = url.openConnection();

        InputStreamReader isr = new InputStreamReader(conn.getInputStream(),bian);
        char[] chars = new char[1024];
        int len;
        while((len = isr.read(chars)) != -1){
            sb.append(new String(chars,0,len));
        }
        isr.close();
        return sb.toString();
    }

    public static ArrayList<String> getname(String src,String zhen,int index){

        ArrayList<String> ans = new ArrayList<>();

        Pattern p = Pattern.compile(zhen);
        Matcher m = p.matcher(src);
        while(m.find()){
            ans.add(m.group(index));
        }
        return ans;
    }

    public static ArrayList<String> getsum(ArrayList<String> first, ArrayList<String> boy, ArrayList<String> girl, int boynum, int girlnum){
        ArrayList<String> sum = new ArrayList<>();
        HashSet<String> boyname = new HashSet<>();
        HashSet<String> girlname = new HashSet<>();

        Random r = new Random();
        while(boyname.size() < boynum){
            Collections.shuffle(first);
            Collections.shuffle(boy);
            String so = first.get(1) + boy.get(1);
            boyname.add(so);
        }

        while(girlname.size() < girlnum){
            Collections.shuffle(first);
            Collections.shuffle(girl);
            String so = first.get(1) + girl.get(1);
            girlname.add(so);
        }

        for (String s : boyname) {
            int wok = r.nextInt(10) + 18;
            String wokk = Integer.toString(wok);
            sum.add(s + "-男-" + wokk);
        }

        for (String s : girlname) {
            int wok = r.nextInt(10) + 18;
            String wokk = Integer.toString(wok);
            sum.add(s + "-女-" + wokk);
        }

        return sum;
    }
}
