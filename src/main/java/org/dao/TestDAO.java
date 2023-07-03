package org.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class TestDAO {
    public Connection getConnection() throws Exception {
        Context initCtx = new InitialContext();
//		Context envCtx = (Context) initCtx.lookup("java:comp/env");
//		DataSource  ds = (DataSource)envCtx.lookup("jdbc:MemberDB");
        DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc:testDB");
        Connection conn = ds.getConnection();
//        System.out.println(conn);
//        return conn;
        return conn;
    }

    public String test() {
        String msg = "connection success";
        try {
            this.getConnection();
        }
        catch (Exception e) {
            e.printStackTrace();
            msg = "connection failed";
        }
        return msg;
    }
}
