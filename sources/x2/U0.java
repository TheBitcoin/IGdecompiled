package x2;

import N1.k;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import f2.C2009H;
import kotlin.jvm.internal.m;
import u2.q;
import y2.n;

public final class U0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2009H f22275a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f22276b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f22277c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f22278d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f22279e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public U0(View view, C2009H h4) {
        super(view);
        m.e(view, "itemView");
        m.e(h4, "updatesTrackingListener");
        this.f22275a = h4;
        View findViewById = view.findViewById(R.id.tv_updates_available_updates_header);
        m.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.f22276b = textView;
        View findViewById2 = view.findViewById(R.id.ll_no_pending_updates_header);
        m.d(findViewById2, "findViewById(...)");
        this.f22277c = (LinearLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_last_check_updates_header);
        m.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f22278d = textView2;
        View findViewById4 = view.findViewById(R.id.tv_check_updates_header);
        m.d(findViewById4, "findViewById(...)");
        TextView textView3 = (TextView) findViewById4;
        this.f22279e = textView3;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.w());
    }

    /* access modifiers changed from: private */
    public static final void c(U0 u02, View view) {
        u02.f22275a.b();
    }

    public final void b(int i4) {
        if (i4 == 0) {
            UptodownApp.a aVar = UptodownApp.f17422D;
            Context context = this.itemView.getContext();
            m.d(context, "getContext(...)");
            if (aVar.T("TrackingWorkerSingle", context)) {
                this.f22279e.setOnClickListener((View.OnClickListener) null);
                Context context2 = this.itemView.getContext();
                m.d(context2, "getContext(...)");
                new n(context2).d(this.f22279e, 0.3f);
            } else {
                this.f22279e.setOnClickListener(new T0(this));
                Context context3 = this.itemView.getContext();
                m.d(context3, "getContext(...)");
                new n(context3).d(this.f22279e, 1.0f);
            }
            this.f22276b.setText(this.itemView.getContext().getString(R.string.you_are_up_to_date));
            TextView textView = this.f22278d;
            Resources resources = this.itemView.getResources();
            q qVar = new q();
            a.C0236a aVar2 = a.f18818a;
            Context context4 = this.itemView.getContext();
            m.d(context4, "getContext(...)");
            textView.setText(resources.getString(R.string.last_check, new Object[]{String.valueOf(qVar.l(aVar2.w(context4)))}));
            this.f22277c.setVisibility(0);
            return;
        }
        this.f22276b.setText(this.itemView.getContext().getString(R.string.my_downloads_pending));
        this.f22277c.setVisibility(8);
    }
}
