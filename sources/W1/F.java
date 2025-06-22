package W1;

import N1.k;
import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageInstallObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import d3.p;
import java.io.File;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;

public final class F {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f8461a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final S1.a f8462b;

    public final class a extends IPackageInstallObserver.Stub {
        public a() {
        }

        public void packageInstalled(String str, int i4) {
            m.e(str, "packageName");
            if (i4 == 1) {
                S1.a b5 = F.this.f8462b;
                if (b5 != null) {
                    b5.b(str);
                }
                k.a aVar = k.f7778g;
                if (aVar.v() != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("packageName", str);
                    ResultReceiver v4 = aVar.v();
                    if (v4 != null) {
                        v4.send(352, bundle);
                    }
                }
            }
            k.f7778g.e();
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8464a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ F f8465b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f8466c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(F f4, File file, d dVar) {
            super(2, dVar);
            this.f8465b = f4;
            this.f8466c = file;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f8465b, this.f8466c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f8464a;
            if (i4 == 0) {
                n.b(obj);
                F f4 = this.f8465b;
                File file = this.f8466c;
                this.f8464a = 1;
                if (f4.h(file, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8467a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ F f8468b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f8469c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(F f4, File file, d dVar) {
            super(2, dVar);
            this.f8468b = f4;
            this.f8469c = file;
        }

        public final d create(Object obj, d dVar) {
            return new c(this.f8468b, this.f8469c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8467a == 0) {
                n.b(obj);
                try {
                    if (new P1.a(this.f8468b.f8461a).s()) {
                        this.f8468b.g(this.f8469c);
                        return s.f8222a;
                    }
                    S1.a b5 = this.f8468b.f8462b;
                    if (b5 == null) {
                        return null;
                    }
                    b5.f(this.f8469c.getPath());
                    return s.f8222a;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return s.f8222a;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invoke(J j4, d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public F(Context context, S1.a aVar) {
        m.e(context, "context");
        this.f8461a = context;
        this.f8462b = aVar;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:4|5|6|7|8|9|(4:11|(1:13)|18|(2:20|(2:22|23)(1:63))(1:62))|26|27|(1:29)|30|(2:32|(1:34))|35|64) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x008d */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0091 A[Catch:{ Exception -> 0x006b, Error -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3 A[Catch:{ Exception -> 0x006b, Error -> 0x0068 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(java.io.File r27) {
        /*
            r26 = this;
            r1 = r26
            r4 = 4
            r5 = 0
            java.lang.String r6 = "versionCode"
            java.lang.String r7 = "packageName"
            java.lang.String r8 = "fileName"
            java.lang.String r9 = "apkFile.absolutePath"
            java.lang.String r10 = "apkFile.name"
            r11 = 353(0x161, float:4.95E-43)
            android.content.Context r12 = r1.f8461a     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            android.content.pm.PackageManager r12 = r12.getPackageManager()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.String r13 = "pm"
            kotlin.jvm.internal.m.d(r12, r13)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.String r13 = r27.getAbsolutePath()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            kotlin.jvm.internal.m.d(r13, r9)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r14 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r13 = W1.s.c(r12, r13, r14)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            if (r13 == 0) goto L_0x012d
            android.content.pm.ApplicationInfo r14 = r13.applicationInfo     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.String r14 = r14.packageName     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            W1.h r15 = new W1.h     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r15.<init>()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r16 = 1
            r17 = 2
            long r2 = r15.m(r13)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            android.content.Context r15 = r1.f8461a     // Catch:{ NameNotFoundException -> 0x008b }
            android.content.pm.PackageManager r15 = r15.getPackageManager()     // Catch:{ NameNotFoundException -> 0x008b }
            r18 = 3
            java.lang.String r0 = "context.packageManager"
            kotlin.jvm.internal.m.d(r15, r0)     // Catch:{ NameNotFoundException -> 0x008d }
            android.content.pm.PackageInfo r0 = W1.s.d(r15, r14, r5)     // Catch:{ NameNotFoundException -> 0x008d }
            W1.h r15 = new W1.h     // Catch:{ NameNotFoundException -> 0x008d }
            r15.<init>()     // Catch:{ NameNotFoundException -> 0x008d }
            long r19 = r15.m(r0)     // Catch:{ NameNotFoundException -> 0x008d }
            int r0 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x008d
            S1.a r0 = r1.f8462b     // Catch:{ NameNotFoundException -> 0x008d }
            if (r0 == 0) goto L_0x006e
            java.lang.String r15 = r27.getName()     // Catch:{ NameNotFoundException -> 0x008d }
            kotlin.jvm.internal.m.d(r15, r10)     // Catch:{ NameNotFoundException -> 0x008d }
            r0.e(r15)     // Catch:{ NameNotFoundException -> 0x008d }
            goto L_0x006e
        L_0x0068:
            r0 = move-exception
            goto L_0x0159
        L_0x006b:
            r0 = move-exception
            goto L_0x018c
        L_0x006e:
            N1.k$a r0 = N1.k.f7778g     // Catch:{ NameNotFoundException -> 0x008d }
            android.os.ResultReceiver r15 = r0.v()     // Catch:{ NameNotFoundException -> 0x008d }
            if (r15 == 0) goto L_0x01be
            android.os.Bundle r15 = new android.os.Bundle     // Catch:{ NameNotFoundException -> 0x008d }
            r15.<init>()     // Catch:{ NameNotFoundException -> 0x008d }
            r15.putString(r7, r14)     // Catch:{ NameNotFoundException -> 0x008d }
            r15.putLong(r6, r2)     // Catch:{ NameNotFoundException -> 0x008d }
            android.os.ResultReceiver r0 = r0.v()     // Catch:{ NameNotFoundException -> 0x008d }
            if (r0 == 0) goto L_0x01be
            r0.send(r11, r15)     // Catch:{ NameNotFoundException -> 0x008d }
            return
        L_0x008b:
            r18 = 3
        L_0x008d:
            S1.a r0 = r1.f8462b     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            if (r0 == 0) goto L_0x009b
            java.lang.String r15 = r27.getName()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            kotlin.jvm.internal.m.d(r15, r10)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r0.a(r15)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
        L_0x009b:
            N1.k$a r19 = N1.k.f7778g     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            android.os.ResultReceiver r0 = r19.v()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            if (r0 == 0) goto L_0x00b9
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r0.<init>()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r0.putString(r7, r14)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r0.putLong(r6, r2)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            android.os.ResultReceiver r2 = r19.v()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            if (r2 == 0) goto L_0x00b9
            r3 = 351(0x15f, float:4.92E-43)
            r2.send(r3, r0)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
        L_0x00b9:
            W1.h r0 = new W1.h     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r0.<init>()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.String r2 = r27.getAbsolutePath()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            kotlin.jvm.internal.m.d(r2, r9)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.String r23 = r0.b(r13, r2, r12)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            W1.h r0 = new W1.h     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r0.<init>()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            long r21 = r0.m(r13)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            W1.g r0 = new W1.g     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r0.<init>()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.String r2 = r27.getAbsolutePath()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            kotlin.jvm.internal.m.d(r2, r9)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            long r24 = r0.f(r2)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.String r0 = r13.packageName     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.String r2 = "piToInstall.packageName"
            kotlin.jvm.internal.m.d(r0, r2)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r20 = r0
            r19.y(r20, r21, r23, r24)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            W1.F$a r0 = new W1.F$a     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r0.<init>()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.Class[] r2 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.Class<android.net.Uri> r3 = android.net.Uri.class
            r2[r5] = r3     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.Class<android.content.pm.IPackageInstallObserver> r3 = android.content.pm.IPackageInstallObserver.class
            r2[r16] = r3     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r2[r17] = r3     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r18] = r3     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.Class r3 = r12.getClass()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.String r6 = "installPackage"
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r4)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.Class[] r2 = (java.lang.Class[]) r2     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.reflect.Method r2 = r3.getMethod(r6, r2)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            android.net.Uri r3 = android.net.Uri.fromFile(r27)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r4[r5] = r3     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r4[r16] = r0     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r4[r17] = r6     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r0 = 0
            r4[r18] = r0     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r2.invoke(r12, r4)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            goto L_0x01be
        L_0x012d:
            S1.a r0 = r1.f8462b     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            if (r0 == 0) goto L_0x013b
            java.lang.String r2 = r27.getName()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            kotlin.jvm.internal.m.d(r2, r10)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r0.d(r2)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
        L_0x013b:
            N1.k$a r0 = N1.k.f7778g     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            android.os.ResultReceiver r2 = r0.v()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            if (r2 == 0) goto L_0x01be
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r2.<init>()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            java.lang.String r3 = r27.getName()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            r2.putString(r8, r3)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            android.os.ResultReceiver r0 = r0.v()     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            if (r0 == 0) goto L_0x01be
            r0.send(r11, r2)     // Catch:{ Exception -> 0x006b, Error -> 0x0068 }
            return
        L_0x0159:
            N1.k$a r2 = N1.k.f7778g
            r2.e()
            S1.a r3 = r1.f8462b
            if (r3 == 0) goto L_0x0170
            java.lang.String r4 = r27.getName()
            kotlin.jvm.internal.m.d(r4, r10)
            java.lang.String r0 = r0.getMessage()
            r3.c(r4, r0)
        L_0x0170:
            android.os.ResultReceiver r0 = r2.v()
            if (r0 == 0) goto L_0x01be
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r3 = r27.getName()
            r0.putString(r8, r3)
            android.os.ResultReceiver r2 = r2.v()
            if (r2 == 0) goto L_0x01be
            r2.send(r11, r0)
            goto L_0x01be
        L_0x018c:
            N1.k$a r2 = N1.k.f7778g
            r2.e()
            S1.a r3 = r1.f8462b
            if (r3 == 0) goto L_0x01a3
            java.lang.String r4 = r27.getName()
            kotlin.jvm.internal.m.d(r4, r10)
            java.lang.String r0 = r0.getMessage()
            r3.c(r4, r0)
        L_0x01a3:
            android.os.ResultReceiver r0 = r2.v()
            if (r0 == 0) goto L_0x01be
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r3 = r27.getName()
            r0.putString(r8, r3)
            android.os.ResultReceiver r2 = r2.v()
            if (r2 == 0) goto L_0x01be
            r2.send(r11, r0)
        L_0x01be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.F.g(java.io.File):void");
    }

    /* access modifiers changed from: private */
    public final Object h(File file, d dVar) {
        return C0977g.g(Y.b(), new c(this, file, (d) null), dVar);
    }

    public final boolean e() {
        PackageManager packageManager = this.f8461a.getPackageManager();
        int checkPermission = packageManager.checkPermission("android.permission.INSTALL_PACKAGES", this.f8461a.getPackageName());
        int checkPermission2 = packageManager.checkPermission("android.permission.DELETE_PACKAGES", this.f8461a.getPackageName());
        if (checkPermission == 0 && checkPermission2 == 0) {
            return true;
        }
        try {
            m.d(packageManager, "pm");
            String packageName = this.f8461a.getPackageName();
            m.d(packageName, "context.packageName");
            return i(s.d(packageManager, packageName, 4096));
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final void f(File file) {
        m.e(file, "file");
        C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (L) null, new b(this, file, (d) null), 3, (Object) null);
    }

    public final boolean i(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo;
        if (packageInfo != null) {
            applicationInfo = packageInfo.applicationInfo;
        } else {
            applicationInfo = null;
        }
        if (applicationInfo == null || (packageInfo.applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) {
            return false;
        }
        return true;
    }
}
