package yj.dao;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import yj.entity.Person;
import yj.entity.User;
import yj.utils.Connector;
import yj.utils.Displayer;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComTest {
    Connector connector=new Connector();

    UserDao userDao=new UserDaoImpl(connector.getConnection());
    PersonDao personDao=new PersonDaoImpl(connector.getConnection());
    Displayer displayer=new Displayer();

    public ComTest() throws Exception {
    }

    /*
    * 在正式开始执行之前，先清除数据库中的数据
    */
    @Test
    @Order(1)
    public void deleteAll() throws SQLException {
        personDao.deleteAll();
        userDao.deleteAll();

        //打印
        List<User> userList = userDao.findAll();
        displayer.displayUsers(userList);
        List<Person> personList=personDao.findAll();
        displayer.displayPersons(personList);
    }

    /*
    * 表user中插入4行数据,person中插入3行数据
    */
    @Test
    @Order(2)
    public void firstAdd() throws SQLException {
        /*user*/
        //待插入数据集合
        List<User> users=new ArrayList<User>();
        users.add(new User("ly","123456"));
        users.add(new User("liming","345678"));
        users.add(new User("test","11111"));
        users.add(new User("test1","12345"));
        //插入数据
        users.forEach(user -> {
            try {
                userDao.addUser(user);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //打印
        List<User> userList = userDao.findAll();
        displayer.displayUsers(userList);

        /*person*/
        //待插入数据集合
        List<Person> persons=new ArrayList<Person>();
        persons.add(new Person("ly","雷力",null,null));
        persons.add(new Person("liming","李明",25,null));
        persons.add(new Person("test","测试用户",20,"13388449933"));
        //插入数据
        persons.forEach(person -> {
            try {
                personDao.addPerson(person);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //打印
        List<Person> personList = personDao.findAll();
        displayer.displayPersons(personList);
    }

    /*
     * 在person表中插入5行数据,并且按要求对user修改
     */
    @Test
    @Order(3)
    public void secondAdd() throws SQLException {
        //待插入数据集合
        List<Person> persons=new ArrayList<Person>();
        persons.add(new Person("ly","王五",null,null));
        persons.add(new Person("test2","测试用户2",null,null));
        persons.add(new Person("test1","测试用户1",33,null));
        persons.add(new Person("test","张三",23,"18877009966"));
        persons.add(new Person("admin","admin",null,null));

        //插入数据
        persons.forEach(person -> {
            try {
                if(personDao.findByUsername(person.getUsername())!=null){       //数据记录存在于person
                    personDao.updatePeron(person);                      //修改
                }
                else{
                    if(userDao.findByUsername(person.getUsername())==null) {    //信息不存在于user
                        userDao.addUser(new User(person.getUsername(),"888888"));
                    }
                    personDao.addPerson(person);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //打印
        List<User> userList = userDao.findAll();
        displayer.displayUsers(userList);

        //打印
        List<Person> personList = personDao.findAll();
        displayer.displayPersons(personList);
    }

    /*
     * 删除users表中test打头的username
     */
    @Test
    @Order(4)
    public void deleteALLTestBegin() throws SQLException {
        personDao.deleteBeginWith("test%");
        userDao.deleteBeginWith("test%");
        //打印
        List<User> userList = userDao.findAll();
        displayer.displayUsers(userList);
        List<Person> personList = personDao.findAll();
        displayer.displayPersons(personList);
    }

    /*
    * 关闭所有连接
    * */
    @Test
    @Order(5)
    public void closeAll() throws Exception {
        userDao.closeState();
        personDao.closeState();
        connector.close();
        System.out.println("数据库关闭连接");
    }
}