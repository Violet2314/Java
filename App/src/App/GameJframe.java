package App;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class GameJframe extends JFrame implements KeyListener, MouseListener {

    int[] wok = new int[17];
    int[][] so = new int[4][4];
    int x,y;
    int[][] win = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
    };
    int step = 0;

    JMenu about = new JMenu("关于我");

    JMenuItem repaly = new JMenuItem("重新游戏");
    JMenuItem relogin = new JMenuItem("重新登录");
    JMenuItem close = new JMenuItem("关闭游戏");
    JMenuItem girls = new JMenuItem("美女");
    JMenuItem anmials = new JMenuItem("动物");
    JMenuItem sports = new JMenuItem("运动");

    String path = "image\\animal\\animal1\\";

    Random r = new Random();

    ArrayList<User> users;

    public GameJframe(ArrayList<User> users){
        this.users = users;

        intjframe();

        random();

        imagewok();

        intjmeubar();

        this.setVisible(true);
    }

    private void intjmeubar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu function = new JMenu("功能");
        JMenu repiece = new JMenu("更换图片");
        about.addMouseListener(this);

        function.add(repiece);

        function.add(relogin);
        function.add(repaly);
        function.add(close);

        repiece.add(girls);
        repiece.add(anmials);
        repiece.add(sports);

        relogin.addMouseListener(this);
        repaly.addMouseListener(this);
        close.addMouseListener(this);
        girls.addMouseListener(this);
        sports.addMouseListener(this);
        anmials.addMouseListener(this);

        jMenuBar.add(function);
        jMenuBar.add(about);
        //设置一个就JMenuBar
        this.setJMenuBar(jMenuBar);

        this.setVisible(true);
    }

    private void intjframe() {
        setSize(603,680);
        setVisible(true);
        setTitle("游戏界面");
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);

        setLayout(null);

        this.addKeyListener(this);

    }

    private void random(){
        for(int i = 1; i <= 16; i++) wok[i] = i;
        for(int i = 1; i <= 16; i++){
            int k = r.nextInt(16) + 1;
            int temp = wok[i];
            wok[i] = wok[k];
            wok[k] = temp;
        }

        int num = 1;
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                so[i][j] = wok[num];
                num++;
            }
        }
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                if(so[i][j] == 16){
                    x = i;
                    y = j;
                }
            }
        }
    }

    private void imagewok(){
        getContentPane().removeAll();

        JLabel stepcount = new JLabel("步数" + step);
        stepcount.setBounds(50,30,100,20);
        this.getContentPane().add(stepcount);

        if(victory()){
            ImageIcon win = new ImageIcon("image/win.png");
            JLabel winn = new JLabel(win);
            winn.setBounds(203,283,197,73);
            getContentPane().add(winn);
        }

        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 4; j++){
                if(so[i-1][j-1] == 16) continue;
                ImageIcon icon  = new ImageIcon(path + so[i - 1][j - 1] + ".jpg");
                JLabel jLabel = new JLabel(icon);
                jLabel.setBounds(105 * (j - 1) + 83,105 * (i - 1) + 134,105,105);
                jLabel.setBorder(new BevelBorder(1));
                getContentPane().add(jLabel);

            }
        }

        ImageIcon icon = new ImageIcon("image/background.png");
        JLabel jLabel = new JLabel(icon);
        jLabel.setBounds(40,40,508,560);
        getContentPane().add(jLabel);

        getContentPane().repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 65){
            getContentPane().removeAll();

            ImageIcon allwok = new ImageIcon(path + "all.jpg");
            JLabel all = new JLabel(allwok);
            all.setBounds(83,134,420,420);
            getContentPane().add(all);

            ImageIcon icon = new ImageIcon("image/background.png");
            JLabel jLabel = new JLabel(icon);
            jLabel.setBounds(40,40,508,560);
            getContentPane().add(jLabel);

            getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(victory()) return;

        int code = e.getKeyCode();
        if(code == 38){
            System.out.println("向上运动");
            so[x][y] = so[x + 1][y];
            so[x+1][y] = 16;
            x++;
            step++;
            imagewok();
        }else if(code == 37){
            System.out.println("向左运动");
            so[x][y] = so[x][y-1];
            so[x][y-1] = 16;
            y--;
            step++;
            imagewok();
        } else if (code == 39) {
            System.out.println("向右运动");
            so[x][y] = so[x][y+1];
            so[x][y+1] = 16;
            y++;
            step++;
            imagewok();
        } else if (code == 40) {
            System.out.println("向下运动");
            so[x][y] = so[x-1][y];
            so[x-1][y] = 16;
            step++;
            x--;
            imagewok();
        } else if (code == 65) {
            imagewok();
        } else if (code == 87) {
            for(int i = 0; i <= 3; i++){
                for(int j = 0; j <= 3; j++){
                    so[i][j] = win[i][j];
                }
            }
            x = 3;
            y = 3;
            imagewok();
        }
    }

    private Boolean victory(){
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                if(win[i][j] != so[i][j]) return false;
            }
        }
        return true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object obj = e.getSource();
        if(obj == relogin){
            this.setVisible(false);
            new LoginJframe(users);
        } else if (obj == repaly) {
            random();
            step = 0;
            imagewok();
        } else if (obj == close) {
            System.exit(0);
        } else if (obj == about) {
            JDialog me = new JDialog();
            ImageIcon icon = new ImageIcon("image/so.jpg");
            JLabel jLabel = new JLabel(icon);
            me.add(jLabel);
            jLabel.setBounds(0,0,500,500);
            me.setSize(1000,1000);
            me.setAlwaysOnTop(true);
            //居中
            me.setLocationRelativeTo(null);
            //打开就无法操作
            me.setModal(true);
            me.setVisible(true);
        } else if (obj == girls) {
            int k = r.nextInt(13) + 1;
            path = "image\\girl\\girl"+ k +"\\";
            random();
            step = 0;
            imagewok();
        } else if (obj == anmials) {
            int k = r.nextInt(8) + 1;
            path = "image\\animal\\animal"+ k +"\\";
            random();
            step = 0;
            imagewok();
        } else if (obj == sports) {
            int k = r.nextInt(10) + 1;
            path = "image\\sport\\sport"+ k +"\\";
            random();
            step = 0;
            imagewok();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
