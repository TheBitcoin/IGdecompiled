package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class ByteArrayDataSink implements DataSink {
    private ByteArrayOutputStream stream;

    public final void close() throws IOException {
        this.stream.close();
    }

    public final byte[] getData() {
        ByteArrayOutputStream byteArrayOutputStream = this.stream;
        if (byteArrayOutputStream == null) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public final void open(DataSpec dataSpec) throws IOException {
        boolean z4;
        long j4 = dataSpec.length;
        if (j4 == -1) {
            this.stream = new ByteArrayOutputStream();
            return;
        }
        if (j4 <= 2147483647L) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        this.stream = new ByteArrayOutputStream((int) dataSpec.length);
    }

    public final void write(byte[] bArr, int i4, int i5) throws IOException {
        this.stream.write(bArr, i4, i5);
    }
}
