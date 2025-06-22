package com.uptodown.activities;

import C1.e;
import E1.a;
import J1.s6;
import R2.g;
import R2.h;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedCallback;
import c2.c1;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class YouTubeActivity extends C1826a {

    /* renamed from: M  reason: collision with root package name */
    public static final a f18692M = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private final g f18693J = h.a(new s6(this));
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public e f18694K;

    /* renamed from: L  reason: collision with root package name */
    private final d f18695L = new d(this);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements D1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YouTubeActivity f18696a;

        b(YouTubeActivity youTubeActivity) {
            this.f18696a = youTubeActivity;
        }

        public void a(View view, d3.a aVar) {
            m.e(view, "fullscreenView");
            m.e(aVar, "exitFullscreen");
            this.f18696a.e3().f10258c.setVisibility(8);
            this.f18696a.e3().f10257b.setVisibility(0);
            this.f18696a.e3().f10257b.addView(view);
        }

        public void onExitFullscreen() {
            this.f18696a.e3().f10258c.setVisibility(0);
            this.f18696a.e3().f10257b.setVisibility(8);
            this.f18696a.e3().f10257b.removeAllViews();
        }
    }

    public static final class c extends D1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YouTubeActivity f18697a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18698b;

        c(YouTubeActivity youTubeActivity, String str) {
            this.f18697a = youTubeActivity;
            this.f18698b = str;
        }

        public void f(e eVar) {
            m.e(eVar, "youTubePlayer");
            this.f18697a.f18694K = eVar;
            eVar.e(this.f18698b, 0.0f);
        }

        public void i(e eVar, C1.c cVar) {
            m.e(eVar, "youTubePlayer");
            m.e(cVar, CampaignEx.JSON_NATIVE_VIDEO_ERROR);
            super.i(eVar, cVar);
            this.f18697a.finish();
        }
    }

    public static final class d extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YouTubeActivity f18699a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(YouTubeActivity youTubeActivity) {
            super(true);
            this.f18699a = youTubeActivity;
        }

        public void handleOnBackPressed() {
            this.f18699a.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final c1 d3(YouTubeActivity youTubeActivity) {
        return c1.c(youTubeActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final c1 e3() {
        return (c1) this.f18693J.getValue();
    }

    private final void f3(String str) {
        E1.a c5 = new a.C0080a().e(1).f(1).c();
        e3().f10258c.e(new c(this, str), c5);
        e3().f10258c.c(new b(this));
    }

    public void onConfigurationChanged(Configuration configuration) {
        e eVar;
        m.e(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        int i4 = configuration.orientation;
        if ((i4 == 1 || i4 == 2) && (eVar = this.f18694K) != null) {
            m.b(eVar);
            eVar.b();
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        Bundle extras;
        super.onCreate(bundle);
        setContentView((View) e3().getRoot());
        Window window = getWindow();
        m.d(window, "getWindow(...)");
        O2(window);
        getOnBackPressedDispatcher().addCallback(this, this.f18695L);
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("id_youtube")) {
            str = null;
        } else {
            str = extras.getString("id_youtube");
        }
        if (str == null || str.length() == 0) {
            finish();
        } else {
            f3(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        e3().f10258c.h();
    }
}
