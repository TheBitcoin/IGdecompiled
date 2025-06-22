package m0;

import j$.util.Objects;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import l0.h;
import m0.C2148p;

final class J extends C2148p {

    /* renamed from: h  reason: collision with root package name */
    static final C2148p f21055h = new J((Object) null, new Object[0], 0);

    /* renamed from: e  reason: collision with root package name */
    private final transient Object f21056e;

    /* renamed from: f  reason: collision with root package name */
    final transient Object[] f21057f;

    /* renamed from: g  reason: collision with root package name */
    private final transient int f21058g;

    static class a extends r {

        /* renamed from: c  reason: collision with root package name */
        private final transient C2148p f21059c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final transient Object[] f21060d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final transient int f21061e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final transient int f21062f;

        /* renamed from: m0.J$a$a  reason: collision with other inner class name */
        class C0260a extends C2147o {
            C0260a() {
            }

            public boolean k() {
                return true;
            }

            public int size() {
                return a.this.f21062f;
            }

            /* renamed from: z */
            public Map.Entry get(int i4) {
                h.g(i4, a.this.f21062f);
                int i5 = i4 * 2;
                Object obj = a.this.f21060d[a.this.f21061e + i5];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.f21060d[i5 + (a.this.f21061e ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
        }

        a(C2148p pVar, Object[] objArr, int i4, int i5) {
            this.f21059c = pVar;
            this.f21060d = objArr;
            this.f21061e = i4;
            this.f21062f = i5;
        }

        /* access modifiers changed from: package-private */
        public int c(Object[] objArr, int i4) {
            return l().c(objArr, i4);
        }

        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value == null || !value.equals(this.f21059c.get(key))) {
                    return false;
                }
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean k() {
            return true;
        }

        /* access modifiers changed from: package-private */
        public C2147o p() {
            return new C0260a();
        }

        public int size() {
            return this.f21062f;
        }

        /* renamed from: z */
        public S iterator() {
            return l().iterator();
        }
    }

    static final class b extends r {

        /* renamed from: c  reason: collision with root package name */
        private final transient C2148p f21064c;

        /* renamed from: d  reason: collision with root package name */
        private final transient C2147o f21065d;

        b(C2148p pVar, C2147o oVar) {
            this.f21064c = pVar;
            this.f21065d = oVar;
        }

        /* access modifiers changed from: package-private */
        public int c(Object[] objArr, int i4) {
            return l().c(objArr, i4);
        }

        public boolean contains(Object obj) {
            if (this.f21064c.get(obj) != null) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean k() {
            return true;
        }

        public C2147o l() {
            return this.f21065d;
        }

        public int size() {
            return this.f21064c.size();
        }

        /* renamed from: w */
        public S iterator() {
            return l().iterator();
        }
    }

    static final class c extends C2147o {

        /* renamed from: c  reason: collision with root package name */
        private final transient Object[] f21066c;

        /* renamed from: d  reason: collision with root package name */
        private final transient int f21067d;

        /* renamed from: e  reason: collision with root package name */
        private final transient int f21068e;

        c(Object[] objArr, int i4, int i5) {
            this.f21066c = objArr;
            this.f21067d = i4;
            this.f21068e = i5;
        }

        public Object get(int i4) {
            h.g(i4, this.f21068e);
            Object obj = this.f21066c[(i4 * 2) + this.f21067d];
            Objects.requireNonNull(obj);
            return obj;
        }

        /* access modifiers changed from: package-private */
        public boolean k() {
            return true;
        }

        public int size() {
            return this.f21068e;
        }
    }

    private J(Object obj, Object[] objArr, int i4) {
        this.f21056e = obj;
        this.f21057f = objArr;
        this.f21058g = i4;
    }

