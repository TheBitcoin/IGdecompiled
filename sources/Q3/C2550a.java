package Q3;

import P3.C2546b;
import P3.C2548d;
import S3.C2570c;
import Y3.C2611a;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: Q3.a  reason: case insensitive filesystem */
public class C2550a implements C2554e {
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final String f23864q = C2546b.i(C2550a.class);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Object f23865a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C2557h f23866b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Semaphore f23867c = new Semaphore(0);

    /* renamed from: d  reason: collision with root package name */
    private final C2570c f23868d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final C2560k f23869e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final C2561l f23870f;

    /* renamed from: g  reason: collision with root package name */
    private volatile int f23871g = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public volatile long f23872h = 120000;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public volatile int f23873i = 0;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f23874j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23875k = false;

    /* renamed from: l  reason: collision with root package name */
    private volatile C2553d f23876l = C2553d.ALWAYS;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public volatile boolean f23877m = false;

    /* renamed from: n  reason: collision with root package name */
    private volatile Thread f23878n = null;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public List f23879o = null;

    /* renamed from: p  reason: collision with root package name */
    private final Runnable f23880p = new C0288a();

    /* renamed from: Q3.a$a  reason: collision with other inner class name */
    class C0288a implements Runnable {
        C0288a() {
        }

        public void run() {
            boolean z4;
            C2550a.this.f23873i = 0;
            while (C2550a.this.f23877m) {
                try {
                    long c5 = C2550a.this.f23872h;
                    if (C2550a.this.f23873i > 1) {
                        c5 += Math.min(((long) C2550a.this.f23873i) * C2550a.this.f23872h, C2550a.this.f23872h * 5);
                    }
                    C2550a.this.f23867c.tryAcquire(c5, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e5) {
                    C2611a.b(C2550a.f23864q).d(e5);
                }
                if (C2550a.this.f23866b.e(C2550a.this.q())) {
                    ArrayList arrayList = new ArrayList();
                    C2550a.this.f23866b.b(arrayList);
                    C2611a.b(C2550a.f23864q).a("Drained %s events.", Integer.valueOf(arrayList.size()));
                    Iterator it = C2550a.this.f23869e.c(arrayList).iterator();
                    int i4 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        C2559j jVar = (C2559j) it.next();
                        if (C2550a.this.f23879o != null) {
                            C2611a.b(C2550a.f23864q).a("DryRun, stored HttpRequest, now %d.", Integer.valueOf(C2550a.this.f23879o.size()));
                            z4 = C2550a.this.f23879o.add(jVar);
                        } else {
                            z4 = C2550a.this.f23870f.c(jVar);
                        }
                        if (!z4) {
                            C2611a.b(C2550a.f23864q).a("Failure while trying to send packet", new Object[0]);
                            C2550a aVar = C2550a.this;
                            aVar.f23873i = aVar.f23873i + 1;
                            break;
                        }
                        i4 += jVar.a();
                        C2550a.this.f23873i = 0;
                        if (!C2550a.this.q()) {
                            C2611a.b(C2550a.f23864q).a("Disconnected during dispatch loop", new Object[0]);
                            break;
                        }
                    }
                    C2611a.b(C2550a.f23864q).a("Dispatched %d events.", Integer.valueOf(i4));
                    if (i4 < arrayList.size()) {
                        C2611a.b(C2550a.f23864q).a("Unable to send all events, requeueing %d events", Integer.valueOf(arrayList.size() - i4));
                        C2550a.this.f23866b.d(arrayList.subList(i4, arrayList.size()));
                        C2550a.this.f23866b.e(C2550a.this.q());
                    }
                }
                synchronized (C2550a.this.f23865a) {
                    try {
                        if (!C2550a.this.f23874j && !C2550a.this.f23866b.c()) {
                            if (C2550a.this.f23872h < 0) {
                            }
                        }
                        C2550a.this.f23877m = false;
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* renamed from: Q3.a$b */
    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23882a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                Q3.d[] r0 = Q3.C2553d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23882a = r0
                Q3.d r1 = Q3.C2553d.EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23882a     // Catch:{ NoSuchFieldError -> 0x001d }
                Q3.d r1 = Q3.C2553d.ALWAYS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23882a     // Catch:{ NoSuchFieldError -> 0x0028 }
                Q3.d r1 = Q3.C2553d.WIFI_ONLY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: Q3.C2550a.b.<clinit>():void");
        }
    }

    public C2550a(C2557h hVar, C2570c cVar, C2560k kVar, C2561l lVar) {
        this.f23868d = cVar;
        this.f23866b = hVar;
        this.f23869e = kVar;
        this.f23870f = lVar;
        lVar.b(this.f23875k);
        lVar.a((long) this.f23871g);
    }

    /* access modifiers changed from: private */
    public boolean q() {
        if (!this.f23868d.b()) {
            return false;
        }
        int i4 = b.f23882a[this.f23876l.ordinal()];
        if (i4 == 2) {
            return true;
        }
        if (i4 == 3 && this.f23868d.a() == C2570c.a.WIFI) {
            return true;
        }
        return false;
    }

    private boolean r() {
        synchronized (this.f23865a) {
            try {
                if (this.f23877m) {
                    return false;
                }
                this.f23877m = true;
                Thread thread = new Thread(this.f23880p);
                thread.setPriority(1);
                thread.setName("Matomo-default-dispatcher");
                this.f23878n = thread;
                thread.start();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(C2553d dVar) {
        this.f23876l = dVar;
    }

    public void b(C2548d dVar) {
        this.f23866b.a(new C2556g(dVar.e()));
        if (this.f23872h != -1) {
            r();
        }
    }
}
