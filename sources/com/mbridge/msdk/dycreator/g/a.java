package com.mbridge.msdk.dycreator.g;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;

public abstract class a extends com.mbridge.msdk.dycreator.c.a {

    /* renamed from: a  reason: collision with root package name */
    protected ConcurrentHashMap<Integer, Object> f12643a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private List<Object> f12644b = new ArrayList();

    public final synchronized void a(Object obj, int i4) {
        if (obj != null) {
            ConcurrentHashMap<Integer, Object> concurrentHashMap = this.f12643a;
            if (concurrentHashMap != null && !concurrentHashMap.containsValue(obj)) {
                this.f12643a.put(Integer.valueOf(i4), obj);
            }
        }
    }

    public final synchronized void a() {
        this.f12643a.clear();
    }
}
