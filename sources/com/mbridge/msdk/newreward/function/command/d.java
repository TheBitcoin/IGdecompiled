package com.mbridge.msdk.newreward.function.command;

import com.mbridge.msdk.newreward.a.e;
import java.util.HashMap;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f14631a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, e> f14632b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private c f14633c;

    private d() {
    }

    public static d a() {
        if (f14631a == null) {
            synchronized (d.class) {
                try {
                    if (f14631a == null) {
                        f14631a = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f14631a;
    }

    public final c b() {
        return this.f14633c;
    }

    public final void b(String str) {
        this.f14632b.remove(str);
    }

    public final void a(c cVar) {
        this.f14633c = cVar;
    }

    public final e a(String str) {
        return this.f14632b.get(str);
    }

    public final void a(e eVar) {
        if (this.f14632b.get(eVar.G()) == null) {
            this.f14632b.put(eVar.G(), eVar);
        }
    }
}
