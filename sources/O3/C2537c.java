package O3;

import N3.C2520k;
import N3.Q;
import S2.C1593g;
import com.mbridge.msdk.MBridgeConstans;
import java.io.IOException;
import java.util.Iterator;
import kotlin.jvm.internal.m;

/* renamed from: O3.c  reason: case insensitive filesystem */
public abstract class C2537c {
    public static final void a(C2520k kVar, Q q4, boolean z4) {
        m.e(kVar, "<this>");
        m.e(q4, "dir");
        C1593g gVar = new C1593g();
        Q q5 = q4;
        while (q5 != null && !kVar.g(q5)) {
            gVar.j(q5);
            q5 = q5.i();
        }
        if (!z4 || !gVar.isEmpty()) {
            Iterator it = gVar.iterator();
            while (it.hasNext()) {
                kVar.c((Q) it.next());
            }
            return;
        }
        throw new IOException(q4 + " already exist.");
    }

    public static final boolean b(C2520k kVar, Q q4) {
        m.e(kVar, "<this>");
        m.e(q4, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        if (kVar.h(q4) != null) {
            return true;
        }
        return false;
    }
}
