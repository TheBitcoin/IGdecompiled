package H2;

import androidx.appcompat.widget.SearchView;
import e4.a;
import java.util.List;
import kotlin.jvm.internal.m;

public final class i implements SearchView.OnQueryTextListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f6668a;

    public i(h hVar) {
        this.f6668a = hVar;
    }

    public boolean onQueryTextChange(String str) {
        boolean z4;
        m.e(str, "newText");
        a aVar = this.f6668a.f6667p;
        l lVar = null;
        if (aVar == null) {
            m.u("switchAdapter");
            aVar = null;
        }
        l lVar2 = this.f6668a.f6666o;
        if (lVar2 == null) {
            m.u("viewModel");
        } else {
            lVar = lVar2;
        }
        List c5 = lVar.c(str);
        if (str.length() > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        aVar.b(c5, z4);
        return true;
    }

    public boolean onQueryTextSubmit(String str) {
        return true;
    }
}
