package com.study.chapter5.box;

import java.io.Serializable;

public abstract class Box implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract void put(String key, Object object);

    public abstract Object get(String key);
}
