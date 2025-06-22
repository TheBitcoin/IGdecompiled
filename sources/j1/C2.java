package J1;

import android.view.View;
import com.uptodown.activities.MyDownloads;
import g2.C2060s;
import kotlin.jvm.internal.C;

public final /* synthetic */ class C2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f6729a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f6730b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2060s f6731c;

    public /* synthetic */ C2(C c5, MyDownloads myDownloads, C2060s sVar) {
        this.f6729a = c5;
        this.f6730b = myDownloads;
        this.f6731c = sVar;
    }

    public final void onClick(View view) {
        MyDownloads.e4(this.f6729a, this.f6730b, this.f6731c, view);
    }
}
