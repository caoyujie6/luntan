package main.hj.luntan.dao;

import main.hj.luntan.common.Gong;
import main.hj.luntan.entity.Tiezi;

import java.sql.SQLException;
import java.util.List;

public interface TieziDao {
    //根据文本框来模糊查询帖子名称
    List<String> chatiezi(Tiezi tiezi);
    //子查询每个板块的帖子的全部内容
    List<Tiezi> selectTiezi(String name) throws SQLException;
    //根据帖子名称来查询帖子信息
    List<Tiezi> chaxinxi(Gong gong);
    //根据帖子id删除帖子
    int shanchu(String id);
}