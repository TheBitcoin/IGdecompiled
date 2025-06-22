package com.mbridge.msdk.newreward.function.a;

import java.util.ArrayList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f14462a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f14463b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f14464c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static int f14465d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static int f14466e = 4;

    /* renamed from: f  reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.c.a.b f14467f;

    /* renamed from: g  reason: collision with root package name */
    private String f14468g;

    /* renamed from: h  reason: collision with root package name */
    private int f14469h = 21;

    /* renamed from: i  reason: collision with root package name */
    private int f14470i = f14463b;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<String> f14471j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private List<String> f14472k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private List<String> f14473l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private List<String> f14474m = new ArrayList();

    public final com.mbridge.msdk.newreward.function.c.a.b a() {
        return this.f14467f;
    }

    public final String b() {
        return this.f14468g;
    }

    public final String c() {
        ArrayList<String> arrayList = this.f14471j;
        if (arrayList == null) {
            return "";
        }
        return arrayList.toString();
    }

    public final String d() {
        List<String> list = this.f14472k;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public final String e() {
        List<String> list = this.f14473l;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public final String f() {
        List<String> list = this.f14474m;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public final int g() {
        return this.f14469h;
    }

    public final int h() {
        return this.f14470i;
    }

    public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar) {
        this.f14467f = bVar;
    }

    public final void b(String str) {
        try {
            List<String> list = this.f14472k;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(String str) {
        try {
            ArrayList<String> arrayList = this.f14471j;
            if (arrayList != null) {
                arrayList.add(str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void c(String str) {
        try {
            List<String> list = this.f14473l;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void d(String str) {
        this.f14468g = str;
    }

    public final void a(int i4) {
        this.f14470i = i4;
    }
}
