package main.hj.luntan.seriver;

import main.hj.luntan.common.Gong;
import main.hj.luntan.entity.Bankuai;
import main.hj.luntan.entity.Tiezi;

import java.util.List;

public interface TieziSeriver {
    //根据文本框内容查询标题
    List<String>  chaxun(Tiezi  tiezi);
    //查找板块的所有帖子内容(先查帖子内容)
    List<Tiezi> select(String name);
    //模糊分页根据文本框内的内容查询
    List<Tiezi> mohu(Gong gong);
    //根据帖子id来删除帖子
    int shanchu(String id);
}
