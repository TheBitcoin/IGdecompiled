package J;

import R.h;
import T.e;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import b0.d;

/* renamed from: J.h  reason: case insensitive filesystem */
public class C0309h {

    /* renamed from: a  reason: collision with root package name */
    public static final int f337a = C0313l.f342a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0309h f338b = new C0309h();

    C0309h() {
    }

    public static C0309h f() {
        return f338b;
    }

    public int a(Context context) {
        return C0313l.b(context);
    }

    public Intent b(Context context, int i4, String str) {
        if (i4 == 1 || i4 == 2) {
            if (context == null || !h.d(context)) {
                StringBuilder sb = new StringBuilder();
                sb.append("gcore_");
                sb.append(f337a);
                sb.append("-");
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                }
                sb.append("-");
                if (context != null) {
                    sb.append(context.getPackageName());
                }
                sb.append("-");
                if (context != null) {
                    try {
                        sb.append(e.a(context).e(context.getPackageName(), 0).versionCode);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                String sb2 = sb.toString();
                Intent intent = new Intent("android.intent.action.VIEW");
                Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
                if (!TextUtils.isEmpty(sb2)) {
                    appendQueryParameter.appendQueryParameter("pcampaignid", sb2);
                }
                intent.setData(appendQueryParameter.build());
                intent.setPackage("com.android.vending");
                intent.addFlags(524288);
                return intent;
            }
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        } else if (i4 != 3) {
            return null;
        } else {
            Uri fromParts = Uri.fromParts("package", "com.google.android.gms", (String) null);
            Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent3.setData(fromParts);
            return intent3;
        }
    }

    public PendingIntent c(Context context, int i4, int i5) {
        return d(context, i4, i5, (String) null);
    }

    public PendingIntent d(Context context, int i4, int i5, String str) {
        Intent b5 = b(context, i4, str);
        if (b5 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i5, b5, d.f1133a | 134217728);
    }

    public String e(int i4) {
        return C0313l.c(i4);
    }

    public int g(Context context) {
        return h(context, f337a);
    }

    public int h(Context context, int i4) {
        int g4 = C0313l.g(context, i4);
        if (C0313l.h(context, g4)) {
            return 18;
        }
        return g4;
    }

    public boolean i(Context context, String str) {
        return C0313l.l(context, str);
    }

    public boolean j(int i4) {
        return C0313l.j(i4);
    }

    public void k(Context context, int i4) {
        C0313l.a(context, i4);
    }
}
