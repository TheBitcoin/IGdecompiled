package com.uptodown.activities;

import J1.C1312a0;
import J1.C1319b0;
import J1.C1326c0;
import N1.k;
import R2.g;
import R2.h;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import c2.M;
import com.uptodown.R;
import g2.C2059q;
import kotlin.jvm.internal.m;
import u2.q;

public final class InformationActivity extends C1826a {

    /* renamed from: J  reason: collision with root package name */
    private final g f17719J = h.a(new C1326c0(this));

    /* access modifiers changed from: private */
    public static final M d3(InformationActivity informationActivity) {
        return M.c(informationActivity.getLayoutInflater());
    }

    private final M e3() {
        return (M) this.f17719J.getValue();
    }

    private final void f3() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            e3().f9828c.setNavigationIcon(drawable);
            e3().f9828c.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        e3().f9828c.setNavigationOnClickListener(new C1312a0(this));
        TextView textView = e3().f9835j;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        e3().f9829d.setTypeface(aVar.x());
        e3().f9830e.setTypeface(aVar.x());
        e3().f9831f.setTypeface(aVar.x());
        e3().f9833h.setTypeface(aVar.x());
        e3().f9834i.setTypeface(aVar.x());
        e3().f9832g.setTypeface(aVar.x());
        TextView textView2 = e3().f9832g;
        C2059q.a aVar2 = C2059q.f20700f;
        String string = getString(R.string.information_activity_dev_on_board_more_info);
        m.d(string, "getString(...)");
        textView2.setText(aVar2.h(this, string));
        e3().f9832g.setOnClickListener(new C1319b0(this));
    }

    /* access modifiers changed from: private */
    public static final void g3(InformationActivity informationActivity, View view) {
        informationActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void h3(InformationActivity informationActivity, View view) {
        String string = informationActivity.getString(R.string.url_dev_on_board);
        m.d(string, "getString(...)");
        String string2 = informationActivity.getString(R.string.support_title);
        m.d(string2, "getString(...)");
        new q().q(informationActivity, string, string2);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) e3().getRoot());
        f3();
    }
}
