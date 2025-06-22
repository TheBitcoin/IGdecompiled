package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.m7  reason: case insensitive filesystem */
public final class C0622m7 implements C0595j7 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f2054a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0591j3 f2055b;

    /* renamed from: c  reason: collision with root package name */
    private static final C0591j3 f2056c;

    /* renamed from: d  reason: collision with root package name */
    private static final C0591j3 f2057d;

    /* renamed from: e  reason: collision with root package name */
    private static final C0591j3 f2058e;

    /* renamed from: f  reason: collision with root package name */
    private static final C0591j3 f2059f;

    /* renamed from: g  reason: collision with root package name */
    private static final C0591j3 f2060g;

    /* renamed from: h  reason: collision with root package name */
    private static final C0591j3 f2061h;

    /* renamed from: i  reason: collision with root package name */
    private static final C0591j3 f2062i;

    /* renamed from: j  reason: collision with root package name */
    private static final C0591j3 f2063j;

    /* renamed from: k  reason: collision with root package name */
    private static final C0591j3 f2064k;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        f2054a = e5.d("measurement.rb.attribution.ad_campaign_info", false);
        f2055b = e5.d("measurement.rb.attribution.client.bundle_on_backgrounded", true);
        f2056c = e5.d("measurement.rb.attribution.service.bundle_on_backgrounded", true);
        f2057d = e5.d("measurement.rb.attribution.client2", true);
        e5.d("measurement.rb.attribution.dma_fix", true);
        f2058e = e5.d("measurement.rb.attribution.followup1.service", false);
        e5.d("measurement.rb.attribution.index_out_of_bounds_fix", true);
        f2059f = e5.d("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", true);
        f2060g = e5.d("measurement.rb.attribution.retry_disposition", false);
        f2061h = e5.d("measurement.rb.attribution.service", true);
        f2062i = e5.d("measurement.rb.attribution.enable_trigger_redaction", true);
        f2063j = e5.d("measurement.rb.attribution.uuid_generation", true);
        e5.b("measurement.id.rb.attribution.retry_disposition", 0);
        f2064k = e5.d("measurement.rb.attribution.improved_retry", true);
    }

    public final boolean A() {
        return true;
    }

    public final boolean B() {
        return ((Boolean) f2054a.e()).booleanValue();
    }

    public final boolean C() {
        return ((Boolean) f2056c.e()).booleanValue();
    }

    public final boolean D() {
        return ((Boolean) f2057d.e()).booleanValue();
    }

    public final boolean E() {
        return ((Boolean) f2058e.e()).booleanValue();
    }

    public final boolean F() {
        return ((Boolean) f2060g.e()).booleanValue();
    }

    public final boolean a() {
        return ((Boolean) f2062i.e()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f2055b.e()).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) f2061h.e()).booleanValue();
    }

    public final boolean e() {
        return ((Boolean) f2059f.e()).booleanValue();
    }

    public final boolean f() {
        return ((Boolean) f2064k.e()).booleanValue();
    }

    public final boolean g() {
        return ((Boolean) f2063j.e()).booleanValue();
    }
}
