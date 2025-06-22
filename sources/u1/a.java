package U1;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private i f8395a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c f8396b;

    /* renamed from: c  reason: collision with root package name */
    private Thread f8397c;

    /* renamed from: U1.a$a  reason: collision with other inner class name */
    private final class C0115a implements Runnable {
        public C0115a() {
        }

        public void run() {
            if (a.this.d("FileReceived")) {
                a.this.c().v();
            }
        }
    }

    private final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final File f8399a;

        public b(File file) {
            this.f8399a = file;
        }

        public void run() {
            try {
                if (this.f8399a != null) {
                    a.this.c().t(this.f8399a);
                    byte[] bArr = new byte[8192];
                    FileInputStream fileInputStream = new FileInputStream(this.f8399a);
                    Socket g4 = a.this.f8396b.g();
                    m.b(g4);
                    OutputStream outputStream = g4.getOutputStream();
                    int available = fileInputStream.available();
                    long j4 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 8192);
                        if (read > 0) {
                            outputStream.write(bArr, 0, read);
                            i4 += read;
                            if (available > 0) {
                                int i6 = (int) ((((double) i4) * 100.0d) / ((double) available));
                                if (i6 <= i5 + 5) {
                                    if (System.currentTimeMillis() > ((long) 1000) + j4 && i6 > i5) {
                                    }
                                }
                                j4 = System.currentTimeMillis();
                                a.this.c().o(i6);
                                i5 = i6;
                            }
                        } else {
                            a.this.c().o(100);
                            fileInputStream.close();
                            outputStream.flush();
                            a.this.c().l();
                            return;
                        }
                    }
                }
            } catch (Exception e5) {
                if (e5.getMessage() != null) {
                    i c5 = a.this.c();
                    String message = e5.getMessage();
                    m.b(message);
                    c5.x(message);
                    return;
                }
                a.this.c().x("Exception");
            }
        }
    }

    public final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f8401a;

        public c(boolean z4) {
            this.f8401a = z4;
        }

        public void run() {
            String str;
            if (this.f8401a) {
                str = "OK";
            } else {
                str = "KO";
            }
            if (!a.this.d(str)) {
                return;
            }
            if (this.f8401a) {
                a.this.f8396b.i().n();
            } else {
                a.this.f8396b.i().l();
            }
        }
    }

    private final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f8403a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f8404b;

        public d(a aVar, String str) {
            m.e(str, "serviceName");
            this.f8404b = aVar;
            this.f8403a = str;
        }

        public void run() {
            if (this.f8404b.d("resolveService:" + this.f8403a)) {
                this.f8404b.f8396b.i().l();
            }
        }
    }

    private final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final T1.e f8405a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f8406b;

        public e(a aVar, T1.e eVar) {
            m.e(eVar, "ftiToSend");
            this.f8406b = aVar;
            this.f8405a = eVar;
        }

        public void run() {
            if (this.f8406b.d(this.f8405a.i())) {
                this.f8406b.c().w(this.f8405a);
            }
        }
    }

    public a(i iVar, c cVar) {
        m.e(iVar, "nsdListener");
        m.e(cVar, "nsdConnectionManager");
        this.f8395a = iVar;
        this.f8396b = cVar;
    }

    /* access modifiers changed from: private */
    public final boolean d(String str) {
        try {
            if (this.f8396b.f() == null) {
                this.f8395a.p("Socket is closed");
                return false;
            }
            Socket f4 = this.f8396b.f();
            m.b(f4);
            if (f4.isClosed()) {
                this.f8395a.p("Socket is closed");
                return false;
            }
            Socket f5 = this.f8396b.f();
            m.b(f5);
            DataOutputStream dataOutputStream = new DataOutputStream(f5.getOutputStream());
            dataOutputStream.writeUTF(str);
            dataOutputStream.flush();
            return true;
        } catch (UnknownHostException e5) {
            e5.printStackTrace();
            this.f8395a.p("Unknown Host");
            return false;
        } catch (IOException e6) {
            e6.printStackTrace();
            this.f8395a.p("I/O Exception");
            return false;
        } catch (Exception e7) {
            e7.printStackTrace();
            this.f8395a.p("Error3");
            return false;
        }
    }

    public final i c() {
        return this.f8395a;
    }

    public final void e() {
        new Thread(new C0115a()).start();
    }

    public final void f(File file) {
        m.e(file, "file");
        Thread thread = new Thread(new b(file));
        this.f8397c = thread;
        m.b(thread);
        thread.start();
    }

    public final void g(boolean z4) {
        new Thread(new c(z4)).start();
    }

    public final void h(String str) {
        m.e(str, "serviceName");
        new Thread(new d(this, str)).start();
    }

    public final void i(T1.e eVar) {
        m.e(eVar, "ftiToSend");
        new Thread(new e(this, eVar)).start();
    }
}
