package com.uptodown.activities;

import J1.J5;
import J1.K5;
import J1.L5;
import J1.M5;
import J1.N5;
import J1.O5;
import J1.P5;
import J1.Q5;
import N1.k;
import R2.g;
import R2.h;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import c2.V0;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import g2.U;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class UserEditProfileActivity extends C1826a {

    /* renamed from: M  reason: collision with root package name */
    public static final a f18590M = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private final g f18591J = h.a(new J5(this));

    /* renamed from: K  reason: collision with root package name */
    private final ActivityResultLauncher f18592K;

    /* renamed from: L  reason: collision with root package name */
    private final ActivityResultLauncher f18593L;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public UserEditProfileActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new K5(this));
        m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f18592K = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new L5(this));
        m.d(registerForActivityResult2, "registerForActivityResult(...)");
        this.f18593L = registerForActivityResult2;
    }

    /* access modifiers changed from: private */
    public static final V0 i3(UserEditProfileActivity userEditProfileActivity) {
        return V0.c(userEditProfileActivity.getLayoutInflater());
    }

    private final V0 j3() {
        return (V0) this.f18591J.getValue();
    }

    private final void k3() {
        setContentView((View) j3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            j3().f10063f.setNavigationIcon(drawable);
            j3().f10063f.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        j3().f10063f.setNavigationOnClickListener(new M5(this));
        TextView textView = j3().f10067j;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        j3().f10068k.setTypeface(aVar.w());
        j3().f10066i.setTypeface(aVar.w());
        j3().f10064g.setTypeface(aVar.w());
        j3().f10065h.setTypeface(aVar.w());
        j3().f10062e.setOnClickListener(new N5(this));
        j3().f10061d.setOnClickListener(new O5(this));
        j3().f10059b.setOnClickListener(new P5(this));
        j3().f10060c.setOnClickListener(new Q5(this));
    }

    /* access modifiers changed from: private */
    public static final void l3(UserEditProfileActivity userEditProfileActivity, View view) {
        userEditProfileActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void m3(UserEditProfileActivity userEditProfileActivity, View view) {
        U e5 = U.f20468m.e(userEditProfileActivity);
        if (e5 != null) {
            Intent intent = new Intent(userEditProfileActivity, UsernameEditActivity.class);
            intent.putExtra("user", e5);
            userEditProfileActivity.f18593L.launch(intent, UptodownApp.f17422D.b(userEditProfileActivity));
            return;
        }
        userEditProfileActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void n3(UserEditProfileActivity userEditProfileActivity, View view) {
        if (U.f20468m.e(userEditProfileActivity) != null) {
            userEditProfileActivity.f18592K.launch(new Intent(userEditProfileActivity, PasswordEditActivity.class), UptodownApp.f17422D.b(userEditProfileActivity));
            return;
        }
        userEditProfileActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void o3(UserEditProfileActivity userEditProfileActivity, View view) {
        U e5 = U.f20468m.e(userEditProfileActivity);
        if (e5 != null) {
            Intent intent = new Intent(userEditProfileActivity, UserAvatarActivity.class);
            intent.putExtra("user", e5);
            userEditProfileActivity.f18593L.launch(intent, UptodownApp.f17422D.b(userEditProfileActivity));
            return;
        }
        userEditProfileActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void p3(UserEditProfileActivity userEditProfileActivity, View view) {
        U.f20468m.a(userEditProfileActivity);
        userEditProfileActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void q3(UserEditProfileActivity userEditProfileActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 2) {
            U.f20468m.a(userEditProfileActivity);
            userEditProfileActivity.setResult(2);
            userEditProfileActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void r3(UserEditProfileActivity userEditProfileActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 10) {
            userEditProfileActivity.setResult(10);
            userEditProfileActivity.finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k3();
    }
}
