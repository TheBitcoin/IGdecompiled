package d4;

import A1.b;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.m;

public final class f extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final View f24539a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f24540b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f24541c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f24542d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f24543e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f24544f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f24545g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f24546h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f24547i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f24548j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f24549k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(View view) {
        super(view);
        m.e(view, "rootView");
        View findViewById = view.findViewById(b.disclosure_divider);
        m.d(findViewById, "rootView.findViewById(R.id.disclosure_divider)");
        this.f24539a = findViewById;
        View findViewById2 = view.findViewById(b.tv_disclosure_purposes_label);
        m.d(findViewById2, "rootView.findViewById(R.…isclosure_purposes_label)");
        this.f24540b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(b.tv_disclosure_domain_label);
        m.d(findViewById3, "rootView.findViewById(R.…_disclosure_domain_label)");
        this.f24541c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(b.tv_disclosure_max_age_label);
        m.d(findViewById4, "rootView.findViewById(R.…disclosure_max_age_label)");
        this.f24542d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(b.tv_disclosure_type_label);
        m.d(findViewById5, "rootView.findViewById(R.…tv_disclosure_type_label)");
        this.f24543e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(b.tv_disclosure_name_label);
        m.d(findViewById6, "rootView.findViewById(R.…tv_disclosure_name_label)");
        this.f24544f = (TextView) findViewById6;
        View findViewById7 = view.findViewById(b.tv_disclosure_purposes);
        m.d(findViewById7, "rootView.findViewById(R.id.tv_disclosure_purposes)");
        this.f24545g = (TextView) findViewById7;
        View findViewById8 = view.findViewById(b.tv_disclosure_domain);
        m.d(findViewById8, "rootView.findViewById(R.id.tv_disclosure_domain)");
        this.f24546h = (TextView) findViewById8;
        View findViewById9 = view.findViewById(b.tv_disclosure_max_age);
        m.d(findViewById9, "rootView.findViewById(R.id.tv_disclosure_max_age)");
        this.f24547i = (TextView) findViewById9;
        View findViewById10 = view.findViewById(b.tv_disclosure_type);
        m.d(findViewById10, "rootView.findViewById(R.id.tv_disclosure_type)");
        this.f24548j = (TextView) findViewById10;
        View findViewById11 = view.findViewById(b.tv_disclosure_name);
        m.d(findViewById11, "rootView.findViewById(R.id.tv_disclosure_name)");
        this.f24549k = (TextView) findViewById11;
    }
}
