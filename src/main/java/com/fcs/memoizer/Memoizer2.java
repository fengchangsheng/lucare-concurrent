package com.fcs.memoizer;

import java.io.InterruptedIOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Lucare.Feng on 2017/2/25.
 * 用ConcurrentHashMap代替HashMap来改进Memoizer1
 * 避免方法的同步带来串行性 但是两个线程同时调用存在漏洞
 * 导致计算得到相同的值
 */
public class Memoizer2<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(A arg) throws InterruptedIOException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
