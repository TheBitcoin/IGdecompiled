package com.uptodown.tv.ui.activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.uptodown.R;
import com.uptodown.tv.ui.fragment.TvMyDownloadsFragment;
import g2.C2060s;
import java.util.List;
import kotlin.jvm.internal.m;
import q2.C2209b;

public final class TvMyDownloadsActivity extends C2209b {

    public final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f19293a;

        /* renamed from: b  reason: collision with root package name */
        private final C2060s f19294b;

        public a(int i4, C2060s sVar) {
            this.f19293a = i4;
            this.f19294b = sVar;
        }

        public void run() {
            List<Fragment> fragments = TvMyDownloadsActivity.this.getSupportFragmentManager().getFragments();
            m.d(fragments, "getFragments(...)");
            if (fragments.size() > 0) {
                Fragment fragment = fragments.get(0);
                if (fragment instanceof TvMyDownloadsFragment) {
                    ((TvMyDownloadsFragment) fragment).t(this.f19293a);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.tv_my_downloads_activity);
    }
}
