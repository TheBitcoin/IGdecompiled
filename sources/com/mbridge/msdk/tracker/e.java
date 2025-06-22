package com.mbridge.msdk.tracker;

import java.io.Serializable;
import java.util.UUID;
import org.json.JSONObject;

public final class e implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private String f15440a;

    /* renamed from: b  reason: collision with root package name */
    private int f15441b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f15442c = 0;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f15443d;

    /* renamed from: e  reason: collision with root package name */
    private String f15444e;

    /* renamed from: f  reason: collision with root package name */
    private long f15445f;

    /* renamed from: g  reason: collision with root package name */
    private long f15446g = 0;

    /* renamed from: h  reason: collision with root package name */
    private long f15447h = 604800000;

    /* renamed from: i  reason: collision with root package name */
    private h f15448i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f15449j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f15450k = false;

    public e(String str) {
        this.f15440a = str;
        this.f15445f = System.currentTimeMillis();
        this.f15444e = UUID.randomUUID().toString();
    }

    public final String a() {
        return this.f15440a;
    }

    public final int b() {
        return this.f15441b;
    }

    public final int c() {
        return this.f15442c;
    }

    public final JSONObject d() {
        JSONObject jSONObject = this.f15443d;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.f15443d = jSONObject2;
        return jSONObject2;
    }

    public final String e() {
        return this.f15444e;
    }

    public final long f() {
        return this.f15445f;
    }

    public final long g() {
        return this.f15446g;
    }

    public final long h() {
        return this.f15447h;
    }

    public final h i() {
        return this.f15448i;
    }

    public final boolean j() {
        return this.f15449j;
    }

    public final boolean k() {
        return this.f15450k;
    }

    public final void a(int i4) {
        this.f15441b = i4;
    }

    public final void b(int i4) {
        this.f15442c = i4;
    }

    /* access modifiers changed from: package-private */
    public final void c(long j4) {
        this.f15447h = j4;
    }

    public final void a(JSONObject jSONObject) {
        this.f15443d = jSONObject;
    }

    public final void b(long j4) {
        this.f15446g = j4;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        this.f15444e = str;
    }

    public final void a(long j4) {
        this.f15445f = j4;
    }

    public final void a(h hVar) {
        this.f15448i = hVar;
    }

    public final void a(boolean z4) {
        this.f15450k = z4;
    }
}
