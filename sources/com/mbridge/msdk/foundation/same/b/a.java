package com.mbridge.msdk.foundation.same.b;

import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f13172a;

    /* renamed from: b  reason: collision with root package name */
    private String f13173b;

    /* renamed from: c  reason: collision with root package name */
    private a f13174c;

    /* renamed from: d  reason: collision with root package name */
    private c f13175d;

    public final void a(c cVar, String str) {
        a aVar = new a();
        aVar.f13175d = cVar;
        aVar.f13173b = str;
        a(aVar);
    }

    public final String b() {
        return this.f13173b;
    }

    public final a c() {
        return this.f13174c;
    }

    public final c d() {
        return this.f13175d;
    }

    private void a(a aVar) {
        if (this.f13172a == null) {
            this.f13172a = new ArrayList();
        }
        aVar.f13174c = this;
        this.f13172a.add(aVar);
    }

    public final void a(List<a> list) {
        if (list != null && list.size() != 0) {
            for (a a5 : list) {
                a(a5);
            }
        }
    }

    public final List<a> a() {
        return this.f13172a;
    }

    public final void a(String str) {
        this.f13173b = str;
    }

    public final void a(c cVar) {
        this.f13175d = cVar;
    }
}
