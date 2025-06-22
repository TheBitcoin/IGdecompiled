package com.uptodown.workers;

import N1.k;
import W1.C1611g;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import u2.t;

public final class SearchApksWorker extends Worker {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19507b = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private Context f19508a;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchApksWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.e(context, "context");
        m.e(workerParameters, "params");
        this.f19508a = context;
        this.f19508a = k.f7778g.a(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean a(java.io.File r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = r10.getName()
            java.lang.String r1 = "getName(...)"
            kotlin.jvm.internal.m.d(r0, r1)
            r2 = 2
            java.lang.String r3 = ".apk"
            r4 = 0
            r5 = 0
            boolean r0 = m3.m.o(r0, r3, r4, r2, r5)
            r2 = -1
            if (r0 == 0) goto L_0x0058
            android.content.Context r0 = r9.f19508a     // Catch:{ NameNotFoundException -> 0x0048 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0048 }
            java.lang.String r1 = "getPackageManager(...)"
            kotlin.jvm.internal.m.d(r0, r1)     // Catch:{ NameNotFoundException -> 0x0048 }
            java.lang.String r1 = r10.getAbsolutePath()     // Catch:{ NameNotFoundException -> 0x0048 }
            java.lang.String r6 = "getAbsolutePath(...)"
            kotlin.jvm.internal.m.d(r1, r6)     // Catch:{ NameNotFoundException -> 0x0048 }
            r6 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r0 = W1.s.c(r0, r1, r6)     // Catch:{ NameNotFoundException -> 0x0048 }
            if (r0 == 0) goto L_0x004a
            android.content.Context r1 = r9.f19508a     // Catch:{ NameNotFoundException -> 0x0046 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0046 }
            if (r1 == 0) goto L_0x004a
            java.lang.String r6 = r0.packageName     // Catch:{ NameNotFoundException -> 0x0046 }
            java.lang.String r7 = "packageName"
            kotlin.jvm.internal.m.d(r6, r7)     // Catch:{ NameNotFoundException -> 0x0046 }
            android.content.pm.PackageInfo r5 = W1.s.d(r1, r6, r4)     // Catch:{ NameNotFoundException -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            goto L_0x004a
        L_0x0048:
            r0 = r5
        L_0x004a:
            if (r0 == 0) goto L_0x0056
            W1.h r1 = new W1.h
            r1.<init>()
            long r0 = r1.m(r0)
            goto L_0x008d
        L_0x0056:
            r0 = r2
            goto L_0x008d
        L_0x0058:
            W1.G$a r0 = W1.G.f8470b
            java.lang.String r6 = r10.getName()
            kotlin.jvm.internal.m.d(r6, r1)
            boolean r0 = r0.a(r6)
            if (r0 == 0) goto L_0x0056
            W1.G r0 = new W1.G
            r0.<init>()
            android.content.Context r1 = r9.f19508a
            T1.i r0 = r0.e(r10, r1)
            if (r0 == 0) goto L_0x008c
            long r6 = r0.b()
            android.content.Context r1 = r9.f19508a     // Catch:{ NameNotFoundException -> 0x0089 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0089 }
            if (r1 == 0) goto L_0x008a
            java.lang.String r0 = r0.a()     // Catch:{ NameNotFoundException -> 0x0089 }
            android.content.pm.PackageInfo r5 = W1.s.d(r1, r0, r4)     // Catch:{ NameNotFoundException -> 0x0089 }
            goto L_0x008a
        L_0x0089:
        L_0x008a:
            r0 = r6
            goto L_0x008d
        L_0x008c:
            return r4
        L_0x008d:
            if (r5 == 0) goto L_0x0099
            W1.h r6 = new W1.h
            r6.<init>()
            long r5 = r6.m(r5)
            goto L_0x009a
        L_0x0099:
            r5 = r2
        L_0x009a:
            r7 = 1
            int r8 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x00c2
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x00c1
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x00af
            u2.C r0 = u2.C2313C.f21882a
            android.content.Context r1 = r9.f19508a
            r0.n(r1, r10, r4, r11)
            return r7
        L_0x00af:
            if (r2 >= 0) goto L_0x00b9
            u2.C r0 = u2.C2313C.f21882a
            android.content.Context r1 = r9.f19508a
            r0.n(r1, r10, r7, r11)
            return r7
        L_0x00b9:
            u2.C r0 = u2.C2313C.f21882a
            android.content.Context r1 = r9.f19508a
            r0.n(r1, r10, r4, r11)
            return r7
        L_0x00c1:
            return r4
        L_0x00c2:
            u2.C r0 = u2.C2313C.f21882a
            android.content.Context r1 = r9.f19508a
            r0.n(r1, r10, r7, r11)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.SearchApksWorker.a(java.io.File, int):boolean");
    }

    public ListenableWorker.Result doWork() {
        boolean z4;
        ListenableWorker.Result success = ListenableWorker.Result.success();
        m.d(success, "success(...)");
        try {
            ArrayList o4 = new C1611g().o(this.f19508a);
            t a5 = t.f21927u.a(this.f19508a);
            a5.a();
            ArrayList p02 = a5.p0();
            Iterator it = o4.iterator();
            m.d(it, "iterator(...)");
            int i4 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                File file = (File) next;
                Iterator it2 = p02.iterator();
                int i5 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i5 = -1;
                        z4 = false;
                        break;
                    }
                    int i6 = i5 + 1;
                    if (m3.m.p(file.getAbsolutePath(), (String) it2.next(), false)) {
                        z4 = true;
                        break;
                    }
                    i5 = i6;
                }
                if (z4) {
                    p02.remove(i5);
                } else if (i4 < 10 && a(file, i4)) {
                    a5.Q0(file.getAbsolutePath());
                    i4++;
                }
            }
            Iterator it3 = p02.iterator();
            m.d(it3, "iterator(...)");
            while (it3.hasNext()) {
                Object next2 = it3.next();
                m.d(next2, "next(...)");
                a5.G((String) next2);
            }
            a5.i();
            return success;
        } catch (Exception e5) {
            e5.printStackTrace();
            return ListenableWorker.Result.failure();
        }
    }
}
