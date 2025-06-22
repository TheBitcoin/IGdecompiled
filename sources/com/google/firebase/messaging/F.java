package com.google.firebase.messaging;

import M.C0335p;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import k0.C0937l;
import k0.C0938m;

public class F implements Closeable, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    private final URL f11228a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Future f11229b;

    /* renamed from: c  reason: collision with root package name */
    private C0937l f11230c;

    private F(URL url) {
        this.f11228a = url;
    }

    public static /* synthetic */ void a(F f4, C0938m mVar) {
        f4.getClass();
        try {
            mVar.c(f4.d());
        } catch (Exception e5) {
            mVar.b(e5);
        }
    }

    private byte[] g() {
        URLConnection openConnection = this.f11228a.openConnection();
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                byte[] d5 = C1788b.d(C1788b.b(inputStream, 1048577));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable("FirebaseMessaging", 2)) {
                    Log.v("FirebaseMessaging", "Downloaded " + d5.length + " bytes from " + this.f11228a);
                }
                if (d5.length <= 1048576) {
                    return d5;
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        throw th;
    }

    public static F i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new F(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w("FirebaseMessaging", "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    public void close() {
        this.f11229b.cancel(true);
    }

    public Bitmap d() {
        if (Log.isLoggable("FirebaseMessaging", 4)) {
            Log.i("FirebaseMessaging", "Starting download of: " + this.f11228a);
        }
        byte[] g4 = g();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(g4, 0, g4.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Successfully downloaded image: " + this.f11228a);
            }
            return decodeByteArray;
        }
        throw new IOException("Failed to decode image: " + this.f11228a);
    }

    public C0937l k() {
        return (C0937l) C0335p.l(this.f11230c);
    }

    public void l(ExecutorService executorService) {
        C0938m mVar = new C0938m();
        this.f11229b = executorService.submit(new E(this, mVar));
        this.f11230c = mVar.a();
    }
}
