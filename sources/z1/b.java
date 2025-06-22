package Z1;

import X1.a;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.List;

public class b {

    /* renamed from: A  reason: collision with root package name */
    public static d f8853A = d.NORMAL;

    /* renamed from: w  reason: collision with root package name */
    private static b f8854w;

    /* renamed from: x  reason: collision with root package name */
    private static b f8855x;

    /* renamed from: y  reason: collision with root package name */
    private static b f8856y;

    /* renamed from: z  reason: collision with root package name */
    private static String[] f8857z = {null, null};

    /* renamed from: a  reason: collision with root package name */
    private int f8858a = 25000;

    /* renamed from: b  reason: collision with root package name */
    private e f8859b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public d f8860c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f8861d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Process f8862e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final BufferedReader f8863f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final BufferedReader f8864g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final OutputStreamWriter f8865h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final List f8866i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f8867j;

    /* renamed from: k  reason: collision with root package name */
    private Boolean f8868k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f8869l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f8870m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f8871n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f8872o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f8873p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public int f8874q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public int f8875r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f8876s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f8877t;

    /* renamed from: u  reason: collision with root package name */
    private Runnable f8878u;

    /* renamed from: v  reason: collision with root package name */
    private Runnable f8879v;

    class a implements Runnable {
        a() {
        }

        public void run() {
            while (true) {
                try {
                    synchronized (b.this.f8866i) {
                        while (!b.this.f8867j && b.this.f8874q >= b.this.f8866i.size()) {
                            b bVar = b.this;
                            bVar.f8869l = false;
                            bVar.f8866i.wait();
                        }
                    }
                    if (b.this.f8874q >= b.this.f8872o) {
                        while (b.this.f8873p != b.this.f8874q) {
                            X1.a.c("Waiting for read and write to catch up before cleanup.");
                        }
                        b.this.x();
                    }
                    if (b.this.f8874q < b.this.f8866i.size()) {
                        b bVar2 = b.this;
                        bVar2.f8869l = true;
                        a aVar = (a) bVar2.f8866i.get(b.this.f8874q);
                        aVar.l();
                        X1.a.c("Executing: " + aVar.g() + " with context: " + b.this.f8860c);
                        b.this.f8865h.write(aVar.g());
                        b.this.f8865h.flush();
                        b.this.f8865h.write("\necho F*D^W@#FGF " + b.this.f8875r + " $?\n");
                        b.this.f8865h.flush();
                        b.m(b.this);
                        b.v(b.this);
                    } else if (b.this.f8867j) {
                        b bVar3 = b.this;
                        bVar3.f8869l = false;
                        bVar3.f8865h.write("\nexit 0\n");
                        b.this.f8865h.flush();
                        X1.a.c("Closing shell");
                        int unused = b.this.f8874q = 0;
                        b bVar4 = b.this;
                        bVar4.C(bVar4.f8865h);
                        return;
                    }
                } catch (IOException e5) {
                    e = e5;
                } catch (InterruptedException e6) {
                    e = e6;
                } catch (Throwable th) {
                    while (true) {
                    }
                    throw th;
                }
            }
            try {
                X1.a.d(e.getMessage(), a.b.ERROR, e);
                int unused2 = b.this.f8874q = 0;
                b bVar5 = b.this;
                bVar5.C(bVar5.f8865h);
            } catch (Throwable th2) {
                int unused3 = b.this.f8874q = 0;
                b bVar6 = b.this;
                bVar6.C(bVar6.f8865h);
                throw th2;
            }
        }
    }

    /* renamed from: Z1.b$b  reason: collision with other inner class name */
    class C0130b extends Thread {
        C0130b() {
        }

