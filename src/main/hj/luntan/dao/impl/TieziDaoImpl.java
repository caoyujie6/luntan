package main.hj.luntan.dao.impl;

import main.hj.luntan.common.Connect;
import main.hj.luntan.common.Gong;
import main.hj.luntan.dao.TieziDao;
import main.hj.luntan.entity.Tiezi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TieziDaoImpl implements TieziDao {
    Connect connect=new Connect();
    //根据文本框内容来模糊查询帖子名字；
    @Override
    public List<String> chatiezi(Tiezi tiezi) {
        String sql="SELECT biaoti FROM zhutitz WHERE biaoti LIKE ? LIMIT 5;";
        String s="%"+tiezi.getBiaoti()+"%";
        ResultSet resultSet=connect.select(sql,s);
        List<String> list=new ArrayList<>();
        try {
            while (resultSet.next()){
                list.add(resultSet.getString(1));
            }
        }catch (SQLException e){

        }
        return list;
    }

    @Override
    public List<Tiezi> selectTiezi(String name) throws SQLException {
        List<Tiezi> list=new ArrayList<>();
        //(select BKid FROM bk where BKname=?)
        String sql="select * from zhutitz where zhutitz.bankuanid=?";
        ResultSet set=connect.select(sql,name);
        while (set.next()){
            Tiezi tiezi=new Tiezi();
            int id=set.getInt("id");
            String biaoti= set.getString("biaoti");
            int bankuaiid=set.getInt("bankuanid");
            int huifunhui=set.getInt("huifushu");
            String time=set.getString("fatietime");
            int user= set.getInt("fatieren");
            String fatieneirong=set.getString("fatieneirong");
            tiezi.setBiaoti(biaoti);
            tiezi.setFatieneirong(fatieneirong);
            tiezi.setHuifushu(huifunhui);
            tiezi.setTieziid(id);
            tiezi.setUserid(user);
            tiezi.setBKid(bankuaiid);
            tiezi.setTime(time);
            list.add(tiezi);
        }
        return list;
    }
    //根据模糊查询帖子的内容
    @Override
    public List<Tiezi> chaxinxi(Gong gong) {
        List<Tiezi> list=new ArrayList<>();
        int j=0;
        for (int i=1;i<=gong.getDianji();i++){
            j=i*gong.getYemianshu()+j;
        }
        int i=gong.getZongshu()-j;
        if (i<0){
            gong.setYemian(gong.getYemian()-(0-i));
            if (gong.getYemian()<0){
                gong.setYemian(0);
            }
            i=0;
        }
        String sql="SELECT * FROM "+gong.getBiao()+" WHERE "+gong.getZiduan()+" LIKE '%"+gong.getTiaojian()+"%' "+" AND "+gong.getZiduan1()+" LIKE \'%"+gong.getTiaojian1()+"%\'"+" LIMIT "+i+","+gong.getYemian();
        ResultSet set=connect.select(sql);
        try {
            while (set.next()){
                Tiezi tiezi=new Tiezi();
                int id=set.getInt("id");
                String biaoti= set.getString("biaoti");
                int bankuaiid=set.getInt("bankuanid");
                int huifunhui=set.getInt("huifushu");
                String time=set.getString("fatietime");
                int user= set.getInt("fatieren");
                String fatieneirong=set.getString("fatieneirong");
                fatieneirong=fatieneirong.substring(0,20)+"....";
                tiezi.setBiaoti(biaoti);
                tiezi.setFatieneirong(fatieneirong);
                tiezi.setHuifushu(huifunhui);
                tiezi.setTieziid(id);
                tiezi.setUserid(user);
                tiezi.setBKid(bankuaiid);
                tiezi.setTime(time);
                list.add(tiezi);
            }
        }catch (SQLException e){

        }
        return list;
    }
    //根据帖子id来删除帖子
    @Override
    public int shanchu(String id) {
        int a=0;
        String sql="DELETE FROM zhutitz WHERE id=?";
        a=connect.update(sql,id);
        return a;
    }


}
