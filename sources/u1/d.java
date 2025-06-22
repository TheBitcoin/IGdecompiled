package U1;

import T1.e;
import W1.C1610f;
import W1.C1612h;
import android.content.Context;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import kotlin.jvm.internal.m;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8414a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final i f8415b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final c f8416c;

    /* renamed from: d  reason: collision with root package name */
    private int f8417d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ServerSocket f8418e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Thread f8419f;

    /* renamed from: g  reason: collision with root package name */
    private Thread f8420g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public e f8421h;

    private final class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                if (d.this.f8416c.f() == null) {
                    d.this.f8415b.b();
                    return;
                }
                Socket f4 = d.this.f8416c.f();
                m.b(f4);
                if (f4.isClosed()) {
                    d.this.f8415b.b();
                    return;
                }
                while (true) {
                    Socket f5 = d.this.f8416c.f();
                    m.b(f5);
                    String readUTF = new DataInputStream(f5.getInputStream()).readUTF();
                    if (readUTF == null) {
                        d.this.f8415b.b();
                    } else if (m3.m.p(readUTF, "OK", true)) {
                        if (d.this.f8416c.e() != null) {
                            i e5 = d.this.f8415b;
                            e e6 = d.this.f8416c.e();
                            m.b(e6);
                            e5.u(e6);
                        }
                    } else if (m3.m.p(readUTF, "KO", true)) {
                        d.this.f8415b.h();
                    } else if (m3.m.p(readUTF, "FileReceived", true)) {
                        d.this.f8415b.q();
                    } else if (m3.m.y(readUTF, "resolveService:", false, 2, (Object) null)) {
                        String substring = readUTF.substring(15);
                        m.d(substring, "this as java.lang.String).substring(startIndex)");
                        d.this.f8415b.r(substring);
                    } else {
                        d.this.f8421h = new e();
                        e a5 = d.this.f8421h;
                        m.b(a5);
                        a5.c(readUTF);
                        i e7 = d.this.f8415b;
                        e a6 = d.this.f8421h;
                        m.b(a6);
                        e7.j(a6);
                    }
                }
            } catch (EOFException unused) {
                d.this.f8415b.k();
            } catch (IOException unused2) {
                d.this.f8415b.b();
            } catch (Exception unused3) {
                d.this.f8415b.b();
            }
        }
    }

    public final class b implements Runnable {
        public b() {
        }

        public void run() {
            d.this.j();
        }
    }

    public final class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                d.this.f8418e = new ServerSocket(0);
                d dVar = d.this;
                ServerSocket b5 = dVar.f8418e;
                m.b(b5);
                dVar.k(b5.getLocalPort());
                d.this.f8415b.f(d.this.i());
                while (true) {
                    Thread c5 = d.this.f8419f;
                    m.b(c5);
                    if (!c5.isInterrupted()) {
                        ServerSocket b6 = d.this.f8418e;
                        m.b(b6);
                        Socket accept = b6.accept();
                        c d5 = d.this.f8416c;
                        m.d(accept, "socketTmp");
                        d5.m(accept);
                        d.this.f8415b.d(accept.getRemoteSocketAddress().toString());
                    } else {
                        return;
                    }
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public d(Context context, i iVar, c cVar) {
        m.e(context, "context");
        m.e(iVar, "nsdListener");
        m.e(cVar, "nsdConnectionManager");
        this.f8414a = context;
        this.f8415b = iVar;
        this.f8416c = cVar;
        o();
    }

    /* access modifiers changed from: private */
    public final void j() {
        int read;
        try {
            File f4 = new C1612h().f(this.f8414a);
            e eVar = this.f8421h;
            m.b(eVar);
            if (eVar.e() != null) {
                e eVar2 = this.f8421h;
                m.b(eVar2);
                String e5 = eVar2.e();
                m.b(e5);
                File file = new File(f4, e5);
                Socket g4 = this.f8416c.g();
                m.b(g4);
                InputStream inputStream = g4.getInputStream();
                if (inputStream != null) {
                    int i4 = 8192;
                    byte[] bArr = new byte[8192];
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    e eVar3 = this.f8421h;
                    m.b(eVar3);
                    long h4 = eVar3.h();
                    int i5 = 0;
                    long j4 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    while (((long) i6) < h4 && (read = inputStream.read(bArr, i5, i4)) > 0) {
                        fileOutputStream.write(bArr, i5, read);
                        i6 += read;
                        byte[] bArr2 = bArr;
                        int i8 = (int) ((((double) i6) * 100.0d) / ((double) h4));
                        if (i8 <= i7 + 5) {
                            long j5 = j4;
                            if (System.currentTimeMillis() <= j5 + ((long) 1000) || i8 <= i7) {
                                bArr = bArr2;
                                j4 = j5;
                                i4 = 8192;
                                i5 = 0;
                            }
                        }
                        j4 = System.currentTimeMillis();
                        this.f8415b.n(i8);
                        i7 = i8;
                        bArr = bArr2;
                        i4 = 8192;
                        i5 = 0;
                    }
                    this.f8415b.n(100);
                    fileOutputStream.close();
                    String e6 = C1610f.f8672a.e(file.getAbsolutePath());
                    if (e6 != null) {
                        e eVar4 = this.f8421h;
                        m.b(eVar4);
                        if (m3.m.p(e6, eVar4.g(), true)) {
                            i iVar = this.f8415b;
                            e eVar5 = this.f8421h;
                            m.b(eVar5);
                            String e7 = eVar5.e();
                            m.b(e7);
                            iVar.y(e7, "File Transfer is correct!");
                            return;
                        }
                    }
                    this.f8415b.m("ERROR: File hashes do not macth!");
                    return;
                }
                this.f8415b.m("ERROR: cant create output file");
            }
        } catch (Exception e8) {
            if (e8.getMessage() != null) {
                i iVar2 = this.f8415b;
                String message = e8.getMessage();
                m.b(message);
                iVar2.m(message);
                return;
            }
            this.f8415b.m("Exception");
        }
    }

    private final void o() {
        Thread thread = new Thread(new c());
        this.f8419f = thread;
        m.b(thread);
        thread.start();
    }

    public final int i() {
        return this.f8417d;
    }

    public final void k(int i4) {
        this.f8417d = i4;
    }

    public final void l() {
        Thread thread = this.f8420g;
        if (thread != null) {
            m.b(thread);
            if (thread.isAlive()) {
                return;
            }
        }
        Thread thread2 = new Thread(new a());
        this.f8420g = thread2;
        m.b(thread2);
        thread2.start();
    }

    public final void m(e eVar) {
        this.f8416c.l(eVar);
        l();
    }

    public final void n() {
        new Thread(new b()).start();
    }

    public final void p() {
        Thread thread = this.f8419f;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            ServerSocket serverSocket = this.f8418e;
            if (serverSocket != null) {
                serverSocket.close();
            }
            this.f8418e = null;
        } catch (IOException unused) {
        }
    }
}
