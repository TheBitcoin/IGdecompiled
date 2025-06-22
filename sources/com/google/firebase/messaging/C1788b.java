package com.google.firebase.messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* renamed from: com.google.firebase.messaging.b  reason: case insensitive filesystem */
abstract class C1788b {
    private static byte[] a(Queue queue, int i4) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        if (bArr.length == i4) {
            return bArr;
        }
        int length = i4 - bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, i4);
        while (length > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int min = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, copyOf, i4 - length, min);
            length -= min;
        }
        return copyOf;
    }

    public static InputStream b(InputStream inputStream, long j4) {
        return new a(inputStream, j4);
    }

    private static int c(long j4) {
        if (j4 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j4 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j4;
    }

    public static byte[] d(InputStream inputStream) {
        return e(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] e(InputStream inputStream, Queue queue, int i4) {
        int i5;
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i4) * 2));
        while (i4 < 2147483639) {
            int min2 = Math.min(min, 2147483639 - i4);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i6 = 0;
            while (i6 < min2) {
                int read = inputStream.read(bArr, i6, min2 - i6);
                if (read == -1) {
                    return a(queue, i4);
                }
                i6 += read;
                i4 += read;
            }
            long j4 = (long) min;
            if (min < 4096) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            min = c(j4 * ((long) i5));
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    /* renamed from: com.google.firebase.messaging.b$a */
    private static final class a extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private long f11337a;

        /* renamed from: b  reason: collision with root package name */
        private long f11338b = -1;

        a(InputStream inputStream, long j4) {
            super(inputStream);
            this.f11337a = j4;
        }

        public int available() {
            return (int) Math.min((long) this.in.available(), this.f11337a);
        }

        public synchronized void mark(int i4) {
            this.in.mark(i4);
            this.f11338b = this.f11337a;
        }

        public int read() {
            if (this.f11337a == 0) {
                return -1;
            }
            int read = this.in.read();
            if (read != -1) {
                this.f11337a--;
            }
            return read;
        }

        public synchronized void reset() {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            } else if (this.f11338b != -1) {
                this.in.reset();
                this.f11337a = this.f11338b;
            } else {
                throw new IOException("Mark not set");
            }
        }

        public long skip(long j4) {
            long skip = this.in.skip(Math.min(j4, this.f11337a));
            this.f11337a -= skip;
            return skip;
        }

        public int read(byte[] bArr, int i4, int i5) {
            long j4 = this.f11337a;
            if (j4 == 0) {
                return -1;
            }
            int read = this.in.read(bArr, i4, (int) Math.min((long) i5, j4));
            if (read != -1) {
                this.f11337a -= (long) read;
            }
            return read;
        }
    }
}
