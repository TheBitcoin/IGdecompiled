package J;

import H.a;
import H.b;
import L.e;
import L.q;
import L.r;
import M.A;
import M.C0335p;
import M.D;
import R.h;
import R.k;
import Z.g;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.GoogleApiActivity;

/* renamed from: J.g  reason: case insensitive filesystem */
public class C0308g extends C0309h {

    /* renamed from: d  reason: collision with root package name */
    public static final int f333d = C0309h.f337a;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f334e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static final C0308g f335f = new C0308g();

    /* renamed from: c  reason: collision with root package name */
    private String f336c;

    public static C0308g n() {
        return f335f;
    }

    public Intent b(Context context, int i4, String str) {
        return super.b(context, i4, str);
    }

    public PendingIntent c(Context context, int i4, int i5) {
        return super.c(context, i4, i5);
    }

    public final String e(int i4) {
        return super.e(i4);
    }

    public int g(Context context) {
        return super.g(context);
    }

    public int h(Context context, int i4) {
        return super.h(context, i4);
    }

    public final boolean j(int i4) {
        return super.j(i4);
    }

    public Dialog l(Activity activity, int i4, int i5, DialogInterface.OnCancelListener onCancelListener) {
        return q(activity, i4, D.b(activity, b(activity, i4, "d"), i5), onCancelListener, (DialogInterface.OnClickListener) null);
    }

    public PendingIntent m(Context context, C0303b bVar) {
        if (bVar.j()) {
            return bVar.h();
        }
        return c(context, bVar.c(), 0);
    }

    public boolean o(Activity activity, int i4, int i5, DialogInterface.OnCancelListener onCancelListener) {
        Dialog l4 = l(activity, i4, i5, onCancelListener);
        if (l4 == null) {
            return false;
        }
        t(activity, l4, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void p(Context context, int i4) {
        u(context, i4, (String) null, d(context, i4, 0, "n"));
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [android.content.DialogInterface$OnClickListener] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.app.Dialog q(android.content.Context r6, int r7, M.D r8, android.content.DialogInterface.OnCancelListener r9, android.content.DialogInterface.OnClickListener r10) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r7 != 0) goto L_0x0005
            return r1
        L_0x0005:
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            android.content.res.Resources$Theme r3 = r6.getTheme()
            r4 = 16843529(0x1010309, float:2.3695736E-38)
            r3.resolveAttribute(r4, r2, r0)
            android.content.res.Resources r3 = r6.getResources()
            int r2 = r2.resourceId
            java.lang.String r2 = r3.getResourceEntryName(r2)
            java.lang.String r3 = "Theme.Dialog.Alert"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x002c
            android.app.AlertDialog$Builder r1 = new android.app.AlertDialog$Builder
            r2 = 5
            r1.<init>(r6, r2)
        L_0x002c:
            if (r1 != 0) goto L_0x0033
            android.app.AlertDialog$Builder r1 = new android.app.AlertDialog$Builder
            r1.<init>(r6)
        L_0x0033:
            java.lang.String r2 = M.A.c(r6, r7)
            r1.setMessage(r2)
            if (r9 == 0) goto L_0x003f
            r1.setOnCancelListener(r9)
        L_0x003f:
            java.lang.String r9 = M.A.b(r6, r7)
            if (r9 == 0) goto L_0x004b
            if (r8 != 0) goto L_0x0048
            r8 = r10
        L_0x0048:
            r1.setPositiveButton(r9, r8)
        L_0x004b:
            java.lang.String r6 = M.A.f(r6, r7)
            if (r6 == 0) goto L_0x0054
            r1.setTitle(r6)
        L_0x0054:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r7 = new java.lang.Object[r0]
            r8 = 0
            r7[r8] = r6
            java.lang.String r6 = "Creating dialog for Google Play services availability issue. ConnectionResult=%s"
            java.lang.String r6 = java.lang.String.format(r6, r7)
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r7.<init>()
            java.lang.String r8 = "GoogleApiAvailability"
            android.util.Log.w(r8, r6, r7)
            android.app.AlertDialog r6 = r1.create()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: J.C0308g.q(android.content.Context, int, M.D, android.content.DialogInterface$OnCancelListener, android.content.DialogInterface$OnClickListener):android.app.Dialog");
    }

    public final Dialog r(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(A.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        t(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public final r s(Context context, q qVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        r rVar = new r(qVar);
        g.a(context, rVar, intentFilter);
        rVar.a(context);
        if (i(context, "com.google.android.gms")) {
            return rVar;
        }
        qVar.a();
        rVar.b();
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void t(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                C0316o.g(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        C0304c.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    /* access modifiers changed from: package-private */
    public final void u(Context context, int i4, String str, PendingIntent pendingIntent) {
        int i5;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", new Object[]{Integer.valueOf(i4), null}), new IllegalArgumentException());
        if (i4 == 18) {
            v(context);
        } else if (pendingIntent != null) {
            String e5 = A.e(context, i4);
            String d5 = A.d(context, i4);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) C0335p.l(context.getSystemService("notification"));
            NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(e5).setStyle(new NotificationCompat.BigTextStyle().bigText(d5));
            if (h.c(context)) {
                C0335p.o(k.e());
                style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
                if (h.d(context)) {
                    style.addAction(a.common_full_open_on_phone, resources.getString(b.common_open_on_phone), pendingIntent);
                } else {
                    style.setContentIntent(pendingIntent);
                }
            } else {
                style.setSmallIcon(17301642).setTicker(resources.getString(b.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(d5);
            }
            if (k.h()) {
                C0335p.o(k.h());
                synchronized (f334e) {
                    str2 = this.f336c;
                }
                if (str2 == null) {
                    str2 = "com.google.android.gms.availability";
                    NotificationChannel a5 = notificationManager.getNotificationChannel(str2);
                    String string = context.getResources().getString(b.common_google_play_services_notification_channel_name);
                    if (a5 == null) {
                        notificationManager.createNotificationChannel(androidx.browser.trusted.h.a(str2, string, 4));
                    } else if (!string.contentEquals(a5.getName())) {
                        a5.setName(string);
                        notificationManager.createNotificationChannel(a5);
                    }
                }
                style.setChannelId(str2);
            }
            Notification build = style.build();
            if (i4 == 1 || i4 == 2 || i4 == 3) {
                C0313l.f343b.set(false);
                i5 = 10436;
            } else {
                i5 = 39789;
            }
            notificationManager.notify(i5, build);
        } else if (i4 == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void v(Context context) {
        new q(this, context).sendEmptyMessageDelayed(1, 120000);
    }

    public final boolean w(Activity activity, e eVar, int i4, int i5, DialogInterface.OnCancelListener onCancelListener) {
        Activity activity2 = activity;
        DialogInterface.OnCancelListener onCancelListener2 = onCancelListener;
        Dialog q4 = q(activity2, i4, D.c(eVar, b(activity, i4, "d"), 2), onCancelListener2, (DialogInterface.OnClickListener) null);
        if (q4 == null) {
            return false;
        }
        t(activity2, q4, "GooglePlayServicesErrorDialog", onCancelListener2);
        return true;
    }

    public final boolean x(Context context, C0303b bVar, int i4) {
        PendingIntent m4;
        if (T.b.a(context) || (m4 = m(context, bVar)) == null) {
            return false;
        }
        u(context, bVar.c(), (String) null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, m4, i4, true), Z.h.f659a | 134217728));
        return true;
    }
}
