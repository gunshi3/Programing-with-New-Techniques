package yj.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConnectorTest {

    Connector connector=new Connector();

    public ConnectorTest() throws Exception {
    }

    @Test
    public void getConnection() {
        Connection connection = connector.getConnection();
        System.out.println(connection);
    }
}