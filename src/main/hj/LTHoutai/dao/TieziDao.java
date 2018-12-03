package main.hj.LTHoutai.dao;

import main.hj.LTHoutai.common.Gong;
import main.hj.luntan.entity.Bankuai;
import main.hj.luntan.entity.Tiezi;

import java.util.List;

public interface TieziDao {
    //遍历所有嘚板块
    List<main.hj.LTHoutai.entiy.Bankuai> cha();
    //根据条件查寻帖子
    List<main.hj.LTHoutai.entiy.Tiezi> mhcx(Gong gong);
    //根据帖子的id查询点赞数；
    int cxdz(int id);
    //根据帖子的id查询评论数
    int cxpl(int id);
    //根据用户id查询用户name
    String cxyh(int id);
    //根据帖子id删除帖子
    int shan(int id);
}
