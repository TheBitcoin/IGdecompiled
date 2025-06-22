package com.mbridge.msdk.tracker.network;

public abstract class ad extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final r f15507a;

    /* renamed from: b  reason: collision with root package name */
    private long f15508b;

    /* renamed from: c  reason: collision with root package name */
    private int f15509c;

    /* renamed from: d  reason: collision with root package name */
    private String f15510d;

    public ad() {
        this.f15509c = 0;
        this.f15510d = "";
        this.f15507a = null;
    }

    public abstract int a();

    /* access modifiers changed from: package-private */
    public final void a(long j4) {
        this.f15508b = j4;
    }

    public final int b() {
        return this.f15509c;
    }

    public final String c() {
        return this.f15510d;
    }

    public final void a(int i4) {
        this.f15509c = i4;
    }

    public final void a(String str) {
        this.f15510d = str;
    }

    public ad(r rVar) {
        this.f15509c = 0;
        this.f15510d = "";
        this.f15507a = rVar;
    }

    public ad(String str) {
        super(str);
        this.f15509c = 0;
        this.f15510d = "";
        this.f15507a = null;
    }

    public ad(Throwable th) {
        super(th);
        this.f15509c = 0;
        this.f15510d = "";
        this.f15507a = null;
    }
}
