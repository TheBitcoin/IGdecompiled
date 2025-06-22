package x2;

import N1.k;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import kotlin.jvm.internal.m;

/* renamed from: x2.x  reason: case insensitive filesystem */
public final class C2402x extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private TextView f22543a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f22544b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f22545c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f22546d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2402x(View view) {
        super(view);
        m.e(view, "itemView");
        View findViewById = view.findViewById(R.id.tv_name_app_fn);
        m.d(findViewById, "findViewById(...)");
        this.f22543a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_desc_app_fn);
        m.d(findViewById2, "findViewById(...)");
        this.f22544b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.iv_logo_app_fn);
        m.d(findViewById3, "findViewById(...)");
        this.f22545c = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_install_fn);
        m.d(findViewById4, "findViewById(...)");
        this.f22546d = (TextView) findViewById4;
        TextView textView = this.f22543a;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        this.f22544b.setTypeface(aVar.x());
        this.f22546d.setTypeface(aVar.w());
    }

    public final ImageView a() {
        return this.f22545c;
    }

    public final TextView b() {
        return this.f22544b;
    }

    public final TextView c() {
        return this.f22546d;
    }

    public final TextView d() {
        return this.f22543a;
    }
}
