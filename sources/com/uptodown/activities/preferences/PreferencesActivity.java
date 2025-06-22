package com.uptodown.activities.preferences;

import L1.B;
import L1.C;
import L1.C1523z;
import L1.D;
import L1.E;
import L1.F;
import L1.G;
import L1.I;
import L1.J;
import L1.K;
import L1.L;
import L1.M;
import L1.N;
import L1.O;
import L1.Q;
import L1.S;
import L1.T;
import L1.U;
import L1.V;
import L1.W;
import L1.X;
import L1.Y;
import L1.Z;
import L1.a0;
import L1.b0;
import L1.c0;
import L1.d0;
import L1.e0;
import L1.f0;
import L1.g0;
import L1.h0;
import L1.i0;
import L1.j0;
import L1.k0;
import L1.l0;
import L1.m0;
import L1.n0;
import L1.o0;
import L1.p0;
import L1.q0;
import L1.r0;
import N1.k;
import R2.g;
import R2.h;
import R2.p;
import R2.s;
import S2.H;
import W1.i;
import W1.t;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
import c2.C1670i0;
import c2.C1676l0;
import c2.C1696w;
import c2.D0;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1826a;
import com.uptodown.activities.GdprPrivacySettings;
import com.uptodown.activities.LanguageSettingsActivity;
import com.uptodown.activities.preferences.a;
import com.uptodown.tv.preferences.TvPrivacyPreferences;
import d3.l;
import g2.P;
import g2.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import u2.C2313C;
import u2.q;
import u2.w;
import y2.n;

public final class PreferencesActivity extends C1826a {

    /* renamed from: O  reason: collision with root package name */
    public static final a f18812O = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private final g f18813J = h.a(new C1523z(this));

    /* renamed from: K  reason: collision with root package name */
    private final P1.a f18814K = new P1.a(this);

    /* renamed from: L  reason: collision with root package name */
    private P f18815L;

    /* renamed from: M  reason: collision with root package name */
    private final ActivityResultLauncher f18816M;

