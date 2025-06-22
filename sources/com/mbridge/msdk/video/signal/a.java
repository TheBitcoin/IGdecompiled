package com.mbridge.msdk.video.signal;

import android.app.Activity;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.videocommon.d.c;
import q1.C2205a;
import q1.C2206b;
import r1.C2216b;

public interface a extends e {

    /* renamed from: com.mbridge.msdk.video.signal.a$a  reason: collision with other inner class name */
    public interface C0206a extends NativeListener.NativeTrackingListener {
        void a();

        void a(int i4, String str);

        void a(boolean z4);

        void b();
    }

    int a();

    void a(int i4);

    void a(int i4, String str);

    void a(Activity activity);

    void a(C0206a aVar);

    void a(c cVar);

    void a(String str);

    void a(C2205a aVar);

    void a(C2206b bVar);

    void a(C2216b bVar);

    void a(boolean z4);

    void b(int i4);

    void b(String str);

    void b(boolean z4);

    boolean b();

    String c();

    void c(int i4);

    void d();

    void d(int i4);

    void e();

    void e(int i4);

    void f();

    void f(int i4);

    int g();

    String g(int i4);

    int h();

    void h(int i4);

    String i();
}
