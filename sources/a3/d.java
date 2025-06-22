package A3;

import B3.e;
import C2.b;
import C2.c;
import C3.f;
import E2.h;
import R2.s;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.data.storage.SharedStorage;
import com.inmobi.cmp.model.ChoiceError;
import d3.l;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f51a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final f f52b;

    /* renamed from: c  reason: collision with root package name */
    public static final SharedStorage f53c;

    /* renamed from: d  reason: collision with root package name */
    public static e f54d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f55e;

    /* renamed from: f  reason: collision with root package name */
    public static g f56f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f57g;

    /* renamed from: h  reason: collision with root package name */
    public static h f58h = h.NATIONAL;

    public static final class a extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f59a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(l lVar) {
            super(1);
            this.f59a = lVar;
        }

        public Object invoke(Object obj) {
            this.f59a.invoke((USRegulationData) obj);
            return s.f8222a;
        }
    }

    static {
        b4.d dVar = b4.d.f24465a;
        f52b = dVar.j();
        SharedStorage m4 = dVar.m();
        f53c = m4;
        f55e = m4.j(a4.a.SAVED_MSPA_JURISDICTION);
    }

    public final String a() {
        return f53c.j(a4.a.SAVED_REGION);
    }

    public final void b(List list, boolean z4, l lVar) {
        m.e(list, "mspaPurpose");
        m.e(lVar, "completion");
        e eVar = f54d;
        if (eVar != null) {
            eVar.e(list, z4, new a(lVar));
            return;
        }
        b.a(b.f6277a, ChoiceError.UNEXPECTED_ERROR_OCCURRED, (String) null, (String) null, c.CONSOLE, (Throwable) null, 22);
        lVar.invoke((Object) null);
    }

    public final g c() {
        g gVar = f56f;
        if (gVar != null) {
            return gVar;
        }
        i iVar = i.f81a;
        g a5 = iVar.a(b4.d.f24478n);
        f fVar = f52b;
        if (m.a(fVar.f170b.f118J, "NATIONAL") || (fVar.f170b.f119K && d())) {
            a5 = g.NOT_APPLICABLE;
        } else if ((!fVar.f170b.f119K || a5 == g.NOT_APPLICABLE || d()) && !fVar.f170b.f119K && a5 == g.NOT_APPLICABLE && e()) {
            a5 = iVar.a(a());
        }
        f56f = a5;
        return a5;
    }

    public final boolean d() {
        return m.a(f55e, "NATIONAL");
    }

    public final boolean e() {
        return m.a(f55e, "STATE_AND_NATIONAL");
    }
}
