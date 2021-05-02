package com.study.chapter5;

import com.study.chapter5.box.Box;
import com.study.chapter5.core.BoxContext;

public class Welcome {

    public String execute() {

        Box box = BoxContext.getThreadLocal();

        String NAME = box.get("NAME").toString();
        String MESSAGE = "WELCOME = " + NAME;

        box.put("MESSAGE", MESSAGE);

        return "return url";
    }
}