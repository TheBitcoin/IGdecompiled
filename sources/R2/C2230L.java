package r2;

import android.view.View;
import com.uptodown.tv.ui.fragment.TvMyDownloadsFragment;
import java.io.File;

/* renamed from: r2.L  reason: case insensitive filesystem */
public final /* synthetic */ class C2230L implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvMyDownloadsFragment f21612a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File f21613b;

    public /* synthetic */ C2230L(TvMyDownloadsFragment tvMyDownloadsFragment, File file) {
        this.f21612a = tvMyDownloadsFragment;
        this.f21613b = file;
    }

    public final void onClick(View view) {
        TvMyDownloadsFragment.o(this.f21612a, this.f21613b, view);
    }
}
