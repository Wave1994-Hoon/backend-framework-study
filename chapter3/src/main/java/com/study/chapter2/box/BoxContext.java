package com.study.chapter2.box;

public class BoxContext {

    private static ThreadLocal<Box> threadLocal = new ThreadLocal<Box>();

    /* 개발자가 직접 호출하면 안되기 때문에 default 접근 제어 사용 */
    static void setThreadLocal(Box box) {
        threadLocal.set(box);
    }

    static void removeThreadLocal() {
        threadLocal.remove();
    }

    public static Box getThreadLocal() {
        return getBox();
    }

    private static Box getBox() {
        Box box = threadLocal.get();

        if (box == null) {
            BoxLocal boxLocal = new BoxLocal();
            setThreadLocal(boxLocal);
        }

        return box;
    }
}
