package com.uptodown.core.activities;

import N1.k;
import O1.C1549a;
import W1.j;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1006v;

public final class ConfirmationIntentWrapperActivity extends AppCompatActivity {

    /* renamed from: c  reason: collision with root package name */
    public static final a f18961c = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private boolean f18962a;

    /* renamed from: b  reason: collision with root package name */
    private final ActivityResultLauncher f18963b;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public ConfirmationIntentWrapperActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1549a(this));
        m.d(registerForActivityResult, "registerForActivityResul…ue\n        finish()\n    }");
        this.f18963b = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final void l(ConfirmationIntentWrapperActivity confirmationIntentWrapperActivity, ActivityResult activityResult) {
        boolean z4;
        m.e(confirmationIntentWrapperActivity, "this$0");
        PackageInstaller.SessionInfo sessionInfo = confirmationIntentWrapperActivity.getPackageManager().getPackageInstaller().getSessionInfo(k.f7778g.n());
        if (sessionInfo == null || ((double) sessionInfo.getProgress()) < 0.81d) {
            z4 = false;
        } else {
            z4 = true;
        }
        C1006v b5 = j.f8686d.b();
        if (b5 != null) {
            b5.v(Boolean.valueOf(z4));
        }
        confirmationIntentWrapperActivity.f18962a = true;
        confirmationIntentWrapperActivity.finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Parcelable parcelable;
        super.onCreate(bundle);
        Intent intent = getIntent();
        m.d(intent, "intent");
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) intent.getParcelableExtra("com.uptodown.sapk.confirmation_intent", Intent.class);
        } else {
            parcelable = intent.getParcelableExtra("com.uptodown.sapk.confirmation_intent");
        }
        try {
            this.f18963b.launch((Intent) parcelable);
        } catch (Exception e5) {
            e5.printStackTrace();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (!this.f18962a) {
            k.f7778g.e();
        }
        super.onDestroy();
    }
}
