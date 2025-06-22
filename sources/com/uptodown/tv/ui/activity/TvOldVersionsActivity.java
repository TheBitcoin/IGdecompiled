package com.uptodown.tv.ui.activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.uptodown.R;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;
import g2.C2060s;
import java.util.List;
import kotlin.jvm.internal.m;
import q2.C2209b;

public final class TvOldVersionsActivity extends C2209b {

    public final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f19296a;

        /* renamed from: b  reason: collision with root package name */
        private final C2060s f19297b;

        public a(int i4, C2060s sVar) {
            this.f19296a = i4;
            this.f19297b = sVar;
        }

        public void run() {
            List<Fragment> fragments = TvOldVersionsActivity.this.getSupportFragmentManager().getFragments();
            m.d(fragments, "getFragments(...)");
            if (fragments.size() > 0) {
                Fragment fragment = fragments.get(0);
                if (fragment instanceof TvOldVersionsFragment) {
                    ((TvOldVersionsFragment) fragment).A(this.f19296a);
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.tv_old_versions);
    }
}
