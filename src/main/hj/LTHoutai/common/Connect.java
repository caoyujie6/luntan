package main.hj.LTHoutai.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {
//    private static ComboPooledDataSource cp=null;
//    static {
//        try {
//            //获取连接池对象
//            cp = new ComboPooledDataSource();
//
//            //设置连接参数
//            cp.setDriverClass("com.mysql.jdbc.Driver");
//            cp.setJdbcUrl("jdbc:mysql://192.168.51.211/luntan?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT");
//            cp.setUser("root");
//            cp.setPassword("123456");
//
//
//            //设置连接池的参数
//            cp.setInitialPoolSize(5);//初始数量
//            cp.setMaxPoolSize(100);//最大数量
//            cp.setCheckoutTimeout(3000);//最大等待时间
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
static MyPool myPool=new MyPool();
    Connection connection=null;
    //加载驱动，建立连接
    public Connection getConnection(){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url="jdbc:mysql://192.168.51.211/luntan?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
//            connection=DriverManager.getConnection(url,"root","123456");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
//        Connection conn=null;
//        try {
//            //获取连接池对象
//            ComboPooledDataSource cp = new ComboPooledDataSource();
//
//            //设置连接参数
//            cp.setJdbcUrl("jdbc:mysql://192.168.51.211/luntan?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT");
//            cp.setUser("root");
//            cp.setPassword("123456");
//            cp.setDriverClass("com.mysql.cj.jdbc.Driver");
//
//            //设置连接池的参数
//            cp.setInitialPoolSize(5);//初始数量
//            cp.setMaxPoolSize(10);//最大数量
//            cp.setCheckoutTimeout(3000);//最大等待时间
//
//            for(int i = 0 ; i<cp.getMaxPoolSize() ; i++) {
//                conn = cp.getConnection();
//                System.out.println(conn.hashCode());
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return conn;
        return myPool.getConnFromPool();
    }
    //关闭资源
    public void close(){
        try {
            if(connection !=  null){
                connection.close ();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //查找
    public ResultSet select(String sql,Object...objects){
        ResultSet resultSet=null;
        Connection connection=this.getConnection();
        PreparedStatement p=null;
        try {
            p=connection.prepareStatement(sql);
            for (int i = 0; i <objects.length ; i++) {
                p.setObject(i+1,objects[i]);
            }
            resultSet=p.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            myPool.releaseConnection(connection);
        }
       return resultSet;
    }

    //增、删、改
    public int update(String sql,Object...objects){
        Connection connection=this.getConnection();
        PreparedStatement p=null;

        int j=0;

        try {
             p=connection.prepareStatement(sql);
            for (int i = 0; i < objects.length ; i++) {
                p.setObject(i+1,objects[i]);
            }
            j=p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            myPool.releaseConnection(connection);
        }
        return j;
    }
}
