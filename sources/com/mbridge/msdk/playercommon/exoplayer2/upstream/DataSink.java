package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import java.io.IOException;

public interface DataSink {

    public interface Factory {
        DataSink createDataSink();
    }

    void close() throws IOException;

    void open(DataSpec dataSpec) throws IOException;

    void write(byte[] bArr, int i4, int i5) throws IOException;
}
