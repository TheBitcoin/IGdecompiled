package com.uptodown.activities.preferences;

import L1.C1499a;
import L1.C1500b;
import L1.C1501c;
import L1.C1502d;
import L1.C1503e;
import L1.C1504f;
import L1.C1505g;
import L1.C1506h;
import L1.C1507i;
import L1.C1508j;
import L1.C1509k;
import L1.C1510l;
import L1.C1511m;
import L1.C1512n;
import L1.C1513o;
import L1.C1514p;
import L1.C1515q;
import L1.C1516s;
import L1.C1517t;
import L1.C1518u;
import L1.C1519v;
import L1.C1520w;
import L1.C1521x;
import L1.r;
import N1.k;
import R2.g;
import R2.h;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import c2.C1655b;
import c2.C1666g0;
import c2.C1668h0;
import c2.C1672j0;
import c2.C1678m0;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1826a;
import com.uptodown.activities.Suggestions;
import g2.U;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import u2.q;

public final class AdvancedPreferencesActivity extends C1826a {

    /* renamed from: L  reason: collision with root package name */
    public static final a f18809L = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private final g f18810J = h.a(new C1510l(this));

    /* renamed from: K  reason: collision with root package name */
    private RelativeLayout.LayoutParams f18811K;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    /* access modifiers changed from: private */
    public static final void A3(AdvancedPreferencesActivity advancedPreferencesActivity, U u4, View view) {
        Object systemService = advancedPreferencesActivity.getSystemService("clipboard");
        m.c(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("userID", u4.g()));
        advancedPreferencesActivity.q0("userID copiado al portapapeles");
    }

    /* access modifiers changed from: private */
    public static final void B3(A a5, AdvancedPreferencesActivity advancedPreferencesActivity, C1668h0 h0Var, View view) {
        if (a5.f20966a == 4) {
            String string = Settings.Secure.getString(advancedPreferencesActivity.getContentResolver(), "android_id");
            TextView textView = h0Var.f10460d;
            textView.setText(h0Var.f10460d.getText() + " id:" + string);
            h0Var.getRoot().setOnLongClickListener(new C1514p(advancedPreferencesActivity, string));
        }
        int i4 = a5.f20966a;
        if (i4 < 5) {
            a5.f20966a = i4 + 1;
        }
    }

    /* access modifiers changed from: private */
    public static final boolean C3(AdvancedPreferencesActivity advancedPreferencesActivity, String str, View view) {
        Object systemService = advancedPreferencesActivity.getSystemService("clipboard");
        m.c(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("identifier", str));
        advancedPreferencesActivity.q0("identifier copiado al portapapeles");
        return true;
    }

    /* access modifiers changed from: private */
    public static final void D3(View view) {
    }

    /* access modifiers changed from: private */
    public static final void E3(View view) {
    }

