package App;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJframe extends JFrame implements MouseListener {

    JButton login = new JButton();
    JButton register = new JButton();

    JTextField code1 = new JTextField();
    JTextField username = new JTextField();
    JTextField password = new JTextField();

    ArrayList<User> users;

    public LoginJframe(ArrayList<User> users){
        this.users = users;

        login();

        addsome();

        this.setVisible(true);
    }

    private void login() {
        setSize(488,430);
        setVisible(true);
        //设置置顶
        setAlwaysOnTop(true);
        //设置居中
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        //取消内部布局
        setLayout(null);

        addMouseListener(this);
    }

    private void addsome(){
        getContentPane().removeAll();

        ImageIcon icon = new ImageIcon("image/login/用户名.png");
        JLabel usernametext = new JLabel(icon);
        usernametext.setBounds(116,135,47,17);
        getContentPane().add(usernametext);


        username.setBounds(195,134,200,30);
        getContentPane().add(username);
        ImageIcon icon1 = new ImageIcon("image/login/密码.png");
        JLabel passwordtext = new JLabel(icon1);
        passwordtext.setBounds(130,195,32,16);
        getContentPane().add(passwordtext);


        password.setBounds(195,195,200,30);
        getContentPane().add(password);
        JLabel code = new JLabel(new ImageIcon("image/login/验证码.png"));
        code.setBounds(133,256,50,30);
        getContentPane().add(code);


        code1.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code1);

        JLabel shouldcode  = new JLabel();
        shouldcode.setText("9999");
        shouldcode.setBounds(300,256,50,30);
        getContentPane().add(shouldcode);

        login.setBounds(123,310,128,47);
        login.setIcon(new ImageIcon("image/login/登录按钮.png"));
        login.setBorderPainted(false);
        login.setContentAreaFilled(false);
        login.addMouseListener(this);
        getContentPane().add(login);

        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("image/register/注册按钮.png"));
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        register.addMouseListener(this);
        this.getContentPane().add(register);

        ImageIcon iconb = new ImageIcon("image/login/background.png");
        JLabel back = new JLabel(iconb);
        back.setBounds(0,0,470,390);
        getContentPane().add(back);

        getContentPane().repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == login){
            System.out.println("wok");

            String usernamefile = username.getText();
            String passwordfile = password.getText();
            String should = code1.getText();

            if(usernamefile.length() == 0 || passwordfile.length() == 0 || should.length() == 0){
                showJDialog("输入不能为空");
                return;
            }

            if(!(containuser(users,usernamefile))){
                showJDialog("用户不存在，请去注册");
                return;
            }
            if(!(check(users,passwordfile))){
                showJDialog("密码错误");
                return;
            }
            new GameJframe(users);
        } else if (e.getSource() == register) {
            System.out.println("so");
            new RegisterJframe(users);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == login){
            login.setIcon(new ImageIcon("image/login/登录按下.png"));
        } else if (e.getSource() == register) {
            register.setIcon((new ImageIcon("image/register/注册按下.png")));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == login){
            login.setIcon(new ImageIcon("image/login/登录按钮.png"));
        } else if (e.getSource() == register) {
            register.setIcon((new ImageIcon("image/register/注册按钮.png")));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public Boolean containuser(ArrayList<User> users,String name){
        User now;
        for(int i = 0; i < users.size(); i++){
            now = users.get(i);
            if(now.getName().equals(name)) return true;
        }
        return false;
    }

    public Boolean check(ArrayList<User> users,String password){
        User now;
        for(int i = 0 ; i < users.size(); i++){
            now = users.get(i);
            if(now.getPassword().equals(password)) return true;
        }
        return false;
    }
    public void showJDialog(String content) {
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
