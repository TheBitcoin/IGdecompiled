package com.uptodown.activities;

import J1.P;
import J1.Q;
import J1.S;
import J1.T;
import J1.U;
import J1.V;
import J1.W;
import J1.X;
import J1.Y;
import J1.Z;
import N1.k;
import R2.g;
import R2.h;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import c2.i1;
import com.inmobi.cmp.ChoiceCmp;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import kotlin.jvm.internal.m;
import u2.K;
import u2.q;
import u2.x;

public final class GdprPrivacySettings extends C1826a {

    /* renamed from: J  reason: collision with root package name */
    private final g f17710J = h.a(new P(this));

    /* access modifiers changed from: private */
    public static final i1 k3(GdprPrivacySettings gdprPrivacySettings) {
        return i1.c(gdprPrivacySettings.getLayoutInflater());
    }

    private final i1 l3() {
        return (i1) this.f17710J.getValue();
    }

    /* access modifiers changed from: private */
    public static final void m3(GdprPrivacySettings gdprPrivacySettings, View view) {
        gdprPrivacySettings.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void n3(GdprPrivacySettings gdprPrivacySettings, CompoundButton compoundButton, boolean z4) {
        SwitchCompat switchCompat = gdprPrivacySettings.l3().f10562k;
        m.d(switchCompat, "sAnalyticsWizardPrivacy");
        TextView textView = gdprPrivacySettings.l3().f10569r;
        m.d(textView, "tvDescriptionAnalyticsWizardPrivacy");
        gdprPrivacySettings.y3(switchCompat, textView, z4);
        gdprPrivacySettings.w3();
    }

    /* access modifiers changed from: private */
    public static final void o3(GdprPrivacySettings gdprPrivacySettings, CompoundButton compoundButton, boolean z4) {
        SwitchCompat switchCompat = gdprPrivacySettings.l3().f10564m;
        m.d(switchCompat, "sErrorLogWizardPrivacy");
        TextView textView = gdprPrivacySettings.l3().f10571t;
        m.d(textView, "tvDescriptionErrorLogWizardPrivacy");
        gdprPrivacySettings.y3(switchCompat, textView, z4);
        gdprPrivacySettings.w3();
    }

    /* access modifiers changed from: private */
    public static final void p3(GdprPrivacySettings gdprPrivacySettings, View view) {
        gdprPrivacySettings.u3();
    }

    /* access modifiers changed from: private */
    public static final void q3(GdprPrivacySettings gdprPrivacySettings, CompoundButton compoundButton, boolean z4) {
        SwitchCompat switchCompat = gdprPrivacySettings.l3().f10563l;
        m.d(switchCompat, "sDeviceAnalysisWizardPrivacy");
        TextView textView = gdprPrivacySettings.l3().f10570s;
        m.d(textView, "tvDescriptionDeviceAnalysisWizardPrivacy");
        gdprPrivacySettings.y3(switchCompat, textView, z4);
        gdprPrivacySettings.w3();
        if (!gdprPrivacySettings.l3().f10563l.isChecked()) {
            gdprPrivacySettings.l3().f10551C.setVisibility(0);
        } else {
            gdprPrivacySettings.l3().f10551C.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public static final void r3(GdprPrivacySettings gdprPrivacySettings, View view) {
        if (!gdprPrivacySettings.isFinishing()) {
            q qVar = new q();
            String string = gdprPrivacySettings.getString(R.string.url_contact);
            m.d(string, "getString(...)");
            q.r(qVar, gdprPrivacySettings, string, (String) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void s3(GdprPrivacySettings gdprPrivacySettings, View view) {
        new K().a(gdprPrivacySettings, true);
        new K().b(false);
        gdprPrivacySettings.l3().f10563l.setChecked(true);
        gdprPrivacySettings.l3().f10562k.setChecked(true);
        gdprPrivacySettings.l3().f10564m.setChecked(true);
        gdprPrivacySettings.v3();
        gdprPrivacySettings.finish();
    }

    /* access modifiers changed from: private */
    public static final void t3(GdprPrivacySettings gdprPrivacySettings, View view) {
        gdprPrivacySettings.w3();
        gdprPrivacySettings.l3().f10563l.setChecked(false);
        gdprPrivacySettings.l3().f10562k.setChecked(false);
        gdprPrivacySettings.l3().f10564m.setChecked(false);
    }

    private final void u3() {
        ChoiceCmp.forceDisplayUI(this);
        ChoiceCmp.showUSRegulationScreen(this);
    }

    private final void v3() {
        boolean isChecked = l3().f10564m.isChecked();
        a.C0236a aVar = a.f18818a;
        if (aVar.O(this) != isChecked) {
            aVar.x0(this, isChecked);
        }
        boolean isChecked2 = l3().f10562k.isChecked();
        if (aVar.M(this) != isChecked2) {
            aVar.r0(this, isChecked2);
        }
        boolean isChecked3 = l3().f10563l.isChecked();
        if (aVar.i0(this) != isChecked3) {
            aVar.j1(this, isChecked3);
        }
        x xVar = new x(this);
        if (aVar.i0(this)) {
            UptodownApp.a aVar2 = UptodownApp.f17422D;
            UptodownApp.a.P0(aVar2, this, false, 2, (Object) null);
            aVar2.I(this);
            xVar.b();
            setResult(-1);
            return;
        }
        setResult(0);
    }

    private final void w3() {
        if (l3().f10567p.getVisibility() == 0) {
            l3().f10565n.setText(R.string.save);
            l3().f10565n.setOnClickListener(new Z(this));
            l3().f10567p.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public static final void x3(GdprPrivacySettings gdprPrivacySettings, View view) {
        gdprPrivacySettings.v3();
        gdprPrivacySettings.finish();
    }

    private final void y3(SwitchCompat switchCompat, TextView textView, boolean z4) {
        if (z4) {
            switchCompat.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
            textView.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
            return;
        }
        switchCompat.setTextColor(ContextCompat.getColor(this, R.color.main_light_grey));
        textView.setTextColor(ContextCompat.getColor(this, R.color.main_light_grey));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) l3().getRoot());
        l3().f10553b.setOnClickListener(new Q(this));
        TextView textView = l3().f10573v;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        l3().f10550B.setTypeface(aVar.w());
        l3().f10566o.setTypeface(aVar.x());
        l3().f10576y.setTypeface(aVar.w());
        l3().f10570s.setTypeface(aVar.x());
        l3().f10575x.setTypeface(aVar.w());
        l3().f10569r.setTypeface(aVar.x());
        l3().f10577z.setTypeface(aVar.w());
        l3().f10571t.setTypeface(aVar.x());
        l3().f10574w.setTypeface(aVar.w());
        l3().f10568q.setTypeface(aVar.x());
        l3().f10549A.setTypeface(aVar.w());
        l3().f10572u.setTypeface(aVar.x());
        l3().f10565n.setTypeface(aVar.w());
        l3().f10567p.setTypeface(aVar.w());
        TextView textView2 = l3().f10551C;
        textView2.setText("⚠ " + getString(R.string.tracking_disabled_warning_gdpr) + " ⚠");
        l3().f10551C.setTypeface(aVar.x());
        SwitchCompat switchCompat = l3().f10562k;
        a.C0236a aVar2 = a.f18818a;
        switchCompat.setChecked(aVar2.M(this));
        l3().f10564m.setChecked(aVar2.O(this));
        l3().f10563l.setChecked(aVar2.i0(this));
        if (aVar2.T(this)) {
            SwitchCompat switchCompat2 = l3().f10562k;
            m.d(switchCompat2, "sAnalyticsWizardPrivacy");
            TextView textView3 = l3().f10569r;
            m.d(textView3, "tvDescriptionAnalyticsWizardPrivacy");
            y3(switchCompat2, textView3, l3().f10562k.isChecked());
            SwitchCompat switchCompat3 = l3().f10564m;
            m.d(switchCompat3, "sErrorLogWizardPrivacy");
            TextView textView4 = l3().f10571t;
            m.d(textView4, "tvDescriptionErrorLogWizardPrivacy");
            y3(switchCompat3, textView4, l3().f10564m.isChecked());
            SwitchCompat switchCompat4 = l3().f10563l;
            m.d(switchCompat4, "sDeviceAnalysisWizardPrivacy");
            TextView textView5 = l3().f10570s;
            m.d(textView5, "tvDescriptionDeviceAnalysisWizardPrivacy");
            y3(switchCompat4, textView5, l3().f10563l.isChecked());
        } else {
            SwitchCompat switchCompat5 = l3().f10562k;
            m.d(switchCompat5, "sAnalyticsWizardPrivacy");
            TextView textView6 = l3().f10569r;
            m.d(textView6, "tvDescriptionAnalyticsWizardPrivacy");
            y3(switchCompat5, textView6, true);
            SwitchCompat switchCompat6 = l3().f10564m;
            m.d(switchCompat6, "sErrorLogWizardPrivacy");
            TextView textView7 = l3().f10571t;
            m.d(textView7, "tvDescriptionErrorLogWizardPrivacy");
            y3(switchCompat6, textView7, true);
            SwitchCompat switchCompat7 = l3().f10563l;
            m.d(switchCompat7, "sDeviceAnalysisWizardPrivacy");
            TextView textView8 = l3().f10570s;
            m.d(textView8, "tvDescriptionDeviceAnalysisWizardPrivacy");
            y3(switchCompat7, textView8, true);
            l3().f10562k.setChecked(true);
            l3().f10564m.setChecked(true);
            l3().f10563l.setChecked(true);
        }
        if (!l3().f10563l.isChecked()) {
            l3().f10551C.setVisibility(0);
        } else {
            l3().f10551C.setVisibility(8);
        }
        l3().f10562k.setOnCheckedChangeListener(new S(this));
        l3().f10564m.setOnCheckedChangeListener(new T(this));
        l3().f10555d.setOnClickListener(new U(this));
        l3().f10563l.setOnCheckedChangeListener(new V(this));
        l3().f10560i.setOnClickListener(new W(this));
        l3().f10565n.setOnClickListener(new X(this));
        l3().f10567p.setOnClickListener(new Y(this));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        a.C0236a aVar = a.f18818a;
        if (!aVar.T(this)) {
            aVar.G0(this, true);
            aVar.r0(this, true);
            aVar.x0(this, true);
            aVar.j1(this, true);
        }
    }
}
