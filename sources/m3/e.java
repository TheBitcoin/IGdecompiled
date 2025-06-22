package m3;

import d3.p;
import j3.d;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.m;

final class e implements l3.e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f21166a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f21167b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f21168c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final p f21169d;

    public static final class a implements Iterator, e3.a {

        /* renamed from: a  reason: collision with root package name */
        private int f21170a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f21171b;

        /* renamed from: c  reason: collision with root package name */
        private int f21172c;

        /* renamed from: d  reason: collision with root package name */
        private d f21173d;

        /* renamed from: e  reason: collision with root package name */
        private int f21174e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ e f21175f;

        a(e eVar) {
            this.f21175f = eVar;
            int f4 = j3.e.f(eVar.f21167b, 0, eVar.f21166a.length());
            this.f21171b = f4;
            this.f21172c = f4;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (r0 < m3.e.c(r6.f21175f)) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f21172c
                r1 = 0
                if (r0 >= 0) goto L_0x000b
                r6.f21170a = r1
                r0 = 0
                r6.f21173d = r0
                return
            L_0x000b:
                m3.e r0 = r6.f21175f
                int r0 = r0.f21168c
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L_0x0022
                int r0 = r6.f21174e
                int r0 = r0 + r3
                r6.f21174e = r0
                m3.e r4 = r6.f21175f
                int r4 = r4.f21168c
                if (r0 >= r4) goto L_0x0030
            L_0x0022:
                int r0 = r6.f21172c
                m3.e r4 = r6.f21175f
                java.lang.CharSequence r4 = r4.f21166a
                int r4 = r4.length()
                if (r0 <= r4) goto L_0x0046
            L_0x0030:
                j3.d r0 = new j3.d
                int r1 = r6.f21171b
                m3.e r4 = r6.f21175f
                java.lang.CharSequence r4 = r4.f21166a
                int r4 = m3.w.F(r4)
                r0.<init>(r1, r4)
                r6.f21173d = r0
                r6.f21172c = r2
                goto L_0x009b
            L_0x0046:
                m3.e r0 = r6.f21175f
                d3.p r0 = r0.f21169d
                m3.e r4 = r6.f21175f
                java.lang.CharSequence r4 = r4.f21166a
                int r5 = r6.f21172c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                R2.l r0 = (R2.l) r0
                if (r0 != 0) goto L_0x0076
                j3.d r0 = new j3.d
                int r1 = r6.f21171b
                m3.e r4 = r6.f21175f
                java.lang.CharSequence r4 = r4.f21166a
                int r4 = m3.w.F(r4)
                r0.<init>(r1, r4)
                r6.f21173d = r0
                r6.f21172c = r2
                goto L_0x009b
            L_0x0076:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f21171b
                j3.d r4 = j3.e.i(r4, r2)
                r6.f21173d = r4
                int r2 = r2 + r0
                r6.f21171b = r2
                if (r0 != 0) goto L_0x0098
                r1 = 1
            L_0x0098:
                int r2 = r2 + r1
                r6.f21172c = r2
            L_0x009b:
                r6.f21170a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: m3.e.a.a():void");
        }

        /* renamed from: b */
        public d next() {
            if (this.f21170a == -1) {
                a();
            }
            if (this.f21170a != 0) {
                d dVar = this.f21173d;
                m.c(dVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f21173d = null;
                this.f21170a = -1;
                return dVar;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f21170a == -1) {
                a();
            }
            if (this.f21170a == 1) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(CharSequence charSequence, int i4, int i5, p pVar) {
        m.e(charSequence, "input");
        m.e(pVar, "getNextMatch");
        this.f21166a = charSequence;
        this.f21167b = i4;
        this.f21168c = i5;
        this.f21169d = pVar;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
