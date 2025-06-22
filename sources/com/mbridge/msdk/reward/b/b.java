package com.mbridge.msdk.reward.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.reward.b.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final a f15352a;

    public b(a aVar) {
        super(Looper.getMainLooper());
        this.f15352a = aVar;
    }

    public final void handleMessage(Message message) {
        boolean z4;
        String str;
        int i4;
        Message message2 = message;
        int i5 = message2.what;
        Object obj = message2.obj;
        c a5 = this.f15352a.a(message2);
        CopyOnWriteArrayList<CampaignEx> e5 = this.f15352a.e();
        List<CampaignEx> f4 = this.f15352a.f();
        com.mbridge.msdk.reward.adapter.c g4 = this.f15352a.g();
        boolean h4 = this.f15352a.h();
        String j4 = this.f15352a.j();
        String i6 = this.f15352a.i();
        a.c k4 = this.f15352a.k();
        InterVideoOutListener l4 = this.f15352a.l();
        boolean m4 = this.f15352a.m();
        MBridgeIds n4 = this.f15352a.n();
        boolean o4 = this.f15352a.o();
        boolean z5 = m4;
        switch (i5) {
            case 8:
                if (e5 != null && e5.size() > 0) {
                    if (f4 == null || f4.size() <= 0) {
                        z4 = false;
                    } else {
                        z4 = !TextUtils.isEmpty(f4.get(0).getCMPTEntryUrl());
                    }
                    int nscpt = e5.get(0).getNscpt();
                    if (g4 == null || !g4.a((List<CampaignEx>) e5, z4, nscpt)) {
                        if (k4 != null && h4) {
                            com.mbridge.msdk.videocommon.a.c(i6);
                            com.mbridge.msdk.videocommon.a.a();
                            com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880010, "load timeout");
                            if (a5 != null) {
                                a5.a(b5);
                            }
                            k4.a(b5, a5);
                            return;
                        }
                        return;
                    } else if (k4 != null && h4) {
                        k4.a(j4, i6, a5);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 9:
                if (l4 != null && h4) {
                    if (z5) {
                        this.f15352a.c();
                    }
                    l4.onVideoLoadSuccess(n4);
                    return;
                }
                return;
            case 16:
            case 18:
                if (l4 != null && h4) {
                    if (obj instanceof String) {
                        str = obj.toString();
                    } else {
                        str = "";
                    }
                    if (!(a5 == null || a5.o() == null)) {
                        str = a5.o().b();
                    }
                    com.mbridge.msdk.videocommon.a.c(i6);
                    com.mbridge.msdk.videocommon.a.a();
                    if (z5) {
                        this.f15352a.c();
                    }
                    l4.onVideoLoadFail(n4, str);
                    return;
                }
                return;
            case 17:
                if (l4 != null && h4) {
                    if (z5) {
                        this.f15352a.c();
                    }
                    l4.onLoadSuccess(n4);
                    return;
                }
                return;
            case 1001001:
                d a6 = d.a();
                if (o4) {
                    i4 = 287;
                } else {
                    i4 = 94;
                }
                this.f15352a.a(false, a6.a(0, i4, i6, true, 1));
                return;
            case 1001002:
                if (g4 == null) {
                    return;
                }
                if (g4.b()) {
                    if (k4 != null) {
                        CopyOnWriteArrayList<CampaignEx> d5 = g4.d();
                        if (d5 != null && d5.size() == 0) {
                            d5 = g4.e();
                        }
                        this.f15352a.a((List<CampaignEx>) d5);
                        c a7 = this.f15352a.a((List<CampaignEx>) d5, a5);
                        if (a7 != null) {
                            a7.b((List<CampaignEx>) d5);
                        }
                        k4.b(j4, i6, a7);
                        return;
                    }
                    return;
                } else if (g4.h(false)) {
                    if (!g4.b()) {
                        g4.g(false);
                        if (!g4.h(true)) {
                            return;
                        }
                        if (!g4.b()) {
                            g4.g(true);
                            return;
                        } else if (k4 != null) {
                            g4.f(true);
                            CopyOnWriteArrayList<CampaignEx> d6 = g4.d();
                            if (d6 != null && d6.size() == 0) {
                                d6 = g4.e();
                            }
                            this.f15352a.a((List<CampaignEx>) d6);
                            c a8 = this.f15352a.a((List<CampaignEx>) d6, a5);
                            if (a8 != null) {
                                a8.b((List<CampaignEx>) d6);
                            }
                            k4.b(j4, i6, a8);
                            return;
                        } else {
                            return;
                        }
                    } else if (k4 != null) {
                        g4.f(false);
                        CopyOnWriteArrayList<CampaignEx> d7 = g4.d();
                        if (d7 != null && d7.size() == 0) {
                            d7 = g4.e();
                        }
                        this.f15352a.a((List<CampaignEx>) d7);
                        c a9 = this.f15352a.a((List<CampaignEx>) d7, a5);
                        if (a9 != null) {
                            a9.b((List<CampaignEx>) d7);
                        }
                        k4.b(j4, i6, a9);
                        return;
                    } else {
                        return;
                    }
                } else if (!g4.h(true)) {
                    return;
                } else {
                    if (!g4.b()) {
                        g4.g(true);
                        return;
                    } else if (k4 != null) {
                        g4.f(true);
                        CopyOnWriteArrayList<CampaignEx> d8 = g4.d();
                        if (d8 != null && d8.size() == 0) {
                            d8 = g4.e();
                        }
                        this.f15352a.a((List<CampaignEx>) d8);
                        c a10 = this.f15352a.a((List<CampaignEx>) d8, a5);
                        if (a10 != null) {
                            a10.b((List<CampaignEx>) d8);
                        }
                        k4.b(j4, i6, a10);
                        return;
                    } else {
                        return;
                    }
                }
            default:
                return;
        }
    }
}
