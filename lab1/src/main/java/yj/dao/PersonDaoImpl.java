package yj.dao;

import yj.entity.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao{
    private Connection conn=null;          //连接对象
    private PreparedStatement pst=null;    //数据库PreparedStatement对象


    public PersonDaoImpl(Connection connection) throws Exception {
        this.conn=connection;        //获取数据库链接
    }

    @Override
    public void closeState() throws SQLException {
        if(pst!=null) pst.close();
    }

    @Override
    public int addPerson(Person person) throws SQLException {
        int count=0;
        String sql="INSERT INTO person (username,name,age,teleno) VALUES(?,?,?,?)";
        this.pst=this.conn.prepareStatement(sql);
        this.pst.setString(1,person.getUsername());
        this.pst.setString(2,person.getName());
        this.pst.setObject(3,person.getAge());
        this.pst.setString(4,person.getTeleno());
        count=this.pst.executeUpdate();
        return count;
    }

    @Override
    public int deletePerson(String username) throws SQLException {
        int count=0;
        String sql="delete from person where username= ?";
        this.pst=this.conn.prepareStatement(sql);
        this.pst.setString(1,username);
        count=this.pst.executeUpdate();
        return count;
    }

    @Override
    public int updatePeron(Person person) throws SQLException {
        int count=0;
        String sql="update person set name=?,age=?,teleno=? where username=?";
        this.pst=this.conn.prepareStatement(sql);
        this.pst.setString(1,person.getName());
        this.pst.setObject(2,person.getAge());
        this.pst.setString(3,person.getTeleno());
        this.pst.setString(4,person.getUsername());
        count=this.pst.executeUpdate();
        return count;
    }

    @Override
    public Person findByName(String name) throws SQLException {
        Person person=null;
        String sql="SELECT * FROM person WHERE name= ?";
        this.pst=this.conn.prepareStatement(sql);
        this.pst.setString(1, name);
        ResultSet res=pst.executeQuery();
        if(res.next()){
            person=new Person(res.getString(1),res.getString(2),res.getInt(3),res.getString(4));
        }
        return person;
    }

    @Override
    public Person findByUsername(String username) throws SQLException {
        Person person=null;
        String sql="SELECT * FROM person WHERE username= ?";
        this.pst=this.conn.prepareStatement(sql);
        this.pst.setString(1, username);
        ResultSet res=pst.executeQuery();
        if(res.next()){
            person=new Person(res.getString(1),res.getString(2),res.getInt(3),res.getString(4));
        }
        return person;
    }

    @Override
    public List<Person> findAll() throws SQLException {
        List<Person> all= new ArrayList<Person>();
        String sql="SELECT * FROM person";
        this.pst=this.conn.prepareStatement(sql);
        ResultSet res=pst.executeQuery();
        while(res.next()){
            all.add(new Person(res.getString(1),res.getString(2),res.getInt(3),res.getString(4)));
        }
        return all;
    }

    @Override
    public int deleteBeginWith(String username) throws SQLException {
        int count=0;
        String sql="delete from person where username like ?";
        this.pst=this.conn.prepareStatement(sql);
        this.pst.setString(1,username);
        count=this.pst.executeUpdate();
        return count;
    }

    @Override
    public int deleteAll() throws SQLException {
        int count=0;
        String sql="delete from person";
        this.pst=this.conn.prepareStatement(sql);
        count=this.pst.executeUpdate();
        return count;
    }
}
