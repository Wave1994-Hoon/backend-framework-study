package com.study.chapter2.transaction;

import java.sql.SQLException;


/* 곹통 기능을 전달하는 역할 */
public class TransactionContext {

    private static final ThreadLocal<Transaction> threadLocal = new ThreadLocal<>();

    public TransactionContext() {
    }

    private static Transaction getThreadLocal() {
        Transaction transaction = threadLocal.get();

        if (transaction == null) {
            transaction = createDefaultTransaction();
        }

        setThreadLocal(transaction);
        return transaction;
    }

    /* WAS 에서는 사용할 케이스는 거의 없지만, 테스트를 위해 생성 */
    private static Transaction createDefaultTransaction() {
        return new TransactionSQLiteJdbc();
    }

    static void setThreadLocal(Transaction transaction) {
        threadLocal.set(transaction);
    }

    static void removeThreadLocal() throws SQLException {
        Transaction transaction = threadLocal.get();

        if (transaction != null) {
            transaction.closeConnection();
        }

        threadLocal.remove();
    }

    public static void commit() throws SQLException {
        Transaction transaction = threadLocal.get();

        if (transaction == null) {
            return;
        }

        transaction.commit();
    }

    public static void rollback() throws SQLException {
        Transaction transaction = threadLocal.get();

        if (transaction == null) {
            return;
        }

        transaction.rollback();
    }
}

