package n;

import A3.c;
import A3.d;
import A3.f;
import B3.e;
import C2.b;
import R2.s;
import S2.C1594h;
import T3.C2573a;
import T3.C2585m;
import T3.C2586n;
import X3.i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ChoiceError;
import d3.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.n;

public final class m extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final A3.a f3605a;

    /* renamed from: b  reason: collision with root package name */
    public final i f3606b;

    /* renamed from: c  reason: collision with root package name */
    public final ChoiceCmpCallback f3607c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3608d = 2;

    public static final class a extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f3609a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(m mVar) {
            super(1);
            this.f3609a = mVar;
        }

        public Object invoke(Object obj) {
            s sVar;
            ChoiceCmpCallback choiceCmpCallback;
            ChoiceCmpCallback choiceCmpCallback2;
            USRegulationData uSRegulationData = (USRegulationData) obj;
            if (uSRegulationData == null || (choiceCmpCallback2 = this.f3609a.f3607c) == null) {
                sVar = null;
            } else {
                choiceCmpCallback2.onReceiveUSRegulationsConsent(uSRegulationData);
                sVar = s.f8222a;
            }
            if (sVar == null && (choiceCmpCallback = this.f3609a.f3607c) != null) {
                choiceCmpCallback.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
            }
            return s.f8222a;
        }
    }

    public m(A3.a aVar, i iVar, ChoiceCmpCallback choiceCmpCallback) {
        kotlin.jvm.internal.m.e(aVar, "mspaConfig");
        kotlin.jvm.internal.m.e(iVar, "gbcConsentRepository");
        this.f3605a = aVar;
        this.f3606b = iVar;
        this.f3607c = choiceCmpCallback;
    }

    public final LiveData a() {
        if (c.i.f1158b) {
            this.f3606b.a();
        }
        d dVar = d.f51a;
        A3.a aVar = this.f3605a;
        a aVar2 = new a(this);
        kotlin.jvm.internal.m.e(aVar, "mspaConfig");
        kotlin.jvm.internal.m.e(aVar2, "completion");
        e eVar = d.f54d;
        if (eVar != null) {
            List<A3.e> list = aVar.f32d;
            if (list != null) {
                c cVar = new c(aVar2);
                kotlin.jvm.internal.m.e(list, "purposes");
                kotlin.jvm.internal.m.e(cVar, "completion");
                for (A3.e eVar2 : list) {
                    eVar2.f63d = Boolean.FALSE;
                    List<f> list2 = eVar2.f66g;
                    if (list2 != null) {
                        for (f fVar : list2) {
                            fVar.f70d = Boolean.FALSE;
                        }
                    }
                }
                eVar.e(list, true, new B3.d(cVar));
            }
        } else {
            b.a(b.f6277a, ChoiceError.UNEXPECTED_ERROR_OCCURRED, (String) null, (String) null, C2.c.CONSOLE, (Throwable) null, 22);
            aVar2.invoke((Object) null);
        }
        return C2585m.f24018a.a(C2586n.ACCEPT_ALL, C2573a.ACCEPT_ALL);
    }

    public final List b(int[] iArr) {
        ArrayList arrayList;
        String str;
        boolean z4;
        ArrayList arrayList2 = new ArrayList();
        List list = this.f3605a.f32d;
        int i4 = 0;
        if (list == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object next : list) {
                Integer num = ((A3.e) next).f60a;
                if (num == null) {
                    int[] iArr2 = iArr;
                    z4 = false;
                } else {
                    z4 = C1594h.n(iArr, num.intValue());
                }
                if (z4) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                A3.e eVar = (A3.e) obj;
                Integer num2 = eVar.f60a;
                if (num2 != null) {
                    int intValue = num2.intValue();
                    M2.a aVar = eVar.f64e;
                    if (aVar == null) {
                        str = null;
                    } else {
                        str = aVar.f7739c;
                    }
                    if (str == null) {
                        str = "";
                    }
                    arrayList2.add(new e4.d(new z3.f(intValue, str), eVar.f63d, (e4.f) null, e4.e.MSPA_PURPOSE, false, (String) null, (Integer) null, 116));
                }
            }
        }
        return arrayList2;
    }
}
