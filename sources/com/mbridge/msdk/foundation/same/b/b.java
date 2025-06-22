package com.mbridge.msdk.foundation.same.b;

import java.util.ArrayList;
import java.util.List;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected a f13176a;

    public b(String str) {
        a aVar = new a();
        aVar.a(str);
        aVar.a(c.AD_ROOT);
        List<a> a5 = a();
        if (a5 != null && a5.size() > 0) {
            aVar.a(a5);
        }
        this.f13176a = aVar;
    }

    /* access modifiers changed from: protected */
    public final a a(ArrayList<a> arrayList, c cVar, String str) {
        a aVar = new a();
        aVar.a(cVar);
        aVar.a(str);
        arrayList.add(aVar);
        return aVar;
    }

    /* access modifiers changed from: protected */
    public abstract List<a> a();

    public final a b() {
        return this.f13176a;
    }
}
