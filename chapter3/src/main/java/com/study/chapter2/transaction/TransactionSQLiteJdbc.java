package com.study.chapter2.transaction;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class TransactionSQLiteJdbc extends Transaction{

    @Override
    protected Connection createConnection() throws SQLException {

        SQLiteConfig config = new SQLiteConfig();
        Properties properties = config.toProperties();

        return org.sqlite.JDBC.createConnection("jdbc:sqlite:C:\\public\\sqlite\\code5.db", properties);
    }
}
