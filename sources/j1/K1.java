package J1;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.uptodown.activities.MoreInfo;

public final /* synthetic */ class K1 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextView f6806a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MoreInfo f6807b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f6808c;

    public /* synthetic */ K1(TextView textView, MoreInfo moreInfo, View view) {
        this.f6806a = textView;
        this.f6807b = moreInfo;
        this.f6808c = view;
    }

    public final void onGlobalLayout() {
        MoreInfo.G3(this.f6806a, this.f6807b, this.f6808c);
    }
}
