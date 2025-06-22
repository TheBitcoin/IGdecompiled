package com.mbridge.msdk.playercommon.exoplayer2.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class ReusableBufferedOutputStream extends BufferedOutputStream implements AutoCloseable {
    private boolean closed;

    public ReusableBufferedOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public final void close() throws IOException {
        this.closed = true;
        try {
            flush();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            Util.sneakyThrow(th);
        }
    }

    public final void reset(OutputStream outputStream) {
        Assertions.checkState(this.closed);
        this.out = outputStream;
        this.count = 0;
        this.closed = false;
    }

    public ReusableBufferedOutputStream(OutputStream outputStream, int i4) {
        super(outputStream, i4);
    }
}
