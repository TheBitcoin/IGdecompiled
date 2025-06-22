package N3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.m;

public final class S implements C2515f, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    public final X f23642a;

    /* renamed from: b  reason: collision with root package name */
    public final C2514e f23643b = new C2514e();

    /* renamed from: c  reason: collision with root package name */
    public boolean f23644c;

    public S(X x4) {
        m.e(x4, "sink");
        this.f23642a = x4;
    }

    public C2514e buffer() {
        return this.f23643b;
    }

    public void close() {
        if (!this.f23644c) {
            try {
                if (this.f23643b.A() > 0) {
                    X x4 = this.f23642a;
                    C2514e eVar = this.f23643b;
                    x4.m(eVar, eVar.A());
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f23642a.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.f23644c = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public C2515f emitCompleteSegments() {
        if (!this.f23644c) {
            long g4 = this.f23643b.g();
            if (g4 > 0) {
                this.f23642a.m(this.f23643b, g4);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void flush() {
        if (!this.f23644c) {
            if (this.f23643b.A() > 0) {
                X x4 = this.f23642a;
                C2514e eVar = this.f23643b;
                x4.m(eVar, eVar.A());
            }
            this.f23642a.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f23644c;
    }

    public void m(C2514e eVar, long j4) {
        m.e(eVar, "source");
        if (!this.f23644c) {
            this.f23643b.m(eVar, j4);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public OutputStream outputStream() {
        return new a(this);
    }

    public a0 timeout() {
        return this.f23642a.timeout();
    }

    public String toString() {
        return "buffer(" + this.f23642a + ')';
    }

    public int write(ByteBuffer byteBuffer) {
        m.e(byteBuffer, "source");
        if (!this.f23644c) {
            int write = this.f23643b.write(byteBuffer);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    public C2515f writeByte(int i4) {
        if (!this.f23644c) {
            this.f23643b.writeByte(i4);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public C2515f writeDecimalLong(long j4) {
        if (!this.f23644c) {
            this.f23643b.writeDecimalLong(j4);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public C2515f writeHexadecimalUnsignedLong(long j4) {
        if (!this.f23644c) {
            this.f23643b.writeHexadecimalUnsignedLong(j4);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public C2515f writeInt(int i4) {
        if (!this.f23644c) {
            this.f23643b.writeInt(i4);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public C2515f writeShort(int i4) {
        if (!this.f23644c) {
            this.f23643b.writeShort(i4);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public C2515f writeUtf8(String str) {
        m.e(str, TypedValues.Custom.S_STRING);
        if (!this.f23644c) {
            this.f23643b.writeUtf8(str);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public static final class a extends OutputStream implements AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ S f23645a;

        a(S s4) {
            this.f23645a = s4;
        }

        public void close() {
            this.f23645a.close();
        }

        public void flush() {
            S s4 = this.f23645a;
            if (!s4.f23644c) {
                s4.flush();
            }
        }

        public String toString() {
            return this.f23645a + ".outputStream()";
        }

        public void write(int i4) {
            S s4 = this.f23645a;
            if (!s4.f23644c) {
                s4.f23643b.writeByte((byte) i4);
                this.f23645a.emitCompleteSegments();
                return;
            }
            throw new IOException("closed");
        }

        public void write(byte[] bArr, int i4, int i5) {
            m.e(bArr, DataSchemeDataSource.SCHEME_DATA);
            S s4 = this.f23645a;
            if (!s4.f23644c) {
                s4.f23643b.write(bArr, i4, i5);
                this.f23645a.emitCompleteSegments();
                return;
            }
            throw new IOException("closed");
        }
    }

    public C2515f write(byte[] bArr) {
        m.e(bArr, "source");
        if (!this.f23644c) {
            this.f23643b.write(bArr);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public C2515f write(byte[] bArr, int i4, int i5) {
        m.e(bArr, "source");
        if (!this.f23644c) {
            this.f23643b.write(bArr, i4, i5);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
}
