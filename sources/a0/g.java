package A0;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

class g implements Closeable, AutoCloseable {

    /* renamed from: g  reason: collision with root package name */
    private static final Logger f5705g = Logger.getLogger(g.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RandomAccessFile f5706a;

    /* renamed from: b  reason: collision with root package name */
    int f5707b;

    /* renamed from: c  reason: collision with root package name */
    private int f5708c;

    /* renamed from: d  reason: collision with root package name */
    private b f5709d;

    /* renamed from: e  reason: collision with root package name */
    private b f5710e;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f5711f = new byte[16];

    class a implements d {

        /* renamed from: a  reason: collision with root package name */
        boolean f5712a = true;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ StringBuilder f5713b;

        a(StringBuilder sb) {
            this.f5713b = sb;
        }

        public void a(InputStream inputStream, int i4) {
            if (this.f5712a) {
                this.f5712a = false;
            } else {
                this.f5713b.append(", ");
            }
            this.f5713b.append(i4);
        }
    }

    static class b {

        /* renamed from: c  reason: collision with root package name */
        static final b f5715c = new b(0, 0);

        /* renamed from: a  reason: collision with root package name */
        final int f5716a;

        /* renamed from: b  reason: collision with root package name */
        final int f5717b;

        b(int i4, int i5) {
            this.f5716a = i4;
            this.f5717b = i5;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f5716a + ", length = " + this.f5717b + "]";
        }
    }

    private final class c extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        private int f5718a;

        /* renamed from: b  reason: collision with root package name */
        private int f5719b;

        /* synthetic */ c(g gVar, b bVar, a aVar) {
            this(bVar);
        }

        public int read(byte[] bArr, int i4, int i5) {
            Object unused = g.v(bArr, "buffer");
            if ((i4 | i5) < 0 || i5 > bArr.length - i4) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i6 = this.f5719b;
            if (i6 <= 0) {
                return -1;
            }
            if (i5 > i6) {
                i5 = i6;
            }
            g.this.F(this.f5718a, bArr, i4, i5);
            this.f5718a = g.this.J(this.f5718a + i5);
            this.f5719b -= i5;
            return i5;
        }

        private c(b bVar) {
            this.f5718a = g.this.J(bVar.f5716a + 4);
            this.f5719b = bVar.f5717b;
        }

        public int read() {
            if (this.f5719b == 0) {
                return -1;
            }
            g.this.f5706a.seek((long) this.f5718a);
            int read = g.this.f5706a.read();
            this.f5718a = g.this.J(this.f5718a + 1);
            this.f5719b--;
            return read;
        }
    }

    public interface d {
        void a(InputStream inputStream, int i4);
    }

    public g(File file) {
        if (!file.exists()) {
            r(file);
        }
        this.f5706a = w(file);
        z();
    }

    private static int A(byte[] bArr, int i4) {
        return ((bArr[i4] & 255) << 24) + ((bArr[i4 + 1] & 255) << 16) + ((bArr[i4 + 2] & 255) << 8) + (bArr[i4 + 3] & 255);
    }

    private int D() {
        return this.f5707b - I();
    }

    /* access modifiers changed from: private */
    public void F(int i4, byte[] bArr, int i5, int i6) {
        int J4 = J(i4);
        int i7 = J4 + i6;
        int i8 = this.f5707b;
        if (i7 <= i8) {
            this.f5706a.seek((long) J4);
            this.f5706a.readFully(bArr, i5, i6);
            return;
        }
        int i9 = i8 - J4;
        this.f5706a.seek((long) J4);
        this.f5706a.readFully(bArr, i5, i9);
        this.f5706a.seek(16);
        this.f5706a.readFully(bArr, i5 + i9, i6 - i9);
    }

    private void G(int i4, byte[] bArr, int i5, int i6) {
        int J4 = J(i4);
        int i7 = J4 + i6;
        int i8 = this.f5707b;
        if (i7 <= i8) {
            this.f5706a.seek((long) J4);
            this.f5706a.write(bArr, i5, i6);
            return;
        }
        int i9 = i8 - J4;
        this.f5706a.seek((long) J4);
        this.f5706a.write(bArr, i5, i9);
        this.f5706a.seek(16);
        this.f5706a.write(bArr, i5 + i9, i6 - i9);
    }

    private void H(int i4) {
        this.f5706a.setLength((long) i4);
        this.f5706a.getChannel().force(true);
    }

    /* access modifiers changed from: private */
    public int J(int i4) {
        int i5 = this.f5707b;
        if (i4 < i5) {
            return i4;
        }
        return (i4 + 16) - i5;
    }

    private void K(int i4, int i5, int i6, int i7) {
        M(this.f5711f, i4, i5, i6, i7);
        this.f5706a.seek(0);
        this.f5706a.write(this.f5711f);
    }

    private static void L(byte[] bArr, int i4, int i5) {
        bArr[i4] = (byte) (i5 >> 24);
        bArr[i4 + 1] = (byte) (i5 >> 16);
        bArr[i4 + 2] = (byte) (i5 >> 8);
        bArr[i4 + 3] = (byte) i5;
    }

    private static void M(byte[] bArr, int... iArr) {
        int i4 = 0;
        for (int L4 : iArr) {
            L(bArr, i4, L4);
            i4 += 4;
        }
    }

