package com.mbridge.msdk.d;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.c.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.m;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.i;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import java.util.LinkedList;
import java.util.List;

public final class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public long f12160a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f12161b;

    /* renamed from: c  reason: collision with root package name */
    private LinkedList<i> f12162c;

    /* renamed from: d  reason: collision with root package name */
    private LinkedList<i> f12163d;

    /* renamed from: e  reason: collision with root package name */
    private int f12164e;

    /* renamed from: f  reason: collision with root package name */
    private int f12165f;

    /* renamed from: g  reason: collision with root package name */
    private e f12166g;

    /* renamed from: h  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.a f12167h;

    /* renamed from: i  reason: collision with root package name */
    private m f12168i;

    /* renamed from: j  reason: collision with root package name */
    private g f12169j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Handler f12170k;

    /* renamed from: com.mbridge.msdk.d.a$a  reason: collision with other inner class name */
    static class C0175a {

        /* renamed from: a  reason: collision with root package name */
        static a f12174a = new a();
    }

    static /* synthetic */ void c(a aVar) {
        try {
            LinkedList<i> linkedList = aVar.f12162c;
            if (linkedList == null || linkedList.size() <= 0 || aVar.f12164e >= aVar.f12162c.size()) {
                LinkedList<i> linkedList2 = aVar.f12163d;
                if (linkedList2 != null && linkedList2.size() > 0 && aVar.f12165f < aVar.f12163d.size()) {
                    i iVar = aVar.f12163d.get(aVar.f12165f);
                    aVar.f12165f++;
                    if (aVar.a(iVar)) {
                        aVar.a(iVar.a(), iVar.b(), true);
                        return;
                    }
                    return;
                }
                return;
            }
            i iVar2 = aVar.f12162c.get(aVar.f12164e);
            aVar.f12164e++;
            if (aVar.a(iVar2)) {
                aVar.a(iVar2.a(), iVar2.b(), false);
            }
        } catch (Throwable th) {
            af.b("LoopTimer", th.getMessage(), th);
        }
    }

    private a() {
        this.f12161b = false;
        this.f12162c = new LinkedList<>();
        this.f12163d = new LinkedList<>();
        this.f12164e = 0;
        this.f12165f = 0;
        this.f12170k = new Handler() {
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void handleMessage(android.os.Message r5) {
                /*
                    r4 = this;
                    com.mbridge.msdk.d.a r0 = com.mbridge.msdk.d.a.this
                    monitor-enter(r0)
                    int r5 = r5.what     // Catch:{ all -> 0x0012 }
                    r1 = 1
                    if (r5 == r1) goto L_0x0014
                    r1 = 2
                    if (r5 == r1) goto L_0x000c
                    goto L_0x0034
                L_0x000c:
                    com.mbridge.msdk.d.a r5 = com.mbridge.msdk.d.a.this     // Catch:{ all -> 0x0012 }
                    com.mbridge.msdk.d.a.c(r5)     // Catch:{ all -> 0x0012 }
                    goto L_0x0034
                L_0x0012:
                    r5 = move-exception
                    goto L_0x0036
                L_0x0014:
                    com.mbridge.msdk.d.a r5 = com.mbridge.msdk.d.a.this     // Catch:{ all -> 0x0012 }
                    boolean r5 = r5.f12161b     // Catch:{ all -> 0x0012 }
                    if (r5 == 0) goto L_0x001e
                    monitor-exit(r0)     // Catch:{ all -> 0x0012 }
                    return
                L_0x001e:
                    com.mbridge.msdk.d.a r5 = com.mbridge.msdk.d.a.this     // Catch:{ all -> 0x0012 }
                    long r2 = r5.f12160a     // Catch:{ all -> 0x0012 }
                    com.mbridge.msdk.d.a.a((com.mbridge.msdk.d.a) r5, (long) r2)     // Catch:{ all -> 0x0012 }
                    android.os.Message r5 = r4.obtainMessage(r1)     // Catch:{ all -> 0x0012 }
                    com.mbridge.msdk.d.a r1 = com.mbridge.msdk.d.a.this     // Catch:{ all -> 0x0012 }
                    long r1 = r1.f12160a     // Catch:{ all -> 0x0012 }
                    r4.sendMessageDelayed(r5, r1)     // Catch:{ all -> 0x0012 }
                L_0x0034:
                    monitor-exit(r0)     // Catch:{ all -> 0x0012 }
                    return
                L_0x0036:
                    monitor-exit(r0)     // Catch:{ all -> 0x0012 }
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.d.a.AnonymousClass1.handleMessage(android.os.Message):void");
            }
        };
    }

    private boolean a(i iVar) {
        boolean z4 = false;
        if (iVar != null && !TextUtils.isEmpty(iVar.b())) {
            String b5 = iVar.b();
            try {
                if (this.f12166g == null) {
                    return true;
                }
                com.mbridge.msdk.videocommon.d.a aVar = this.f12167h;
                int a5 = this.f12166g.a(b5, aVar != null ? aVar.f() : 0);
                if (a5 != -1) {
                    if (a5 == 1) {
                        return true;
                    }
                } else if (!TextUtils.isEmpty(b5)) {
                    LinkedList<i> linkedList = this.f12162c;
                    if (linkedList == null || !linkedList.contains(b5)) {
                        LinkedList<i> linkedList2 = this.f12163d;
                        if (linkedList2 != null && linkedList2.contains(b5)) {
                            this.f12163d.remove(b5);
                        }
                    } else {
                        this.f12162c.remove(b5);
                    }
                    m mVar = this.f12168i;
                    if (mVar != null) {
                        mVar.a(b5);
                    }
                }
                try {
                    Handler handler = this.f12170k;
                    handler.sendMessage(handler.obtainMessage(2));
                    return false;
                } catch (Throwable th) {
                    th = th;
                    af.b("LoopTimer", th.getMessage(), th);
                    return z4;
                }
            } catch (Throwable th2) {
                th = th2;
                z4 = true;
                af.b("LoopTimer", th.getMessage(), th);
                return z4;
            }
        }
        return z4;
    }

    public final void b(String str, String str2) {
        if (!this.f12163d.contains(str2)) {
            this.f12163d.add(new i(str, str2, 287));
            m mVar = this.f12168i;
            if (mVar != null) {
                mVar.a(str, str2, 287);
            }
        }
    }

    private void a(String str, String str2, boolean z4) {
        try {
            Context c5 = c.m().c();
            if (c5 != null) {
                final com.mbridge.msdk.reward.adapter.c cVar = new com.mbridge.msdk.reward.adapter.c(c5, str, str2);
                cVar.b(z4);
                cVar.a((com.mbridge.msdk.reward.adapter.a) new com.mbridge.msdk.reward.adapter.a() {
                    public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.d.c cVar) {
                    }

                    public final void a(List<CampaignEx> list, b bVar, com.mbridge.msdk.foundation.same.report.d.c cVar) {
                        a.this.f12170k.sendMessage(a.this.f12170k.obtainMessage(2));
                        cVar.a((com.mbridge.msdk.reward.adapter.a) null);
                    }

                    public final void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
                        a.this.f12170k.sendMessage(a.this.f12170k.obtainMessage(2));
                        cVar.a((com.mbridge.msdk.reward.adapter.a) null);
                    }
                });
                com.mbridge.msdk.foundation.same.report.d.c cVar2 = new com.mbridge.msdk.foundation.same.report.d.c();
                cVar2.c(SameMD5.getMD5(ak.d()));
                cVar2.d(str2);
                if (z4) {
                    cVar2.b(287);
                } else {
                    cVar2.b(94);
                }
                cVar2.i("0");
                cVar2.b("1");
                cVar.a(1, 8000, false, cVar2);
            }
        } catch (Exception e5) {
            af.b("LoopTimer", e5.getMessage(), e5);
        }
    }

    public final void a(String str, String str2) {
        if (!this.f12162c.contains(str2)) {
            this.f12162c.add(new i(str, str2, 94));
            m mVar = this.f12168i;
            if (mVar != null) {
                mVar.a(str, str2, 94);
            }
        }
    }

    public final void a(long j4) {
        if (this.f12169j == null) {
            this.f12169j = g.a(c.m().c());
        }
        if (this.f12168i == null) {
            this.f12168i = m.a((f) this.f12169j);
        }
        List<i> a5 = this.f12168i.a(287);
        if (a5 != null) {
            this.f12163d.addAll(a5);
            for (i next : a5) {
                b(next.a(), next.b());
            }
        }
        List<i> a6 = this.f12168i.a(94);
        if (a6 != null) {
            this.f12162c.addAll(a6);
            for (i next2 : a6) {
                a(next2.a(), next2.b());
            }
        }
        if (this.f12166g == null) {
            this.f12166g = e.a((f) this.f12169j);
        }
        if (this.f12167h == null) {
            this.f12167h = com.mbridge.msdk.videocommon.d.b.a().b();
        }
        this.f12160a = j4;
        this.f12161b = false;
        Handler handler = this.f12170k;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f12160a);
    }

    static /* synthetic */ void a(a aVar, long j4) {
        LinkedList<i> linkedList = aVar.f12162c;
        if (linkedList == null || linkedList.size() <= 0 || aVar.f12164e == 0 || aVar.f12162c.size() <= aVar.f12164e) {
            LinkedList<i> linkedList2 = aVar.f12163d;
            if (linkedList2 == null || linkedList2.size() <= 0 || aVar.f12165f == 0 || aVar.f12163d.size() == aVar.f12165f) {
                aVar.f12165f = 0;
                aVar.f12164e = 0;
                Handler handler = aVar.f12170k;
                handler.sendMessage(handler.obtainMessage(2));
            }
        }
    }
}
