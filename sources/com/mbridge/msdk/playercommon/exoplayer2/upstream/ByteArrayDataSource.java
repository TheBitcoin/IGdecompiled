package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;

public final class ByteArrayDataSource implements DataSource {
    private int bytesRemaining;
    private final byte[] data;
    private int readPosition;
    private Uri uri;

    public ByteArrayDataSource(byte[] bArr) {
        boolean z4;
        Assertions.checkNotNull(bArr);
        if (bArr.length > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        this.data = bArr;
    }

    public final void close() throws IOException {
        this.uri = null;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final long open(DataSpec dataSpec) throws IOException {
        this.uri = dataSpec.uri;
        long j4 = dataSpec.position;
        int i4 = (int) j4;
        this.readPosition = i4;
        long j5 = dataSpec.length;
        if (j5 == -1) {
            j5 = ((long) this.data.length) - j4;
        }
        int i5 = (int) j5;
        this.bytesRemaining = i5;
        if (i5 > 0 && i4 + i5 <= this.data.length) {
            return (long) i5;
        }
        throw new IOException("Unsatisfiable range: [" + this.readPosition + ", " + dataSpec.length + "], length: " + this.data.length);
    }

    public final int read(byte[] bArr, int i4, int i5) throws IOException {
        if (i5 == 0) {
            return 0;
        }
        int i6 = this.bytesRemaining;
        if (i6 == 0) {
            return -1;
        }
        int min = Math.min(i5, i6);
        System.arraycopy(this.data, this.readPosition, bArr, i4, min);
        this.readPosition += min;
        this.bytesRemaining -= min;
        return min;
    }
}
