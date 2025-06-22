package com.mbridge.msdk.foundation.b;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f12735a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f12736b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f12737c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static int f12738d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static int f12739e = 4;

    /* renamed from: f  reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f12740f;

    /* renamed from: g  reason: collision with root package name */
    private String f12741g;

    /* renamed from: h  reason: collision with root package name */
    private int f12742h = 21;

    /* renamed from: i  reason: collision with root package name */
    private int f12743i = f12736b;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<String> f12744j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private List<String> f12745k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private List<String> f12746l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private List<String> f12747m = new ArrayList();

    public final CopyOnWriteArrayList<CampaignEx> a() {
        return this.f12740f;
    }

    public final String b() {
        return this.f12741g;
    }

    public final String c() {
        ArrayList<String> arrayList = this.f12744j;
        if (arrayList == null) {
            return "";
        }
        return arrayList.toString();
    }

    public final String d() {
        List<String> list = this.f12745k;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public final String e() {
        List<String> list = this.f12746l;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public final String f() {
        List<String> list = this.f12747m;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public final int g() {
        return this.f12743i;
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.f12740f = copyOnWriteArrayList;
    }

    public final void b(String str) {
        try {
            List<String> list = this.f12745k;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(String str) {
        try {
            ArrayList<String> arrayList = this.f12744j;
            if (arrayList != null) {
                arrayList.add(str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void c(String str) {
        try {
            List<String> list = this.f12746l;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void d(String str) {
        this.f12741g = str;
    }

    public final void a(int i4) {
        this.f12743i = i4;
    }
}
