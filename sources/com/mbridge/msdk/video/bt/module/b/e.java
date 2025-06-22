package com.mbridge.msdk.video.bt.module.b;

import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.video.bt.module.MBTempContainer;

public final class e extends MBTempContainer.a.C0203a {

    /* renamed from: a  reason: collision with root package name */
    private h f15971a;

    /* renamed from: b  reason: collision with root package name */
    private c f15972b;

    public e(c cVar, h hVar) {
        this.f15971a = hVar;
        this.f15972b = cVar;
    }

    public final void a(String str) {
        super.a(str);
        h hVar = this.f15971a;
        if (hVar != null) {
            hVar.a(this.f15972b, str);
        }
    }
}
