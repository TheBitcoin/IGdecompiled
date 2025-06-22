package com.google.firebase.messaging;

import I.C0296c;
import R0.b;
import S0.e;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.adid.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import k0.C0937l;
import k0.C0940o;
import p0.C2194f;

class D {

    /* renamed from: a  reason: collision with root package name */
    private final C2194f f11220a;

    /* renamed from: b  reason: collision with root package name */
    private final I f11221b;

    /* renamed from: c  reason: collision with root package name */
    private final C0296c f11222c;

    /* renamed from: d  reason: collision with root package name */
    private final b f11223d;

    /* renamed from: e  reason: collision with root package name */
    private final b f11224e;

    /* renamed from: f  reason: collision with root package name */
    private final e f11225f;

    D(C2194f fVar, I i4, b bVar, b bVar2, e eVar) {
        this(fVar, i4, new C0296c(fVar.k()), bVar, bVar2, eVar);
    }

    private static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private C0937l c(C0937l lVar) {
        return lVar.g(new h(), new C(this));
    }

    private String d() {
        try {
            return b(MessageDigest.getInstance("SHA-1").digest(this.f11220a.m().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    private String g(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString(CampaignEx.JSON_NATIVE_VIDEO_ERROR);
            if ("RST".equals(string3)) {
                throw new IOException("INSTANCE_ID_RESET");
            } else if (string3 != null) {
                throw new IOException(string3);
            } else {
                Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } else {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    static boolean h(String str) {
        if ("SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00c0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(java.lang.String r3, java.lang.String r4, android.os.Bundle r5) {
        /*
            r2 = this;
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "scope"
            r5.putString(r1, r4)
            java.lang.String r4 = "sender"
            r5.putString(r4, r3)
            java.lang.String r4 = "subtype"
            r5.putString(r4, r3)
            p0.f r3 = r2.f11220a
            p0.o r3 = r3.n()
            java.lang.String r3 = r3.c()
            java.lang.String r4 = "gmp_app_id"
            r5.putString(r4, r3)
            com.google.firebase.messaging.I r3 = r2.f11221b
            int r3 = r3.d()
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r4 = "gmsv"
            r5.putString(r4, r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r4 = "osv"
            r5.putString(r4, r3)
            com.google.firebase.messaging.I r3 = r2.f11221b
            java.lang.String r3 = r3.a()
            java.lang.String r4 = "app_ver"
            r5.putString(r4, r3)
            com.google.firebase.messaging.I r3 = r2.f11221b
            java.lang.String r3 = r3.b()
            java.lang.String r4 = "app_ver_name"
            r5.putString(r4, r3)
            java.lang.String r3 = "firebase-app-name-hash"
            java.lang.String r4 = r2.d()
            r5.putString(r3, r4)
            S0.e r3 = r2.f11225f     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            r4 = 0
            k0.l r3 = r3.a(r4)     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            java.lang.Object r3 = k0.C0940o.a(r3)     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            com.google.firebase.installations.g r3 = (com.google.firebase.installations.g) r3     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            java.lang.String r3 = r3.b()     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            if (r4 != 0) goto L_0x007a
            java.lang.String r4 = "Goog-Firebase-Installations-Auth"
            r5.putString(r4, r3)     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            goto L_0x0085
        L_0x0076:
            r3 = move-exception
            goto L_0x0080
        L_0x0078:
            r3 = move-exception
            goto L_0x0080
        L_0x007a:
            java.lang.String r3 = "FIS auth token is empty"
            android.util.Log.w(r0, r3)     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            goto L_0x0085
        L_0x0080:
            java.lang.String r4 = "Failed to get FIS auth token"
            android.util.Log.e(r0, r4, r3)
        L_0x0085:
            S0.e r3 = r2.f11225f
            k0.l r3 = r3.getId()
            java.lang.Object r3 = k0.C0940o.a(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "appid"
            r5.putString(r4, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "fcm-"
            r3.append(r4)
            java.lang.String r4 = "24.1.0"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "cliv"
            r5.putString(r4, r3)
            R0.b r3 = r2.f11224e
            java.lang.Object r3 = r3.get()
            P0.j r3 = (P0.j) r3
            R0.b r4 = r2.f11223d
            java.lang.Object r4 = r4.get()
            Z0.i r4 = (Z0.i) r4
            if (r3 == 0) goto L_0x00e2
            if (r4 == 0) goto L_0x00e2
            java.lang.String r0 = "fire-iid"
            P0.j$a r3 = r3.b(r0)
            P0.j$a r0 = P0.j.a.NONE
            if (r3 == r0) goto L_0x00e2
            int r3 = r3.b()
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r0 = "Firebase-Client-Log-Type"
            r5.putString(r0, r3)
            java.lang.String r3 = "Firebase-Client"
            java.lang.String r4 = r4.a()
            r5.putString(r3, r4)
        L_0x00e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.D.i(java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    private C0937l k(String str, String str2, Bundle bundle) {
        try {
            i(str, str2, bundle);
            return this.f11222c.c(bundle);
        } catch (InterruptedException | ExecutionException e5) {
            return C0940o.d(e5);
        }
    }

    /* access modifiers changed from: package-private */
    public C0937l e() {
        return this.f11222c.a();
    }

    /* access modifiers changed from: package-private */
    public C0937l f() {
        return c(k(I.c(this.f11220a), "*", new Bundle()));
    }

    /* access modifiers changed from: package-private */
    public C0937l j(boolean z4) {
        return this.f11222c.d(z4);
    }

    /* access modifiers changed from: package-private */
    public C0937l l(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        return c(k(str, "/topics/" + str2, bundle));
    }

    /* access modifiers changed from: package-private */
    public C0937l m(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        bundle.putString("delete", "1");
        return c(k(str, "/topics/" + str2, bundle));
    }

    D(C2194f fVar, I i4, C0296c cVar, b bVar, b bVar2, e eVar) {
        this.f11220a = fVar;
        this.f11221b = i4;
        this.f11222c = cVar;
        this.f11223d = bVar;
        this.f11224e = bVar2;
        this.f11225f = eVar;
    }
}
