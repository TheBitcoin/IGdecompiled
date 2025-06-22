package x2;

import N1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import g2.C2048f;
import g2.C2050h;
import kotlin.jvm.internal.m;
import u2.F;

/* renamed from: x2.B  reason: case insensitive filesystem */
public final class C2351B extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22103a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f22104b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f22105c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f22106d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2351B(View view, Context context) {
        super(view);
        m.e(view, "itemView");
        m.e(context, "context");
        this.f22103a = context;
        View findViewById = view.findViewById(R.id.iv_logo_app);
        m.d(findViewById, "findViewById(...)");
        this.f22104b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_app_name);
        m.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f22105c = textView;
        View findViewById3 = view.findViewById(R.id.tv_app_version);
        m.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f22106d = textView2;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.x());
    }

    public final void a(C2048f fVar) {
        if (fVar != null) {
            this.f22104b.setImageDrawable(F.f21886a.k(this.f22103a, fVar.o()));
            this.f22105c.setText(fVar.m());
            this.f22106d.setText(fVar.B());
        }
    }

    public final void b(C2050h hVar) {
        if (hVar != null) {
            String F4 = hVar.F();
            if (F4 == null || F4.length() == 0) {
                this.f22104b.setImageDrawable(ContextCompat.getDrawable(this.f22103a, R.drawable.vector_app_icon_placeholder));
            } else {
                s.h().l(hVar.F()).n(UptodownApp.f17422D.i0(this.f22103a)).i(this.f22104b);
            }
            this.f22105c.setText(hVar.L());
            this.f22106d.setText(hVar.w0());
        }
    }
}
