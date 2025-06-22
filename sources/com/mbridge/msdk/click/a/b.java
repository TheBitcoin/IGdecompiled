package com.mbridge.msdk.click.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f12028a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f12029b = 1;

    /* renamed from: c  reason: collision with root package name */
    private String f12030c;

    /* renamed from: d  reason: collision with root package name */
    private int f12031d;

    /* renamed from: e  reason: collision with root package name */
    private HashSet<String> f12032e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    private long f12033f = System.currentTimeMillis();

    /* renamed from: g  reason: collision with root package name */
    private CampaignEx f12034g;

    /* renamed from: h  reason: collision with root package name */
    private String f12035h;

    /* renamed from: i  reason: collision with root package name */
    private int f12036i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12037j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f12038k;

    /* renamed from: l  reason: collision with root package name */
    private int f12039l;

    public b(String str, String str2) {
        this.f12030c = str;
        b(str2);
    }

    public final boolean a() {
        return this.f12037j;
    }

    public final boolean b() {
        return this.f12038k;
    }

    public final int c() {
        return this.f12039l;
    }

    public final int d() {
        return this.f12036i;
    }

    public final String e() {
        return this.f12035h;
    }

    public final CampaignEx f() {
        return this.f12034g;
    }

    public final String g() {
        return this.f12030c;
    }

    public final int h() {
        return this.f12031d;
    }

    public final HashSet<String> i() {
        return this.f12032e;
    }

    public final long j() {
        return this.f12033f;
    }

    public final void a(boolean z4) {
        this.f12037j = z4;
    }

    public final void b(boolean z4) {
        this.f12038k = z4;
    }

    public final void a(int i4) {
        this.f12039l = i4;
    }

    public final void b(int i4) {
        this.f12036i = i4;
    }

    public final void a(String str) {
        this.f12035h = str;
    }

    public final void b(String str) {
        this.f12031d++;
        this.f12032e.add(str);
    }

    public final void a(CampaignEx campaignEx) {
        this.f12034g = campaignEx;
    }
}
