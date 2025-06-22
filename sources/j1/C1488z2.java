package J1;

import android.view.View;
import com.uptodown.activities.MyDownloads;
import kotlin.jvm.internal.C;

/* renamed from: J1.z2  reason: case insensitive filesystem */
public final /* synthetic */ class C1488z2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f7228a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7229b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C f7230c;

    public /* synthetic */ C1488z2(MyDownloads myDownloads, int i4, C c5) {
        this.f7228a = myDownloads;
        this.f7229b = i4;
        this.f7230c = c5;
    }

    public final void onClick(View view) {
        MyDownloads.b4(this.f7228a, this.f7229b, this.f7230c, view);
    }
}
