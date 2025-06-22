package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class f implements DynamiteModule.b {
    f() {
    }

    public final DynamiteModule.b.C0024b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0024b bVar = new DynamiteModule.b.C0024b();
        int i4 = 0;
        int a5 = aVar.a(context, str, false);
        bVar.f1389b = a5;
        if (a5 != 0) {
            i4 = 1;
        }
        bVar.f1390c = i4;
        return bVar;
    }
}
