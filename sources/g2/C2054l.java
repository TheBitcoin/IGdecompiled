package g2;

import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.m;
import u2.w;

/* renamed from: g2.l  reason: case insensitive filesystem */
public final class C2054l {

    /* renamed from: a  reason: collision with root package name */
    public String f20697a;

    /* renamed from: b  reason: collision with root package name */
    public String f20698b;

    /* renamed from: c  reason: collision with root package name */
    private int f20699c = -1;

    public final String a() {
        String str = this.f20698b;
        if (str != null) {
            return str;
        }
        m.u("date");
        return null;
    }

    public final int b() {
        return this.f20699c;
    }

    public final String c() {
        String substring = e().substring(m3.m.R(e(), "/", 0, false, 6, (Object) null) + 1);
        m.d(substring, "substring(...)");
        return substring;
    }

    public final String d() {
        return new w().i(c());
    }

    public final String e() {
        String str = this.f20697a;
        if (str != null) {
            return str;
        }
        m.u(MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        return null;
    }

    public final void f(String str) {
        m.e(str, "<set-?>");
        this.f20698b = str;
    }

    public final void g(int i4) {
        this.f20699c = i4;
    }

    public final void h(String str) {
        m.e(str, "<set-?>");
        this.f20697a = str;
    }
}
