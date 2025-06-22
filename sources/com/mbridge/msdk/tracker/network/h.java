package com.mbridge.msdk.tracker.network;

import android.text.TextUtils;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f15536a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15537b;

    public h(String str, String str2) {
        this.f15536a = str;
        this.f15537b = str2;
    }

    public final String a() {
        return this.f15536a;
    }

    public final String b() {
        return this.f15537b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && h.class == obj.getClass()) {
            h hVar = (h) obj;
            if (!TextUtils.equals(this.f15536a, hVar.f15536a) || !TextUtils.equals(this.f15537b, hVar.f15537b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f15536a.hashCode() * 31) + this.f15537b.hashCode();
    }

    public final String toString() {
        return "Header[name=" + this.f15536a + ",value=" + this.f15537b + "]";
    }
}
