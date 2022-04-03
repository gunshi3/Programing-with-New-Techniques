package yj.dao;

import yj.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao{
    public void closeState() throws SQLException;

    public int addUser(User user) throws SQLException;                  //增加

    public int deleteUser(String username) throws SQLException;         //删除

    public int updateUser(User user) throws SQLException;               //修改

    public User findByUsername(String username) throws SQLException;        //姓名查询

    public List<User> findAll() throws SQLException;                    //全查询

    public int deleteBeginWith(String username) throws SQLException;    //以特定字符串开头的信息

    public int deleteAll() throws SQLException;
}