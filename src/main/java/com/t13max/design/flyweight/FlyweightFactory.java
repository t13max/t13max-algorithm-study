package com.t13max.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 呆呆
 * @Datetime 2022/4/21 8:03
 */
public class FlyweightFactory {

    private Map<String, Flyweight> flyweightMap = new HashMap<>();

    public FlyweightFactory() {
        this.flyweightMap.put("X", new ConcreteFlyweight());
        this.flyweightMap.put("Y", new ConcreteFlyweight());
        this.flyweightMap.put("Z", new ConcreteFlyweight());
    }

    public Flyweight getFlyweight(String key) {
        //也可以不存在就建一个
        return flyweightMap.get(key);
    }
}
