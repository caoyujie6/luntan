package main.hj.luntan.seriver;


import main.hj.luntan.entity.*;;import java.sql.SQLException;
import java.util.List;

public interface LoginSeriver {
    List<Login> select();
    int insert(User user);
    List<Login> fenye(int start, int showNum);
    int geshu(int num, String falg);
    //登录
    boolean denglu(Login login);
    List<Login> mohuselect(String falg, int start, int yeshu);
    //通过id 删除
    boolean delete(Login login);
    //修改
    boolean xiugai(Login login, String falg);
    //查询全部帖子的内容
    List<Tiezi> findAllTZ();
    //根据id查找
    Tiezi findByTZid(int id);
    //查询板块表的内容
    List<Bankuai> findAllBK();
    //发表帖子（添加帖子）
    int insert(Tiezi tiezi);
    //根据手机号来查询是否该用户已注册
    List<User> panduan(User user);
    //添加一名手机号用户
    int tj(User user);

    List<User> findAll() throws SQLException;
    List<User> cha(User user) throws SQLException;
    //查询回复帖子
    List<HuiFuLianBiao> huifu(int a);
    //回复帖子
    int huifutiezi(HufuTieZi hufuTieZi);
    //通过name查找回复人的id
    int selectUser(String name);
    //    根据用户id 查询帖子内容
    List<Tiezi> findByUserId(int userId);

    //根据板块名字查找版块id
    Bankuai selectBK(String name);
    //点赞表里增加
    int insertt(Dianzan dianzan);
    //查询点赞表里的数据
    int list(int yid,int bid)throws SQLException;
    //删除点赞表里的用户
    int deletee(Dianzan dianzan);
    //查询帖子个数
    int list1(int bid)throws SQLException;
    //根据版块id查询版块名字
    Bankuai select(int id);
    //根据帖子id查询对应的回复贴个数
    int selectHfTznum(int id);
    //查询帖子表里的发帖人
    int fatieren(int ren)throws SQLException;
     //查询评论数
      int pinglun(int ping)throws SQLException;
    //查询用户点赞
    int list2(int yid)throws SQLException;

}
