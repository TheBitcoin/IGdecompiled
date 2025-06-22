package c;

import C3.f;
import M2.c;
import androidx.lifecycle.ViewModel;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import com.inmobi.cmp.data.storage.SharedStorage;
import e4.d;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.m;

public final class e extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final SharedStorage f1144a;

    /* renamed from: b  reason: collision with root package name */
    public final ChoiceCmpCallback f1145b;

    /* renamed from: c  reason: collision with root package name */
    public final c f1146c;

    /* renamed from: d  reason: collision with root package name */
    public final f f1147d;

    public e(SharedStorage sharedStorage, ChoiceCmpCallback choiceCmpCallback, c cVar, f fVar) {
        m.e(sharedStorage, "sharedStorage");
        m.e(cVar, "response");
        m.e(fVar, "portalConfig");
        this.f1144a = sharedStorage;
        this.f1145b = choiceCmpCallback;
        this.f1146c = cVar;
        this.f1147d = fVar;
    }

    public final GBCConsentValue a(List list, String str) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((d) obj).f24631a.f4812a == i.f1157a.e(str)) {
                break;
            }
        }
        d dVar = (d) obj;
        if (dVar == null) {
            return GBCConsentValue.DENIED;
        }
        if (m.a(dVar.f24632b, Boolean.TRUE)) {
            return GBCConsentValue.GRANTED;
        }
        return GBCConsentValue.DENIED;
    }
}
