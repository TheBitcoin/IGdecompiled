package J1;

import android.view.View;
import com.uptodown.activities.MyDownloads;
import java.util.HashMap;

public final /* synthetic */ class K2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f6809a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f6810b;

    public /* synthetic */ K2(MyDownloads myDownloads, HashMap hashMap) {
        this.f6809a = myDownloads;
        this.f6810b = hashMap;
    }

    public final void onClick(View view) {
        MyDownloads.q4(this.f6809a, this.f6810b, view);
    }
}
