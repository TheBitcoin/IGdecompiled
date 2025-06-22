package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import com.squareup.picasso.C1814a;
import j$.util.DesugarCollections;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class s {

    /* renamed from: o  reason: collision with root package name */
    static final Handler f17301o = new a(Looper.getMainLooper());

    /* renamed from: p  reason: collision with root package name */
    static volatile s f17302p = null;

    /* renamed from: a  reason: collision with root package name */
    private final g f17303a;

    /* renamed from: b  reason: collision with root package name */
    private final c f17304b;

    /* renamed from: c  reason: collision with root package name */
    private final List f17305c;

    /* renamed from: d  reason: collision with root package name */
    final Context f17306d;

    /* renamed from: e  reason: collision with root package name */
    final g f17307e;

    /* renamed from: f  reason: collision with root package name */
    final H1.a f17308f;

    /* renamed from: g  reason: collision with root package name */
    final z f17309g;

    /* renamed from: h  reason: collision with root package name */
    final Map f17310h;

    /* renamed from: i  reason: collision with root package name */
    final Map f17311i;

    /* renamed from: j  reason: collision with root package name */
    final ReferenceQueue f17312j;

    /* renamed from: k  reason: collision with root package name */
    final Bitmap.Config f17313k;

    /* renamed from: l  reason: collision with root package name */
    boolean f17314l;

    /* renamed from: m  reason: collision with root package name */
    volatile boolean f17315m;

    /* renamed from: n  reason: collision with root package name */
    boolean f17316n;

    static class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i4 = message.what;
            if (i4 != 3) {
                int i5 = 0;
                if (i4 == 8) {
                    List list = (List) message.obj;
                    int size = list.size();
                    while (i5 < size) {
                        C1816c cVar = (C1816c) list.get(i5);
                        cVar.f17214b.d(cVar);
                        i5++;
                    }
                } else if (i4 == 13) {
                    List list2 = (List) message.obj;
                    int size2 = list2.size();
                    while (i5 < size2) {
                        C1814a aVar = (C1814a) list2.get(i5);
                        aVar.f17192a.n(aVar);
                        i5++;
                    }
                } else {
                    throw new AssertionError("Unknown handler message received: " + message.what);
                }
            } else {
                C1814a aVar2 = (C1814a) message.obj;
                if (aVar2.g().f17315m) {
                    C.u("Main", "canceled", aVar2.f17193b.d(), "target got garbage collected");
                }
                aVar2.f17192a.a(aVar2.k());
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Context f17317a;

        /* renamed from: b  reason: collision with root package name */
        private H1.c f17318b;

        /* renamed from: c  reason: collision with root package name */
        private ExecutorService f17319c;

        /* renamed from: d  reason: collision with root package name */
        private H1.a f17320d;

        /* renamed from: e  reason: collision with root package name */
        private g f17321e;

        /* renamed from: f  reason: collision with root package name */
        private List f17322f;

        /* renamed from: g  reason: collision with root package name */
        private Bitmap.Config f17323g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f17324h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f17325i;

        public b(Context context) {
            if (context != null) {
                this.f17317a = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public s a() {
            Context context = this.f17317a;
            if (this.f17318b == null) {
                this.f17318b = new r(context);
            }
            if (this.f17320d == null) {
                this.f17320d = new l(context);
            }
            if (this.f17319c == null) {
                this.f17319c = new u();
            }
            if (this.f17321e == null) {
                this.f17321e = g.f17339a;
            }
            z zVar = new z(this.f17320d);
            z zVar2 = zVar;
            return new s(context, new g(context, this.f17319c, s.f17301o, this.f17318b, this.f17320d, zVar), this.f17320d, (d) null, this.f17321e, this.f17322f, zVar2, this.f17323g, this.f17324h, this.f17325i);
        }
    }

    private static class c extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private final ReferenceQueue f17326a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f17327b;

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Exception f17328a;

            a(Exception exc) {
                this.f17328a = exc;
            }

            public void run() {
                throw new RuntimeException(this.f17328a);
            }
        }

        c(ReferenceQueue referenceQueue, Handler handler) {
            this.f17326a = referenceQueue;
            this.f17327b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    C1814a.C0209a aVar = (C1814a.C0209a) this.f17326a.remove(1000);
                    Message obtainMessage = this.f17327b.obtainMessage();
                    if (aVar != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = aVar.f17204a;
                        this.f17327b.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e5) {
                    this.f17327b.post(new a(e5));
                    return;
                }
            }
        }
    }

    public interface d {
    }

    public enum e {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(SupportMenu.CATEGORY_MASK);
        

        /* renamed from: a  reason: collision with root package name */
        final int f17334a;

        private e(int i4) {
            this.f17334a = i4;
        }
    }

    public enum f {
        LOW,
        NORMAL,
        HIGH
    }

    public interface g {

        /* renamed from: a  reason: collision with root package name */
        public static final g f17339a = new a();

        static class a implements g {
            a() {
            }

            public v a(v vVar) {
                return vVar;
            }
        }

        v a(v vVar);
    }

    s(Context context, g gVar, H1.a aVar, d dVar, g gVar2, List list, z zVar, Bitmap.Config config, boolean z4, boolean z5) {
        int i4;
        this.f17306d = context;
        this.f17307e = gVar;
        this.f17308f = aVar;
        this.f17303a = gVar2;
        this.f17313k = config;
        if (list != null) {
            i4 = list.size();
        } else {
            i4 = 0;
        }
        ArrayList arrayList = new ArrayList(i4 + 7);
        arrayList.add(new y(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new d(context));
        arrayList.add(new n(context));
        arrayList.add(new e(context));
        arrayList.add(new C1815b(context));
        arrayList.add(new i(context));
        arrayList.add(new q(gVar.f17246d, zVar));
        this.f17305c = DesugarCollections.unmodifiableList(arrayList);
        this.f17309g = zVar;
        this.f17310h = new WeakHashMap();
        this.f17311i = new WeakHashMap();
        this.f17314l = z4;
        this.f17315m = z5;
        ReferenceQueue referenceQueue = new ReferenceQueue();
        this.f17312j = referenceQueue;
        c cVar = new c(referenceQueue, f17301o);
        this.f17304b = cVar;
        cVar.start();
    }

    private void f(Bitmap bitmap, e eVar, C1814a aVar, Exception exc) {
        if (!aVar.l()) {
            if (!aVar.m()) {
                this.f17310h.remove(aVar.k());
            }
            if (bitmap == null) {
                aVar.c(exc);
                if (this.f17315m) {
                    C.u("Main", "errored", aVar.f17193b.d(), exc.getMessage());
                }
            } else if (eVar != null) {
                aVar.b(bitmap, eVar);
                if (this.f17315m) {
                    String d5 = aVar.f17193b.d();
                    C.u("Main", "completed", d5, "from " + eVar);
                }
            } else {
                throw new AssertionError("LoadedFrom cannot be null.");
            }
        }
    }

    public static s h() {
        if (f17302p == null) {
            synchronized (s.class) {
                try {
                    if (f17302p == null) {
                        Context context = PicassoProvider.f17191a;
                        if (context != null) {
                            f17302p = new b(context).a();
                        } else {
                            throw new IllegalStateException("context == null");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f17302p;
    }

    /* access modifiers changed from: package-private */
    public void a(Object obj) {
        C.c();
        C1814a aVar = (C1814a) this.f17310h.remove(obj);
        if (aVar != null) {
            aVar.a();
            this.f17307e.c(aVar);
        }
        if (obj instanceof ImageView) {
            f fVar = (f) this.f17311i.remove((ImageView) obj);
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public void b(ImageView imageView) {
        if (imageView != null) {
            a(imageView);
            return;
        }
        throw new IllegalArgumentException("view cannot be null.");
    }

    public void c(A a5) {
        if (a5 != null) {
            a(a5);
            return;
        }
        throw new IllegalArgumentException("target cannot be null.");
    }

    /* access modifiers changed from: package-private */
    public void d(C1816c cVar) {
        boolean z4;
        C1814a h4 = cVar.h();
        List i4 = cVar.i();
        if (i4 == null || i4.isEmpty()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (h4 != null || z4) {
            Uri uri = cVar.j().f17353d;
            Exception k4 = cVar.k();
            Bitmap s4 = cVar.s();
            e o4 = cVar.o();
            if (h4 != null) {
                f(s4, o4, h4, k4);
            }
            if (z4) {
                int size = i4.size();
                for (int i5 = 0; i5 < size; i5++) {
                    f(s4, o4, (C1814a) i4.get(i5), k4);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(ImageView imageView, f fVar) {
        if (this.f17311i.containsKey(imageView)) {
            a(imageView);
        }
        this.f17311i.put(imageView, fVar);
    }

    /* access modifiers changed from: package-private */
    public void g(C1814a aVar) {
        Object k4 = aVar.k();
        if (!(k4 == null || this.f17310h.get(k4) == aVar)) {
            a(k4);
            this.f17310h.put(k4, aVar);
        }
        o(aVar);
    }

    /* access modifiers changed from: package-private */
    public List i() {
        return this.f17305c;
    }

    public w j(int i4) {
        if (i4 != 0) {
            return new w(this, (Uri) null, i4);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    public w k(Uri uri) {
        return new w(this, uri, 0);
    }

    public w l(String str) {
        if (str == null) {
            return new w(this, (Uri) null, 0);
        }
        if (str.trim().length() != 0) {
            return k(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    /* access modifiers changed from: package-private */
    public Bitmap m(String str) {
        Bitmap bitmap = this.f17308f.get(str);
        if (bitmap != null) {
            this.f17309g.d();
            return bitmap;
        }
        this.f17309g.e();
        return bitmap;
    }

    /* access modifiers changed from: package-private */
    public void n(C1814a aVar) {
        Bitmap bitmap;
        if (o.a(aVar.f17196e)) {
            bitmap = m(aVar.d());
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            e eVar = e.MEMORY;
            f(bitmap, eVar, aVar, (Exception) null);
            if (this.f17315m) {
                C.u("Main", "completed", aVar.f17193b.d(), "from " + eVar);
                return;
            }
            return;
        }
        g(aVar);
        if (this.f17315m) {
            C.t("Main", "resumed", aVar.f17193b.d());
        }
    }

    /* access modifiers changed from: package-private */
    public void o(C1814a aVar) {
        this.f17307e.h(aVar);
    }

    /* access modifiers changed from: package-private */
    public v p(v vVar) {
        v a5 = this.f17303a.a(vVar);
        if (a5 != null) {
            return a5;
        }
        throw new IllegalStateException("Request transformer " + this.f17303a.getClass().getCanonicalName() + " returned null for " + vVar);
    }
}
