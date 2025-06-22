package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.d  reason: case insensitive filesystem */
public final class C0533d {

    /* renamed from: a  reason: collision with root package name */
    private C0542e f1796a;

    /* renamed from: b  reason: collision with root package name */
    private C0542e f1797b;

    /* renamed from: c  reason: collision with root package name */
    private List f1798c;

    public C0533d() {
        this.f1796a = new C0542e("", 0, (Map) null);
        this.f1797b = new C0542e("", 0, (Map) null);
        this.f1798c = new ArrayList();
    }

    public final C0542e a() {
        return this.f1796a;
    }

    public final void b(C0542e eVar) {
        this.f1796a = eVar;
        this.f1797b = (C0542e) eVar.clone();
        this.f1798c.clear();
    }

    public final void c(String str, long j4, Map map) {
        HashMap hashMap = new HashMap();
        for (String str2 : map.keySet()) {
            hashMap.put(str2, C0542e.c(str2, this.f1796a.b(str2), map.get(str2)));
        }
        this.f1798c.add(new C0542e(str, j4, hashMap));
    }

    public final /* synthetic */ Object clone() {
        C0533d dVar = new C0533d((C0542e) this.f1796a.clone());
        for (C0542e clone : this.f1798c) {
            dVar.f1798c.add((C0542e) clone.clone());
        }
        return dVar;
    }

    public final C0542e d() {
        return this.f1797b;
    }

    public final void e(C0542e eVar) {
        this.f1797b = eVar;
    }

    public final List f() {
        return this.f1798c;
    }

    private C0533d(C0542e eVar) {
        this.f1796a = eVar;
        this.f1797b = (C0542e) eVar.clone();
        this.f1798c = new ArrayList();
    }
}
