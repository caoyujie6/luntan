package main.hj.LTHoutai.seriver.UserSeriverImpl;

import main.hj.LTHoutai.dao.UserDaoImpl.UserDaoImpl;
import main.hj.LTHoutai.entiy.User;
import main.hj.LTHoutai.seriver.UserSeriver;
import java.sql.SQLException;
import java.util.List;

public class UserSeriverImpl implements UserSeriver {
    UserDaoImpl impl=new UserDaoImpl();
    @Override
    public List<User> select() {
        List<User> list=null;
        try {
          list= impl.selectUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
