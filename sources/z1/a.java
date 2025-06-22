package Z1;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f8835a = false;

    /* renamed from: b  reason: collision with root package name */
    protected Context f8836b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f8837c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f8838d = 0;

    /* renamed from: e  reason: collision with root package name */
    c f8839e = null;

    /* renamed from: f  reason: collision with root package name */
    Handler f8840f = null;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f8841g = false;

    /* renamed from: h  reason: collision with root package name */
    boolean f8842h = false;

    /* renamed from: i  reason: collision with root package name */
    String[] f8843i = new String[0];

    /* renamed from: j  reason: collision with root package name */
    boolean f8844j = false;

    /* renamed from: k  reason: collision with root package name */
    boolean f8845k = false;

    /* renamed from: l  reason: collision with root package name */
    boolean f8846l = true;

    /* renamed from: m  reason: collision with root package name */
    int f8847m = -1;

    /* renamed from: n  reason: collision with root package name */
    int f8848n = 0;

    /* renamed from: o  reason: collision with root package name */
    int f8849o = X1.a.f8810b;

    private class b extends Handler {
        private b() {
        }

        public final void handleMessage(Message message) {
            int i4 = message.getData().getInt("action");
            String string = message.getData().getString(MimeTypes.BASE_TYPE_TEXT);
            if (i4 == 1) {
                a aVar = a.this;
                aVar.c(aVar.f8848n, string);
            } else if (i4 == 2) {
                a aVar2 = a.this;
                aVar2.a(aVar2.f8848n, aVar2.f8847m);
            } else if (i4 == 3) {
                a aVar3 = a.this;
                aVar3.d(aVar3.f8848n, string);
            }
        }
    }

    private class c extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private final a f8851a;

        public c(a aVar) {
            this.f8851a = aVar;
        }

        public void run() {
            a aVar = this.f8851a;
            if (aVar.f8849o > 0) {
                synchronized (aVar) {
                    try {
                        X1.a.c("Command " + this.f8851a.f8848n + " is waiting for: " + this.f8851a.f8849o);
                        a aVar2 = this.f8851a;
                        aVar2.wait((long) aVar2.f8849o);
                    } catch (InterruptedException e5) {
                        X1.a.c("Exception: " + e5);
                    }
                    if (!this.f8851a.i()) {
                        X1.a.c("Timeout Exception has occurred for command: " + this.f8851a.f8848n + ".");
                        a.this.m("Timeout Exception");
                    }
                }
            }
        }
    }

    public a(int i4, boolean z4, String... strArr) {
        this.f8843i = strArr;
        this.f8848n = i4;
        e(z4);
    }

    private void e(boolean z4) {
        this.f8846l = z4;
        if (Looper.myLooper() == null || !z4) {
            X1.a.c("CommandHandler not created");
            return;
        }
        X1.a.c("CommandHandler created");
        this.f8840f = new b();
    }

    /* access modifiers changed from: protected */
    public final void b() {
        if (!this.f8845k) {
            synchronized (this) {
                try {
                    Handler handler = this.f8840f;
                    if (handler == null || !this.f8846l) {
                        a(this.f8848n, this.f8847m);
                    } else {
                        Message obtainMessage = handler.obtainMessage();
                        Bundle bundle = new Bundle();
                        bundle.putInt("action", 2);
                        obtainMessage.setData(bundle);
                        this.f8840f.sendMessage(obtainMessage);
                    }
                    X1.a.c("Command " + this.f8848n + " finished.");
                    f();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void c(int i4, String str) {
        X1.a.e("Command", "ID: " + i4 + ", " + str);
        this.f8838d = this.f8838d + 1;
    }

    /* access modifiers changed from: protected */
    public final void f() {
        this.f8842h = false;
        this.f8844j = true;
        notifyAll();
    }

    public final String g() {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < this.f8843i.length; i4++) {
            if (i4 > 0) {
                sb.append(10);
            }
            sb.append(this.f8843i[i4]);
        }
        return sb.toString();
    }

    public final boolean h() {
        return this.f8842h;
    }

    public final boolean i() {
        return this.f8844j;
    }

    /* access modifiers changed from: protected */
    public final void j(int i4, String str) {
        this.f8837c++;
        Handler handler = this.f8840f;
        if (handler == null || !this.f8846l) {
            c(i4, str);
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putInt("action", 1);
        bundle.putString(MimeTypes.BASE_TYPE_TEXT, str);
        obtainMessage.setData(bundle);
        this.f8840f.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: protected */
    public final void k(int i4) {
        synchronized (this) {
            this.f8847m = i4;
        }
    }

    /* access modifiers changed from: protected */
    public final void l() {
        this.f8841g = true;
        c cVar = new c(this);
        this.f8839e = cVar;
        cVar.setPriority(1);
        this.f8839e.start();
        this.f8842h = true;
    }

    /* access modifiers changed from: protected */
    public final void m(String str) {
        try {
            b.z();
            X1.a.c("Terminating all shells.");
            n(str);
        } catch (IOException unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final void n(String str) {
        synchronized (this) {
            try {
                Handler handler = this.f8840f;
                if (handler == null || !this.f8846l) {
                    d(this.f8848n, str);
                } else {
                    Message obtainMessage = handler.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putInt("action", 3);
                    bundle.putString(MimeTypes.BASE_TYPE_TEXT, str);
                    obtainMessage.setData(bundle);
                    this.f8840f.sendMessage(obtainMessage);
                }
                X1.a.c("Command " + this.f8848n + " did not finish because it was terminated. Termination reason: " + str);
                k(-1);
                this.f8845k = true;
                f();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i4, int i5) {
    }

    public void d(int i4, String str) {
    }
}
