package com.mbridge.msdk.newreward.function.common;

public class MBridgeOffsetManager {
    private int offset = 0;

    public int getOffset() {
        return Math.max(this.offset, 0);
    }

    public void increaseOffset(int i4) {
        this.offset += i4;
    }

    public void resetOffset() {
        this.offset = 0;
    }
}
