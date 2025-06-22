package J1;

import android.view.View;
import com.uptodown.activities.MyDownloads;
import g2.C2060s;
import kotlin.jvm.internal.C;

/* renamed from: J1.y2  reason: case insensitive filesystem */
public final /* synthetic */ class C1481y2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f7218a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2060s f7219b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f7220c;

    public /* synthetic */ C1481y2(C c5, C2060s sVar, MyDownloads myDownloads) {
        this.f7218a = c5;
        this.f7219b = sVar;
        this.f7220c = myDownloads;
    }

    public final void onClick(View view) {
        MyDownloads.h4(this.f7218a, this.f7219b, this.f7220c, view);
    }
}
