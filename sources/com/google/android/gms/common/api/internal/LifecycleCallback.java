package com.google.android.gms.common.api.internal;

import L.A;
import L.C;
import L.d;
import L.e;
import M.C0335p;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback {

    /* renamed from: a  reason: collision with root package name */
    protected final e f1281a;

    protected LifecycleCallback(e eVar) {
        this.f1281a = eVar;
    }

    protected static e c(d dVar) {
        if (dVar.d()) {
            return C.i(dVar.b());
        }
        if (dVar.c()) {
            return A.f(dVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    public static e d(Activity activity) {
        return c(new d(activity));
    }

    @Keep
    private static e getChimeraLifecycleFragmentImpl(d dVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity b() {
        Activity c5 = this.f1281a.c();
        C0335p.l(c5);
        return c5;
    }

    public void e(int i4, int i5, Intent intent) {
    }

    public void f(Bundle bundle) {
    }

    public void g() {
    }

    public void h() {
    }

    public void i(Bundle bundle) {
    }

    public void j() {
    }

    public void k() {
    }
}
