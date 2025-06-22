package com.mbridge.msdk.newreward.function.command;

import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private a f14629a;

    /* renamed from: b  reason: collision with root package name */
    private a f14630b;

    public final void a(a aVar) {
        this.f14629a = aVar;
    }

    public final void b(a aVar) {
        if (this.f14630b == null) {
            this.f14630b = aVar;
        }
    }

    public final Object c(Object obj, f fVar) {
        if (this.f14629a == null) {
            return Boolean.FALSE;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f14629a.a(bVar).a();
    }

    public final void d(Object obj) throws MBridgeError {
        if (this.f14629a != null) {
            b bVar = new b();
            bVar.a(f.CHECK_CAMPAIGN_EXCLUDE_INS);
            bVar.a(obj);
            e a5 = this.f14629a.a(bVar);
            if (!a5.b()) {
                throw ((MBridgeError) a5.a());
            }
        }
    }

    public final void e(Object obj) {
        if (this.f14629a != null) {
            b bVar = new b();
            bVar.a(obj);
            bVar.a(f.HANDLER_ALREADY_INSTALL_CAMPAIGN);
            this.f14629a.a(bVar);
        }
    }

    public final void f(Object obj) {
        b bVar = new b();
        bVar.a(obj);
        bVar.a(f.START_LOAD_CHECK);
        this.f14629a.a(bVar);
    }

    public final Object g(Object obj, f fVar) {
        if (this.f14630b == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f14630b.a(bVar).a();
    }

    public final Object h(Object obj, f fVar) {
        if (this.f14630b == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f14630b.a(bVar).a();
    }

    public final Object i(Object obj, f fVar) {
        if (this.f14630b == null) {
            this.f14630b = new com.mbridge.msdk.newreward.function.command.a.c();
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f14630b.a(bVar).a();
    }

    public final Map a(Object... objArr) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (objArr.length % 2 == 0) {
            for (int i4 = 0; i4 < objArr.length; i4++) {
                if (i4 % 2 == 0) {
                    Object obj = objArr[i4];
                    Object obj2 = objArr[i4 + 1];
                    if (obj == null) {
                        obj = "";
                    }
                    if (obj2 == null) {
                        obj2 = "";
                    }
                    concurrentHashMap.put(obj, obj2);
                }
            }
        }
        return concurrentHashMap;
    }

    public final void b(Object obj, b bVar) {
        if (this.f14629a != null) {
            b bVar2 = new b();
            bVar2.a(obj);
            bVar2.a(f.SMART_LOAD);
            this.f14629a.a(bVar2, bVar);
        }
    }

    public final Object f(Object obj, f fVar) {
        if (this.f14630b == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f14630b.a(bVar).a();
    }

    public final void c(Object obj) throws MBridgeError {
        if (this.f14629a != null) {
            b bVar = new b();
            bVar.a(f.CHECK_CAMPAIGN);
            bVar.a(obj);
            e a5 = this.f14629a.a(bVar);
            if (!a5.b()) {
                throw ((MBridgeError) a5.a());
            }
        }
    }

    public final Object e(Object obj, f fVar) {
        if (this.f14630b == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f14630b.a(bVar).a();
    }

    public final Object b(Object obj) {
        if (this.f14629a == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(obj);
        bVar.a(f.CANDIDATE_LOAD_ACTION);
        return this.f14629a.a(bVar).a();
    }

    public final Object d(Object obj, f fVar) {
        if (this.f14630b == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f14630b.a(bVar).a();
    }

    public final Object a(Object obj, f fVar) {
        if (this.f14629a == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(obj);
        bVar.a(fVar);
        return this.f14629a.a(bVar).a();
    }

    public final void e(Object obj, b bVar) {
        if (this.f14630b != null) {
            b bVar2 = new b();
            bVar2.a((f) ((Map) obj).get("command_type"));
            bVar2.a(obj);
            this.f14630b.a(bVar2, bVar);
        }
    }

    public final Object b(Object obj, f fVar) {
        if (this.f14629a == null) {
            return Boolean.FALSE;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f14629a.a(bVar).a();
    }

    public final void c(Object obj, b bVar) {
        if (this.f14629a != null) {
            b bVar2 = new b();
            bVar2.a(obj);
            bVar2.a((f) ((Map) obj).get("command_type"));
            this.f14629a.a(bVar2, bVar);
        }
    }

    public final void d(Object obj, b bVar) {
        if (this.f14630b != null) {
            b bVar2 = new b();
            bVar2.a(obj);
            bVar2.a((f) ((Map) obj).get("command_type"));
            this.f14630b.a(bVar2, bVar);
        }
    }

    public final void a(Object obj, f fVar, b bVar) {
        if (this.f14629a != null) {
            b bVar2 = new b();
            bVar2.a(obj);
            bVar2.a(fVar);
            this.f14629a.a(bVar2, bVar);
        }
    }

    public final void a(Object obj, b bVar) {
        if (this.f14629a != null) {
            b bVar2 = new b();
            bVar2.a(obj);
            bVar2.a(f.NORMAL_LOAD);
            this.f14629a.a(bVar2, bVar);
        }
    }

    public final void a(Object obj) {
        if (this.f14629a != null) {
            b bVar = new b();
            bVar.a(f.SHOW);
            bVar.a(obj);
            this.f14629a.a(bVar);
        }
    }

    public final void a(Object obj, f fVar, Object obj2) {
        b bVar = new b();
        bVar.a(obj2);
        bVar.a(fVar);
        new com.mbridge.msdk.newreward.function.command.a.b(obj).a(bVar);
    }

    public final void a(Object obj, String str) {
        if (this.f14630b == null) {
            this.f14630b = new com.mbridge.msdk.newreward.function.command.a.c();
        }
        b bVar = new b();
        bVar.a(obj);
        this.f14630b.a(bVar, str);
    }
}
