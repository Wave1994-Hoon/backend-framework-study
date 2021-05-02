package com.study.chapter5.box;

import javax.servlet.http.HttpServletRequest;

public class BoxHttp extends Box{

    private static final long serialVersionUID = 1L;

    private HttpServletRequest requset;

    public BoxHttp(HttpServletRequest requset) {
        this.requset = requset;
    }

    @Override
    public void put(String key, Object object) {
        requset.setAttribute(key, object);
    }

    @Override
    public Object get(String key) {
        Object object = requset.getAttribute(key);

        if (object != null) { return object; }
        return requset.getParameter(key);
        
    }
}
