package com.mbridge.msdk.newreward.player;

public class Calculate {
    private int mValue;

    public int addOne() {
        int i4 = this.mValue + 1;
        this.mValue = i4;
        return i4;
    }

    public int reduceOne() {
        int i4 = this.mValue - 1;
        this.mValue = i4;
        return i4;
    }
}
