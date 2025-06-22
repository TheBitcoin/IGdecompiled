package com.google.firebase.messaging;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.trusted.h;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.firebase.messaging.d  reason: case insensitive filesystem */
public abstract class C1790d {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f11348a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* renamed from: com.google.firebase.messaging.d$a */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final NotificationCompat.Builder f11349a;

        /* renamed from: b  reason: collision with root package name */
        public final String f11350b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11351c;

        a(NotificationCompat.Builder builder, String str, int i4) {
            this.f11349a = builder;
            this.f11350b = str;
            this.f11351c = i4;
        }
    }

    private static PendingIntent a(Context context, J j4, String str, PackageManager packageManager) {
        Intent f4 = f(str, j4, packageManager);
        if (f4 == null) {
            return null;
        }
        f4.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        f4.putExtras(j4.y());
        if (q(j4)) {
            f4.putExtra("gcm.n.analytics_data", j4.x());
        }
        return PendingIntent.getActivity(context, g(), f4, l(1073741824));
    }

    private static PendingIntent b(Context context, Context context2, J j4) {
        if (!q(j4)) {
            return null;
        }
        return c(context, context2, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(j4.x()));
    }

    private static PendingIntent c(Context context, Context context2, Intent intent) {
        return PendingIntent.getBroadcast(context, g(), new Intent("com.google.android.c2dm.intent.RECEIVE").setPackage(context2.getPackageName()).putExtra("wrapped_intent", intent), l(1073741824));
    }

    public static a d(Context context, Context context2, J j4, String str, Bundle bundle) {
        String packageName = context2.getPackageName();
        Resources resources = context2.getResources();
        PackageManager packageManager = context2.getPackageManager();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context2, str);
        String n4 = j4.n(resources, packageName, "gcm.n.title");
        if (!TextUtils.isEmpty(n4)) {
            builder.setContentTitle(n4);
        }
        String n5 = j4.n(resources, packageName, "gcm.n.body");
        if (!TextUtils.isEmpty(n5)) {
            builder.setContentText(n5);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(n5));
        }
        builder.setSmallIcon(m(packageManager, resources, packageName, j4.p("gcm.n.icon"), bundle));
        Uri n6 = n(packageName, j4, resources);
        if (n6 != null) {
            builder.setSound(n6);
        }
        builder.setContentIntent(a(context, j4, packageName, packageManager));
        PendingIntent b5 = b(context, context2, j4);
        if (b5 != null) {
            builder.setDeleteIntent(b5);
        }
        Integer h4 = h(context2, j4.p("gcm.n.color"), bundle);
        if (h4 != null) {
            builder.setColor(h4.intValue());
        }
        builder.setAutoCancel(!j4.a("gcm.n.sticky"));
        builder.setLocalOnly(j4.a("gcm.n.local_only"));
        String p4 = j4.p("gcm.n.ticker");
        if (p4 != null) {
            builder.setTicker(p4);
        }
        Integer m4 = j4.m();
        if (m4 != null) {
            builder.setPriority(m4.intValue());
        }
        Integer r4 = j4.r();
        if (r4 != null) {
            builder.setVisibility(r4.intValue());
        }
        Integer l4 = j4.l();
        if (l4 != null) {
            builder.setNumber(l4.intValue());
        }
        Long j5 = j4.j("gcm.n.event_time");
        if (j5 != null) {
            builder.setShowWhen(true);
            builder.setWhen(j5.longValue());
        }
        long[] q4 = j4.q();
        if (q4 != null) {
            builder.setVibrate(q4);
        }
        int[] e5 = j4.e();
        if (e5 != null) {
            builder.setLights(e5[0], e5[1], e5[2]);
        }
        builder.setDefaults(i(j4));
        return new a(builder, o(j4), 0);
    }

    static a e(Context context, J j4) {
        Bundle j5 = j(context.getPackageManager(), context.getPackageName());
        return d(context, context, j4, k(context, j4.k(), j5), j5);
    }

    private static Intent f(String str, J j4, PackageManager packageManager) {
        String p4 = j4.p("gcm.n.click_action");
        if (!TextUtils.isEmpty(p4)) {
            Intent intent = new Intent(p4);
            intent.setPackage(str);
            intent.setFlags(268435456);
            return intent;
        }
        Uri f4 = j4.f();
        if (f4 != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage(str);
            intent2.setData(f4);
            return intent2;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            Log.w("FirebaseMessaging", "No activity found to launch app");
        }
        return launchIntentForPackage;
    }

    private static int g() {
        return f11348a.incrementAndGet();
    }

    private static Integer h(Context context, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                Log.w("FirebaseMessaging", "Color is invalid: " + str + ". Notification will use default color.");
            }
        }
        int i4 = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i4 == 0) {
            return null;
        }
        try {
            return Integer.valueOf(ContextCompat.getColor(context, i4));
        } catch (Resources.NotFoundException unused2) {
            Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            return null;
        }
    }

    private static int i(J j4) {
        boolean a5 = j4.a("gcm.n.default_sound");
        if (j4.a("gcm.n.default_vibrate_timings")) {
            a5 |= true;
        }
        return j4.a("gcm.n.default_light_settings") ? a5 | true ? 1 : 0 : a5 ? 1 : 0;
    }

    private static Bundle j(PackageManager packageManager, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (!(applicationInfo == null || (bundle = applicationInfo.metaData) == null)) {
                return bundle;
            }
        } catch (PackageManager.NameNotFoundException e5) {
            Log.w("FirebaseMessaging", "Couldn't get own application info: " + e5);
        }
        return Bundle.EMPTY;
    }

    public static String k(Context context, String str, Bundle bundle) {
        String str2;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                if (notificationManager.getNotificationChannel(str) != null) {
                    return str;
                }
                Log.w("FirebaseMessaging", "Notification Channel requested (" + str + ") has not been created by the app. Manifest configuration, or default, value will be used.");
            }
            String string = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string)) {
                Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            } else if (notificationManager.getNotificationChannel(string) != null) {
                return string;
            } else {
                Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
            }
            if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                int identifier = context.getResources().getIdentifier("fcm_fallback_notification_channel_label", TypedValues.Custom.S_STRING, context.getPackageName());
                if (identifier == 0) {
                    Log.e("FirebaseMessaging", "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                    str2 = "Misc";
                } else {
                    str2 = context.getString(identifier);
                }
                notificationManager.createNotificationChannel(h.a("fcm_fallback_notification_channel", str2, 3));
            }
            return "fcm_fallback_notification_channel";
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static int l(int i4) {
        if (Build.VERSION.SDK_INT >= 23) {
            return i4 | AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        }
        return i4;
    }

    private static int m(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && p(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && p(resources, identifier2)) {
                return identifier2;
            }
            Log.w("FirebaseMessaging", "Icon resource " + str2 + " not found. Notification will use default icon.");
        }
        int i4 = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i4 == 0 || !p(resources, i4)) {
            try {
                i4 = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e5) {
                Log.w("FirebaseMessaging", "Couldn't get own application info: " + e5);
            }
        }
        if (i4 == 0 || !p(resources, i4)) {
            return 17301651;
        }
        return i4;
    }

    private static Uri n(String str, J j4, Resources resources) {
        String o4 = j4.o();
        if (TextUtils.isEmpty(o4)) {
            return null;
        }
        if (MRAIDCommunicatorUtil.STATES_DEFAULT.equals(o4) || resources.getIdentifier(o4, "raw", str) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        return Uri.parse("android.resource://" + str + "/raw/" + o4);
    }

    private static String o(J j4) {
        String p4 = j4.p("gcm.n.tag");
        if (!TextUtils.isEmpty(p4)) {
            return p4;
        }
        return "FCM-Notification:" + SystemClock.uptimeMillis();
    }

    private static boolean p(Resources resources, int i4) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!C1789c.a(resources.getDrawable(i4, (Resources.Theme) null))) {
                return true;
            }
            Log.e("FirebaseMessaging", "Adaptive icons cannot be used in notifications. Ignoring icon id: " + i4);
            return false;
        } catch (Resources.NotFoundException unused) {
            Log.e("FirebaseMessaging", "Couldn't find resource " + i4 + ", treating it as an invalid icon");
            return false;
        }
    }

    static boolean q(J j4) {
        return j4.a("google.c.a.e");
    }
}
