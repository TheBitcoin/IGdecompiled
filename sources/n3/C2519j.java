package N3;

import S2.C1601o;
import S2.H;
import d3.l;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.m;

/* renamed from: N3.j  reason: case insensitive filesystem */
public final class C2519j {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f23719a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f23720b;

    /* renamed from: c  reason: collision with root package name */
    private final Q f23721c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f23722d;

    /* renamed from: e  reason: collision with root package name */
    private final Long f23723e;

    /* renamed from: f  reason: collision with root package name */
    private final Long f23724f;

    /* renamed from: g  reason: collision with root package name */
    private final Long f23725g;

    /* renamed from: h  reason: collision with root package name */
    private final Map f23726h;

    public C2519j(boolean z4, boolean z5, Q q4, Long l4, Long l5, Long l6, Long l7, Map map) {
        m.e(map, "extras");
        this.f23719a = z4;
        this.f23720b = z5;
        this.f23721c = q4;
        this.f23722d = l4;
        this.f23723e = l5;
        this.f23724f = l6;
        this.f23725g = l7;
        this.f23726h = H.r(map);
    }

    public final Long a() {
        return this.f23724f;
    }

    public final Long b() {
        return this.f23722d;
    }

    public final boolean c() {
        return this.f23720b;
    }

    public final boolean d() {
        return this.f23719a;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f23719a) {
            arrayList.add("isRegularFile");
        }
        if (this.f23720b) {
            arrayList.add("isDirectory");
        }
        if (this.f23722d != null) {
            arrayList.add("byteCount=" + this.f23722d);
        }
        if (this.f23723e != null) {
            arrayList.add("createdAt=" + this.f23723e);
        }
        if (this.f23724f != null) {
            arrayList.add("lastModifiedAt=" + this.f23724f);
        }
        if (this.f23725g != null) {
            arrayList.add("lastAccessedAt=" + this.f23725g);
        }
        if (!this.f23726h.isEmpty()) {
            arrayList.add("extras=" + this.f23726h);
        }
        return C1601o.O(arrayList, ", ", "FileMetadata(", ")", 0, (CharSequence) null, (l) null, 56, (Object) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ C2519j(boolean r2, boolean r3, N3.Q r4, java.lang.Long r5, java.lang.Long r6, java.lang.Long r7, java.lang.Long r8, java.util.Map r9, int r10, kotlin.jvm.internal.C2103g r11) {
        /*
            r1 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0006
            r2 = 0
        L_0x0006:
            r11 = r10 & 2
            if (r11 == 0) goto L_0x000b
            r3 = 0
        L_0x000b:
            r11 = r10 & 4
            r0 = 0
            if (r11 == 0) goto L_0x0011
            r4 = r0
        L_0x0011:
            r11 = r10 & 8
            if (r11 == 0) goto L_0x0016
            r5 = r0
        L_0x0016:
            r11 = r10 & 16
            if (r11 == 0) goto L_0x001b
            r6 = r0
        L_0x001b:
            r11 = r10 & 32
            if (r11 == 0) goto L_0x0020
            r7 = r0
        L_0x0020:
            r11 = r10 & 64
            if (r11 == 0) goto L_0x0025
            r8 = r0
        L_0x0025:
            r10 = r10 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x002d
            java.util.Map r9 = S2.H.g()
        L_0x002d:
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.C2519j.<init>(boolean, boolean, N3.Q, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.util.Map, int, kotlin.jvm.internal.g):void");
    }
}
