package l;

import androidx.appcompat.widget.SearchView;
import e4.a;
import java.util.List;
import kotlin.jvm.internal.m;

/* renamed from: l.k  reason: case insensitive filesystem */
public final class C0952k implements SearchView.OnQueryTextListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0951j f3545a;

    public C0952k(C0951j jVar) {
        this.f3545a = jVar;
    }

    public boolean onQueryTextChange(String str) {
        boolean z4;
        m.e(str, "newText");
        a aVar = this.f3545a.f3544s;
        C0954m mVar = null;
        if (aVar == null) {
            m.u("switchAdapter");
            aVar = null;
        }
        C0954m mVar2 = this.f3545a.f3542q;
        if (mVar2 == null) {
            m.u("viewModel");
        } else {
            mVar = mVar2;
        }
        List b5 = mVar.b(str);
        if (str.length() > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        aVar.b(b5, z4);
        return true;
    }

    public boolean onQueryTextSubmit(String str) {
        return true;
    }
}
