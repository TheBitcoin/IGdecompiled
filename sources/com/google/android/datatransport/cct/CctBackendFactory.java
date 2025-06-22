package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import r.C1021d;
import r.C1025h;
import r.C1030m;

@Keep
public class CctBackendFactory implements C1021d {
    public C1030m create(C1025h hVar) {
        return new d(hVar.b(), hVar.e(), hVar.d());
    }
}
