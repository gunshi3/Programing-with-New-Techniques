package yj.dao;
import yj.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private java.sql.Connection conn=null;          //连接对象
    private java.sql.PreparedStatement pst=null;    //数据库PreparedStatement对象

    //构造方法
    public UserDaoImpl(Connection connection) throws Exception {
        this.conn=connection;                       //获取数据库链接
    }

    public void closeState() throws SQLException {
        if(pst!=null) pst.close();
    }

    @Override
    public int addUser(User user) throws SQLException {
        int count=0;
        String sql="INSERT INTO user (username,pass) VALUES(?,?)";
        this.pst=this.conn.prepareStatement(sql);
        this.pst.setString(1,user.getUsername());
        this.pst.setString(2, user.getPass());
        count=this.pst.executeUpdate();
        return count;
    }

    @Override
    public int deleteUser(String username) throws SQLException {
        int count=0;
        String sql="delete from user where username= ?";
        this.pst=this.conn.prepareStatement(sql);
        this.pst.setString(1,username);
        count=this.pst.executeUpdate();
        return count;
    }

    public int updateUser(User user) throws SQLException {
        int count=0;
        String sql="update user set pass = ? where username = ?";
        this.pst=this.conn.prepareStatement(sql);
        this.pst.setString(1, user.getPass());
        this.pst.setString(2, user.getUsername());
        count=this.pst.executeUpdate();
        return count;
    }

    @Override
    public User findByUsername(String username) throws SQLException {
        User user=null;
        String sql="SELECT * FROM user WHERE username= ?";
        this.pst=this.conn.prepareStatement(sql);
        this.pst.setString(1, username);
        ResultSet res=pst.executeQuery();
        if(res.next()){
            user=new User(res.getString(1),res.getString(2));
        }
        return user;
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> all=new ArrayList<User>();
        String sql="SELECT * FROM user";
        this.pst=this.conn.prepareStatement(sql);
        ResultSet res=pst.executeQuery();
        while(res.next()){
            all.add(new User(res.getString(1),res.getString(2)));
        }
        return all;
    }

    @Override
    public int deleteBeginWith(String username) throws SQLException {
        int count=0;
        String sql="delete from user where username like ?";
        this.pst=this.conn.prepareStatement(sql);
        this.pst.setString(1,username);
        count=this.pst.executeUpdate();
        return count;
    }

    @Override
    public int deleteAll() throws SQLException {
        int count=0;
        String sql="delete from user";
        this.pst=this.conn.prepareStatement(sql);
        count=this.pst.executeUpdate();
        return count;
    }
}
