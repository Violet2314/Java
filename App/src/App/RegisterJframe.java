package App;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class RegisterJframe extends JFrame implements MouseListener {

    ArrayList<User> users = new ArrayList<User>();

    JTextField code1 = new JTextField();
    JTextField username = new JTextField();
    JTextField password = new JTextField();

    JButton registrer = new JButton();
    JButton restart = new JButton();

    public RegisterJframe(ArrayList<User> users){
        this.users = users;

        loginso();

        add();
    }

    private void loginso() {
        setSize(488,430);
        setVisible(true);
        //设置置顶
        setAlwaysOnTop(true);
        //设置居中
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        //取消内部布局
        setLayout(null);
    }

    private void add(){
        getContentPane().removeAll();

        ImageIcon icon = new ImageIcon("image/register/注册用户名.png");
        JLabel usernametext = new JLabel(icon);
        usernametext.setBounds(116,135,47,17);
        getContentPane().add(usernametext);


        username.setBounds(195,134,200,30);
        getContentPane().add(username);

        ImageIcon icon1 = new ImageIcon("image/register/注册密码.png");
        JLabel passwordtext = new JLabel(icon1);
        passwordtext.setBounds(130,195,32,16);
        getContentPane().add(passwordtext);


        password.setBounds(195,195,200,30);
        getContentPane().add(password);

        JLabel code = new JLabel(new ImageIcon("image/register/再次输入密码.png"));
        code.setBounds(133,256,50,30);
        getContentPane().add(code);

        code1.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code1);

        registrer.setBounds(123,310,128,47);
        registrer.setIcon(new ImageIcon("image/register/注册按钮.png"));
        registrer.setBorderPainted(false);
        registrer.setContentAreaFilled(false);
        registrer.addMouseListener(this);
        getContentPane().add(registrer);

        restart.setBounds(256, 310, 128, 47);
        restart.setIcon(new ImageIcon("image/register/重置按钮.png"));
        //去除按钮的默认边框
        restart.setBorderPainted(false);
        //去除按钮的默认背景
        restart.setContentAreaFilled(false);
        restart.addMouseListener(this);
        this.getContentPane().add(restart);

        ImageIcon iconb = new ImageIcon("image/register/background.png");
        JLabel background = new JLabel(iconb);
        background.setBounds(0,0,470,390);
        getContentPane().add(background);

        getContentPane().repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String usertext = username.getText();
        String password1 = password.getText();
        String password2 = code1.getText();

        if(usertext.length() == 0 || password1.length() == 0 ||password2.length() == 0){
            test.showJDialog("输出不能为空");
            return;
        }
        if((test.containuser(users,usertext))){
            test.showJDialog("用户名已存在");
            return;
        }
        if(!(password1.equals(password2))){
            test.showJDialog("两次输入的密码不相同");
            return;
        }

        User now = new User(usertext,password1);
        users.add(now);
        new LoginJframe(users);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == registrer){
            registrer.setIcon(new ImageIcon("image/register/注册按下.png"));
        } else if (e.getSource() == restart) {
            restart.setIcon(new ImageIcon("image/register/重置按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == registrer){
            registrer.setIcon(new ImageIcon("image/register/注册按钮.png"));
        } else if (e.getSource() == restart) {
            restart.setIcon(new ImageIcon("image/register/重置按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
