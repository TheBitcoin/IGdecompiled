package h2;

import N1.k;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.C1826a;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import com.uptodown.tv.ui.activity.TvMyDownloadsActivity;
import com.uptodown.tv.ui.activity.TvOldVersionsActivity;
import g2.C2060s;
import java.io.File;
import kotlin.jvm.internal.m;
import q2.C2209b;

/* renamed from: h2.e  reason: case insensitive filesystem */
public final class C2073e extends ResultReceiver {
    public C2073e(Handler handler) {
        super(handler);
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i4, Bundle bundle) {
        C2060s sVar;
        Long l4;
        File n4;
        Parcelable parcelable;
        String str = null;
        if (bundle != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) bundle.getParcelable("download", C2060s.class);
            } else {
                parcelable = bundle.getParcelable("download");
            }
            sVar = (C2060s) parcelable;
        } else {
            sVar = null;
        }
        k.a aVar = k.f7778g;
        if (aVar.g() != null) {
            Activity g4 = aVar.g();
            if (i4 != 202) {
                if (i4 == 209 && (g4 instanceof C1826a)) {
                    C1826a aVar2 = (C1826a) g4;
                    aVar2.runOnUiThread(new C1826a.b());
                }
            } else if (sVar != null && (g4 instanceof C2209b) && !(g4 instanceof TvAppDetailActivity)) {
                C2209b bVar = (C2209b) g4;
                bVar.runOnUiThread(new C2209b.a(bVar, sVar));
            }
            if (g4 instanceof MainActivity) {
                if (sVar != null) {
                    ((MainActivity) g4).d8(sVar, i4);
                }
            } else if (g4 instanceof MyDownloads) {
                ((MyDownloads) g4).E4(i4, sVar);
            } else if (g4 instanceof Updates) {
                ((Updates) g4).Q5(i4, bundle);
            } else if (g4 instanceof MyApps) {
                MyApps myApps = (MyApps) g4;
                if (sVar != null) {
                    str = sVar.w();
                }
                myApps.x5(i4, str);
            } else if (g4 instanceof AppDetailActivity) {
                if (bundle != null) {
                    str = bundle.getString("packagename");
                }
                if (!(str == null || str.length() == 0)) {
                    AppDetailActivity appDetailActivity = (AppDetailActivity) g4;
                    appDetailActivity.runOnUiThread(new AppDetailActivity.b(i4, str));
                }
                AppDetailActivity appDetailActivity2 = (AppDetailActivity) g4;
                appDetailActivity2.runOnUiThread(new AppDetailActivity.d(i4, sVar));
            } else if (g4 instanceof TvAppDetailActivity) {
                TvAppDetailActivity tvAppDetailActivity = (TvAppDetailActivity) g4;
                tvAppDetailActivity.runOnUiThread(new TvAppDetailActivity.c(i4, sVar));
            } else if (g4 instanceof TvOldVersionsActivity) {
                TvOldVersionsActivity tvOldVersionsActivity = (TvOldVersionsActivity) g4;
                tvOldVersionsActivity.runOnUiThread(new TvOldVersionsActivity.a(i4, sVar));
            } else if (g4 instanceof TvMyDownloadsActivity) {
                TvMyDownloadsActivity tvMyDownloadsActivity = (TvMyDownloadsActivity) g4;
                tvMyDownloadsActivity.runOnUiThread(new TvMyDownloadsActivity.a(i4, sVar));
            } else if (g4 instanceof WishlistActivity) {
                WishlistActivity wishlistActivity = (WishlistActivity) g4;
                if (sVar != null) {
                    str = sVar.w();
                }
                wishlistActivity.r5(str);
            } else if (g4 instanceof RecommendedActivity) {
                RecommendedActivity recommendedActivity = (RecommendedActivity) g4;
                if (sVar != null) {
                    str = sVar.w();
                }
                recommendedActivity.t5(str);
            } else if (g4 instanceof PublicListActivity) {
                PublicListActivity publicListActivity = (PublicListActivity) g4;
                if (sVar != null) {
                    str = sVar.w();
                }
                publicListActivity.X4(str);
            } else if (g4 instanceof OldVersionsActivity) {
                if (sVar != null) {
                    l4 = Long.valueOf(sVar.E());
                } else {
                    l4 = null;
                }
                if (l4 != null) {
                    OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) g4;
                    oldVersionsActivity.runOnUiThread(new OldVersionsActivity.c(i4, sVar));
                }
                if (!(i4 != 202 || sVar == null || (n4 = sVar.n()) == null)) {
                    OldVersionsActivity oldVersionsActivity2 = (OldVersionsActivity) g4;
                    String w4 = sVar.w();
                    m.b(w4);
                    oldVersionsActivity2.runOnUiThread(new OldVersionsActivity.b(oldVersionsActivity2, w4, sVar.E(), n4));
                }
                if (i4 == 208) {
                    OldVersionsActivity oldVersionsActivity3 = (OldVersionsActivity) g4;
                    oldVersionsActivity3.runOnUiThread(new OldVersionsActivity.c(i4, (C2060s) null));
                }
            } else if (g4 instanceof MoreInfo) {
                MoreInfo moreInfo = (MoreInfo) g4;
                moreInfo.runOnUiThread(new MoreInfo.a(sVar));
            } else if (g4 instanceof OrganizationActivity) {
                ((OrganizationActivity) g4).C3(sVar);
            }
        }
    }
}
