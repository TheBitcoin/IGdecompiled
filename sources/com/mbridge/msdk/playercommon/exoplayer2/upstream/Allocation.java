package com.mbridge.msdk.playercommon.exoplayer2.upstream;

public final class Allocation {
    public final byte[] data;
    public final int offset;

    public Allocation(byte[] bArr, int i4) {
        this.data = bArr;
        this.offset = i4;
    }
}
