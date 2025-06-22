package J1;

import android.view.View;
import android.widget.TextView;
import com.uptodown.activities.MoreInfo;

public final /* synthetic */ class L1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MoreInfo f6824a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f6825b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f6826c;

    public /* synthetic */ L1(MoreInfo moreInfo, TextView textView, View view) {
        this.f6824a = moreInfo;
        this.f6825b = textView;
        this.f6826c = view;
    }

    public final void onClick(View view) {
        MoreInfo.H3(this.f6824a, this.f6825b, this.f6826c, view);
    }
}
