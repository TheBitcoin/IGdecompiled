package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.g;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import i1.C2079a;
import i1.C2080b;
import i1.C2081c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ObjectTypeAdapter extends TypeAdapter {

    /* renamed from: c  reason: collision with root package name */
    private static final r f11546c = f(p.DOUBLE);

    /* renamed from: a  reason: collision with root package name */
    private final Gson f11547a;

    /* renamed from: b  reason: collision with root package name */
    private final q f11548b;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11550a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                i1.b[] r0 = i1.C2080b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11550a = r0
                i1.b r1 = i1.C2080b.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f11550a     // Catch:{ NoSuchFieldError -> 0x001d }
                i1.b r1 = i1.C2080b.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f11550a     // Catch:{ NoSuchFieldError -> 0x0028 }
                i1.b r1 = i1.C2080b.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f11550a     // Catch:{ NoSuchFieldError -> 0x0033 }
                i1.b r1 = i1.C2080b.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f11550a     // Catch:{ NoSuchFieldError -> 0x003e }
                i1.b r1 = i1.C2080b.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f11550a     // Catch:{ NoSuchFieldError -> 0x0049 }
                i1.b r1 = i1.C2080b.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ObjectTypeAdapter.a.<clinit>():void");
        }
    }

    public static r e(q qVar) {
        if (qVar == p.DOUBLE) {
            return f11546c;
        }
        return f(qVar);
    }

    private static r f(final q qVar) {
        return new r() {
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                if (typeToken.c() == Object.class) {
                    return new ObjectTypeAdapter(gson, q.this);
                }
                return null;
            }
        };
    }

    private Object g(C2079a aVar, C2080b bVar) {
        int i4 = a.f11550a[bVar.ordinal()];
        if (i4 == 3) {
            return aVar.J();
        }
        if (i4 == 4) {
            return this.f11548b.a(aVar);
        }
        if (i4 == 5) {
            return Boolean.valueOf(aVar.z());
        }
        if (i4 == 6) {
            aVar.H();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + bVar);
    }

    private Object h(C2079a aVar, C2080b bVar) {
        int i4 = a.f11550a[bVar.ordinal()];
        if (i4 == 1) {
            aVar.a();
            return new ArrayList();
        } else if (i4 != 2) {
            return null;
        } else {
            aVar.d();
            return new g();
        }
    }

    public Object b(C2079a aVar) {
        String str;
        boolean z4;
        C2080b L4 = aVar.L();
        Object h4 = h(aVar, L4);
        if (h4 == null) {
            return g(aVar, L4);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.u()) {
                if (h4 instanceof Map) {
                    str = aVar.F();
                } else {
                    str = null;
                }
                C2080b L5 = aVar.L();
                Object h5 = h(aVar, L5);
                if (h5 != null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (h5 == null) {
                    h5 = g(aVar, L5);
                }
                if (h4 instanceof List) {
                    ((List) h4).add(h5);
                } else {
                    ((Map) h4).put(str, h5);
                }
                if (z4) {
                    arrayDeque.addLast(h4);
                    h4 = h5;
                }
            } else {
                if (h4 instanceof List) {
                    aVar.l();
                } else {
                    aVar.n();
                }
                if (arrayDeque.isEmpty()) {
                    return h4;
                }
                h4 = arrayDeque.removeLast();
            }
        }
    }

    public void d(C2081c cVar, Object obj) {
        if (obj == null) {
            cVar.x();
            return;
        }
        TypeAdapter l4 = this.f11547a.l(obj.getClass());
        if (l4 instanceof ObjectTypeAdapter) {
            cVar.i();
            cVar.n();
            return;
        }
        l4.d(cVar, obj);
    }

    private ObjectTypeAdapter(Gson gson, q qVar) {
        this.f11547a = gson;
        this.f11548b = qVar;
    }
}
