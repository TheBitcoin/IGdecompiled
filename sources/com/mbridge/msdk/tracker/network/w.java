package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.tracker.network.b;

public final class w<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f15665a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f15666b;

    /* renamed from: c  reason: collision with root package name */
    public final ad f15667c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f15668d;

    public interface a {
        void a(ad adVar);
    }

    public interface b<T> {
        void a(T t4);
    }

    private w(T t4, b.a aVar) {
        this.f15668d = false;
        this.f15665a = t4;
        this.f15666b = aVar;
        this.f15667c = null;
    }

    public static <T> w<T> a(T t4, b.a aVar) {
        return new w<>(t4, aVar);
    }

    public static <T> w<T> a(ad adVar) {
        return new w<>(adVar);
    }

    private w(ad adVar) {
        this.f15668d = false;
        this.f15665a = null;
        this.f15666b = null;
        this.f15667c = adVar;
    }
}
