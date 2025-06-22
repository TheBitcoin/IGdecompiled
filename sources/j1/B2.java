package J1;

import android.view.View;
import com.uptodown.activities.MyDownloads;
import g2.C2060s;
import kotlin.jvm.internal.C;

public final /* synthetic */ class B2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f6718a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2060s f6719b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f6720c;

    public /* synthetic */ B2(C c5, C2060s sVar, MyDownloads myDownloads) {
        this.f6718a = c5;
        this.f6719b = sVar;
        this.f6720c = myDownloads;
    }

    public final void onClick(View view) {
        MyDownloads.d4(this.f6718a, this.f6719b, this.f6720c, view);
    }
}
