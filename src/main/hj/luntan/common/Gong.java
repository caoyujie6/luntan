package main.hj.luntan.common;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Gong {
    private int dianji;//点击数
    private int yemianshu;//初始页面容量
    private int yemian;//可变的页面容量
    private int zongshu;//总共的数量
    private String biao; //表名
    private String ziduan;//查询的字段
    private String tiaojian;//条件
    private  String tiaojian1;//条件二
    private String ziduan1;//字段2
    public Gong(int yemianshu, String biao, String ziduan, String tiaojian,String tiaojian1,String zhutitz) {
        this.yemianshu = yemianshu;
        this.biao = biao;
        this.ziduan = ziduan;
        this.ziduan1=zhutitz;
        this.tiaojian = tiaojian;
        this.tiaojian1=tiaojian1;
        this.dianji=1;//给点击数赋初始值
        this.zongshu=cha();
        this.yemian=dianji*yemianshu;
    }
    public Gong(int yemianshu, String biao, String ziduan, String tiaojian) {
        this.yemianshu = yemianshu;
        this.biao = biao;
        this.ziduan = ziduan;
        this.tiaojian = tiaojian;
        this.dianji=1;//给点击数赋初始值
        this.zongshu=cha1();
        this.yemian=dianji*yemianshu;
    }
    //查数据库得总共数量
    public  int cha1(){
        String a="select Count(1) from "+this.biao+" where  "+this.ziduan+"="+this.tiaojian;
        ResultSet resultSet=new Connect().select(a);
        int i=0;
        try {
            while (resultSet.next()){
                i=resultSet.getInt(1);
            }
        }catch (SQLException e){

        }
        return i;
    }
    //查数据库的总共数量
    public int cha(){
        String a="select Count(1) from "+this.biao+" where "+this.ziduan+" LIKE \'%"+this.tiaojian+"%\'"+" AND "+ziduan1+" LIKE \'%"+tiaojian1+"%\'";
        ResultSet resultSet=new Connect().select(a);
       int i=0;
       try {
           while (resultSet.next()){
               i=resultSet.getInt(1);
           }
       }catch (SQLException e){

       }
        return i;
    }

    public String getZiduan1() {
        return ziduan1;
    }

    public void setZiduan1(String ziduan1) {
        this.ziduan1 = ziduan1;
    }

    public String getTiaojian1() {
        return tiaojian1;
    }

    public void setTiaojian1(String tiaojian1) {
        this.tiaojian1 = tiaojian1;
    }

    public int getYemian() {
        return yemian;
    }

    public void setYemian(int yemian) {
        this.yemian = yemian;
    }

    public int getDianji() {
        return dianji;
    }

    public void setDianji(int dianji) {
        this.yemian=dianji*yemianshu;//每一次页面显示的事点击数乘以页面初始数
        this.dianji = dianji;
    }

    public int getYemianshu() {
        return yemianshu;
    }

    public void setYemianshu(int yemianshu) {
        this.yemianshu = yemianshu;
    }

    public int getZongshu() {
        return zongshu;
    }

    public void setZongshu(int zongshu) {
        this.zongshu = zongshu;
    }

    public String getBiao() {
        return biao;
    }

    public void setBiao(String biao) {
        this.biao = biao;
    }

    public String getZiduan() {
        return ziduan;
    }

    public void setZiduan(String ziduan) {
        this.ziduan = ziduan;
    }

    public String getTiaojian() {
        return tiaojian;
    }

    public void setTiaojian(String tiaojian) {
        this.tiaojian = tiaojian;
    }

}
