package C;

import J.C0302a;
import J.C0309h;
import J.C0310i;
import J.C0313l;
import M.C0335p;
import Q.b;
import W.e;
import W.f;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.work.WorkRequest;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class a {

    /* renamed from: a  reason: collision with root package name */
    C0302a f95a;

    /* renamed from: b  reason: collision with root package name */
    f f96b;

    /* renamed from: c  reason: collision with root package name */
    boolean f97c;

    /* renamed from: d  reason: collision with root package name */
    final Object f98d = new Object();

    /* renamed from: e  reason: collision with root package name */
    c f99e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f100f;

    /* renamed from: g  reason: collision with root package name */
    final long f101g;

    /* renamed from: C.a$a  reason: collision with other inner class name */
    public static final class C0000a {

        /* renamed from: a  reason: collision with root package name */
        private final String f102a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f103b;

        public C0000a(String str, boolean z4) {
            this.f102a = str;
            this.f103b = z4;
        }

        public String a() {
            return this.f102a;
        }

        public boolean b() {
            return this.f103b;
        }

        public String toString() {
            String str = this.f102a;
            boolean z4 = this.f103b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z4);
            return sb.toString();
        }
    }

    public a(Context context, long j4, boolean z4, boolean z5) {
        Context applicationContext;
        C0335p.l(context);
        if (z4 && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f100f = context;
        this.f97c = false;
        this.f101g = j4;
    }

    public static C0000a a(Context context) {
        a aVar = new a(context, -1, true, false);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            aVar.d(false);
            C0000a f4 = aVar.f(-1);
            aVar.e(f4, true, 0.0f, SystemClock.elapsedRealtime() - elapsedRealtime, "", (Throwable) null);
            aVar.c();
            return f4;
        } catch (Throwable th) {
            Throwable th2 = th;
            aVar.c();
            throw th2;
        }
    }

    private final C0000a f(int i4) {
        C0000a aVar;
        C0335p.k("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f97c) {
                    synchronized (this.f98d) {
                        c cVar = this.f99e;
                        if (cVar == null || !cVar.f108d) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    d(false);
                    if (!this.f97c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                }
                C0335p.l(this.f95a);
                C0335p.l(this.f96b);
                aVar = new C0000a(this.f96b.b(), this.f96b.s(true));
            } catch (RemoteException e5) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e5);
                throw new IOException("Remote exception");
            } catch (Exception e6) {
                throw new IOException("AdvertisingIdClient cannot reconnect.", e6);
            } catch (Throwable th) {
                throw th;
            }
        }
        g();
        return aVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|(3:5|6|7)|9|10|(1:12)|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0014 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void g() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f98d
            monitor-enter(r0)
            C.c r1 = r6.f99e     // Catch:{ all -> 0x0012 }
            if (r1 == 0) goto L_0x0014
            java.util.concurrent.CountDownLatch r1 = r1.f107c     // Catch:{ all -> 0x0012 }
            r1.countDown()     // Catch:{ all -> 0x0012 }
            C.c r1 = r6.f99e     // Catch:{ InterruptedException -> 0x0014 }
            r1.join()     // Catch:{ InterruptedException -> 0x0014 }
            goto L_0x0014
        L_0x0012:
            r1 = move-exception
            goto L_0x0025
        L_0x0014:
            long r1 = r6.f101g     // Catch:{ all -> 0x0012 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0023
            C.c r3 = new C.c     // Catch:{ all -> 0x0012 }
            r3.<init>(r6, r1)     // Catch:{ all -> 0x0012 }
            r6.f99e = r3     // Catch:{ all -> 0x0012 }
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            return
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: C.a.g():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r3 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            M.C0335p.k(r0)
            monitor-enter(r3)
            android.content.Context r0 = r3.f100f     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0033
            J.a r0 = r3.f95a     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x000f
            goto L_0x0033
        L_0x000f:
            boolean r0 = r3.f97c     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0027
            Q.b r0 = Q.b.b()     // Catch:{ all -> 0x001f }
            android.content.Context r1 = r3.f100f     // Catch:{ all -> 0x001f }
            J.a r2 = r3.f95a     // Catch:{ all -> 0x001f }
            r0.c(r1, r2)     // Catch:{ all -> 0x001f }
            goto L_0x0027
        L_0x001f:
            r0 = move-exception
            java.lang.String r1 = "AdvertisingIdClient"
            java.lang.String r2 = "AdvertisingIdClient unbindService failed."
            android.util.Log.i(r1, r2, r0)     // Catch:{ all -> 0x0031 }
        L_0x0027:
            r0 = 0
            r3.f97c = r0     // Catch:{ all -> 0x0031 }
            r0 = 0
            r3.f96b = r0     // Catch:{ all -> 0x0031 }
            r3.f95a = r0     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            return
        L_0x0031:
            r0 = move-exception
            goto L_0x0035
        L_0x0033:
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            return
        L_0x0035:
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: C.a.c():void");
    }

    /* access modifiers changed from: protected */
    public final void d(boolean z4) {
        C0335p.k("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f97c) {
                    c();
                }
                Context context = this.f100f;
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                int h4 = C0309h.f().h(context, C0313l.f342a);
                if (h4 != 0) {
                    if (h4 != 2) {
                        throw new IOException("Google Play services not available");
                    }
                }
                C0302a aVar = new C0302a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (b.b().a(context, intent, aVar, 1)) {
                    this.f95a = aVar;
                    this.f96b = e.h(aVar.a(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS));
                    this.f97c = true;
                    if (z4) {
                        g();
                    }
                } else {
                    throw new IOException("Connection failure");
                }
            } catch (PackageManager.NameNotFoundException unused) {
                throw new C0310i(9);
            } catch (InterruptedException unused2) {
                throw new IOException("Interrupted exception");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean e(C0000a aVar, boolean z4, float f4, long j4, String str, Throwable th) {
        if (Math.random() > 0.0d) {
            return false;
        }
        HashMap hashMap = new HashMap();
        String str2 = "1";
        hashMap.put("app_context", str2);
        if (aVar != null) {
            if (true != aVar.b()) {
                str2 = "0";
            }
            hashMap.put("limit_ad_tracking", str2);
            String a5 = aVar.a();
            if (a5 != null) {
                hashMap.put("ad_id_size", Integer.toString(a5.length()));
            }
        }
        if (th != null) {
            hashMap.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, th.getClass().getName());
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j4));
        new b(this, hashMap).start();
        return true;
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        c();
        super.finalize();
    }

    public static void b(boolean z4) {
    }
}
