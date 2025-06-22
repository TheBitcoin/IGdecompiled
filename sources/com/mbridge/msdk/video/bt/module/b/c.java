package com.mbridge.msdk.video.bt.module.b;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.bt.module.a.b;

public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private b f15960a;

    /* renamed from: d  reason: collision with root package name */
    private String f15961d;

    public c(b bVar, String str) {
        this.f15960a = bVar;
        this.f15961d = str;
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f15960a != null) {
            af.a("H5ShowRewardListener", "onAdShow");
            this.f15960a.a(this.f15961d);
        }
    }

    public final void b(String str, String str2) {
        if (this.f15960a != null) {
            af.a("H5ShowRewardListener", "onEndcardShow");
            this.f15960a.c(this.f15961d, str, str2);
        }
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, boolean z4, com.mbridge.msdk.videocommon.b.c cVar2) {
        if (this.f15960a != null) {
            af.a("H5ShowRewardListener", "onAdClose");
            this.f15960a.a(this.f15961d, z4, cVar2);
        }
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, String str) {
        if (this.f15960a != null) {
            af.a("H5ShowRewardListener", "onShowFail");
            this.f15960a.a(this.f15961d, str);
        }
    }

    public final void a(boolean z4, String str, String str2) {
        if (this.f15960a != null) {
            af.a("H5ShowRewardListener", "onVideoAdClicked");
            this.f15960a.a(this.f15961d, str, str2);
        }
    }

    public final void a(String str, String str2) {
        if (this.f15960a != null) {
            af.a("H5ShowRewardListener", "onVideoComplete");
            this.f15960a.b(this.f15961d, str, str2);
        }
    }

    public final void a(int i4, String str, String str2) {
        if (this.f15960a != null) {
            af.a("H5ShowRewardListener", "onAutoLoad");
            this.f15960a.a(this.f15961d, i4, str, str2);
        }
    }
}
