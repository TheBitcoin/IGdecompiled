package J1;

import android.view.View;
import com.uptodown.activities.MyDownloads;
import kotlin.jvm.internal.C;

public final /* synthetic */ class D2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f6742a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f6743b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f6744c;

    public /* synthetic */ D2(C c5, MyDownloads myDownloads, int i4) {
        this.f6742a = c5;
        this.f6743b = myDownloads;
        this.f6744c = i4;
    }

    public final void onClick(View view) {
        MyDownloads.f4(this.f6742a, this.f6743b, this.f6744c, view);
    }
}
