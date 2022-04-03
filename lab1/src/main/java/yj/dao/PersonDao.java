package yj.dao;
import yj.entity.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao{

    public void closeState() throws SQLException;

    public int addPerson(Person person) throws SQLException;            //增加

    public int deletePerson(String name) throws SQLException;           //删除

    public int updatePeron(Person person) throws SQLException;          //修改

    public Person findByName(String name) throws SQLException;          //name查询

    public Person findByUsername(String username) throws SQLException;  //姓名查询

    public List<Person> findAll() throws SQLException;                  //全查询

    public int deleteBeginWith(String username) throws SQLException;    //删除某个字符串开头的数据

    public int deleteAll() throws SQLException;                                             //删除所有的信息
}