    /* renamed from: N  reason: collision with root package name */
    private final ActivityResultLauncher f18817N;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public PreferencesActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new K(this));
        m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f18816M = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new W(this));
        m.d(registerForActivityResult2, "registerForActivityResult(...)");
        this.f18817N = registerForActivityResult2;
    }

    /* access modifiers changed from: private */
    public static final s A4(PreferencesActivity preferencesActivity, C1670i0 i0Var, int i4) {
        boolean z4;
        a.C0236a aVar = a.f18818a;
        if (i4 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        aVar.b1(preferencesActivity, z4);
        if (i4 == 0) {
            i0Var.f10547c.setText(preferencesActivity.getString(R.string.internal_storage));
        } else {
            i0Var.f10547c.setText(preferencesActivity.getString(R.string.sd_card));
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void B4(PreferencesActivity preferencesActivity, View view) {
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.S(preferencesActivity)) {
            preferencesActivity.startActivity(new Intent(preferencesActivity, TvPrivacyPreferences.class));
        } else {
            preferencesActivity.startActivity(new Intent(preferencesActivity, GdprPrivacySettings.class), aVar.a(preferencesActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final void C4(PreferencesActivity preferencesActivity, View view) {
        Intent intent = new Intent(preferencesActivity, AdvancedPreferencesActivity.class);
        intent.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
        intent.putExtra("advanced_settings_index", 3);
        preferencesActivity.startActivity(intent, UptodownApp.f17422D.a(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final void D4(PreferencesActivity preferencesActivity, View view) {
        Intent intent = new Intent(preferencesActivity, AdvancedPreferencesActivity.class);
        intent.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
        intent.putExtra("advanced_settings_index", 0);
        preferencesActivity.startActivity(intent, UptodownApp.f17422D.a(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final void E4(PreferencesActivity preferencesActivity, View view) {
        Intent intent = new Intent(preferencesActivity, AdvancedPreferencesActivity.class);
        intent.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
        intent.putExtra("advanced_settings_index", 1);
        preferencesActivity.startActivity(intent, UptodownApp.f17422D.a(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final void F4(PreferencesActivity preferencesActivity, View view) {
        String string = preferencesActivity.getString(R.string.privacy_policy_title);
        m.d(string, "getString(...)");
        String string2 = preferencesActivity.getString(R.string.url_advertising);
        m.d(string2, "getString(...)");
        new q().q(preferencesActivity, string2, string);
    }

    /* access modifiers changed from: private */
    public static final void G4(PreferencesActivity preferencesActivity, View view) {
        Intent intent = new Intent(preferencesActivity, AdvancedPreferencesActivity.class);
        intent.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
        intent.putExtra("advanced_settings_index", 2);
        preferencesActivity.startActivity(intent, UptodownApp.f17422D.a(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final void H4(PreferencesActivity preferencesActivity, View view) {
        Intent intent = new Intent(preferencesActivity, AdvancedPreferencesActivity.class);
        intent.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
        intent.putExtra("advanced_settings_index", 4);
        preferencesActivity.startActivity(intent, UptodownApp.f17422D.a(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final void I4(PreferencesActivity preferencesActivity, HashMap hashMap, View view) {
        if (preferencesActivity.X3().f10623G.f10612c.isChecked()) {
            String string = preferencesActivity.getString(R.string.download_updates_automatically_title);
            m.d(string, "getString(...)");
            preferencesActivity.T3(string, hashMap, Integer.parseInt(a.f18818a.m(preferencesActivity)), new e0(preferencesActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final s J4(PreferencesActivity preferencesActivity, int i4) {
        a.f18818a.E0(preferencesActivity, String.valueOf(i4));
        preferencesActivity.X3().f10623G.f10613d.setText(preferencesActivity.Y3());
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void K4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        if (z4) {
            n nVar = new n(preferencesActivity);
            RelativeLayout b5 = preferencesActivity.X3().f10623G.getRoot();
            m.d(b5, "getRoot(...)");
            nVar.d(b5, 1.0f);
            n nVar2 = new n(preferencesActivity);
            RelativeLayout b6 = preferencesActivity.X3().f10622F.getRoot();
            m.d(b6, "getRoot(...)");
            nVar2.d(b6, 1.0f);
            a.f18818a.E0(preferencesActivity, "2");
            preferencesActivity.X3().f10623G.f10613d.setText(preferencesActivity.Y3());
            return;
        }
        n nVar3 = new n(preferencesActivity);
        RelativeLayout b7 = preferencesActivity.X3().f10623G.getRoot();
        m.d(b7, "getRoot(...)");
        nVar3.d(b7, 0.3f);
        n nVar4 = new n(preferencesActivity);
        RelativeLayout b8 = preferencesActivity.X3().f10622F.getRoot();
        m.d(b8, "getRoot(...)");
        nVar4.d(b8, 0.3f);
        a.f18818a.E0(preferencesActivity, "0");
        preferencesActivity.X3().f10623G.f10613d.setText(preferencesActivity.getString(R.string.preference_updates_disabled));
    }

    /* access modifiers changed from: private */
    public static final void L4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.X3().f10637n.f10590c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void M4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        new P1.a(preferencesActivity).G(z4);
    }

    /* access modifiers changed from: private */
    public static final void N4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.X3().f10633j.f10590c.performClick();
    }

    private final void O4() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 646);
        }
    }

    private final void P4() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.f18817N.launch("android.permission.POST_NOTIFICATIONS");
            return;
        }
        a.f18818a.X0(this, true);
        R4();
    }

    /* access modifiers changed from: private */
    public static final void Q4(PreferencesActivity preferencesActivity, boolean z4) {
        if (z4) {
            a.f18818a.X0(preferencesActivity, true);
            preferencesActivity.R4();
            return;
        }
        preferencesActivity.X3().f10617A.f10590c.setChecked(false);
        preferencesActivity.a4();
        a.C0236a aVar = a.f18818a;
        int B4 = aVar.B(preferencesActivity) + 1;
        aVar.W0(preferencesActivity, B4);
        if (Build.VERSION.SDK_INT >= 33 && B4 >= 2 && !C2313C.f21882a.u(preferencesActivity)) {
            preferencesActivity.S4();
        }
    }

    private final void R4() {
        X3().f10617A.f10591d.setText(getString(R.string.enabled));
        if (m.a(a.f18818a.m(this), "0")) {
            n nVar = new n(this);
            RelativeLayout b5 = X3().f10622F.getRoot();
            m.d(b5, "getRoot(...)");
            nVar.d(b5, 0.3f);
        } else {
            n nVar2 = new n(this);
            RelativeLayout b6 = X3().f10622F.getRoot();
            m.d(b6, "getRoot(...)");
            nVar2.d(b6, 1.0f);
        }
        n nVar3 = new n(this);
        RelativeLayout b7 = X3().f10634k.getRoot();
        m.d(b7, "getRoot(...)");
        nVar3.d(b7, 1.0f);
        X3().f10634k.f10590c.setClickable(true);
        n nVar4 = new n(this);
        RelativeLayout b8 = X3().f10638o.getRoot();
        m.d(b8, "getRoot(...)");
        nVar4.d(b8, 1.0f);
        X3().f10638o.f10590c.setClickable(true);
        n nVar5 = new n(this);
        RelativeLayout b9 = X3().f10637n.getRoot();
        m.d(b9, "getRoot(...)");
        nVar5.d(b9, 1.0f);
        X3().f10637n.f10590c.setClickable(true);
    }

    /* access modifiers changed from: private */
    public static final C1676l0 S3(PreferencesActivity preferencesActivity) {
        return C1676l0.c(preferencesActivity.getLayoutInflater());
    }

    private final void S4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title_notification_dialog_permission);
        builder.setMessage(R.string.description_notification_dialog_permission);
        builder.setPositiveButton(R.string.button_notification_dialog_permission, new f0(this));
        builder.create().show();
    }

    private final void T3(String str, HashMap hashMap, int i4, l lVar) {
        if (!isFinishing()) {
            AlertDialog j22 = j2();
            if (j22 != null) {
                j22.dismiss();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C1696w c5 = C1696w.c(getLayoutInflater());
            m.d(c5, "inflate(...)");
            A a5 = new A();
            a5.f20966a = i4;
            c5.f10830d.setTypeface(k.f7778g.w());
            c5.f10830d.setText(str);
            for (Map.Entry entry : hashMap.entrySet()) {
                D0 c6 = D0.c(getLayoutInflater());
                m.d(c6, "inflate(...)");
                c6.getRoot().setId(((Number) entry.getKey()).intValue());
                c6.f9719b.setTypeface(k.f7778g.x());
                c6.f9719b.setText((CharSequence) entry.getValue());
                c6.getRoot().setOnClickListener(new k0(a5, entry));
                if (((Number) entry.getKey()).intValue() == i4) {
                    c6.f9719b.setChecked(true);
                }
                c5.f10828b.addView(c6.getRoot());
            }
            c5.f10829c.setTypeface(k.f7778g.w());
            c5.f10829c.setOnClickListener(new l0(lVar, a5, this));
            builder.setView(c5.getRoot());
            J2(builder.create());
            if (!isFinishing() && j2() != null) {
                AlertDialog j23 = j2();
                m.b(j23);
                j23.setCancelable(true);
                W2();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void T4(PreferencesActivity preferencesActivity, DialogInterface dialogInterface, int i4) {
        preferencesActivity.O4();
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void U3(A a5, Map.Entry entry, View view) {
        a5.f20966a = ((Number) entry.getKey()).intValue();
    }

    /* access modifiers changed from: private */
    public static final void V3(l lVar, A a5, PreferencesActivity preferencesActivity, View view) {
        lVar.invoke(Integer.valueOf(a5.f20966a));
        preferencesActivity.i2();
    }

    private final String W3() {
        int f4 = a.f18818a.f(this);
        if (f4 == -1) {
            String string = getString(R.string.setting_play_video_array_never);
            m.d(string, "getString(...)");
            return string;
        } else if (f4 == 0) {
            String string2 = getString(R.string.setting_play_video_array_only_wifi);
            m.d(string2, "getString(...)");
            return string2;
        } else if (f4 != 1) {
            return "";
        } else {
            String string3 = getString(R.string.setting_play_video_array_wifi_and_data);
            m.d(string3, "getString(...)");
            return string3;
        }
    }

    private final C1676l0 X3() {
        return (C1676l0) this.f18813J.getValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String Y3() {
        /*
            r7 = this;
            com.uptodown.activities.preferences.a$a r0 = com.uptodown.activities.preferences.a.f18818a
            java.lang.String r1 = r0.m(r7)
            int r2 = r1.hashCode()
            r3 = 2131952496(0x7f130370, float:1.9541436E38)
            java.lang.String r4 = "2"
            switch(r2) {
                case 48: goto L_0x0030;
                case 49: goto L_0x001f;
                case 50: goto L_0x0013;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0038
        L_0x0013:
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x001a
            goto L_0x0038
        L_0x001a:
            java.lang.String r0 = r7.getString(r3)
            goto L_0x0047
        L_0x001f:
            java.lang.String r2 = "1"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0028
            goto L_0x0038
        L_0x0028:
            r0 = 2131952504(0x7f130378, float:1.9541453E38)
            java.lang.String r0 = r7.getString(r0)
            goto L_0x0047
        L_0x0030:
            java.lang.String r2 = "0"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0040
        L_0x0038:
            r0.E0(r7, r4)
            java.lang.String r0 = r7.getString(r3)
            goto L_0x0047
        L_0x0040:
            r0 = 2131952509(0x7f13037d, float:1.9541463E38)
            java.lang.String r0 = r7.getString(r0)
        L_0x0047:
            r1 = 0
            java.io.File r2 = r7.getExternalFilesDir(r1)
            if (r2 == 0) goto L_0x0056
            long r1 = r2.getUsableSpace()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
        L_0x0056:
            java.lang.String r2 = "\n⚠ "
            if (r1 != 0) goto L_0x0074
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r2)
            r0 = 2131951995(0x7f13017b, float:1.954042E38)
            java.lang.String r0 = r7.getString(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        L_0x0074:
            long r3 = r1.longValue()
            r5 = 262144000(0xfa00000, double:1.295163447E-315)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x0098
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r2)
            r0 = 2131952006(0x7f130186, float:1.9540443E38)
            java.lang.String r0 = r7.getString(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x0098:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.preferences.PreferencesActivity.Y3():java.lang.String");
    }

    private final String Z3() {
        int parseInt = Integer.parseInt(a.f18818a.z(this));
        if (parseInt == 1) {
            return getString(R.string.updates_notification_description_always);
        }
        if (parseInt == 2) {
            return getString(R.string.updates_notification_description_daily);
        }
        if (parseInt == 3) {
            return getString(R.string.updates_notification_description_weekly);
        }
        if (parseInt != 4) {
            return "";
        }
        return getString(R.string.updates_notification_description_never);
    }

    private final void a4() {
        X3().f10617A.f10591d.setText(getString(R.string.disabled));
        n nVar = new n(this);
        RelativeLayout b5 = X3().f10622F.getRoot();
        m.d(b5, "getRoot(...)");
        nVar.d(b5, 0.3f);
        n nVar2 = new n(this);
        RelativeLayout b6 = X3().f10634k.getRoot();
        m.d(b6, "getRoot(...)");
        nVar2.d(b6, 0.3f);
        X3().f10634k.f10590c.setClickable(false);
        n nVar3 = new n(this);
        RelativeLayout b7 = X3().f10638o.getRoot();
        m.d(b7, "getRoot(...)");
        nVar3.d(b7, 0.3f);
        X3().f10638o.f10590c.setClickable(false);
        n nVar4 = new n(this);
        RelativeLayout b8 = X3().f10637n.getRoot();
        m.d(b8, "getRoot(...)");
        nVar4.d(b8, 0.3f);
        X3().f10637n.f10590c.setClickable(false);
    }

    /* access modifiers changed from: private */
    public static final void b4(PreferencesActivity preferencesActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 1003) {
            preferencesActivity.setResult(PointerIconCompat.TYPE_HELP);
            preferencesActivity.finish();
            preferencesActivity.startActivity(preferencesActivity.getIntent());
        }
    }

    /* access modifiers changed from: private */
    public static final void c4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        a.f18818a.A0(preferencesActivity, z4);
    }

    /* access modifiers changed from: private */
    public static final void d4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.X3().f10629f.f10590c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void e4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        a.f18818a.s0(preferencesActivity, z4);
    }

    /* access modifiers changed from: private */
    public static final void f4(PreferencesActivity preferencesActivity, HashMap hashMap, View view) {
        String string = preferencesActivity.getString(R.string.setting_title_play_video_app_details);
        m.d(string, "getString(...)");
        preferencesActivity.T3(string, hashMap, a.f18818a.f(preferencesActivity), new g0(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final s g4(PreferencesActivity preferencesActivity, int i4) {
        a.f18818a.v0(preferencesActivity, String.valueOf(i4));
        preferencesActivity.X3().f10630g.f10547c.setText(preferencesActivity.W3());
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void h4(PreferencesActivity preferencesActivity, HashMap hashMap, View view) {
        String string = preferencesActivity.getString(R.string.data_saver_preference_subtitle);
        m.d(string, "getString(...)");
        preferencesActivity.T3(string, hashMap, a.f18818a.k(preferencesActivity), new i0(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final s i4(PreferencesActivity preferencesActivity, int i4) {
        a.C0236a aVar = a.f18818a;
        if (aVar.k(preferencesActivity) != i4) {
            aVar.z0(preferencesActivity, String.valueOf(i4));
            preferencesActivity.setResult(PointerIconCompat.TYPE_WAIT);
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void j4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.X3().f10643t.f10590c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void k4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        a.f18818a.Z0(preferencesActivity, z4);
    }

    /* access modifiers changed from: private */
    public static final void l4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.X3().f10631h.f10590c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void m4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void n4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        a.f18818a.J0(preferencesActivity, z4);
        if (z4) {
            try {
                t.f8713a.d();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void o4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.X3().f10647x.f10590c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void p4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        a.f18818a.a1(preferencesActivity, z4);
        if (z4) {
            preferencesActivity.f18814K.M(true);
        }
    }

    /* access modifiers changed from: private */
    public static final void q4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.X3().f10617A.f10590c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void r4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        if (z4) {
            preferencesActivity.R4();
            preferencesActivity.P4();
            return;
        }
        preferencesActivity.a4();
        a.f18818a.X0(preferencesActivity, false);
    }

    /* access modifiers changed from: private */
    public static final void s4(PreferencesActivity preferencesActivity, HashMap hashMap, View view) {
        String string = preferencesActivity.getString(R.string.updates);
        m.d(string, "getString(...)");
        preferencesActivity.T3(string, hashMap, Integer.parseInt(a.f18818a.z(preferencesActivity)), new j0(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final s t4(PreferencesActivity preferencesActivity, int i4) {
        a.f18818a.V0(preferencesActivity, String.valueOf(i4));
        preferencesActivity.X3().f10622F.f10547c.setText(preferencesActivity.Z3());
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void u4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.X3().f10634k.f10590c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void v4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        a.f18818a.D0(preferencesActivity, z4);
    }

    /* access modifiers changed from: private */
    public static final void w4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.X3().f10638o.f10590c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void x4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.f18816M.launch(new Intent(preferencesActivity, LanguageSettingsActivity.class), UptodownApp.f17422D.b(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final void y4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        a.f18818a.K0(preferencesActivity, z4);
    }

    /* access modifiers changed from: private */
    public static final void z4(PreferencesActivity preferencesActivity, HashMap hashMap, A a5, C1670i0 i0Var, View view) {
        String string = preferencesActivity.getString(R.string.select_downloads_path);
        m.d(string, "getString(...)");
        preferencesActivity.T3(string, hashMap, a5.f20966a, new d0(preferencesActivity, i0Var));
    }

    public void finish() {
        P p4 = new P(this);
        if (!p4.b(this.f18815L)) {
            r rVar = new r();
            rVar.j(this);
            p4.k(this, rVar);
        }
        super.finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView((View) X3().getRoot());
        this.f18815L = new P(this);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            X3().f10618B.setNavigationIcon(drawable);
            X3().f10618B.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        X3().f10618B.setNavigationOnClickListener(new h0(this));
        TextView textView = X3().f10620D;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        X3().f10639p.f10461e.setTypeface(aVar.w());
        X3().f10639p.f10461e.setText(getString(R.string.item_menu_idioma));
        X3().f10639p.f10460d.setTypeface(aVar.x());
        X3().f10639p.f10460d.setVisibility(0);
        String p4 = a.f18818a.p(this);
        String[] stringArray = getResources().getStringArray(R.array.languageCodes);
        m.d(stringArray, "getStringArray(...)");
        String[] stringArray2 = getResources().getStringArray(R.array.localizedLang);
        m.d(stringArray2, "getStringArray(...)");
        int length = stringArray.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                str = "";
                break;
            } else if (stringArray[i4].equals(p4)) {
                str = stringArray2[i4];
                break;
            } else {
                i4++;
            }
        }
        X3().f10639p.f10460d.setText(str);
        X3().f10639p.getRoot().setOnClickListener(new E(this));
        TextView textView2 = X3().f10621E.f10442b;
        k.a aVar2 = k.f7778g;
        textView2.setTypeface(aVar2.w());
        X3().f10621E.f10442b.setText(getString(R.string.updates));
        X3().f10623G.f10614e.setTypeface(aVar2.w());
        X3().f10623G.f10614e.setText(getString(R.string.updates));
        X3().f10623G.f10613d.setTypeface(aVar2.x());
        X3().f10623G.f10613d.setText(Y3());
        X3().f10623G.getRoot().setOnClickListener(new Q(this, H.i(p.a(Integer.valueOf(Integer.parseInt("1")), getString(R.string.preference_only_notify)), p.a(Integer.valueOf(Integer.parseInt("2")), getString(R.string.pref_auto_update_title)))));
        a.C0236a aVar3 = a.f18818a;
        if (m.a(aVar3.m(this), "0")) {
            n nVar = new n(this);
            RelativeLayout b5 = X3().f10623G.getRoot();
            m.d(b5, "getRoot(...)");
            nVar.d(b5, 0.3f);
            n nVar2 = new n(this);
            RelativeLayout b6 = X3().f10622F.getRoot();
            m.d(b6, "getRoot(...)");
            nVar2.d(b6, 0.3f);
            X3().f10623G.f10612c.setChecked(false);
        } else {
            n nVar3 = new n(this);
            RelativeLayout b7 = X3().f10623G.getRoot();
            m.d(b7, "getRoot(...)");
            nVar3.d(b7, 1.0f);
            n nVar4 = new n(this);
            RelativeLayout b8 = X3().f10622F.getRoot();
            m.d(b8, "getRoot(...)");
            nVar4.d(b8, 1.0f);
            X3().f10623G.f10612c.setChecked(true);
        }
        X3().f10623G.f10612c.setOnCheckedChangeListener(new V(this));
        X3().f10636m.f10442b.setTypeface(aVar2.w());
        X3().f10636m.f10442b.setText(getString(R.string.preference_file_management));
        X3().f10637n.getRoot().setOnClickListener(new X(this));
        X3().f10637n.f10592e.setTypeface(aVar2.w());
        X3().f10637n.f10592e.setText(getString(R.string.search_apk_file_worker_preference_title));
        X3().f10637n.f10591d.setTypeface(aVar2.x());
        X3().f10637n.f10591d.setText(getString(R.string.preference_locate_files_in_storage));
        X3().f10637n.f10590c.setChecked(new P1.a(this).p());
        X3().f10637n.f10590c.setOnCheckedChangeListener(new Y(this));
        X3().f10633j.getRoot().setOnClickListener(new Z(this));
        X3().f10633j.f10592e.setTypeface(aVar2.w());
        X3().f10633j.f10592e.setText(getString(R.string.delete_apk));
        X3().f10633j.f10591d.setTypeface(aVar2.x());
        X3().f10633j.f10591d.setText(getString(R.string.delete_apk_desc));
        X3().f10633j.f10590c.setChecked(aVar3.P(this));
        X3().f10633j.f10590c.setOnCheckedChangeListener(new a0(this));
        X3().f10644u.f10442b.setTypeface(aVar2.w());
        X3().f10644u.f10442b.setText(getString(R.string.preference_performance_and_data_saver));
        X3().f10629f.getRoot().setOnClickListener(new b0(this));
        X3().f10629f.f10592e.setTypeface(aVar2.w());
        X3().f10629f.f10592e.setText(getString(R.string.preference_title_allow_animations));
        X3().f10629f.f10591d.setVisibility(8);
        X3().f10629f.f10590c.setChecked(aVar3.N(this));
        X3().f10629f.f10590c.setOnCheckedChangeListener(new c0(this));
        if (UptodownApp.f17422D.Q()) {
            X3().f10629f.getRoot().setVisibility(8);
        }
        X3().f10630g.f10548d.setTypeface(aVar2.w());
        X3().f10630g.f10548d.setText(getString(R.string.setting_title_play_video_app_details));
        X3().f10630g.f10547c.setTypeface(aVar2.x());
        X3().f10630g.f10547c.setText(W3());
        X3().f10630g.getRoot().setOnClickListener(new m0(this, H.i(p.a(-1, getString(R.string.setting_play_video_array_never)), p.a(0, getString(R.string.setting_play_video_array_only_wifi)), p.a(1, getString(R.string.setting_play_video_array_wifi_and_data)))));
        X3().f10632i.f10548d.setTypeface(aVar2.w());
        X3().f10632i.f10548d.setText(getString(R.string.data_saver_preference_title));
        X3().f10632i.f10547c.setTypeface(aVar2.x());
        X3().f10632i.f10547c.setText(getString(R.string.data_saver_preference_summary));
        X3().f10632i.getRoot().setOnClickListener(new n0(this, H.i(p.a(0, getString(R.string.data_saver_preference_save_option)), p.a(1, getString(R.string.data_saver_preference_auto_option)), p.a(2, getString(R.string.data_saver_preference_hd_option)))));
        X3().f10643t.getRoot().setOnClickListener(new o0(this));
        X3().f10643t.f10592e.setTypeface(aVar2.w());
        X3().f10643t.f10592e.setText(getString(R.string.solo_wifi));
        X3().f10643t.f10591d.setTypeface(aVar2.x());
        X3().f10643t.f10591d.setText(getString(R.string.solo_wifi_desc));
        X3().f10643t.f10590c.setChecked(aVar3.Z(this));
        X3().f10643t.f10590c.setOnCheckedChangeListener(new p0(this));
        if (this.f18814K.s() || t.f8713a.d()) {
            X3().f10649z.f10442b.setTypeface(aVar2.w());
            X3().f10649z.f10442b.setText(getString(R.string.pref_category_title_install_as_root_system));
            X3().f10631h.getRoot().setOnClickListener(new q0(this));
            X3().f10631h.f10592e.setTypeface(aVar2.w());
            X3().f10631h.f10592e.setText(getString(R.string.pref_auto_update_title));
            X3().f10631h.f10591d.setTypeface(aVar2.x());
            X3().f10631h.f10591d.setText(getString(R.string.pref_auto_update_sumary));
            X3().f10631h.f10590c.setChecked(aVar3.W(this));
            X3().f10631h.f10590c.setOnCheckedChangeListener(new r0(this));
            X3().f10647x.getRoot().setOnClickListener(new L1.A(this));
            X3().f10647x.f10592e.setTypeface(aVar2.w());
            X3().f10647x.f10592e.setText(getString(R.string.pref_install_apk_as_root_system_title));
            X3().f10647x.f10591d.setTypeface(aVar2.x());
            X3().f10647x.f10591d.setText(getString(R.string.pref_install_apk_as_root_system_summary));
            X3().f10647x.f10590c.setChecked(aVar3.a0(this));
            X3().f10647x.f10590c.setOnCheckedChangeListener(new B(this));
        } else {
            X3().f10649z.f10442b.setVisibility(8);
            X3().f10631h.getRoot().setVisibility(8);
            X3().f10647x.getRoot().setVisibility(8);
        }
        X3().f10642s.f10442b.setTypeface(aVar2.w());
        X3().f10642s.f10442b.setText(getString(R.string.recibir_notificaciones));
        X3().f10617A.getRoot().setOnClickListener(new C(this));
        X3().f10617A.f10592e.setTypeface(aVar2.w());
        X3().f10617A.f10592e.setText(getString(R.string.preference_notifications));
        X3().f10617A.f10591d.setTypeface(aVar2.x());
        if (aVar3.Y(this)) {
            X3().f10617A.f10591d.setText(getString(R.string.enabled));
        } else {
            X3().f10617A.f10591d.setText(getString(R.string.disabled));
        }
        X3().f10617A.f10590c.setOnCheckedChangeListener(new D(this));
        X3().f10622F.f10548d.setTypeface(aVar2.w());
        X3().f10622F.f10548d.setText(getString(R.string.updates));
        X3().f10622F.f10547c.setTypeface(aVar2.x());
        X3().f10622F.f10547c.setText(Z3());
        X3().f10622F.getRoot().setOnClickListener(new F(this, H.i(p.a(1, getString(R.string.answer_always)), p.a(2, getString(R.string.answer_daily)), p.a(3, getString(R.string.answer_weekly)), p.a(4, getString(R.string.answer_never)))));
        X3().f10634k.getRoot().setOnClickListener(new G(this));
        X3().f10634k.f10592e.setTypeface(aVar2.w());
        X3().f10634k.f10592e.setText(getString(R.string.downloads_title));
        X3().f10634k.f10591d.setTypeface(aVar2.x());
        X3().f10634k.f10591d.setText(getString(R.string.downloads_notification_permission_description));
        X3().f10634k.f10590c.setChecked(aVar3.R(this));
        X3().f10634k.f10590c.setOnCheckedChangeListener(new L1.H(this));
        X3().f10638o.getRoot().setOnClickListener(new I(this));
        X3().f10638o.f10592e.setTypeface(aVar2.w());
        X3().f10638o.f10592e.setText(getString(R.string.installations));
        X3().f10638o.f10591d.setTypeface(aVar2.x());
        X3().f10638o.f10591d.setText(getString(R.string.installs_notification_permission_description));
        X3().f10638o.f10590c.setChecked(aVar3.X(this));
        X3().f10638o.f10590c.setOnCheckedChangeListener(new J(this));
        if (C2313C.f21882a.a(this)) {
            R4();
            X3().f10617A.f10590c.setChecked(true);
        } else {
            a4();
            X3().f10617A.f10590c.setChecked(false);
        }
        A a5 = new A();
        String string = getString(R.string.internal_storage);
        m.d(string, "getString(...)");
        if (!aVar3.c0(this)) {
            string = getString(R.string.internal_storage);
            a5.f20966a = 0;
        } else if (aVar3.b0(this)) {
            string = getString(R.string.sd_card);
            a5.f20966a = 1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(0, getString(R.string.internal_memory_free, new Object[]{new i().d(new w().f(this).getFreeSpace(), this)}));
        ArrayList c5 = new W1.E().c(this);
        if (!c5.isEmpty()) {
            hashMap.put(1, getString(R.string.sd_card_free, new Object[]{new i().d(((T1.h) c5.get(0)).a(), this)}));
        }
        if (hashMap.size() > 1) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry : hashMap.entrySet()) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
            C1670i0 c6 = C1670i0.c(getLayoutInflater());
            m.d(c6, "inflate(...)");
            c6.f10548d.setTypeface(k.f7778g.w());
            c6.f10548d.setText(getString(R.string.download_path));
            c6.f10547c.setText(string);
            c6.getRoot().setOnClickListener(new L(this, hashMap2, a5, c6));
            X3().f10640q.addView(c6.getRoot(), X3().f10640q.indexOfChild(X3().f10633j.getRoot()));
        }
        TextView textView3 = X3().f10645v.f10442b;
        k.a aVar4 = k.f7778g;
        textView3.setTypeface(aVar4.w());
        X3().f10645v.f10442b.setText(getString(R.string.preference_privacy_and_security));
        X3().f10646w.f10461e.setTypeface(aVar4.w());
        X3().f10646w.f10461e.setText(getString(R.string.gdpr_title));
        X3().f10646w.getRoot().setOnClickListener(new M(this));
        if (!a.f18818a.U(this)) {
            X3().f10646w.getRoot().setVisibility(8);
        }
        X3().f10628e.f10461e.setTypeface(aVar4.w());
        X3().f10628e.f10461e.setText(getString(R.string.advanced_settings));
        X3().f10628e.getRoot().setOnClickListener(new N(this));
        X3().f10641r.f10442b.setTypeface(aVar4.w());
        X3().f10641r.f10442b.setText(getString(R.string.app_detail_more_info_title));
        X3().f10619C.f10461e.setTypeface(aVar4.w());
        X3().f10619C.f10461e.setText(getString(R.string.preference_tos_and_pp));
        X3().f10619C.getRoot().setOnClickListener(new O(this));
        X3().f10635l.f10461e.setTypeface(aVar4.w());
        X3().f10635l.f10461e.setText(getString(R.string.feedback));
        X3().f10635l.getRoot().setOnClickListener(new L1.P(this));
        X3().f10627d.f10461e.setTypeface(aVar4.w());
        X3().f10627d.f10461e.setText(getString(R.string.advertising));
        X3().f10627d.getRoot().setOnClickListener(new S(this));
        X3().f10625b.f10461e.setTypeface(aVar4.w());
        X3().f10625b.f10461e.setText(getString(R.string.about));
        X3().f10625b.getRoot().setOnClickListener(new T(this));
        X3().f10626c.f10461e.setTypeface(aVar4.w());
        X3().f10626c.f10461e.setText(getString(R.string.about_uptodown));
        X3().f10626c.getRoot().setOnClickListener(new U(this));
    }
}
