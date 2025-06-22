package com.uptodown.tv.ui.activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.uptodown.R;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import java.util.List;
import kotlin.jvm.internal.m;
import q2.C2209b;

public final class TvMyAppsActivity extends C2209b {

    public final class a implements Runnable {
        public a() {
        }

        public void run() {
            List<Fragment> fragments = TvMyAppsActivity.this.getSupportFragmentManager().getFragments();
            m.d(fragments, "getFragments(...)");
            if (fragments.size() > 0) {
                Fragment fragment = fragments.get(0);
                if (fragment instanceof TvMyAppsFragment) {
                    ((TvMyAppsFragment) fragment).I();
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.tv_my_apps_activity);
    }
}
