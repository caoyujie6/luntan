package main.hj.luntan.seriver.impl;

import main.hj.luntan.common.Gong;
import main.hj.luntan.dao.impl.TieziDaoImpl;
import main.hj.luntan.entity.Tiezi;
import main.hj.luntan.seriver.TieziSeriver;
import java.sql.SQLException;
import java.util.List;
public class TieziSeriverImpl implements TieziSeriver {
    TieziDaoImpl tieziDao=new TieziDaoImpl();
    @Override
    public List<String> chaxun(Tiezi tiezi) {
        return tieziDao.chatiezi(tiezi);
    }
   //查询相关板块的所有帖子
    @Override
    public List<Tiezi> select(String name) {
        try {
            return tieziDao.selectTiezi(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //模糊分页根据文本框内的内容
    @Override
    public List<Tiezi> mohu(Gong gong) {
        return tieziDao.chaxinxi(gong);
    }

    @Override
    public int shanchu(String id) {
        return tieziDao.shanchu(id);
    }
}