package com.study.chapter1.controller;

import com.study.chapter1.service.Welcome;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MasterController extends HttpServlet {

    private static final long serialVersionUID = 1L; // https://woowabros.github.io/experience/2017/10/17/java-serialize2.html

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Welcome welcome = new Welcome();

        String url = welcome.execute(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request,response);
    }
}
