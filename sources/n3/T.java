package N3;

import O3.C2535a;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.m;

public final class T implements C2516g, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    public final Z f23646a;

    /* renamed from: b  reason: collision with root package name */
    public final C2514e f23647b = new C2514e();

    /* renamed from: c  reason: collision with root package name */
    public boolean f23648c;

    public T(Z z4) {
        m.e(z4, "source");
        this.f23646a = z4;
    }

    public boolean a(long j4, C2517h hVar, int i4, int i5) {
        m.e(hVar, "bytes");
        if (this.f23648c) {
            throw new IllegalStateException("closed");
        } else if (j4 < 0 || i4 < 0 || i5 < 0 || hVar.G() - i4 < i5) {
            return false;
        } else {
            for (int i6 = 0; i6 < i5; i6++) {
                long j5 = ((long) i6) + j4;
                if (!request(1 + j5) || this.f23647b.n(j5) != hVar.h(i4 + i6)) {
                    return false;
                }
            }
            return true;
        }
    }

    public C2514e buffer() {
        return this.f23647b;
    }

    public void close() {
        if (!this.f23648c) {
            this.f23648c = true;
            this.f23646a.close();
            this.f23647b.a();
        }
    }

    public long e(C2514e eVar, long j4) {
        m.e(eVar, "sink");
        if (j4 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        } else if (this.f23648c) {
            throw new IllegalStateException("closed");
        } else if (this.f23647b.A() == 0 && this.f23646a.e(this.f23647b, 8192) == -1) {
            return -1;
        } else {
            return this.f23647b.e(eVar, Math.min(j4, this.f23647b.A()));
        }
    }

    public boolean exhausted() {
        if (this.f23648c) {
            throw new IllegalStateException("closed");
        } else if (!this.f23647b.exhausted() || this.f23646a.e(this.f23647b, 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    public C2514e h() {
        return this.f23647b;
    }

    public long indexOf(byte b5) {
        return indexOf(b5, 0, Long.MAX_VALUE);
    }

    public InputStream inputStream() {
        return new a(this);
    }

    public boolean isOpen() {
        return !this.f23648c;
    }

    public int read(ByteBuffer byteBuffer) {
        m.e(byteBuffer, "sink");
        if (this.f23647b.A() == 0 && this.f23646a.e(this.f23647b, 8192) == -1) {
            return -1;
        }
        return this.f23647b.read(byteBuffer);
    }

    public byte readByte() {
        require(1);
        return this.f23647b.readByte();
    }

    public byte[] readByteArray() {
        this.f23647b.J(this.f23646a);
        return this.f23647b.readByteArray();
    }

    public C2517h readByteString(long j4) {
        require(j4);
        return this.f23647b.readByteString(j4);
    }

    public long readDecimalLong() {
        int i4;
        require(1);
        long j4 = 0;
        while (true) {
            long j5 = j4 + 1;
            if (!request(j5)) {
                break;
            }
            byte n4 = this.f23647b.n(j4);
            if ((n4 >= 48 && n4 <= 57) || (j4 == 0 && n4 == 45)) {
                j4 = j5;
            } else if (i4 == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected a digit or '-' but was 0x");
                String num = Integer.toString(n4, m3.a.a(m3.a.a(16)));
                m.d(num, "toString(this, checkRadix(radix))");
                sb.append(num);
                throw new NumberFormatException(sb.toString());
            }
        }
        return this.f23647b.readDecimalLong();
    }

    public void readFully(byte[] bArr) {
        m.e(bArr, "sink");
        try {
            require((long) bArr.length);
            this.f23647b.readFully(bArr);
        } catch (EOFException e5) {
            int i4 = 0;
            while (this.f23647b.A() > 0) {
                C2514e eVar = this.f23647b;
                int read = eVar.read(bArr, i4, (int) eVar.A());
                if (read != -1) {
                    i4 += read;
                } else {
                    throw new AssertionError();
                }
            }
            throw e5;
        }
    }

    public long readHexadecimalUnsignedLong() {
        require(1);
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            if (!request((long) i5)) {
                break;
            }
            byte n4 = this.f23647b.n((long) i4);
            if ((n4 >= 48 && n4 <= 57) || ((n4 >= 97 && n4 <= 102) || (n4 >= 65 && n4 <= 70))) {
                i4 = i5;
            } else if (i4 == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected leading [0-9a-fA-F] character but was 0x");
                String num = Integer.toString(n4, m3.a.a(m3.a.a(16)));
                m.d(num, "toString(this, checkRadix(radix))");
                sb.append(num);
                throw new NumberFormatException(sb.toString());
            }
        }
        return this.f23647b.readHexadecimalUnsignedLong();
    }

    public int readInt() {
        require(4);
        return this.f23647b.readInt();
    }

    public int readIntLe() {
        require(4);
        return this.f23647b.readIntLe();
    }

    public long readLongLe() {
        require(8);
        return this.f23647b.readLongLe();
    }

    public short readShort() {
        require(2);
        return this.f23647b.readShort();
    }

    public short readShortLe() {
        require(2);
        return this.f23647b.readShortLe();
    }

    public String readUtf8(long j4) {
        require(j4);
        return this.f23647b.readUtf8(j4);
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public boolean request(long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        } else if (!this.f23648c) {
            while (this.f23647b.A() < j4) {
                if (this.f23646a.e(this.f23647b, 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void require(long j4) {
        if (!request(j4)) {
            throw new EOFException();
        }
    }

    public boolean s(long j4, C2517h hVar) {
        m.e(hVar, "bytes");
        return a(j4, hVar, 0, hVar.G());
    }

    public void skip(long j4) {
        if (!this.f23648c) {
            while (j4 > 0) {
                if (this.f23647b.A() == 0 && this.f23646a.e(this.f23647b, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j4, this.f23647b.A());
                this.f23647b.skip(min);
                j4 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public a0 timeout() {
        return this.f23646a.timeout();
    }

    public String toString() {
        return "buffer(" + this.f23646a + ')';
    }

    public long indexOf(byte b5, long j4, long j5) {
        if (this.f23648c) {
            throw new IllegalStateException("closed");
        } else if (0 > j4 || j4 > j5) {
            throw new IllegalArgumentException(("fromIndex=" + j4 + " toIndex=" + j5).toString());
        } else {
            long j6 = j4;
            while (j6 < j5) {
                byte b6 = b5;
                long j7 = j5;
                long indexOf = this.f23647b.indexOf(b6, j6, j7);
                if (indexOf == -1) {
                    long A4 = this.f23647b.A();
                    if (A4 >= j7 || this.f23646a.e(this.f23647b, 8192) == -1) {
                        break;
                    }
                    j6 = Math.max(j6, A4);
                    b5 = b6;
                    j5 = j7;
                } else {
                    return indexOf;
                }
            }
            return -1;
        }
    }

    public String readUtf8LineStrict(long j4) {
        if (j4 >= 0) {
            long j5 = j4 == Long.MAX_VALUE ? Long.MAX_VALUE : j4 + 1;
            long indexOf = indexOf((byte) 10, 0, j5);
            if (indexOf != -1) {
                return C2535a.b(this.f23647b, indexOf);
            }
            if (j5 < Long.MAX_VALUE && request(j5) && this.f23647b.n(j5 - 1) == 13 && request(1 + j5) && this.f23647b.n(j5) == 10) {
                return C2535a.b(this.f23647b, j5);
            }
            C2514e eVar = new C2514e();
            C2514e eVar2 = this.f23647b;
            eVar2.k(eVar, 0, Math.min((long) 32, eVar2.A()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f23647b.A(), j4) + " content=" + eVar.x().m() + 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j4).toString());
    }

    public byte[] readByteArray(long j4) {
        require(j4);
        return this.f23647b.readByteArray(j4);
    }

    public static final class a extends InputStream implements AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ T f23649a;

        a(T t4) {
            this.f23649a = t4;
        }

        public int available() {
            T t4 = this.f23649a;
            if (!t4.f23648c) {
                return (int) Math.min(t4.f23647b.A(), (long) Integer.MAX_VALUE);
            }
            throw new IOException("closed");
        }

        public void close() {
            this.f23649a.close();
        }

        public int read() {
            T t4 = this.f23649a;
            if (!t4.f23648c) {
                if (t4.f23647b.A() == 0) {
                    T t5 = this.f23649a;
                    if (t5.f23646a.e(t5.f23647b, 8192) == -1) {
                        return -1;
                    }
                }
                return this.f23649a.f23647b.readByte() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return this.f23649a + ".inputStream()";
        }

        public int read(byte[] bArr, int i4, int i5) {
            m.e(bArr, DataSchemeDataSource.SCHEME_DATA);
            if (!this.f23649a.f23648c) {
                C2511b.b((long) bArr.length, (long) i4, (long) i5);
                if (this.f23649a.f23647b.A() == 0) {
                    T t4 = this.f23649a;
                    if (t4.f23646a.e(t4.f23647b, 8192) == -1) {
                        return -1;
                    }
                }
                return this.f23649a.f23647b.read(bArr, i4, i5);
            }
            throw new IOException("closed");
        }
    }
}
