package i2;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import j2.C2092a;
import kotlin.coroutines.jvm.internal.l;
import o3.J;
import org.json.JSONException;

public final class i extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2092a f20916a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JSONException f20917b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(C2092a aVar, JSONException jSONException, d dVar) {
        super(2, dVar);
        this.f20916a = aVar;
        this.f20917b = jSONException;
    }

    public final d create(Object obj, d dVar) {
        return new i(this.f20916a, this.f20917b, dVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new i(this.f20916a, this.f20917b, (d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        b.c();
        n.b(obj);
        this.f20916a.a(this.f20917b.getMessage());
        return s.f8222a;
    }
}
