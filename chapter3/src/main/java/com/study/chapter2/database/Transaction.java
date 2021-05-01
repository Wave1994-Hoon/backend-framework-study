package com.study.chapter2.database;

import java.sql.*;
import java.util.ArrayList;


/*
* Transaction Flow
* 1. Connection 객체 생성
* 2. SQL 에 필요한 기능 생성 --> PreparedStatement, Statement, ResultSet
* 3. Connection close
* 4. 트랙잭션 상태 제어
*
*
*
* */

public abstract class Transaction {

    private final ArrayList<Statement> stateList = new ArrayList<>();

    private final ArrayList<ResultSet> resultList = new ArrayList<>();

    private Connection connection;

    private boolean isAutoCommit = false;

    protected abstract Connection createConnection() throws SQLException;

    void close() throws SQLException {

        for (ResultSet resultSet : resultList) {
            resultSet.close();
        }

        resultList.clear();

        for (Statement statement : stateList) {
            statement.close();
        }

        stateList.clear();
    }

    public void setAutoCommitIsFalse() throws SQLException {
        if (isAutoCommit) {
            return;
        }

        isAutoCommit = true;
        connection.setAutoCommit(false);
    }

    private Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = createConnection();
        }

        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection == null) {
            return;
        }

        connection.close();
    }


    public void commit() throws SQLException {
        if (connection == null) {
            return;
        }

        connection.close();
        connection.commit();
    }

    public void rollback() throws SQLException {
        if (connection == null) {
            return;
        }

        connection.commit();
        connection.rollback();
    }

    PreparedStatement prepareStatement(String SQL) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preoaredStatement = connection.prepareStatement(SQL);
        stateList.add(preoaredStatement);

        return preoaredStatement;
    }

    Statement createStatement() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        stateList.add(statement);

        return statement;
    }

    ResultSet getResultSet(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        resultList.add(resultSet);

        return resultSet;
    }
}
