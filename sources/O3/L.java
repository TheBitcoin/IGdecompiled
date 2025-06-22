package o3;

import R2.k;
import V2.d;
import V2.f;
import d3.l;
import d3.p;
import u3.b;

public enum L {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3664a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                o3.L[] r0 = o3.L.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                o3.L r1 = o3.L.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                o3.L r1 = o3.L.ATOMIC     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                o3.L r1 = o3.L.UNDISPATCHED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                o3.L r1 = o3.L.LAZY     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f3664a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: o3.L.a.<clinit>():void");
        }
    }

    public final void b(p pVar, Object obj, d dVar) {
        int i4 = a.f3664a[ordinal()];
        if (i4 == 1) {
            u3.a.d(pVar, obj, dVar, (l) null, 4, (Object) null);
        } else if (i4 == 2) {
            f.a(pVar, obj, dVar);
        } else if (i4 == 3) {
            b.a(pVar, obj, dVar);
        } else if (i4 != 4) {
            throw new k();
        }
    }

    public final boolean c() {
        if (this == LAZY) {
            return true;
        }
        return false;
    }
}
