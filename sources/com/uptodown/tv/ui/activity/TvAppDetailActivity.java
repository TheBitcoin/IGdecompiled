package com.uptodown.tv.ui.activity;

import R2.n;
import R2.s;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.uptodown.R;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import d3.p;
import g2.C2060s;
import java.util.List;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.J;
import o3.Y;
import q2.C2208a;
import q2.C2209b;

public final class TvAppDetailActivity extends C2209b {

    public final class a implements Runnable {
        public a() {
        }

        public void run() {
            List<Fragment> fragments = TvAppDetailActivity.this.getSupportFragmentManager().getFragments();
            m.d(fragments, "getFragments(...)");
            if (fragments.size() > 0) {
                Fragment fragment = fragments.get(0);
                if (fragment instanceof TvAppDetailFragment) {
                    ((TvAppDetailFragment) fragment).c0();
                }
            }
        }
    }

    public final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f19279a;

        /* renamed from: b  reason: collision with root package name */
        private final int f19280b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TvAppDetailActivity f19281c;

        public b(TvAppDetailActivity tvAppDetailActivity, String str, int i4) {
            m.e(str, "packagename");
            this.f19281c = tvAppDetailActivity;
            this.f19279a = str;
            this.f19280b = i4;
        }

        public void run() {
            List<Fragment> fragments = this.f19281c.getSupportFragmentManager().getFragments();
            m.d(fragments, "getFragments(...)");
            if (fragments.size() > 0) {
                Fragment fragment = fragments.get(0);
                if (fragment instanceof TvAppDetailFragment) {
                    ((TvAppDetailFragment) fragment).N0(this.f19280b, this.f19279a);
                }
            }
        }
    }

    public final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f19282a;

        /* renamed from: b  reason: collision with root package name */
        private final C2060s f19283b;

        public c(int i4, C2060s sVar) {
            this.f19282a = i4;
            this.f19283b = sVar;
        }

        /* access modifiers changed from: private */
        public static final void b(Fragment fragment, c cVar) {
            ((TvAppDetailFragment) fragment).P0(cVar.f19282a, cVar.f19283b);
        }

        public void run() {
            List<Fragment> fragments = TvAppDetailActivity.this.getSupportFragmentManager().getFragments();
            m.d(fragments, "getFragments(...)");
            if (fragments.size() > 0) {
                Fragment fragment = fragments.get(0);
                if (fragment instanceof TvAppDetailFragment) {
                    TvAppDetailActivity.this.runOnUiThread(new C2208a(fragment, this));
                }
            }
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19285a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppDetailActivity f19286b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19287c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(TvAppDetailActivity tvAppDetailActivity, String str, V2.d dVar) {
            super(2, dVar);
            this.f19286b = tvAppDetailActivity;
            this.f19287c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f19286b, this.f19287c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19285a == 0) {
                n.b(obj);
                List<Fragment> fragments = this.f19286b.getSupportFragmentManager().getFragments();
                m.d(fragments, "getFragments(...)");
                if (fragments.size() > 0) {
                    Fragment fragment = fragments.get(0);
                    if (fragment instanceof TvAppDetailFragment) {
                        ((TvAppDetailFragment) fragment).O0(this.f19287c);
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public final Object m(String str, V2.d dVar) {
        Object g4 = C0977g.g(Y.c(), new d(this, str, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.tv_app_detail_activity);
    }
}
