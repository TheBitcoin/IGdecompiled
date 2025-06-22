package com.mbridge.msdk.video.signal.factory;

import com.mbridge.msdk.video.signal.a.e;
import com.mbridge.msdk.video.signal.a.h;
import com.mbridge.msdk.video.signal.b;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.video.signal.j;

public class a implements IJSFactory {

    /* renamed from: a  reason: collision with root package name */
    protected b f16921a;

    /* renamed from: b  reason: collision with root package name */
    protected d f16922b;

    /* renamed from: c  reason: collision with root package name */
    protected j f16923c;

    /* renamed from: d  reason: collision with root package name */
    protected g f16924d;

    /* renamed from: e  reason: collision with root package name */
    protected f f16925e;

    /* renamed from: f  reason: collision with root package name */
    protected i f16926f;

    /* renamed from: g  reason: collision with root package name */
    protected c f16927g;

    public b getActivityProxy() {
        if (this.f16921a == null) {
            this.f16921a = new com.mbridge.msdk.video.signal.a.b();
        }
        return this.f16921a;
    }

    public i getIJSRewardVideoV1() {
        if (this.f16926f == null) {
            this.f16926f = new com.mbridge.msdk.video.signal.a.g();
        }
        return this.f16926f;
    }

    public c getJSBTModule() {
        if (this.f16927g == null) {
            this.f16927g = new com.mbridge.msdk.video.signal.a.c();
        }
        return this.f16927g;
    }

    public d getJSCommon() {
        if (this.f16922b == null) {
            this.f16922b = new com.mbridge.msdk.video.signal.a.d();
        }
        return this.f16922b;
    }

    public f getJSContainerModule() {
        if (this.f16925e == null) {
            this.f16925e = new e();
        }
        return this.f16925e;
    }

    public g getJSNotifyProxy() {
        if (this.f16924d == null) {
            this.f16924d = new com.mbridge.msdk.video.signal.a.f();
        }
        return this.f16924d;
    }

    public j getJSVideoModule() {
        if (this.f16923c == null) {
            this.f16923c = new h();
        }
        return this.f16923c;
    }
}
