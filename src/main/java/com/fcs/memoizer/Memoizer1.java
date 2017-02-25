package com.fcs.memoizer;

import java.io.InterruptedIOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lucare.Feng on 2017/2/25.
 * 使用HashMap和同步机制来初始化缓存
 * 每次只有一个线程能执行compute
 */
public class Memoizer1<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    public synchronized V compute(A arg) throws InterruptedIOException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
