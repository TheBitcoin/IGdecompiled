package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;

@KeepName
public abstract class GooglePlayServicesManifestException extends IllegalStateException {

    /* renamed from: a  reason: collision with root package name */
    private final int f1244a;

    public GooglePlayServicesManifestException(int i4, String str) {
        super(str);
        this.f1244a = i4;
    }
}
