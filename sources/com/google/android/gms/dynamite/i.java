package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class i implements DynamiteModule.b {
    i() {
    }

    public final DynamiteModule.b.C0024b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0024b bVar = new DynamiteModule.b.C0024b();
        bVar.f1388a = aVar.b(context, str);
        int i4 = 1;
        int a5 = aVar.a(context, str, true);
        bVar.f1389b = a5;
        int i5 = bVar.f1388a;
        if (i5 == 0) {
            i5 = 0;
            if (a5 == 0) {
                i4 = 0;
                bVar.f1390c = i4;
                return bVar;
            }
        }
        if (a5 < i5) {
            i4 = -1;
        }
        bVar.f1390c = i4;
        return bVar;
    }
}
