package com.mbridge.msdk.newreward.function.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.newreward.a.d;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f14873a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14874b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14875c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f14876d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14877e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f14878f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f14879g;

    /* renamed from: h  reason: collision with root package name */
    private final long f14880h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public c f14881i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f14882j = false;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f14883k = false;

    /* renamed from: l  reason: collision with root package name */
    private d f14884l;

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f14895a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<b> f14896b;

        /* renamed from: c  reason: collision with root package name */
        private final long f14897c;

        public a(Handler handler, b bVar, long j4) {
            this.f14895a = handler;
            this.f14896b = new WeakReference<>(bVar);
            this.f14897c = j4;
        }

        public final void run() {
            b bVar = this.f14896b.get();
            if (bVar != null) {
                try {
                    b.a(bVar);
                } catch (Exception e5) {
                    af.a("LoadCheckController", "startCheckTask error: " + e5.getMessage());
                }
            }
            Handler handler = this.f14895a;
            if (handler != null) {
                handler.postDelayed(this, this.f14897c);
            }
        }
    }

    public b(int i4, String str, String str2, boolean z4) {
        this.f14873a = i4;
        this.f14874b = str;
        this.f14875c = str2;
        this.f14876d = z4;
        this.f14877e = ah.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_LOAD_CHECK_INTERVAL, 120000);
        this.f14880h = (long) ah.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_LOAD_TOKEN_VALIDITY_PERIOD, 1800000);
        this.f14878f = ah.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_LOAD_CHECK_OPTIMIZED, false);
    }

    public final void a(c cVar, d dVar) {
        if (cVar == null || dVar == null) {
            a();
        } else if (!this.f14878f) {
            a();
        } else {
            this.f14884l = dVar;
            this.f14881i = cVar;
            HandlerThread handlerThread = new HandlerThread("load_check_controller");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f14879g = handler;
            handler.postDelayed(new a(handler, this, (long) this.f14877e), (long) this.f14877e);
        }
    }

    private void a() {
        com.mbridge.msdk.newreward.function.d.c.a().b().b(this.f14873a, this.f14874b, this.f14875c);
    }

    private void a(e eVar, com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        eVar.F().a(bVar, bVar2);
    }

    @NonNull
    private e a(com.mbridge.msdk.newreward.function.c.a.b bVar) {
        e eVar = new e(false, this.f14873a, bVar.h(), this.f14875c, bVar.i());
        eVar.f(bVar.g());
        eVar.f(30000);
        eVar.g((int) MBridgeCommon.DEFAULT_LOAD_TIMEOUT);
        eVar.e(this.f14874b);
        eVar.a(true);
        eVar.b(false);
        eVar.c(false);
        return eVar;
    }

    static /* synthetic */ void a(b bVar) {
        if (bVar.f14884l.a() != null) {
            for (e y4 : bVar.f14884l.a()) {
                if (y4.y() == 1) {
                    return;
                }
            }
        }
        if (!bVar.f14882j) {
            bVar.f14882j = true;
            com.mbridge.msdk.newreward.function.d.c.a().b().a(bVar.f14873a, bVar.f14874b, bVar.f14875c, bVar.f14876d, (com.mbridge.msdk.newreward.function.d.b) new com.mbridge.msdk.newreward.function.d.b() {
                public final void a(List<com.mbridge.msdk.newreward.function.c.a.b> list) {
                    b.a(b.this, (List) list);
                }

                public final void a() {
                    b.a(b.this, (e) null, (com.mbridge.msdk.newreward.function.c.a.b) null);
                }
            });
        }
    }

    static /* synthetic */ void a(b bVar, List list) {
        b bVar2 = bVar;
        Iterator it = list.iterator();
        final com.mbridge.msdk.newreward.function.c.a.b bVar3 = null;
        final com.mbridge.msdk.newreward.function.c.a.b bVar4 = null;
        while (it.hasNext()) {
            com.mbridge.msdk.newreward.function.c.a.b bVar5 = (com.mbridge.msdk.newreward.function.c.a.b) it.next();
            if (bVar5.i()) {
                long I4 = bVar5.I();
                if (I4 == 0) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar5.c(), bVar5.d(), bVar5.e(), bVar5.g(), 8);
                } else if (TextUtils.isEmpty(bVar5.h())) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar5.c(), bVar5.d(), bVar5.e(), bVar5.g(), 8);
                } else if (System.currentTimeMillis() - I4 > bVar2.f14880h && bVar5.u() == null) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar5.c(), bVar5.d(), bVar5.e(), bVar5.g(), 8);
                } else if (bVar5.s() <= 0.0d && bVar5.G() != 1) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar5.c(), bVar5.d(), bVar5.e(), bVar5.g(), 8);
                } else if (bVar4 != null && bVar5.s() <= bVar4.s()) {
                }
            } else if (bVar5.I() == 0) {
                com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar5.c(), bVar5.d(), bVar5.e(), bVar5.g(), 8);
            } else if (bVar5.E() == null || bVar5.E().size() == 0) {
                com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar5.c(), bVar5.d(), bVar5.e(), bVar5.g(), 8);
            } else if (bVar4 != null && bVar5.I() <= bVar4.I()) {
            }
            bVar4 = bVar5;
        }
        if (list.size() != 0 && !bVar2.f14883k) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                com.mbridge.msdk.newreward.function.c.a.b bVar6 = (com.mbridge.msdk.newreward.function.c.a.b) it2.next();
                if (!(bVar6 == bVar4 || bVar6.u() == null)) {
                    if (bVar3 == null || bVar6.I() > bVar3.I()) {
                        bVar3 = bVar6;
                    }
                }
            }
        }
        if (!bVar2.f14883k && bVar3 != null) {
            bVar2.f14883k = true;
            final e a5 = bVar2.a(bVar3);
            try {
                c cVar = bVar2.f14881i;
                cVar.a((Object) a5, f.REPORT_LOAD_CHECK, (Object) cVar.a("check_type", "download_start_resource", "campaign", bVar3));
            } catch (Exception e5) {
                af.b("LoadCheckController", "handlerAnthonyNeedDownloadCampaign error: " + e5.getMessage());
            }
            bVar2.a(a5, bVar3, (com.mbridge.msdk.newreward.a.b.b) new com.mbridge.msdk.newreward.a.b.b() {
                public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                    boolean unused = b.this.f14883k = false;
                    try {
                        b.this.f14881i.a((Object) a5, f.REPORT_LOAD_CHECK, (Object) b.this.f14881i.a("check_type", "download_failed", "campaign", bVar3));
                    } catch (Exception e5) {
                        af.b("LoadCheckController", "handlerAnthonyNeedDownloadCampaign error: " + e5.getMessage());
                    }
                }

                public final void reqSuccessful(Object obj) {
                    boolean unused = b.this.f14883k = false;
                    try {
                        b.this.f14881i.a((Object) a5, f.REPORT_LOAD_CHECK, (Object) b.this.f14881i.a("check_type", "download_success", "campaign", bVar3));
                    } catch (Exception e5) {
                        af.b("LoadCheckController", "handlerAnthonyNeedDownloadCampaign error: " + e5.getMessage());
                    }
                }
            });
        }
        if (bVar4 != null) {
            List<CampaignEx> E4 = bVar4.E();
            final e a6 = bVar2.a(bVar4);
            if (E4 == null) {
                try {
                    c cVar2 = bVar2.f14881i;
                    cVar2.a((Object) a6, f.REPORT_LOAD_CHECK, (Object) cVar2.a("check_type", "check_start_campaign"));
                } catch (Exception e6) {
                    af.b("LoadCheckController", "handlerLoadFailedCampaigns error: " + e6.getMessage());
                }
                c cVar3 = bVar2.f14881i;
                cVar3.a((Object) cVar3.a("command_manager", cVar3, "adapter_model", a6), (com.mbridge.msdk.newreward.a.b.b) new com.mbridge.msdk.newreward.a.b.b() {
                    public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                        b.a(b.this, a6, bVar4);
                    }

                    public final void reqSuccessful(Object obj) {
                        b.a(b.this, bVar4, a6);
                    }
                });
                return;
            }
            try {
                c cVar4 = bVar2.f14881i;
                cVar4.a((Object) a6, f.REPORT_LOAD_CHECK, (Object) cVar4.a("check_type", "check_start_resource"));
            } catch (Exception e7) {
                af.b("LoadCheckController", "handlerLoadFailedCampaigns error: " + e7.getMessage());
            }
            bVar2.a(a6, bVar4, (com.mbridge.msdk.newreward.a.b.b) new com.mbridge.msdk.newreward.a.b.b() {
                public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                    b.a(b.this, a6, bVar4);
                }

                public final void reqSuccessful(Object obj) {
                    b.a(b.this, bVar4, a6);
                }
            });
            return;
        }
        bVar2.f14882j = false;
    }

    static /* synthetic */ void a(b bVar, e eVar, com.mbridge.msdk.newreward.function.c.a.b bVar2) {
        Map map;
        bVar.f14882j = false;
        if (eVar != null) {
            if (bVar2 == null) {
                try {
                    map = bVar.f14881i.a("check_type", "check_failed");
                } catch (Exception e5) {
                    af.b("LoadCheckController", "reportLoadCheckFailed error: " + e5.getMessage());
                    return;
                }
            } else {
                map = bVar.f14881i.a("check_type", "check_failed", "campaign", bVar2);
            }
            bVar.f14881i.a((Object) eVar, f.REPORT_LOAD_CHECK, (Object) map);
        }
    }

    static /* synthetic */ void a(b bVar, com.mbridge.msdk.newreward.function.c.a.b bVar2, e eVar) {
        bVar.f14882j = false;
        if (eVar != null) {
            c cVar = bVar.f14881i;
            cVar.a((Object) eVar, f.REPORT_LOAD_CHECK, (Object) cVar.a("check_type", "check_success", "campaign", bVar2));
            eVar.h(true);
            if (!bVar2.i() || bVar2.s() <= 0.0d) {
                bVar.f14884l.a(eVar);
            }
        }
    }
}
