package com.t13max.design.proxy.jdk;

import com.atb.design.entity.Shape;
import com.atb.design.entity.ShapeImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author 呆呆
 * @Datetime 2022/2/27 17:40
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object object;

    public DynamicProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前");
        Object result = method.invoke(object, args);
        System.out.println("代理后");
        return result;
    }


    public static void main(String[] args) {
        Shape shape = new ShapeImpl();
        Shape proxyShape = (Shape) Proxy.newProxyInstance(Shape.class.getClassLoader(), new Class[]{Shape.class}, new DynamicProxyHandler(shape));
        proxyShape.test();
    }
}
