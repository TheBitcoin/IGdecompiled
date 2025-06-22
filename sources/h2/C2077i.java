package h2;

import N1.k;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.Updates;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import kotlin.jvm.internal.m;

/* renamed from: h2.i  reason: case insensitive filesystem */
public final class C2077i extends ResultReceiver {
    public C2077i(Handler handler) {
        super(handler);
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i4, Bundle bundle) {
        m.e(bundle, "resultData");
        String string = bundle.getString("packageName");
        Activity g4 = k.f7778g.g();
        if (g4 == null) {
            return;
        }
        if (g4 instanceof Updates) {
            if (string != null) {
                ((Updates) g4).U5(i4, string);
            }
        } else if (g4 instanceof MyApps) {
            if (string != null) {
                ((MyApps) g4).w5(i4, string);
            }
        } else if (g4 instanceof AppDetailActivity) {
            if (string != null) {
                AppDetailActivity appDetailActivity = (AppDetailActivity) g4;
                appDetailActivity.runOnUiThread(new AppDetailActivity.c(appDetailActivity, string, i4));
            }
        } else if (g4 instanceof MyDownloads) {
            MyDownloads myDownloads = (MyDownloads) g4;
            myDownloads.runOnUiThread(new MyDownloads.b(i4));
        } else if (g4 instanceof OldVersionsActivity) {
            OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) g4;
            oldVersionsActivity.runOnUiThread(new OldVersionsActivity.d(string, i4));
        } else if (g4 instanceof InstallerActivity) {
            if (i4 == 351) {
                ((InstallerActivity) g4).U1();
            } else {
                ((InstallerActivity) g4).finish();
            }
        } else if (g4 instanceof TvAppDetailActivity) {
            if (string != null) {
                TvAppDetailActivity tvAppDetailActivity = (TvAppDetailActivity) g4;
                tvAppDetailActivity.runOnUiThread(new TvAppDetailActivity.b(tvAppDetailActivity, string, i4));
            }
        } else if ((g4 instanceof MainActivity) && string != null) {
            MainActivity mainActivity = (MainActivity) g4;
            mainActivity.runOnUiThread(new MainActivity.C1820d(mainActivity, i4, string));
        }
    }
}
