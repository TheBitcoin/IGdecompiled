package com.mbridge.msdk.foundation.same.report.e;

import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.same.net.c;
import com.mbridge.msdk.foundation.same.net.d;
import com.mbridge.msdk.foundation.tools.af;

public abstract class b extends c<String> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13471a = "b";

    public abstract void a(String str);

    public abstract void b(String str);

    public void onError(a aVar) {
        String str = f13471a;
        af.b(str, "errorCode = " + aVar.f13249a);
        b(com.mbridge.msdk.foundation.same.net.e.a.a(aVar));
    }

    public void onSuccess(d<String> dVar) {
        if (dVar != null) {
            a((String) dVar.f13256c);
        }
    }
}
