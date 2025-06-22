package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.tracker.network.h;
import j$.util.DesugarCollections;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final int f15613a;

    /* renamed from: b  reason: collision with root package name */
    private final List<h> f15614b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15615c;

    /* renamed from: d  reason: collision with root package name */
    private final InputStream f15616d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f15617e;

    public g(int i4, List<h> list) {
        this(i4, list, -1, (InputStream) null);
    }

    public final int a() {
        return this.f15613a;
    }

    public final List<h> b() {
        return DesugarCollections.unmodifiableList(this.f15614b);
    }

    public final int c() {
        return this.f15615c;
    }

    public final InputStream d() {
        InputStream inputStream = this.f15616d;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.f15617e != null) {
            return new ByteArrayInputStream(this.f15617e);
        }
        return null;
    }

    public g(int i4, List<h> list, int i5, InputStream inputStream) {
        this.f15613a = i4;
        this.f15614b = list;
        this.f15615c = i5;
        this.f15616d = inputStream;
        this.f15617e = null;
    }
}
