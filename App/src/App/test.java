package App;

import javax.swing.*;
import java.util.ArrayList;

public class test {
    private test(){

    }

    public static Boolean containuser(ArrayList<User> users, String name){
        User now;
        for(int i = 0; i < users.size(); i++){
            now = users.get(i);
            if(now.getName().equals(name)) return true;
        }
        return false;
    }

    public static Boolean check(ArrayList<User> users,String password){
        User now;
        for(int i = 0 ; i < users.size(); i++){
            now = users.get(i);
            if(now.getPassword().equals(password)) return true;
        }
        return false;
    }
    public static void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }
}
