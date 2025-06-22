package m0;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import l0.h;

public abstract class w {

    class a extends S {

        /* renamed from: a  reason: collision with root package name */
        boolean f21152a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f21153b;

        a(Object obj) {
            this.f21153b = obj;
        }

        public boolean hasNext() {
            return !this.f21152a;
        }

        public Object next() {
            if (!this.f21152a) {
                this.f21152a = true;
                return this.f21153b;
            }
            throw new NoSuchElementException();
        }
    }

    public static boolean a(Collection collection, Iterator it) {
        h.i(collection);
        h.i(it);
        boolean z4 = false;
        while (it.hasNext()) {
            z4 |= collection.add(it.next());
        }
        return z4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0006  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.util.Iterator r3, java.util.Iterator r4) {
        /*
        L_0x0000:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x001d
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = l0.f.a(r0, r2)
            if (r0 != 0) goto L_0x0000
            return r1
        L_0x001d:
            boolean r3 = r4.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.w.b(java.util.Iterator, java.util.Iterator):boolean");
    }

    public static S c(Object obj) {
        return new a(obj);
    }
}
