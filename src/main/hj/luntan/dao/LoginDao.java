package main.hj.luntan.dao;
import main.hj.luntan.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface LoginDao {
    //查询所有
    List<User> findAll() throws SQLException;
    //根据ID查询
    Login fingById(String id);
    //根据用户名和密码查询
    Login fingByNameAddPaeeword();
    //增、删、改
    int update(User user);
    //分页查询
    List<Login> fenye(int start, int yeshu) throws SQLException;
    //得到表的总条数
    int getsum(String falg) throws SQLException;
    //模糊查询
    List<Login> mohuselect(String falg, int start, int yeshu) throws SQLException;
    //删除
    int delete(Login login);
    //修改
    int xiugai(Login login, String falg);
    //查询帖子的全部
    List<Tiezi> findAllTZ() throws SQLException;
    //根据帖子id查询帖子的内容
    Tiezi fingByTieziId(int id) throws SQLException;
    //查询板块的全部内容
    List<Bankuai> findAllBK() throws SQLException;
    //连接查询帖子属于哪个板块
    List<Bankuai> BKname(int id);
    //把帖子添加到数据库
    int insert(Tiezi tiezi);
    //根据手机号查询是否有此人
    List<User> sjcx(User user);
    //添加一个手机号
    int sjtj(User user);
    //根据用户名和密码进行查询
    List<User> cha(User user) throws SQLException;
    //查询回复帖子
    List<HuiFuLianBiao> huifu(int a) throws SQLException;
    //回复帖子
    int huifutiezi(HufuTieZi hufuTieZi);
    //查找用户ID
    int selectUser(String name) throws SQLException;

    //根据用户id 查询帖子内容
    List<Tiezi> findByUserId(int userId);

    //根据版块名字查找版块id
    Bankuai selectBk(String name) throws SQLException;

    //点赞的用户id和文章id进行增加
  int insertt(Dianzan dianzan);
  //查找点赞表里 的用户id和帖子id
   int list(int yid,int bid)throws SQLException;
        //删除点赞表里的用户
    int deletee(Dianzan dianzan);
    //查询帖子点赞个数
    int list1(int bid)throws SQLException;
    //查询发帖数
    int fatieren(int ren)throws SQLException;
    //查询评论数
    int pinglun(int ping)throws SQLException;
    //查询用户点赞
    int list2(int yid)throws SQLException;
    //根据版块id查询板块名字
    Bankuai selectBKname(int id) throws SQLException;
    //查询帖子对应的回复帖子个数
    int selectHuTznum(int id) throws SQLException;

}
