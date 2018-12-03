package main.hj.luntan.dao.impl;

import main.hj.luntan.common.Connect;
import main.hj.luntan.dao.LoginDao;
import main.hj.luntan.entity.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LoginImpl implements LoginDao {
   Connect c=new Connect();
   //查询
    @Override
    public List<User> findAll() throws SQLException {
        List<User>list=new ArrayList<>();

        String sql="select * from yonghu";
        ResultSet re=c.select(sql);
        while (re.next()){
            User user=new User();
            String name=re.getString("name");
            String password=re.getString("password");
            user.setName(name);
            user.setMima(password);
            list.add(user);
        }
        return list;
    }
  //按ID查询
    @Override
    public Login fingById(String id) {
        return null;
    }
     //按姓名密码查询
    @Override
    public Login fingByNameAddPaeeword() {
        return null;
    }

    //插入
    @Override
    public int update(User user) {
        String sql="insert into yonghu(name,password)values(?,?)";
        return c.update(sql,user.getName(),user.getMima());
    }
   //分页查询
    @Override
    public List<Login> fenye(int start, int yeshu) throws SQLException {
        List<Login>list=new ArrayList<>();
        String sql="select * from yonghu limit ?,?";
        ResultSet set=c.select(sql,start,yeshu);
        while (set.next()){
            Login login=new Login();
            String name=set.getString("name");
            String password=set.getString("password");
            login.setName(name);
            login.setPassword(password);
            list.add(login);
        }
        return list;
    }

  //查询表内数据的总个数
    @Override
    public int getsum(String falg) throws SQLException {
        int a=0;
        falg="%"+falg+"%";
        String sql="select Count(1) from Login where name LIKE ? ";
        ResultSet set=c.select(sql,falg);
        while (set.next()){
           a=Integer.parseInt(set.getString(1));
        }
        return a;
    }
//模糊查询
    @Override
    public List<Login> mohuselect(String falg,int start, int yeshu) throws SQLException {
        List<Login> list=new ArrayList<>();
        String a="%"+falg+"%";
        String sql="SELECT * FROM Login where name LIKE ? LIMIT ?,?;";
        ResultSet set=c.select(sql,a,start,yeshu);
        while (set.next()){
            Login login=new Login();
            String id=set.getString("id");
            String name=set.getString("name");
            String password=set.getString("password");
            login.setId(id);
            login.setName(name);
            login.setPassword(password);
            list.add(login);
        }
        return list;
    }
//删除
    @Override
    public int delete(Login login) {
        String sql="delete from Login where name=?";
        int a=c.update(sql,login.getName());
        return a;
    }
//修改
    @Override
    public int xiugai(Login login,String falg) {
        int a=0;
        String sql="update Login set ?=? WHERE name=?";
        if (falg.equals("密码")){
            falg="password";
            a=c.update(sql,falg,login.getPassword(),login.getName());
        }else if (falg.equals("称呼")){
            falg="chenghu";
            a=c.update(sql,falg,login.getChenghu(),login.getName());
        }
        return a;
    }
     //查询帖子的全部内容
    @Override
    public List<Tiezi> findAllTZ() throws SQLException {
        List<Tiezi> list=new ArrayList<>();
        String sql="select * from zhutitz";
        ResultSet set=c.select(sql);
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
   //根据帖子的id查询帖的内容
    @Override
    public Tiezi fingByTieziId(int id) throws SQLException {
        String sql="select * from zhutitz where id=? ";
        Tiezi tiezi=new Tiezi();
        ResultSet set=c.select(sql,id);
         while (set.next()){
             int TZid=set.getInt("id");
             String biaoti= set.getString("biaoti");
             int bankuaiid=set.getInt("bankuanid");
             int huifunhui=set.getInt("huifushu");
             String time=set.getString("fatietime");
             int user=set.getInt("fatieren");
             String fatieneirong=set.getString("fatieneirong");
             System.out.println(biaoti);
             tiezi.setTieziid(TZid);
             tiezi.setBiaoti(biaoti);
             tiezi.setFatieneirong(fatieneirong);
             tiezi.setHuifushu(huifunhui);
             tiezi.setUserid(user);
             tiezi.setBKid(bankuaiid);
             tiezi.setTime(time);
         }
        return tiezi;
    }
    //查询板块的内容
    @Override
    public List<Bankuai> findAllBK() throws SQLException {
        List<Bankuai> list=new ArrayList<>();
        String sql="select * from bk";
        ResultSet set=c.select(sql);
        while (set.next()){
            Bankuai bankuai=new Bankuai();
            int id=set.getInt("BKID");
            String name=set.getString("BKname");
            bankuai.setId(id);
            bankuai.setName(name);
            list.add(bankuai);
        }
        return list;
    }
   //连接查询贴子属于哪个版块
    @Override
    public List<Bankuai> BKname(int id) {
        String sql="select BKname from bk where";
        return null;
    }
   //发表帖子（添加帖子）
    @Override
    public int  insert(Tiezi tiezi) {
        int a=0;
        String sql="insert into zhutitz(biaoti ,bankuanid , huifushu , fatieren , fatieneirong) values (?,?,?,?,?)";
        a=c.update(sql,tiezi.getBiaoti(),tiezi.getBKid(),tiezi.getHuifushu(),tiezi.getUserid(),tiezi.getFatieneirong());
        return a;
    }
    //根据手机号查询是否有此人
    @Override
    public List<User> sjcx(User user) {
        List<User> list=new ArrayList<>();
        String sql="SELECT * FROM yonghu WHERE shouji=?";
        ResultSet resultSet=c.select(sql,user.getShoujihao());
        try {
            while (resultSet.next()){
                User user1=new User();
                user1.setName(resultSet.getString("name"));
                user1.setMima(resultSet.getString("password"));
                user1.setShoujihao(resultSet.getString("shouji"));
                user1.setNicheng(resultSet.getString("nicheng"));
                user1.setId(resultSet.getInt("jueseid"));
                list.add(user1);
            }
        }catch (SQLException e){

        }
        return list;
    }
     //把手机号添加到数据库（账号）
    @Override
    public int sjtj(User user) {
        int a=0;
        String sql="insert into yonghu(name,shouji) values (?,?)";
        a=c.update(sql,user.getName(),user.getShoujihao());
        return a;
    }

        //查询用户名密码
    @Override
    public List<User> cha(User user) throws SQLException {
        List<User> list=new ArrayList<>();
        String sql="select * from yonghu where name=? and password=?";
        ResultSet set=c.select(sql,user.getName(),user.getMima());
        while (set.next()){
            User user1=new User();
            String name=set.getString("name");
            String password=set.getString("password");
            user1.setName(name);
            user1.setMima(password);
            list.add(user1);
        }
        return list;
    }

     //链表查询帖子所对应的回复帖子
    @Override
    public List<HuiFuLianBiao> huifu(int a) throws SQLException {
        String sql="SELECT yonghu.`name`,huifutz.huifuneirong,huifutz.huifutime FROM huifutz INNER JOIN zhutitz ON zhutitz.id= huifutz.huifutzid INNER JOIN yonghu ON yonghu.id=huifutz.huifuzhe WHERE zhutitz.id=?;";
        ResultSet set=c.select(sql,a);
        List<HuiFuLianBiao> list=new ArrayList<>();
        while (set.next()){
            String name=set.getString(1);
            String time=set.getString(3);
            String neirong=set.getString(2);
            HuiFuLianBiao huiFu=new HuiFuLianBiao(name,time,neirong);
            list.add(huiFu);
        }
        return list;
    }
  //把回复帖子添加到数据库
    @Override
    public int huifutiezi(HufuTieZi hufuTieZi) {
        int a=0;
        String sql="insert into  huifutz (huifutzid,huifuzhe,huifuneirong) values (?,?,?)";
        c.update(sql,hufuTieZi.getHuifuTZid(),hufuTieZi.getHuifuze(),hufuTieZi.getHuifuneirong());
        return a;
    }
  //根据账号查找用户id
    @Override
    public int selectUser(String name) throws SQLException {
        int id=0;
        String sql="select id from yonghu where name=?";
         ResultSet set=c.select(sql,name);
         while (set.next()){
            id=set.getInt("id");
         }
        return id;
    }
//根据发帖人ID获取内容
    @Override
    public List<Tiezi> findByUserId(int userId){
        List<Tiezi> list=new ArrayList<>();
        String sql="select * from zhutitz where fatieren=?";
        ResultSet resultSet=c.select(sql,userId);
       try {
           while (resultSet.next()){
               Tiezi tiezi=new Tiezi();
               tiezi.setFatieneirong(resultSet.getString("fatieneirong"));
               tiezi.setBiaoti(resultSet.getString("biaoti"));
               tiezi.setTime(resultSet.getString("fatietime"));
               list.add(tiezi);
           }
       }catch (SQLException e){

       }
        return list;
    }

    public static void main(String[] args) {
        LoginImpl login=new LoginImpl();
        try {
            Tiezi tiezi=login.fingByTieziId(1);
            System.out.println(tiezi.getBiaoti());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
  //根据版块名字查找版块id
    @Override
    public Bankuai selectBk(String name) throws SQLException {
        String sql="select * from bk where BKname=?";
        ResultSet set=c.select(sql,name);
        Bankuai bk=new Bankuai();
        while (set.next()){
            int id=set.getInt("BKID");
            String bkname=set.getString("BKname");
            bk.setId(id);
            bk.setName(bkname);
        }
        return bk;
    }
    //给点赞表里增加
    @Override
    public int insertt(Dianzan dianzan) {
        String sql="insert into dianzan(yid,bid)values(?,?)";
        return c.update(sql,dianzan.getYid(),dianzan.getBid());
    }
//查询个数
    @Override
    public int list(int yid, int bid) throws SQLException {
        int a=0;
        String sql="select count(1) from dianzan where yid=? and bid=?";
        ResultSet re=c.select(sql,yid,bid);
        while (re.next()){
         a=Integer.parseInt(re.getString(1));
        }
        return a;
    }
  //点赞
    @Override
    public int deletee(Dianzan dianzan) {
        int s=0;
        String sql="delete from dianzan where yid=? and bid=?";
        s=c.update(sql,dianzan.getYid(),dianzan.getBid());
        return s;

    }
    /*点赞个数*/
    @Override
    public int list1(int bid) throws SQLException{
        int a=0;
        String sql="select count(1) from dianzan where bid=?";
        ResultSet re=c.select(sql,bid);
        while (re.next()){
            a=Integer.parseInt(re.getString(1));
        }
        return a;
    }
    //发帖个数
    @Override
    public int fatieren(int ren) throws SQLException {
        int a=0;
        String sql=" select count(1) from zhutitz where fatieren=?";
        ResultSet re=c.select(sql,ren);
        while (re.next()){
            a=Integer.parseInt(re.getString(1));
        }
        return a;
    }
        //评论数
    @Override
    public int pinglun(int ping) throws SQLException {
        int a=0;
        String sql=" select count(1) from huifutz where huifuzhe=?";
        ResultSet re=c.select(sql,ping);
        while (re.next()){
            a=Integer.parseInt(re.getString(1));
        }
        return a;
    }
    //点赞数
    @Override
    public int list2(int yid) throws SQLException {
        int a=0;
        String sql="select count(1) from dianzan where yid=?";
        ResultSet re=c.select(sql,yid);
        while (re.next()){
            a=Integer.parseInt(re.getString(1));
        }
        return a;
    }

    //根据版块id查找版块名字
    @Override
    public Bankuai selectBKname(int id) throws SQLException {
        String sql="select BKname from bk where BKid=?";
        Bankuai BK=new Bankuai();
        ResultSet set=c.select(sql,id);
        while (set.next()){ ;
            String name=set.getString("BKname");
            BK.setName(name);
        }
        return BK;
    }
   //回复帖子对应的帖子个数
    @Override
    public int selectHuTznum(int id) throws SQLException {
        int a=0;
        String sql="select count(1) from huifutz where huifutz.huifutzid=?";
        ResultSet set=c.select(sql,id);
        while (set.next()){
            a=Integer.parseInt(set.getString(1));
        }
        return a;
    }
}
