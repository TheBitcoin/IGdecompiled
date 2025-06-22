package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.videocommon.d.b;
import com.mbridge.msdk.videocommon.d.c;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a implements Serializable {

    /* renamed from: A  reason: collision with root package name */
    private int f17037A;

    /* renamed from: B  reason: collision with root package name */
    private File f17038B;
    /* access modifiers changed from: private */

    /* renamed from: C  reason: collision with root package name */
    public int f17039C;

    /* renamed from: D  reason: collision with root package name */
    private int f17040D;

    /* renamed from: E  reason: collision with root package name */
    private int f17041E;

    /* renamed from: F  reason: collision with root package name */
    private int f17042F;

    /* renamed from: G  reason: collision with root package name */
    private boolean f17043G;

    /* renamed from: H  reason: collision with root package name */
    private k f17044H;

    /* renamed from: I  reason: collision with root package name */
    private c f17045I;

    /* renamed from: J  reason: collision with root package name */
    private k f17046J;

    /* renamed from: K  reason: collision with root package name */
    private boolean f17047K;

    /* renamed from: L  reason: collision with root package name */
    private boolean f17048L;

    /* renamed from: M  reason: collision with root package name */
    private boolean f17049M;

    /* renamed from: N  reason: collision with root package name */
    private boolean f17050N;

    /* renamed from: O  reason: collision with root package name */
    private boolean f17051O;

    /* renamed from: P  reason: collision with root package name */
    private boolean f17052P;

    /* renamed from: Q  reason: collision with root package name */
    private boolean f17053Q;

    /* renamed from: R  reason: collision with root package name */
    private OnDownloadStateListener f17054R;

    /* renamed from: S  reason: collision with root package name */
    private OnProgressStateListener f17055S;

    /* renamed from: a  reason: collision with root package name */
    private boolean f17056a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f17057b = 1;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f17058c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f17059d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public volatile int f17060e = 0;

    /* renamed from: f  reason: collision with root package name */
    private CopyOnWriteArrayList<c> f17061f = new CopyOnWriteArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f17062g;

    /* renamed from: h  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f17063h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public CampaignEx f17064i;

    /* renamed from: j  reason: collision with root package name */
    private String f17065j;

    /* renamed from: k  reason: collision with root package name */
    private Context f17066k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public long f17067l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public String f17068m;

    /* renamed from: n  reason: collision with root package name */
    private String f17069n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public long f17070o = 0;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public String f17071p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f17072q = false;

    /* renamed from: r  reason: collision with root package name */
    private long f17073r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f17074s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f17075t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public n f17076u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f17077v;

    /* renamed from: w  reason: collision with root package name */
    private String f17078w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public DownloadRequest f17079x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public int f17080y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public boolean f17081z;

    /* JADX WARNING: Can't wrap try/catch for region: R(7:99|100|101|102|(4:104|(1:106)|107|(1:109))|110|119) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x02e5 */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02ea A[Catch:{ Exception -> 0x012c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.content.Context r18, com.mbridge.msdk.foundation.entity.CampaignEx r19, java.lang.String r20, int r21) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            java.lang.String r2 = "cache"
            java.lang.String r3 = ""
            r1.<init>()
            r4 = 0
            r1.f17056a = r4
            r5 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r1.f17057b = r5
            r1.f17059d = r4
            r1.f17060e = r4
            java.util.concurrent.CopyOnWriteArrayList r7 = new java.util.concurrent.CopyOnWriteArrayList
            r7.<init>()
            r1.f17061f = r7
            r7 = 0
            r1.f17070o = r7
            r1.f17072q = r4
            r9 = 100
            r1.f17074s = r9
            r1.f17075t = r4
            r1.f17077v = r4
            r1.f17039C = r5
            r1.f17043G = r4
            r1.f17047K = r4
            r1.f17048L = r4
            r1.f17049M = r4
            r1.f17050N = r4
            r1.f17051O = r4
            r1.f17052P = r4
            r1.f17053Q = r4
            com.mbridge.msdk.videocommon.download.a$1 r10 = new com.mbridge.msdk.videocommon.download.a$1
            r10.<init>()
            r1.f17054R = r10
            com.mbridge.msdk.videocommon.download.a$2 r10 = new com.mbridge.msdk.videocommon.download.a$2
            r10.<init>()
            r1.f17055S = r10
            if (r18 != 0) goto L_0x0054
            if (r0 != 0) goto L_0x0054
            goto L_0x0330
        L_0x0054:
            com.mbridge.msdk.c.h r10 = com.mbridge.msdk.c.h.a()
            com.mbridge.msdk.foundation.controller.c r11 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r11 = r11.k()
            com.mbridge.msdk.c.g r10 = r10.a(r11)
            if (r10 == 0) goto L_0x006c
            boolean r10 = r10.aG()
            r1.f17043G = r10
        L_0x006c:
            int r10 = com.mbridge.msdk.foundation.same.a.f13147u
            r1.f17040D = r10
            int r10 = com.mbridge.msdk.foundation.same.a.f13148v
            r1.f17041E = r10
            int r10 = com.mbridge.msdk.foundation.same.a.f13146t
            r1.f17042F = r10
            long r10 = java.lang.System.currentTimeMillis()
            r1.f17073r = r10
            com.mbridge.msdk.foundation.controller.c r10 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r10 = r10.c()
            r1.f17066k = r10
            r1.f17064i = r0
            r10 = r20
            r1.f17065j = r10
            r10 = r21
            r1.f17057b = r10
            if (r0 == 0) goto L_0x009a
            java.lang.String r0 = r0.getVideoUrlEncode()
            r1.f17068m = r0
        L_0x009a:
            java.lang.String r0 = r1.f17068m
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.ad.c((java.lang.String) r0)
            r1.f17078w = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.mbridge.msdk.foundation.same.b.c r10 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_VC
            java.lang.String r10 = com.mbridge.msdk.foundation.same.b.e.a((com.mbridge.msdk.foundation.same.b.c) r10)
            r0.append(r10)
            java.lang.String r10 = java.io.File.separator
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            r1.f17069n = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r10 = r1.f17069n
            r0.append(r10)
            java.lang.String r10 = r1.f17078w
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            r1.f17071p = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r1.f17064i
            java.lang.String r10 = r10.getAppName()
            r0.append(r10)
            java.lang.String r10 = " videoLocalPath:"
            r0.append(r10)
            java.lang.String r10 = r1.f17071p
            r0.append(r10)
            java.lang.String r10 = " videoUrl: "
            r0.append(r10)
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r1.f17064i
            java.lang.String r10 = r10.getVideoUrlEncode()
            r0.append(r10)
            java.lang.String r10 = " "
            r0.append(r10)
            int r10 = r1.f17074s
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r10 = "CampaignDownLoadTask"
            com.mbridge.msdk.foundation.tools.af.c(r10, r0)
            java.lang.String r0 = r1.f17068m     // Catch:{ Exception -> 0x012c }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x0113
            goto L_0x0330
        L_0x0113:
            java.lang.String r0 = r1.f17069n     // Catch:{ Exception -> 0x012c }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x012c }
            if (r0 != 0) goto L_0x012f
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r1.f17069n     // Catch:{ Exception -> 0x012c }
            r0.<init>(r11)     // Catch:{ Exception -> 0x012c }
            boolean r11 = r0.exists()     // Catch:{ Exception -> 0x012c }
            if (r11 != 0) goto L_0x0130
            r0.mkdirs()     // Catch:{ Exception -> 0x012c }
            goto L_0x0130
        L_0x012c:
            r0 = move-exception
            goto L_0x0329
        L_0x012f:
            r0 = 0
        L_0x0130:
            if (r0 == 0) goto L_0x0165
            boolean r11 = r0.exists()     // Catch:{ Exception -> 0x012c }
            if (r11 == 0) goto L_0x0165
            java.io.File r11 = r1.f17038B     // Catch:{ Exception -> 0x012c }
            if (r11 == 0) goto L_0x0142
            boolean r11 = r11.exists()     // Catch:{ Exception -> 0x012c }
            if (r11 != 0) goto L_0x0165
        L_0x0142:
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x012c }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012c }
            r12.<init>()     // Catch:{ Exception -> 0x012c }
            r12.append(r0)     // Catch:{ Exception -> 0x012c }
            java.lang.String r0 = "/.nomedia"
            r12.append(r0)     // Catch:{ Exception -> 0x012c }
            java.lang.String r0 = r12.toString()     // Catch:{ Exception -> 0x012c }
            r11.<init>(r0)     // Catch:{ Exception -> 0x012c }
            r1.f17038B = r11     // Catch:{ Exception -> 0x012c }
            boolean r0 = r11.exists()     // Catch:{ Exception -> 0x012c }
            if (r0 != 0) goto L_0x0165
            java.io.File r0 = r1.f17038B     // Catch:{ Exception -> 0x012c }
            r0.createNewFile()     // Catch:{ Exception -> 0x012c }
        L_0x0165:
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x012c }
            android.content.Context r0 = r0.c()     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.db.g r0 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r0)     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.db.n r0 = com.mbridge.msdk.foundation.db.n.a((com.mbridge.msdk.foundation.db.f) r0)     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r1.f17068m     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.entity.m r11 = r0.a((java.lang.String) r11, (java.lang.String) r3)     // Catch:{ Exception -> 0x012c }
            r12 = 5
            if (r11 == 0) goto L_0x0204
            long r13 = r11.c()     // Catch:{ Exception -> 0x012c }
            r1.f17070o = r13     // Catch:{ Exception -> 0x012c }
            int r0 = r1.f17060e     // Catch:{ Exception -> 0x012c }
            r13 = 2
            if (r0 == r13) goto L_0x018f
            int r0 = r11.b()     // Catch:{ Exception -> 0x012c }
            r1.f17060e = r0     // Catch:{ Exception -> 0x012c }
        L_0x018f:
            int r0 = r1.f17060e     // Catch:{ Exception -> 0x012c }
            if (r0 != r5) goto L_0x0195
            r1.f17060e = r13     // Catch:{ Exception -> 0x012c }
        L_0x0195:
            int r0 = r11.d()     // Catch:{ Exception -> 0x012c }
            long r13 = (long) r0     // Catch:{ Exception -> 0x012c }
            r1.f17067l = r13     // Catch:{ Exception -> 0x012c }
            long r13 = r11.a()     // Catch:{ Exception -> 0x012c }
            int r0 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x01aa
            long r13 = r11.a()     // Catch:{ Exception -> 0x012c }
            r1.f17073r = r13     // Catch:{ Exception -> 0x012c }
        L_0x01aa:
            int r0 = r1.f17060e     // Catch:{ Exception -> 0x012c }
            if (r0 != r12) goto L_0x01ea
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x012c }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012c }
            r11.<init>()     // Catch:{ Exception -> 0x012c }
            java.lang.String r13 = r1.f17069n     // Catch:{ Exception -> 0x012c }
            r11.append(r13)     // Catch:{ Exception -> 0x012c }
            java.lang.String r13 = r1.f17078w     // Catch:{ Exception -> 0x012c }
            r11.append(r13)     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x012c }
            r0.<init>(r11)     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r1.f17069n     // Catch:{ Exception -> 0x012c }
            java.lang.String r13 = r1.f17078w     // Catch:{ Exception -> 0x012c }
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.exists(r0, r11, r13)     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x01e6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012c }
            r0.<init>()     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r1.f17069n     // Catch:{ Exception -> 0x012c }
            r0.append(r11)     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r1.f17078w     // Catch:{ Exception -> 0x012c }
            r0.append(r11)     // Catch:{ Exception -> 0x012c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x012c }
            r1.f17071p = r0     // Catch:{ Exception -> 0x012c }
            goto L_0x020b
        L_0x01e6:
            r1.u()     // Catch:{ Exception -> 0x012c }
            goto L_0x020b
        L_0x01ea:
            int r0 = r1.f17060e     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x020b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012c }
            r0.<init>()     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r1.f17069n     // Catch:{ Exception -> 0x012c }
            r0.append(r11)     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r1.f17078w     // Catch:{ Exception -> 0x012c }
            r0.append(r11)     // Catch:{ Exception -> 0x012c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x012c }
            r1.f17071p = r0     // Catch:{ Exception -> 0x012c }
            goto L_0x020b
        L_0x0204:
            java.lang.String r11 = r1.f17068m     // Catch:{ Exception -> 0x012c }
            long r13 = r1.f17073r     // Catch:{ Exception -> 0x012c }
            r0.a((java.lang.String) r11, (long) r13)     // Catch:{ Exception -> 0x012c }
        L_0x020b:
            long r13 = r1.f17067l     // Catch:{ Exception -> 0x0231 }
            int r0 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x0248
            long r7 = r1.f17070o     // Catch:{ Exception -> 0x0231 }
            r15 = 100
            long r7 = r7 * r15
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f17064i     // Catch:{ Exception -> 0x0231 }
            int r0 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ Exception -> 0x0231 }
            long r4 = (long) r0     // Catch:{ Exception -> 0x0231 }
            long r13 = r13 * r4
            int r0 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r0 < 0) goto L_0x0248
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f17064i     // Catch:{ Exception -> 0x0231 }
            int r0 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ Exception -> 0x0231 }
            if (r0 == r9) goto L_0x0233
            int r0 = r1.f17060e     // Catch:{ Exception -> 0x0231 }
            if (r0 != r12) goto L_0x0248
            goto L_0x0233
        L_0x0231:
            r0 = move-exception
            goto L_0x0241
        L_0x0233:
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0231 }
            r0.<init>()     // Catch:{ Exception -> 0x0231 }
            r0.a(r2, r6)     // Catch:{ Exception -> 0x0231 }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r1.f17064i     // Catch:{ Exception -> 0x0231 }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r4, (com.mbridge.msdk.foundation.same.report.d.e) r0)     // Catch:{ Exception -> 0x0231 }
            goto L_0x0248
        L_0x0241:
            boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x012c }
            if (r4 == 0) goto L_0x0248
            r0.printStackTrace()     // Catch:{ Exception -> 0x012c }
        L_0x0248:
            java.lang.String r4 = r1.f17068m     // Catch:{ Exception -> 0x012c }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x0259
            com.mbridge.msdk.videocommon.listener.a r0 = r1.f17063h     // Catch:{ Exception -> 0x012c }
            java.lang.String r2 = "VideoUrl is NULL, Please check it."
            r0.a(r2, r3)     // Catch:{ Exception -> 0x012c }
            goto L_0x0330
        L_0x0259:
            int r0 = r1.f17060e     // Catch:{ Exception -> 0x012c }
            r5 = 1
            if (r0 != r5) goto L_0x0265
            java.lang.String r0 = "Run : Task is RUNNING, Will return."
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ Exception -> 0x012c }
            goto L_0x0330
        L_0x0265:
            int r0 = r1.f17060e     // Catch:{ Exception -> 0x012c }
            if (r0 != r12) goto L_0x02c1
            long r7 = r1.f17067l     // Catch:{ Exception -> 0x012c }
            long r12 = r1.f17070o     // Catch:{ Exception -> 0x012c }
            int r0 = com.mbridge.msdk.foundation.download.utils.Utils.getDownloadRate(r7, r12)     // Catch:{ Exception -> 0x012c }
            int r5 = r1.f17074s     // Catch:{ Exception -> 0x012c }
            if (r0 < r5) goto L_0x02c1
            java.lang.String r0 = "Run : Video Done, Will callback."
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.videocommon.listener.a r0 = r1.f17062g     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x0283
            java.lang.String r3 = r1.f17068m     // Catch:{ Exception -> 0x012c }
            r0.a(r3)     // Catch:{ Exception -> 0x012c }
        L_0x0283:
            com.mbridge.msdk.videocommon.listener.a r0 = r1.f17063h     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x028c
            java.lang.String r3 = r1.f17068m     // Catch:{ Exception -> 0x012c }
            r0.a(r3)     // Catch:{ Exception -> 0x012c }
        L_0x028c:
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x02ab }
            java.lang.String r3 = r1.f17071p     // Catch:{ Exception -> 0x02ab }
            r0.<init>(r3)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r3 = r1.f17069n     // Catch:{ Exception -> 0x02ab }
            java.lang.String r4 = r1.f17078w     // Catch:{ Exception -> 0x02ab }
            boolean r3 = com.mbridge.msdk.foundation.download.utils.Objects.exists(r0, r3, r4)     // Catch:{ Exception -> 0x02ab }
            if (r3 == 0) goto L_0x02b3
            boolean r3 = r0.isFile()     // Catch:{ Exception -> 0x02ab }
            if (r3 == 0) goto L_0x02b3
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02ab }
            r0.setLastModified(r3)     // Catch:{ Exception -> 0x02ab }
            goto L_0x02b3
        L_0x02ab:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.tools.af.b(r10, r0)     // Catch:{ Exception -> 0x012c }
        L_0x02b3:
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x012c }
            r0.<init>()     // Catch:{ Exception -> 0x012c }
            r0.a(r2, r6)     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.f17064i     // Catch:{ Exception -> 0x012c }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (com.mbridge.msdk.foundation.same.report.d.e) r0)     // Catch:{ Exception -> 0x012c }
            goto L_0x0330
        L_0x02c1:
            int r0 = r1.f17057b     // Catch:{ Exception -> 0x012c }
            r5 = 3
            if (r0 != r5) goto L_0x02df
            java.lang.String r0 = "Run : Dlnet is 3, Will callback."
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ Exception -> 0x012c }
            r4 = 0
            r11 = 0
            r1.a((long) r4, (boolean) r11, (java.lang.String) r3)     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x012c }
            r0.<init>()     // Catch:{ Exception -> 0x012c }
            r0.a(r2, r6)     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.f17064i     // Catch:{ Exception -> 0x012c }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (com.mbridge.msdk.foundation.same.report.d.e) r0)     // Catch:{ Exception -> 0x012c }
            goto L_0x0330
        L_0x02df:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f17064i     // Catch:{ Exception -> 0x02e5 }
            int r9 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ Exception -> 0x02e5 }
        L_0x02e5:
            r1.c((int) r9)     // Catch:{ Exception -> 0x012c }
            if (r9 != 0) goto L_0x02fc
            com.mbridge.msdk.videocommon.listener.a r0 = r1.f17062g     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x02f3
            java.lang.String r2 = r1.f17068m     // Catch:{ Exception -> 0x012c }
            r0.a(r2)     // Catch:{ Exception -> 0x012c }
        L_0x02f3:
            com.mbridge.msdk.videocommon.listener.a r0 = r1.f17063h     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x02fc
            java.lang.String r2 = r1.f17068m     // Catch:{ Exception -> 0x012c }
            r0.a(r2)     // Catch:{ Exception -> 0x012c }
        L_0x02fc:
            com.mbridge.msdk.foundation.download.DownloadMessage r2 = new com.mbridge.msdk.foundation.download.DownloadMessage     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.f17064i     // Catch:{ Exception -> 0x012c }
            java.lang.String r5 = r1.f17078w     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.download.DownloadResourceType r7 = com.mbridge.msdk.foundation.download.DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO     // Catch:{ Exception -> 0x012c }
            r6 = 100
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f17064i     // Catch:{ Exception -> 0x012c }
            int r0 = r1.e((com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ Exception -> 0x012c }
            r2.setUseCronetDownload(r0)     // Catch:{ Exception -> 0x012c }
            java.lang.String r0 = "resource_type"
            r3 = 4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x012c }
            r2.addExtra(r0, r3)     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.download.OnDownloadStateListener r0 = r1.f17054R     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.download.OnProgressStateListener r3 = r1.f17055S     // Catch:{ Exception -> 0x012c }
            java.lang.String r4 = "1"
            com.mbridge.msdk.foundation.download.core.DownloadRequest r0 = r1.a((com.mbridge.msdk.foundation.download.DownloadMessage) r2, (com.mbridge.msdk.foundation.download.OnDownloadStateListener) r0, (com.mbridge.msdk.foundation.download.OnProgressStateListener) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x012c }
            r1.f17079x = r0     // Catch:{ Exception -> 0x012c }
            goto L_0x0330
        L_0x0329:
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.c(r10, r0)
        L_0x0330:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.a.<init>(android.content.Context, com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.String, int):void");
    }

    private void u() {
        if (this.f17076u == null) {
            this.f17076u = n.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        try {
            this.f17076u.b(this.f17068m);
            if (!ah.a().a("r_d_v_b_l", true)) {
                File file = new File(this.f17071p);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
            af.b("CampaignDownLoadTask", "del DB or file failed");
        } finally {
            this.f17060e = 0;
        }
    }

    /* access modifiers changed from: private */
    public void v() {
        Class<CampaignEx> cls = CampaignEx.class;
        Class<String> cls2 = String.class;
        Class<com.mbridge.msdk.reward.b.a> cls3 = com.mbridge.msdk.reward.b.a.class;
        try {
            String str = com.mbridge.msdk.reward.b.a.f15240b;
            com.mbridge.msdk.reward.b.a newInstance = cls3.newInstance();
            cls3.getMethod("insertExcludeId", new Class[]{cls2, cls}).invoke(newInstance, new Object[]{this.f17065j, this.f17064i});
            Class<?> cls4 = Class.forName("com.mbridge.msdk.mbnative.controller.NativeController");
            Object newInstance2 = cls4.newInstance();
            cls4.getMethod("insertExcludeId", new Class[]{cls2, cls}).invoke(newInstance2, new Object[]{this.f17065j, this.f17064i});
        } catch (Exception e5) {
            af.b("CampaignDownLoadTask", e5.getMessage());
        }
    }

    public final void o() {
        af.b("CampaignDownLoadTask", "start()");
        try {
            if (!TextUtils.isEmpty(this.f17068m)) {
                if (this.f17068m != null) {
                    af.b("CampaignDownLoadTask", new URL(this.f17068m).getPath());
                }
                if (this.f17074s == 0 && this.f17039C == 2) {
                    af.b("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                    return;
                }
                DownloadRequest downloadRequest = this.f17079x;
                if (downloadRequest != null) {
                    downloadRequest.start();
                }
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.f17062g;
            if (aVar != null) {
                aVar.a("VideoUrl is not illegal, Please check it.", "");
            }
            com.mbridge.msdk.videocommon.listener.a aVar2 = this.f17063h;
            if (aVar2 != null) {
                aVar2.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    public final void p() {
        if (!this.f17053Q) {
            try {
                this.f17081z = true;
                if (this.f17039C == 1) {
                    af.b("CampaignDownLoadTask", "Can not call resume(), because videoCtnType = " + this.f17039C);
                } else if (this.f17057b == 3) {
                    af.b("CampaignDownLoadTask", "Can not call resume(), because dlnet = " + this.f17057b);
                } else {
                    af.b("CampaignDownLoadTask", "resume()");
                    this.f17051O = false;
                    this.f17052P = false;
                    DownloadMessage downloadMessage = new DownloadMessage(new Object(), this.f17068m, this.f17078w, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
                    downloadMessage.setUseCronetDownload(e(this.f17064i));
                    DownloadRequest<?> a5 = a(downloadMessage, this.f17054R, this.f17055S, "2");
                    this.f17079x = a5;
                    a5.start();
                }
            } catch (Exception e5) {
                af.b("CampaignDownLoadTask", e5.getMessage());
            }
        }
    }

    public final String q() {
        String str = "";
        if (this.f17057b == 3) {
            return str;
        }
        String str2 = this.f17069n + this.f17078w;
        File file = new File(str2);
        try {
            if (!Objects.exists(file, this.f17069n, this.f17078w)) {
                str = "file is not exist ";
            } else if (!file.isFile()) {
                str = "file is not file ";
            } else if (!file.canRead()) {
                str = "file can not read ";
            } else if (file.length() > 0) {
                this.f17071p = str2;
            } else {
                str = "file length is 0 ";
            }
        } catch (Throwable th) {
            af.b("CampaignDownLoadTask", th.getMessage());
            str = th.getMessage();
        }
        if (this.f17060e == 5 && !TextUtils.isEmpty(str)) {
            u();
        }
        return str;
    }

    public final void r() {
        if (this.f17061f != null) {
            this.f17061f = null;
        }
    }

    public final void s() {
        try {
            u();
            CampaignEx campaignEx = this.f17064i;
            if (campaignEx == null || campaignEx.getPlayable_ads_without_video() != 2) {
                com.mbridge.msdk.videocommon.a.a a5 = com.mbridge.msdk.videocommon.a.a.a();
                if (a5 != null) {
                    a5.a(this.f17064i);
                }
                this.f17060e = 0;
            }
        } catch (Exception unused) {
            af.b("CampaignDownLoadTask", "del file is failed");
        } finally {
            this.f17060e = 0;
        }
    }

    public final String t() {
        if (this.f17053Q) {
            try {
                File file = new File(this.f17071p);
                if (!file.exists() || !file.isFile()) {
                    return this.f17068m;
                }
                return this.f17071p;
            } catch (Exception e5) {
                af.b("CampaignDownLoadTask", e5.getMessage());
                return this.f17068m;
            }
        } else {
            try {
                File file2 = new File(this.f17071p);
                if (Objects.exists(file2, this.f17069n, this.f17078w) && file2.isFile()) {
                    return this.f17071p;
                }
            } catch (Exception e6) {
                af.b("CampaignDownLoadTask", e6.getMessage());
            }
            return this.f17068m;
        }
    }

    public final void c(boolean z4) {
        this.f17049M = z4;
    }

    public final void d(boolean z4) {
        this.f17050N = z4;
    }

    public final String e() {
        return this.f17068m;
    }

    public final boolean f() {
        return this.f17077v;
    }

    public final long g() {
        return this.f17073r;
    }

    public final String h() {
        return this.f17071p;
    }

    public final boolean i() {
        return this.f17053Q;
    }

    public final long j() {
        return this.f17067l;
    }

    public final int k() {
        return this.f17060e;
    }

    public final CampaignEx l() {
        return this.f17064i;
    }

    public final long m() {
        return this.f17070o;
    }

    public final void n() {
        af.b("CampaignDownLoadTask", "startForLoadRefactor()");
        try {
            if (TextUtils.isEmpty(this.f17068m)) {
                com.mbridge.msdk.videocommon.listener.a aVar = this.f17062g;
                if (aVar != null) {
                    aVar.a(this.f17068m);
                    return;
                }
                return;
            }
            if (this.f17068m != null) {
                af.b("CampaignDownLoadTask", new URL(this.f17068m).getPath());
            }
            if (this.f17057b == 3) {
                af.b("CampaignDownLoadTask", "startForLoadRefactor: Dlnet is 3, Will callback.");
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.f17062g;
                if (aVar2 != null) {
                    aVar2.a(this.f17068m);
                }
            } else if (this.f17074s == 0 && this.f17039C == 2) {
                af.b("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                com.mbridge.msdk.videocommon.listener.a aVar3 = this.f17062g;
                if (aVar3 != null) {
                    aVar3.a(this.f17068m);
                }
            } else {
                try {
                    if (this.f17060e == 5 && Utils.getDownloadRate(this.f17067l, this.f17070o) >= this.f17074s) {
                        if (Objects.exists(new File(this.f17069n + this.f17078w), this.f17069n, this.f17078w)) {
                            this.f17071p = this.f17069n + this.f17078w;
                            com.mbridge.msdk.videocommon.listener.a aVar4 = this.f17062g;
                            if (aVar4 != null) {
                                aVar4.a(this.f17068m);
                                return;
                            }
                            return;
                        }
                    }
                } catch (Exception e5) {
                    af.b("CampaignDownLoadTask", "startForLoadRefactor: " + e5.getMessage());
                }
                DownloadRequest downloadRequest = this.f17079x;
                if (downloadRequest != null) {
                    downloadRequest.start();
                }
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar5 = this.f17062g;
            if (aVar5 != null) {
                aVar5.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    public final boolean c() {
        return this.f17049M;
    }

    public final boolean d() {
        return this.f17050N;
    }

    public final void e(boolean z4) {
        this.f17077v = z4;
    }

    public final void f(boolean z4) {
        this.f17072q = z4;
    }

    public final void b(boolean z4) {
        this.f17048L = z4;
    }

    public final void c(int i4) {
        af.a("CampaignDownLoadTask", "set ready rate: " + i4);
        this.f17074s = i4;
    }

    public final void d(int i4) {
        this.f17037A = i4;
    }

    public final void e(int i4) {
        this.f17039C = i4;
    }

    private int d(CampaignEx campaignEx) {
        try {
            k kVar = this.f17046J;
            if (kVar != null) {
                return kVar.p();
            }
            return 100;
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            af.b("CampaignDownLoadTask", e5.getMessage());
            return 100;
        }
    }

    private int e(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 0;
        }
        try {
            if (campaignEx.getAabEntity() != null) {
                return campaignEx.getAabEntity().h3c;
            }
            return 0;
        } catch (Throwable th) {
            af.b("CampaignDownLoadTask", th.getMessage());
            return 0;
        }
    }

    public final boolean b() {
        return this.f17048L;
    }

    private int c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 100;
        }
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.f17044H == null) {
                    this.f17044H = h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), this.f17065j);
                }
                return this.f17044H.p();
            } else if (campaignEx.getAdType() == 42) {
                if (this.f17046J == null) {
                    this.f17046J = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f17065j);
                }
                return d((CampaignEx) null);
            } else {
                if (this.f17045I == null) {
                    this.f17045I = b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f17065j, false);
                }
                return this.f17045I.r();
            }
        } catch (Throwable th) {
            af.b("CampaignDownLoadTask", th.getMessage(), th);
            return 100;
        }
    }

    public final void b(int i4) {
        this.f17058c = i4;
    }

    private int b(CampaignEx campaignEx) {
        int i4;
        if (campaignEx == null) {
            return 100;
        }
        if (campaignEx.getReady_rate() != -1) {
            i4 = campaignEx.getReady_rate();
            af.a("CampaignDownLoadTask", "ready_rate(campaign): " + i4);
        } else {
            i4 = c(campaignEx);
            af.a("CampaignDownLoadTask", "ready_rate(reward_unit_setting): " + i4);
        }
        try {
            return Math.max(i4, 0);
        } catch (Exception unused) {
            return 100;
        }
    }

    public final void a(boolean z4) {
        this.f17047K = z4;
    }

    public final boolean a() {
        return this.f17047K;
    }

    public final void d(String str) {
        this.f17068m = str;
    }

    public final void a(int i4) {
        this.f17057b = i4;
    }

    public final void a(int i4, int i5) {
        this.f17060e = i4;
        if (this.f17076u == null) {
            this.f17076u = n.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        this.f17076u.a(this.f17068m, (long) i5, i4);
    }

    public final void b(String str) {
        v();
        a(2, str, "");
        this.f17060e = 4;
    }

    public final void a(CampaignEx campaignEx) {
        this.f17064i = campaignEx;
    }

    private DownloadRequest<?> a(DownloadMessage downloadMessage, OnDownloadStateListener onDownloadStateListener, OnProgressStateListener onProgressStateListener, String str) {
        return MBDownloadManager.getInstance().download(downloadMessage).withReadTimeout((long) this.f17040D).withConnectTimeout((long) this.f17042F).withWriteTimeout((long) this.f17041E).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.f17069n).withDownloadStateListener(onDownloadStateListener).withProgressStateListener(onProgressStateListener).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS).with("do_us_fi_re", Boolean.toString(this.f17043G)).with("download_scene", "download_video").with(CampaignEx.JSON_KEY_READY_RATE, String.valueOf(this.f17074s)).with("scenes", str).build();
    }

    public final void b(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.f17063h = aVar;
    }

    public final void c(String str) {
        this.f17071p = str;
    }

    public final void a(long j4, boolean z4, String str) {
        n nVar;
        af.b("CampaignDownLoadTask", "setStateToDone 下载完成  ： mProgressSize" + this.f17070o + "  progressSize " + j4 + "  " + this.f17080y + "%   FileSize : " + this.f17067l + "  " + this.f17064i.getAppName());
        long j5 = 0;
        if (this.f17074s != 100 || this.f17057b == 3 || j4 == this.f17067l || z4) {
            this.f17060e = 5;
            if (j4 == this.f17067l) {
                a(1, "", str);
            }
            long j6 = this.f17067l;
            if (!(j6 == 0 || (nVar = this.f17076u) == null)) {
                nVar.b(this.f17068m, j6);
            }
            this.f17056a = false;
            a(j4, this.f17060e);
            return;
        }
        File file = new File(this.f17071p);
        if (Objects.exists(file, this.f17069n, this.f17078w)) {
            j5 = file.length();
        }
        af.b("CampaignDownLoadTask", "progressSize = " + j4 + " fileSize = " + this.f17067l + " " + z4 + " absFileSize = " + j5);
        a("File size is not match witch download size.");
    }

    public final void a(String str) {
        com.mbridge.msdk.videocommon.listener.a aVar = this.f17062g;
        if (aVar != null) {
            aVar.a(str, this.f17068m);
        }
        com.mbridge.msdk.videocommon.listener.a aVar2 = this.f17063h;
        if (aVar2 != null) {
            aVar2.a(str, this.f17068m);
        }
        af.b("CampaignDownLoadTask", "Video download stop : " + str);
        if (this.f17060e != 4 && this.f17060e != 2 && this.f17060e != 5) {
            this.f17060e = 4;
            CampaignEx campaignEx = this.f17064i;
            if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || this.f17064i.getRsIgnoreCheckRule().size() <= 0 || !this.f17064i.getRsIgnoreCheckRule().contains(0)) {
                a(this.f17070o, this.f17060e);
            } else {
                af.c("CampaignDownLoadTask", "Is not check video download status");
            }
        }
    }

    public final void a(c cVar) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f17061f;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(cVar);
        }
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.f17062g = aVar;
    }

    private void a(long j4, int i4) {
        this.f17070o = j4;
        int i5 = this.f17074s;
        if (100 * j4 >= ((long) i5) * this.f17067l && !this.f17075t && i4 != 4) {
            if (i5 != 100 || i4 == 5) {
                this.f17075t = true;
                af.b("CampaignDownLoadTask", "UpdateListener : state: " + i4 + " progress : " + j4);
                String q4 = q();
                if (TextUtils.isEmpty(q4)) {
                    com.mbridge.msdk.videocommon.listener.a aVar = this.f17062g;
                    if (aVar != null) {
                        aVar.a(this.f17068m);
                    }
                    com.mbridge.msdk.videocommon.listener.a aVar2 = this.f17063h;
                    if (aVar2 != null) {
                        aVar2.a(this.f17068m);
                    }
                } else {
                    com.mbridge.msdk.videocommon.listener.a aVar3 = this.f17062g;
                    if (aVar3 != null) {
                        aVar3.a("file is not effective " + q4, this.f17068m);
                    }
                    com.mbridge.msdk.videocommon.listener.a aVar4 = this.f17063h;
                    if (aVar4 != null) {
                        aVar4.a("file is not effective " + q4, this.f17068m);
                    }
                }
            } else {
                this.f17060e = 5;
                return;
            }
        }
        if (!this.f17056a && j4 > 0) {
            this.f17056a = true;
            if (this.f17076u == null) {
                this.f17076u = n.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
            }
            this.f17076u.a(this.f17068m, j4, this.f17060e);
        }
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f17061f;
        if (copyOnWriteArrayList != null) {
            Iterator<c> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    next.a(j4, i4);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i4, String str, String str2) {
        long j4 = 0;
        if (this.f17073r != 0) {
            j4 = System.currentTimeMillis() - this.f17073r;
        }
        com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n(this.f17066k, this.f17064i, i4, Long.toString(j4), this.f17067l, this.f17037A);
        nVar.e(this.f17064i.getId());
        nVar.m(this.f17064i.getVideoUrlEncode());
        nVar.h(str);
        nVar.f(this.f17064i.getRequestId());
        nVar.s(this.f17064i.getCurrentLocalRid());
        nVar.g(this.f17064i.getRequestIdNotice());
        nVar.c(this.f17065j);
        nVar.t(str2);
        nVar.a(CampaignEx.JSON_KEY_READY_RATE, String.valueOf(this.f17074s));
        nVar.a("url", this.f17064i.getVideoUrlEncode());
        nVar.e(4);
        DownloadRequest downloadRequest = this.f17079x;
        if (downloadRequest != null) {
            nVar.a("scenes", downloadRequest.get("scenes", ""));
            nVar.a("resumed_breakpoint", this.f17079x.get("resumed_breakpoint", ""));
        }
        int i5 = this.f17037A;
        if (i5 != 94 && i5 != 287) {
            o.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(nVar);
        }
    }

    /* access modifiers changed from: private */
    public void a(CampaignEx campaignEx, e eVar) {
        if (!this.f17051O && campaignEx != null && eVar != null) {
            this.f17051O = true;
            try {
                eVar.a("resource_type", 4);
                DownloadRequest downloadRequest = this.f17079x;
                if (downloadRequest != null) {
                    eVar.a("scenes", downloadRequest.get("scenes", "1"));
                    eVar.a("resumed_breakpoint", this.f17079x.get("resumed_breakpoint", "2"));
                } else {
                    eVar.a("scenes", "1");
                    eVar.a("resumed_breakpoint", "1");
                }
                eVar.a("url", campaignEx.getVideoUrlEncode());
                eVar.a(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(this.f17074s));
                d.a().a("m_download_start", campaignEx, eVar);
            } catch (Exception e5) {
                af.b("CampaignDownLoadTask", e5.getMessage());
            }
        }
    }

    static /* synthetic */ void a(a aVar, int i4, boolean z4, String str) {
        if (!aVar.f17052P) {
            try {
                aVar.f17052P = true;
                e eVar = new e();
                DownloadRequest downloadRequest = aVar.f17079x;
                if (downloadRequest != null) {
                    eVar.a("scenes", downloadRequest.get("scenes", ""));
                    eVar.a("url", aVar.f17068m);
                    eVar.a("resumed_breakpoint", aVar.f17079x.get("resumed_breakpoint", ""));
                    eVar.a("h3c", "");
                }
                eVar.a("resource_type", 4);
                eVar.a("file_size", Long.valueOf(aVar.f17067l));
                eVar.a(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(aVar.f17074s));
                eVar.a("result", Integer.valueOf(i4));
                eVar.a("reason", str);
                d.a().a("m_download_end", aVar.f17064i, eVar);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }
}
