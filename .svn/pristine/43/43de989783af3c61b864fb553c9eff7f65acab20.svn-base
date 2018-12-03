package main.hj.luntan.dao.impl;

import main.hj.luntan.common.Connect;
import main.hj.luntan.dao.MinganciDao;

public class MinganciDaoImpl implements MinganciDao {
    Connect connect=new Connect();
    @Override
    public int zeng(String shuju) {
        String sql="insert into minganci(min) values (?)";
        int i=connect.update(sql,shuju);
        return i;
    }
}
