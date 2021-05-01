package com.study.chapter2.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TransactionSQLiteJdbcOld extends Transaction{

    @Override
    protected Connection createConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC"); // https://kyun2.tistory.com/23
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // DriverManager 에 JDBC 객체 등록
        return DriverManager.getConnection("jdbc:sqlite:C:\\public\\sqlite\\code5.db");
    }
}
