package com.study.chapter2;

import com.study.chapter2.box.Box;
import com.study.chapter2.box.BoxHttp;
import com.study.chapter2.transaction.Transaction;
import com.study.chapter2.transaction.TransactionSQLitePool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class MasterController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Box box = new BoxHttp(request);
        BoxContext.setThreadLocal(box);

        Transaction transaction = new TransactionSQLitePool();
        TransactionContext.setThreadLocal(transaction);

        try {

            Welcome welcome = new Welcome();
            String url = welcome.execute();

            TransactionContext.commit();

            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);

            TransactionContext.removeThreadLocal();
            BoxContext.removeThreadLocal();

        } catch (Exception ex) {
            try {
                TransactionContext.rollback();
            } catch (SQLException exx) {
                throw new ServletException(exx);
            }
        }
    }
}
