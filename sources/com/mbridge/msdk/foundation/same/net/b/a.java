package com.mbridge.msdk.foundation.same.net.b;

import com.mbridge.msdk.foundation.same.net.c;
import com.mbridge.msdk.foundation.same.net.d;
import com.mbridge.msdk.foundation.tools.af;

public abstract class a extends c<String> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13252a = "a";

    public abstract void a(String str);

    public abstract void b(String str);

    public void onError(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        String str = f13252a;
        af.b(str, "errorCode = " + aVar.f13249a);
        a(com.mbridge.msdk.foundation.same.net.e.a.a(aVar));
    }

    public void onSuccess(d<String> dVar) {
        if (dVar != null) {
            b((String) dVar.f13256c);
        }
    }
}
