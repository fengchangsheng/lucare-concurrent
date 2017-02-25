package com.fcs.memoizer;

import java.io.InterruptedIOException;
import java.math.BigInteger;

/**
 * Created by Lucare.Feng on 2017/2/25.
 */
public class ExpensiveFunction implements Computable<String,BigInteger> {

    public BigInteger compute(String arg) throws InterruptedIOException {
        // 在经过长时间计算后
        return new BigInteger(arg);
    }

}
