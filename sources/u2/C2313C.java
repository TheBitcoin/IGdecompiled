package u2;

import W1.G;
import W1.i;
import W1.s;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.uptodown.R;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.preferences.a;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.receivers.DownloadNotificationReceiver;
import com.uptodown.workers.DownloadWorker;
import g2.C2034B;
import g2.C2039G;
import g2.C2043a;
import g2.C2050h;
import g2.C2060s;
import g2.S;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.C2098b;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;

/* renamed from: u2.C  reason: case insensitive filesystem */
public final class C2313C {

    /* renamed from: a  reason: collision with root package name */
    public static final C2313C f21882a = new C2313C();

    private C2313C() {
    }

    private final void A(S s4, Context context) {
        Drawable drawable;
        Object systemService = context.getSystemService("notification");
        m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        t a5 = t.f21927u.a(context);
        a5.a();
        s4.r(1);
        a5.v1(s4);
        a5.i();
        String str = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            m.d(packageManager, "getPackageManager(...)");
            PackageInfo d5 = s.d(packageManager, s4.h(), 0);
            drawable = d5.applicationInfo.loadIcon(context.getPackageManager());
            try {
                str = d5.applicationInfo.loadLabel(context.getPackageManager()).toString();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            drawable = null;
        }
        if (str != null) {
            String string = context.getString(R.string.notification_update_available_title);
            m.d(string, "getString(...)");
            String string2 = context.getString(R.string.notification_update_available_message, new Object[]{str});
            m.d(string2, "getString(...)");
            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            inboxStyle.setBigContentTitle(string);
            inboxStyle.addLine(string2);
            StringBuilder sb = new StringBuilder();
            sb.append(string2);
            m.d(sb, "append(...)");
            sb.append(10);
            m.d(sb, "append(...)");
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
            builder.setOnlyAlertOnce(true);
            H(builder);
            builder.setAutoCancel(true);
            if (drawable != null) {
                builder.setLargeIcon(r(drawable));
            }
            builder.setTimeoutAfter(3600000);
            builder.setOngoing(false);
            builder.setContentText(string2);
            builder.setStyle(inboxStyle);
            Class<Updates> cls = Updates.class;
            Intent intent = new Intent(context, cls);
            TaskStackBuilder create = TaskStackBuilder.create(context);
            m.d(create, "create(...)");
            create.addParentStack((Class<?>) cls);
            create.addNextIntent(intent);
            builder.setContentIntent(create.getPendingIntent(0, t()));
            notificationManager.notify(258, builder.build());
            a.f18818a.O0(context, String.valueOf(System.currentTimeMillis()));
            E(string, String.valueOf(System.currentTimeMillis()), sb.toString(), (String) null, (String) null, context);
        }
    }

    private final void C(Context context) {
        int a5 = S.f20455j.a(context);
        if (a5 > 0) {
            D(context, a5);
            return;
        }
        Object systemService = context.getSystemService("notification");
        m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(258);
    }

    private final void D(Context context, int i4) {
        String string = context.getResources().getString(R.string.app_name);
        m.d(string, "getString(...)");
        String string2 = context.getString(R.string.updates_availables_notification, new Object[]{String.valueOf(i4)});
        m.d(string2, "getString(...)");
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle(string);
        inboxStyle.addLine(string2);
        StringBuilder sb = new StringBuilder();
        sb.append(string2);
        m.d(sb, "append(...)");
        sb.append(10);
        m.d(sb, "append(...)");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
        builder.setOnlyAlertOnce(true);
        H(builder);
        builder.setAutoCancel(false);
        builder.setOngoing(false);
        builder.setContentText(string2);
        builder.setStyle(inboxStyle);
        Class<Updates> cls = Updates.class;
        Intent intent = new Intent(context, cls);
        TaskStackBuilder create = TaskStackBuilder.create(context);
        m.d(create, "create(...)");
        create.addParentStack((Class<?>) cls);
        create.addNextIntent(intent);
        builder.setContentIntent(create.getPendingIntent(0, t()));
        builder.setNumber(i4);
        Object systemService = context.getSystemService("notification");
        m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(258, builder.build());
        a.f18818a.O0(context, String.valueOf(System.currentTimeMillis()));
        E(string, String.valueOf(System.currentTimeMillis()), sb.toString(), (String) null, (String) null, context);
    }

    private final void E(String str, String str2, String str3, String str4, String str5, Context context) {
        C2034B b5 = new C2034B();
        b5.m(str);
        b5.l(str2);
        b5.k(str3);
        b5.i(str4);
        b5.j(str5);
        b5.h(context);
    }

    private final void G(NotificationCompat.Builder builder, int i4) {
        builder.setOnlyAlertOnce(true);
        H(builder);
        builder.setAutoCancel(false);
        builder.setOngoing(true);
        builder.setProgress(100, i4, false);
    }

    private final void H(NotificationCompat.Builder builder) {
        builder.setSmallIcon((int) R.drawable.vector_uptodown_notification);
    }

    private final void b(Context context, int i4) {
        String str;
        if (Build.VERSION.SDK_INT >= 24 && i4 > 0) {
            Object systemService = context.getSystemService("notification");
            m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            StatusBarNotification[] a5 = notificationManager.getActiveNotifications();
            Iterator a6 = C2098b.a(a5);
            while (true) {
                if (!a6.hasNext()) {
                    str = null;
                    break;
                }
                StatusBarNotification statusBarNotification = (StatusBarNotification) a6.next();
                if (i4 == statusBarNotification.getId()) {
                    str = statusBarNotification.getGroupKey();
                    break;
                }
            }
            if (str != null) {
                Iterator a7 = C2098b.a(a5);
                while (a7.hasNext()) {
                    StatusBarNotification statusBarNotification2 = (StatusBarNotification) a7.next();
                    if (i4 != statusBarNotification2.getId() && m.a(statusBarNotification2.getGroupKey(), str)) {
                        return;
                    }
                }
                notificationManager.cancel(i4);
            }
        }
    }

    private final Bitmap r(Drawable drawable) {
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                Bitmap bitmap2 = bitmapDrawable.getBitmap();
                m.d(bitmap2, "getBitmap(...)");
                return bitmap2;
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            m.b(bitmap);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            m.b(bitmap);
        }
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    private final int s(Context context) {
        t a5 = t.f21927u.a(context);
        a5.a();
        int r02 = a5.r0();
        a5.i();
        if (r02 == 0) {
            return MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION;
        }
        return r02 + 1;
    }