        public void run() {
            synchronized (b.this.f8866i) {
                b.this.f8866i.notifyAll();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            Z1.b.f(r9.f8882a).waitFor();
            Z1.b.f(r9.f8882a).destroy();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
            if (Z1.b.o(r9.f8882a) < Z1.b.a(r9.f8882a).size()) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0082, code lost:
            if (r1 == null) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
            r1 = (Z1.a) Z1.b.a(r9.f8882a).get(Z1.b.o(r9.f8882a));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x009a, code lost:
            if (r1.f8837c < r1.f8838d) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
            r1.n("All output not processed!");
            r1.n("Did you forget the super.commandOutput call or are you waiting on the command object?");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a7, code lost:
            r1.n("Unexpected Termination.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ac, code lost:
            Z1.b.q(r9.f8882a);
            r1 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b3, code lost:
            Z1.b.p(r9.f8882a, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0148, code lost:
            r9.f8882a.K(r1);
            r4 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0152, code lost:
            if (r1.f8837c <= r1.f8838d) goto L_0x018c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0154, code lost:
            if (r4 != 0) goto L_0x0178;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0156, code lost:
            r4 = r4 + 1;
            X1.a.c("Waiting for output to be processed. " + r1.f8838d + " Of " + r1.f8837c);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            wait(com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x017e, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0183, code lost:
            r5 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            X1.a.c(r5.getMessage());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0070 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0140 */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0148 A[EDGE_INSN: B:85:0x0148->B:58:0x0148 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x0002 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r9 = this;
                r0 = 0
            L_0x0001:
                r1 = r0
            L_0x0002:
                r2 = 1
                r3 = 0
                Z1.b r4 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                boolean r4 = r4.f8867j     // Catch:{ IOException -> 0x002e }
                if (r4 == 0) goto L_0x0031
                Z1.b r4 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                java.io.BufferedReader r4 = r4.f8863f     // Catch:{ IOException -> 0x002e }
                boolean r4 = r4.ready()     // Catch:{ IOException -> 0x002e }
                if (r4 != 0) goto L_0x0031
                Z1.b r4 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                int r4 = r4.f8873p     // Catch:{ IOException -> 0x002e }
                Z1.b r5 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                java.util.List r5 = r5.f8866i     // Catch:{ IOException -> 0x002e }
                int r5 = r5.size()     // Catch:{ IOException -> 0x002e }
                if (r4 >= r5) goto L_0x005e
                goto L_0x0031
            L_0x002b:
                r0 = move-exception
                goto L_0x01af
            L_0x002e:
                r0 = move-exception
                goto L_0x01a3
            L_0x0031:
                Z1.b r4 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                r4.f8870m = r3     // Catch:{ IOException -> 0x002e }
                java.io.BufferedReader r4 = r4.f8863f     // Catch:{ IOException -> 0x002e }
                java.lang.String r4 = r4.readLine()     // Catch:{ IOException -> 0x002e }
                Z1.b r5 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                r5.f8870m = r2     // Catch:{ IOException -> 0x002e }
                if (r4 != 0) goto L_0x0044
                goto L_0x005e
            L_0x0044:
                if (r1 != 0) goto L_0x00f2
                int r5 = r5.f8873p     // Catch:{ IOException -> 0x002e }
                Z1.b r6 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                java.util.List r6 = r6.f8866i     // Catch:{ IOException -> 0x002e }
                int r6 = r6.size()     // Catch:{ IOException -> 0x002e }
                if (r5 < r6) goto L_0x00e0
                Z1.b r4 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                boolean r4 = r4.f8867j     // Catch:{ IOException -> 0x002e }
                if (r4 == 0) goto L_0x0002
            L_0x005e:
                Z1.b r4 = Z1.b.this     // Catch:{ Exception -> 0x0070 }
                java.lang.Process r4 = r4.f8862e     // Catch:{ Exception -> 0x0070 }
                r4.waitFor()     // Catch:{ Exception -> 0x0070 }
                Z1.b r4 = Z1.b.this     // Catch:{ Exception -> 0x0070 }
                java.lang.Process r4 = r4.f8862e     // Catch:{ Exception -> 0x0070 }
                r4.destroy()     // Catch:{ Exception -> 0x0070 }
            L_0x0070:
                Z1.b r4 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                int r4 = r4.f8873p     // Catch:{ IOException -> 0x002e }
                Z1.b r5 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                java.util.List r5 = r5.f8866i     // Catch:{ IOException -> 0x002e }
                int r5 = r5.size()     // Catch:{ IOException -> 0x002e }
                if (r4 >= r5) goto L_0x00b3
                if (r1 != 0) goto L_0x0096
                Z1.b r1 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                java.util.List r1 = r1.f8866i     // Catch:{ IOException -> 0x002e }
                Z1.b r4 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                int r4 = r4.f8873p     // Catch:{ IOException -> 0x002e }
                java.lang.Object r1 = r1.get(r4)     // Catch:{ IOException -> 0x002e }
                Z1.a r1 = (Z1.a) r1     // Catch:{ IOException -> 0x002e }
            L_0x0096:
                int r4 = r1.f8837c     // Catch:{ IOException -> 0x002e }
                int r5 = r1.f8838d     // Catch:{ IOException -> 0x002e }
                if (r4 >= r5) goto L_0x00a7
                java.lang.String r4 = "All output not processed!"
                r1.n(r4)     // Catch:{ IOException -> 0x002e }
                java.lang.String r4 = "Did you forget the super.commandOutput call or are you waiting on the command object?"
                r1.n(r4)     // Catch:{ IOException -> 0x002e }
                goto L_0x00ac
            L_0x00a7:
                java.lang.String r4 = "Unexpected Termination."
                r1.n(r4)     // Catch:{ IOException -> 0x002e }
            L_0x00ac:
                Z1.b r1 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                Z1.b.q(r1)     // Catch:{ IOException -> 0x002e }
                r1 = r0
                goto L_0x0070
            L_0x00b3:
                Z1.b r0 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                int unused = r0.f8873p = r3     // Catch:{ IOException -> 0x002e }
            L_0x00b8:
                Z1.b r0 = Z1.b.this
                java.io.OutputStreamWriter r1 = r0.f8865h
                r0.C(r1)
                Z1.b r0 = Z1.b.this
                java.io.BufferedReader r1 = r0.f8864g
                r0.B(r1)
                Z1.b r0 = Z1.b.this
                java.io.BufferedReader r1 = r0.f8863f
                r0.B(r1)
                java.lang.String r0 = "Shell destroyed"
                X1.a.c(r0)
                Z1.b r0 = Z1.b.this
                r0.f8871n = r2
                r0.f8870m = r3
                goto L_0x01ae
            L_0x00e0:
                Z1.b r1 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                java.util.List r1 = r1.f8866i     // Catch:{ IOException -> 0x002e }
                Z1.b r5 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                int r5 = r5.f8873p     // Catch:{ IOException -> 0x002e }
                java.lang.Object r1 = r1.get(r5)     // Catch:{ IOException -> 0x002e }
                Z1.a r1 = (Z1.a) r1     // Catch:{ IOException -> 0x002e }
            L_0x00f2:
                java.lang.String r5 = "F*D^W@#FGF"
                int r5 = r4.indexOf(r5)     // Catch:{ IOException -> 0x002e }
                r6 = -1
                if (r5 != r6) goto L_0x0101
                int r7 = r1.f8848n     // Catch:{ IOException -> 0x002e }
                r1.j(r7, r4)     // Catch:{ IOException -> 0x002e }
                goto L_0x0120
            L_0x0101:
                if (r5 <= 0) goto L_0x0120
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x002e }
                r7.<init>()     // Catch:{ IOException -> 0x002e }
                java.lang.String r8 = "Found token, line: "
                r7.append(r8)     // Catch:{ IOException -> 0x002e }
                r7.append(r4)     // Catch:{ IOException -> 0x002e }
                java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x002e }
                X1.a.c(r7)     // Catch:{ IOException -> 0x002e }
                int r7 = r1.f8848n     // Catch:{ IOException -> 0x002e }
                java.lang.String r8 = r4.substring(r3, r5)     // Catch:{ IOException -> 0x002e }
                r1.j(r7, r8)     // Catch:{ IOException -> 0x002e }
            L_0x0120:
                if (r5 < 0) goto L_0x0002
                java.lang.String r4 = r4.substring(r5)     // Catch:{ IOException -> 0x002e }
                java.lang.String r5 = " "
                java.lang.String[] r4 = r4.split(r5)     // Catch:{ IOException -> 0x002e }
                int r5 = r4.length     // Catch:{ IOException -> 0x002e }
                r7 = 2
                if (r5 < r7) goto L_0x0002
                r5 = r4[r2]     // Catch:{ IOException -> 0x002e }
                if (r5 == 0) goto L_0x0002
                int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x0139 }
                goto L_0x013a
            L_0x0139:
                r5 = 0
            L_0x013a:
                r4 = r4[r7]     // Catch:{ NumberFormatException -> 0x0140 }
                int r6 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x0140 }
            L_0x0140:
                Z1.b r4 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                int r4 = r4.f8876s     // Catch:{ IOException -> 0x002e }
                if (r5 != r4) goto L_0x0002
                Z1.b r4 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                r4.K(r1)     // Catch:{ IOException -> 0x002e }
                r4 = 0
            L_0x014e:
                int r5 = r1.f8837c     // Catch:{ IOException -> 0x002e }
                int r7 = r1.f8838d     // Catch:{ IOException -> 0x002e }
                if (r5 <= r7) goto L_0x018c
                if (r4 != 0) goto L_0x0178
                int r4 = r4 + 1
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x002e }
                r5.<init>()     // Catch:{ IOException -> 0x002e }
                java.lang.String r7 = "Waiting for output to be processed. "
                r5.append(r7)     // Catch:{ IOException -> 0x002e }
                int r7 = r1.f8838d     // Catch:{ IOException -> 0x002e }
                r5.append(r7)     // Catch:{ IOException -> 0x002e }
                java.lang.String r7 = " Of "
                r5.append(r7)     // Catch:{ IOException -> 0x002e }
                int r7 = r1.f8837c     // Catch:{ IOException -> 0x002e }
                r5.append(r7)     // Catch:{ IOException -> 0x002e }
                java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x002e }
                X1.a.c(r5)     // Catch:{ IOException -> 0x002e }
            L_0x0178:
                monitor-enter(r9)     // Catch:{ Exception -> 0x0183 }
                r7 = 2000(0x7d0, double:9.88E-321)
                r9.wait(r7)     // Catch:{ all -> 0x0180 }
                monitor-exit(r9)     // Catch:{ all -> 0x0180 }
                goto L_0x014e
            L_0x0180:
                r5 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0180 }
                throw r5     // Catch:{ Exception -> 0x0183 }
            L_0x0183:
                r5 = move-exception
                java.lang.String r5 = r5.getMessage()     // Catch:{ IOException -> 0x002e }
                X1.a.c(r5)     // Catch:{ IOException -> 0x002e }
                goto L_0x014e
            L_0x018c:
                java.lang.String r4 = "Read all output"
                X1.a.c(r4)     // Catch:{ IOException -> 0x002e }
                r1.k(r6)     // Catch:{ IOException -> 0x002e }
                r1.b()     // Catch:{ IOException -> 0x002e }
                Z1.b r1 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                Z1.b.q(r1)     // Catch:{ IOException -> 0x002e }
                Z1.b r1 = Z1.b.this     // Catch:{ IOException -> 0x002e }
                Z1.b.e(r1)     // Catch:{ IOException -> 0x002e }
                goto L_0x0001
            L_0x01a3:
                java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x002b }
                X1.a$b r4 = X1.a.b.ERROR     // Catch:{ all -> 0x002b }
                X1.a.d(r1, r4, r0)     // Catch:{ all -> 0x002b }
                goto L_0x00b8
            L_0x01ae:
                return
            L_0x01af:
                Z1.b r1 = Z1.b.this
                java.io.OutputStreamWriter r4 = r1.f8865h
                r1.C(r4)
                Z1.b r1 = Z1.b.this
                java.io.BufferedReader r4 = r1.f8864g
                r1.B(r4)
                Z1.b r1 = Z1.b.this
                java.io.BufferedReader r4 = r1.f8863f
                r1.B(r4)
                java.lang.String r1 = "Shell destroyed"
                X1.a.c(r1)
                Z1.b r1 = Z1.b.this
                r1.f8871n = r2
                r1.f8870m = r3
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: Z1.b.c.run():void");
        }
    }

    public enum d {
        NORMAL("normal"),
        SHELL("u:r:shell:s0"),
        SYSTEM_SERVER("u:r:system_server:s0"),
        SYSTEM_APP("u:r:system_app:s0"),
        PLATFORM_APP("u:r:platform_app:s0"),
        UNTRUSTED_APP("u:r:untrusted_app:s0"),
        RECOVERY("u:r:recovery:s0");
        

        /* renamed from: a  reason: collision with root package name */
        private String f8891a;

        private d(String str) {
            this.f8891a = str;
        }

        public String b() {
            return this.f8891a;
        }
    }

    public enum e {
        NORMAL,
        ROOT,
        CUSTOM
    }

    protected static class f extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public int f8896a;

        /* renamed from: b  reason: collision with root package name */
        public b f8897b;

        /* synthetic */ f(b bVar, a aVar) {
            this(bVar);
        }

        private void a() {
            Field field;
            try {
                Class<?> cls = this.f8897b.f8862e.getClass();
                try {
                    field = cls.getDeclaredField("pid");
                } catch (NoSuchFieldException unused) {
                    field = cls.getDeclaredField("id");
                }
                field.setAccessible(true);
                int intValue = ((Integer) field.get(this.f8897b.f8862e)).intValue();
                OutputStreamWriter t4 = this.f8897b.f8865h;
                t4.write("(echo -17 > /proc/" + intValue + "/oom_adj) &> /dev/null\n");
                this.f8897b.f8865h.write("(echo -17 > /proc/$$/oom_adj) &> /dev/null\n");
                this.f8897b.f8865h.flush();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        public void run() {
            try {
                this.f8897b.f8865h.write("echo Started\n");
                this.f8897b.f8865h.flush();
                while (true) {
                    String readLine = this.f8897b.f8863f.readLine();
                    if (readLine == null) {
                        throw new EOFException();
                    } else if (!"".equals(readLine)) {
                        if ("Started".equals(readLine)) {
                            this.f8896a = 1;
                            a();
                            return;
                        }
                        String unused = this.f8897b.f8861d = "unknown error occurred.";
                    }
                }
            } catch (IOException e5) {
                this.f8896a = -42;
                if (e5.getMessage() != null) {
                    String unused2 = this.f8897b.f8861d = e5.getMessage();
                } else {
                    String unused3 = this.f8897b.f8861d = "RootAccess denied?.";
                }
            }
        }

        private f(b bVar) {
            this.f8896a = -911;
            this.f8897b = bVar;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:25|26|27|28|29) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:30|31|32|33|34) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x019a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x01b6 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x01b6=Splitter:B:32:0x01b6, B:27:0x019a=Splitter:B:27:0x019a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private b(java.lang.String r6, Z1.b.e r7, Z1.b.d r8, int r9) {
        /*
            r5 = this;
            r5.<init>()
            r0 = 25000(0x61a8, float:3.5032E-41)
            r5.f8858a = r0
            r0 = 0
            r5.f8859b = r0
            Z1.b$d r1 = Z1.b.d.NORMAL
            r5.f8860c = r1
            java.lang.String r2 = ""
            r5.f8861d = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r5.f8866i = r2
            r2 = 0
            r5.f8867j = r2
            r5.f8868k = r0
            r5.f8869l = r2
            r5.f8870m = r2
            r5.f8871n = r2
            r3 = 5000(0x1388, float:7.006E-42)
            r5.f8872o = r3
            r5.f8873p = r2
            r5.f8874q = r2
            r5.f8875r = r2
            r5.f8876s = r2
            r5.f8877t = r2
            Z1.b$a r3 = new Z1.b$a
            r3.<init>()
            r5.f8878u = r3
            Z1.b$c r3 = new Z1.b$c
            r3.<init>()
            r5.f8879v = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Starting shell: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            X1.a.c(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Context: "
            r3.append(r4)
            java.lang.String r4 = r8.b()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            X1.a.c(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Timeout: "
            r3.append(r4)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            X1.a.c(r3)
            r5.f8859b = r7
            if (r9 <= 0) goto L_0x0085
            goto L_0x0087
        L_0x0085:
            int r9 = r5.f8858a
        L_0x0087:
            r5.f8858a = r9
            r5.f8860c = r8
            if (r8 != r1) goto L_0x0099
            java.lang.Runtime r7 = java.lang.Runtime.getRuntime()
            java.lang.Process r6 = r7.exec(r6)
            r5.f8862e = r6
            goto L_0x012a
        L_0x0099:
            java.lang.String r7 = r5.H(r2)
            r8 = 1
            java.lang.String r8 = r5.H(r8)
            boolean r9 = r5.I()
            if (r9 == 0) goto L_0x00db
            if (r7 == 0) goto L_0x00db
            if (r8 == 0) goto L_0x00db
            java.lang.String r9 = "SUPERSU"
            boolean r9 = r7.endsWith(r9)
            if (r9 == 0) goto L_0x00db
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            int r9 = r9.intValue()
            r1 = 190(0xbe, float:2.66E-43)
            if (r9 < r1) goto L_0x00db
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r6 = " --context "
            r7.append(r6)
            Z1.b$d r6 = r5.f8860c
            java.lang.String r6 = r6.b()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            goto L_0x0120
        L_0x00db:
            java.lang.String r9 = "Su binary --context switch not supported!"
            X1.a.c(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "Su binary display version: "
            r9.append(r1)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            X1.a.c(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "Su binary internal version: "
            r7.append(r9)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            X1.a.c(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "SELinuxEnforcing: "
            r7.append(r8)
            boolean r8 = r5.I()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            X1.a.c(r7)
        L_0x0120:
            java.lang.Runtime r7 = java.lang.Runtime.getRuntime()
            java.lang.Process r6 = r7.exec(r6)
            r5.f8862e = r6
        L_0x012a:
            java.io.BufferedReader r6 = new java.io.BufferedReader
            java.io.InputStreamReader r7 = new java.io.InputStreamReader
            java.lang.Process r8 = r5.f8862e
            java.io.InputStream r8 = r8.getInputStream()
            java.lang.String r9 = "UTF-8"
            r7.<init>(r8, r9)
            r6.<init>(r7)
            r5.f8863f = r6
            java.io.BufferedReader r6 = new java.io.BufferedReader
            java.io.InputStreamReader r7 = new java.io.InputStreamReader
            java.lang.Process r8 = r5.f8862e
            java.io.InputStream r8 = r8.getErrorStream()
            r7.<init>(r8, r9)
            r6.<init>(r7)
            r5.f8864g = r6
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter
            java.lang.Process r7 = r5.f8862e
            java.io.OutputStream r7 = r7.getOutputStream()
            r6.<init>(r7, r9)
            r5.f8865h = r6
            Z1.b$f r6 = new Z1.b$f
            r6.<init>(r5, r0)
            r6.start()
            int r7 = r5.f8858a     // Catch:{ InterruptedException -> 0x01cd }
            long r7 = (long) r7     // Catch:{ InterruptedException -> 0x01cd }
            r6.join(r7)     // Catch:{ InterruptedException -> 0x01cd }
            int r7 = r6.f8896a     // Catch:{ InterruptedException -> 0x01cd }
            r8 = -911(0xfffffffffffffc71, float:NaN)
            if (r7 == r8) goto L_0x01b1
            r8 = -42
            if (r7 == r8) goto L_0x0195
            java.lang.Thread r7 = new java.lang.Thread     // Catch:{ InterruptedException -> 0x01cd }
            java.lang.Runnable r8 = r5.f8878u     // Catch:{ InterruptedException -> 0x01cd }
            java.lang.String r9 = "Shell Input"
            r7.<init>(r8, r9)     // Catch:{ InterruptedException -> 0x01cd }
            r8 = 5
            r7.setPriority(r8)     // Catch:{ InterruptedException -> 0x01cd }
            r7.start()     // Catch:{ InterruptedException -> 0x01cd }
            java.lang.Thread r7 = new java.lang.Thread     // Catch:{ InterruptedException -> 0x01cd }
            java.lang.Runnable r9 = r5.f8879v     // Catch:{ InterruptedException -> 0x01cd }
            java.lang.String r0 = "Shell Output"
            r7.<init>(r9, r0)     // Catch:{ InterruptedException -> 0x01cd }
            r7.setPriority(r8)     // Catch:{ InterruptedException -> 0x01cd }
            r7.start()     // Catch:{ InterruptedException -> 0x01cd }
            return
        L_0x0195:
            java.lang.Process r7 = r5.f8862e     // Catch:{ Exception -> 0x019a }
            r7.destroy()     // Catch:{ Exception -> 0x019a }
        L_0x019a:
            java.io.BufferedReader r7 = r5.f8863f     // Catch:{ InterruptedException -> 0x01cd }
            r5.B(r7)     // Catch:{ InterruptedException -> 0x01cd }
            java.io.BufferedReader r7 = r5.f8864g     // Catch:{ InterruptedException -> 0x01cd }
            r5.B(r7)     // Catch:{ InterruptedException -> 0x01cd }
            java.io.OutputStreamWriter r7 = r5.f8865h     // Catch:{ InterruptedException -> 0x01cd }
            r5.C(r7)     // Catch:{ InterruptedException -> 0x01cd }
            Y1.a r7 = new Y1.a     // Catch:{ InterruptedException -> 0x01cd }
            java.lang.String r8 = "Root Access Denied"
            r7.<init>(r8)     // Catch:{ InterruptedException -> 0x01cd }
            throw r7     // Catch:{ InterruptedException -> 0x01cd }
        L_0x01b1:
            java.lang.Process r7 = r5.f8862e     // Catch:{ Exception -> 0x01b6 }
            r7.destroy()     // Catch:{ Exception -> 0x01b6 }
        L_0x01b6:
            java.io.BufferedReader r7 = r5.f8863f     // Catch:{ InterruptedException -> 0x01cd }
            r5.B(r7)     // Catch:{ InterruptedException -> 0x01cd }
            java.io.BufferedReader r7 = r5.f8864g     // Catch:{ InterruptedException -> 0x01cd }
            r5.B(r7)     // Catch:{ InterruptedException -> 0x01cd }
            java.io.OutputStreamWriter r7 = r5.f8865h     // Catch:{ InterruptedException -> 0x01cd }
            r5.C(r7)     // Catch:{ InterruptedException -> 0x01cd }
            java.util.concurrent.TimeoutException r7 = new java.util.concurrent.TimeoutException     // Catch:{ InterruptedException -> 0x01cd }
            java.lang.String r8 = r5.f8861d     // Catch:{ InterruptedException -> 0x01cd }
            r7.<init>(r8)     // Catch:{ InterruptedException -> 0x01cd }
            throw r7     // Catch:{ InterruptedException -> 0x01cd }
        L_0x01cd:
            r6.interrupt()
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            r6.interrupt()
            java.util.concurrent.TimeoutException r6 = new java.util.concurrent.TimeoutException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: Z1.b.<init>(java.lang.String, Z1.b$e, Z1.b$d, int):void");
    }

    public static void A() {
        X1.a.c("Request to close custom shell!");
        b bVar = f8856y;
        if (bVar != null) {
            bVar.y();
        }
    }

    /* access modifiers changed from: private */
    public void B(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void C(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void D() {
        X1.a.c("Request to close root shell!");
        b bVar = f8854w;
        if (bVar != null) {
            bVar.y();
        }
    }

    public static void E() {
        X1.a.c("Request to close normal shell!");
        b bVar = f8855x;
        if (bVar != null) {
            bVar.y();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:20|21|(1:23)|24|25|26|27|(2:(2:29|(2:31|(1:60)(2:61|58))(3:33|34|(1:59)(2:62|58)))(0)|38)|36|38|39) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0041 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0044 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004d A[Catch:{ IOException -> 0x0019, InterruptedException -> 0x0017, all -> 0x0014 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.String H(boolean r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            r1 = r9 ^ 1
            java.lang.String[] r2 = f8857z     // Catch:{ all -> 0x0014 }
            r2 = r2[r1]     // Catch:{ all -> 0x0014 }
            if (r2 != 0) goto L_0x0079
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0019, InterruptedException -> 0x0017 }
            if (r9 == 0) goto L_0x001b
            java.lang.String r4 = "su -V"
            goto L_0x001d
        L_0x0014:
            r9 = move-exception
            goto L_0x007f
        L_0x0017:
            r9 = move-exception
            goto L_0x006f
        L_0x0019:
            r9 = move-exception
            goto L_0x0074
        L_0x001b:
            java.lang.String r4 = "su -v"
        L_0x001d:
            java.lang.Process r3 = r3.exec(r4, r2)     // Catch:{ IOException -> 0x0019, InterruptedException -> 0x0017 }
            r3.waitFor()     // Catch:{ IOException -> 0x0019, InterruptedException -> 0x0017 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0014 }
            r4.<init>()     // Catch:{ all -> 0x0014 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x0014 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ all -> 0x0014 }
            java.io.InputStream r7 = r3.getInputStream()     // Catch:{ all -> 0x0014 }
            r6.<init>(r7)     // Catch:{ all -> 0x0014 }
            r5.<init>(r6)     // Catch:{ all -> 0x0014 }
        L_0x0037:
            java.lang.String r6 = r5.readLine()     // Catch:{ IOException -> 0x0041 }
            if (r6 == 0) goto L_0x0041
            r4.add(r6)     // Catch:{ IOException -> 0x0041 }
            goto L_0x0037
        L_0x0041:
            r5.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            r3.destroy()     // Catch:{ all -> 0x0014 }
            int r3 = r4.size()     // Catch:{ all -> 0x0014 }
        L_0x004b:
            if (r0 >= r3) goto L_0x006a
            java.lang.Object r5 = r4.get(r0)     // Catch:{ all -> 0x0014 }
            int r0 = r0 + 1
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0014 }
            if (r9 != 0) goto L_0x0060
            java.lang.String r6 = "."
            boolean r6 = r5.contains(r6)     // Catch:{ all -> 0x0014 }
            if (r6 == 0) goto L_0x004b
            goto L_0x0066
        L_0x0060:
            int r6 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x0068 }
            if (r6 <= 0) goto L_0x004b
        L_0x0066:
            r2 = r5
            goto L_0x006a
        L_0x0068:
            goto L_0x004b
        L_0x006a:
            java.lang.String[] r9 = f8857z     // Catch:{ all -> 0x0014 }
            r9[r1] = r2     // Catch:{ all -> 0x0014 }
            goto L_0x0079
        L_0x006f:
            r9.printStackTrace()     // Catch:{ all -> 0x0014 }
            monitor-exit(r8)
            return r2
        L_0x0074:
            r9.printStackTrace()     // Catch:{ all -> 0x0014 }
            monitor-exit(r8)
            return r2
        L_0x0079:
            java.lang.String[] r9 = f8857z     // Catch:{ all -> 0x0014 }
            r9 = r9[r1]     // Catch:{ all -> 0x0014 }
            monitor-exit(r8)
            return r9
        L_0x007f:
            monitor-exit(r8)     // Catch:{ all -> 0x0014 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: Z1.b.H(boolean):java.lang.String");
    }

    public static b L() {
        return M(0, 3);
    }

    public static b M(int i4, int i5) {
        return N(i4, f8853A, i5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r1 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Z1.b N(int r4, Z1.b.d r5, int r6) {
        /*
            Z1.b r0 = f8854w
            if (r0 != 0) goto L_0x0056
            java.lang.String r0 = "Starting Root Shell!"
            X1.a.c(r0)
            java.lang.String r0 = "su"
            r1 = 0
        L_0x000c:
            Z1.b r2 = f8854w
            if (r2 != 0) goto L_0x00a6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            r2.<init>()     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            java.lang.String r3 = "Trying to open Root Shell, attempt #"
            r2.append(r3)     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            r2.append(r1)     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            X1.a.c(r2)     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            Z1.b r2 = new Z1.b     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            Z1.b$e r3 = Z1.b.e.ROOT     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            r2.<init>(r0, r3, r5, r4)     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            f8854w = r2     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            goto L_0x000c
        L_0x002e:
            r2 = move-exception
            goto L_0x0034
        L_0x0030:
            r2 = move-exception
            goto L_0x0040
        L_0x0032:
            r2 = move-exception
            goto L_0x004b
        L_0x0034:
            int r3 = r1 + 1
            if (r1 >= r6) goto L_0x003a
        L_0x0038:
            r1 = r3
            goto L_0x000c
        L_0x003a:
            java.lang.String r4 = "TimeoutException, could not start shell"
            X1.a.c(r4)
            throw r2
        L_0x0040:
            int r3 = r1 + 1
            if (r1 >= r6) goto L_0x0045
            goto L_0x0038
        L_0x0045:
            java.lang.String r4 = "RootDeniedException, could not start shell"
            X1.a.c(r4)
            throw r2
        L_0x004b:
            int r3 = r1 + 1
            if (r1 >= r6) goto L_0x0050
            goto L_0x0038
        L_0x0050:
            java.lang.String r4 = "IOException, could not start shell"
            X1.a.c(r4)
            throw r2
        L_0x0056:
            Z1.b$d r4 = r0.f8860c
            if (r4 == r5) goto L_0x00a1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            r4.<init>()     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            java.lang.String r0 = "Context is different than open shell, switching context... "
            r4.append(r0)     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            Z1.b r0 = f8854w     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            Z1.b$d r0 = r0.f8860c     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            r4.append(r0)     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            java.lang.String r0 = " VS "
            r4.append(r0)     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            r4.append(r5)     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            X1.a.c(r4)     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            Z1.b r4 = f8854w     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            r4.O(r5)     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            goto L_0x00a6
        L_0x0080:
            r4 = move-exception
            goto L_0x0086
        L_0x0082:
            r4 = move-exception
            goto L_0x008f
        L_0x0084:
            r4 = move-exception
            goto L_0x0098
        L_0x0086:
            if (r6 <= 0) goto L_0x0089
            goto L_0x00a6
        L_0x0089:
            java.lang.String r5 = "TimeoutException, could not switch context!"
            X1.a.c(r5)
            throw r4
        L_0x008f:
            if (r6 <= 0) goto L_0x0092
            goto L_0x00a6
        L_0x0092:
            java.lang.String r5 = "RootDeniedException, could not switch context!"
            X1.a.c(r5)
            throw r4
        L_0x0098:
            if (r6 <= 0) goto L_0x009b
            goto L_0x00a6
        L_0x009b:
            java.lang.String r5 = "IOException, could not switch context!"
            X1.a.c(r5)
            throw r4
        L_0x00a1:
            java.lang.String r4 = "Using Existing Root Shell!"
            X1.a.c(r4)
        L_0x00a6:
            Z1.b r4 = f8854w
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: Z1.b.N(int, Z1.b$d, int):Z1.b");
    }

    static /* synthetic */ int e(b bVar) {
        int i4 = bVar.f8876s;
        bVar.f8876s = i4 + 1;
        return i4;
    }

    static /* synthetic */ int m(b bVar) {
        int i4 = bVar.f8874q;
        bVar.f8874q = i4 + 1;
        return i4;
    }

    static /* synthetic */ int q(b bVar) {
        int i4 = bVar.f8873p;
        bVar.f8873p = i4 + 1;
        return i4;
    }

    static /* synthetic */ int v(b bVar) {
        int i4 = bVar.f8875r;
        bVar.f8875r = i4 + 1;
        return i4;
    }

    /* access modifiers changed from: private */
    public void x() {
        this.f8877t = true;
        int i4 = this.f8872o;
        int abs = Math.abs(i4 - (i4 / 4));
        X1.a.c("Cleaning up: " + abs);
        for (int i5 = 0; i5 < abs; i5++) {
            this.f8866i.remove(0);
        }
        this.f8873p = this.f8866i.size() - 1;
        this.f8874q = this.f8866i.size() - 1;
        this.f8877t = false;
    }

    public static void z() {
        X1.a.c("Request to close all shells!");
        E();
        D();
        A();
    }

    public int F(a aVar) {
        return this.f8866i.indexOf(aVar);
    }

    public String G(a aVar) {
        return "Command is in position " + F(aVar) + " currently executing command at position " + this.f8874q + " and the number of commands is " + this.f8866i.size();
    }

    public synchronized boolean I() {
        FileInputStream fileInputStream;
        boolean z4;
        try {
            if (this.f8868k == null) {
                boolean z5 = null;
                if (new File("/sys/fs/selinux/enforce").exists()) {
                    try {
                        fileInputStream = new FileInputStream("/sys/fs/selinux/enforce");
                        if (fileInputStream.read() == 49) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        z5 = Boolean.valueOf(z4);
                        fileInputStream.close();
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                }
                if (z5 == null) {
                    z5 = true;
                }
                this.f8868k = z5;
            }
        } catch (Throwable th2) {
            while (true) {
                throw th2;
            }
        }
        return this.f8868k.booleanValue();
    }

    /* access modifiers changed from: protected */
    public void J() {
        new C0130b().start();
    }

    public void K(a aVar) {
        while (this.f8864g.ready() && aVar != null) {
            try {
                String readLine = this.f8864g.readLine();
                if (readLine != null) {
                    aVar.j(aVar.f8848n, readLine);
                } else {
                    return;
                }
            } catch (Exception e5) {
                X1.a.d(e5.getMessage(), a.b.ERROR, e5);
                return;
            }
        }
    }

    public b O(d dVar) {
        if (this.f8859b == e.ROOT) {
            try {
                D();
            } catch (Exception unused) {
                X1.a.c("Problem closing shell while trying to switch context...");
            }
            return N(this.f8858a, dVar, 3);
        }
        X1.a.c("Can only switch context on a root shell!");
        return this;
    }

    public a w(a aVar) {
        if (this.f8867j) {
            throw new IllegalStateException("Unable to add commands to a closed shell");
        } else if (!aVar.f8841g) {
            do {
            } while (this.f8877t);
            this.f8866i.add(aVar);
            J();
            return aVar;
        } else {
            throw new IllegalStateException("This command has already been executed. (Don't re-use command instances.)");
        }
    }

    public void y() {
        X1.a.c("Request to close shell!");
        int i4 = 0;
        while (this.f8869l) {
            X1.a.c("Waiting on shell to finish executing before closing...");
            i4++;
            if (i4 > 10000) {
                break;
            }
        }
        synchronized (this.f8866i) {
            this.f8867j = true;
            J();
        }
        X1.a.c("Shell Closed!");
        if (this == f8854w) {
            f8854w = null;
        } else if (this == f8855x) {
            f8855x = null;
        } else if (this == f8856y) {
            f8856y = null;
        }
    }
}
