package com.fcs.memoizer;

import java.io.InterruptedIOException;

/**
 * Created by Lucare.Feng on 2017/2/25.
 */
public interface Computable<A, V> {

    V compute(A arg) throws InterruptedIOException;

}
