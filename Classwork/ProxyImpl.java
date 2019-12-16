package Classwork;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyImpl implements InvocationHandler {

    private final Object delegate;

    ProxyImpl(Object delegate) {
        this.delegate = delegate;
    }


    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(delegate, objects);
        long endTime = System.currentTimeMillis();
        System.out.printf("Time: %d\n", endTime - startTime);
        return result;
    }
}