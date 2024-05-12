package try1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameJFrame extends JFrame implements ActionListener {
    
    ArrayList<String> user = new ArrayList<>();
    JButton start = new JButton("开始");
    
    public GameJFrame(String[] nofind,int num,String bi) {
        //设置界面
        user.add("1");
        user.add("2");
        user.add("3");
        user.add("4");

        for (int i = 0; i < nofind.length; i++) {
            if(user.contains(nofind[i])){
                user.remove(nofind[i]);
            }
        }

        

        initJframe();

        //添加组件
        initView();

        //界面显示出来
        this.setVisible(true);

    }

    //添加组件
    public void initView() {

        JLabel countDown = new JLabel("倒计时：5秒");
        countDown.setFont(new Font(null,1,50));
        countDown.setBounds(50,50,300,60);
        this.getContentPane().add(countDown);


        JLabel namePrompt = new JLabel("中奖选手为：");
        namePrompt.setFont(new Font(null,1,20));
        namePrompt.setBounds(80,150,125,30);
        this.getContentPane().add(namePrompt);

        JLabel rollName = new JLabel("XXX");
        rollName.setFont(new Font(null,1,20));
        rollName.setBounds(200,150,125,30);
        this.getContentPane().add(rollName);

        JLabel rollImage = new JLabel(new ImageIcon("src/try1/img/girl/1.jpg"));
        rollImage.setBounds(87,200,210,210);
        this.getContentPane().add(rollImage);

        start.setFont(new Font(null,1,20));
        start.setBounds(118,430,150,50);
        start.setBackground(Color.WHITE);
        //start.addActionListener(this);
        this.getContentPane().add(start);

    }


    //设置界面
    public void initJframe() {
        //设置标题
        this.setTitle("随机点名器");
        //设置大小
        this.setSize(400, 600);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口无法进行调节
        this.setResizable(false);
        //界面居中
        this.setLocationRelativeTo(null);
        //取消内部默认居中放置
        this.setLayout(null);
        //设置背景颜色
        this.getContentPane().setBackground(Color.white);
        this.setAlwaysOnTop(true);//置顶
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == start){

        }
    }
}
