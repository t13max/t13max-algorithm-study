package com.t13max.design.proxy.cglib;


/**
 * @Author 呆呆
 * @Datetime 2022/2/27 17:52
 */
/*public class CglibProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理前");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("代理后");
        return result;
    }

    public static void main(String[] args) {
        Shape shape = new ShapeImpl();
        CglibProxy cglibProxy = new CglibProxy();
        ShapeImpl shapeProxy = (ShapeImpl) cglibProxy.getInstance(shape);
        shapeProxy.test();
    }
}*/
