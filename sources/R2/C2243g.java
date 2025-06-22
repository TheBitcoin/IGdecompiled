package r2;

import android.content.DialogInterface;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import g2.C2060s;

/* renamed from: r2.g  reason: case insensitive filesystem */
public final /* synthetic */ class C2243g implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvAppDetailFragment f21640a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2060s f21641b;

    public /* synthetic */ C2243g(TvAppDetailFragment tvAppDetailFragment, C2060s sVar) {
        this.f21640a = tvAppDetailFragment;
        this.f21641b = sVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i4) {
        TvAppDetailFragment.T(this.f21640a, this.f21641b, dialogInterface, i4);
    }
}
