package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class S4 extends LinkedHashMap {

    /* renamed from: b  reason: collision with root package name */
    private static final S4 f1613b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1614a = true;

    static {
        S4 s4 = new S4();
        f1613b = s4;
        s4.f1614a = false;
    }

    private S4() {
    }

    private static int a(Object obj) {
        if (obj instanceof byte[]) {
            return C0684u4.d((byte[]) obj);
        }
        if (!(obj instanceof C0708x4)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public static S4 b() {
        return f1613b;
    }

    private final void h() {
        if (!this.f1614a) {
            throw new UnsupportedOperationException();
        }
    }

    public final void c(S4 s4) {
        h();
        if (!s4.isEmpty()) {
            putAll(s4);
        }
    }

    public final void clear() {
        h();
        super.clear();
    }

    public final S4 d() {
        if (isEmpty()) {
            return new S4();
        }
        return new S4(this);
    }

    public final void e() {
        this.f1614a = false;
    }

    public final Set entrySet() {
        if (isEmpty()) {
            return Collections.EMPTY_SET;
        }
        return super.entrySet();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L_0x005d
            java.util.Map r7 = (java.util.Map) r7
            r0 = 1
            if (r6 == r7) goto L_0x0059
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L_0x0016
        L_0x0014:
            r7 = 0
            goto L_0x005a
        L_0x0016:
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x001e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0059
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L_0x0035
            goto L_0x0014
        L_0x0035:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L_0x0052
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L_0x0052
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x0056
        L_0x0052:
            boolean r3 = r4.equals(r3)
        L_0x0056:
            if (r3 != 0) goto L_0x001e
            goto L_0x0014
        L_0x0059:
            r7 = 1
        L_0x005a:
            if (r7 == 0) goto L_0x005d
            return r0
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.S4.equals(java.lang.Object):boolean");
    }

    public final boolean f() {
        return this.f1614a;
    }

    public final int hashCode() {
        int i4 = 0;
        for (Map.Entry entry : entrySet()) {
            i4 += a(entry.getValue()) ^ a(entry.getKey());
        }
        return i4;
    }

    public final Object put(Object obj, Object obj2) {
        h();
        C0684u4.e(obj);
        C0684u4.e(obj2);
        return super.put(obj, obj2);
    }

    public final void putAll(Map map) {
        h();
        for (Object next : map.keySet()) {
            C0684u4.e(next);
            C0684u4.e(map.get(next));
        }
        super.putAll(map);
    }

    public final Object remove(Object obj) {
        h();
        return super.remove(obj);
    }

    private S4(Map map) {
        super(map);
    }
}
