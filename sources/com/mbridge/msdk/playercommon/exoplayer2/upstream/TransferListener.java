package com.mbridge.msdk.playercommon.exoplayer2.upstream;

public interface TransferListener<S> {
    void onBytesTransferred(S s4, int i4);

    void onTransferEnd(S s4);

    void onTransferStart(S s4, DataSpec dataSpec);
}
