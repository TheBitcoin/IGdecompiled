package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.tracker.network.c;
import com.mbridge.msdk.tracker.network.u;

public final class e implements c {
    public final String a(u<?> uVar) {
        String k4 = uVar.k();
        int i4 = uVar.i();
        if (i4 == 0) {
            return k4;
        }
        return Integer.toString(i4) + '-' + k4;
    }
}
