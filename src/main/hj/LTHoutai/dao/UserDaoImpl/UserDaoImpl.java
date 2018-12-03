package main.hj.LTHoutai.dao.UserDaoImpl;

import main.hj.LTHoutai.dao.UserDao;
import main.hj.LTHoutai.entiy.User;
import main.hj.luntan.common.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    Connect c=new Connect();
    @Override
    public List<User> selectUser() throws SQLException {
        List<User> list=new ArrayList<>();
        String sql="select * from yonghu";
        ResultSet set=c.select(sql);
        while (set.next()){
            User user=new User();
            user.setId(set.getInt("id"));
            user.setJueseid( set.getInt("jueseid"));
            user.setName( set.getString("name"));
            user.setPassword(   set.getString("password"));
            user.setShoujihao( set.getString("shoujihao"));
            list.add(user);
        }
        return list;
    }
}
