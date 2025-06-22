package j0;

import M.C0335p;
import R.d;
import R.g;
import R.n;
import R.p;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import c0.b;
import c0.c;
import c0.h;
import c0.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class a {

    /* renamed from: r  reason: collision with root package name */
    private static final long f3435r = TimeUnit.DAYS.toMillis(366);

    /* renamed from: s  reason: collision with root package name */
    private static volatile ScheduledExecutorService f3436s = null;

    /* renamed from: t  reason: collision with root package name */
    private static final Object f3437t = new Object();

    /* renamed from: u  reason: collision with root package name */
    private static volatile e f3438u = new c();

    /* renamed from: a  reason: collision with root package name */
    private final Object f3439a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final PowerManager.WakeLock f3440b;

    /* renamed from: c  reason: collision with root package name */
    private int f3441c = 0;

    /* renamed from: d  reason: collision with root package name */
    private Future f3442d;

    /* renamed from: e  reason: collision with root package name */
    private long f3443e;

    /* renamed from: f  reason: collision with root package name */
    private final Set f3444f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private boolean f3445g = true;

    /* renamed from: h  reason: collision with root package name */
    private int f3446h;

    /* renamed from: i  reason: collision with root package name */
    b f3447i;

    /* renamed from: j  reason: collision with root package name */
    private d f3448j = g.b();

    /* renamed from: k  reason: collision with root package name */
    private WorkSource f3449k;

    /* renamed from: l  reason: collision with root package name */
    private final String f3450l;

    /* renamed from: m  reason: collision with root package name */
    private final String f3451m;

    /* renamed from: n  reason: collision with root package name */
    private final Context f3452n;

    /* renamed from: o  reason: collision with root package name */
    private final Map f3453o = new HashMap();

    /* renamed from: p  reason: collision with root package name */
    private AtomicInteger f3454p = new AtomicInteger(0);

    /* renamed from: q  reason: collision with root package name */
    private final ScheduledExecutorService f3455q;

    public a(Context context, int i4, String str) {
        String str2;
        String packageName = context.getPackageName();
        C0335p.m(context, "WakeLock: context must not be null");
        C0335p.g(str, "WakeLock: wakeLockName must not be empty");
        this.f3452n = context.getApplicationContext();
        this.f3451m = str;
        this.f3447i = null;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "*gcore*:".concat(valueOf);
            } else {
                str2 = new String("*gcore*:");
            }
            this.f3450l = str2;
        } else {
            this.f3450l = str;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(i4, str);
            this.f3440b = newWakeLock;
            if (p.c(context)) {
                WorkSource b5 = p.b(context, n.a(packageName) ? context.getPackageName() : packageName);
                this.f3449k = b5;
                if (b5 != null) {
                    i(newWakeLock, b5);
                }
            }
            ScheduledExecutorService scheduledExecutorService = f3436s;
            if (scheduledExecutorService == null) {
                synchronized (f3437t) {
                    try {
                        scheduledExecutorService = f3436s;
                        if (scheduledExecutorService == null) {
                            h.a();
                            scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                            f3436s = scheduledExecutorService;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            this.f3455q = scheduledExecutorService;
            return;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("expected a non-null reference", 0, 29);
        throw new i(sb.toString());
    }

    public static /* synthetic */ void e(a aVar) {
        synchronized (aVar.f3439a) {
            try {
                if (aVar.b()) {
                    Log.e("WakeLock", String.valueOf(aVar.f3450l).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                    aVar.g();
                    if (aVar.b()) {
                        aVar.f3441c = 1;
                        aVar.h(0);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final String f(String str) {
        if (this.f3445g) {
            TextUtils.isEmpty((CharSequence) null);
        }
        return null;
    }

    private final void g() {
        if (!this.f3444f.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.f3444f);
            this.f3444f.clear();
            if (arrayList.size() > 0) {
                android.support.v4.media.a.a(arrayList.get(0));
                throw null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a6, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void h(int r6) {
        /*
            r5 = this;
            java.lang.Object r6 = r5.f3439a
            monitor-enter(r6)
            boolean r0 = r5.b()     // Catch:{ all -> 0x000b }
            if (r0 != 0) goto L_0x000e
            monitor-exit(r6)     // Catch:{ all -> 0x000b }
            return
        L_0x000b:
            r0 = move-exception
            goto L_0x00a7
        L_0x000e:
            boolean r0 = r5.f3445g     // Catch:{ all -> 0x000b }
            r1 = 0
            if (r0 == 0) goto L_0x001e
            int r0 = r5.f3441c     // Catch:{ all -> 0x000b }
            int r0 = r0 + -1
            r5.f3441c = r0     // Catch:{ all -> 0x000b }
            if (r0 > 0) goto L_0x001c
            goto L_0x0020
        L_0x001c:
            monitor-exit(r6)     // Catch:{ all -> 0x000b }
            return
        L_0x001e:
            r5.f3441c = r1     // Catch:{ all -> 0x000b }
        L_0x0020:
            r5.g()     // Catch:{ all -> 0x000b }
            java.util.Map r0 = r5.f3453o     // Catch:{ all -> 0x000b }
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x000b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x000b }
        L_0x002d:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x000b }
            if (r2 == 0) goto L_0x003c
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x000b }
            j0.d r2 = (j0.d) r2     // Catch:{ all -> 0x000b }
            r2.f3457a = r1     // Catch:{ all -> 0x000b }
            goto L_0x002d
        L_0x003c:
            java.util.Map r0 = r5.f3453o     // Catch:{ all -> 0x000b }
            r0.clear()     // Catch:{ all -> 0x000b }
            java.util.concurrent.Future r0 = r5.f3442d     // Catch:{ all -> 0x000b }
            r2 = 0
            if (r0 == 0) goto L_0x004f
            r0.cancel(r1)     // Catch:{ all -> 0x000b }
            r5.f3442d = r2     // Catch:{ all -> 0x000b }
            r3 = 0
            r5.f3443e = r3     // Catch:{ all -> 0x000b }
        L_0x004f:
            r5.f3446h = r1     // Catch:{ all -> 0x000b }
            android.os.PowerManager$WakeLock r0 = r5.f3440b     // Catch:{ all -> 0x000b }
            boolean r0 = r0.isHeld()     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x0094
            android.os.PowerManager$WakeLock r0 = r5.f3440b     // Catch:{ RuntimeException -> 0x0067 }
            r0.release()     // Catch:{ RuntimeException -> 0x0067 }
            c0.b r0 = r5.f3447i     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x00a5
            r5.f3447i = r2     // Catch:{ all -> 0x000b }
            goto L_0x00a5
        L_0x0065:
            r0 = move-exception
            goto L_0x008d
        L_0x0067:
            r0 = move-exception
            java.lang.Class r1 = r0.getClass()     // Catch:{ all -> 0x0065 }
            java.lang.Class<java.lang.RuntimeException> r3 = java.lang.RuntimeException.class
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x008c
            java.lang.String r1 = "WakeLock"
            java.lang.String r3 = r5.f3450l     // Catch:{ all -> 0x0065 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0065 }
            java.lang.String r4 = " failed to release!"
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x0065 }
            android.util.Log.e(r1, r3, r0)     // Catch:{ all -> 0x0065 }
            c0.b r0 = r5.f3447i     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x00a5
            r5.f3447i = r2     // Catch:{ all -> 0x000b }
            goto L_0x00a5
        L_0x008c:
            throw r0     // Catch:{ all -> 0x0065 }
        L_0x008d:
            c0.b r1 = r5.f3447i     // Catch:{ all -> 0x000b }
            if (r1 == 0) goto L_0x0093
            r5.f3447i = r2     // Catch:{ all -> 0x000b }
        L_0x0093:
            throw r0     // Catch:{ all -> 0x000b }
        L_0x0094:
            java.lang.String r0 = "WakeLock"
            java.lang.String r1 = r5.f3450l     // Catch:{ all -> 0x000b }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x000b }
            java.lang.String r2 = " should be held!"
            java.lang.String r1 = r1.concat(r2)     // Catch:{ all -> 0x000b }
            android.util.Log.e(r0, r1)     // Catch:{ all -> 0x000b }
        L_0x00a5:
            monitor-exit(r6)     // Catch:{ all -> 0x000b }
            return
        L_0x00a7:
            monitor-exit(r6)     // Catch:{ all -> 0x000b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.a.h(int):void");
    }

    private static void i(PowerManager.WakeLock wakeLock, WorkSource workSource) {
        try {
            wakeLock.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e5) {
            Log.wtf("WakeLock", e5.toString());
        }
    }

    public void a(long j4) {
        this.f3454p.incrementAndGet();
        long j5 = Long.MAX_VALUE;
        long max = Math.max(Math.min(Long.MAX_VALUE, f3435r), 1);
        if (j4 > 0) {
            max = Math.min(j4, max);
        }
        synchronized (this.f3439a) {
            try {
                if (!b()) {
                    this.f3447i = b.a(false, (c) null);
                    this.f3440b.acquire();
                    this.f3448j.elapsedRealtime();
                }
                this.f3441c++;
                this.f3446h++;
                f((String) null);
                d dVar = (d) this.f3453o.get((Object) null);
                if (dVar == null) {
                    dVar = new d((c) null);
                    this.f3453o.put((Object) null, dVar);
                }
                dVar.f3457a++;
                long elapsedRealtime = this.f3448j.elapsedRealtime();
                if (Long.MAX_VALUE - elapsedRealtime > max) {
                    j5 = elapsedRealtime + max;
                }
                if (j5 > this.f3443e) {
                    this.f3443e = j5;
                    Future future = this.f3442d;
                    if (future != null) {
                        future.cancel(false);
                    }
                    this.f3442d = this.f3455q.schedule(new b(this), max, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b() {
        boolean z4;
        synchronized (this.f3439a) {
            if (this.f3441c > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        return z4;
    }

    public void c() {
        if (this.f3454p.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f3450l).concat(" release without a matched acquire!"));
        }
        synchronized (this.f3439a) {
            try {
                f((String) null);
                if (this.f3453o.containsKey((Object) null)) {
                    d dVar = (d) this.f3453o.get((Object) null);
                    if (dVar != null) {
                        int i4 = dVar.f3457a - 1;
                        dVar.f3457a = i4;
                        if (i4 == 0) {
                            this.f3453o.remove((Object) null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f3450l).concat(" counter does not exist"));
                }
                h(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(boolean z4) {
        synchronized (this.f3439a) {
            this.f3445g = z4;
        }
    }
}
