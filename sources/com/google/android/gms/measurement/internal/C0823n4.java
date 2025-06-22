package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.measurement.internal.n4  reason: case insensitive filesystem */
final class C0823n4 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ F3 f3148a;

    C0823n4(F3 f32) {
        this.f3148a = f32;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00af A[SYNTHETIC, Splitter:B:40:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0111 A[Catch:{ RuntimeException -> 0x0028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0113 A[Catch:{ RuntimeException -> 0x0028 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.google.android.gms.measurement.internal.C0823n4 r17, boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            r1 = r17
            r0 = r20
            r2 = r21
            r3 = 1
            com.google.android.gms.measurement.internal.F3 r5 = r1.f3148a
            r5.k()
            com.google.android.gms.measurement.internal.F3 r5 = r1.f3148a     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.d6 r5 = r5.g()     // Catch:{ RuntimeException -> 0x0028 }
            boolean r6 = com.google.android.gms.internal.measurement.R6.a()     // Catch:{ RuntimeException -> 0x0028 }
            if (r6 == 0) goto L_0x002b
            com.google.android.gms.measurement.internal.F3 r6 = r1.f3148a     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.g r6 = r6.b()     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.b2 r7 = com.google.android.gms.measurement.internal.G.f2445U0     // Catch:{ RuntimeException -> 0x0028 }
            boolean r6 = r6.q(r7)     // Catch:{ RuntimeException -> 0x0028 }
            if (r6 == 0) goto L_0x002b
            r6 = 1
            goto L_0x002c
        L_0x0028:
            r0 = move-exception
            goto L_0x019b
        L_0x002b:
            r6 = 0
        L_0x002c:
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ RuntimeException -> 0x0028 }
            java.lang.String r8 = "_cis"
            java.lang.String r9 = "Activity created with data 'referrer' without required params"
            java.lang.String r10 = "utm_medium"
            java.lang.String r11 = "utm_source"
            java.lang.String r12 = "utm_campaign"
            java.lang.String r14 = "gclid"
            if (r7 == 0) goto L_0x0040
        L_0x003e:
            r5 = 0
            goto L_0x00ab
        L_0x0040:
            boolean r7 = r2.contains(r14)     // Catch:{ RuntimeException -> 0x0028 }
            if (r7 != 0) goto L_0x008e
            if (r6 == 0) goto L_0x0050
            java.lang.String r7 = "gbraid"
            boolean r7 = r2.contains(r7)     // Catch:{ RuntimeException -> 0x0028 }
            if (r7 != 0) goto L_0x008e
        L_0x0050:
            boolean r7 = r2.contains(r12)     // Catch:{ RuntimeException -> 0x0028 }
            if (r7 != 0) goto L_0x008e
            boolean r7 = r2.contains(r11)     // Catch:{ RuntimeException -> 0x0028 }
            if (r7 != 0) goto L_0x008e
            boolean r7 = r2.contains(r10)     // Catch:{ RuntimeException -> 0x0028 }
            if (r7 != 0) goto L_0x008e
            java.lang.String r7 = "utm_id"
            boolean r7 = r2.contains(r7)     // Catch:{ RuntimeException -> 0x0028 }
            if (r7 != 0) goto L_0x008e
            java.lang.String r7 = "dclid"
            boolean r7 = r2.contains(r7)     // Catch:{ RuntimeException -> 0x0028 }
            if (r7 != 0) goto L_0x008e
            java.lang.String r7 = "srsltid"
            boolean r7 = r2.contains(r7)     // Catch:{ RuntimeException -> 0x0028 }
            if (r7 != 0) goto L_0x008e
            java.lang.String r7 = "sfmc_id"
            boolean r7 = r2.contains(r7)     // Catch:{ RuntimeException -> 0x0028 }
            if (r7 != 0) goto L_0x008e
            com.google.android.gms.measurement.internal.n2 r5 = r5.a()     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.p2 r5 = r5.F()     // Catch:{ RuntimeException -> 0x0028 }
            r5.a(r9)     // Catch:{ RuntimeException -> 0x0028 }
            goto L_0x003e
        L_0x008e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0028 }
            java.lang.String r15 = "https://google.com/search?"
            r7.<init>(r15)     // Catch:{ RuntimeException -> 0x0028 }
            r7.append(r2)     // Catch:{ RuntimeException -> 0x0028 }
            java.lang.String r7 = r7.toString()     // Catch:{ RuntimeException -> 0x0028 }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ RuntimeException -> 0x0028 }
            android.os.Bundle r5 = r5.z(r7, r6)     // Catch:{ RuntimeException -> 0x0028 }
            if (r5 == 0) goto L_0x00ab
            java.lang.String r6 = "referrer"
            r5.putString(r8, r6)     // Catch:{ RuntimeException -> 0x0028 }
        L_0x00ab:
            java.lang.String r6 = "_cmp"
            if (r18 == 0) goto L_0x010b
            com.google.android.gms.measurement.internal.F3 r7 = r1.f3148a     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.d6 r7 = r7.g()     // Catch:{ RuntimeException -> 0x0028 }
            boolean r15 = com.google.android.gms.internal.measurement.R6.a()     // Catch:{ RuntimeException -> 0x0028 }
            if (r15 == 0) goto L_0x00cf
            com.google.android.gms.measurement.internal.F3 r15 = r1.f3148a     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.g r15 = r15.b()     // Catch:{ RuntimeException -> 0x0028 }
            r16 = 0
            com.google.android.gms.measurement.internal.b2 r4 = com.google.android.gms.measurement.internal.G.f2445U0     // Catch:{ RuntimeException -> 0x0028 }
            boolean r4 = r15.q(r4)     // Catch:{ RuntimeException -> 0x0028 }
            if (r4 == 0) goto L_0x00d1
            r15 = 1
        L_0x00cc:
            r4 = r19
            goto L_0x00d3
        L_0x00cf:
            r16 = 0
        L_0x00d1:
            r15 = 0
            goto L_0x00cc
        L_0x00d3:
            android.os.Bundle r4 = r7.z(r4, r15)     // Catch:{ RuntimeException -> 0x0028 }
            if (r4 == 0) goto L_0x010b
            java.lang.String r7 = "intent"
            r4.putString(r8, r7)     // Catch:{ RuntimeException -> 0x0028 }
            boolean r7 = r4.containsKey(r14)     // Catch:{ RuntimeException -> 0x0028 }
            if (r7 != 0) goto L_0x00ff
            if (r5 == 0) goto L_0x00ff
            boolean r7 = r5.containsKey(r14)     // Catch:{ RuntimeException -> 0x0028 }
            if (r7 == 0) goto L_0x00ff
            java.lang.String r7 = "_cer"
            java.lang.String r8 = "gclid=%s"
            java.lang.String r15 = r5.getString(r14)     // Catch:{ RuntimeException -> 0x0028 }
            java.lang.Object[] r13 = new java.lang.Object[r3]     // Catch:{ RuntimeException -> 0x0028 }
            r13[r16] = r15     // Catch:{ RuntimeException -> 0x0028 }
            java.lang.String r8 = java.lang.String.format(r8, r13)     // Catch:{ RuntimeException -> 0x0028 }
            r4.putString(r7, r8)     // Catch:{ RuntimeException -> 0x0028 }
        L_0x00ff:
            com.google.android.gms.measurement.internal.F3 r7 = r1.f3148a     // Catch:{ RuntimeException -> 0x0028 }
            r7.b1(r0, r6, r4)     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.F3 r7 = r1.f3148a     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.i6 r7 = r7.f2390q     // Catch:{ RuntimeException -> 0x0028 }
            r7.b(r0, r4)     // Catch:{ RuntimeException -> 0x0028 }
        L_0x010b:
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ RuntimeException -> 0x0028 }
            if (r4 == 0) goto L_0x0113
            goto L_0x018c
        L_0x0113:
            com.google.android.gms.measurement.internal.F3 r4 = r1.f3148a     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.n2 r4 = r4.a()     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.p2 r4 = r4.F()     // Catch:{ RuntimeException -> 0x0028 }
            java.lang.String r7 = "Activity created with referrer"
            r4.b(r7, r2)     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.F3 r4 = r1.f3148a     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.g r4 = r4.b()     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.b2 r7 = com.google.android.gms.measurement.internal.G.f2504r0     // Catch:{ RuntimeException -> 0x0028 }
            boolean r4 = r4.q(r7)     // Catch:{ RuntimeException -> 0x0028 }
            java.lang.String r7 = "_ldl"
            java.lang.String r8 = "auto"
            if (r4 == 0) goto L_0x0159
            if (r5 == 0) goto L_0x0143
            com.google.android.gms.measurement.internal.F3 r2 = r1.f3148a     // Catch:{ RuntimeException -> 0x0028 }
            r2.b1(r0, r6, r5)     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.F3 r2 = r1.f3148a     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.i6 r2 = r2.f2390q     // Catch:{ RuntimeException -> 0x0028 }
            r2.b(r0, r5)     // Catch:{ RuntimeException -> 0x0028 }
            goto L_0x0152
        L_0x0143:
            com.google.android.gms.measurement.internal.F3 r0 = r1.f3148a     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.n2 r0 = r0.a()     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.F()     // Catch:{ RuntimeException -> 0x0028 }
            java.lang.String r4 = "Referrer does not contain valid parameters"
            r0.b(r4, r2)     // Catch:{ RuntimeException -> 0x0028 }
        L_0x0152:
            com.google.android.gms.measurement.internal.F3 r0 = r1.f3148a     // Catch:{ RuntimeException -> 0x0028 }
            r2 = 0
            r0.l0(r8, r7, r2, r3)     // Catch:{ RuntimeException -> 0x0028 }
            return
        L_0x0159:
            boolean r0 = r2.contains(r14)     // Catch:{ RuntimeException -> 0x0028 }
            if (r0 == 0) goto L_0x018d
            boolean r0 = r2.contains(r12)     // Catch:{ RuntimeException -> 0x0028 }
            if (r0 != 0) goto L_0x0181
            boolean r0 = r2.contains(r11)     // Catch:{ RuntimeException -> 0x0028 }
            if (r0 != 0) goto L_0x0181
            boolean r0 = r2.contains(r10)     // Catch:{ RuntimeException -> 0x0028 }
            if (r0 != 0) goto L_0x0181
            java.lang.String r0 = "utm_term"
            boolean r0 = r2.contains(r0)     // Catch:{ RuntimeException -> 0x0028 }
            if (r0 != 0) goto L_0x0181
            java.lang.String r0 = "utm_content"
            boolean r0 = r2.contains(r0)     // Catch:{ RuntimeException -> 0x0028 }
            if (r0 == 0) goto L_0x018d
        L_0x0181:
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ RuntimeException -> 0x0028 }
            if (r0 != 0) goto L_0x018c
            com.google.android.gms.measurement.internal.F3 r0 = r1.f3148a     // Catch:{ RuntimeException -> 0x0028 }
            r0.l0(r8, r7, r2, r3)     // Catch:{ RuntimeException -> 0x0028 }
        L_0x018c:
            return
        L_0x018d:
            com.google.android.gms.measurement.internal.F3 r0 = r1.f3148a     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.n2 r0 = r0.a()     // Catch:{ RuntimeException -> 0x0028 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.F()     // Catch:{ RuntimeException -> 0x0028 }
            r0.a(r9)     // Catch:{ RuntimeException -> 0x0028 }
            return
        L_0x019b:
            com.google.android.gms.measurement.internal.F3 r1 = r1.f3148a
            com.google.android.gms.measurement.internal.n2 r1 = r1.a()
            com.google.android.gms.measurement.internal.p2 r1 = r1.G()
            java.lang.String r2 = "Throwable caught in handleReferrerForOnActivityCreated"
            r1.b(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0823n4.a(com.google.android.gms.measurement.internal.n4, boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        C0823n4 n4Var;
        String str;
        boolean z4;
        try {
            this.f3148a.a().K().a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                this.f3148a.p().F(activity, bundle);
                return;
            }
            Uri data = intent.getData();
            if (data == null || !data.isHierarchical()) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String string = extras.getString("com.android.vending.referral_url");
                    if (!TextUtils.isEmpty(string)) {
                        data = Uri.parse(string);
                    }
                }
                data = null;
            }
            Uri uri = data;
            if (uri == null || !uri.isHierarchical()) {
                this.f3148a.p().F(activity, bundle);
                return;
            }
            this.f3148a.g();
            if (d6.f0(intent)) {
                str = "gs";
            } else {
                str = "auto";
            }
            String str2 = str;
            String queryParameter = uri.getQueryParameter("referrer");
            if (bundle == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            n4Var = this;
            try {
                this.f3148a.f().D(new C0844q4(n4Var, z4, uri, str2, queryParameter));
                n4Var.f3148a.p().F(activity, bundle);
            } catch (RuntimeException e5) {
                e = e5;
                try {
                    n4Var.f3148a.a().G().b("Throwable caught in onActivityCreated", e);
                    n4Var.f3148a.p().F(activity, bundle);
                } catch (Throwable th) {
                    th = th;
                    n4Var.f3148a.p().F(activity, bundle);
                    throw th;
                }
            }
        } catch (RuntimeException e6) {
            e = e6;
            n4Var = this;
            n4Var.f3148a.a().G().b("Throwable caught in onActivityCreated", e);
            n4Var.f3148a.p().F(activity, bundle);
        } catch (Throwable th2) {
            th = th2;
            n4Var = this;
            n4Var.f3148a.p().F(activity, bundle);
            throw th;
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        this.f3148a.p().E(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.f3148a.p().Q(activity);
        C0838p5 r4 = this.f3148a.r();
        r4.f().D(new C0845q5(r4, r4.B().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        C0838p5 r4 = this.f3148a.r();
        r4.f().D(new C0851r5(r4, r4.B().elapsedRealtime()));
        this.f3148a.p().S(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f3148a.p().R(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
