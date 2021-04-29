package com.study.chapter1.service;

import javax.servlet.http.HttpServletRequest;

public class Welcome {

    public String execute(HttpServletRequest request) {

        String NAME = request.getParameter("NAME");

        String MESSAGE = "WELCOME = " + NAME;

        request.setAttribute("MESSAGE", MESSAGE);

        return "return url";
    }
}