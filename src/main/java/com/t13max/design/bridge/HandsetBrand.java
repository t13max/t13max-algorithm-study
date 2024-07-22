package com.t13max.design.bridge;

/**
 * @Author 呆呆
 * @Datetime 2022/4/20 7:55
 */
public abstract class HandsetBrand {

    private HandsetSoft soft;

    public HandsetBrand(HandsetSoft soft) {
        this.soft = soft;
    }

    public HandsetSoft getSoft() {
        return soft;
    }

    public void setSoft(HandsetSoft soft) {
        this.soft = soft;
    }

    public abstract void run();
}
