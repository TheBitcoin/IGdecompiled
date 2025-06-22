package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class m extends InputStream implements AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f17270a;

    /* renamed from: b  reason: collision with root package name */
    private long f17271b;

    /* renamed from: c  reason: collision with root package name */
    private long f17272c;

    /* renamed from: d  reason: collision with root package name */
    private long f17273d;

    /* renamed from: e  reason: collision with root package name */
    private long f17274e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17275f;

    /* renamed from: g  reason: collision with root package name */
    private int f17276g;

    m(InputStream inputStream) {
        this(inputStream, 4096);
    }

    private void i(long j4) {
        try {
            long j5 = this.f17272c;
            long j6 = this.f17271b;
            if (j5 >= j6 || j6 > this.f17273d) {
                this.f17272c = j6;
                this.f17270a.mark((int) (j4 - j6));
            } else {
                this.f17270a.reset();
                this.f17270a.mark((int) (j4 - this.f17272c));
                k(this.f17272c, this.f17271b);
            }
            this.f17273d = j4;
        } catch (IOException e5) {
            throw new IllegalStateException("Unable to mark: " + e5);
        }
    }

    private void k(long j4, long j5) {
        while (j4 < j5) {
            long skip = this.f17270a.skip(j5 - j4);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j4 += skip;
        }
    }

    public void a(boolean z4) {
        this.f17275f = z4;
    }

    public int available() {
        return this.f17270a.available();
    }

    public void close() {
        this.f17270a.close();
    }

    public void d(long j4) {
        if (this.f17271b > this.f17273d || j4 < this.f17272c) {
            throw new IOException("Cannot reset");
        }
        this.f17270a.reset();
        k(this.f17272c, j4);
        this.f17271b = j4;
    }

    public long g(int i4) {
        long j4 = this.f17271b + ((long) i4);
        if (this.f17273d < j4) {
            i(j4);
        }
        return this.f17271b;
    }

    public void mark(int i4) {
        this.f17274e = g(i4);
    }

    public boolean markSupported() {
        return this.f17270a.markSupported();
    }

    public int read() {
        if (!this.f17275f) {
            long j4 = this.f17273d;
            if (this.f17271b + 1 > j4) {
                i(j4 + ((long) this.f17276g));
            }
        }
        int read = this.f17270a.read();
        if (read != -1) {
            this.f17271b++;
        }
        return read;
    }

    public void reset() {
        d(this.f17274e);
    }

    public long skip(long j4) {
        if (!this.f17275f) {
            long j5 = this.f17271b;
            if (j5 + j4 > this.f17273d) {
                i(j5 + j4 + ((long) this.f17276g));
            }
        }
        long skip = this.f17270a.skip(j4);
        this.f17271b += skip;
        return skip;
    }

    m(InputStream inputStream, int i4) {
        this(inputStream, i4, 1024);
    }

    private m(InputStream inputStream, int i4, int i5) {
        this.f17274e = -1;
        this.f17275f = true;
        this.f17276g = -1;
        this.f17270a = !inputStream.markSupported() ? new BufferedInputStream(inputStream, i4) : inputStream;
        this.f17276g = i5;
    }

    public int read(byte[] bArr) {
        if (!this.f17275f) {
            long j4 = this.f17271b;
            if (((long) bArr.length) + j4 > this.f17273d) {
                i(j4 + ((long) bArr.length) + ((long) this.f17276g));
            }
        }
        int read = this.f17270a.read(bArr);
        if (read != -1) {
            this.f17271b += (long) read;
        }
        return read;
    }

    public int read(byte[] bArr, int i4, int i5) {
        if (!this.f17275f) {
            long j4 = this.f17271b;
            long j5 = (long) i5;
            if (j4 + j5 > this.f17273d) {
                i(j4 + j5 + ((long) this.f17276g));
            }
        }
        int read = this.f17270a.read(bArr, i4, i5);
        if (read != -1) {
            this.f17271b += (long) read;
        }
        return read;
    }
}