    private final void F3() {
        C1668h0 c5 = C1668h0.c(getLayoutInflater());
        m.d(c5, "inflate(...)");
        RelativeLayout b5 = c5.getRoot();
        RelativeLayout.LayoutParams layoutParams = this.f18811K;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            m.u("lp");
            layoutParams = null;
        }
        b5.setLayoutParams(layoutParams);
        TextView textView = c5.f10461e;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        c5.f10461e.setText("Website");
        c5.f10460d.setTypeface(aVar.x());
        c5.f10460d.setText(getString(R.string.url));
        c5.f10460d.setVisibility(0);
        c5.getRoot().setOnClickListener(new C1515q(this));
        S3().f10221b.addView(c5.getRoot());
        C1668h0 c6 = C1668h0.c(getLayoutInflater());
        m.d(c6, "inflate(...)");
        RelativeLayout b6 = c6.getRoot();
        RelativeLayout.LayoutParams layoutParams3 = this.f18811K;
        if (layoutParams3 == null) {
            m.u("lp");
            layoutParams3 = null;
        }
        b6.setLayoutParams(layoutParams3);
        c6.f10461e.setTypeface(aVar.w());
        c6.f10461e.setText("Developers");
        c6.f10460d.setTypeface(aVar.x());
        c6.f10460d.setText(getString(R.string.url_developers));
        c6.f10460d.setVisibility(0);
        c6.getRoot().setOnClickListener(new r(this));
        S3().f10221b.addView(c6.getRoot());
        C1666g0 c7 = C1666g0.c(getLayoutInflater());
        m.d(c7, "inflate(...)");
        c7.f10442b.setTypeface(aVar.w());
        c7.f10442b.setText(getString(R.string.social_networks));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.setMargins(0, (int) getResources().getDimension(R.dimen.margin_m), 0, 0);
        c7.getRoot().setLayoutParams(layoutParams4);
        S3().f10221b.addView(c7.getRoot());
        C1678m0 c8 = C1678m0.c(getLayoutInflater());
        m.d(c8, "inflate(...)");
        LinearLayout b7 = c8.getRoot();
        RelativeLayout.LayoutParams layoutParams5 = this.f18811K;
        if (layoutParams5 == null) {
            m.u("lp");
        } else {
            layoutParams2 = layoutParams5;
        }
        b7.setLayoutParams(layoutParams2);
        c8.f10660g.setOnClickListener(new C1516s(this));
        c8.f10658e.setOnClickListener(new C1517t(this));
        c8.f10659f.setOnClickListener(new C1518u(this));
        c8.f10656c.setOnClickListener(new C1519v(this));
        c8.f10657d.setOnClickListener(new C1520w(this));
        c8.f10655b.setOnClickListener(new C1521x(this));
        S3().f10221b.addView(c8.getRoot());
    }

    /* access modifiers changed from: private */
    public static final void G3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        q qVar = new q();
        q.r(qVar, advancedPreferencesActivity, advancedPreferencesActivity.getString(R.string.url) + "/android", (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void H3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        q qVar = new q();
        String string = advancedPreferencesActivity.getString(R.string.url_developers);
        m.d(string, "getString(...)");
        q.r(qVar, advancedPreferencesActivity, string, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void I3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        q qVar = new q();
        String string = advancedPreferencesActivity.getString(R.string.url_youtube);
        m.d(string, "getString(...)");
        q.r(qVar, advancedPreferencesActivity, string, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void J3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        q qVar = new q();
        String string = advancedPreferencesActivity.getString(R.string.url_tiktok);
        m.d(string, "getString(...)");
        q.r(qVar, advancedPreferencesActivity, string, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void K3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        q qVar = new q();
        String string = advancedPreferencesActivity.getString(R.string.url_x);
        m.d(string, "getString(...)");
        q.r(qVar, advancedPreferencesActivity, string, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void L3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        q qVar = new q();
        String string = advancedPreferencesActivity.getString(R.string.url_instagram);
        m.d(string, "getString(...)");
        q.r(qVar, advancedPreferencesActivity, string, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void M3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        q qVar = new q();
        String string = advancedPreferencesActivity.getString(R.string.url_linkedin);
        m.d(string, "getString(...)");
        q.r(qVar, advancedPreferencesActivity, string, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void N3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        q qVar = new q();
        String string = advancedPreferencesActivity.getString(R.string.url_facebook);
        m.d(string, "getString(...)");
        q.r(qVar, advancedPreferencesActivity, string, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final C1655b O3(AdvancedPreferencesActivity advancedPreferencesActivity) {
        return C1655b.c(advancedPreferencesActivity.getLayoutInflater());
    }

    private final void P3() {
        C1668h0 c5 = C1668h0.c(getLayoutInflater());
        m.d(c5, "inflate(...)");
        RelativeLayout b5 = c5.getRoot();
        RelativeLayout.LayoutParams layoutParams = this.f18811K;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            m.u("lp");
            layoutParams = null;
        }
        b5.setLayoutParams(layoutParams);
        TextView textView = c5.f10461e;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        c5.f10461e.setText(getString(R.string.write_a_suggestion));
        c5.getRoot().setOnClickListener(new C1504f(this));
        S3().f10221b.addView(c5.getRoot());
        C1668h0 c6 = C1668h0.c(getLayoutInflater());
        m.d(c6, "inflate(...)");
        RelativeLayout b6 = c6.getRoot();
        RelativeLayout.LayoutParams layoutParams3 = this.f18811K;
        if (layoutParams3 == null) {
            m.u("lp");
        } else {
            layoutParams2 = layoutParams3;
        }
        b6.setLayoutParams(layoutParams2);
        c6.f10461e.setTypeface(aVar.w());
        c6.f10461e.setText(getString(R.string.dmca_title));
        c6.getRoot().setOnClickListener(new C1505g(this));
        S3().f10221b.addView(c6.getRoot());
    }

    /* access modifiers changed from: private */
    public static final void Q3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        try {
            advancedPreferencesActivity.startActivity(new Intent(advancedPreferencesActivity, Suggestions.class), UptodownApp.f17422D.a(advancedPreferencesActivity));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static final void R3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        String string = advancedPreferencesActivity.getString(R.string.dmca_title);
        m.d(string, "getString(...)");
        String string2 = advancedPreferencesActivity.getString(R.string.url_dmca);
        m.d(string2, "getString(...)");
        new q().q(advancedPreferencesActivity, string2, string);
    }

    private final C1655b S3() {
        return (C1655b) this.f18810J.getValue();
    }

    private final void T3() {
        P1.a aVar = new P1.a(this);
        C1672j0 c5 = C1672j0.c(getLayoutInflater());
        m.d(c5, "inflate(...)");
        RelativeLayout b5 = c5.getRoot();
        RelativeLayout.LayoutParams layoutParams = this.f18811K;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            m.u("lp");
            layoutParams = null;
        }
        b5.setLayoutParams(layoutParams);
        TextView textView = c5.f10592e;
        k.a aVar2 = k.f7778g;
        textView.setTypeface(aVar2.w());
        c5.f10592e.setText(getString(R.string.show_splits_dialog));
        c5.f10591d.setVisibility(8);
        c5.f10590c.setChecked(aVar.r());
        c5.f10590c.setOnCheckedChangeListener(new C1500b(aVar));
        c5.getRoot().setOnClickListener(new C1501c(c5));
        S3().f10221b.addView(c5.getRoot());
        C1672j0 c6 = C1672j0.c(getLayoutInflater());
        m.d(c6, "inflate(...)");
        RelativeLayout b6 = c6.getRoot();
        RelativeLayout.LayoutParams layoutParams3 = this.f18811K;
        if (layoutParams3 == null) {
            m.u("lp");
        } else {
            layoutParams2 = layoutParams3;
        }
        b6.setLayoutParams(layoutParams2);
        c6.f10592e.setTypeface(aVar2.w());
        c6.f10592e.setText(getString(R.string.show_warning_installed));
        c6.f10591d.setVisibility(8);
        c6.f10590c.setChecked(aVar.N());
        c6.f10590c.setOnCheckedChangeListener(new C1502d(aVar));
        c6.getRoot().setOnClickListener(new C1503e(c6));
        S3().f10221b.addView(c6.getRoot());
    }

    /* access modifiers changed from: private */
    public static final void U3(P1.a aVar, CompoundButton compoundButton, boolean z4) {
        aVar.I(z4);
    }

    /* access modifiers changed from: private */
    public static final void V3(C1672j0 j0Var, View view) {
        j0Var.f10590c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void W3(P1.a aVar, CompoundButton compoundButton, boolean z4) {
        aVar.J(z4);
    }

    /* access modifiers changed from: private */
    public static final void X3(C1672j0 j0Var, View view) {
        j0Var.f10590c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void Y3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        advancedPreferencesActivity.finish();
    }

    private final void Z3() {
        C1668h0 c5 = C1668h0.c(getLayoutInflater());
        m.d(c5, "inflate(...)");
        RelativeLayout b5 = c5.getRoot();
        RelativeLayout.LayoutParams layoutParams = this.f18811K;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            m.u("lp");
            layoutParams = null;
        }
        b5.setLayoutParams(layoutParams);
        TextView textView = c5.f10461e;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        c5.f10461e.setText(getString(R.string.tos_title));
        c5.getRoot().setOnClickListener(new C1512n(this));
        S3().f10221b.addView(c5.getRoot());
        C1668h0 c6 = C1668h0.c(getLayoutInflater());
        m.d(c6, "inflate(...)");
        RelativeLayout b6 = c6.getRoot();
        RelativeLayout.LayoutParams layoutParams3 = this.f18811K;
        if (layoutParams3 == null) {
            m.u("lp");
        } else {
            layoutParams2 = layoutParams3;
        }
        b6.setLayoutParams(layoutParams2);
        c6.f10461e.setTypeface(aVar.w());
        c6.f10461e.setText(getString(R.string.privacy_policy_title));
        c6.getRoot().setOnClickListener(new C1513o(this));
        S3().f10221b.addView(c6.getRoot());
    }

    /* access modifiers changed from: private */
    public static final void a4(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        String string = advancedPreferencesActivity.getString(R.string.tos_title);
        m.d(string, "getString(...)");
        String string2 = advancedPreferencesActivity.getString(R.string.url_tos);
        m.d(string2, "getString(...)");
        new q().q(advancedPreferencesActivity, string2, string);
    }

    /* access modifiers changed from: private */
    public static final void b4(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        String string = advancedPreferencesActivity.getString(R.string.privacy_policy_title);
        m.d(string, "getString(...)");
        String string2 = advancedPreferencesActivity.getString(R.string.url_privacy);
        m.d(string2, "getString(...)");
        new q().q(advancedPreferencesActivity, string2, string);
    }

    private final void y3() {
        C1668h0 c5 = C1668h0.c(getLayoutInflater());
        m.d(c5, "inflate(...)");
        RelativeLayout b5 = c5.getRoot();
        RelativeLayout.LayoutParams layoutParams = this.f18811K;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            m.u("lp");
            layoutParams = null;
        }
        b5.setLayoutParams(layoutParams);
        TextView textView = c5.f10461e;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        c5.f10461e.setText(getString(R.string.version_label));
        c5.f10460d.setTypeface(aVar.x());
        c5.f10460d.setText(getString(R.string.version, new Object[]{getString(R.string.app_name), "6.71", "671"}));
        c5.f10460d.setVisibility(0);
        c5.f10458b.setVisibility(8);
        c5.getRoot().setOnClickListener(new C1506h(new A(), this, c5));
        S3().f10221b.addView(c5.getRoot());
        C1668h0 c6 = C1668h0.c(getLayoutInflater());
        m.d(c6, "inflate(...)");
        RelativeLayout b6 = c6.getRoot();
        RelativeLayout.LayoutParams layoutParams3 = this.f18811K;
        if (layoutParams3 == null) {
            m.u("lp");
            layoutParams3 = null;
        }
        b6.setLayoutParams(layoutParams3);
        c6.f10461e.setTypeface(aVar.w());
        c6.f10461e.setText(getString(R.string.publication_date));
        c6.f10460d.setTypeface(aVar.x());
        c6.f10460d.setText("Jun 18, 2025 12:14");
        c6.f10460d.setVisibility(0);
        c6.f10458b.setVisibility(8);
        c6.getRoot().setOnClickListener(new C1507i());
        S3().f10221b.addView(c6.getRoot());
        C1668h0 c7 = C1668h0.c(getLayoutInflater());
        m.d(c7, "inflate(...)");
        RelativeLayout b7 = c7.getRoot();
        RelativeLayout.LayoutParams layoutParams4 = this.f18811K;
        if (layoutParams4 == null) {
            m.u("lp");
            layoutParams4 = null;
        }
        b7.setLayoutParams(layoutParams4);
        c7.f10461e.setTypeface(aVar.w());
        c7.f10461e.setText("Uptodown Core");
        c7.f10460d.setTypeface(aVar.x());
        c7.f10460d.setText("0.2.51");
        c7.f10460d.setVisibility(0);
        c7.f10458b.setVisibility(8);
        c7.getRoot().setOnClickListener(new C1508j());
        S3().f10221b.addView(c7.getRoot());
        if (UptodownApp.f17422D.K()) {
            C1668h0 c8 = C1668h0.c(getLayoutInflater());
            m.d(c8, "inflate(...)");
            RelativeLayout b8 = c8.getRoot();
            RelativeLayout.LayoutParams layoutParams5 = this.f18811K;
            if (layoutParams5 == null) {
                m.u("lp");
                layoutParams5 = null;
            }
            b8.setLayoutParams(layoutParams5);
            c8.f10461e.setTypeface(aVar.w());
            c8.f10461e.setText("Console");
            c8.getRoot().setOnClickListener(new C1509k(this));
            S3().f10221b.addView(c8.getRoot());
            U e5 = U.f20468m.e(this);
            if (e5 != null) {
                C1668h0 c9 = C1668h0.c(getLayoutInflater());
                m.d(c9, "inflate(...)");
                RelativeLayout b9 = c9.getRoot();
                RelativeLayout.LayoutParams layoutParams6 = this.f18811K;
                if (layoutParams6 == null) {
                    m.u("lp");
                } else {
                    layoutParams2 = layoutParams6;
                }
                b9.setLayoutParams(layoutParams2);
                c9.f10461e.setTypeface(aVar.w());
                c9.f10458b.setVisibility(8);
                c9.f10461e.setText("userID: " + e5.g());
                c9.getRoot().setOnClickListener(new C1511m(this, e5));
                S3().f10221b.addView(c9.getRoot());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void z3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        advancedPreferencesActivity.startActivity(new Intent(advancedPreferencesActivity, K1.a.class), UptodownApp.f17422D.a(advancedPreferencesActivity));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) S3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            S3().f10223d.setNavigationIcon(drawable);
            S3().f10223d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        S3().f10223d.setNavigationOnClickListener(new C1499a(this));
        S3().f10224e.setTypeface(k.f7778g.w());
        int dimension = (int) getResources().getDimension(R.dimen.margin_s);
        int i4 = -1;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        this.f18811K = layoutParams;
        layoutParams.setMargins(0, dimension, 0, dimension);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("advanced_settings_title")) {
                S3().f10224e.setText(extras.getString("advanced_settings_title"));
            }
            if (extras.containsKey("advanced_settings_index")) {
                i4 = extras.getInt("advanced_settings_index");
            }
        }
        if (i4 == 0) {
            Z3();
        } else if (i4 == 1) {
            P3();
        } else if (i4 == 2) {
            y3();
        } else if (i4 == 3) {
            T3();
        } else if (i4 == 4) {
            F3();
        }
    }
}
