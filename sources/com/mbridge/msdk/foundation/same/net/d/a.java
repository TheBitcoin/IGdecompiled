package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.tracker.network.h;
import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f13257a;

    /* renamed from: b  reason: collision with root package name */
    public final List<h> f13258b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f13259c;

    /* renamed from: d  reason: collision with root package name */
    public final int f13260d;

    public a(int i4, byte[] bArr, List<h> list) {
        this(i4, bArr, a(list), list);
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

    private a(int i4, byte[] bArr, Map<String, String> map, List<h> list) {
        this.f13260d = i4;
        this.f13257a = bArr;
        this.f13259c = map;
        if (list == null) {
            this.f13258b = null;
        } else {
            this.f13258b = DesugarCollections.unmodifiableList(list);
        }
    }
}
