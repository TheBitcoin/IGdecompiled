package com.mbridge.msdk.tracker.network.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class l extends ByteArrayOutputStream implements AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    private final c f15624a;

    public l(c cVar, int i4) {
        this.f15624a = cVar;
        this.buf = cVar.a(Math.max(i4, 256));
    }

    private void a(int i4) {
        int i5 = this.count;
        if (i5 + i4 > this.buf.length) {
            byte[] a5 = this.f15624a.a((i5 + i4) * 2);
            System.arraycopy(this.buf, 0, a5, 0, this.count);
            this.f15624a.a(this.buf);
            this.buf = a5;
        }
    }

    public final void close() throws IOException {
        this.f15624a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.f15624a.a(this.buf);
    }

    public final synchronized void write(byte[] bArr, int i4, int i5) {
        a(i5);
        if (bArr != null) {
            super.write(bArr, i4, i5);
        }
    }

    public final synchronized void write(int i4) {
        a(1);
        super.write(i4);
    }
}
