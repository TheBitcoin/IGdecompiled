package F0;

import G0.d;
import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k0.C0938m;
import o.C0963d;
import o.f;
import o.i;
import q.l;
import v0.g;
import y0.C2408A;
import y0.N;
import y0.c0;

/* renamed from: F0.e  reason: case insensitive filesystem */
final class C1298e {

    /* renamed from: a  reason: collision with root package name */
    private final double f6433a;

    /* renamed from: b  reason: collision with root package name */
    private final double f6434b;

    /* renamed from: c  reason: collision with root package name */
    private final long f6435c;

    /* renamed from: d  reason: collision with root package name */
    private final long f6436d;

    /* renamed from: e  reason: collision with root package name */
    private final int f6437e;

    /* renamed from: f  reason: collision with root package name */
    private final BlockingQueue f6438f;

    /* renamed from: g  reason: collision with root package name */
    private final ThreadPoolExecutor f6439g;

    /* renamed from: h  reason: collision with root package name */
    private final i f6440h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final N f6441i;

    /* renamed from: j  reason: collision with root package name */
    private int f6442j;

    /* renamed from: k  reason: collision with root package name */
    private long f6443k;

    /* renamed from: F0.e$b */
    private final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final C2408A f6444a;

        /* renamed from: b  reason: collision with root package name */
        private final C0938m f6445b;

        public void run() {
            C1298e.this.n(this.f6444a, this.f6445b);
            C1298e.this.f6441i.c();
            double e5 = C1298e.this.g();
            g f4 = g.f();
            f4.b("Delay for: " + String.format(Locale.US, "%.2f", new Object[]{Double.valueOf(e5 / 1000.0d)}) + " s for report: " + this.f6444a.d());
            C1298e.o(e5);
        }

        private b(C2408A a5, C0938m mVar) {
            this.f6444a = a5;
            this.f6445b = mVar;
        }
    }

    C1298e(i iVar, d dVar, N n4) {
        this(dVar.f6526f, dVar.f6527g, ((long) dVar.f6528h) * 1000, iVar, n4);
    }

    public static /* synthetic */ void a(C1298e eVar, C0938m mVar, boolean z4, C2408A a5, Exception exc) {
        eVar.getClass();
        if (exc != null) {
            mVar.d(exc);
            return;
        }
        if (z4) {
            eVar.j();
        }
        mVar.e(a5);
    }

    public static /* synthetic */ void b(C1298e eVar, CountDownLatch countDownLatch) {
        eVar.getClass();
        try {
            l.a(eVar.f6440h, f.HIGHEST);
        } catch (Exception unused) {
        }
        countDownLatch.countDown();
    }

    /* access modifiers changed from: private */
    public double g() {
        return Math.min(3600000.0d, (60000.0d / this.f6433a) * Math.pow(this.f6434b, (double) h()));
    }

    private int h() {
        int i4;
        if (this.f6443k == 0) {
            this.f6443k = m();
        }
        int m4 = (int) ((m() - this.f6443k) / this.f6435c);
        if (l()) {
            i4 = Math.min(100, this.f6442j + m4);
        } else {
            i4 = Math.max(0, this.f6442j - m4);
        }
        if (this.f6442j != i4) {
            this.f6442j = i4;
            this.f6443k = m();
        }
        return i4;
    }

    private boolean k() {
        if (this.f6438f.size() < this.f6437e) {
            return true;
        }
        return false;
    }

    private boolean l() {
        if (this.f6438f.size() == this.f6437e) {
            return true;
        }
        return false;
    }

    private long m() {
        return System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public void n(C2408A a5, C0938m mVar) {
        boolean z4;
        g f4 = g.f();
        f4.b("Sending report through Google DataTransport: " + a5.d());
        if (SystemClock.elapsedRealtime() - this.f6436d < AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6440h.b(C0963d.h(a5.b()), new C1296c(this, mVar, z4, a5));
    }

    /* access modifiers changed from: private */
    public static void o(double d5) {
        try {
            Thread.sleep((long) d5);
        } catch (InterruptedException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public C0938m i(C2408A a5, boolean z4) {
        synchronized (this.f6438f) {
            try {
                C0938m mVar = new C0938m();
                if (z4) {
                    this.f6441i.b();
                    if (k()) {
                        g f4 = g.f();
                        f4.b("Enqueueing report: " + a5.d());
                        g f5 = g.f();
                        f5.b("Queue size: " + this.f6438f.size());
                        this.f6439g.execute(new b(a5, mVar));
                        g f6 = g.f();
                        f6.b("Closing task for report: " + a5.d());
                        mVar.e(a5);
                        return mVar;
                    }
                    h();
                    g f7 = g.f();
                    f7.b("Dropping report due to queue being full: " + a5.d());
                    this.f6441i.a();
                    mVar.e(a5);
                    return mVar;
                }
                n(a5, mVar);
                return mVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new C1297d(this, countDownLatch)).start();
        c0.c(countDownLatch, 2, TimeUnit.SECONDS);
    }

    C1298e(double d5, double d6, long j4, i iVar, N n4) {
        this.f6433a = d5;
        this.f6434b = d6;
        this.f6435c = j4;
        this.f6440h = iVar;
        this.f6441i = n4;
        this.f6436d = SystemClock.elapsedRealtime();
        int i4 = (int) d5;
        this.f6437e = i4;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i4);
        this.f6438f = arrayBlockingQueue;
        this.f6439g = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f6442j = 0;
        this.f6443k = 0;
    }
}
