package yj.dao;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import yj.entity.User;
import yj.utils.Connector;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDaoImplTest {
    Connector connector=new Connector();
    UserDao userDao=new UserDaoImpl(connector.getConnection());

    public UserDaoImplTest() throws Exception {

    }

    @Test
    @Order(1)
    public void deleteAll() throws SQLException {
        int res=userDao.deleteAll();
        System.out.println(res);
    }

    @Test
    @Order(2)
    public void addUser() throws SQLException {
        userDao.addUser(new User("zy","0000000"));
        userDao.addUser(new User("yj","1234567"));
    }

    @Test
    @Order(3)
    public void findByUserName() throws SQLException {
        User user=userDao.findByUsername("zy");
        System.out.println(user);
    }

    @Test
    @Order(4)
    public void updateUser() throws SQLException {
        User user=new User("zy","8888");
        int res=userDao.updateUser(user);
        System.out.println(res);
    }

    @Test
    @Order(5)
    public void deleteUsr() throws SQLException {
        int res=userDao.deleteUser("yj");
        System.out.println(res);
    }

    @Test
    @Order(6)
    public void findAll() throws SQLException {
        List<User> users=userDao.findAll();
        users.forEach(user -> System.out.println(user));
    }

    /*
     * 关闭所有连接
     * */
    @Test
    @Order(7)
    public void closeAll() throws Exception {
        userDao.closeState();
        connector.close();
        System.out.println("数据库关闭连接");
    }
}