package com.study.chapter2;

import com.study.chapter2.box.Box;
import com.study.chapter2.box.BoxContext;

import javax.servlet.http.HttpServletRequest;

public class Welcome {

    public String execute() {

        Box box = BoxContext.getThread();

        String NAME = box.get("NAME").toString();
        String MESSAGE = "WELCOME = " + NAME;

        box.put("MESSAGE", MESSAGE);

        return "return url";
    }
}