    static J i(int i4, Object[] objArr, C2148p.a aVar) {
        if (i4 == 0) {
            return (J) f21055h;
        }
        if (i4 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            C2139g.a(obj, obj2);
            return new J((Object) null, objArr, 1);
        }
        h.k(i4, objArr.length >> 1);
        Object j4 = j(objArr, i4, r.m(i4), 0);
        if (j4 instanceof Object[]) {
            Object[] objArr2 = (Object[]) j4;
            C2148p.a.C0263a aVar2 = (C2148p.a.C0263a) objArr2[2];
            if (aVar != null) {
                aVar.f21139e = aVar2;
                Object obj3 = objArr2[0];
                int intValue = ((Integer) objArr2[1]).intValue();
                objArr = Arrays.copyOf(objArr, intValue * 2);
                j4 = obj3;
                i4 = intValue;
            } else {
                throw aVar2.a();
            }
        }
        return new J(j4, objArr, i4);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object j(java.lang.Object[] r17, int r18, int r19, int r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = 0
            r3 = 1
            if (r0 != r3) goto L_0x0018
            r0 = r17[r20]
            j$.util.Objects.requireNonNull(r0)
            r1 = r20 ^ 1
            r1 = r17[r1]
            j$.util.Objects.requireNonNull(r1)
            m0.C2139g.a(r0, r1)
            return r2
        L_0x0018:
            int r4 = r1 + -1
            r5 = 128(0x80, float:1.794E-43)
            r6 = 3
            r7 = -1
            r8 = 2
            r9 = 0
            if (r1 > r5) goto L_0x008b
            byte[] r1 = new byte[r1]
            java.util.Arrays.fill(r1, r7)
            r5 = 0
            r7 = 0
        L_0x0029:
            if (r5 >= r0) goto L_0x007b
            int r10 = r5 * 2
            int r10 = r10 + r20
            int r11 = r7 * 2
            int r11 = r11 + r20
            r12 = r17[r10]
            j$.util.Objects.requireNonNull(r12)
            r10 = r10 ^ r3
            r10 = r17[r10]
            j$.util.Objects.requireNonNull(r10)
            m0.C2139g.a(r12, r10)
            int r13 = r12.hashCode()
            int r13 = m0.C2145m.b(r13)
        L_0x0049:
            r13 = r13 & r4
            byte r14 = r1[r13]
            r15 = 255(0xff, float:3.57E-43)
            r14 = r14 & r15
            if (r14 != r15) goto L_0x005f
            byte r14 = (byte) r11
            r1[r13] = r14
            if (r7 >= r5) goto L_0x005c
            r17[r11] = r12
            r11 = r11 ^ 1
            r17[r11] = r10
        L_0x005c:
            int r7 = r7 + 1
            goto L_0x0075
        L_0x005f:
            r15 = r17[r14]
            boolean r15 = r12.equals(r15)
            if (r15 == 0) goto L_0x0078
            m0.p$a$a r2 = new m0.p$a$a
            r11 = r14 ^ 1
            r13 = r17[r11]
            j$.util.Objects.requireNonNull(r13)
            r2.<init>(r12, r10, r13)
            r17[r11] = r10
        L_0x0075:
            int r5 = r5 + 1
            goto L_0x0029
        L_0x0078:
            int r13 = r13 + 1
            goto L_0x0049
        L_0x007b:
            if (r7 != r0) goto L_0x007e
            return r1
        L_0x007e:
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r9] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            r0[r3] = r1
            r0[r8] = r2
            return r0
        L_0x008b:
            r5 = 32768(0x8000, float:4.5918E-41)
            if (r1 > r5) goto L_0x00fa
            short[] r1 = new short[r1]
            java.util.Arrays.fill(r1, r7)
            r5 = 0
            r7 = 0
        L_0x0097:
            if (r5 >= r0) goto L_0x00ea
            int r10 = r5 * 2
            int r10 = r10 + r20
            int r11 = r7 * 2
            int r11 = r11 + r20
            r12 = r17[r10]
            j$.util.Objects.requireNonNull(r12)
            r10 = r10 ^ r3
            r10 = r17[r10]
            j$.util.Objects.requireNonNull(r10)
            m0.C2139g.a(r12, r10)
            int r13 = r12.hashCode()
            int r13 = m0.C2145m.b(r13)
        L_0x00b7:
            r13 = r13 & r4
            short r14 = r1[r13]
            r15 = 65535(0xffff, float:9.1834E-41)
            r14 = r14 & r15
            if (r14 != r15) goto L_0x00ce
            short r14 = (short) r11
            r1[r13] = r14
            if (r7 >= r5) goto L_0x00cb
            r17[r11] = r12
            r11 = r11 ^ 1
            r17[r11] = r10
        L_0x00cb:
            int r7 = r7 + 1
            goto L_0x00e4
        L_0x00ce:
            r15 = r17[r14]
            boolean r15 = r12.equals(r15)
            if (r15 == 0) goto L_0x00e7
            m0.p$a$a r2 = new m0.p$a$a
            r11 = r14 ^ 1
            r13 = r17[r11]
            j$.util.Objects.requireNonNull(r13)
            r2.<init>(r12, r10, r13)
            r17[r11] = r10
        L_0x00e4:
            int r5 = r5 + 1
            goto L_0x0097
        L_0x00e7:
            int r13 = r13 + 1
            goto L_0x00b7
        L_0x00ea:
            if (r7 != r0) goto L_0x00ed
            return r1
        L_0x00ed:
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r9] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            r0[r3] = r1
            r0[r8] = r2
            return r0
        L_0x00fa:
            int[] r1 = new int[r1]
            java.util.Arrays.fill(r1, r7)
            r5 = 0
            r10 = 0
        L_0x0101:
            if (r5 >= r0) goto L_0x0155
            int r11 = r5 * 2
            int r11 = r11 + r20
            int r12 = r10 * 2
            int r12 = r12 + r20
            r13 = r17[r11]
            j$.util.Objects.requireNonNull(r13)
            r11 = r11 ^ r3
            r11 = r17[r11]
            j$.util.Objects.requireNonNull(r11)
            m0.C2139g.a(r13, r11)
            int r14 = r13.hashCode()
            int r14 = m0.C2145m.b(r14)
        L_0x0121:
            r14 = r14 & r4
            r15 = r1[r14]
            if (r15 != r7) goto L_0x0135
            r1[r14] = r12
            if (r10 >= r5) goto L_0x0130
            r17[r12] = r13
            r12 = r12 ^ 1
            r17[r12] = r11
        L_0x0130:
            int r10 = r10 + 1
            r16 = 1
            goto L_0x014d
        L_0x0135:
            r16 = 1
            r3 = r17[r15]
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0151
            m0.p$a$a r2 = new m0.p$a$a
            r3 = r15 ^ 1
            r12 = r17[r3]
            j$.util.Objects.requireNonNull(r12)
            r2.<init>(r13, r11, r12)
            r17[r3] = r11
        L_0x014d:
            int r5 = r5 + 1
            r3 = 1
            goto L_0x0101
        L_0x0151:
            int r14 = r14 + 1
            r3 = 1
            goto L_0x0121
        L_0x0155:
            r16 = 1
            if (r10 != r0) goto L_0x015a
            return r1
        L_0x015a:
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r9] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
            r0[r16] = r1
            r0[r8] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.J.j(java.lang.Object[], int, int, int):java.lang.Object");
    }

