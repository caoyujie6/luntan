package main.hj.LTHoutai.seriver;

import main.hj.LTHoutai.common.Gong;
import main.hj.LTHoutai.entiy.GlTz;
import main.hj.luntan.entity.Bankuai;

import java.util.List;

public interface TieZiSeriver {
    //查询全部嘚板块
    List<main.hj.LTHoutai.entiy.Bankuai>  kan();
    //根据条件查询帖子
    List<GlTz> cha(Gong gong);
    //根据帖子的id删除帖子
    int  shan(int id);
}
