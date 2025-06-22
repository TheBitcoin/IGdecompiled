package F2;

import E2.s;
import X3.w;
import androidx.lifecycle.ViewModel;
import e4.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;

public final class g extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final s f6513a;

    /* renamed from: b  reason: collision with root package name */
    public final X3.g f6514b;

    /* renamed from: c  reason: collision with root package name */
    public final w f6515c;

    /* renamed from: d  reason: collision with root package name */
    public final List f6516d = new ArrayList();

    public g(s sVar, X3.g gVar, w wVar) {
        m.e(sVar, "tcModel");
        m.e(gVar, "disclosureRepository");
        m.e(wVar, "translationsTextRepository");
        this.f6513a = sVar;
        this.f6514b = gVar;
        this.f6515c = wVar;
    }

    public final int a(e eVar) {
        m.e(eVar, "switchItemType");
        int ordinal = eVar.ordinal();
        if (ordinal == 0) {
            return 8;
        }
        if (ordinal == 1) {
            return 2;
        }
        if (ordinal != 2) {
            return 8;
        }
        return 10;
    }
}
