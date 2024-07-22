package com.t13max.design.bridge;

/**
 * @Author 呆呆
 * @Datetime 2022/4/20 7:56
 */
public class HandsetBrandN extends HandsetBrand {

    public HandsetBrandN(HandsetSoft soft) {
        super(soft);
    }

    @Override
    public void run() {
        getSoft().run();
    }

}
