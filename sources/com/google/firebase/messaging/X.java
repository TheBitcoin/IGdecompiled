package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import java.util.ArrayDeque;
import java.util.Queue;

public class X {

    /* renamed from: e  reason: collision with root package name */
    private static X f11299e;

    /* renamed from: a  reason: collision with root package name */
    private String f11300a = null;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f11301b = null;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f11302c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Queue f11303d = new ArrayDeque();

    private X() {
    }

    private int a(Context context, Intent intent) {
        ComponentName componentName;
        String f4 = f(context, intent);
        if (f4 != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Restricting intent to a specific service: " + f4);
            }
            intent.setClassName(context.getPackageName(), f4);
        }
        try {
            if (e(context)) {
                componentName = i0.g(context, intent);
            } else {
                componentName = context.startService(intent);
                Log.d("FirebaseMessaging", "Missing wake lock permission, service start may be delayed");
            }
            if (componentName != null) {
                return -1;
            }
            Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
            return MBridgeCommon.CampaignState.STATE_LOAD_FAILED_RESOURCE_DOWNLOAD_ERROR;
        } catch (SecurityException e5) {
            Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e5);
            return 401;
        } catch (IllegalStateException e6) {
            Log.e("FirebaseMessaging", "Failed to start service while in background: " + e6);
            return 402;
        }
    }

    static synchronized X b() {
        X x4;
        synchronized (X.class) {
            try {
                if (f11299e == null) {
                    f11299e = new X();
                }
                x4 = f11299e;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return x4;
    }

    private synchronized String f(Context context, Intent intent) {
        try {
            String str = this.f11300a;
            if (str != null) {
                return str;
            }
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService != null) {
                ServiceInfo serviceInfo = resolveService.serviceInfo;
                if (serviceInfo != null) {
                    if (context.getPackageName().equals(serviceInfo.packageName)) {
                        String str2 = serviceInfo.name;
                        if (str2 != null) {
                            if (str2.startsWith(".")) {
                                this.f11300a = context.getPackageName() + serviceInfo.name;
                            } else {
                                this.f11300a = serviceInfo.name;
                            }
                            return this.f11300a;
                        }
                    }
                    Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
                    return null;
                }
            }
            Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
            return null;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Intent c() {
        return (Intent) this.f11303d.poll();
    }

    /* access modifiers changed from: package-private */
    public boolean d(Context context) {
        boolean z4;
        if (this.f11302c == null) {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f11302c = Boolean.valueOf(z4);
        }
        if (!this.f11301b.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f11302c.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean e(Context context) {
        boolean z4;
        if (this.f11301b == null) {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f11301b = Boolean.valueOf(z4);
        }
        if (!this.f11301b.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f11301b.booleanValue();
    }

    public int g(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Starting service");
        }
        this.f11303d.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return a(context, intent2);
    }
}
