package F3;

import K3.C2493a;
import L3.C2499f;
import N3.C2515f;
import N3.L;
import N3.X;
import N3.Z;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class d implements Closeable, Flushable, AutoCloseable {

    /* renamed from: u  reason: collision with root package name */
    static final Pattern f23282u = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: a  reason: collision with root package name */
    final C2493a f23283a;

    /* renamed from: b  reason: collision with root package name */
    final File f23284b;

    /* renamed from: c  reason: collision with root package name */
    private final File f23285c;

    /* renamed from: d  reason: collision with root package name */
    private final File f23286d;

    /* renamed from: e  reason: collision with root package name */
    private final File f23287e;

    /* renamed from: f  reason: collision with root package name */
    private final int f23288f;

    /* renamed from: g  reason: collision with root package name */
    private long f23289g;

    /* renamed from: h  reason: collision with root package name */
    final int f23290h;

    /* renamed from: i  reason: collision with root package name */
    private long f23291i = 0;

    /* renamed from: j  reason: collision with root package name */
    C2515f f23292j;

    /* renamed from: k  reason: collision with root package name */
    final LinkedHashMap f23293k = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: l  reason: collision with root package name */
    int f23294l;

    /* renamed from: m  reason: collision with root package name */
    boolean f23295m;

    /* renamed from: n  reason: collision with root package name */
    boolean f23296n;

    /* renamed from: o  reason: collision with root package name */
    boolean f23297o;

    /* renamed from: p  reason: collision with root package name */
    boolean f23298p;

    /* renamed from: q  reason: collision with root package name */
    boolean f23299q;

    /* renamed from: r  reason: collision with root package name */
    private long f23300r = 0;

    /* renamed from: s  reason: collision with root package name */
    private final Executor f23301s;

    /* renamed from: t  reason: collision with root package name */
    private final Runnable f23302t = new a();

    class a implements Runnable {
        a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r1 = r6.f23303a;
            r1.f23299q = true;
            r1.f23292j = N3.L.c(N3.L.b());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                F3.d r0 = F3.d.this
                monitor-enter(r0)
                F3.d r1 = F3.d.this     // Catch:{ all -> 0x0011 }
                boolean r2 = r1.f23296n     // Catch:{ all -> 0x0011 }
                r3 = 0
                r4 = 1
                r2 = r2 ^ r4
                boolean r5 = r1.f23297o     // Catch:{ all -> 0x0011 }
                r2 = r2 | r5
                if (r2 == 0) goto L_0x0013
                monitor-exit(r0)     // Catch:{ all -> 0x0011 }
                return
            L_0x0011:
                r1 = move-exception
                goto L_0x003d
            L_0x0013:
                r1.D()     // Catch:{ IOException -> 0x0017 }
                goto L_0x001b
            L_0x0017:
                F3.d r1 = F3.d.this     // Catch:{ all -> 0x0011 }
                r1.f23298p = r4     // Catch:{ all -> 0x0011 }
            L_0x001b:
                F3.d r1 = F3.d.this     // Catch:{ IOException -> 0x002d }
                boolean r1 = r1.p()     // Catch:{ IOException -> 0x002d }
                if (r1 == 0) goto L_0x003b
                F3.d r1 = F3.d.this     // Catch:{ IOException -> 0x002d }
                r1.x()     // Catch:{ IOException -> 0x002d }
                F3.d r1 = F3.d.this     // Catch:{ IOException -> 0x002d }
                r1.f23294l = r3     // Catch:{ IOException -> 0x002d }
                goto L_0x003b
            L_0x002d:
                F3.d r1 = F3.d.this     // Catch:{ all -> 0x0011 }
                r1.f23299q = r4     // Catch:{ all -> 0x0011 }
                N3.X r2 = N3.L.b()     // Catch:{ all -> 0x0011 }
                N3.f r2 = N3.L.c(r2)     // Catch:{ all -> 0x0011 }
                r1.f23292j = r2     // Catch:{ all -> 0x0011 }
            L_0x003b:
                monitor-exit(r0)     // Catch:{ all -> 0x0011 }
                return
            L_0x003d:
                monitor-exit(r0)     // Catch:{ all -> 0x0011 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: F3.d.a.run():void");
        }
    }

    class b extends e {
        b(X x4) {
            super(x4);
        }

        /* access modifiers changed from: protected */
        public void a(IOException iOException) {
            d.this.f23295m = true;
        }
    }

    public final class c {

        /* renamed from: a  reason: collision with root package name */
        final C0280d f23305a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f23306b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f23307c;

        class a extends e {
            a(X x4) {
                super(x4);
            }

            /* access modifiers changed from: protected */
            public void a(IOException iOException) {
                synchronized (d.this) {
                    c.this.c();
                }
            }
        }

        c(C0280d dVar) {
            boolean[] zArr;
            this.f23305a = dVar;
            if (dVar.f23314e) {
                zArr = null;
            } else {
                zArr = new boolean[d.this.f23290h];
            }
            this.f23306b = zArr;
        }

        public void a() {
            synchronized (d.this) {
                try {
                    if (!this.f23307c) {
                        if (this.f23305a.f23315f == this) {
                            d.this.d(this, false);
                        }
                        this.f23307c = true;
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void b() {
            synchronized (d.this) {
                try {
                    if (!this.f23307c) {
                        if (this.f23305a.f23315f == this) {
                            d.this.d(this, true);
                        }
                        this.f23307c = true;
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (this.f23305a.f23315f == this) {
                int i4 = 0;
                while (true) {
                    d dVar = d.this;
                    if (i4 < dVar.f23290h) {
                        try {
                            dVar.f23283a.delete(this.f23305a.f23313d[i4]);
                        } catch (IOException unused) {
                        }
                        i4++;
                    } else {
                        this.f23305a.f23315f = null;
                        return;
                    }
                }
            }
        }

        public X d(int i4) {
            synchronized (d.this) {
                try {
                    if (!this.f23307c) {
                        C0280d dVar = this.f23305a;
                        if (dVar.f23315f != this) {
                            X b5 = L.b();
                            return b5;
                        }
                        if (!dVar.f23314e) {
                            this.f23306b[i4] = true;
                        }
                        a aVar = new a(d.this.f23283a.sink(dVar.f23313d[i4]));
                        return aVar;
                    }
                    throw new IllegalStateException();
                } catch (FileNotFoundException unused) {
                    return L.b();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: F3.d$d  reason: collision with other inner class name */
    private final class C0280d {

        /* renamed from: a  reason: collision with root package name */
        final String f23310a;

        /* renamed from: b  reason: collision with root package name */
        final long[] f23311b;

        /* renamed from: c  reason: collision with root package name */
        final File[] f23312c;

        /* renamed from: d  reason: collision with root package name */
        final File[] f23313d;

        /* renamed from: e  reason: collision with root package name */
        boolean f23314e;

        /* renamed from: f  reason: collision with root package name */
        c f23315f;

        /* renamed from: g  reason: collision with root package name */
        long f23316g;

        C0280d(String str) {
            this.f23310a = str;
            int i4 = d.this.f23290h;
            this.f23311b = new long[i4];
            this.f23312c = new File[i4];
            this.f23313d = new File[i4];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i5 = 0; i5 < d.this.f23290h; i5++) {
                sb.append(i5);
                this.f23312c[i5] = new File(d.this.f23284b, sb.toString());
                sb.append(".tmp");
                this.f23313d[i5] = new File(d.this.f23284b, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException a(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        public void b(String[] strArr) {
            if (strArr.length == d.this.f23290h) {
                int i4 = 0;
                while (i4 < strArr.length) {
                    try {
                        this.f23311b[i4] = Long.parseLong(strArr[i4]);
                        i4++;
                    } catch (NumberFormatException unused) {
                        throw a(strArr);
                    }
                }
                return;
            }
            throw a(strArr);
        }

        /* access modifiers changed from: package-private */
        public e c() {
            Z z4;
            if (Thread.holdsLock(d.this)) {
                Z[] zArr = new Z[d.this.f23290h];
                long[] jArr = (long[]) this.f23311b.clone();
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    try {
                        d dVar = d.this;
                        if (i5 >= dVar.f23290h) {
                            return new e(this.f23310a, this.f23316g, zArr, jArr);
                        }
                        zArr[i5] = dVar.f23283a.source(this.f23312c[i5]);
                        i5++;
                    } catch (FileNotFoundException unused) {
                        while (true) {
                            d dVar2 = d.this;
                            if (i4 >= dVar2.f23290h || (z4 = zArr[i4]) == null) {
                                try {
                                    dVar2.A(this);
                                    return null;
                                } catch (IOException unused2) {
                                    return null;
                                }
                            } else {
                                E3.c.d(z4);
                                i4++;
                            }
                        }
                    }
                }
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(C2515f fVar) {
            for (long writeDecimalLong : this.f23311b) {
                fVar.writeByte(32).writeDecimalLong(writeDecimalLong);
            }
        }
    }

    public final class e implements Closeable, AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        private final String f23318a;

        /* renamed from: b  reason: collision with root package name */
        private final long f23319b;

        /* renamed from: c  reason: collision with root package name */
        private final Z[] f23320c;

        /* renamed from: d  reason: collision with root package name */
        private final long[] f23321d;

        e(String str, long j4, Z[] zArr, long[] jArr) {
            this.f23318a = str;
            this.f23319b = j4;
            this.f23320c = zArr;
            this.f23321d = jArr;
        }

        public c a() {
            return d.this.l(this.f23318a, this.f23319b);
        }

        public void close() {
            for (Z d5 : this.f23320c) {
                E3.c.d(d5);
            }
        }

        public Z d(int i4) {
            return this.f23320c[i4];
        }
    }

    d(C2493a aVar, File file, int i4, int i5, long j4, Executor executor) {
        this.f23283a = aVar;
        this.f23284b = file;
        this.f23288f = i4;
        this.f23285c = new File(file, "journal");
        this.f23286d = new File(file, "journal.tmp");
        this.f23287e = new File(file, "journal.bkp");
        this.f23290h = i5;
        this.f23289g = j4;
        this.f23301s = executor;
    }

    private void E(String str) {
        if (!f23282u.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    private synchronized void a() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static d g(C2493a aVar, File file, int i4, int i5, long j4) {
        if (j4 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i5 > 0) {
            return new d(aVar, file, i4, i5, j4, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), E3.c.B("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private C2515f r() {
        return L.c(new b(this.f23283a.appendingSink(this.f23285c)));
    }

    private void u() {
        this.f23283a.delete(this.f23286d);
        Iterator it = this.f23293k.values().iterator();
        while (it.hasNext()) {
            C0280d dVar = (C0280d) it.next();
            int i4 = 0;
            if (dVar.f23315f == null) {
                while (i4 < this.f23290h) {
                    this.f23291i += dVar.f23311b[i4];
                    i4++;
                }
            } else {
                dVar.f23315f = null;
                while (i4 < this.f23290h) {
                    this.f23283a.delete(dVar.f23312c[i4]);
                    this.f23283a.delete(dVar.f23313d[i4]);
                    i4++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|18|(1:20)(1:21)|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r9.f23294l = r0 - r9.f23293k.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        if (r1.exhausted() == false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        x();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        r9.f23292j = r();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x007c=Splitter:B:24:0x007c, B:17:0x005f=Splitter:B:17:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void v() {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            K3.a r1 = r9.f23283a
            java.io.File r2 = r9.f23285c
            N3.Z r1 = r1.source(r2)
            N3.g r1 = N3.L.d(r1)
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r3 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r4 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r5 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r6 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x007c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x007c
            int r7 = r9.f23288f     // Catch:{ all -> 0x005d }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x005d }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x007c
            int r4 = r9.f23290h     // Catch:{ all -> 0x005d }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x005d }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x007c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x007c
            r0 = 0
        L_0x0053:
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ EOFException -> 0x005f }
            r9.w(r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0053
        L_0x005d:
            r0 = move-exception
            goto L_0x00aa
        L_0x005f:
            java.util.LinkedHashMap r2 = r9.f23293k     // Catch:{ all -> 0x005d }
            int r2 = r2.size()     // Catch:{ all -> 0x005d }
            int r0 = r0 - r2
            r9.f23294l = r0     // Catch:{ all -> 0x005d }
            boolean r0 = r1.exhausted()     // Catch:{ all -> 0x005d }
            if (r0 != 0) goto L_0x0072
            r9.x()     // Catch:{ all -> 0x005d }
            goto L_0x0078
        L_0x0072:
            N3.f r0 = r9.r()     // Catch:{ all -> 0x005d }
            r9.f23292j = r0     // Catch:{ all -> 0x005d }
        L_0x0078:
            E3.c.d(r1)
            return
        L_0x007c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x005d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r7.<init>()     // Catch:{ all -> 0x005d }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x005d }
            r7.append(r2)     // Catch:{ all -> 0x005d }
            r7.append(r0)     // Catch:{ all -> 0x005d }
            r7.append(r3)     // Catch:{ all -> 0x005d }
            r7.append(r0)     // Catch:{ all -> 0x005d }
            r7.append(r5)     // Catch:{ all -> 0x005d }
            r7.append(r0)     // Catch:{ all -> 0x005d }
            r7.append(r6)     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x005d }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x005d }
            r4.<init>(r0)     // Catch:{ all -> 0x005d }
            throw r4     // Catch:{ all -> 0x005d }
        L_0x00aa:
            E3.c.d(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: F3.d.v():void");
    }

    private void w(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i4 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i4);
            if (indexOf2 == -1) {
                str2 = str.substring(i4);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f23293k.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i4, indexOf2);
            }
            C0280d dVar = (C0280d) this.f23293k.get(str2);
            if (dVar == null) {
                dVar = new C0280d(str2);
                this.f23293k.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f23314e = true;
                dVar.f23315f = null;
                dVar.b(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f23315f = new c(dVar);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean A(C0280d dVar) {
        c cVar = dVar.f23315f;
        if (cVar != null) {
            cVar.c();
        }
        for (int i4 = 0; i4 < this.f23290h; i4++) {
            this.f23283a.delete(dVar.f23312c[i4]);
            long j4 = this.f23291i;
            long[] jArr = dVar.f23311b;
            this.f23291i = j4 - jArr[i4];
            jArr[i4] = 0;
        }
        this.f23294l++;
        this.f23292j.writeUtf8("REMOVE").writeByte(32).writeUtf8(dVar.f23310a).writeByte(10);
        this.f23293k.remove(dVar.f23310a);
        if (p()) {
            this.f23301s.execute(this.f23302t);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void D() {
        while (this.f23291i > this.f23289g) {
            A((C0280d) this.f23293k.values().iterator().next());
        }
        this.f23298p = false;
    }

    public synchronized void close() {
        try {
            if (this.f23296n) {
                if (!this.f23297o) {
                    for (C0280d dVar : (C0280d[]) this.f23293k.values().toArray(new C0280d[this.f23293k.size()])) {
                        c cVar = dVar.f23315f;
                        if (cVar != null) {
                            cVar.a();
                        }
                    }
                    D();
                    this.f23292j.close();
                    this.f23292j = null;
                    this.f23297o = true;
                    return;
                }
            }
            this.f23297o = true;
        } finally {
            while (true) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d(F3.d.c r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            F3.d$d r0 = r10.f23305a     // Catch:{ all -> 0x002a }
            F3.d$c r1 = r0.f23315f     // Catch:{ all -> 0x002a }
            if (r1 != r10) goto L_0x00f8
            r1 = 0
            if (r11 == 0) goto L_0x004a
            boolean r2 = r0.f23314e     // Catch:{ all -> 0x002a }
            if (r2 != 0) goto L_0x004a
            r2 = 0
        L_0x000f:
            int r3 = r9.f23290h     // Catch:{ all -> 0x002a }
            if (r2 >= r3) goto L_0x004a
            boolean[] r3 = r10.f23306b     // Catch:{ all -> 0x002a }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x002a }
            if (r3 == 0) goto L_0x0030
            K3.a r3 = r9.f23283a     // Catch:{ all -> 0x002a }
            java.io.File[] r4 = r0.f23313d     // Catch:{ all -> 0x002a }
            r4 = r4[r2]     // Catch:{ all -> 0x002a }
            boolean r3 = r3.exists(r4)     // Catch:{ all -> 0x002a }
            if (r3 != 0) goto L_0x002d
            r10.a()     // Catch:{ all -> 0x002a }
            monitor-exit(r9)
            return
        L_0x002a:
            r10 = move-exception
            goto L_0x00fe
        L_0x002d:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x0030:
            r10.a()     // Catch:{ all -> 0x002a }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
            r11.<init>()     // Catch:{ all -> 0x002a }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x002a }
            r11.append(r2)     // Catch:{ all -> 0x002a }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x002a }
            r10.<init>(r11)     // Catch:{ all -> 0x002a }
            throw r10     // Catch:{ all -> 0x002a }
        L_0x004a:
            int r10 = r9.f23290h     // Catch:{ all -> 0x002a }
            if (r1 >= r10) goto L_0x0082
            java.io.File[] r10 = r0.f23313d     // Catch:{ all -> 0x002a }
            r10 = r10[r1]     // Catch:{ all -> 0x002a }
            if (r11 == 0) goto L_0x007a
            K3.a r2 = r9.f23283a     // Catch:{ all -> 0x002a }
            boolean r2 = r2.exists(r10)     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x007f
            java.io.File[] r2 = r0.f23312c     // Catch:{ all -> 0x002a }
            r2 = r2[r1]     // Catch:{ all -> 0x002a }
            K3.a r3 = r9.f23283a     // Catch:{ all -> 0x002a }
            r3.rename(r10, r2)     // Catch:{ all -> 0x002a }
            long[] r10 = r0.f23311b     // Catch:{ all -> 0x002a }
            r3 = r10[r1]     // Catch:{ all -> 0x002a }
            K3.a r10 = r9.f23283a     // Catch:{ all -> 0x002a }
            long r5 = r10.size(r2)     // Catch:{ all -> 0x002a }
            long[] r10 = r0.f23311b     // Catch:{ all -> 0x002a }
            r10[r1] = r5     // Catch:{ all -> 0x002a }
            long r7 = r9.f23291i     // Catch:{ all -> 0x002a }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f23291i = r7     // Catch:{ all -> 0x002a }
            goto L_0x007f
        L_0x007a:
            K3.a r2 = r9.f23283a     // Catch:{ all -> 0x002a }
            r2.delete(r10)     // Catch:{ all -> 0x002a }
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x004a
        L_0x0082:
            int r10 = r9.f23294l     // Catch:{ all -> 0x002a }
            r1 = 1
            int r10 = r10 + r1
            r9.f23294l = r10     // Catch:{ all -> 0x002a }
            r10 = 0
            r0.f23315f = r10     // Catch:{ all -> 0x002a }
            boolean r10 = r0.f23314e     // Catch:{ all -> 0x002a }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00be
            r0.f23314e = r1     // Catch:{ all -> 0x002a }
            N3.f r10 = r9.f23292j     // Catch:{ all -> 0x002a }
            java.lang.String r1 = "CLEAN"
            N3.f r10 = r10.writeUtf8(r1)     // Catch:{ all -> 0x002a }
            r10.writeByte(r3)     // Catch:{ all -> 0x002a }
            N3.f r10 = r9.f23292j     // Catch:{ all -> 0x002a }
            java.lang.String r1 = r0.f23310a     // Catch:{ all -> 0x002a }
            r10.writeUtf8(r1)     // Catch:{ all -> 0x002a }
            N3.f r10 = r9.f23292j     // Catch:{ all -> 0x002a }
            r0.d(r10)     // Catch:{ all -> 0x002a }
            N3.f r10 = r9.f23292j     // Catch:{ all -> 0x002a }
            r10.writeByte(r2)     // Catch:{ all -> 0x002a }
            if (r11 == 0) goto L_0x00dc
            long r10 = r9.f23300r     // Catch:{ all -> 0x002a }
            r1 = 1
            long r1 = r1 + r10
            r9.f23300r = r1     // Catch:{ all -> 0x002a }
            r0.f23316g = r10     // Catch:{ all -> 0x002a }
            goto L_0x00dc
        L_0x00be:
            java.util.LinkedHashMap r10 = r9.f23293k     // Catch:{ all -> 0x002a }
            java.lang.String r11 = r0.f23310a     // Catch:{ all -> 0x002a }
            r10.remove(r11)     // Catch:{ all -> 0x002a }
            N3.f r10 = r9.f23292j     // Catch:{ all -> 0x002a }
            java.lang.String r11 = "REMOVE"
            N3.f r10 = r10.writeUtf8(r11)     // Catch:{ all -> 0x002a }
            r10.writeByte(r3)     // Catch:{ all -> 0x002a }
            N3.f r10 = r9.f23292j     // Catch:{ all -> 0x002a }
            java.lang.String r11 = r0.f23310a     // Catch:{ all -> 0x002a }
            r10.writeUtf8(r11)     // Catch:{ all -> 0x002a }
            N3.f r10 = r9.f23292j     // Catch:{ all -> 0x002a }
            r10.writeByte(r2)     // Catch:{ all -> 0x002a }
        L_0x00dc:
            N3.f r10 = r9.f23292j     // Catch:{ all -> 0x002a }
            r10.flush()     // Catch:{ all -> 0x002a }
            long r10 = r9.f23291i     // Catch:{ all -> 0x002a }
            long r0 = r9.f23289g     // Catch:{ all -> 0x002a }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ef
            boolean r10 = r9.p()     // Catch:{ all -> 0x002a }
            if (r10 == 0) goto L_0x00f6
        L_0x00ef:
            java.util.concurrent.Executor r10 = r9.f23301s     // Catch:{ all -> 0x002a }
            java.lang.Runnable r11 = r9.f23302t     // Catch:{ all -> 0x002a }
            r10.execute(r11)     // Catch:{ all -> 0x002a }
        L_0x00f6:
            monitor-exit(r9)
            return
        L_0x00f8:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002a }
            r10.<init>()     // Catch:{ all -> 0x002a }
            throw r10     // Catch:{ all -> 0x002a }
        L_0x00fe:
            monitor-exit(r9)     // Catch:{ all -> 0x002a }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: F3.d.d(F3.d$c, boolean):void");
    }

    public synchronized void flush() {
        if (this.f23296n) {
            a();
            D();
            this.f23292j.flush();
        }
    }

    public void i() {
        close();
        this.f23283a.deleteContents(this.f23284b);
    }

    public synchronized boolean isClosed() {
        return this.f23297o;
    }

    public c k(String str) {
        return l(str, -1);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized F3.d.c l(java.lang.String r6, long r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.o()     // Catch:{ all -> 0x0022 }
            r5.a()     // Catch:{ all -> 0x0022 }
            r5.E(r6)     // Catch:{ all -> 0x0022 }
            java.util.LinkedHashMap r0 = r5.f23293k     // Catch:{ all -> 0x0022 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0022 }
            F3.d$d r0 = (F3.d.C0280d) r0     // Catch:{ all -> 0x0022 }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0026
            if (r0 == 0) goto L_0x0024
            long r1 = r0.f23316g     // Catch:{ all -> 0x0022 }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0026
            goto L_0x0024
        L_0x0022:
            r6 = move-exception
            goto L_0x0077
        L_0x0024:
            monitor-exit(r5)
            return r3
        L_0x0026:
            if (r0 == 0) goto L_0x002e
            F3.d$c r7 = r0.f23315f     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x002e
            monitor-exit(r5)
            return r3
        L_0x002e:
            boolean r7 = r5.f23298p     // Catch:{ all -> 0x0022 }
            if (r7 != 0) goto L_0x006e
            boolean r7 = r5.f23299q     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x0037
            goto L_0x006e
        L_0x0037:
            N3.f r7 = r5.f23292j     // Catch:{ all -> 0x0022 }
            java.lang.String r8 = "DIRTY"
            N3.f r7 = r7.writeUtf8(r8)     // Catch:{ all -> 0x0022 }
            r8 = 32
            N3.f r7 = r7.writeByte(r8)     // Catch:{ all -> 0x0022 }
            N3.f r7 = r7.writeUtf8(r6)     // Catch:{ all -> 0x0022 }
            r8 = 10
            r7.writeByte(r8)     // Catch:{ all -> 0x0022 }
            N3.f r7 = r5.f23292j     // Catch:{ all -> 0x0022 }
            r7.flush()     // Catch:{ all -> 0x0022 }
            boolean r7 = r5.f23295m     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x0059
            monitor-exit(r5)
            return r3
        L_0x0059:
            if (r0 != 0) goto L_0x0065
            F3.d$d r0 = new F3.d$d     // Catch:{ all -> 0x0022 }
            r0.<init>(r6)     // Catch:{ all -> 0x0022 }
            java.util.LinkedHashMap r7 = r5.f23293k     // Catch:{ all -> 0x0022 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0022 }
        L_0x0065:
            F3.d$c r6 = new F3.d$c     // Catch:{ all -> 0x0022 }
            r6.<init>(r0)     // Catch:{ all -> 0x0022 }
            r0.f23315f = r6     // Catch:{ all -> 0x0022 }
            monitor-exit(r5)
            return r6
        L_0x006e:
            java.util.concurrent.Executor r6 = r5.f23301s     // Catch:{ all -> 0x0022 }
            java.lang.Runnable r7 = r5.f23302t     // Catch:{ all -> 0x0022 }
            r6.execute(r7)     // Catch:{ all -> 0x0022 }
            monitor-exit(r5)
            return r3
        L_0x0077:
            monitor-exit(r5)     // Catch:{ all -> 0x0022 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: F3.d.l(java.lang.String, long):F3.d$c");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized F3.d.e n(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.o()     // Catch:{ all -> 0x004d }
            r3.a()     // Catch:{ all -> 0x004d }
            r3.E(r4)     // Catch:{ all -> 0x004d }
            java.util.LinkedHashMap r0 = r3.f23293k     // Catch:{ all -> 0x004d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x004d }
            F3.d$d r0 = (F3.d.C0280d) r0     // Catch:{ all -> 0x004d }
            r1 = 0
            if (r0 == 0) goto L_0x0051
            boolean r2 = r0.f23314e     // Catch:{ all -> 0x004d }
            if (r2 != 0) goto L_0x001a
            goto L_0x0051
        L_0x001a:
            F3.d$e r0 = r0.c()     // Catch:{ all -> 0x004d }
            if (r0 != 0) goto L_0x0022
            monitor-exit(r3)
            return r1
        L_0x0022:
            int r1 = r3.f23294l     // Catch:{ all -> 0x004d }
            int r1 = r1 + 1
            r3.f23294l = r1     // Catch:{ all -> 0x004d }
            N3.f r1 = r3.f23292j     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "READ"
            N3.f r1 = r1.writeUtf8(r2)     // Catch:{ all -> 0x004d }
            r2 = 32
            N3.f r1 = r1.writeByte(r2)     // Catch:{ all -> 0x004d }
            N3.f r4 = r1.writeUtf8(r4)     // Catch:{ all -> 0x004d }
            r1 = 10
            r4.writeByte(r1)     // Catch:{ all -> 0x004d }
            boolean r4 = r3.p()     // Catch:{ all -> 0x004d }
            if (r4 == 0) goto L_0x004f
            java.util.concurrent.Executor r4 = r3.f23301s     // Catch:{ all -> 0x004d }
            java.lang.Runnable r1 = r3.f23302t     // Catch:{ all -> 0x004d }
            r4.execute(r1)     // Catch:{ all -> 0x004d }
            goto L_0x004f
        L_0x004d:
            r4 = move-exception
            goto L_0x0053
        L_0x004f:
            monitor-exit(r3)
            return r0
        L_0x0051:
            monitor-exit(r3)
            return r1
        L_0x0053:
            monitor-exit(r3)     // Catch:{ all -> 0x004d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: F3.d.n(java.lang.String):F3.d$e");
    }

    public synchronized void o() {
        try {
            if (!this.f23296n) {
                if (this.f23283a.exists(this.f23287e)) {
                    if (this.f23283a.exists(this.f23285c)) {
                        this.f23283a.delete(this.f23287e);
                    } else {
                        this.f23283a.rename(this.f23287e, this.f23285c);
                    }
                }
                if (this.f23283a.exists(this.f23285c)) {
                    v();
                    u();
                    this.f23296n = true;
                    return;
                }
                x();
                this.f23296n = true;
            }
        } catch (IOException e5) {
            C2499f i4 = C2499f.i();
            i4.p(5, "DiskLruCache " + this.f23284b + " is corrupt: " + e5.getMessage() + ", removing", e5);
            i();
            this.f23297o = false;
        } catch (Throwable th) {
            this.f23297o = false;
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        int i4 = this.f23294l;
        if (i4 < 2000 || i4 < this.f23293k.size()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0071, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00be, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void x() {
        /*
            r6 = this;
            monitor-enter(r6)
            N3.f r0 = r6.f23292j     // Catch:{ all -> 0x0009 }
            if (r0 == 0) goto L_0x000c
            r0.close()     // Catch:{ all -> 0x0009 }
            goto L_0x000c
        L_0x0009:
            r0 = move-exception
            goto L_0x00bf
        L_0x000c:
            K3.a r0 = r6.f23283a     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.f23286d     // Catch:{ all -> 0x0009 }
            N3.X r0 = r0.sink(r1)     // Catch:{ all -> 0x0009 }
            N3.f r0 = N3.L.c(r0)     // Catch:{ all -> 0x0009 }
            java.lang.String r1 = "libcore.io.DiskLruCache"
            N3.f r1 = r0.writeUtf8(r1)     // Catch:{ all -> 0x0071 }
            r2 = 10
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = "1"
            N3.f r1 = r0.writeUtf8(r1)     // Catch:{ all -> 0x0071 }
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            int r1 = r6.f23288f     // Catch:{ all -> 0x0071 }
            long r3 = (long) r1     // Catch:{ all -> 0x0071 }
            N3.f r1 = r0.writeDecimalLong(r3)     // Catch:{ all -> 0x0071 }
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            int r1 = r6.f23290h     // Catch:{ all -> 0x0071 }
            long r3 = (long) r1     // Catch:{ all -> 0x0071 }
            N3.f r1 = r0.writeDecimalLong(r3)     // Catch:{ all -> 0x0071 }
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            r0.writeByte(r2)     // Catch:{ all -> 0x0071 }
            java.util.LinkedHashMap r1 = r6.f23293k     // Catch:{ all -> 0x0071 }
            java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x0071 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0071 }
        L_0x004d:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0071 }
            if (r3 == 0) goto L_0x0088
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0071 }
            F3.d$d r3 = (F3.d.C0280d) r3     // Catch:{ all -> 0x0071 }
            F3.d$c r4 = r3.f23315f     // Catch:{ all -> 0x0071 }
            r5 = 32
            if (r4 == 0) goto L_0x0073
            java.lang.String r4 = "DIRTY"
            N3.f r4 = r0.writeUtf8(r4)     // Catch:{ all -> 0x0071 }
            r4.writeByte(r5)     // Catch:{ all -> 0x0071 }
            java.lang.String r3 = r3.f23310a     // Catch:{ all -> 0x0071 }
            r0.writeUtf8(r3)     // Catch:{ all -> 0x0071 }
            r0.writeByte(r2)     // Catch:{ all -> 0x0071 }
            goto L_0x004d
        L_0x0071:
            r1 = move-exception
            goto L_0x00bb
        L_0x0073:
            java.lang.String r4 = "CLEAN"
            N3.f r4 = r0.writeUtf8(r4)     // Catch:{ all -> 0x0071 }
            r4.writeByte(r5)     // Catch:{ all -> 0x0071 }
            java.lang.String r4 = r3.f23310a     // Catch:{ all -> 0x0071 }
            r0.writeUtf8(r4)     // Catch:{ all -> 0x0071 }
            r3.d(r0)     // Catch:{ all -> 0x0071 }
            r0.writeByte(r2)     // Catch:{ all -> 0x0071 }
            goto L_0x004d
        L_0x0088:
            r0.close()     // Catch:{ all -> 0x0009 }
            K3.a r0 = r6.f23283a     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.f23285c     // Catch:{ all -> 0x0009 }
            boolean r0 = r0.exists(r1)     // Catch:{ all -> 0x0009 }
            if (r0 == 0) goto L_0x009e
            K3.a r0 = r6.f23283a     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.f23285c     // Catch:{ all -> 0x0009 }
            java.io.File r2 = r6.f23287e     // Catch:{ all -> 0x0009 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x0009 }
        L_0x009e:
            K3.a r0 = r6.f23283a     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.f23286d     // Catch:{ all -> 0x0009 }
            java.io.File r2 = r6.f23285c     // Catch:{ all -> 0x0009 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x0009 }
            K3.a r0 = r6.f23283a     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.f23287e     // Catch:{ all -> 0x0009 }
            r0.delete(r1)     // Catch:{ all -> 0x0009 }
            N3.f r0 = r6.r()     // Catch:{ all -> 0x0009 }
            r6.f23292j = r0     // Catch:{ all -> 0x0009 }
            r0 = 0
            r6.f23295m = r0     // Catch:{ all -> 0x0009 }
            r6.f23299q = r0     // Catch:{ all -> 0x0009 }
            monitor-exit(r6)
            return
        L_0x00bb:
            r0.close()     // Catch:{ all -> 0x0009 }
            throw r1     // Catch:{ all -> 0x0009 }
        L_0x00bf:
            monitor-exit(r6)     // Catch:{ all -> 0x0009 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: F3.d.x():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean z(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.o()     // Catch:{ all -> 0x0028 }
            r6.a()     // Catch:{ all -> 0x0028 }
            r6.E(r7)     // Catch:{ all -> 0x0028 }
            java.util.LinkedHashMap r0 = r6.f23293k     // Catch:{ all -> 0x0028 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0028 }
            F3.d$d r7 = (F3.d.C0280d) r7     // Catch:{ all -> 0x0028 }
            r0 = 0
            if (r7 != 0) goto L_0x0017
            monitor-exit(r6)
            return r0
        L_0x0017:
            boolean r7 = r6.A(r7)     // Catch:{ all -> 0x0028 }
            if (r7 == 0) goto L_0x002a
            long r1 = r6.f23291i     // Catch:{ all -> 0x0028 }
            long r3 = r6.f23289g     // Catch:{ all -> 0x0028 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x002a
            r6.f23298p = r0     // Catch:{ all -> 0x0028 }
            goto L_0x002a
        L_0x0028:
            r7 = move-exception
            goto L_0x002c
        L_0x002a:
            monitor-exit(r6)
            return r7
        L_0x002c:
            monitor-exit(r6)     // Catch:{ all -> 0x0028 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: F3.d.z(java.lang.String):boolean");
    }
}
