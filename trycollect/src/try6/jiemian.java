package try6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class jiemian extends JFrame implements ActionListener {

    File file = new File("name.txt");
    JButton rightCode = new JButton();
    JLabel shueiji = new JLabel();
    ArrayList<String> user = new ArrayList<>();

    public jiemian() throws IOException {
        getuser();
        setting();
        addsome();
        this.setVisible(true);
    }
    private void getuser() throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line;
        while((line = re.readLine()) != null){
            user.add(line);
        }
        re.close();
    }

    private void addsome() {
        Font rightCodeFont = new Font(null,1,30);
        //设置颜色
        rightCode.setForeground(Color.black);
        //设置字体
        rightCode.setFont(rightCodeFont);
        //设置内容
        rightCode.setText("随机");
        //绑定鼠标事件
        rightCode.addActionListener(this);
        //位置和宽高
        rightCode.setBounds(150, 350, 100, 50);
        //添加到界面
        this.getContentPane().add(rightCode);

        Font now2 = new Font(null,1,30);
        shueiji.setForeground(Color.black);
        shueiji.setFont(now2);
        getlable();
        shueiji.setBounds(100,200,200,50);
        this.getContentPane().add(shueiji);
    }

    private void getlable() {

        Random r = new Random();
        int so = r.nextInt(user.size());
        String now = user.get(so);
        shueiji.setText(now);

    }

    private void setting() {
        setSize(403,600);
        setVisible(true);
        setTitle("wo");
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        this.setLayout(null);//关键是这个
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rightCode){
            getlable();
        }
    }
}