    static Object k(Object obj, Object[] objArr, int i4, int i5, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i4 == 1) {
            Object obj3 = objArr[i5];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i5 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        } else if (obj == null) {
            return null;
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length - 1;
                int b5 = C2145m.b(obj2.hashCode());
                while (true) {
                    int i6 = b5 & length;
                    byte b6 = bArr[i6] & 255;
                    if (b6 == 255) {
                        return null;
                    }
                    if (obj2.equals(objArr[b6])) {
                        return objArr[b6 ^ 1];
                    }
                    b5 = i6 + 1;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length - 1;
                int b7 = C2145m.b(obj2.hashCode());
                while (true) {
                    int i7 = b7 & length2;
                    short s4 = sArr[i7] & 65535;
                    if (s4 == 65535) {
                        return null;
                    }
                    if (obj2.equals(objArr[s4])) {
                        return objArr[s4 ^ 1];
                    }
                    b7 = i7 + 1;
                }
            } else {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length - 1;
                int b8 = C2145m.b(obj2.hashCode());
                while (true) {
                    int i8 = b8 & length3;
                    int i9 = iArr[i8];
                    if (i9 == -1) {
                        return null;
                    }
                    if (obj2.equals(objArr[i9])) {
                        return objArr[i9 ^ 1];
                    }
                    b8 = i8 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public r a() {
        return new a(this, this.f21057f, 0, this.f21058g);
    }

    /* access modifiers changed from: package-private */
    public r b() {
        return new b(this, new c(this.f21057f, 0, this.f21058g));
    }

    /* access modifiers changed from: package-private */
    public C2146n c() {
        return new c(this.f21057f, 1, this.f21058g);
    }

    public Object get(Object obj) {
        Object k4 = k(this.f21056e, this.f21057f, this.f21058g, 0, obj);
        if (k4 == null) {
            return null;
        }
        return k4;
    }

    public int size() {
        return this.f21058g;
    }
}
