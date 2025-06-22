package J1;

import android.view.View;
import com.uptodown.activities.MyDownloads;
import kotlin.jvm.internal.C;

public final /* synthetic */ class E2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f6754a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f6755b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f6756c;

    public /* synthetic */ E2(C c5, MyDownloads myDownloads, int i4) {
        this.f6754a = c5;
        this.f6755b = myDownloads;
        this.f6756c = i4;
    }

    public final void onClick(View view) {
        MyDownloads.g4(this.f6754a, this.f6755b, this.f6756c, view);
    }
}
