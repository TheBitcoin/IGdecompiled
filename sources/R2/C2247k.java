package r2;

import android.content.DialogInterface;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import g2.C2060s;

/* renamed from: r2.k  reason: case insensitive filesystem */
public final /* synthetic */ class C2247k implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2060s f21645a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TvAppDetailFragment f21646b;

    public /* synthetic */ C2247k(C2060s sVar, TvAppDetailFragment tvAppDetailFragment) {
        this.f21645a = sVar;
        this.f21646b = tvAppDetailFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i4) {
        TvAppDetailFragment.Q(this.f21645a, this.f21646b, dialogInterface, i4);
    }
}
