package com.mbridge.msdk.tracker.network.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.tracker.network.b;
import com.mbridge.msdk.tracker.network.g;
import com.mbridge.msdk.tracker.network.v;
import com.mbridge.msdk.tracker.network.x;

public final class n {
    public static v a(com.mbridge.msdk.tracker.network.n nVar, x xVar, int i4, b bVar) {
        if (nVar == null) {
            nVar = new b(new h());
        }
        if (xVar == null) {
            xVar = new g(new Handler(Looper.getMainLooper()));
        }
        if (i4 <= 0) {
            i4 = 4;
        }
        if (bVar == null) {
            bVar = new j();
        }
        return new v(nVar, xVar, i4, bVar);
    }
}
