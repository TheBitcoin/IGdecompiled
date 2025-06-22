package com.uptodown.tv.ui.activity;

import N1.j;
import R2.s;
import S2.C1601o;
import W1.C1612h;
import W1.G;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.leanback.app.BackgroundManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.preferences.TvPrivacyPreferences;
import f2.C2027s;
import g2.C2050h;
import g2.C2060s;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.m;
import q2.C2209b;
import q2.C2210c;
import q2.C2211d;
import q2.C2212e;
import q2.f;
import q2.g;
import r2.C2252p;
import r2.C2258v;
import u2.q;
import u2.t;
import u2.x;
import u2.y;

public final class TvMainActivity extends C2209b implements C2027s {

    /* renamed from: b  reason: collision with root package name */
    private AlertDialog f19288b;

    /* renamed from: c  reason: collision with root package name */
    public Fragment f19289c;

    /* renamed from: d  reason: collision with root package name */
    private final ActivityResultLauncher f19290d;

    /* renamed from: e  reason: collision with root package name */
    private final ActivityResultLauncher f19291e;

    public TvMainActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C2211d(this));
        m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f19290d = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C2212e(this));
        m.d(registerForActivityResult2, "registerForActivityResult(...)");
        this.f19291e = registerForActivityResult2;
    }

    private final boolean A(Intent intent) {
        if ((intent.getFlags() & 1048576) == 1048576) {
            return true;
        }
        return false;
    }

    private final void r(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(str);
        builder.setPositiveButton(17039370, new C2210c());
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        if (!isFinishing()) {
            create.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void s(DialogInterface dialogInterface, int i4) {
        m.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    private final void t() {
        AlertDialog alertDialog;
        AlertDialog alertDialog2 = this.f19288b;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        a.C0236a aVar = a.f18818a;
        if (aVar.U(this) && !aVar.i0(this)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(R.string.tracking_disabled_warning_gdpr));
            builder.setPositiveButton(R.string.gdpr_set_up, new f(this));
            builder.setNegativeButton(17039360, new g());
            builder.setCancelable(true);
            this.f19288b = builder.create();
            if (!isFinishing() && (alertDialog = this.f19288b) != null) {
                alertDialog.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void u(TvMainActivity tvMainActivity, DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
        tvMainActivity.f19291e.launch(new Intent(tvMainActivity, TvPrivacyPreferences.class));
    }

    /* access modifiers changed from: private */
    public static final void v(DialogInterface dialogInterface, int i4) {
        m.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void w(TvMainActivity tvMainActivity, ActivityResult activityResult) {
        if (a.f18818a.i0(tvMainActivity)) {
            UptodownApp.a.P0(UptodownApp.f17422D, tvMainActivity, false, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void y(TvMainActivity tvMainActivity, ActivityResult activityResult) {
        String str;
        Bundle extras;
        if (activityResult.getResultCode() == 10) {
            Intent data = activityResult.getData();
            if (data == null || (extras = data.getExtras()) == null) {
                str = null;
            } else {
                str = extras.getString("realPath");
            }
            if (str != null && str.length() != 0) {
                boolean y4 = new u2.m().y(tvMainActivity);
                File file = new File(str);
                new j(tvMainActivity).c(file, (String) null, y4);
                t a5 = t.f21927u.a(tvMainActivity);
                a5.a();
                String name = file.getName();
                m.d(name, "getName(...)");
                C2060s d02 = a5.d0(name);
                a5.i();
                Bundle bundle = new Bundle();
                if (d02 != null) {
                    if (d02.w() != null && ((C2060s.c) d02.o().get(0)).d() > 0) {
                        y yVar = y.f21955a;
                        String w4 = d02.w();
                        m.b(w4);
                        bundle = yVar.b(tvMainActivity, w4, bundle);
                    }
                    if (d02.w() != null) {
                        bundle.putString("packagename", d02.w());
                    }
                    if (((C2060s.c) d02.o().get(0)).d() > 0) {
                        bundle.putString("fileId", String.valueOf(((C2060s.c) d02.o().get(0)).d()));
                    }
                }
                bundle.putString("type", "start");
                x k4 = tvMainActivity.k();
                if (k4 != null) {
                    k4.d("install", bundle);
                }
            }
        }
    }

    public void b(int i4) {
        r(getString(R.string.msg_app_not_found));
    }

    public void c(C2050h hVar) {
        m.e(hVar, "appInfo");
        Intent intent = new Intent(this, TvAppDetailActivity.class);
        intent.putExtra("appInfo", hVar);
        startActivity(intent, UptodownApp.f17422D.a(this));
    }

    public void onBackPressed() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        m.d(fragments, "getFragments(...)");
        if (C1601o.P(fragments) instanceof C2252p) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        Uri data;
        super.onCreate(bundle);
        setContentView((int) R.layout.tv_activity_main);
        z(new C2258v());
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, x()).commit();
        if (a.f18818a.i0(this)) {
            UptodownApp.a.P0(UptodownApp.f17422D, this, false, 2, (Object) null);
        }
        BackgroundManager instance = BackgroundManager.getInstance(this);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.tv_default_background);
        if (instance != null) {
            instance.setDrawable(drawable);
        }
        Intent intent = getIntent();
        if (intent != null && !A(intent) && (data = intent.getData()) != null) {
            String j4 = new C1612h().j(data, this);
            if (j4 == null || (!G.f8470b.a(j4) && !m3.m.o(j4, ".apk", false, 2, (Object) null))) {
                new b2.m(this, new q().j(data), this, LifecycleOwnerKt.getLifecycleScope(this));
                return;
            }
            Intent intent2 = new Intent(getApplicationContext(), InstallerActivity.class);
            intent2.setData(data);
            this.f19290d.launch(intent2);
            s sVar = s.f8222a;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        t();
    }

    public final Fragment x() {
        Fragment fragment = this.f19289c;
        if (fragment != null) {
            return fragment;
        }
        m.u("tvMainFragment");
        return null;
    }

    public final void z(Fragment fragment) {
        m.e(fragment, "<set-?>");
        this.f19289c = fragment;
    }
}
