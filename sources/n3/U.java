package N3;

import S2.C1594h;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class U {

    /* renamed from: h  reason: collision with root package name */
    public static final a f23650h = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f23651a;

    /* renamed from: b  reason: collision with root package name */
    public int f23652b;

    /* renamed from: c  reason: collision with root package name */
    public int f23653c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23654d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23655e;

    /* renamed from: f  reason: collision with root package name */
    public U f23656f;

    /* renamed from: g  reason: collision with root package name */
    public U f23657g;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public U() {
        this.f23651a = new byte[8192];
        this.f23655e = true;
        this.f23654d = false;
    }

    public final void a() {
        int i4;
        U u4 = this.f23657g;
        if (u4 != this) {
            m.b(u4);
            if (u4.f23655e) {
                int i5 = this.f23653c - this.f23652b;
                U u5 = this.f23657g;
                m.b(u5);
                int i6 = 8192 - u5.f23653c;
                U u6 = this.f23657g;
                m.b(u6);
                if (u6.f23654d) {
                    i4 = 0;
                } else {
                    U u7 = this.f23657g;
                    m.b(u7);
                    i4 = u7.f23652b;
                }
                if (i5 <= i6 + i4) {
                    U u8 = this.f23657g;
                    m.b(u8);
                    f(u8, i5);
                    b();
                    V.b(this);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("cannot compact");
    }

    public final U b() {
        U u4 = this.f23656f;
        if (u4 == this) {
            u4 = null;
        }
        U u5 = this.f23657g;
        m.b(u5);
        u5.f23656f = this.f23656f;
        U u6 = this.f23656f;
        m.b(u6);
        u6.f23657g = this.f23657g;
        this.f23656f = null;
        this.f23657g = null;
        return u4;
    }

    public final U c(U u4) {
        m.e(u4, "segment");
        u4.f23657g = this;
        u4.f23656f = this.f23656f;
        U u5 = this.f23656f;
        m.b(u5);
        u5.f23657g = u4;
        this.f23656f = u4;
        return u4;
    }

    public final U d() {
        this.f23654d = true;
        return new U(this.f23651a, this.f23652b, this.f23653c, true, false);
    }

    public final U e(int i4) {
        U u4;
        if (i4 <= 0 || i4 > this.f23653c - this.f23652b) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i4 >= 1024) {
            u4 = d();
        } else {
            u4 = V.c();
            byte[] bArr = this.f23651a;
            byte[] bArr2 = u4.f23651a;
            int i5 = this.f23652b;
            C1594h.f(bArr, bArr2, 0, i5, i5 + i4, 2, (Object) null);
        }
        u4.f23653c = u4.f23652b + i4;
        this.f23652b += i4;
        U u5 = this.f23657g;
        m.b(u5);
        u5.c(u4);
        return u4;
    }

    public final void f(U u4, int i4) {
        m.e(u4, "sink");
        if (u4.f23655e) {
            int i5 = u4.f23653c;
            if (i5 + i4 > 8192) {
                if (!u4.f23654d) {
                    int i6 = u4.f23652b;
                    if ((i5 + i4) - i6 <= 8192) {
                        byte[] bArr = u4.f23651a;
                        C1594h.f(bArr, bArr, 0, i6, i5, 2, (Object) null);
                        u4.f23653c -= u4.f23652b;
                        u4.f23652b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.f23651a;
            byte[] bArr3 = u4.f23651a;
            int i7 = u4.f23653c;
            int i8 = this.f23652b;
            C1594h.d(bArr2, bArr3, i7, i8, i8 + i4);
            u4.f23653c += i4;
            this.f23652b += i4;
            return;
        }
        throw new IllegalStateException("only owner can write");
    }

    public U(byte[] bArr, int i4, int i5, boolean z4, boolean z5) {
        m.e(bArr, DataSchemeDataSource.SCHEME_DATA);
        this.f23651a = bArr;
        this.f23652b = i4;
        this.f23653c = i5;
        this.f23654d = z4;
        this.f23655e = z5;
    }
}
