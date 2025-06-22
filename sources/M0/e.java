package M0;

import K0.C1493b;
import K0.C1494c;
import K0.C1495d;
import K0.C1496e;
import K0.C1497f;
import K0.C1498g;
import android.util.Base64;
import android.util.JsonWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

final class e implements C1496e, C1498g {

    /* renamed from: a  reason: collision with root package name */
    private e f7393a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7394b = true;

    /* renamed from: c  reason: collision with root package name */
    private final JsonWriter f7395c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f7396d;

    /* renamed from: e  reason: collision with root package name */
    private final Map f7397e;

    /* renamed from: f  reason: collision with root package name */
    private final C1495d f7398f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f7399g;

    e(Writer writer, Map map, Map map2, C1495d dVar, boolean z4) {
        this.f7395c = new JsonWriter(writer);
        this.f7396d = map;
        this.f7397e = map2;
        this.f7398f = dVar;
        this.f7399g = z4;
    }

    private boolean t(Object obj) {
        if (obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number)) {
            return true;
        }
        return false;
    }

    private e w(String str, Object obj) {
        y();
        this.f7395c.name(str);
        if (obj != null) {
            return k(obj, false);
        }
        this.f7395c.nullValue();
        return this;
    }

    private e x(String str, Object obj) {
        if (obj == null) {
            return this;
        }
        y();
        this.f7395c.name(str);
        return k(obj, false);
    }

    private void y() {
        if (this.f7394b) {
            e eVar = this.f7393a;
            if (eVar != null) {
                eVar.y();
                this.f7393a.f7394b = false;
                this.f7393a = null;
                this.f7395c.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    public C1496e a(C1494c cVar, Object obj) {
        return p(cVar.b(), obj);
    }

    public C1496e c(C1494c cVar, long j4) {
        return o(cVar.b(), j4);
    }

    public C1496e d(C1494c cVar, int i4) {
        return n(cVar.b(), i4);
    }

    public C1496e e(C1494c cVar, double d5) {
        return m(cVar.b(), d5);
    }

    public C1496e g(C1494c cVar, boolean z4) {
        return q(cVar.b(), z4);
    }

    public e h(double d5) {
        y();
        this.f7395c.value(d5);
        return this;
    }

    public e i(int i4) {
        y();
        this.f7395c.value((long) i4);
        return this;
    }

    public e j(long j4) {
        y();
        this.f7395c.value(j4);
        return this;
    }

    /* access modifiers changed from: package-private */
    public e k(Object obj, boolean z4) {
        Class<?> cls;
        int i4 = 0;
        if (z4 && t(obj)) {
            if (obj == null) {
                cls = null;
            } else {
                cls = obj.getClass();
            }
            throw new C1493b(String.format("%s cannot be encoded inline", new Object[]{cls}));
        } else if (obj == null) {
            this.f7395c.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.f7395c.value((Number) obj);
            return this;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                return s((byte[]) obj);
            }
            this.f7395c.beginArray();
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length = iArr.length;
                while (i4 < length) {
                    this.f7395c.value((long) iArr[i4]);
                    i4++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i4 < length2) {
                    j(jArr[i4]);
                    i4++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i4 < length3) {
                    this.f7395c.value(dArr[i4]);
                    i4++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i4 < length4) {
                    this.f7395c.value(zArr[i4]);
                    i4++;
                }
            } else if (obj instanceof Number[]) {
                for (Number k4 : (Number[]) obj) {
                    k(k4, false);
                }
            } else {
                for (Object k5 : (Object[]) obj) {
                    k(k5, false);
                }
            }
            this.f7395c.endArray();
            return this;
        } else if (obj instanceof Collection) {
            this.f7395c.beginArray();
            for (Object k6 : (Collection) obj) {
                k(k6, false);
            }
            this.f7395c.endArray();
            return this;
        } else if (obj instanceof Map) {
            this.f7395c.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    p((String) key, entry.getValue());
                } catch (ClassCastException e5) {
                    throw new C1493b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", new Object[]{key, key.getClass()}), e5);
                }
            }
            this.f7395c.endObject();
            return this;
        } else {
            C1495d dVar = (C1495d) this.f7396d.get(obj.getClass());
            if (dVar != null) {
                return v(dVar, obj, z4);
            }
            C1497f fVar = (C1497f) this.f7397e.get(obj.getClass());
            if (fVar != null) {
                fVar.a(obj, this);
                return this;
            } else if (!(obj instanceof Enum)) {
                return v(this.f7398f, obj, z4);
            } else {
                if (obj instanceof f) {
                    i(((f) obj).getNumber());
                    return this;
                }
                b(((Enum) obj).name());
                return this;
            }
        }
    }

    /* renamed from: l */
    public e b(String str) {
        y();
        this.f7395c.value(str);
        return this;
    }

    public e m(String str, double d5) {
        y();
        this.f7395c.name(str);
        return h(d5);
    }

    public e n(String str, int i4) {
        y();
        this.f7395c.name(str);
        return i(i4);
    }

    public e o(String str, long j4) {
        y();
        this.f7395c.name(str);
        return j(j4);
    }

    public e p(String str, Object obj) {
        if (this.f7399g) {
            return x(str, obj);
        }
        return w(str, obj);
    }

    public e q(String str, boolean z4) {
        y();
        this.f7395c.name(str);
        return f(z4);
    }

    /* renamed from: r */
    public e f(boolean z4) {
        y();
        this.f7395c.value(z4);
        return this;
    }

    public e s(byte[] bArr) {
        y();
        if (bArr == null) {
            this.f7395c.nullValue();
            return this;
        }
        this.f7395c.value(Base64.encodeToString(bArr, 2));
        return this;
    }

    /* access modifiers changed from: package-private */
    public void u() {
        y();
        this.f7395c.flush();
    }

    /* access modifiers changed from: package-private */
    public e v(C1495d dVar, Object obj, boolean z4) {
        if (!z4) {
            this.f7395c.beginObject();
        }
        dVar.a(obj, this);
        if (!z4) {
            this.f7395c.endObject();
        }
        return this;
    }
}
