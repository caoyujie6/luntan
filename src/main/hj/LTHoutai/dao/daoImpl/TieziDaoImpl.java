package main.hj.LTHoutai.dao.daoImpl;

import main.hj.LTHoutai.common.Gong;
import main.hj.LTHoutai.dao.TieziDao;
import main.hj.LTHoutai.entiy.Tiezi;
import main.hj.luntan.common.Connect;
import main.hj.luntan.entity.Bankuai;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TieziDaoImpl  implements TieziDao {
    Connect connect=new Connect();
    //查询全部嘚帖子
    @Override
    public List<main.hj.LTHoutai.entiy.Bankuai> cha() {
        List<main.hj.LTHoutai.entiy.Bankuai> list=new ArrayList<>();
        String sql="SELECT * FROM bk";
        ResultSet resultSet=connect.select(sql);
        try {
            while (resultSet.next()){
                main.hj.LTHoutai.entiy.Bankuai bankuai=new main.hj.LTHoutai.entiy.Bankuai();
                bankuai.setId(resultSet.getInt("BKID"));
                bankuai.setName(resultSet.getString("BKname"));
                list.add(bankuai);
            }
        }catch (SQLException e){

        }
        return list;
    }
    //根据条件查询帖子
    @Override
    public List<Tiezi> mhcx(Gong gong) {
        List<Tiezi> list=new ArrayList<>();
        int j=0;
        if (gong.getYemian()==gong.getYemianshu()){
            j=gong.getDianji()*gong.getYemianshu();
        }else {
            for (int i=1;i<=gong.getDianji();i++){
                j=i*gong.getYemianshu()+j;
            }
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
                if (fatieneirong.length()>4){
                    fatieneirong=fatieneirong.substring(0,4)+"....";
                }
                if (biaoti.length()>4){
                    biaoti=biaoti.substring(0,4)+"...";
                }
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
    //根据帖子的id查询点赞数
    @Override
    public int cxdz(int id) {
        int i=0;
        String sql="SELECT COUNT(1) FROM dianzan WHERE bid=?";
        ResultSet resultSet=connect.select(sql,id);
        try {
            while (resultSet.next()){
                i=resultSet.getInt(1);
            }
        }catch (SQLException e){

        }
        return i;
    }
    //根据帖子的id查询评论的数量
    @Override
    public int cxpl(int id) {
        int i=0;
        String sql="SELECT COUNT(1) FROM huifutz WHERE huifutzid=?";
        ResultSet resultSet=connect.select(sql,id);
        try {
            while (resultSet.next()){
                i=resultSet.getInt(1);
            }
        }catch (SQLException e){

        }
        return i;
    }
    //根据用户id查询用户的名字
    @Override
    public String cxyh(int id) {
        String name=null;
        String sql="SELECT NAME FROM yonghu WHERE id=?";
        ResultSet resultSet=connect.select(sql,id);
        try {
            while (resultSet.next()){
                name=resultSet.getString(1);
            }
        }catch (SQLException e){

        }
        return name;
    }
    //根据帖子的id删除帖子
    @Override
    public int shan(int id) {
        String sql="DELETE FROM zhutitz WHERE id=?";
        return connect.update(sql,id);
    }
}
