package N0;

import K0.C1493b;
import K0.C1494c;
import K0.C1495d;
import K0.C1496e;
import K0.C1497f;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;

final class f implements C1496e {

    /* renamed from: f  reason: collision with root package name */
    private static final Charset f7755f = Charset.forName(C.UTF8_NAME);

    /* renamed from: g  reason: collision with root package name */
    private static final C1494c f7756g = C1494c.a(LeanbackPreferenceDialogFragment.ARG_KEY).b(a.b().c(1).a()).a();

    /* renamed from: h  reason: collision with root package name */
    private static final C1494c f7757h = C1494c.a("value").b(a.b().c(2).a()).a();

    /* renamed from: i  reason: collision with root package name */
    private static final C1495d f7758i = new e();

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f7759a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f7760b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f7761c;

    /* renamed from: d  reason: collision with root package name */
    private final C1495d f7762d;

    /* renamed from: e  reason: collision with root package name */
    private final i f7763e = new i(this);

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7764a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                N0.d$a[] r0 = N0.d.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7764a = r0
                N0.d$a r1 = N0.d.a.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7764a     // Catch:{ NoSuchFieldError -> 0x001d }
                N0.d$a r1 = N0.d.a.SIGNED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7764a     // Catch:{ NoSuchFieldError -> 0x0028 }
                N0.d$a r1 = N0.d.a.FIXED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: N0.f.a.<clinit>():void");
        }
    }

    f(OutputStream outputStream, Map map, Map map2, C1495d dVar) {
        this.f7759a = outputStream;
        this.f7760b = map;
        this.f7761c = map2;
        this.f7762d = dVar;
    }

    public static /* synthetic */ void b(Map.Entry entry, C1496e eVar) {
        eVar.a(f7756g, entry.getKey());
        eVar.a(f7757h, entry.getValue());
    }

    private static ByteBuffer p(int i4) {
        return ByteBuffer.allocate(i4).order(ByteOrder.LITTLE_ENDIAN);
    }

    private long q(C1495d dVar, Object obj) {
        OutputStream outputStream;
        b bVar = new b();
        try {
            outputStream = this.f7759a;
            this.f7759a = bVar;
            dVar.a(obj, this);
            this.f7759a = outputStream;
            long a5 = bVar.a();
            bVar.close();
            return a5;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private f r(C1495d dVar, C1494c cVar, Object obj, boolean z4) {
        long q4 = q(dVar, obj);
        if (z4 && q4 == 0) {
            return this;
        }
        w((v(cVar) << 3) | 2);
        x(q4);
        dVar.a(obj, this);
        return this;
    }

    private f s(C1497f fVar, C1494c cVar, Object obj, boolean z4) {
        this.f7763e.c(cVar, z4);
        fVar.a(obj, this.f7763e);
        return this;
    }

    private static d u(C1494c cVar) {
        d dVar = (d) cVar.c(d.class);
        if (dVar != null) {
            return dVar;
        }
        throw new C1493b("Field has no @Protobuf config");
    }

    private static int v(C1494c cVar) {
        d dVar = (d) cVar.c(d.class);
        if (dVar != null) {
            return dVar.tag();
        }
        throw new C1493b("Field has no @Protobuf config");
    }

    private void w(int i4) {
        while (((long) (i4 & -128)) != 0) {
            this.f7759a.write((i4 & ModuleDescriptor.MODULE_VERSION) | 128);
            i4 >>>= 7;
        }
        this.f7759a.write(i4 & ModuleDescriptor.MODULE_VERSION);
    }

    private void x(long j4) {
        while ((-128 & j4) != 0) {
            this.f7759a.write((((int) j4) & ModuleDescriptor.MODULE_VERSION) | 128);
            j4 >>>= 7;
        }
        this.f7759a.write(((int) j4) & ModuleDescriptor.MODULE_VERSION);
    }

    public C1496e a(C1494c cVar, Object obj) {
        return i(cVar, obj, true);
    }

    public C1496e e(C1494c cVar, double d5) {
        return f(cVar, d5, true);
    }

    /* access modifiers changed from: package-private */
    public C1496e f(C1494c cVar, double d5, boolean z4) {
        if (z4 && d5 == 0.0d) {
            return this;
        }
        w((v(cVar) << 3) | 1);
        this.f7759a.write(p(8).putDouble(d5).array());
        return this;
    }

    /* access modifiers changed from: package-private */
    public C1496e h(C1494c cVar, float f4, boolean z4) {
        if (z4 && f4 == 0.0f) {
            return this;
        }
        w((v(cVar) << 3) | 5);
        this.f7759a.write(p(4).putFloat(f4).array());
        return this;
    }

    /* access modifiers changed from: package-private */
    public C1496e i(C1494c cVar, Object obj, boolean z4) {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (!z4 || charSequence.length() != 0) {
                    w((v(cVar) << 3) | 2);
                    byte[] bytes = charSequence.toString().getBytes(f7755f);
                    w(bytes.length);
                    this.f7759a.write(bytes);
                    return this;
                }
            } else if (obj instanceof Collection) {
                for (Object i4 : (Collection) obj) {
                    i(cVar, i4, false);
                }
            } else if (obj instanceof Map) {
                for (Map.Entry r4 : ((Map) obj).entrySet()) {
                    r(f7758i, cVar, r4, false);
                }
            } else if (obj instanceof Double) {
                return f(cVar, ((Double) obj).doubleValue(), z4);
            } else {
                if (obj instanceof Float) {
                    return h(cVar, ((Float) obj).floatValue(), z4);
                }
                if (obj instanceof Number) {
                    return m(cVar, ((Number) obj).longValue(), z4);
                }
                if (obj instanceof Boolean) {
                    return o(cVar, ((Boolean) obj).booleanValue(), z4);
                }
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    if (!z4 || bArr.length != 0) {
                        w((v(cVar) << 3) | 2);
                        w(bArr.length);
                        this.f7759a.write(bArr);
                        return this;
                    }
                } else {
                    C1495d dVar = (C1495d) this.f7760b.get(obj.getClass());
                    if (dVar != null) {
                        return r(dVar, cVar, obj, z4);
                    }
                    C1497f fVar = (C1497f) this.f7761c.get(obj.getClass());
                    if (fVar != null) {
                        return s(fVar, cVar, obj, z4);
                    }
                    if (obj instanceof c) {
                        return d(cVar, ((c) obj).getNumber());
                    }
                    if (obj instanceof Enum) {
                        return d(cVar, ((Enum) obj).ordinal());
                    }
                    return r(this.f7762d, cVar, obj, z4);
                }
            }
        }
        return this;
    }

    /* renamed from: j */
    public f d(C1494c cVar, int i4) {
        return k(cVar, i4, true);
    }

    /* access modifiers changed from: package-private */
    public f k(C1494c cVar, int i4, boolean z4) {
        if (!z4 || i4 != 0) {
            d u4 = u(cVar);
            int i5 = a.f7764a[u4.intEncoding().ordinal()];
            if (i5 == 1) {
                w(u4.tag() << 3);
                w(i4);
                return this;
            } else if (i5 == 2) {
                w(u4.tag() << 3);
                w((i4 << 1) ^ (i4 >> 31));
                return this;
            } else if (i5 == 3) {
                w((u4.tag() << 3) | 5);
                this.f7759a.write(p(4).putInt(i4).array());
                return this;
            }
        }
        return this;
    }

    /* renamed from: l */
    public f c(C1494c cVar, long j4) {
        return m(cVar, j4, true);
    }

    /* access modifiers changed from: package-private */
    public f m(C1494c cVar, long j4, boolean z4) {
        if (!z4 || j4 != 0) {
            d u4 = u(cVar);
            int i4 = a.f7764a[u4.intEncoding().ordinal()];
            if (i4 == 1) {
                w(u4.tag() << 3);
                x(j4);
                return this;
            } else if (i4 == 2) {
                w(u4.tag() << 3);
                x((j4 >> 63) ^ (j4 << 1));
                return this;
            } else if (i4 == 3) {
                w((u4.tag() << 3) | 1);
                this.f7759a.write(p(8).putLong(j4).array());
                return this;
            }
        }
        return this;
    }

    /* renamed from: n */
    public f g(C1494c cVar, boolean z4) {
        return o(cVar, z4, true);
    }

    /* access modifiers changed from: package-private */
    public f o(C1494c cVar, boolean z4, boolean z5) {
        return k(cVar, z4 ? 1 : 0, z5);
    }

    /* access modifiers changed from: package-private */
    public f t(Object obj) {
        if (obj == null) {
            return this;
        }
        C1495d dVar = (C1495d) this.f7760b.get(obj.getClass());
        if (dVar != null) {
            dVar.a(obj, this);
            return this;
        }
        throw new C1493b("No encoder for " + obj.getClass());
    }
}