    private void o(int i4) {
        int i5 = i4 + 4;
        int D4 = D();
        if (D4 < i5) {
            int i6 = this.f5707b;
            do {
                D4 += i6;
                i6 <<= 1;
            } while (D4 < i5);
            H(i6);
            b bVar = this.f5710e;
            int J4 = J(bVar.f5716a + 4 + bVar.f5717b);
            if (J4 < this.f5709d.f5716a) {
                FileChannel channel = this.f5706a.getChannel();
                channel.position((long) this.f5707b);
                long j4 = (long) (J4 - 4);
                if (channel.transferTo(16, j4, channel) != j4) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            int i7 = this.f5710e.f5716a;
            int i8 = this.f5709d.f5716a;
            if (i7 < i8) {
                int i9 = (this.f5707b + i7) - 16;
                K(i6, this.f5708c, i8, i9);
                this.f5710e = new b(i9, this.f5710e.f5717b);
            } else {
                K(i6, this.f5708c, i8, i7);
            }
            this.f5707b = i6;
        }
    }

    /* JADX INFO: finally extract failed */
    private static void r(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile w4 = w(file2);
        try {
            w4.setLength(4096);
            w4.seek(0);
            byte[] bArr = new byte[16];
            M(bArr, 4096, 0, 0, 0);
            w4.write(bArr);
            w4.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            w4.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static Object v(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    private static RandomAccessFile w(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private b x(int i4) {
        if (i4 == 0) {
            return b.f5715c;
        }
        this.f5706a.seek((long) i4);
        return new b(i4, this.f5706a.readInt());
    }

    private void z() {
        this.f5706a.seek(0);
        this.f5706a.readFully(this.f5711f);
        int A4 = A(this.f5711f, 0);
        this.f5707b = A4;
        if (((long) A4) <= this.f5706a.length()) {
            this.f5708c = A(this.f5711f, 4);
            int A5 = A(this.f5711f, 8);
            int A6 = A(this.f5711f, 12);
            this.f5709d = x(A5);
            this.f5710e = x(A6);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f5707b + ", Actual length: " + this.f5706a.length());
    }

    public synchronized void E() {
        try {
            if (u()) {
                throw new NoSuchElementException();
            } else if (this.f5708c == 1) {
                n();
            } else {
                b bVar = this.f5709d;
                int J4 = J(bVar.f5716a + 4 + bVar.f5717b);
                F(J4, this.f5711f, 0, 4);
                int A4 = A(this.f5711f, 0);
                K(this.f5707b, this.f5708c - 1, J4, this.f5710e.f5716a);
                this.f5708c--;
                this.f5709d = new b(J4, A4);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public int I() {
        if (this.f5708c == 0) {
            return 16;
        }
        b bVar = this.f5710e;
        int i4 = bVar.f5716a;
        int i5 = this.f5709d.f5716a;
        if (i4 >= i5) {
            return (i4 - i5) + 4 + bVar.f5717b + 16;
        }
        return (((i4 + 4) + bVar.f5717b) + this.f5707b) - i5;
    }

    public synchronized void close() {
        this.f5706a.close();
    }

    public void k(byte[] bArr) {
        l(bArr, 0, bArr.length);
    }

    public synchronized void l(byte[] bArr, int i4, int i5) {
        int i6;
        int i7;
        try {
            v(bArr, "buffer");
            if ((i4 | i5) < 0 || i5 > bArr.length - i4) {
                throw new IndexOutOfBoundsException();
            }
            o(i5);
            boolean u4 = u();
            if (u4) {
                i6 = 16;
            } else {
                b bVar = this.f5710e;
                i6 = J(bVar.f5716a + 4 + bVar.f5717b);
            }
            b bVar2 = new b(i6, i5);
            L(this.f5711f, 0, i5);
            G(bVar2.f5716a, this.f5711f, 0, 4);
            G(bVar2.f5716a + 4, bArr, i4, i5);
            if (u4) {
                i7 = bVar2.f5716a;
            } else {
                i7 = this.f5709d.f5716a;
            }
            K(this.f5707b, this.f5708c + 1, i7, bVar2.f5716a);
            this.f5710e = bVar2;
            this.f5708c++;
            if (u4) {
                this.f5709d = bVar2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void n() {
        try {
            K(4096, 0, 0, 0);
            this.f5708c = 0;
            b bVar = b.f5715c;
            this.f5709d = bVar;
            this.f5710e = bVar;
            if (this.f5707b > 4096) {
                H(4096);
            }
            this.f5707b = 4096;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized void p(d dVar) {
        int i4 = this.f5709d.f5716a;
        for (int i5 = 0; i5 < this.f5708c; i5++) {
            b x4 = x(i4);
            dVar.a(new c(this, x4, (a) null), x4.f5717b);
            i4 = J(x4.f5716a + 4 + x4.f5717b);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f5707b);
        sb.append(", size=");
        sb.append(this.f5708c);
        sb.append(", first=");
        sb.append(this.f5709d);
        sb.append(", last=");
        sb.append(this.f5710e);
        sb.append(", element lengths=[");
        try {
            p(new a(sb));
        } catch (IOException e5) {
            f5705g.log(Level.WARNING, "read error", e5);
        }
        sb.append("]]");
        return sb.toString();
    }

    public synchronized boolean u() {
        boolean z4;
        if (this.f5708c == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        return z4;
    }
}
