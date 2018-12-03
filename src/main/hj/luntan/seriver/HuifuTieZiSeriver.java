package main.hj.luntan.seriver;

import main.hj.luntan.common.Gong;
import main.hj.luntan.entity.HufuTieZi;

import java.util.List;

public interface HuifuTieZiSeriver {
    //根据公共类来获得集合
    List<HufuTieZi> de(Gong gong);
    //根据回复帖子id来删除数据
    int shnchu(String id);
}
