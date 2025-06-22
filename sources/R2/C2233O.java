package r2;

import android.content.DialogInterface;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;

/* renamed from: r2.O  reason: case insensitive filesystem */
public final /* synthetic */ class C2233O implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvOldVersionsFragment f21617a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21618b;

    public /* synthetic */ C2233O(TvOldVersionsFragment tvOldVersionsFragment, String str) {
        this.f21617a = tvOldVersionsFragment;
        this.f21618b = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i4) {
        TvOldVersionsFragment.q(this.f21617a, this.f21618b, dialogInterface, i4);
    }
}
