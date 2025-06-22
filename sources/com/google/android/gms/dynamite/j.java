package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class j implements DynamiteModule.b {
    j() {
    }

    public final DynamiteModule.b.C0024b a(Context context, String str, DynamiteModule.b.a aVar) {
        int i4;
        DynamiteModule.b.C0024b bVar = new DynamiteModule.b.C0024b();
        int b5 = aVar.b(context, str);
        bVar.f1388a = b5;
        int i5 = 1;
        int i6 = 0;
        if (b5 != 0) {
            i4 = aVar.a(context, str, false);
            bVar.f1389b = i4;
        } else {
            i4 = aVar.a(context, str, true);
            bVar.f1389b = i4;
        }
        int i7 = bVar.f1388a;
        if (i7 != 0) {
            i6 = i7;
        } else if (i4 == 0) {
            i5 = 0;
            bVar.f1390c = i5;
            return bVar;
        }
        if (i4 < i6) {
            i5 = -1;
        }
        bVar.f1390c = i5;
        return bVar;
    }
}
