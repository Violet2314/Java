package com.itheima.domain;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Poker extends JLabel implements MouseListener {
    private String name;
    private Boolean see;

    //是否可以被点击
    private Boolean up = false;

    //是否已经被点击
    private Boolean check = false;

    public Poker(String name,Boolean see){
        this.name = name;
        this.see = see;
        if(see){
            trueup();
        }else {
            falseuo();
        }
        //设置牌的宽高大小
        this.setSize(71, 96);
        //把牌显示出来
        this.setVisible(true);
        //给每一张牌添加鼠标监听
        this.addMouseListener(this);
    }

    public void trueup(){
        this.setIcon(new ImageIcon("image/poker/"+ name +".png"));
        up = true;
    }
    public void falseuo(){
        this.setIcon(new ImageIcon("image/poker/rear.png"));
        up = false;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(up){
            Point now = this.getLocation();
            int change;
            if(check){
                change = 20;
            }else{
                change = -20;
            }
            check = !check;
            Point to = new Point(now.x, now.y + change);
            this.setLocation(to);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

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

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return see
     */
    public Boolean getSee() {
        return see;
    }

    /**
     * 设置
     * @param see
     */
    public void setSee(Boolean see) {
        this.see = see;
    }

    /**
     * 获取
     * @return up
     */
    public Boolean getUp() {
        return up;
    }

    /**
     * 设置
     * @param up
     */
    public void setUp(Boolean up) {
        this.up = up;
    }

    /**
     * 获取
     * @return check
     */
    public Boolean getCheck() {
        return check;
    }

    /**
     * 设置
     * @param check
     */
    public void setCheck(Boolean check) {
        this.check = check;
    }

    public String toString() {
        return "Poker{name = " + name + ", see = " + see + ", up = " + up + ", check = " + check + "}";
    }

    //自己练习
}
