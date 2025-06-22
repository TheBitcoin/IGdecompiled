package com.google.android.gms.internal.measurement;

import java.io.File;

/* renamed from: com.google.android.gms.internal.measurement.m0  reason: case insensitive filesystem */
final class C0615m0 implements C0624n0 {
    C0615m0() {
    }

    public final String a(String str, C0656r0 r0Var, C0633o0 o0Var) {
        return str;
    }

    public final /* synthetic */ String b(File file, String str) {
        return e(file, str, C0656r0.f2120a);
    }

    public final /* synthetic */ String c(String str) {
        return d(str, C0656r0.f2120a);
    }

    public final /* synthetic */ String d(String str, C0656r0 r0Var) {
        return a(str, r0Var, C0633o0.RAW_FILE_IO_TYPE);
    }

    public final /* synthetic */ String e(File file, String str, C0656r0 r0Var) {
        return d(new File(file, str).getPath(), r0Var);
    }
}