    private final int t() {
        if (Build.VERSION.SDK_INT >= 31) {
            return 201326592;
        }
        return 134217728;
    }

    private final void v(Context context, C2060s sVar, String str) {
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (sVar != null) {
            str2 = sVar.i();
        } else {
            str2 = null;
        }
        if (str2 == null || str2.length() == 0) {
            if (sVar != null) {
                str3 = sVar.w();
            } else {
                str3 = null;
            }
            if (!(str3 == null || str3.length() == 0)) {
                m.b(sVar);
                str5 = sVar.w();
                m.b(str5);
            }
        } else {
            m.b(sVar);
            str5 = sVar.i();
            m.b(str5);
        }
        String str6 = str5;
        if (str == null || str.length() == 0) {
            str4 = context.getString(R.string.descarga_error);
        } else {
            str4 = context.getString(R.string.descarga_error) + str;
        }
        Object systemService = context.getSystemService("notification");
        m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
        H(builder);
        if (!(str6 == null || str6.length() == 0)) {
            builder.setContentTitle(str6);
        }
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(str4));
        builder.setContentText(str4);
        builder.setAutoCancel(true);
        Class<MainActivity> cls = MainActivity.class;
        Intent intent = new Intent(context, cls);
        TaskStackBuilder create = TaskStackBuilder.create(context);
        m.d(create, "create(...)");
        create.addParentStack((Class<?>) cls);
        create.addNextIntent(intent);
        builder.setContentIntent(create.getPendingIntent(0, t()));
        Class<MyDownloads> cls2 = MyDownloads.class;
        Intent intent2 = new Intent(context, cls2);
        TaskStackBuilder create2 = TaskStackBuilder.create(context);
        m.d(create2, "create(...)");
        create2.addParentStack((Class<?>) cls2);
        create2.addNextIntent(intent2);
        builder.setContentIntent(create2.getPendingIntent(0, t()));
        notificationManager.notify(257, builder.build());
        E(str6, String.valueOf(System.currentTimeMillis()), str, (String) null, (String) null, context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void w(android.content.Context r13, g2.C2060s r14) {
        /*
            r12 = this;
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)
            java.lang.String r1 = r13.getPackageName()
            r0.setPackage(r1)
            java.util.ArrayList r1 = r14.o()
            int r1 = r1.size()
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x004e
            java.util.ArrayList r1 = r14.o()
            java.lang.Object r1 = r1.get(r2)
            g2.s$c r1 = (g2.C2060s.c) r1
            java.lang.String r1 = r1.a()
            if (r1 == 0) goto L_0x004e
            java.io.File r1 = new java.io.File
            java.util.ArrayList r4 = r14.o()
            java.lang.Object r4 = r4.get(r2)
            g2.s$c r4 = (g2.C2060s.c) r4
            java.lang.String r4 = r4.a()
            kotlin.jvm.internal.m.b(r4)
            r1.<init>(r4)
            u2.q r4 = new u2.q
            r4.<init>()
            android.net.Uri r1 = r4.t(r1, r13)
            java.lang.String r4 = "application/vnd.android.package-archive"
            r0.setDataAndType(r1, r4)
        L_0x004e:
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            if (r1 < r4) goto L_0x0057
            r1 = 335544320(0x14000000, float:6.4623485E-27)
            goto L_0x0058
        L_0x0057:
            r1 = 0
        L_0x0058:
            android.app.PendingIntent r1 = android.app.PendingIntent.getActivity(r13, r2, r0, r1)
            if (r1 == 0) goto L_0x0155
            androidx.core.app.NotificationCompat$Builder r2 = new androidx.core.app.NotificationCompat$Builder
            java.lang.String r4 = "CHANNEL_ID_UPTODOWN"
            r2.<init>((android.content.Context) r13, (java.lang.String) r4)
            r12.H(r2)
            java.lang.String r6 = r14.i()
            r2.setContentTitle(r6)
            r5 = 2131951900(0x7f13011c, float:1.9540228E38)
            java.lang.String r8 = r13.getString(r5)
            java.lang.String r0 = "getString(...)"
            kotlin.jvm.internal.m.d(r8, r0)
            androidx.core.app.NotificationCompat$BigTextStyle r0 = new androidx.core.app.NotificationCompat$BigTextStyle
            r0.<init>()
            androidx.core.app.NotificationCompat$BigTextStyle r0 = r0.bigText(r8)
            r2.setStyle(r0)
            r2.setContentText(r8)
            r2.setAutoCancel(r3)
            java.lang.String r0 = r14.D()
            if (r0 == 0) goto L_0x00ab
            com.squareup.picasso.s r0 = com.squareup.picasso.s.h()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r7 = r14.D()     // Catch:{ Exception -> 0x00a7 }
            com.squareup.picasso.w r0 = r0.l(r7)     // Catch:{ Exception -> 0x00a7 }
            android.graphics.Bitmap r0 = r0.g()     // Catch:{ Exception -> 0x00a7 }
            r2.setLargeIcon((android.graphics.Bitmap) r0)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00ab
        L_0x00a7:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00ab:
            java.lang.String r0 = "com.uptodown.APP_DOWNLOADED"
            r2.setGroup(r0)
            r2.setContentIntent(r1)
            java.lang.String r1 = "notification"
            java.lang.Object r1 = r13.getSystemService(r1)
            java.lang.String r7 = "null cannot be cast to non-null type android.app.NotificationManager"
            kotlin.jvm.internal.m.c(r1, r7)
            android.app.NotificationManager r1 = (android.app.NotificationManager) r1
            int r7 = android.os.Build.VERSION.SDK_INT
            r9 = 24
            if (r7 < r9) goto L_0x00f3
            androidx.core.app.NotificationCompat$Builder r7 = new androidx.core.app.NotificationCompat$Builder
            r7.<init>((android.content.Context) r13, (java.lang.String) r4)
            java.lang.String r4 = r13.getString(r5)
            androidx.core.app.NotificationCompat$Builder r4 = r7.setContentTitle(r4)
            r5 = 2131231558(0x7f080346, float:1.80792E38)
            androidx.core.app.NotificationCompat$Builder r4 = r4.setSmallIcon((int) r5)
            androidx.core.app.NotificationCompat$Builder r0 = r4.setGroup(r0)
            androidx.core.app.NotificationCompat$Builder r0 = r0.setAutoCancel(r3)
            androidx.core.app.NotificationCompat$Builder r0 = r0.setGroupSummary(r3)
            java.lang.String r3 = "setGroupSummary(...)"
            kotlin.jvm.internal.m.d(r0, r3)
            r3 = 6
            android.app.Notification r0 = r0.build()
            r1.notify(r3, r0)
        L_0x00f3:
            java.lang.String r0 = r14.w()
            r3 = -1
            if (r0 == 0) goto L_0x0122
            long r4 = r14.E()
            r9 = 0
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x0122
            g2.a r0 = new g2.a
            java.lang.String r4 = r14.w()
            kotlin.jvm.internal.m.b(r4)
            long r9 = r14.E()
            r0.<init>(r4, r9)
            g2.a r4 = r0.f(r13)
            if (r4 == 0) goto L_0x011f
            int r0 = r4.a()
            goto L_0x0124
        L_0x011f:
            r4 = r0
            r0 = -1
            goto L_0x0124
        L_0x0122:
            r0 = 0
            goto L_0x011f
        L_0x0124:
            if (r0 != r3) goto L_0x013b
            int r0 = r12.s(r13)
            if (r4 == 0) goto L_0x012f
            r4.h(r0)
        L_0x012f:
            if (r4 == 0) goto L_0x0136
            g2.a$b r3 = g2.C2043a.b.DOWNLOADED
            r4.j(r3)
        L_0x0136:
            if (r4 == 0) goto L_0x013b
            r4.g(r13)
        L_0x013b:
            android.app.Notification r2 = r2.build()
            r1.notify(r0, r2)
            java.lang.String r10 = r14.i()
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r7 = java.lang.String.valueOf(r0)
            java.lang.String r9 = "install"
            r5 = r12
            r11 = r13
            r5.E(r6, r7, r8, r9, r10, r11)
        L_0x0155:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.C2313C.w(android.content.Context, g2.s):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e4, code lost:
        r2 = new g2.C2043a(r15, r10);
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void x(android.content.Context r14, java.lang.String r15) {
        /*
            r13 = this;
            r1 = 0
            r2 = 0
            android.content.pm.PackageManager r0 = r14.getPackageManager()     // Catch:{ Exception -> 0x0037 }
            java.lang.String r3 = "getPackageManager(...)"
            kotlin.jvm.internal.m.d(r0, r3)     // Catch:{ Exception -> 0x0037 }
            android.content.pm.PackageInfo r0 = W1.s.d(r0, r15, r1)     // Catch:{ Exception -> 0x0037 }
            android.content.pm.ApplicationInfo r3 = r0.applicationInfo     // Catch:{ Exception -> 0x0037 }
            android.content.pm.PackageManager r4 = r14.getPackageManager()     // Catch:{ Exception -> 0x0037 }
            android.graphics.drawable.Drawable r3 = r3.loadIcon(r4)     // Catch:{ Exception -> 0x0037 }
            android.content.pm.ApplicationInfo r4 = r0.applicationInfo     // Catch:{ Exception -> 0x0034 }
            android.content.pm.PackageManager r5 = r14.getPackageManager()     // Catch:{ Exception -> 0x0034 }
            java.lang.CharSequence r4 = r4.loadLabel(r5)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0034 }
            W1.h r5 = new W1.h     // Catch:{ Exception -> 0x0032 }
            r5.<init>()     // Catch:{ Exception -> 0x0032 }
            long r5 = r5.m(r0)     // Catch:{ Exception -> 0x0032 }
        L_0x0030:
            r7 = r4
            goto L_0x0040
        L_0x0032:
            r0 = move-exception
            goto L_0x003a
        L_0x0034:
            r0 = move-exception
            r4 = r2
            goto L_0x003a
        L_0x0037:
            r0 = move-exception
            r3 = r2
            r4 = r3
        L_0x003a:
            r0.printStackTrace()
            r5 = -1
            goto L_0x0030
        L_0x0040:
            if (r7 == 0) goto L_0x0129
            r0 = 255(0xff, float:3.57E-43)
            r13.d(r14, r0)
            android.content.pm.PackageManager r0 = r14.getPackageManager()
            android.content.Intent r0 = r0.getLaunchIntentForPackage(r15)
            if (r0 == 0) goto L_0x0129
            int r4 = android.os.Build.VERSION.SDK_INT
            r8 = 31
            if (r4 < r8) goto L_0x005a
            r8 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x005b
        L_0x005a:
            r8 = 0
        L_0x005b:
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r14, r1, r0, r8)
            if (r0 == 0) goto L_0x0129
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder
            java.lang.String r8 = "CHANNEL_ID_UPTODOWN"
            r1.<init>((android.content.Context) r14, (java.lang.String) r8)
            r13.H(r1)
            r9 = 2131952424(0x7f130328, float:1.954129E38)
            r10 = r5
            java.lang.String r5 = r14.getString(r9)
            java.lang.String r6 = "getString(...)"
            kotlin.jvm.internal.m.d(r5, r6)
            r1.setContentTitle(r5)
            androidx.core.app.NotificationCompat$BigTextStyle r6 = new androidx.core.app.NotificationCompat$BigTextStyle
            r6.<init>()
            androidx.core.app.NotificationCompat$BigTextStyle r6 = r6.bigText(r7)
            r1.setStyle(r6)
            r1.setContentText(r7)
            r6 = 1
            r1.setAutoCancel(r6)
            if (r3 == 0) goto L_0x0097
            android.graphics.Bitmap r3 = r13.r(r3)
            r1.setLargeIcon((android.graphics.Bitmap) r3)
        L_0x0097:
            java.lang.String r3 = "com.uptodown.APP_INSTALLED"
            r1.setGroup(r3)
            r1.setContentIntent(r0)
            java.lang.String r0 = "notification"
            java.lang.Object r0 = r14.getSystemService(r0)
            java.lang.String r12 = "null cannot be cast to non-null type android.app.NotificationManager"
            kotlin.jvm.internal.m.c(r0, r12)
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0
            r12 = 24
            if (r4 < r12) goto L_0x00dd
            androidx.core.app.NotificationCompat$Builder r4 = new androidx.core.app.NotificationCompat$Builder
            r4.<init>((android.content.Context) r14, (java.lang.String) r8)
            java.lang.String r8 = r14.getString(r9)
            androidx.core.app.NotificationCompat$Builder r4 = r4.setContentTitle(r8)
            r8 = 2131231558(0x7f080346, float:1.80792E38)
            androidx.core.app.NotificationCompat$Builder r4 = r4.setSmallIcon((int) r8)
            androidx.core.app.NotificationCompat$Builder r3 = r4.setGroup(r3)
            androidx.core.app.NotificationCompat$Builder r3 = r3.setAutoCancel(r6)
            androidx.core.app.NotificationCompat$Builder r3 = r3.setGroupSummary(r6)
            java.lang.String r4 = "setGroupSummary(...)"
            kotlin.jvm.internal.m.d(r3, r4)
            r4 = 7
            android.app.Notification r3 = r3.build()
            r0.notify(r4, r3)
        L_0x00dd:
            r3 = 0
            r6 = -1
            int r8 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r8 <= 0) goto L_0x00f4
            g2.a r2 = new g2.a
            r2.<init>(r15, r10)
            g2.a r3 = r2.f(r14)
            if (r3 == 0) goto L_0x00f4
            int r2 = r3.a()
            goto L_0x00f6
        L_0x00f4:
            r3 = r2
            r2 = -1
        L_0x00f6:
            if (r2 != r6) goto L_0x010d
            int r2 = r13.s(r14)
            if (r3 == 0) goto L_0x0101
            r3.h(r2)
        L_0x0101:
            if (r3 == 0) goto L_0x0108
            g2.a$b r4 = g2.C2043a.b.INSTALLED
            r3.j(r4)
        L_0x0108:
            if (r3 == 0) goto L_0x010d
            r3.g(r14)
        L_0x010d:
            android.app.Notification r1 = r1.build()
            r0.notify(r2, r1)
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r6 = java.lang.String.valueOf(r0)
            java.lang.String r8 = "open_app"
            r4 = r13
            r10 = r14
            r9 = r15
            r4.E(r5, r6, r7, r8, r9, r10)
            r14 = 6
            r13.b(r10, r14)
            goto L_0x012a
        L_0x0129:
            r4 = r13
        L_0x012a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.C2313C.x(android.content.Context, java.lang.String):void");
    }

    public final void B(Context context, Uri uri) {
        m.e(context, "context");
        if (uri != null) {
            String string = context.getString(R.string.app_name);
            m.d(string, "getString(...)");
            String string2 = context.getString(R.string.notification_msg_update_uptodown);
            m.d(string2, "getString(...)");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(context.getPackageName());
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, t());
            Object systemService = context.getSystemService("notification");
            m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
            H(builder);
            builder.setContentTitle(string);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(string2));
            builder.setContentText(string2);
            builder.setAutoCancel(true);
            builder.setContentIntent(activity);
            ((NotificationManager) systemService).notify(259, builder.build());
            E(string, String.valueOf(System.currentTimeMillis()), string2, "update_uptodown", uri.getPath(), context);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void F(android.content.Context r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "ctx"
            kotlin.jvm.internal.m.e(r0, r1)
            boolean r1 = r18.a(r19)
            if (r1 != 0) goto L_0x0011
        L_0x000d:
            r4 = r18
            goto L_0x013a
        L_0x0011:
            N1.k$a r1 = N1.k.f7778g
            android.app.Activity r1 = r1.g()
            if (r1 == 0) goto L_0x001a
            goto L_0x000d
        L_0x001a:
            com.uptodown.UptodownApp$a r1 = com.uptodown.UptodownApp.f17422D
            java.lang.String r2 = "GenerateQueueWorker"
            boolean r2 = r1.U(r2, r0)
            if (r2 == 0) goto L_0x0025
            goto L_0x000d
        L_0x0025:
            java.lang.String r2 = "DownloadUpdatesWorker"
            boolean r1 = r1.U(r2, r0)
            if (r1 == 0) goto L_0x002e
            goto L_0x000d
        L_0x002e:
            com.uptodown.activities.preferences.a$a r1 = com.uptodown.activities.preferences.a.f18818a
            java.lang.String r2 = r1.z(r0)
            int r2 = java.lang.Integer.parseInt(r2)
            r3 = -1
            r5 = 0
            r7 = 1
            if (r2 == r7) goto L_0x0048
            r8 = 2
            if (r2 == r8) goto L_0x0050
            r8 = 3
            if (r2 == r8) goto L_0x004c
            r8 = 4
            if (r2 == r8) goto L_0x004a
        L_0x0048:
            r8 = r5
            goto L_0x0053
        L_0x004a:
            r8 = r3
            goto L_0x0053
        L_0x004c:
            r8 = 604800000(0x240c8400, double:2.988109026E-315)
            goto L_0x0053
        L_0x0050:
            r8 = 86400000(0x5265c00, double:4.2687272E-316)
        L_0x0053:
            java.lang.String r1 = r1.r(r0)
            long r10 = java.lang.System.currentTimeMillis()
            r2 = 0
            if (r1 == 0) goto L_0x006d
            long r5 = java.lang.Long.parseLong(r1)
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0068
        L_0x0066:
            r1 = 0
            goto L_0x006e
        L_0x0068:
            long r8 = r8 + r5
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x0066
        L_0x006d:
            r1 = 1
        L_0x006e:
            if (r1 == 0) goto L_0x000d
            u2.t$a r1 = u2.t.f21927u
            u2.t r1 = r1.a(r0)
            r1.a()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            g2.S$b r4 = g2.S.f20455j
            java.util.ArrayList r4 = r4.b(r0)
            java.util.Iterator r8 = r4.iterator()
            java.lang.String r9 = "iterator(...)"
            kotlin.jvm.internal.m.d(r8, r9)
            r9 = 0
        L_0x008e:
            boolean r12 = r8.hasNext()
            if (r12 == 0) goto L_0x00bc
            java.lang.Object r12 = r8.next()
            java.lang.String r13 = "next(...)"
            kotlin.jvm.internal.m.d(r12, r13)
            g2.S r12 = (g2.S) r12
            java.lang.String r13 = r12.h()
            g2.f r13 = r1.Y(r13)
            if (r13 == 0) goto L_0x008e
            boolean r13 = r13.C(r0)
            if (r13 == 0) goto L_0x008e
            int r13 = r12.g()
            if (r13 != r7) goto L_0x00b8
            int r9 = r9 + 1
            goto L_0x008e
        L_0x00b8:
            r3.add(r12)
            goto L_0x008e
        L_0x00bc:
            u2.x r8 = new u2.x
            r8.<init>(r0)
            android.os.Bundle r12 = new android.os.Bundle
            r12.<init>()
            int r13 = r4.size()
            if (r13 <= 0) goto L_0x0135
            int r4 = r4.size()
            java.lang.String r13 = "get(...)"
            java.lang.String r14 = "notificationUpdates"
            java.lang.String r15 = "type"
            if (r4 <= r9) goto L_0x0100
            int r4 = r3.size()
            if (r4 <= 0) goto L_0x00f5
            java.lang.Object r2 = r3.get(r2)
            kotlin.jvm.internal.m.d(r2, r13)
            g2.S r2 = (g2.S) r2
            r4 = r18
            r4.A(r2, r0)
            java.lang.String r0 = "shown_single"
            r12.putString(r15, r0)
            r8.d(r14, r12)
            goto L_0x0137
        L_0x00f5:
            r4 = r18
            java.lang.String r0 = "shown_single_failed"
            r12.putString(r15, r0)
            r8.d(r14, r12)
            goto L_0x0137
        L_0x0100:
            r4 = r18
            r16 = 259200000(0xf731400, double:1.280618154E-315)
            long r5 = r5 + r16
            int r9 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r9 >= 0) goto L_0x0137
            r18.C(r19)
            int r0 = r3.size()
        L_0x0112:
            if (r2 >= r0) goto L_0x012c
            java.lang.Object r5 = r3.get(r2)
            g2.S r5 = (g2.S) r5
            r5.r(r7)
            java.lang.Object r5 = r3.get(r2)
            kotlin.jvm.internal.m.d(r5, r13)
            g2.S r5 = (g2.S) r5
            r1.v1(r5)
            int r2 = r2 + 1
            goto L_0x0112
        L_0x012c:
            java.lang.String r0 = "shownMaxTimeUnnotified"
            r12.putString(r15, r0)
            r8.d(r14, r12)
            goto L_0x0137
        L_0x0135:
            r4 = r18
        L_0x0137:
            r1.i()
        L_0x013a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.C2313C.F(android.content.Context):void");
    }

    public final boolean a(Context context) {
        m.e(context, "context");
        if (Build.VERSION.SDK_INT < 33) {
            return a.f18818a.Y(context);
        }
        if (!u(context) || !a.f18818a.Y(context)) {
            return false;
        }
        return true;
    }

    public final void c(Context context) {
        m.e(context, "context");
        Object systemService = context.getSystemService("notification");
        m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(8);
    }

    public final void d(Context context, int i4) {
        m.e(context, "context");
        Object systemService = context.getSystemService("notification");
        m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(i4);
    }

    public final void e(Context context) {
        m.e(context, "context");
        d(context, 261);
    }

    public final void f(Context context) {
        m.e(context, "context");
        d(context, 255);
    }

    public final void g(Context context) {
        m.e(context, "context");
        d(context, 259);
    }

    public final void h(Context context) {
        m.e(context, "context");
        d(context, 258);
    }

    public final void i(Context context) {
        m.e(context, "context");
        if (Build.VERSION.SDK_INT >= 24) {
            Object systemService = context.getSystemService("notification");
            m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            StatusBarNotification[] a5 = ((NotificationManager) systemService).getActiveNotifications();
            t a6 = t.f21927u.a(context);
            a6.a();
            Iterator it = a6.X().iterator();
            m.d(it, "iterator(...)");
            boolean z4 = false;
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                C2043a aVar = (C2043a) next;
                Iterator a7 = C2098b.a(a5);
                while (true) {
                    if (a7.hasNext()) {
                        if (aVar.a() == ((StatusBarNotification) a7.next()).getId()) {
                            z4 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z4) {
                    a6.n(aVar);
                }
            }
            a6.i();
        }
    }

    public final void j(Context context) {
        String str;
        int i4;
        String str2;
        Intent intent;
        m.e(context, "context");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
        C2060s g4 = DownloadWorker.f19459d.g();
        if (g4 != null) {
            t a5 = t.f21927u.a(context);
            a5.a();
            ArrayList m02 = a5.m0();
            a5.i();
            Iterator it = m02.iterator();
            m.d(it, "iterator(...)");
            int i5 = 0;
            int i6 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                C2060s sVar = (C2060s) next;
                if (sVar.N()) {
                    if (sVar.x() == 0) {
                        i6++;
                    } else if (DownloadWorker.f19459d.j(sVar.h())) {
                        i5++;
                    }
                }
            }
            int i7 = i5 + i6;
            String i8 = g4.i();
            if (i8 == null || i8.length() == 0) {
                str = g4.w();
            } else {
                str = g4.i();
            }
            String str3 = context.getResources().getString(R.string.notification_line_downloading) + ' ' + str + " (" + g4.x() + context.getResources().getString(R.string.percent) + ')';
            G(builder, g4.x());
            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            inboxStyle.addLine(new i().d(g4.y(), context) + '/' + new i().d(g4.z(), context));
            Class<DownloadNotificationReceiver> cls = DownloadNotificationReceiver.class;
            if (i6 > 0) {
                F f4 = F.f20971a;
                String string = context.getString(R.string.queue_downloading_counter);
                m.d(string, "getString(...)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i7)}, 1));
                m.d(format, "format(...)");
                inboxStyle.addLine(format);
                Intent intent2 = new Intent(context, cls);
                intent2.setAction("CANCEL_ALL");
                intent2.putExtra("download", g4);
                intent2.putExtra("notificationID", 261);
                builder.addAction(R.drawable.core_vector_cross, context.getString(R.string.dialog_update_all_button_cancel_all), PendingIntent.getBroadcast(context, 0, intent2, t()));
            }
            builder.setStyle(inboxStyle);
            builder.setContentTitle(str3);
            Class<MyDownloads> cls2 = MyDownloads.class;
            Intent intent3 = new Intent(context, cls2);
            TaskStackBuilder create = TaskStackBuilder.create(context);
            m.d(create, "create(...)");
            create.addParentStack((Class<?>) cls2);
            create.addNextIntent(intent3);
            builder.setContentIntent(create.getPendingIntent(0, t()));
            if (DownloadWorker.f19459d.h()) {
                intent = new Intent(context, cls);
                intent.setAction("RESUME");
                str2 = context.getString(R.string.updates_button_resume);
                i4 = R.drawable.vector_play_resume;
            } else {
                intent = new Intent(context, cls);
                intent.setAction("PAUSE");
                str2 = context.getString(R.string.action_pause);
                i4 = R.drawable.vector_pause;
            }
            builder.addAction(i4, str2, PendingIntent.getBroadcast(context, 0, intent, t()));
            Intent intent4 = new Intent(context, cls);
            intent4.setAction("CANCEL");
            intent4.putExtra("download", g4);
            intent4.putExtra("notificationID", 261);
            builder.addAction(R.drawable.core_vector_cross, context.getString(R.string.option_button_cancel), PendingIntent.getBroadcast(context, 0, intent4, t()));
        } else {
            builder.setOnlyAlertOnce(true);
            H(builder);
            builder.setAutoCancel(false);
            builder.setOngoing(true);
            String string2 = context.getString(R.string.preparing_update_download);
            m.d(string2, "getString(...)");
            builder.setContentTitle(string2);
        }
        Object systemService = context.getSystemService("notification");
        m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(261, builder.build());
    }

    public final void k(Context context, C2060s sVar) {
        m.e(context, "context");
        m.e(sVar, "download");
        if (a(context) && a.f18818a.R(context)) {
            w(context, sVar);
        }
    }

    public final void l(Context context, String str) {
        m.e(context, "context");
        m.e(str, "packagename");
        if (a(context) && a.f18818a.X(context)) {
            x(context, str);
        }
    }

    public final void m(Context context, String str) {
        m.e(context, "context");
        m.e(str, "contentText");
        if (a(context) && a.f18818a.X(context)) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
            H(builder);
            String string = context.getString(R.string.installing);
            m.d(string, "getString(...)");
            builder.setContentTitle(string);
            builder.setContentText(str);
            builder.setProgress(100, 0, true);
            Object systemService = context.getSystemService("notification");
            m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).notify(255, builder.build());
            E(string, String.valueOf(System.currentTimeMillis()), str, (String) null, (String) null, context);
        }
    }

    public final void n(Context context, File file, boolean z4, int i4) {
        int i5;
        String str;
        Drawable d5;
        Context context2 = context;
        File file2 = file;
        m.e(context2, "context");
        m.e(file2, "file");
        if (a(context) && new P1.a(context2).p()) {
            int i6 = i4 + 260;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(context2.getPackageName());
            intent.setDataAndType(new q().t(file2, context2), "application/vnd.android.package-archive");
            intent.putExtra("notificationId", i6);
            if (Build.VERSION.SDK_INT >= 31) {
                i5 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
            } else {
                i5 = 0;
            }
            PendingIntent activity = PendingIntent.getActivity(context2, 0, intent, i5);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context2, "CHANNEL_ID_UPTODOWN");
            H(builder);
            String name = file2.getName();
            m.d(name, "getName(...)");
            if (m3.m.o(name, ".apk", false, 2, (Object) null)) {
                try {
                    PackageManager packageManager = context2.getPackageManager();
                    m.d(packageManager, "getPackageManager(...)");
                    String absolutePath = file2.getAbsolutePath();
                    m.d(absolutePath, "getAbsolutePath(...)");
                    PackageInfo c5 = s.c(packageManager, absolutePath, 128);
                    if (c5 != null) {
                        Drawable loadIcon = c5.applicationInfo.loadIcon(context2.getPackageManager());
                        m.d(loadIcon, "loadIcon(...)");
                        builder.setLargeIcon(r(loadIcon));
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            } else {
                G.a aVar = G.f8470b;
                String name2 = file2.getName();
                m.d(name2, "getName(...)");
                if (aVar.a(name2) && (d5 = new G().d(file2, context2)) != null) {
                    builder.setLargeIcon(r(d5));
                }
            }
            String name3 = file.getName();
            builder.setContentTitle(name3);
            if (z4) {
                F f4 = F.f20971a;
                String string = context2.getString(R.string.notification_installable_found);
                m.d(string, "getString(...)");
                String absolutePath2 = file.getAbsolutePath();
                m.d(absolutePath2, "getAbsolutePath(...)");
                String absolutePath3 = file.getAbsolutePath();
                m.d(absolutePath3, "getAbsolutePath(...)");
                String substring = absolutePath2.substring(0, m3.m.R(absolutePath3, "/", 0, false, 6, (Object) null));
                m.d(substring, "substring(...)");
                str = String.format(string, Arrays.copyOf(new Object[]{substring}, 1));
                m.d(str, "format(...)");
            } else {
                F f5 = F.f20971a;
                String string2 = context2.getString(R.string.notification_installable_to_delete);
                m.d(string2, "getString(...)");
                String absolutePath4 = file.getAbsolutePath();
                m.d(absolutePath4, "getAbsolutePath(...)");
                String absolutePath5 = file.getAbsolutePath();
                m.d(absolutePath5, "getAbsolutePath(...)");
                String substring2 = absolutePath4.substring(0, m3.m.R(absolutePath5, "/", 0, false, 6, (Object) null));
                m.d(substring2, "substring(...)");
                str = String.format(string2, Arrays.copyOf(new Object[]{substring2}, 1));
                m.d(str, "format(...)");
            }
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(str));
            builder.setContentText(str);
            builder.setAutoCancel(true);
            builder.setGroup("com.uptodown.INSTALLABLE_FOUND");
            Intent intent2 = new Intent(context2, InstallerActivity.class);
            intent2.putExtra("realPath", file.getAbsolutePath());
            intent2.putExtra("action", "delete");
            intent2.putExtra("notificationId", i6);
            PendingIntent activity2 = PendingIntent.getActivity(context2, i6, intent2, t());
            StringBuilder sb = new StringBuilder();
            if (z4) {
                builder.addAction(R.drawable.vector_user_panel_my_apps, context2.getString(R.string.option_button_install), activity);
                builder.setContentIntent(activity);
                sb.append("install");
                sb.append(";");
            }
            builder.addAction(R.drawable.core_vector_cross, context2.getString(R.string.option_button_delete), activity2);
            sb.append("delete");
            Object systemService = context2.getSystemService("notification");
            m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (Build.VERSION.SDK_INT >= 24) {
                NotificationCompat.Builder groupSummary = new NotificationCompat.Builder(context2, "CHANNEL_ID_UPTODOWN").setContentTitle(str).setSmallIcon((int) R.drawable.vector_uptodown_notification).setGroup("com.uptodown.INSTALLABLE_FOUND").setAutoCancel(true).setGroupSummary(true);
                m.d(groupSummary, "setGroupSummary(...)");
                notificationManager.notify(5, groupSummary.build());
            }
            notificationManager.notify(i6, builder.build());
            E(name3, String.valueOf(System.currentTimeMillis()), str, sb.toString(), file.getAbsolutePath(), context2);
        }
    }

    public final void o(Context context, int i4, String str) {
        int i5;
        String format;
        m.e(context, "context");
        try {
            if (a(context)) {
                Intent intent = new Intent(context, SecurityActivity.class);
                intent.setPackage(context.getPackageName());
                if (Build.VERSION.SDK_INT >= 31) {
                    i5 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                } else {
                    i5 = 0;
                }
                PendingIntent activity = PendingIntent.getActivity(context, 0, intent, i5);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
                H(builder);
                builder.setContentIntent(activity);
                if (i4 > 0) {
                    if (i4 == 1 && str != null) {
                        if (str.length() != 0) {
                            F f4 = F.f20971a;
                            String string = context.getString(R.string.notification_app_positives_found);
                            m.d(string, "getString(...)");
                            format = String.format(string, Arrays.copyOf(new Object[]{context.getString(R.string.app_name), str}, 2));
                            m.d(format, "format(...)");
                            String str2 = format;
                            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(str2));
                            builder.setContentText(str2);
                            builder.setAutoCancel(true);
                            Object systemService = context.getSystemService("notification");
                            m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                            ((NotificationManager) systemService).notify(256, builder.build());
                            E((String) null, String.valueOf(System.currentTimeMillis()), str2, "positive_apps", (String) null, context);
                        }
                    }
                    F f5 = F.f20971a;
                    String string2 = context.getString(R.string.notification_apps_positives_found);
                    m.d(string2, "getString(...)");
                    format = String.format(string2, Arrays.copyOf(new Object[]{context.getString(R.string.app_name), String.valueOf(i4)}, 2));
                    m.d(format, "format(...)");
                    String str22 = format;
                    builder.setStyle(new NotificationCompat.BigTextStyle().bigText(str22));
                    builder.setContentText(str22);
                    builder.setAutoCancel(true);
                    Object systemService2 = context.getSystemService("notification");
                    m.c(systemService2, "null cannot be cast to non-null type android.app.NotificationManager");
                    ((NotificationManager) systemService2).notify(256, builder.build());
                    E((String) null, String.valueOf(System.currentTimeMillis()), str22, "positive_apps", (String) null, context);
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void p(Context context, C2050h hVar, int i4, Bitmap bitmap, C2039G g4) {
        int i5;
        C2050h hVar2 = hVar;
        Bitmap bitmap2 = bitmap;
        C2039G g5 = g4;
        m.e(context, "context");
        m.e(hVar2, "appInfo");
        m.e(g5, "preRegister");
        if (a(context)) {
            int i6 = i4 + 500;
            Intent intent = new Intent(context, AppDetailActivity.class);
            intent.putExtra("appInfo", hVar2);
            if (Build.VERSION.SDK_INT >= 31) {
                i5 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
            } else {
                i5 = 0;
            }
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, i5);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
            H(builder);
            builder.setContentIntent(activity);
            F f4 = F.f20971a;
            String string = context.getString(R.string.notification_upcoming_releases);
            m.d(string, "getString(...)");
            String format = String.format(string, Arrays.copyOf(new Object[]{hVar2.L(), context.getString(R.string.app_name)}, 2));
            m.d(format, "format(...)");
            if (bitmap2 != null) {
                builder.setLargeIcon(bitmap2);
            }
            builder.setContentIntent(activity);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(format));
            builder.setContentText(format);
            builder.setAutoCancel(true);
            builder.setGroup("com.uptodown.PREREGISTER");
            Object systemService = context.getSystemService("notification");
            m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).notify(i6, builder.build());
            E((String) null, String.valueOf(System.currentTimeMillis()), format, "preregister", String.valueOf(hVar2.e()), context);
            Bundle bundle = new Bundle();
            bundle.putString("type", "notification_shown");
            new x(context).d("preregister", bundle);
        } else {
            t a5 = t.f21927u.a(context);
            a5.a();
            if (a5.w0(g5.c()) == null) {
                a5.T0(g5);
            }
            a5.i();
        }
        g5.j(context);
    }

    public final void q(Context context, C2060s sVar, String str) {
        m.e(context, "context");
        if (a(context) && a.f18818a.R(context)) {
            z(context, sVar, str);
        }
    }

    public final boolean u(Context context) {
        m.e(context, "context");
        if (ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
            return true;
        }
        return false;
    }

    public final void y(Context context, C2060s sVar, String str) {
        m.e(context, "context");
        if (a(context) && a.f18818a.R(context)) {
            v(context, sVar, str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0179  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z(android.content.Context r13, g2.C2060s r14, java.lang.String r15) {
        /*
            r12 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.m.e(r13, r0)
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.uptodown.activities.MyDownloads> r1 = com.uptodown.activities.MyDownloads.class
            r0.<init>(r13, r1)
            r2 = 0
            r3 = 1
            if (r14 == 0) goto L_0x0059
            java.util.ArrayList r4 = r14.o()
            int r4 = r4.size()
            if (r4 != r3) goto L_0x0059
            java.util.ArrayList r4 = r14.o()
            java.lang.Object r4 = r4.get(r2)
            g2.s$c r4 = (g2.C2060s.c) r4
            java.lang.String r4 = r4.a()
            if (r4 == 0) goto L_0x0059
            java.io.File r4 = new java.io.File
            java.util.ArrayList r5 = r14.o()
            java.lang.Object r5 = r5.get(r2)
            g2.s$c r5 = (g2.C2060s.c) r5
            java.lang.String r5 = r5.a()
            kotlin.jvm.internal.m.b(r5)
            r4.<init>(r5)
            boolean r4 = r4.exists()
            if (r4 == 0) goto L_0x0059
            java.util.ArrayList r4 = r14.o()
            java.lang.Object r4 = r4.get(r2)
            g2.s$c r4 = (g2.C2060s.c) r4
            java.lang.String r4 = r4.a()
            java.lang.String r5 = "remoteInstallPath"
            r0.putExtra(r5, r4)
        L_0x0059:
            androidx.core.app.TaskStackBuilder r4 = androidx.core.app.TaskStackBuilder.create(r13)
            java.lang.String r5 = "create(...)"
            kotlin.jvm.internal.m.d(r4, r5)
            r4.addParentStack((java.lang.Class<?>) r1)
            r4.addNextIntent(r0)
            int r0 = r12.t()
            android.app.PendingIntent r0 = r4.getPendingIntent(r2, r0)
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder
            java.lang.String r4 = "CHANNEL_ID_UPTODOWN"
            r1.<init>((android.content.Context) r13, (java.lang.String) r4)
            r1.setContentIntent(r0)
            r12.H(r1)
            r0 = 2131952423(0x7f130327, float:1.9541288E38)
            java.lang.String r6 = r13.getString(r0)
            java.lang.String r0 = "getString(...)"
            kotlin.jvm.internal.m.d(r6, r0)
            r1.setContentTitle(r6)
            r5 = 0
            if (r14 == 0) goto L_0x0094
            java.lang.String r7 = r14.i()
            goto L_0x0095
        L_0x0094:
            r7 = r5
        L_0x0095:
            r8 = 2131952422(0x7f130326, float:1.9541286E38)
            r9 = 2
            java.lang.Object[] r9 = new java.lang.Object[r9]
            r9[r2] = r15
            r9[r3] = r7
            java.lang.String r8 = r13.getString(r8, r9)
            kotlin.jvm.internal.m.d(r8, r0)
            androidx.core.app.NotificationCompat$BigTextStyle r15 = new androidx.core.app.NotificationCompat$BigTextStyle
            r15.<init>()
            androidx.core.app.NotificationCompat$BigTextStyle r15 = r15.bigText(r8)
            r1.setStyle(r15)
            r1.setContentText(r8)
            r1.setAutoCancel(r3)
            if (r14 == 0) goto L_0x00bf
            java.lang.String r15 = r14.D()
            goto L_0x00c0
        L_0x00bf:
            r15 = r5
        L_0x00c0:
            if (r15 == 0) goto L_0x00db
            com.squareup.picasso.s r15 = com.squareup.picasso.s.h()     // Catch:{ Exception -> 0x00d6 }
            java.lang.String r0 = r14.D()     // Catch:{ Exception -> 0x00d6 }
            com.squareup.picasso.w r15 = r15.l(r0)     // Catch:{ Exception -> 0x00d6 }
            android.graphics.Bitmap r15 = r15.g()     // Catch:{ Exception -> 0x00d6 }
            r1.setLargeIcon((android.graphics.Bitmap) r15)     // Catch:{ Exception -> 0x00d6 }
            goto L_0x00db
        L_0x00d6:
            r0 = move-exception
            r15 = r0
            r15.printStackTrace()
        L_0x00db:
            java.lang.String r15 = "com.uptodown.REMOTE_APP_DOWNLOADED"
            r1.setGroup(r15)
            java.lang.String r0 = "notification"
            java.lang.Object r0 = r13.getSystemService(r0)
            java.lang.String r2 = "null cannot be cast to non-null type android.app.NotificationManager"
            kotlin.jvm.internal.m.c(r0, r2)
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0
            int r2 = android.os.Build.VERSION.SDK_INT
            r7 = 24
            if (r2 < r7) goto L_0x0124
            androidx.core.app.NotificationCompat$Builder r2 = new androidx.core.app.NotificationCompat$Builder
            r2.<init>((android.content.Context) r13, (java.lang.String) r4)
            r4 = 2131951900(0x7f13011c, float:1.9540228E38)
            java.lang.String r4 = r13.getString(r4)
            androidx.core.app.NotificationCompat$Builder r2 = r2.setContentTitle(r4)
            r4 = 2131231558(0x7f080346, float:1.80792E38)
            androidx.core.app.NotificationCompat$Builder r2 = r2.setSmallIcon((int) r4)
            androidx.core.app.NotificationCompat$Builder r15 = r2.setGroup(r15)
            androidx.core.app.NotificationCompat$Builder r15 = r15.setAutoCancel(r3)
            androidx.core.app.NotificationCompat$Builder r15 = r15.setGroupSummary(r3)
            java.lang.String r2 = "setGroupSummary(...)"
            kotlin.jvm.internal.m.d(r15, r2)
            r2 = 8
            android.app.Notification r15 = r15.build()
            r0.notify(r2, r15)
        L_0x0124:
            if (r14 == 0) goto L_0x012b
            java.lang.String r15 = r14.w()
            goto L_0x012c
        L_0x012b:
            r15 = r5
        L_0x012c:
            r2 = -1
            if (r15 == 0) goto L_0x0157
            long r3 = r14.E()
            r9 = 0
            int r15 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r15 <= 0) goto L_0x0157
            g2.a r15 = new g2.a
            java.lang.String r3 = r14.w()
            kotlin.jvm.internal.m.b(r3)
            long r9 = r14.E()
            r15.<init>(r3, r9)
            g2.a r3 = r15.f(r13)
            if (r3 == 0) goto L_0x0154
            int r15 = r3.a()
            goto L_0x0159
        L_0x0154:
            r3 = r15
        L_0x0155:
            r15 = -1
            goto L_0x0159
        L_0x0157:
            r3 = r5
            goto L_0x0155
        L_0x0159:
            if (r15 != r2) goto L_0x0170
            int r15 = r12.s(r13)
            if (r3 == 0) goto L_0x0164
            r3.h(r15)
        L_0x0164:
            if (r3 == 0) goto L_0x016b
            g2.a$b r2 = g2.C2043a.b.DOWNLOADED
            r3.j(r2)
        L_0x016b:
            if (r3 == 0) goto L_0x0170
            r3.g(r13)
        L_0x0170:
            android.app.Notification r1 = r1.build()
            r0.notify(r15, r1)
            if (r14 == 0) goto L_0x017d
            java.lang.String r5 = r14.i()
        L_0x017d:
            r10 = r5
            long r14 = java.lang.System.currentTimeMillis()
            java.lang.String r7 = java.lang.String.valueOf(r14)
            java.lang.String r9 = "downloads"
            r5 = r12
            r11 = r13
            r5.E(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.C2313C.z(android.content.Context, g2.s, java.lang.String):void");
    }
}
