package E2;

import R2.s;
import S2.C1594h;
import S2.C1601o;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.data.storage.SharedStorage;
import com.inmobi.cmp.model.ChoiceError;
import d3.l;
import j$.time.ZonedDateTime;
import j1.C2091a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.m;
import n1.C2160c;
import o1.C2180h;
import z3.e;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f6347a = new a();

    public static final class a {
        public final String a(s sVar) {
            Integer num;
            int i4;
            m.e(sVar, "tcModel");
            try {
                b4.d dVar = b4.d.f24465a;
                C2091a g4 = dVar.g();
                SharedStorage m4 = dVar.m();
                g4.k(C2180h.f21395f, C2160c.f21237a, Integer.valueOf(sVar.f6399i));
                g4.k(C2180h.f21395f, C2160c.f21240d, Integer.valueOf(sVar.f6403m));
                g4.k(C2180h.f21395f, C2160c.f21241e, Integer.valueOf(sVar.f6404n));
                g4.k(C2180h.f21395f, C2160c.f21242f, Integer.valueOf(sVar.f6400j));
                g4.k(C2180h.f21395f, C2160c.f21243g, sVar.f6402l);
                String str = C2180h.f21395f;
                String str2 = C2160c.f21244h;
                e eVar = sVar.f6391a;
                if (eVar == null) {
                    num = null;
                } else {
                    num = eVar.f4801b;
                }
                if (num == null) {
                    i4 = sVar.f6405o;
                } else {
                    i4 = num.intValue();
                }
                g4.k(str, str2, Integer.valueOf(i4));
                g4.k(C2180h.f21395f, C2160c.f21245i, Integer.valueOf(sVar.f()));
                g4.k(C2180h.f21395f, C2160c.f21246j, Boolean.valueOf(sVar.f6395e));
                g4.k(C2180h.f21395f, C2160c.f21247k, Boolean.valueOf(sVar.f6396f));
                g4.k(C2180h.f21395f, C2160c.f21248l, b(12, sVar.f6407q));
                g4.k(C2180h.f21395f, C2160c.f21249m, b(24, sVar.f6408r));
                g4.k(C2180h.f21395f, C2160c.f21250n, b(24, sVar.f6409s));
                g4.k(C2180h.f21395f, C2160c.f21251o, Boolean.valueOf(sVar.f6397g));
                g4.k(C2180h.f21395f, C2160c.f21252p, sVar.f6398h);
                g4.k(C2180h.f21395f, C2160c.f21253q, C1601o.Z(sVar.f6416z.getAcceptedItems()));
                g4.k(C2180h.f21395f, C2160c.f21254r, C1601o.Z(sVar.f6386C.getAcceptedItems()));
                String str3 = C2180h.f21395f;
                String str4 = C2160c.f21255s;
                ArrayList arrayList = new ArrayList();
                for (Map.Entry value : sVar.f6390G.f6363c.entrySet()) {
                    arrayList.addAll((Collection) value.getValue());
                }
                s sVar2 = s.f8222a;
                g4.k(str3, str4, arrayList);
                g4.k(C2180h.f21395f, C2160c.f21257u, b(24, sVar.f6412v));
                g4.k(C2180h.f21395f, C2160c.f21258v, b(24, sVar.f6413w));
                int i5 = sVar.f6406p;
                g4.k(C2180h.f21395f, C2160c.f21259w, Integer.valueOf(i5));
                g4.k(C2180h.f21395f, C2160c.f21260x, b(i5, sVar.f6414x));
                g4.k(C2180h.f21395f, C2160c.f21261y, b(i5, sVar.f6415y));
                g4.k(C2180h.f21395f, C2160c.f21234A, C1601o.Z(sVar.f6389F.getAcceptedItems()));
                g4.k(C2180h.f21395f, C2160c.f21236C, C1601o.Z(sVar.f6388E.getAcceptedItems()));
                m4.e(a4.a.HDR_GPP_VERSION, String.valueOf(g4.e().g()));
                m4.e(a4.a.HDR_SECTION_LIST, g4.h().toString());
                a4.a aVar = a4.a.HDR_SECTION_ID;
                List h4 = g4.h();
                m.d(h4, "gppModel.sectionIds");
                m4.e(aVar, C1601o.O(h4, "_", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null));
                String w4 = m3.m.w("IABGPP_[SectionID]_String", "[SectionID]", String.valueOf(C2180h.f21393d), false, 4, (Object) null);
                String b5 = g4.g(C2180h.f21395f).b();
                m.d(b5, "gppModel.getSection(TcfEuV2.NAME).encode()");
                m4.g(w4, b5);
                ZonedDateTime zonedDateTime = sVar.f6394d;
                if (zonedDateTime != null) {
                    g4.k(C2180h.f21395f, C2160c.f21238b, zonedDateTime);
                    g4.k(C2180h.f21395f, C2160c.f21239c, sVar.f6394d);
                }
                b4.d dVar2 = b4.d.f24465a;
                m.e(g4, "gppModel");
                b4.d.f24479o = g4;
                String d5 = g4.d();
                a4.a aVar2 = a4.a.HDR_GPP_STRING;
                m.d(d5, "gppString");
                m4.e(aVar2, d5);
                return d5;
            } catch (Exception unused) {
                ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
                if (callback == null) {
                    return "";
                }
                callback.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
                return "";
            }
        }

        public final List b(int i4, Vector vector) {
            boolean[] zArr = new boolean[i4];
            for (Number intValue : vector.getAcceptedItems()) {
                int intValue2 = intValue.intValue();
                if (1 <= intValue2 && intValue2 < i4 + 1) {
                    zArr[intValue2 - 1] = true;
                }
            }
            return C1594h.J(zArr);
        }
    }
}
