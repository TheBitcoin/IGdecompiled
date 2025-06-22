package com.mbridge.msdk.tracker.network;

import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final int f15600a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f15601b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f15602c;

    /* renamed from: d  reason: collision with root package name */
    public final List<h> f15603d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15604e;

    /* renamed from: f  reason: collision with root package name */
    public final long f15605f;

    public r(int i4, byte[] bArr, boolean z4, long j4, List<h> list) {
        this(i4, bArr, a(list), list, z4, j4);
    }

    private static Map<String, String> a(List<h> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (h next : list) {
            treeMap.put(next.a(), next.b());
        }
        return treeMap;
    }

    private r(int i4, byte[] bArr, Map<String, String> map, List<h> list, boolean z4, long j4) {
        this.f15600a = i4;
        this.f15601b = bArr;
        this.f15602c = map;
        if (list == null) {
            this.f15603d = null;
        } else {
            this.f15603d = DesugarCollections.unmodifiableList(list);
        }
        this.f15604e = z4;
        this.f15605f = j4;
    }
}
