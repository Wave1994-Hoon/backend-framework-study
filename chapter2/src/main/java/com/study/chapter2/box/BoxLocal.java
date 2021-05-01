package com.study.chapter2.box;

import java.util.HashMap;

public class BoxLocal extends Box{

    private static final long serialVersionUID = 1L;

    private HashMap<String, Object> hashMap= new HashMap<String, Object>();

    public BoxLocal() {
    }

    @Override
    public void put(String key, Object object) {
        hashMap.put(key, object);
    }

    @Override
    public Object get(String key) {
        return hashMap.get(key);
    }
}
