package com.mbridge.msdk.click;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.click.entity.b;
import com.mbridge.msdk.click.m;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import java.util.concurrent.Semaphore;

public final class k extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Semaphore f12088a = new Semaphore(0);

    /* renamed from: b  reason: collision with root package name */
    private Context f12089b;

    /* renamed from: c  reason: collision with root package name */
    private String f12090c;

    /* renamed from: d  reason: collision with root package name */
    private String f12091d;

    /* renamed from: e  reason: collision with root package name */
    private String f12092e;

    /* renamed from: f  reason: collision with root package name */
    private CampaignEx f12093f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12094g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12095h;

    /* renamed from: i  reason: collision with root package name */
    private int f12096i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12097j;

    /* renamed from: k  reason: collision with root package name */
    private com.mbridge.msdk.click.entity.a f12098k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public JumpLoaderResult f12099l;

    /* renamed from: m  reason: collision with root package name */
    private f f12100m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public j f12101n;

    /* renamed from: o  reason: collision with root package name */
    private final m.a f12102o = new m.a() {
        public final boolean a(String str) {
            boolean a5 = k.a(k.this, str);
            if (a5) {
                a();
            }
            return a5;
        }

        public final boolean b(String str) {
            boolean a5 = k.a(k.this, str);
            if (a5) {
                a();
            }
            return a5;
        }

        public final boolean c(String str) {
            return false;
        }

        public final void a(String str, boolean z4, String str2) {
            k.a(k.this, str);
            k.this.f12099l.setContent(str2);
            a();
        }

        private void a() {
            synchronized (this) {
                try {
                    k.this.f12099l.setSuccess(true);
                    if (k.this.f12101n != null) {
                        k.this.f12101n.a(k.this.f12099l);
                    }
                    k.this.f12088a.release();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void a(int i4, String str, String str2, String str3) {
            if (!TextUtils.isEmpty(str2)) {
                k.this.f12099l.setExceptionMsg(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                k.this.f12099l.setContent(str3);
            }
            k.a(k.this, str);
            a();
        }
    };

    public k(b bVar) {
        this.f12089b = bVar.a();
        this.f12090c = bVar.b();
        this.f12091d = bVar.c();
        this.f12092e = bVar.d();
        this.f12093f = bVar.e();
        this.f12094g = bVar.f();
        this.f12095h = bVar.g();
        this.f12096i = bVar.i();
        this.f12097j = bVar.h();
    }

    public final void cancelTask() {
    }

    public final void pauseTask(boolean z4) {
    }

    public final void runTask() {
        f fVar = this.f12100m;
        if (fVar != null) {
            fVar.a((Object) null);
        }
        JumpLoaderResult jumpLoaderResult = new JumpLoaderResult();
        this.f12099l = jumpLoaderResult;
        jumpLoaderResult.setUrl(this.f12090c);
        JumpLoaderResult a5 = a(this.f12090c);
        this.f12099l = a5;
        if (a5 != null && !TextUtils.isEmpty(a5.getExceptionMsg())) {
            this.f12099l.setSuccess(true);
        }
        if (this.mState != a.b.RUNNING) {
            j jVar = this.f12101n;
            if (jVar != null) {
                jVar.a(this.f12099l);
            }
        } else if (!this.f12099l.isSuccess()) {
            j jVar2 = this.f12101n;
            if (jVar2 != null) {
                jVar2.a(this.f12099l);
            }
        } else {
            com.mbridge.msdk.click.entity.a aVar = this.f12098k;
            if (aVar != null) {
                this.f12099l.setStatusCode(aVar.f12066f);
            }
            JumpLoaderResult jumpLoaderResult2 = this.f12099l;
            com.mbridge.msdk.click.entity.a aVar2 = this.f12098k;
            String str = this.f12091d;
            String str2 = this.f12092e;
            Context context = this.f12089b;
            m.a aVar3 = this.f12102o;
            j jVar3 = this.f12101n;
            Semaphore semaphore = this.f12088a;
            if (aj.a.b(jumpLoaderResult2.getUrl()) || 200 != aVar2.f12066f || TextUtils.isEmpty(jumpLoaderResult2.getContent()) || jumpLoaderResult2.getContent().contains("EXCEPTION_CAMPAIGN_NOT_ACTIVE")) {
                if (aVar2 != null) {
                    jumpLoaderResult2.setType(1);
                    jumpLoaderResult2.setExceptionMsg(aVar2.f12068h);
                    jumpLoaderResult2.setStatusCode(aVar2.f12066f);
                    jumpLoaderResult2.setHeader(aVar2.a());
                    jumpLoaderResult2.setContent(aVar2.f12067g);
                }
                String url = jumpLoaderResult2.getUrl();
                if (aj.a.b(url)) {
                    jumpLoaderResult2.setCode(1);
                    jumpLoaderResult2.setUrl(url);
                    jumpLoaderResult2.setjumpDone(true);
                } else {
                    jumpLoaderResult2.setCode(2);
                    jumpLoaderResult2.setUrl(url);
                }
                if (jVar3 != null) {
                    jVar3.a(jumpLoaderResult2);
                    return;
                }
                return;
            }
            jumpLoaderResult2.setType(2);
            if (!TextUtils.isEmpty(jumpLoaderResult2.getContent())) {
                new m().a(str, str2, context, jumpLoaderResult2.getUrl(), jumpLoaderResult2.getContent(), aVar3);
            } else {
                try {
                    new m().a(str, str2, context, jumpLoaderResult2.getUrl(), aVar3);
                } catch (Exception unused) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("TAG", "webview spider start error");
                    }
                }
            }
            semaphore.acquireUninterruptibly();
        }
    }

    private String b(String str) {
        if (this.f12097j) {
            String a5 = com.mbridge.msdk.c.b.a(this.f12089b, str);
            if (!TextUtils.isEmpty(a5)) {
                str = str + a5;
            }
        }
        com.mbridge.msdk.e.b.a();
        return str;
    }

    public final void a(f fVar) {
        this.f12100m = fVar;
    }

    public final void a(j jVar) {
        this.f12101n = jVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x016a A[EDGE_INSN: B:74:0x016a->B:63:0x016a ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.click.entity.JumpLoaderResult a(java.lang.String r15) {
        /*
            r14 = this;
            java.lang.String r15 = r14.b((java.lang.String) r15)
            com.mbridge.msdk.click.entity.JumpLoaderResult r1 = new com.mbridge.msdk.click.entity.JumpLoaderResult
            r1.<init>()
            com.mbridge.msdk.click.l r2 = new com.mbridge.msdk.click.l
            r2.<init>()
            com.mbridge.msdk.click.h r3 = new com.mbridge.msdk.click.h
            r3.<init>()
            java.lang.String r4 = ""
            boolean r0 = android.webkit.URLUtil.isNetworkUrl(r15)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x002d
            java.net.URI r0 = java.net.URI.create(r15)     // Catch:{ Exception -> 0x002a }
            java.lang.String r5 = r0.getScheme()     // Catch:{ Exception -> 0x002a }
            java.lang.String r4 = r0.getHost()     // Catch:{ Exception -> 0x0028 }
            goto L_0x0038
        L_0x0028:
            r0 = move-exception
            goto L_0x002f
        L_0x002a:
            r0 = move-exception
            r5 = r4
            goto L_0x002f
        L_0x002d:
            r0 = r4
            goto L_0x003a
        L_0x002f:
            java.lang.String r6 = "SocketRequestTask"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r6, r0)
        L_0x0038:
            r0 = r4
            r4 = r5
        L_0x003a:
            r5 = 0
            r7 = r15
            r15 = 0
        L_0x003d:
            r6 = 10
            if (r15 >= r6) goto L_0x016a
            com.mbridge.msdk.foundation.same.e.a$b r6 = r14.mState
            com.mbridge.msdk.foundation.same.e.a$b r8 = com.mbridge.msdk.foundation.same.e.a.b.RUNNING
            r9 = 0
            if (r6 == r8) goto L_0x0049
            return r9
        L_0x0049:
            java.lang.String r6 = "tcp"
            boolean r6 = r7.startsWith(r6)
            r8 = 1
            if (r6 == 0) goto L_0x0060
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r14.f12093f
            boolean r10 = r14.f12094g
            boolean r11 = r14.f12095h
            com.mbridge.msdk.click.entity.a r6 = r2.a(r7, r6, r10, r11)
            r14.f12098k = r6
            r6 = 3
            goto L_0x006d
        L_0x0060:
            boolean r6 = r14.f12094g
            boolean r10 = r14.f12095h
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r14.f12093f
            com.mbridge.msdk.click.entity.a r6 = r3.a(r7, r6, r10, r11)
            r14.f12098k = r6
            r6 = 1
        L_0x006d:
            com.mbridge.msdk.click.entity.a r10 = r14.f12098k
            if (r10 != 0) goto L_0x0079
            r1.setUrl(r7)
            r1.setSuccess(r5)
            goto L_0x016a
        L_0x0079:
            java.lang.String r10 = r10.f12068h
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x00b3
            r1.setUrl(r7)
            com.mbridge.msdk.click.entity.a r0 = r14.f12098k
            java.lang.String r0 = r0.f12068h
            r1.setExceptionMsg(r0)
            r1.setType(r6)
            com.mbridge.msdk.click.entity.a r0 = r14.f12098k
            java.lang.String r0 = r0.a()
            r1.setHeader(r0)
            r1.setSuccess(r5)
            if (r15 != 0) goto L_0x016a
            com.mbridge.msdk.click.a.a r6 = com.mbridge.msdk.click.a.a.a()
            com.mbridge.msdk.click.entity.a r15 = r14.f12098k
            java.lang.String r8 = r15.f12068h
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r14.f12093f
            java.lang.String r10 = r14.f12092e
            boolean r11 = r14.f12094g
            boolean r12 = r14.f12095h
            int r13 = r14.f12096i
            r6.a(r7, r8, r9, r10, r11, r12, r13)
            goto L_0x016a
        L_0x00b3:
            com.mbridge.msdk.click.entity.a r6 = r14.f12098k
            int r6 = r6.f12066f
            r10 = 200(0xc8, float:2.8E-43)
            if (r6 != r10) goto L_0x00d1
            r1.setjumpDone(r8)
            r1.setUrl(r7)
            r1.setSuccess(r8)
            com.mbridge.msdk.click.entity.a r15 = r14.f12098k
            java.lang.String r15 = r15.f12067g
            if (r15 != 0) goto L_0x00cb
            goto L_0x00cc
        L_0x00cb:
            r9 = r15
        L_0x00cc:
            r1.setContent(r9)
            goto L_0x016a
        L_0x00d1:
            r10 = 301(0x12d, float:4.22E-43)
            if (r6 == r10) goto L_0x00fd
            r10 = 302(0x12e, float:4.23E-43)
            if (r6 == r10) goto L_0x00fd
            r10 = 307(0x133, float:4.3E-43)
            if (r6 != r10) goto L_0x00de
            goto L_0x00fd
        L_0x00de:
            r1.setjumpDone(r5)
            r1.setUrl(r7)
            if (r15 != 0) goto L_0x016a
            com.mbridge.msdk.click.a.a r6 = com.mbridge.msdk.click.a.a.a()
            com.mbridge.msdk.click.entity.a r15 = r14.f12098k
            java.lang.String r8 = r15.f12068h
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r14.f12093f
            java.lang.String r10 = r14.f12092e
            boolean r11 = r14.f12094g
            boolean r12 = r14.f12095h
            int r13 = r14.f12096i
            r6.a(r7, r8, r9, r10, r11, r12, r13)
            goto L_0x016a
        L_0x00fd:
            r1.setSuccess(r8)
            r1.setIs302Jump(r8)
            com.mbridge.msdk.click.entity.a r6 = r14.f12098k
            java.lang.String r6 = r6.f12061a
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x0114
            r1.setjumpDone(r8)
            r1.setUrl(r7)
            goto L_0x016a
        L_0x0114:
            com.mbridge.msdk.click.entity.a r6 = r14.f12098k
            java.lang.String r6 = r6.f12061a
            java.lang.String r7 = "http"
            boolean r7 = r6.startsWith(r7)
            if (r7 != 0) goto L_0x0155
            java.lang.String r7 = "/"
            boolean r7 = r6.startsWith(r7)
            if (r7 == 0) goto L_0x014e
            boolean r7 = android.text.TextUtils.isEmpty(r4)
            if (r7 != 0) goto L_0x014e
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 != 0) goto L_0x014e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            java.lang.String r4 = "://"
            r7.append(r4)
            r7.append(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r0 = r9
            r4 = r0
            goto L_0x0155
        L_0x014e:
            r1.setjumpDone(r8)
            r1.setUrl(r6)
            goto L_0x016a
        L_0x0155:
            boolean r7 = com.mbridge.msdk.foundation.tools.aj.a.b((java.lang.String) r6)
            if (r7 == 0) goto L_0x0162
            r1.setjumpDone(r8)
            r1.setUrl(r6)
            goto L_0x016a
        L_0x0162:
            java.lang.String r7 = r14.b((java.lang.String) r6)
            int r15 = r15 + 1
            goto L_0x003d
        L_0x016a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.k.a(java.lang.String):com.mbridge.msdk.click.entity.JumpLoaderResult");
    }

    static /* synthetic */ boolean a(k kVar, String str) {
        CampaignEx campaignEx = kVar.f12093f;
        JumpLoaderResult jumpLoaderResult = kVar.f12099l;
        if (aj.a.b(jumpLoaderResult.getUrl())) {
            jumpLoaderResult.setCode(1);
            jumpLoaderResult.setUrl(str);
            jumpLoaderResult.setjumpDone(true);
            return true;
        }
        jumpLoaderResult.setCode(2);
        jumpLoaderResult.setUrl(str);
        return false;
    }
}
