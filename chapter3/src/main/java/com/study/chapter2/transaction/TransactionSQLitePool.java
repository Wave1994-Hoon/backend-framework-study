package com.study.chapter2.transaction;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionSQLitePool extends Transaction{

    protected Connection createConnection() throws SQLException, NamingException {
        Context context = new InitialContext();
        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/code5");

        return dataSource.getConnection();
    }
}
