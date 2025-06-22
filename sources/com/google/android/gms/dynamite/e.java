package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class e implements DynamiteModule.b {
    e() {
    }

    public final DynamiteModule.b.C0024b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0024b bVar = new DynamiteModule.b.C0024b();
        int b5 = aVar.b(context, str);
        bVar.f1388a = b5;
        if (b5 != 0) {
            bVar.f1390c = -1;
            return bVar;
        }
        int a5 = aVar.a(context, str, true);
        bVar.f1389b = a5;
        if (a5 != 0) {
            bVar.f1390c = 1;
        }
        return bVar;
    }
}
