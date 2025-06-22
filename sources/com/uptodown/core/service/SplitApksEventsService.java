package com.uptodown.core.service;

import N1.k;
import T1.f;
import W1.j;
import W1.s;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import com.uptodown.core.activities.ConfirmationIntentWrapperActivity;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1006v;

public final class SplitApksEventsService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19246a = new a((C2103g) null);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final String a(Context context, String str) {
            m.e(context, "c");
            m.e(str, "packageName");
            try {
                PackageManager packageManager = context.getPackageManager();
                m.d(packageManager, "pm");
                return packageManager.getApplicationLabel(s.a(packageManager, str, 0)).toString();
            } catch (Exception unused) {
                return null;
            }
        }

        private a() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0071, code lost:
        if (r7 != null) goto L_0x0076;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String a(int r7, android.content.Intent r8) {
        /*
            r6 = this;
            r0 = 2
            r1 = 0
            java.lang.String r2 = "android.content.pm.extra.STATUS_MESSAGE"
            r3 = 0
            switch(r7) {
                case 1: goto L_0x0082;
                case 2: goto L_0x005a;
                case 3: goto L_0x0053;
                case 4: goto L_0x002c;
                case 5: goto L_0x0024;
                case 6: goto L_0x001c;
                case 7: goto L_0x0014;
                default: goto L_0x0008;
            }
        L_0x0008:
            int r7 = N1.i.error_unknown
            java.lang.String r7 = r6.getString(r7)
            java.lang.String r3 = r8.getStringExtra(r2)
            goto L_0x00a8
        L_0x0014:
            int r7 = N1.i.installation_status_failure_incompatible
            java.lang.String r7 = r6.getString(r7)
            goto L_0x00a8
        L_0x001c:
            int r7 = N1.i.installation_status_failure_storage
            java.lang.String r7 = r6.getString(r7)
            goto L_0x00a8
        L_0x0024:
            int r7 = N1.i.installation_status_failure_conflict
            java.lang.String r7 = r6.getString(r7)
            goto L_0x00a8
        L_0x002c:
            int r7 = N1.i.installation_status_failure_invalid
            java.lang.String r7 = r6.getString(r7)
            java.lang.String r4 = r8.getStringExtra(r2)
            if (r4 == 0) goto L_0x004e
            int r5 = r4.length()
            if (r5 != 0) goto L_0x003f
            goto L_0x004e
        L_0x003f:
            java.lang.String r5 = "INSTALL_FAILED_VERSION_DOWNGRADE"
            boolean r0 = m3.m.y(r4, r5, r1, r0, r3)
            if (r0 == 0) goto L_0x004e
            int r8 = N1.i.core_invalid_apk_downgrade
            java.lang.String r3 = r6.getString(r8)
            goto L_0x00a8
        L_0x004e:
            java.lang.String r3 = r8.getStringExtra(r2)
            goto L_0x00a8
        L_0x0053:
            int r7 = N1.i.xapk_installation_cancelled_by_user
            java.lang.String r7 = r6.getString(r7)
            goto L_0x00a8
        L_0x005a:
            java.lang.String r7 = "android.content.pm.extra.OTHER_PACKAGE_NAME"
            java.lang.String r7 = r8.getStringExtra(r7)
            if (r7 == 0) goto L_0x0074
            com.uptodown.core.service.SplitApksEventsService$a r8 = f19246a
            android.content.Context r0 = r6.getApplicationContext()
            java.lang.String r2 = "applicationContext"
            kotlin.jvm.internal.m.d(r0, r2)
            java.lang.String r7 = r8.a(r0, r7)
            if (r7 == 0) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            java.lang.String r7 = "device"
        L_0x0076:
            int r8 = N1.i.installation_status_failure_blocked
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r7
            java.lang.String r7 = r6.getString(r8, r0)
            goto L_0x00a8
        L_0x0082:
            int r7 = N1.i.installation_status_failure
            java.lang.String r7 = r6.getString(r7)
            java.lang.String r4 = r8.getStringExtra(r2)
            if (r4 == 0) goto L_0x00a4
            int r5 = r4.length()
            if (r5 != 0) goto L_0x0095
            goto L_0x00a4
        L_0x0095:
            java.lang.String r5 = "-3001"
            boolean r0 = m3.m.y(r4, r5, r1, r0, r3)
            if (r0 == 0) goto L_0x00a4
            int r8 = N1.i.core_build_type_error
            java.lang.String r3 = r6.getString(r8)
            goto L_0x00a8
        L_0x00a4:
            java.lang.String r3 = r8.getStringExtra(r2)
        L_0x00a8:
            if (r3 == 0) goto L_0x00be
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            java.lang.String r7 = ": "
            r8.append(r7)
            r8.append(r3)
            java.lang.String r7 = r8.toString()
        L_0x00be:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.service.SplitApksEventsService.a(int, android.content.Intent):java.lang.String");
    }

    public IBinder onBind(Intent intent) {
        m.e(intent, "intent");
        return null;
    }

    public int onStartCommand(Intent intent, int i4, int i5) {
        Parcelable parcelable;
        String str;
        String str2;
        m.e(intent, "intent");
        int intExtra = intent.getIntExtra("android.content.pm.extra.STATUS", -999);
        f fVar = new f(intExtra);
        f.a aVar = f.f8302c;
        k.a aVar2 = k.f7778g;
        if (!aVar.a(aVar2.m(), fVar)) {
            aVar2.F(fVar);
            if (intExtra != -1) {
                Long l4 = null;
                if (intExtra == 0) {
                    T1.a i6 = aVar2.i();
                    Bundle bundle = new Bundle();
                    bundle.putInt("piStatus", intExtra);
                    if (i6 != null) {
                        str = i6.b();
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        bundle.putString("packagename", i6.b());
                    }
                    if (i6 != null) {
                        l4 = Long.valueOf(i6.c());
                    }
                    if (l4 != null && i6.c() > 0) {
                        bundle.putLong("size", i6.c());
                    }
                    Application application = getApplication();
                    m.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
                    ((k) application).N().send(228, bundle);
                    aVar2.e();
                    C1006v a5 = j.f8686d.a();
                    if (a5 != null) {
                        a5.v(Boolean.TRUE);
                    }
                } else if (intExtra != 3) {
                    T1.a i7 = aVar2.i();
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("piStatus", intExtra);
                    if (i7 != null) {
                        str2 = i7.b();
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        bundle2.putString("packagename", i7.b());
                    }
                    if (i7 != null) {
                        l4 = Long.valueOf(i7.c());
                    }
                    if (l4 != null && i7.c() > 0) {
                        bundle2.putLong("size", i7.c());
                    }
                    bundle2.putString("extra_error", a(intExtra, intent));
                    Application application2 = getApplication();
                    m.c(application2, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
                    ((k) application2).N().send(227, bundle2);
                    aVar2.e();
                    C1006v a6 = j.f8686d.a();
                    if (a6 != null) {
                        a6.v(Boolean.FALSE);
                    }
                } else {
                    aVar2.e();
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("piStatus", intExtra);
                    Application application3 = getApplication();
                    m.c(application3, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
                    ((k) application3).N().send(223, bundle3);
                    C1006v a7 = j.f8686d.a();
                    if (a7 != null) {
                        a7.v(Boolean.FALSE);
                    }
                }
            } else {
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) intent.getParcelableExtra("android.intent.extra.INTENT", Intent.class);
                } else {
                    parcelable = intent.getParcelableExtra("android.intent.extra.INTENT");
                }
                Intent intent2 = new Intent(this, ConfirmationIntentWrapperActivity.class);
                intent2.putExtra("com.uptodown.sapk.confirmation_intent", (Intent) parcelable);
                intent2.addFlags(268435456);
                startActivity(intent2);
            }
        }
        stopSelf();
        return 2;
    }
}
