package com.google.android.gms.measurement.internal;

import M.C0335p;
import R.d;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.measurement.C0635o2;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.q2  reason: case insensitive filesystem */
public final class C0842q2 extends E5 {
    public C0842q2(H5 h5) {
        super(h5);
    }

    /* access modifiers changed from: private */
    public static byte[] y(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream inputStream2 = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream2.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inputStream2.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public final /* bridge */ /* synthetic */ Context A() {
        return super.A();
    }

    public final /* bridge */ /* synthetic */ d B() {
        return super.B();
    }

    public final /* bridge */ /* synthetic */ C0741c C() {
        return super.C();
    }

    public final /* bridge */ /* synthetic */ C0821n2 a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ C0769g b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ C0887x c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ C0779h2 d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ C0904z2 e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ P2 f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ d6 g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    public final /* bridge */ /* synthetic */ Z5 l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ h6 m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ C0797k n() {
        return super.n();
    }

    public final /* bridge */ /* synthetic */ I2 o() {
        return super.o();
    }

    public final /* bridge */ /* synthetic */ C0796j5 p() {
        return super.p();
    }

    public final /* bridge */ /* synthetic */ G5 q() {
        return super.q();
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        return false;
    }

    public final void v(String str, I5 i5, C0635o2 o2Var, C0862t2 t2Var) {
        String str2;
        k();
        r();
        try {
            URL url = new URI(i5.b()).toURL();
            l();
            byte[] i4 = o2Var.i();
            str2 = str;
            try {
                f().w(new C0869u2(this, str2, url, i4, i5.c(), t2Var));
            } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
                a().G().c("Failed to parse URL. Not uploading MeasurementBatch. appId", C0821n2.s(str2), i5.b());
            }
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            str2 = str;
            a().G().c("Failed to parse URL. Not uploading MeasurementBatch. appId", C0821n2.s(str2), i5.b());
        }
    }

    public final void w(String str, URL url, byte[] bArr, Map map, C0862t2 t2Var) {
        k();
        r();
        C0335p.l(url);
        C0335p.l(bArr);
        C0335p.l(t2Var);
        f().w(new C0869u2(this, str, url, bArr, map, t2Var));
    }

    public final boolean z() {
        r();
        ConnectivityManager connectivityManager = (ConnectivityManager) A().getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }
}
