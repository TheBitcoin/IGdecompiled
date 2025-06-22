package r2;

import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import d3.p;
import java.util.Comparator;

/* renamed from: r2.D  reason: case insensitive filesystem */
public final /* synthetic */ class C2222D implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f21599a;

    public /* synthetic */ C2222D(p pVar) {
        this.f21599a = pVar;
    }

    public final int compare(Object obj, Object obj2) {
        return TvMyAppsFragment.R(this.f21599a, obj, obj2);
    }
}
