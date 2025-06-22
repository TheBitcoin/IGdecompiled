package com.mbridge.msdk.tracker;

import java.io.Serializable;

public final class i implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    static String f15459a = "CREATE TABLE IF NOT EXISTS %s (id INTEGER PRIMARY KEY,uuid TEXT,name TEXT,type INTEGER,time_stamp INTEGER,duration INTEGER,properties TEXT,priority INTEGER,state INTEGER,invalid_time INTEGER,ignore_max_timeout INTEGER,ignore_max_retry_times INTEGER,report_count INTEGER)";

    /* renamed from: b  reason: collision with root package name */
    static String f15460b = "DROP TABLE IF EXISTS %s";

    /* renamed from: c  reason: collision with root package name */
    private final e f15461c;

    /* renamed from: d  reason: collision with root package name */
    private int f15462d;

    /* renamed from: e  reason: collision with root package name */
    private int f15463e;

    /* renamed from: f  reason: collision with root package name */
    private final String f15464f;

    /* renamed from: g  reason: collision with root package name */
    private long f15465g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f15466h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f15467i = false;

    public i(e eVar) {
        this.f15461c = eVar;
        this.f15464f = eVar.e();
    }

    public final void a(boolean z4) {
        this.f15466h = z4;
    }

    public final void b(boolean z4) {
        this.f15467i = z4;
    }

    public final e c() {
        return this.f15461c;
    }

    public final int d() {
        return this.f15462d;
    }

    public final int e() {
        return this.f15463e;
    }

    public final String f() {
        return this.f15464f;
    }

    public final long g() {
        return this.f15465g;
    }

    public final boolean a() {
        return this.f15466h;
    }

    public final boolean b() {
        return this.f15467i;
    }

    public final void a(int i4) {
        this.f15462d = i4;
    }

    public final void b(int i4) {
        this.f15463e = i4;
    }

    public final void a(long j4) {
        this.f15465g = j4;
    }
}
