package com.mbridge.msdk.newreward.function.c.c;

import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import java.io.File;
import java.util.ArrayList;

public final class n extends a<File> {

    /* renamed from: b  reason: collision with root package name */
    private final y f14578b = new y(b(), c(), this, 100);

    /* renamed from: c  reason: collision with root package name */
    private File f14579c;

    public n(b bVar, a aVar) {
        super(bVar, aVar);
    }

    public final void a(File file) {
        this.f14579c = file;
    }

    public final int b_() {
        return 1;
    }

    public final File g() {
        return this.f14579c;
    }

    public final boolean h() {
        if (c() == null || c().h() == null) {
            return true;
        }
        ArrayList<Integer> rsIgnoreCheckRule = c().h().getRsIgnoreCheckRule();
        if (rsIgnoreCheckRule == null) {
            return false;
        }
        return rsIgnoreCheckRule.contains(0);
    }

    public final String j() {
        if (c() == null || c().h() == null) {
            return "";
        }
        return c().h().getVideoUrlEncode();
    }

    public final boolean k() {
        return true;
    }

    public final q l() {
        return this.f14578b;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        return this.f14579c;
    }
}
