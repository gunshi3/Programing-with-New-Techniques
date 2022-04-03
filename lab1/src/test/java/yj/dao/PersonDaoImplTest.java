package yj.dao;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import yj.entity.Person;
import yj.utils.Connector;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonDaoImplTest {
    Connector connector=new Connector();
    PersonDao personDao=new PersonDaoImpl(connector.getConnection());

    public PersonDaoImplTest() throws Exception {
    }

    @Test
    @Order(1)
    public void deleteAll() throws SQLException {
        int res=personDao.deleteAll();
        System.out.println(res);
    }

    @Test
    @Order(2)
    public void addPerson() throws SQLException {
        Person person = new Person("zy","team.go",20,"18274000661");
        int res=personDao.addPerson(person);
        System.out.println(res);
    }

    @Test
    @Order(3)
    public void findByName() throws SQLException {
        Person person = personDao.findByName("team.go");
        System.out.println(person);
    }

    @Test
    @Order(4)
    public void updatePeron() throws SQLException {
        Person person = new Person("zy","&yj",20,"0000000");
        int res=personDao.updatePeron(person);
        System.out.println(res);
    }

    @Test
    @Order(6)
    public void deletePerson() throws SQLException {
        int res=personDao.deletePerson("zy");
        System.out.println(res);
    }

    @Test
    @Order(5)
    public void findAll() throws SQLException {
        List<Person> persons = personDao.findAll();
        persons.forEach(person -> System.out.println(person));
    }

    /*
     * 关闭所有连接
     * */
    @Test
    @Order(7)
    public void closeAll() throws Exception {
        personDao.closeState();
        connector.close();
        System.out.println("数据库关闭连接");
    }
}