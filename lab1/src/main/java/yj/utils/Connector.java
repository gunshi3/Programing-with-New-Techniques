package yj.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/*
*   数据库连接工具类
*/
public class Connector {
    private static final String driverClass=PropertyUtil.getValue("driverClass");
    private static final String url=PropertyUtil.getValue("url");
    private static final String user=PropertyUtil.getValue("user");
    private static final String password=PropertyUtil.getValue("password");
    private Connection conn=null;

    //构造函数加载驱动
    public Connector() throws Exception{
        try{
            Class.forName(driverClass);
            this.conn= DriverManager.getConnection(url,user,password);
        }catch(Exception e){
            throw e;
        }
    }
    
    //获取连接对象
    public Connection getConnection(){
        return this.conn;
    }
    
    //关闭连接
    public void close() throws Exception{
        if(this.conn!=null){
            try{
                this.conn.close();
            }catch(Exception e){
                throw e;
            }
        }
    }
}
