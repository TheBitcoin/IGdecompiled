package r2;

import android.view.View;
import com.uptodown.tv.ui.fragment.TvMyDownloadsFragment;
import java.io.File;

/* renamed from: r2.M  reason: case insensitive filesystem */
public final /* synthetic */ class C2231M implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ File f21614a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TvMyDownloadsFragment f21615b;

    public /* synthetic */ C2231M(File file, TvMyDownloadsFragment tvMyDownloadsFragment) {
        this.f21614a = file;
        this.f21615b = tvMyDownloadsFragment;
    }

    public final void onClick(View view) {
        TvMyDownloadsFragment.p(this.f21614a, this.f21615b, view);
    }
}
