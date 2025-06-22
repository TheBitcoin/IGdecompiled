package com.google.firebase.messaging;

import R.k;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import java.util.List;
import p0.C2194f;

class I {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11253a;

    /* renamed from: b  reason: collision with root package name */
    private String f11254b;

    /* renamed from: c  reason: collision with root package name */
    private String f11255c;

    /* renamed from: d  reason: collision with root package name */
    private int f11256d;

    /* renamed from: e  reason: collision with root package name */
    private int f11257e = 0;

    I(Context context) {
        this.f11253a = context;
    }

    static String c(C2194f fVar) {
        String d5 = fVar.n().d();
        if (d5 != null) {
            return d5;
        }
        String c5 = fVar.n().c();
        if (!c5.startsWith("1:")) {
            return c5;
        }
        String[] split = c5.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private PackageInfo f(String str) {
        try {
            return this.f11253a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e5) {
            Log.w("FirebaseMessaging", "Failed to find package " + e5);
            return null;
        }
    }

    private synchronized void h() {
        PackageInfo f4 = f(this.f11253a.getPackageName());
        if (f4 != null) {
            this.f11254b = Integer.toString(f4.versionCode);
            this.f11255c = f4.versionName;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized String a() {
        try {
            if (this.f11254b == null) {
                h();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f11254b;
    }

    /* access modifiers changed from: package-private */
    public synchronized String b() {
        try {
            if (this.f11255c == null) {
                h();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f11255c;
    }

    /* access modifiers changed from: package-private */
    public synchronized int d() {
        PackageInfo f4;
        try {
            if (this.f11256d == 0 && (f4 = f("com.google.android.gms")) != null) {
                this.f11256d = f4.versionCode;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f11256d;
    }

    /* access modifiers changed from: package-private */
    public synchronized int e() {
        int i4 = this.f11257e;
        if (i4 != 0) {
            return i4;
        }
        PackageManager packageManager = this.f11253a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!k.h()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f11257e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w("FirebaseMessaging", "Failed to resolve IID implementation package, falling back");
            if (k.h()) {
                this.f11257e = 2;
            } else {
                this.f11257e = 1;
            }
            return this.f11257e;
        }
        this.f11257e = 2;
        return 2;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        if (e() != 0) {
            return true;
        }
        return false;
    }
}
