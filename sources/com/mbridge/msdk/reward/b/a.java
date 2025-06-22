package com.mbridge.msdk.reward.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.reward.adapter.b;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class a {

    /* renamed from: N  reason: collision with root package name */
    private static ConcurrentHashMap<String, Integer> f15238N = new ConcurrentHashMap<>();

    /* renamed from: O  reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f15239O = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static String f15240b = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f15241d = null;

    /* renamed from: e  reason: collision with root package name */
    public static String f15242e = "";

    /* renamed from: f  reason: collision with root package name */
    public static ConcurrentHashMap<String, d> f15243f = new ConcurrentHashMap<>();

    /* renamed from: A  reason: collision with root package name */
    private int f15244A;

    /* renamed from: B  reason: collision with root package name */
    private int f15245B;

    /* renamed from: C  reason: collision with root package name */
    private int f15246C;
    /* access modifiers changed from: private */

    /* renamed from: D  reason: collision with root package name */
    public boolean f15247D = false;
    /* access modifiers changed from: private */

    /* renamed from: E  reason: collision with root package name */
    public boolean f15248E = false;

    /* renamed from: F  reason: collision with root package name */
    private boolean f15249F = false;

    /* renamed from: G  reason: collision with root package name */
    private boolean f15250G = false;

    /* renamed from: H  reason: collision with root package name */
    private boolean f15251H;
    /* access modifiers changed from: private */

    /* renamed from: I  reason: collision with root package name */
    public boolean f15252I = false;
    /* access modifiers changed from: private */

    /* renamed from: J  reason: collision with root package name */
    public ArrayList<Integer> f15253J = new ArrayList<>(7);
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public boolean f15254K = false;

    /* renamed from: L  reason: collision with root package name */
    private final Object f15255L = new Object();
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public List<CampaignEx> f15256M = new ArrayList();

    /* renamed from: P  reason: collision with root package name */
    private Queue<Integer> f15257P;

    /* renamed from: Q  reason: collision with root package name */
    private String f15258Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public g f15259R = null;

    /* renamed from: S  reason: collision with root package name */
    private volatile boolean f15260S = true;

    /* renamed from: T  reason: collision with root package name */
    private volatile boolean f15261T = false;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public volatile boolean f15262U = false;
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public volatile boolean f15263V = false;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public volatile boolean f15264W = false;
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public volatile boolean f15265X = false;
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public volatile boolean f15266Y = false;
    /* access modifiers changed from: private */

    /* renamed from: Z  reason: collision with root package name */
    public CopyOnWriteArrayList<CampaignEx> f15267Z;

    /* renamed from: a  reason: collision with root package name */
    b f15268a;
    /* access modifiers changed from: private */
    public List<CampaignEx> aa;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15269c = false;

    /* renamed from: g  reason: collision with root package name */
    volatile boolean f15270g = false;

    /* renamed from: h  reason: collision with root package name */
    volatile boolean f15271h = false;

    /* renamed from: i  reason: collision with root package name */
    volatile boolean f15272i = false;

    /* renamed from: j  reason: collision with root package name */
    volatile boolean f15273j = false;

    /* renamed from: k  reason: collision with root package name */
    volatile boolean f15274k = false;

    /* renamed from: l  reason: collision with root package name */
    private Context f15275l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public com.mbridge.msdk.reward.adapter.c f15276m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public com.mbridge.msdk.videocommon.d.c f15277n;

    /* renamed from: o  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.a f15278o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public volatile InterVideoOutListener f15279p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public volatile c f15280q;

    /* renamed from: r  reason: collision with root package name */
    private String f15281r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public String f15282s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public MBridgeIds f15283t;

    /* renamed from: u  reason: collision with root package name */
    private String f15284u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public volatile String f15285v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public String f15286w;

    /* renamed from: x  reason: collision with root package name */
    private int f15287x = 0;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public Handler f15288y = new b(this);
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public int f15289z = 2;

    /* renamed from: com.mbridge.msdk.reward.b.a$a  reason: collision with other inner class name */
    public class C0200a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final com.mbridge.msdk.reward.adapter.c f15330b;

        /* renamed from: c  reason: collision with root package name */
        private final int f15331c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f15332d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f15333e = false;

        /* renamed from: f  reason: collision with root package name */
        private int f15334f;

        /* renamed from: g  reason: collision with root package name */
        private String f15335g;

        /* renamed from: h  reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.report.d.c f15336h;

        public C0200a(com.mbridge.msdk.reward.adapter.c cVar, int i4, boolean z4, String str, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
            this.f15330b = cVar;
            this.f15331c = i4;
            this.f15332d = z4;
            if (cVar != null) {
                cVar.e(false);
            }
            this.f15335g = str;
            this.f15336h = cVar2;
        }

        public final void a() {
            this.f15333e = true;
        }

        public final void run() {
            if (!this.f15333e) {
                com.mbridge.msdk.reward.adapter.c cVar = this.f15330b;
                if (cVar != null) {
                    cVar.e(true);
                }
                af.b("RewardVideoController", "adSource=" + this.f15331c + " CommonCancelTimeTask mIsDevCall：" + this.f15332d);
                a.this.a(com.mbridge.msdk.foundation.c.a.b(880023, "v3 is timeout"), this.f15336h);
            }
        }

        public final void a(int i4) {
            this.f15334f = i4;
        }
    }

    public class b implements com.mbridge.msdk.reward.adapter.a {

        /* renamed from: b  reason: collision with root package name */
        private com.mbridge.msdk.reward.adapter.c f15338b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f15339c;

        /* renamed from: d  reason: collision with root package name */
        private C0200a f15340d;

        public b(com.mbridge.msdk.reward.adapter.c cVar, boolean z4) {
            this.f15338b = cVar;
            this.f15339c = z4;
        }

        public final void a(C0200a aVar) {
            this.f15340d = aVar;
        }

        public final void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            C0200a aVar = this.f15340d;
            if (aVar != null) {
                aVar.a();
                a.this.f15288y.removeCallbacks(this.f15340d);
            }
            if (a.this.f15280q != null) {
                c.b(a.this.f15280q, a.this.f15285v, a.this.f15282s, cVar);
            }
        }

        public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            C0200a aVar = this.f15340d;
            if (aVar != null) {
                aVar.a();
                a.this.f15288y.removeCallbacks(this.f15340d);
            }
            a.this.a(list);
            if (a.this.f15280q != null) {
                a.this.f15280q.a(a.this.f15285v, a.this.f15282s, cVar);
            }
        }

        public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            C0200a aVar = this.f15340d;
            if (aVar != null) {
                aVar.a();
                a.this.f15288y.removeCallbacks(this.f15340d);
            }
            com.mbridge.msdk.reward.adapter.c cVar2 = this.f15338b;
            if (cVar2 != null) {
                cVar2.a((com.mbridge.msdk.reward.adapter.a) null);
                this.f15338b = null;
            }
            a.this.a(list);
            if (a.this.f15280q != null) {
                a.this.f15280q.a(bVar, cVar);
            }
        }
    }

    public final class c {

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<InterVideoOutListener> f15342b;

        /* renamed from: c  reason: collision with root package name */
        private volatile AtomicInteger f15343c;

        /* renamed from: d  reason: collision with root package name */
        private Handler f15344d;

        /* renamed from: e  reason: collision with root package name */
        private String f15345e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f15346f;

        public final void a(String str, String str2, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            Handler handler = this.f15344d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f15342b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.f15343c.get() != 2 && this.f15344d != null) {
                this.f15343c.set(2);
                if (!a.this.f15263V) {
                    boolean unused = a.this.f15263V = true;
                    if (cVar == null) {
                        cVar = new com.mbridge.msdk.foundation.same.report.d.c();
                    }
                    cVar.b((List<CampaignEx>) a.this.f15256M);
                    a.a(a.this, "2000048", cVar, interVideoOutListener);
                    if (interVideoOutListener != null) {
                        Message obtain = Message.obtain();
                        Bundle bundle = new Bundle();
                        bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                        bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                        bundle.putString("metrics_data_lrid", cVar.f());
                        obtain.setData(bundle);
                        obtain.obj = str2;
                        obtain.what = 9;
                        this.f15344d.sendMessage(obtain);
                    }
                }
            }
        }

        private c(InterVideoOutListener interVideoOutListener, Handler handler, String str) {
            this.f15342b = new WeakReference<>(interVideoOutListener);
            this.f15343c = new AtomicInteger(0);
            this.f15344d = handler;
            this.f15345e = str;
        }

        public final void b(String str, String str2, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            Handler handler = this.f15344d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f15342b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.f15343c.get() != 2 && this.f15344d != null) {
                if (this.f15343c.get() == 1) {
                    this.f15343c.set(3);
                }
                if (!a.this.f15263V) {
                    boolean unused = a.this.f15263V = true;
                    if (cVar == null) {
                        cVar = new com.mbridge.msdk.foundation.same.report.d.c();
                    }
                    cVar.a(true);
                    cVar.b((List<CampaignEx>) a.this.f15256M);
                    a.a(a.this, "2000048", cVar, interVideoOutListener);
                    if (interVideoOutListener != null) {
                        Message obtain = Message.obtain();
                        Bundle bundle = new Bundle();
                        bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                        bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                        bundle.putSerializable("metrics_data_lrid", cVar.f());
                        obtain.setData(bundle);
                        obtain.obj = str2;
                        obtain.what = 9;
                        this.f15344d.sendMessage(obtain);
                    }
                    if (a.this.f15264W) {
                        this.f15343c.set(2);
                    }
                }
            }
        }

        public final void a(com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            String str;
            com.mbridge.msdk.foundation.same.report.d.c cVar2;
            if (bVar == null || cVar == null) {
                str = "";
            } else {
                str = bVar.b();
                cVar.a(bVar);
            }
            InterVideoOutListener interVideoOutListener = null;
            if (a.this.f15276m != null) {
                a.this.f15276m.a((com.mbridge.msdk.reward.adapter.a) a.this.f15268a);
                CopyOnWriteArrayList<CampaignEx> e5 = a.this.f15276m.e();
                CampaignEx campaignEx = (a.this.f15256M == null || a.this.f15256M.size() == 0) ? null : (CampaignEx) a.this.f15256M.get(0);
                if (campaignEx == null) {
                    campaignEx = (e5 == null || e5.size() == 0) ? null : e5.get(0);
                }
                CampaignEx campaignEx2 = campaignEx;
                if (!a.this.f15248E || ((campaignEx2 != null && !TextUtils.isEmpty(campaignEx2.getNLRid())) || !(e5 == null || e5.size() == 0))) {
                    cVar2 = cVar;
                } else {
                    cVar2 = cVar;
                    if (a.this.f15276m.a(campaignEx2, true, bVar, 2, cVar2)) {
                        return;
                    }
                }
                a.this.f15276m.a((com.mbridge.msdk.reward.adapter.a) null);
            } else {
                cVar2 = cVar;
            }
            Handler handler = this.f15344d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f15342b;
            if (weakReference != null) {
                interVideoOutListener = weakReference.get();
            }
            if (this.f15343c.get() != 2 && this.f15344d != null) {
                boolean unused = a.this.f15264W = true;
                if (!a.this.f15266Y || str.contains("resource load timeout")) {
                    boolean unused2 = a.this.f15265X = true;
                }
                if (a.this.f15263V) {
                    this.f15343c.set(2);
                }
                if (a.this.f15264W && a.this.f15265X && !a.this.f15263V) {
                    this.f15343c.set(2);
                    a.a(a.this, "2000047", cVar2, interVideoOutListener);
                    if (interVideoOutListener != null) {
                        Message obtain = Message.obtain();
                        obtain.obj = str;
                        obtain.what = 16;
                        if (cVar2 != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("metrics_data_lrid", cVar2.f());
                            obtain.setData(bundle);
                        }
                        this.f15344d.sendMessage(obtain);
                    }
                }
            }
        }

        static /* synthetic */ void b(c cVar, String str, String str2, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
            WeakReference<InterVideoOutListener> weakReference = cVar.f15342b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if ((cVar.f15343c.get() == 1 || cVar.f15343c.get() == 3) && cVar.f15344d != null && !a.this.f15262U) {
                boolean unused = a.this.f15262U = true;
                a.a(a.this, "2000127", cVar2, interVideoOutListener);
                if (interVideoOutListener != null) {
                    Message obtain = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, false);
                    if (cVar2 != null) {
                        bundle.putString("metrics_data_lrid", cVar2.f());
                    }
                    obtain.setData(bundle);
                    obtain.obj = str2;
                    obtain.what = 17;
                    cVar.f15344d.sendMessage(obtain);
                    if (ah.a().a("l_s_i_l_v_s", false)) {
                        cVar.a(str, str2, cVar2);
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            WeakReference<InterVideoOutListener> weakReference = this.f15342b;
            a.a(a.this, "2000047", cVar, weakReference != null ? weakReference.get() : null);
            if (this.f15344d != null) {
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 18;
                if (cVar != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("metrics_data_lrid", cVar.f());
                    obtain.setData(bundle);
                }
                this.f15344d.sendMessage(obtain);
            }
        }

        public final void a(boolean z4) {
            this.f15346f = z4;
        }

        static /* synthetic */ void a(c cVar, String str, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
            cVar.f15343c.set(2);
            cVar.a(str, cVar2);
        }

        static /* synthetic */ void a(c cVar, String str, String str2, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
            WeakReference<InterVideoOutListener> weakReference = cVar.f15342b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (cVar.f15344d != null && !a.this.f15262U) {
                boolean unused = a.this.f15262U = true;
                a.a(a.this, "2000127", cVar2, interVideoOutListener);
                if (interVideoOutListener != null) {
                    Message obtain = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, true);
                    if (cVar2 != null) {
                        bundle.putString("metrics_data_lrid", cVar2.f());
                    }
                    obtain.setData(bundle);
                    obtain.obj = str2;
                    obtain.what = 17;
                    cVar.f15344d.sendMessage(obtain);
                    if (ah.a().a("l_s_i_l_v_s", false)) {
                        cVar.b(str, str2, cVar2);
                    }
                }
            }
        }

        static /* synthetic */ void a(c cVar, com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
            String str;
            WeakReference<InterVideoOutListener> weakReference = cVar.f15342b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (cVar.f15343c.get() != 2 && cVar.f15344d != null) {
                boolean unused = a.this.f15265X = true;
                if (bVar != null) {
                    str = bVar.b();
                } else {
                    str = "";
                }
                if (str.contains("resource load timeout")) {
                    boolean unused2 = a.this.f15264W = true;
                }
                if (a.this.f15265X && a.this.f15264W && !a.this.f15263V) {
                    cVar.f15343c.set(2);
                    if (interVideoOutListener != null) {
                        Message obtain = Message.obtain();
                        obtain.obj = str;
                        obtain.what = 16;
                        if (cVar2 != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("metrics_data_lrid", cVar2.f());
                            obtain.setData(bundle);
                        }
                        cVar.f15344d.sendMessage(obtain);
                    }
                    if (cVar2 == null) {
                        cVar2 = new com.mbridge.msdk.foundation.same.report.d.c();
                    }
                    cVar2.a(true);
                    a.a(a.this, "2000047", cVar2, interVideoOutListener);
                }
            }
        }
    }

    private final class d extends com.mbridge.msdk.video.bt.module.b.b {
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public a f15348d;

        /* renamed from: e  reason: collision with root package name */
        private Handler f15349e;

        /* renamed from: f  reason: collision with root package name */
        private int f15350f;

        public final void b(String str, String str2) {
            try {
                a aVar = this.f15348d;
                if (aVar != null && aVar.f15279p != null) {
                    try {
                        this.f15348d.f15279p.onEndcardShow(a.this.f15283t);
                        com.mbridge.msdk.foundation.d.b a5 = com.mbridge.msdk.foundation.d.b.a();
                        a5.a(str2 + "_" + 2, 2);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoController", e5.getMessage());
                        }
                    }
                    this.f15350f = 6;
                }
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e6.getMessage());
                }
            }
        }

        private d(a aVar, Handler handler) {
            this.f15350f = 0;
            this.f15348d = aVar;
            this.f15349e = handler;
        }

        public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
            String str;
            a.this.f15269c = false;
            try {
                com.mbridge.msdk.reward.a.a aVar = new com.mbridge.msdk.reward.a.a(a.this.f15282s, a.this.f15247D);
                a aVar2 = this.f15348d;
                if (aVar2 == null || aVar2.f15276m == null) {
                    str = "";
                } else {
                    str = this.f15348d.f15276m.f15156c;
                }
                aVar.a(cVar.f(), str, 3, a.f15240b);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e5.getMessage());
                }
            }
            try {
                a aVar3 = this.f15348d;
                if (aVar3 != null) {
                    boolean unused = aVar3.f15254K = true;
                    if (this.f15348d.f15276m != null) {
                        this.f15348d.f15276m.f15156c = "";
                    }
                    com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() {
                        public final void run() {
                            try {
                                if (a.this.f15259R == null) {
                                    g unused = a.this.f15259R = g.a(com.mbridge.msdk.foundation.controller.c.m().c());
                                }
                                h a5 = h.a((f) a.this.f15259R);
                                if (a5 != null) {
                                    a5.a(a.this.f15282s);
                                }
                            } catch (Throwable unused2) {
                                af.b("RewardVideoController", "can't find DailyPlayCapDao");
                            }
                        }
                    });
                    if (a.this.f15248E) {
                        a.this.c();
                    }
                    a aVar4 = a.this;
                    aVar4.a("2000130", cVar, aVar4.f15279p, "");
                    this.f15958b = true;
                    if (this.f15348d.f15279p != null) {
                        this.f15348d.f15279p.onAdShow(a.this.f15283t);
                        this.f15350f = 2;
                    }
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", th.getMessage());
                }
            }
        }

        public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, boolean z4, com.mbridge.msdk.videocommon.b.c cVar2) {
            try {
                a aVar = this.f15348d;
                if (!(aVar == null || aVar.f15279p == null)) {
                    if (cVar2 == null) {
                        cVar2 = com.mbridge.msdk.videocommon.b.c.b(this.f15348d.f15286w);
                    }
                    if (a.this.f15248E) {
                        a.this.c();
                        a.this.b();
                        com.mbridge.msdk.foundation.same.a.b.d(a.this.f15282s, a.this.a());
                    }
                    this.f15348d.f15279p.onAdClose(a.this.f15283t, new RewardInfo(z4, cVar2.a(), String.valueOf(cVar2.b())));
                    this.f15350f = 7;
                    boolean unused = this.f15348d.f15254K = false;
                    a.this.f15253J.clear();
                    this.f15348d = null;
                }
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000152", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e5.getMessage());
                }
            }
        }

        public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, String str) {
            try {
                a aVar = a.this;
                aVar.f15269c = false;
                if (this.f15348d != null) {
                    if (aVar.f15248E) {
                        a.this.c();
                    }
                    boolean unused = this.f15348d.f15254K = false;
                    a.this.a("2000131", cVar, this.f15348d.f15279p, str);
                    this.f15959c = true;
                    if (this.f15348d.f15279p != null) {
                        try {
                            this.f15348d.f15279p.onShowFail(cVar, a.this.f15283t, str);
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("RewardVideoController", e5.getMessage());
                            }
                        }
                        this.f15350f = 4;
                    }
                }
            } catch (Exception e6) {
                this.f15350f = 0;
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e6.getMessage());
                }
            }
        }

        public final void a(boolean z4, String str, String str2) {
            try {
                a aVar = this.f15348d;
                if (aVar != null && aVar.f15279p != null) {
                    if (a.this.f15248E) {
                        a.this.c();
                    }
                    boolean unused = this.f15348d.f15254K = false;
                    try {
                        this.f15348d.f15279p.onVideoAdClicked(z4, a.this.f15283t);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoController", e5.getMessage());
                        }
                    }
                }
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e6.getMessage());
                }
            }
        }

        public final void a(String str, String str2) {
            try {
                a aVar = this.f15348d;
                if (aVar != null && aVar.f15279p != null) {
                    try {
                        this.f15348d.f15279p.onVideoComplete(a.this.f15283t);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoController", e5.getMessage());
                        }
                    }
                    this.f15350f = 5;
                }
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e6.getMessage());
                }
            }
        }

        public final void a(boolean z4, int i4) {
            try {
                a aVar = this.f15348d;
                if (aVar != null && aVar.f15279p != null) {
                    try {
                        this.f15348d.f15279p.onAdCloseWithIVReward(a.this.f15283t, new RewardInfo(z4, i4));
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoController", e5.getMessage());
                        }
                    }
                }
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e6.getMessage());
                }
            }
        }

        public final void a(int i4, String str, String str2) {
            this.f15350f = i4;
            a aVar = this.f15348d;
            if (aVar != null && !aVar.f15248E && !this.f15348d.f15247D && this.f15348d.f15277n != null && this.f15348d.f15277n.s(this.f15350f) && this.f15348d.f15280q != null && this.f15348d.f15280q.f15343c.get() != 1 && this.f15348d.f15280q.f15343c.get() != 3 && !a.this.f15253J.contains(Integer.valueOf(this.f15350f))) {
                a.this.f15253J.add(Integer.valueOf(this.f15350f));
                int A4 = this.f15348d.f15277n.A() * 1000;
                if (this.f15350f == 4) {
                    A4 = PathInterpolatorCompat.MAX_NUM_POINTS;
                }
                Handler handler = this.f15349e;
                if (handler != null) {
                    handler.removeMessages(1001001);
                    this.f15349e.sendEmptyMessageDelayed(1001001, (long) A4);
                    return;
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        int i4;
                        if (d.this.f15348d != null) {
                            com.mbridge.msdk.foundation.same.report.d.d a5 = com.mbridge.msdk.foundation.same.report.d.d.a();
                            if (a.this.f15247D) {
                                i4 = 287;
                            } else {
                                i4 = 94;
                            }
                            d.this.f15348d.a(false, a5.a(0, i4, a.this.f15282s, true, 1));
                        }
                    }
                }, (long) A4);
            }
        }
    }

    public static void insertExcludeId(String str, CampaignEx campaignEx) {
        if (!TextUtils.isEmpty(str) && campaignEx != null && com.mbridge.msdk.foundation.controller.c.m().c() != null) {
            i a5 = i.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
            com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
            fVar.a(System.currentTimeMillis());
            fVar.b(str);
            fVar.a(campaignEx.getId());
            a5.a(fVar);
        }
    }

    private void p() {
        e.a((f) g.a(this.f15275l)).a(this.f15282s);
    }

    private void q() {
        try {
            List<CampaignEx> b5 = e.a((f) g.a(this.f15275l)).b(this.f15282s);
            if (b5 != null && b5.size() > 0) {
                for (CampaignEx next : b5) {
                    if (!TextUtils.isEmpty(next.getCMPTEntryUrl())) {
                        com.mbridge.msdk.videocommon.a.b(this.f15282s + "_" + next.getRequestId() + "_" + next.getCMPTEntryUrl());
                        if (next.getRewardTemplateMode() != null && !TextUtils.isEmpty(next.getRewardTemplateMode().e())) {
                            com.mbridge.msdk.videocommon.a.b(this.f15282s + "_" + next.getId() + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e());
                        }
                    } else {
                        com.mbridge.msdk.videocommon.a.b(next.getAdType(), next);
                    }
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoController", e5.getMessage());
            }
        }
    }

    private void r() {
        com.mbridge.msdk.reward.adapter.c cVar = new com.mbridge.msdk.reward.adapter.c(this.f15275l, this.f15285v, this.f15282s);
        this.f15276m = cVar;
        cVar.b(this.f15247D);
        this.f15276m.c(this.f15248E);
        if (this.f15247D) {
            this.f15276m.a(this.f15244A, this.f15245B, this.f15246C);
        }
        this.f15276m.a(this.f15277n);
    }

    private boolean s() {
        try {
            if (this.f15259R == null) {
                this.f15259R = g.a(com.mbridge.msdk.foundation.controller.c.m().c());
            }
            h a5 = h.a((f) this.f15259R);
            if (this.f15277n == null) {
                this.f15277n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f15282s, this.f15247D);
            }
            int d5 = this.f15277n.d();
            if (a5 == null || !a5.a(this.f15282s, d5)) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            af.b("RewardVideoController", "cap check error");
            return false;
        }
    }

    public final List<CampaignEx> f() {
        return this.aa;
    }

    public final com.mbridge.msdk.reward.adapter.c g() {
        return this.f15276m;
    }

    public final boolean h() {
        return this.f15251H;
    }

    public final String i() {
        return this.f15282s;
    }

    public final String j() {
        return this.f15285v;
    }

    public final c k() {
        return this.f15280q;
    }

    public final InterVideoOutListener l() {
        return this.f15279p;
    }

    public final boolean m() {
        return this.f15248E;
    }

    public final MBridgeIds n() {
        return this.f15283t;
    }

    public final boolean o() {
        return this.f15247D;
    }

    private boolean e(boolean z4) {
        if (z4) {
            d("is_ready_start", "");
        }
        if (this.f15276m == null) {
            r();
        }
        List<com.mbridge.msdk.foundation.entity.c> a5 = com.mbridge.msdk.videocommon.a.a.a().a(this.f15282s);
        boolean z5 = false;
        if (a5 == null || a5.size() <= 0) {
            if (z4) {
                d("is_ready_ctir_" + false, "no effective campaign list");
            }
            return false;
        }
        String b5 = com.mbridge.msdk.foundation.same.a.b.b(this.f15282s);
        if (!TextUtils.isEmpty(b5)) {
            z5 = a(a5, b5);
        }
        if (z4) {
            d("is_ready_ctir_" + z5, "");
        }
        if (!z5) {
            for (com.mbridge.msdk.foundation.entity.c next : a5) {
                if (next != null) {
                    this.f15276m.a(next.a());
                    this.f15276m.f15157d = next.d();
                    if (this.f15276m.d(z4)) {
                        return true;
                    }
                }
            }
        }
        return z5;
    }

    public final void b(boolean z4) {
        this.f15248E = z4;
    }

    public final void c(boolean z4) {
        this.f15252I = z4;
    }

    public final boolean d(boolean z4) {
        try {
            if (!s()) {
                if (this.f15248E) {
                    return e(z4);
                }
                if (this.f15276m == null) {
                    r();
                }
                com.mbridge.msdk.reward.adapter.c cVar = this.f15276m;
                if (cVar != null) {
                    return cVar.b();
                }
                return false;
            } else if (!z4) {
                return false;
            } else {
                d("is_ready_start", "over cap check error");
                return false;
            }
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            af.b("RewardVideoController", e5.getMessage());
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            af.b("RewardVideoController", th.getMessage());
            return false;
        }
    }

    public final void b() {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (this.f15254K && (concurrentHashMap = f15239O) != null && !concurrentHashMap.containsKey(a())) {
            f15239O.remove(a());
        }
    }

    public final void c() {
        String str = "";
        try {
            MBridgeIds mBridgeIds = this.f15283t;
            if (mBridgeIds == null) {
                return;
            }
            if (!this.f15254K) {
                mBridgeIds.setBidToken(str);
                return;
            }
            String a5 = a();
            if (!TextUtils.isEmpty(a5)) {
                ConcurrentHashMap<String, String> concurrentHashMap = f15239O;
                if (concurrentHashMap != null && concurrentHashMap.containsKey(a5) && !TextUtils.isEmpty(f15239O.get(a5))) {
                    str = f15239O.get(a5);
                }
                this.f15283t.setBidToken(str);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public final void a(boolean z4) {
        this.f15247D = z4;
        if (z4) {
            this.f15289z = com.mbridge.msdk.foundation.same.a.f13126X;
        } else {
            this.f15289z = com.mbridge.msdk.foundation.same.a.f13125W;
        }
    }

    public final void b(String str, String str2) {
        try {
            this.f15275l = com.mbridge.msdk.foundation.controller.c.m().c();
            this.f15282s = str2;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.f15285v = str;
            this.f15283t = new MBridgeIds(this.f15285v, this.f15282s);
            this.f15278o = com.mbridge.msdk.videocommon.d.b.a().b();
            com.mbridge.msdk.foundation.same.f.a.b().execute(new c(this.f15275l, this.f15282s));
            if (this.f15259R == null) {
                this.f15259R = g.a(com.mbridge.msdk.foundation.controller.c.m().c());
            }
        } catch (Throwable th) {
            af.b("RewardVideoController", th.getMessage(), th);
        }
    }

    public final void a(int i4) {
        this.f15289z = i4;
    }

    public final String a() {
        com.mbridge.msdk.reward.adapter.c cVar = this.f15276m;
        if (cVar != null) {
            return cVar.a(this.f15254K);
        }
        return "";
    }

    public final void a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            Context context = this.f15275l;
            an.b(context, "MBridge_ConfirmTitle" + this.f15282s, str.trim());
        }
        if (!TextUtils.isEmpty(str2)) {
            Context context2 = this.f15275l;
            an.b(context2, "MBridge_ConfirmContent" + this.f15282s, str2.trim());
        }
        if (!TextUtils.isEmpty(str4)) {
            Context context3 = this.f15275l;
            an.b(context3, "MBridge_CancelText" + this.f15282s, str4.trim());
        }
        if (!TextUtils.isEmpty(str3)) {
            Context context4 = this.f15275l;
            an.b(context4, "MBridge_ConfirmText" + this.f15282s, str3.trim());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0106  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.foundation.same.report.d.c b(boolean r7, java.lang.String r8, com.mbridge.msdk.foundation.same.report.d.e r9) {
        /*
            r6 = this;
            java.lang.String r0 = "hb"
            java.lang.String r1 = "adtp"
            com.mbridge.msdk.foundation.same.report.d.c r2 = new com.mbridge.msdk.foundation.same.report.d.c
            r2.<init>()
            if (r7 == 0) goto L_0x0080
            android.content.Context r3 = r6.f15275l     // Catch:{ Exception -> 0x003d }
            com.mbridge.msdk.foundation.db.g r3 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r3)     // Catch:{ Exception -> 0x003d }
            com.mbridge.msdk.foundation.db.e r3 = com.mbridge.msdk.foundation.db.e.a((com.mbridge.msdk.foundation.db.f) r3)     // Catch:{ Exception -> 0x003d }
            if (r3 == 0) goto L_0x003f
            java.lang.String r4 = r6.f15282s     // Catch:{ Exception -> 0x003d }
            java.util.List r3 = r3.e(r4)     // Catch:{ Exception -> 0x003d }
            if (r3 == 0) goto L_0x003f
            int r4 = r3.size()     // Catch:{ Exception -> 0x003d }
            if (r4 <= 0) goto L_0x003f
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x003d }
        L_0x0029:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x003d }
            if (r4 == 0) goto L_0x003f
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x003d }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x003d }
            com.mbridge.msdk.foundation.same.report.d.d r5 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x003d }
            r5.b((java.lang.String) r4)     // Catch:{ Exception -> 0x003d }
            goto L_0x0029
        L_0x003d:
            r3 = move-exception
            goto L_0x0075
        L_0x003f:
            com.mbridge.msdk.foundation.same.report.d.d r3 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x003d }
            java.util.LinkedHashMap r3 = r3.b()     // Catch:{ Exception -> 0x003d }
            if (r3 == 0) goto L_0x0080
            int r4 = r3.size()     // Catch:{ Exception -> 0x003d }
            if (r4 <= 0) goto L_0x0080
            java.util.Set r3 = r3.entrySet()     // Catch:{ Exception -> 0x003d }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x003d }
        L_0x0057:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x003d }
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x003d }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ Exception -> 0x003d }
            if (r4 == 0) goto L_0x0057
            java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x003d }
            com.mbridge.msdk.foundation.same.report.d.c r4 = (com.mbridge.msdk.foundation.same.report.d.c) r4     // Catch:{ Exception -> 0x003d }
            boolean r4 = r4.s()     // Catch:{ Exception -> 0x003d }
            if (r4 == 0) goto L_0x0057
            r3.remove()     // Catch:{ Exception -> 0x003d }
            goto L_0x0057
        L_0x0075:
            boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x007d }
            if (r4 == 0) goto L_0x0080
            r3.printStackTrace()     // Catch:{ Exception -> 0x007d }
            goto L_0x0080
        L_0x007d:
            r7 = move-exception
            goto L_0x0102
        L_0x0080:
            boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x007d }
            if (r3 == 0) goto L_0x008f
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.ak.d()     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r3)     // Catch:{ Exception -> 0x007d }
            goto L_0x0093
        L_0x008f:
            java.lang.String r3 = r6.a((java.lang.String) r8)     // Catch:{ Exception -> 0x007d }
        L_0x0093:
            com.mbridge.msdk.foundation.same.report.d.d r4 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = ""
            com.mbridge.msdk.foundation.same.report.d.c r2 = r4.a((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x007d }
            if (r2 != 0) goto L_0x00b8
            com.mbridge.msdk.foundation.same.report.d.c r4 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x007d }
            r4.<init>()     // Catch:{ Exception -> 0x007d }
            com.mbridge.msdk.foundation.same.report.d.d r2 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x00b5 }
            java.util.LinkedHashMap r2 = r2.b()     // Catch:{ Exception -> 0x00b5 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x00b5 }
            r2 = 1
            r4.d((boolean) r2)     // Catch:{ Exception -> 0x00b5 }
            r2 = r4
            goto L_0x00b8
        L_0x00b5:
            r7 = move-exception
            r2 = r4
            goto L_0x0102
        L_0x00b8:
            r2.c((java.lang.String) r3)     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = r6.f15282s     // Catch:{ Exception -> 0x007d }
            r2.d((java.lang.String) r3)     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = "1"
            if (r9 == 0) goto L_0x00ef
            boolean r4 = r9.a((java.lang.String) r1)     // Catch:{ Exception -> 0x007d }
            if (r4 == 0) goto L_0x00d7
            java.lang.Object r1 = r9.b(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x007d }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x007d }
            r2.b((int) r1)     // Catch:{ Exception -> 0x007d }
        L_0x00d7:
            boolean r1 = r9.a((java.lang.String) r0)     // Catch:{ Exception -> 0x007d }
            if (r1 == 0) goto L_0x00ef
            java.lang.Object r9 = r9.b(r0)     // Catch:{ Exception -> 0x007d }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x007d }
            r2.i(r9)     // Catch:{ Exception -> 0x007d }
            boolean r9 = r9.equals(r3)     // Catch:{ Exception -> 0x007d }
            if (r9 == 0) goto L_0x00ef
            r2.e((java.lang.String) r8)     // Catch:{ Exception -> 0x007d }
        L_0x00ef:
            if (r7 == 0) goto L_0x00f3
            java.lang.String r3 = "2"
        L_0x00f3:
            r2.b((java.lang.String) r3)     // Catch:{ Exception -> 0x007d }
            if (r7 == 0) goto L_0x010f
            com.mbridge.msdk.reward.c.a.a r7 = com.mbridge.msdk.reward.c.a.a.a()     // Catch:{ Exception -> 0x007d }
            java.lang.String r8 = "2000123"
            r7.a(r8, r2)     // Catch:{ Exception -> 0x007d }
            goto L_0x010f
        L_0x0102:
            boolean r8 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r8 == 0) goto L_0x010f
            java.lang.String r8 = "RewardVideoController"
            java.lang.String r7 = r7.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r8, r7)
        L_0x010f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.b(boolean, java.lang.String, com.mbridge.msdk.foundation.same.report.d.e):com.mbridge.msdk.foundation.same.report.d.c");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            com.mbridge.msdk.reward.adapter.c r0 = r4.f15276m     // Catch:{ Exception -> 0x000f }
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.a()     // Catch:{ Exception -> 0x000f }
            boolean r0 = r5.equals(r0)     // Catch:{ Exception -> 0x000f }
            if (r0 != 0) goto L_0x0028
            goto L_0x0011
        L_0x000f:
            r0 = move-exception
            goto L_0x0037
        L_0x0011:
            com.mbridge.msdk.reward.adapter.c r0 = new com.mbridge.msdk.reward.adapter.c     // Catch:{ Exception -> 0x000f }
            android.content.Context r1 = r4.f15275l     // Catch:{ Exception -> 0x000f }
            java.lang.String r2 = r4.f15285v     // Catch:{ Exception -> 0x000f }
            r0.<init>(r1, r2, r5)     // Catch:{ Exception -> 0x000f }
            r4.f15276m = r0     // Catch:{ Exception -> 0x000f }
            boolean r1 = r4.f15247D     // Catch:{ Exception -> 0x000f }
            r0.b((boolean) r1)     // Catch:{ Exception -> 0x000f }
            com.mbridge.msdk.reward.adapter.c r0 = r4.f15276m     // Catch:{ Exception -> 0x000f }
            boolean r1 = r4.f15248E     // Catch:{ Exception -> 0x000f }
            r0.c((boolean) r1)     // Catch:{ Exception -> 0x000f }
        L_0x0028:
            com.mbridge.msdk.reward.adapter.c r0 = r4.f15276m     // Catch:{ Exception -> 0x000f }
            int r1 = r4.f15289z     // Catch:{ Exception -> 0x000f }
            r0.a((int) r1)     // Catch:{ Exception -> 0x000f }
            com.mbridge.msdk.reward.adapter.c r0 = r4.f15276m     // Catch:{ Exception -> 0x000f }
            com.mbridge.msdk.videocommon.d.c r1 = r4.f15277n     // Catch:{ Exception -> 0x000f }
            r0.a((com.mbridge.msdk.videocommon.d.c) r1)     // Catch:{ Exception -> 0x000f }
            goto L_0x0044
        L_0x0037:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x0044
            java.lang.String r1 = "RewardVideoController"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r0)
        L_0x0044:
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()
            boolean r1 = r4.f15248E
            r2 = 1
            java.util.List r0 = r0.a((java.lang.String) r5, (int) r2, (boolean) r1)
            com.mbridge.msdk.videocommon.a.a r1 = com.mbridge.msdk.videocommon.a.a.a()
            boolean r3 = r4.f15248E
            java.util.List r1 = r1.b(r5, r2, r3)
            r4.aa = r1
            if (r0 == 0) goto L_0x0098
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x0098
            com.mbridge.msdk.videocommon.a.a r1 = com.mbridge.msdk.videocommon.a.a.a()
            r1.a((java.lang.String) r5, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r0, (java.lang.String) r6)
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r4.f15267Z
            if (r5 != 0) goto L_0x0076
            java.util.concurrent.CopyOnWriteArrayList r5 = new java.util.concurrent.CopyOnWriteArrayList
            r5.<init>()
            r4.f15267Z = r5
            goto L_0x0079
        L_0x0076:
            r5.clear()
        L_0x0079:
            java.util.Iterator r5 = r0.iterator()
        L_0x007d:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0092
            java.lang.Object r0 = r5.next()
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            r0.setLocalRequestId(r6)
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r4.f15267Z
            r1.add(r0)
            goto L_0x007d
        L_0x0092:
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r4.f15267Z
            r4.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r5)
            return r2
        L_0x0098:
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r4.f15267Z
            if (r5 == 0) goto L_0x009f
            r5.clear()
        L_0x009f:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.c(java.lang.String, java.lang.String):boolean");
    }

    public final String d() {
        com.mbridge.msdk.reward.adapter.c cVar = this.f15276m;
        if (cVar != null) {
            return cVar.f();
        }
        return "";
    }

    private void d(String str, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            cVar.d(this.f15282s);
            cVar.b(this.f15247D ? 287 : 94);
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a("event_name", str);
            eVar.a("reason", str2);
            cVar.a("m_temp_is_ready_check", eVar);
            com.mbridge.msdk.reward.c.a.a.a().a("m_temp_is_ready_check", cVar);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public final CopyOnWriteArrayList<CampaignEx> e() {
        return this.f15267Z;
    }

    public final void a(int i4, int i5, int i6) {
        this.f15244A = i4;
        this.f15245B = i5;
        if (i5 == com.mbridge.msdk.foundation.same.a.f13113K) {
            this.f15246C = i6 < 0 ? 5 : i6;
        }
        if (i5 == com.mbridge.msdk.foundation.same.a.f13112J) {
            this.f15246C = i6 < 0 ? 80 : i6;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            int i7 = 1;
            jSONObject.put("ivRewardEnable", 1);
            jSONObject.put("ivRewardMode", i4 == com.mbridge.msdk.foundation.same.a.f13110H ? 0 : 1);
            if (i5 == com.mbridge.msdk.foundation.same.a.f13112J) {
                i7 = 0;
            }
            jSONObject.put("ivRewardPlayValueMode", i7);
            jSONObject.put("ivRewardPlayValue", i6);
            com.mbridge.msdk.c.h.a().f(this.f15282s, jSONObject.toString());
        } catch (Exception unused) {
            af.b("RewardVideoController", "setIVRewardEnable to SP was ERROR");
        }
    }

    public static void a(String str, int i4) {
        try {
            if (f15238N != null && ap.b(str)) {
                f15238N.put(str, Integer.valueOf(i4));
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoController", e5.getMessage());
            }
        }
    }

    public static void a(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (concurrentHashMap = f15239O) != null && !concurrentHashMap.containsKey(str)) {
            f15239O.put(str, str2);
        }
    }

    public final void a(InterVideoOutListener interVideoOutListener) {
        this.f15279p = interVideoOutListener;
        this.f15280q = new c(interVideoOutListener, this.f15288y, this.f15282s);
    }

    public final void a(boolean z4, com.mbridge.msdk.foundation.same.report.d.e eVar) {
        a(z4, "", eVar);
    }

    public final void a(boolean z4, String str, com.mbridge.msdk.foundation.same.report.d.e eVar) {
        a aVar;
        com.mbridge.msdk.foundation.same.report.d.c b5 = b(z4, str, eVar);
        if (this.f15280q == null) {
            aVar = this;
            aVar.f15280q = new c((InterVideoOutListener) null, this.f15288y, this.f15282s);
        } else {
            aVar = this;
        }
        if (aVar.f15280q == null || aVar.f15280q.f15343c.get() != 1) {
            if (aVar.f15280q == null || aVar.f15280q.f15343c.get() != 3) {
                aVar.f15260S = true;
                if (aVar.f15280q != null) {
                    aVar.f15280q.f15343c.set(1);
                }
            } else {
                aVar.f15260S = false;
            }
            aVar.f15251H = z4;
            aVar.f15288y.removeMessages(1001001);
            aVar.f15263V = false;
            aVar.f15262U = false;
            aVar.f15264W = false;
            aVar.f15265X = false;
            q();
            p();
            com.mbridge.msdk.reward.adapter.b.a();
            try {
                if (TextUtils.isEmpty(str)) {
                    if (aVar.f15247D) {
                        com.mbridge.msdk.d.b.getInstance().addInterstitialList(aVar.f15285v, aVar.f15282s);
                    } else {
                        com.mbridge.msdk.d.b.getInstance().addRewardList(aVar.f15285v, aVar.f15282s);
                    }
                }
                if (aVar.f15248E && TextUtils.isEmpty(str)) {
                    b(b5);
                } else if (com.mbridge.msdk.system.a.map == null) {
                    a(b5);
                } else {
                    com.mbridge.msdk.videocommon.d.c a5 = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), aVar.f15282s);
                    aVar.f15277n = a5;
                    if (a5 == null) {
                        aVar.f15258Q = com.mbridge.msdk.foundation.controller.c.m().k();
                        com.mbridge.msdk.videocommon.d.b.a().a(aVar.f15258Q, com.mbridge.msdk.foundation.controller.c.m().b(), aVar.f15282s, new com.mbridge.msdk.videocommon.c.c() {
                            public final void a(String str) {
                            }

                            public final void b(String str) {
                            }
                        });
                        aVar.f15277n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), aVar.f15282s, aVar.f15247D);
                    }
                    if (!TextUtils.isEmpty(aVar.f15285v)) {
                        aVar.f15277n.b(aVar.f15285v);
                    }
                    int F4 = aVar.f15277n.F() * 1000;
                    if (aVar.f15288y != null) {
                        Message obtain = Message.obtain();
                        obtain.what = 1001002;
                        if (b5 != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("metrics_data_lrid", b5.f());
                            obtain.setData(bundle);
                        }
                        aVar.f15288y.sendMessageDelayed(obtain, (long) F4);
                    }
                    aVar.f15257P = aVar.f15277n.B();
                    try {
                        a(z4, str, b5);
                    } catch (Exception e5) {
                        Exception exc = e5;
                        if (aVar.f15280q != null) {
                            com.mbridge.msdk.foundation.c.b b6 = com.mbridge.msdk.foundation.c.a.b(880020, "load exception");
                            if (b5 != null) {
                                b5.a(b6);
                                b5.c(true);
                            }
                            aVar.f15280q.a(b6, b5);
                        }
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoController", exc.getMessage());
                        }
                    }
                }
            } catch (Exception e6) {
                Exception exc2 = e6;
                if (aVar.f15280q != null) {
                    com.mbridge.msdk.foundation.c.b b7 = com.mbridge.msdk.foundation.c.a.b(880001, "");
                    if (b5 != null) {
                        b5.a(b7);
                        b5.c(true);
                    }
                    aVar.f15280q.a(b7, b5);
                }
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", exc2.getMessage());
                }
            }
        } else {
            a(z4, b5);
        }
    }

    private void b(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f15280q != null) {
            com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880035, "");
            if (cVar != null) {
                cVar.a(b5);
                cVar.c(true);
            }
            c.a(this.f15280q, "bidToken is empty", cVar);
        }
    }

    private void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f15280q != null) {
            String a5 = com.mbridge.msdk.foundation.c.a.a(880001, "");
            com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880001, "");
            if (cVar != null) {
                cVar.a(b5);
                cVar.c(true);
            }
            c.a(this.f15280q, a5, cVar);
        }
    }

    private void a(boolean z4, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f15251H) {
            if (z4) {
                String a5 = com.mbridge.msdk.foundation.c.a.a(880016, "errorCode: 3501 errorMessage: current unit is loading");
                com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880016, "errorCode: 3501 errorMessage: current unit is loading");
                if (cVar != null) {
                    cVar.a(b5);
                    cVar.c(true);
                }
                this.f15280q.a(a5, cVar);
            }
        } else if (z4) {
            this.f15251H = z4;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:158:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0486  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean r17, java.lang.String r18, com.mbridge.msdk.foundation.same.report.d.c r19) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r4 = r18
            r5 = r19
            com.mbridge.msdk.reward.b.a$c r0 = r1.f15280q
            if (r0 == 0) goto L_0x04c0
            boolean r0 = r1.f15248E
            java.lang.String r10 = "RewardVideoController"
            r3 = 880019(0xd6d93, float:1.233169E-39)
            java.lang.String r6 = ""
            r11 = 0
            r12 = 1
            if (r0 != 0) goto L_0x0161
            java.lang.String r0 = r1.f15282s
            java.lang.String r7 = r5.f()
            boolean r0 = r1.c((java.lang.String) r0, (java.lang.String) r7)
            r1.f15266Y = r0
            boolean r0 = r1.f15266Y
            if (r0 == 0) goto L_0x0111
            boolean r0 = r1.s()
            if (r0 != 0) goto L_0x00b4
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r1.f15267Z
            if (r3 == 0) goto L_0x04c0
            int r0 = r3.size()
            if (r0 <= 0) goto L_0x04c0
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0055 }
            r0.<init>()     // Catch:{ Exception -> 0x0055 }
            java.lang.String r6 = "cache"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x0055 }
            r0.a(r6, r7)     // Catch:{ Exception -> 0x0055 }
            java.lang.String r6 = "2000127"
            r5.a(r6, r0)     // Catch:{ Exception -> 0x0055 }
            java.lang.String r6 = "2000048"
            r5.a(r6, r0)     // Catch:{ Exception -> 0x0055 }
            r5.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)     // Catch:{ Exception -> 0x0055 }
            goto L_0x0061
        L_0x0055:
            r0 = move-exception
            boolean r6 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r6 == 0) goto L_0x0061
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r10, r0)
        L_0x0061:
            com.mbridge.msdk.reward.b.a$c r0 = r1.f15280q
            java.lang.String r6 = r1.f15285v
            java.lang.String r7 = r1.f15282s
            com.mbridge.msdk.reward.b.a.c.a(r0, r6, r7, r5)
            java.lang.Object r0 = r3.get(r11)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            com.mbridge.msdk.reward.b.a$c r6 = r1.f15280q
            boolean r7 = r1.f15248E
            r6.a((boolean) r7)
            com.mbridge.msdk.reward.adapter.c r6 = r1.f15276m
            if (r6 == 0) goto L_0x009b
            java.lang.String r7 = r0.getCMPTEntryUrl()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            r7 = r7 ^ r12
            int r0 = r0.getNscpt()
            boolean r0 = r6.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3, (boolean) r7, (int) r0)
            if (r0 == 0) goto L_0x009b
            r1.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)
            com.mbridge.msdk.reward.b.a$c r0 = r1.f15280q
            java.lang.String r3 = r1.f15285v
            java.lang.String r6 = r1.f15282s
            r0.b((java.lang.String) r3, (java.lang.String) r6, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            goto L_0x00a0
        L_0x009b:
            com.mbridge.msdk.reward.adapter.c r0 = r1.f15276m
            r1.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r3, (com.mbridge.msdk.reward.adapter.c) r0)
        L_0x00a0:
            boolean r0 = r1.f15260S
            if (r0 == 0) goto L_0x04c0
            com.mbridge.msdk.reward.adapter.c r0 = r1.f15276m
            if (r0 == 0) goto L_0x00ad
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r1.f15267Z
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)
        L_0x00ad:
            java.util.Queue<java.lang.Integer> r0 = r1.f15257P
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            goto L_0x04c0
        L_0x00b4:
            java.lang.String r0 = "非BID，本地存在可用的缓存，超过上限"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r10, (java.lang.String) r0)
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.f15267Z
            if (r0 == 0) goto L_0x00df
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00df
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.f15267Z
            java.util.Iterator r0 = r0.iterator()
        L_0x00c9:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L_0x00df
            java.lang.Object r7 = r0.next()
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = (com.mbridge.msdk.foundation.entity.CampaignEx) r7
            com.mbridge.msdk.videocommon.a.a r8 = com.mbridge.msdk.videocommon.a.a.a()
            java.lang.String r9 = r1.f15282s
            r8.a((com.mbridge.msdk.foundation.entity.CampaignEx) r7, (java.lang.String) r9)
            goto L_0x00c9
        L_0x00df:
            com.mbridge.msdk.reward.adapter.c r0 = r1.f15276m
            if (r0 == 0) goto L_0x00e8
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r7 = r1.f15267Z
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r7)
        L_0x00e8:
            if (r2 == 0) goto L_0x0102
            com.mbridge.msdk.reward.b.a$c r0 = r1.f15280q
            if (r0 == 0) goto L_0x04c0
            java.lang.String r0 = com.mbridge.msdk.foundation.c.a.a(r3, r6)
            com.mbridge.msdk.foundation.c.b r2 = com.mbridge.msdk.foundation.c.a.b(r3, r6)
            r5.a((com.mbridge.msdk.foundation.c.b) r2)
            r5.c((boolean) r12)
            com.mbridge.msdk.reward.b.a$c r2 = r1.f15280q
            com.mbridge.msdk.reward.b.a.c.a((com.mbridge.msdk.reward.b.a.c) r2, (java.lang.String) r0, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            return
        L_0x0102:
            r1.f15266Y = r11
            com.mbridge.msdk.reward.b.a$c r0 = r1.f15280q
            boolean r3 = r1.f15248E
            r0.a((boolean) r3)
            java.util.Queue<java.lang.Integer> r0 = r1.f15257P
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            return
        L_0x0111:
            boolean r0 = r1.s()
            if (r0 != 0) goto L_0x012f
            r1.f15266Y = r11
            com.mbridge.msdk.reward.adapter.c r0 = r1.f15276m
            if (r0 == 0) goto L_0x0122
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r1.f15267Z
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)
        L_0x0122:
            com.mbridge.msdk.reward.b.a$c r0 = r1.f15280q
            boolean r3 = r1.f15248E
            r0.a((boolean) r3)
            java.util.Queue<java.lang.Integer> r0 = r1.f15257P
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            return
        L_0x012f:
            if (r2 == 0) goto L_0x0149
            com.mbridge.msdk.reward.b.a$c r0 = r1.f15280q
            if (r0 == 0) goto L_0x04c0
            java.lang.String r0 = com.mbridge.msdk.foundation.c.a.a(r3, r6)
            com.mbridge.msdk.foundation.c.b r2 = com.mbridge.msdk.foundation.c.a.b(r3, r6)
            r5.a((com.mbridge.msdk.foundation.c.b) r2)
            r5.c((boolean) r12)
            com.mbridge.msdk.reward.b.a$c r2 = r1.f15280q
            com.mbridge.msdk.reward.b.a.c.a((com.mbridge.msdk.reward.b.a.c) r2, (java.lang.String) r0, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            return
        L_0x0149:
            r1.f15266Y = r11
            com.mbridge.msdk.reward.adapter.c r0 = r1.f15276m
            if (r0 == 0) goto L_0x0154
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r1.f15267Z
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)
        L_0x0154:
            com.mbridge.msdk.reward.b.a$c r0 = r1.f15280q
            boolean r3 = r1.f15248E
            r0.a((boolean) r3)
            java.util.Queue<java.lang.Integer> r0 = r1.f15257P
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            return
        L_0x0161:
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()
            java.lang.String r7 = r1.f15282s
            boolean r8 = r1.f15248E
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.a((java.lang.String) r7, (int) r12, (boolean) r8, (java.lang.String) r6)
            r7 = 880038(0xd6da6, float:1.233196E-39)
            r13 = 0
            if (r0 == 0) goto L_0x033a
            int r8 = r0.size()
            if (r8 <= 0) goto L_0x033a
            boolean r8 = r1.s()
            if (r8 != 0) goto L_0x0315
            java.util.concurrent.CopyOnWriteArrayList r3 = new java.util.concurrent.CopyOnWriteArrayList
            r3.<init>()
            int r6 = r0.size()
            if (r6 <= 0) goto L_0x01b0
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x01b0
            java.util.Iterator r6 = r0.iterator()
        L_0x0194:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x01b0
            java.lang.Object r8 = r6.next()
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8
            if (r8 == 0) goto L_0x0194
            java.lang.String r9 = r8.getBidToken()
            boolean r9 = r4.equals(r9)
            if (r9 == 0) goto L_0x0194
            r3.add(r8)
            goto L_0x0194
        L_0x01b0:
            int r6 = r3.size()
            if (r6 <= 0) goto L_0x01ba
            r1.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r3, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            return
        L_0x01ba:
            com.mbridge.msdk.reward.a.a r3 = new com.mbridge.msdk.reward.a.a     // Catch:{ Exception -> 0x01fb }
            java.lang.String r6 = r1.f15282s     // Catch:{ Exception -> 0x01fb }
            boolean r8 = r1.f15247D     // Catch:{ Exception -> 0x01fb }
            r3.<init>(r6, r8)     // Catch:{ Exception -> 0x01fb }
            com.mbridge.msdk.foundation.b.c r6 = new com.mbridge.msdk.foundation.b.c     // Catch:{ Exception -> 0x01fb }
            r6.<init>()     // Catch:{ Exception -> 0x01fb }
            boolean r8 = r3.a(r4)     // Catch:{ Exception -> 0x01fb }
            if (r8 == 0) goto L_0x02ac
            com.mbridge.msdk.reward.adapter.c r6 = r1.f15276m     // Catch:{ Exception -> 0x0283 }
            if (r6 != 0) goto L_0x020c
            com.mbridge.msdk.reward.adapter.c r6 = new com.mbridge.msdk.reward.adapter.c     // Catch:{ Exception -> 0x01fb }
            android.content.Context r8 = r1.f15275l     // Catch:{ Exception -> 0x01fb }
            java.lang.String r9 = r1.f15285v     // Catch:{ Exception -> 0x01fb }
            java.lang.String r14 = r1.f15282s     // Catch:{ Exception -> 0x01fb }
            r6.<init>(r8, r9, r14)     // Catch:{ Exception -> 0x01fb }
            r1.f15276m = r6     // Catch:{ Exception -> 0x01fb }
            boolean r8 = r1.f15247D     // Catch:{ Exception -> 0x01fb }
            r6.b((boolean) r8)     // Catch:{ Exception -> 0x01fb }
            com.mbridge.msdk.reward.adapter.c r6 = r1.f15276m     // Catch:{ Exception -> 0x01fb }
            boolean r8 = r1.f15248E     // Catch:{ Exception -> 0x01fb }
            r6.c((boolean) r8)     // Catch:{ Exception -> 0x01fb }
            boolean r6 = r1.f15247D     // Catch:{ Exception -> 0x01fb }
            if (r6 == 0) goto L_0x01fe
            com.mbridge.msdk.reward.adapter.c r6 = r1.f15276m     // Catch:{ Exception -> 0x01fb }
            int r8 = r1.f15244A     // Catch:{ Exception -> 0x01fb }
            int r9 = r1.f15245B     // Catch:{ Exception -> 0x01fb }
            int r14 = r1.f15246C     // Catch:{ Exception -> 0x01fb }
            r6.a((int) r8, (int) r9, (int) r14)     // Catch:{ Exception -> 0x01fb }
            goto L_0x01fe
        L_0x01fb:
            r0 = move-exception
            goto L_0x02fa
        L_0x01fe:
            com.mbridge.msdk.reward.adapter.c r6 = r1.f15276m     // Catch:{ Exception -> 0x01fb }
            int r8 = r1.f15289z     // Catch:{ Exception -> 0x01fb }
            r6.a((int) r8)     // Catch:{ Exception -> 0x01fb }
            com.mbridge.msdk.reward.adapter.c r6 = r1.f15276m     // Catch:{ Exception -> 0x01fb }
            com.mbridge.msdk.videocommon.d.c r8 = r1.f15277n     // Catch:{ Exception -> 0x01fb }
            r6.a((com.mbridge.msdk.videocommon.d.c) r8)     // Catch:{ Exception -> 0x01fb }
        L_0x020c:
            com.mbridge.msdk.foundation.c.b r6 = new com.mbridge.msdk.foundation.c.b     // Catch:{ Exception -> 0x0283 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0283 }
            com.mbridge.msdk.reward.adapter.c r9 = r1.f15276m     // Catch:{ Exception -> 0x0283 }
            r7 = r6
            r6 = 0
            r8 = 1
            com.mbridge.msdk.foundation.b.c r6 = r3.a((java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r6, (com.mbridge.msdk.foundation.c.b) r7, (int) r8, (com.mbridge.msdk.reward.adapter.c) r9)     // Catch:{ Exception -> 0x0283 }
            if (r6 == 0) goto L_0x02cf
            int r5 = r6.g()     // Catch:{ Exception -> 0x0283 }
            int r7 = com.mbridge.msdk.foundation.b.c.f12738d     // Catch:{ Exception -> 0x0283 }
            if (r5 != r7) goto L_0x02cf
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x0283 }
            if (r5 == 0) goto L_0x02cf
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x0283 }
            int r5 = r5.size()     // Catch:{ Exception -> 0x0283 }
            if (r5 <= 0) goto L_0x02cf
            com.mbridge.msdk.reward.adapter.c r5 = r1.f15276m     // Catch:{ Exception -> 0x0283 }
            if (r5 == 0) goto L_0x02cf
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x0283 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x0283 }
            r7.<init>()     // Catch:{ Exception -> 0x0283 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0283 }
        L_0x0245:
            boolean r8 = r0.hasNext()     // Catch:{ Exception -> 0x0283 }
            if (r8 == 0) goto L_0x0294
            java.lang.Object r8 = r0.next()     // Catch:{ Exception -> 0x0283 }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8     // Catch:{ Exception -> 0x0283 }
            if (r8 == 0) goto L_0x0245
            java.lang.String r9 = r8.getRequestId()     // Catch:{ Exception -> 0x0283 }
            boolean r13 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0283 }
            if (r13 == 0) goto L_0x025e
            goto L_0x0245
        L_0x025e:
            r0 = 0
        L_0x025f:
            int r13 = r5.size()     // Catch:{ Exception -> 0x0283 }
            if (r0 >= r13) goto L_0x028b
            java.lang.Object r13 = r5.get(r0)     // Catch:{ Exception -> 0x0283 }
            com.mbridge.msdk.foundation.entity.CampaignEx r13 = (com.mbridge.msdk.foundation.entity.CampaignEx) r13     // Catch:{ Exception -> 0x0283 }
            if (r13 == 0) goto L_0x0288
            java.lang.String r13 = r13.getRequestId()     // Catch:{ Exception -> 0x0283 }
            boolean r13 = r9.equals(r13)     // Catch:{ Exception -> 0x0283 }
            if (r13 == 0) goto L_0x0278
            goto L_0x028b
        L_0x0278:
            int r13 = r5.size()     // Catch:{ Exception -> 0x0283 }
            int r13 = r13 - r12
            if (r0 != r13) goto L_0x0288
            r7.add(r8)     // Catch:{ Exception -> 0x0283 }
            goto L_0x0288
        L_0x0283:
            r0 = move-exception
            r5 = r19
            goto L_0x02fa
        L_0x0288:
            int r0 = r0 + 1
            goto L_0x025f
        L_0x028b:
            int r0 = r5.size()     // Catch:{ Exception -> 0x0283 }
            if (r0 != 0) goto L_0x0294
            r7.add(r8)     // Catch:{ Exception -> 0x0283 }
        L_0x0294:
            com.mbridge.msdk.reward.adapter.c r0 = r1.f15276m     // Catch:{ Exception -> 0x0283 }
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r7)     // Catch:{ Exception -> 0x0283 }
            com.mbridge.msdk.reward.adapter.c r0 = r1.f15276m     // Catch:{ Exception -> 0x0283 }
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x0283 }
            r0.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r5, (boolean) r11, (boolean) r12)     // Catch:{ Exception -> 0x0283 }
            java.util.concurrent.CopyOnWriteArrayList r13 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x0283 }
            java.util.concurrent.CopyOnWriteArrayList r0 = r6.a()     // Catch:{ Exception -> 0x0283 }
            r13.<init>(r0)     // Catch:{ Exception -> 0x0283 }
            goto L_0x02cf
        L_0x02ac:
            java.util.concurrent.CopyOnWriteArrayList r13 = r1.a((java.lang.String) r4, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r0)     // Catch:{ Exception -> 0x0283 }
            int r0 = r13.size()     // Catch:{ Exception -> 0x0283 }
            if (r0 <= 0) goto L_0x02c5
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0283 }
            android.content.Context r0 = r0.c()     // Catch:{ Exception -> 0x0283 }
            com.mbridge.msdk.foundation.db.b r0 = com.mbridge.msdk.foundation.db.b.a((android.content.Context) r0)     // Catch:{ Exception -> 0x0283 }
            r0.a((java.lang.String) r4, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r13)     // Catch:{ Exception -> 0x0283 }
        L_0x02c5:
            java.lang.String r0 = "cb is closed"
            r6.d(r0)     // Catch:{ Exception -> 0x0283 }
            int r0 = com.mbridge.msdk.foundation.b.c.f12737c     // Catch:{ Exception -> 0x0283 }
            r6.a((int) r0)     // Catch:{ Exception -> 0x0283 }
        L_0x02cf:
            r8 = 0
            r9 = 1
            r7 = 0
            r5 = r4
            r4 = r19
            r3.a((com.mbridge.msdk.foundation.same.report.d.c) r4, (java.lang.String) r5, (com.mbridge.msdk.foundation.b.c) r6, (java.util.List<com.mbridge.msdk.foundation.b.a.C0178a>) r7, (org.json.JSONObject) r8, (int) r9)     // Catch:{ Exception -> 0x02f6 }
            r15 = r5
            r5 = r4
            r4 = r15
            if (r13 == 0) goto L_0x0305
            int r0 = r13.size()     // Catch:{ Exception -> 0x01fb }
            if (r0 <= 0) goto L_0x0305
            r1.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r13, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)     // Catch:{ Exception -> 0x01fb }
            com.mbridge.msdk.reward.adapter.c r0 = r1.f15276m     // Catch:{ Exception -> 0x01fb }
            if (r0 == 0) goto L_0x0305
            boolean r0 = r3.a(r4)     // Catch:{ Exception -> 0x01fb }
            if (r0 != 0) goto L_0x0305
            com.mbridge.msdk.reward.adapter.c r0 = r1.f15276m     // Catch:{ Exception -> 0x01fb }
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r13)     // Catch:{ Exception -> 0x01fb }
            goto L_0x0305
        L_0x02f6:
            r0 = move-exception
            r15 = r5
            r5 = r4
            r4 = r15
        L_0x02fa:
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r3 == 0) goto L_0x0305
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r10, r0)
        L_0x0305:
            r1.f15266Y = r11
            com.mbridge.msdk.reward.b.a$c r0 = r1.f15280q
            boolean r3 = r1.f15248E
            r0.a((boolean) r3)
            java.util.Queue<java.lang.Integer> r0 = r1.f15257P
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            goto L_0x04c0
        L_0x0315:
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()
            java.lang.String r7 = r1.f15282s
            r0.a((java.lang.String) r7, (java.lang.String) r4)
            if (r2 == 0) goto L_0x04c0
            com.mbridge.msdk.reward.b.a$c r0 = r1.f15280q
            if (r0 == 0) goto L_0x04c0
            java.lang.String r0 = com.mbridge.msdk.foundation.c.a.a(r3, r6)
            com.mbridge.msdk.foundation.c.b r2 = com.mbridge.msdk.foundation.c.a.b(r3, r6)
            if (r5 == 0) goto L_0x0334
            r5.a((com.mbridge.msdk.foundation.c.b) r2)
            r5.c((boolean) r12)
        L_0x0334:
            com.mbridge.msdk.reward.b.a$c r2 = r1.f15280q
            com.mbridge.msdk.reward.b.a.c.a((com.mbridge.msdk.reward.b.a.c) r2, (java.lang.String) r0, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            return
        L_0x033a:
            boolean r8 = r1.s()
            if (r8 != 0) goto L_0x049c
            com.mbridge.msdk.reward.a.a r3 = new com.mbridge.msdk.reward.a.a     // Catch:{ Exception -> 0x0381 }
            java.lang.String r6 = r1.f15282s     // Catch:{ Exception -> 0x0381 }
            boolean r8 = r1.f15247D     // Catch:{ Exception -> 0x0381 }
            r3.<init>(r6, r8)     // Catch:{ Exception -> 0x0381 }
            com.mbridge.msdk.foundation.b.c r6 = new com.mbridge.msdk.foundation.b.c     // Catch:{ Exception -> 0x0381 }
            r6.<init>()     // Catch:{ Exception -> 0x0381 }
            boolean r8 = r3.a(r4)     // Catch:{ Exception -> 0x0381 }
            if (r8 == 0) goto L_0x0434
            com.mbridge.msdk.reward.adapter.c r6 = r1.f15276m     // Catch:{ Exception -> 0x040b }
            if (r6 != 0) goto L_0x0392
            com.mbridge.msdk.reward.adapter.c r6 = new com.mbridge.msdk.reward.adapter.c     // Catch:{ Exception -> 0x0381 }
            android.content.Context r8 = r1.f15275l     // Catch:{ Exception -> 0x0381 }
            java.lang.String r9 = r1.f15285v     // Catch:{ Exception -> 0x0381 }
            java.lang.String r14 = r1.f15282s     // Catch:{ Exception -> 0x0381 }
            r6.<init>(r8, r9, r14)     // Catch:{ Exception -> 0x0381 }
            r1.f15276m = r6     // Catch:{ Exception -> 0x0381 }
            boolean r8 = r1.f15247D     // Catch:{ Exception -> 0x0381 }
            r6.b((boolean) r8)     // Catch:{ Exception -> 0x0381 }
            com.mbridge.msdk.reward.adapter.c r6 = r1.f15276m     // Catch:{ Exception -> 0x0381 }
            boolean r8 = r1.f15248E     // Catch:{ Exception -> 0x0381 }
            r6.c((boolean) r8)     // Catch:{ Exception -> 0x0381 }
            boolean r6 = r1.f15247D     // Catch:{ Exception -> 0x0381 }
            if (r6 == 0) goto L_0x0384
            com.mbridge.msdk.reward.adapter.c r6 = r1.f15276m     // Catch:{ Exception -> 0x0381 }
            int r8 = r1.f15244A     // Catch:{ Exception -> 0x0381 }
            int r9 = r1.f15245B     // Catch:{ Exception -> 0x0381 }
            int r14 = r1.f15246C     // Catch:{ Exception -> 0x0381 }
            r6.a((int) r8, (int) r9, (int) r14)     // Catch:{ Exception -> 0x0381 }
            goto L_0x0384
        L_0x0381:
            r0 = move-exception
            goto L_0x0482
        L_0x0384:
            com.mbridge.msdk.reward.adapter.c r6 = r1.f15276m     // Catch:{ Exception -> 0x0381 }
            int r8 = r1.f15289z     // Catch:{ Exception -> 0x0381 }
            r6.a((int) r8)     // Catch:{ Exception -> 0x0381 }
            com.mbridge.msdk.reward.adapter.c r6 = r1.f15276m     // Catch:{ Exception -> 0x0381 }
            com.mbridge.msdk.videocommon.d.c r8 = r1.f15277n     // Catch:{ Exception -> 0x0381 }
            r6.a((com.mbridge.msdk.videocommon.d.c) r8)     // Catch:{ Exception -> 0x0381 }
        L_0x0392:
            com.mbridge.msdk.foundation.c.b r6 = new com.mbridge.msdk.foundation.c.b     // Catch:{ Exception -> 0x040b }
            r6.<init>(r7)     // Catch:{ Exception -> 0x040b }
            com.mbridge.msdk.reward.adapter.c r9 = r1.f15276m     // Catch:{ Exception -> 0x040b }
            r7 = r6
            r6 = 0
            r8 = 1
            com.mbridge.msdk.foundation.b.c r6 = r3.a((java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r6, (com.mbridge.msdk.foundation.c.b) r7, (int) r8, (com.mbridge.msdk.reward.adapter.c) r9)     // Catch:{ Exception -> 0x040b }
            if (r6 == 0) goto L_0x0457
            int r5 = r6.g()     // Catch:{ Exception -> 0x040b }
            int r7 = com.mbridge.msdk.foundation.b.c.f12738d     // Catch:{ Exception -> 0x040b }
            if (r5 != r7) goto L_0x0457
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x040b }
            if (r5 == 0) goto L_0x0457
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x040b }
            int r5 = r5.size()     // Catch:{ Exception -> 0x040b }
            if (r5 <= 0) goto L_0x0457
            com.mbridge.msdk.reward.adapter.c r5 = r1.f15276m     // Catch:{ Exception -> 0x040b }
            if (r5 == 0) goto L_0x0457
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x040b }
            if (r0 == 0) goto L_0x0421
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x040b }
            r7.<init>()     // Catch:{ Exception -> 0x040b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x040b }
        L_0x03cd:
            boolean r8 = r0.hasNext()     // Catch:{ Exception -> 0x040b }
            if (r8 == 0) goto L_0x041c
            java.lang.Object r8 = r0.next()     // Catch:{ Exception -> 0x040b }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8     // Catch:{ Exception -> 0x040b }
            if (r8 == 0) goto L_0x03cd
            java.lang.String r9 = r8.getRequestId()     // Catch:{ Exception -> 0x040b }
            boolean r13 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x040b }
            if (r13 == 0) goto L_0x03e6
            goto L_0x03cd
        L_0x03e6:
            r0 = 0
        L_0x03e7:
            int r13 = r5.size()     // Catch:{ Exception -> 0x040b }
            if (r0 >= r13) goto L_0x0413
            java.lang.Object r13 = r5.get(r0)     // Catch:{ Exception -> 0x040b }
            com.mbridge.msdk.foundation.entity.CampaignEx r13 = (com.mbridge.msdk.foundation.entity.CampaignEx) r13     // Catch:{ Exception -> 0x040b }
            if (r13 == 0) goto L_0x0410
            java.lang.String r13 = r13.getRequestId()     // Catch:{ Exception -> 0x040b }
            boolean r13 = r9.equals(r13)     // Catch:{ Exception -> 0x040b }
            if (r13 == 0) goto L_0x0400
            goto L_0x0413
        L_0x0400:
            int r13 = r5.size()     // Catch:{ Exception -> 0x040b }
            int r13 = r13 - r12
            if (r0 != r13) goto L_0x0410
            r7.add(r8)     // Catch:{ Exception -> 0x040b }
            goto L_0x0410
        L_0x040b:
            r0 = move-exception
            r5 = r19
            goto L_0x0482
        L_0x0410:
            int r0 = r0 + 1
            goto L_0x03e7
        L_0x0413:
            int r0 = r5.size()     // Catch:{ Exception -> 0x040b }
            if (r0 != 0) goto L_0x041c
            r7.add(r8)     // Catch:{ Exception -> 0x040b }
        L_0x041c:
            com.mbridge.msdk.reward.adapter.c r0 = r1.f15276m     // Catch:{ Exception -> 0x040b }
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r7)     // Catch:{ Exception -> 0x040b }
        L_0x0421:
            com.mbridge.msdk.reward.adapter.c r0 = r1.f15276m     // Catch:{ Exception -> 0x040b }
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x040b }
            r0.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r5, (boolean) r11, (boolean) r12)     // Catch:{ Exception -> 0x040b }
            java.util.concurrent.CopyOnWriteArrayList r13 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x040b }
            java.util.concurrent.CopyOnWriteArrayList r0 = r6.a()     // Catch:{ Exception -> 0x040b }
            r13.<init>(r0)     // Catch:{ Exception -> 0x040b }
            goto L_0x0457
        L_0x0434:
            java.util.concurrent.CopyOnWriteArrayList r13 = r1.a((java.lang.String) r4, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r0)     // Catch:{ Exception -> 0x040b }
            int r0 = r13.size()     // Catch:{ Exception -> 0x040b }
            if (r0 <= 0) goto L_0x044d
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x040b }
            android.content.Context r0 = r0.c()     // Catch:{ Exception -> 0x040b }
            com.mbridge.msdk.foundation.db.b r0 = com.mbridge.msdk.foundation.db.b.a((android.content.Context) r0)     // Catch:{ Exception -> 0x040b }
            r0.a((java.lang.String) r4, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r13)     // Catch:{ Exception -> 0x040b }
        L_0x044d:
            java.lang.String r0 = "cb is closed 2"
            r6.d(r0)     // Catch:{ Exception -> 0x040b }
            int r0 = com.mbridge.msdk.foundation.b.c.f12737c     // Catch:{ Exception -> 0x040b }
            r6.a((int) r0)     // Catch:{ Exception -> 0x040b }
        L_0x0457:
            r8 = 0
            r9 = 1
            r7 = 0
            r5 = r4
            r4 = r19
            r3.a((com.mbridge.msdk.foundation.same.report.d.c) r4, (java.lang.String) r5, (com.mbridge.msdk.foundation.b.c) r6, (java.util.List<com.mbridge.msdk.foundation.b.a.C0178a>) r7, (org.json.JSONObject) r8, (int) r9)     // Catch:{ Exception -> 0x047e }
            r15 = r5
            r5 = r4
            r4 = r15
            if (r13 == 0) goto L_0x048d
            int r0 = r13.size()     // Catch:{ Exception -> 0x0381 }
            if (r0 <= 0) goto L_0x048d
            r1.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r13, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)     // Catch:{ Exception -> 0x0381 }
            com.mbridge.msdk.reward.adapter.c r0 = r1.f15276m     // Catch:{ Exception -> 0x0381 }
            if (r0 == 0) goto L_0x048d
            boolean r0 = r3.a(r4)     // Catch:{ Exception -> 0x0381 }
            if (r0 != 0) goto L_0x048d
            com.mbridge.msdk.reward.adapter.c r0 = r1.f15276m     // Catch:{ Exception -> 0x0381 }
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r13)     // Catch:{ Exception -> 0x0381 }
            goto L_0x048d
        L_0x047e:
            r0 = move-exception
            r15 = r5
            r5 = r4
            r4 = r15
        L_0x0482:
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r3 == 0) goto L_0x048d
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r10, r0)
        L_0x048d:
            r1.f15266Y = r11
            com.mbridge.msdk.reward.b.a$c r0 = r1.f15280q
            boolean r3 = r1.f15248E
            r0.a((boolean) r3)
            java.util.Queue<java.lang.Integer> r0 = r1.f15257P
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            goto L_0x04c0
        L_0x049c:
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()
            java.lang.String r7 = r1.f15282s
            r0.a((java.lang.String) r7, (java.lang.String) r4)
            if (r2 == 0) goto L_0x04c0
            com.mbridge.msdk.reward.b.a$c r0 = r1.f15280q
            if (r0 == 0) goto L_0x04c0
            java.lang.String r0 = com.mbridge.msdk.foundation.c.a.a(r3, r6)
            com.mbridge.msdk.foundation.c.b r2 = com.mbridge.msdk.foundation.c.a.b(r3, r6)
            if (r5 == 0) goto L_0x04bb
            r5.a((com.mbridge.msdk.foundation.c.b) r2)
            r5.c((boolean) r12)
        L_0x04bb:
            com.mbridge.msdk.reward.b.a$c r2 = r1.f15280q
            com.mbridge.msdk.reward.b.a.c.a((com.mbridge.msdk.reward.b.a.c) r2, (java.lang.String) r0, (com.mbridge.msdk.foundation.same.report.d.c) r5)
        L_0x04c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(boolean, java.lang.String, com.mbridge.msdk.foundation.same.report.d.c):void");
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("cache", 1);
                cVar.a("2000127", eVar);
                cVar.a("2000048", eVar);
                cVar.a((List<CampaignEx>) copyOnWriteArrayList);
            } catch (Exception e5) {
                af.b("RewardVideoController", e5.getMessage());
            }
            this.f15266Y = true;
            this.f15280q.a(this.f15248E);
            c.a(this.f15280q, this.f15285v, this.f15282s, cVar);
            CampaignEx campaignEx = copyOnWriteArrayList.get(0);
            a(campaignEx.getRequestId(), str);
            com.mbridge.msdk.reward.adapter.c cVar2 = this.f15276m;
            if (cVar2 == null || !cVar2.a((List<CampaignEx>) copyOnWriteArrayList, true ^ TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt())) {
                a(copyOnWriteArrayList, this.f15276m);
                return;
            }
            a((List<CampaignEx>) copyOnWriteArrayList);
            this.f15280q.b(this.f15285v, this.f15282s, cVar);
        }
    }

    private CopyOnWriteArrayList<CampaignEx> a(String str, List<CampaignEx> list) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    int i4 = 1;
                    for (CampaignEx next : list) {
                        if (next != null) {
                            if (next.getVcn() > i4) {
                                i4 = next.getVcn();
                            }
                            if (next.getTokenRule() == 1) {
                                String requestId = next.getRequestId();
                                if (!TextUtils.isEmpty(requestId)) {
                                    if (linkedHashMap.containsKey(requestId)) {
                                        List list2 = (List) linkedHashMap.get(requestId);
                                        if (list2 != null) {
                                            list2.add(next);
                                        }
                                    } else {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(next);
                                        linkedHashMap.put(requestId, arrayList);
                                    }
                                }
                            } else {
                                String requestId2 = next.getRequestId();
                                if (!TextUtils.isEmpty(requestId2)) {
                                    if (linkedHashMap2.containsKey(requestId2)) {
                                        List list3 = (List) linkedHashMap2.get(requestId2);
                                        if (list3 != null) {
                                            list3.add(next);
                                        }
                                    } else {
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(next);
                                        linkedHashMap2.put(requestId2, arrayList2);
                                    }
                                }
                            }
                        }
                    }
                    if (!(linkedHashMap2.size() + linkedHashMap.size() < i4 || linkedHashMap.size() <= 0 || linkedHashMap.entrySet() == null || linkedHashMap.entrySet().iterator() == null || linkedHashMap.entrySet().iterator().next() == null || ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue() == null)) {
                        copyOnWriteArrayList.addAll((Collection) ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue());
                        com.mbridge.msdk.foundation.same.a.b.a(this.f15282s, str, i4);
                        return copyOnWriteArrayList;
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e5.getMessage());
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.reward.adapter.c cVar) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = copyOnWriteArrayList;
        CampaignEx campaignEx = copyOnWriteArrayList2.get(0);
        boolean isEmpty = TextUtils.isEmpty(campaignEx.getCMPTEntryUrl());
        boolean z4 = !isEmpty;
        int nscpt = campaignEx.getNscpt();
        this.f15270g = false;
        this.f15271h = false;
        this.f15272i = false;
        this.f15273j = false;
        this.f15274k = false;
        com.mbridge.msdk.reward.adapter.b a5 = com.mbridge.msdk.reward.adapter.b.a();
        Context context = this.f15275l;
        boolean z5 = this.f15248E;
        int i4 = this.f15247D ? 287 : 94;
        Context context2 = context;
        String str = this.f15285v;
        boolean z6 = z5;
        String str2 = this.f15282s;
        com.mbridge.msdk.reward.adapter.b bVar = a5;
        int i5 = i4;
        String requestId = campaignEx.getRequestId();
        Context context3 = context2;
        AnonymousClass2 r11 = new b.c(campaignEx, z4, cVar, nscpt) {

            /* renamed from: a  reason: collision with root package name */
            com.mbridge.msdk.foundation.same.report.d.c f15291a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CampaignEx f15292b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f15293c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ com.mbridge.msdk.reward.adapter.c f15294d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f15295e;

            {
                this.f15292b = r2;
                this.f15293c = r3;
                this.f15294d = r4;
                this.f15295e = r5;
                this.f15291a = com.mbridge.msdk.foundation.same.report.d.d.a().b().get(r2.getLocalRequestId());
            }

            public final void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
                a.this.f15270g = true;
                if (!this.f15293c) {
                    Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        final CampaignEx next = it.next();
                        if (next == null || next.getRewardTemplateMode() == null || TextUtils.isEmpty(next.getRewardTemplateMode().e()) || next.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) || a.this.f15288y == null) {
                            com.mbridge.msdk.reward.adapter.c cVar = this.f15294d;
                            if (cVar == null || !cVar.a((List<CampaignEx>) copyOnWriteArrayList, this.f15293c, this.f15295e)) {
                                a aVar = a.this;
                                a.a(aVar, str2, aVar.aa);
                                if (a.this.f15280q != null && !a.this.f15273j) {
                                    a.this.f15273j = true;
                                    com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3503 errorMessage: have no temp but isReady false");
                                    if (this.f15291a == null) {
                                        this.f15291a = new com.mbridge.msdk.foundation.same.report.d.c();
                                    }
                                    this.f15291a.b((List<CampaignEx>) a.this.f15267Z);
                                    this.f15291a.a(b5);
                                    c.a(a.this.f15280q, b5, this.f15291a);
                                }
                            } else if (a.this.f15280q != null && !a.this.f15274k) {
                                a.this.f15274k = true;
                                af.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                                a.this.a((List<CampaignEx>) copyOnWriteArrayList);
                                com.mbridge.msdk.foundation.same.report.d.c cVar2 = this.f15291a;
                                if (cVar2 != null) {
                                    cVar2.b((List<CampaignEx>) copyOnWriteArrayList);
                                }
                                a.this.f15280q.b(str, str2, this.f15291a);
                            }
                        } else {
                            final String str4 = str;
                            final String str5 = str2;
                            final String str6 = str3;
                            final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = copyOnWriteArrayList;
                            a.this.f15288y.post(new Runnable() {
                                public final void run() {
                                    com.mbridge.msdk.reward.adapter.b.a().a(a.this.f15252I, a.this.f15288y, a.this.f15247D, a.this.f15248E, (WindVaneWebView) null, next.getRewardTemplateMode().e(), a.this.f15289z, AnonymousClass2.this.f15292b, copyOnWriteArrayList2, H5DownLoadManager.getInstance().getH5ResAddress(next.getRewardTemplateMode().e()), str4, str5, str6, next.getRequestIdNotice(), a.this.f15277n, new b.j() {
                                        public final void a(String str, String str2, String str3, String str4, String str5, a.C0208a aVar) {
                                            AnonymousClass1 r22 = AnonymousClass1.this;
                                            AnonymousClass2 r5 = AnonymousClass2.this;
                                            com.mbridge.msdk.reward.adapter.c cVar = r5.f15294d;
                                            if (cVar == null || !cVar.a((List<CampaignEx>) copyOnWriteArrayList2, r5.f15293c, r5.f15295e)) {
                                                a aVar2 = a.this;
                                                a.a(aVar2, str3, aVar2.aa);
                                                if (a.this.f15280q != null && !a.this.f15273j) {
                                                    a.this.f15273j = true;
                                                    com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3502 errorMessage: temp preload success but isReady false");
                                                    AnonymousClass2 r32 = AnonymousClass2.this;
                                                    if (r32.f15291a == null) {
                                                        r32.f15291a = new com.mbridge.msdk.foundation.same.report.d.c();
                                                    }
                                                    AnonymousClass1 r33 = AnonymousClass1.this;
                                                    AnonymousClass2.this.f15291a.b((List<CampaignEx>) copyOnWriteArrayList2);
                                                    AnonymousClass2.this.f15291a.a(b5);
                                                    c.a(a.this.f15280q, b5, AnonymousClass2.this.f15291a);
                                                }
                                            } else if (a.this.f15280q != null && !a.this.f15274k) {
                                                a.this.f15274k = true;
                                                AnonymousClass1 r23 = AnonymousClass1.this;
                                                a.this.a((List<CampaignEx>) copyOnWriteArrayList2);
                                                a.this.f15280q.b(str2, str3, AnonymousClass2.this.f15291a);
                                            }
                                        }

                                        public final void a(String str, String str2, String str3, a.C0208a aVar, com.mbridge.msdk.foundation.c.b bVar) {
                                            AnonymousClass1 r12 = AnonymousClass1.this;
                                            a aVar2 = a.this;
                                            a.a(aVar2, str5, aVar2.aa);
                                            if (a.this.f15280q != null && !a.this.f15273j) {
                                                a.this.f15273j = true;
                                                bVar.a("errorCode: 3301 errorMessage: temp preload failed");
                                                AnonymousClass2 r13 = AnonymousClass2.this;
                                                if (r13.f15291a == null) {
                                                    r13.f15291a = new com.mbridge.msdk.foundation.same.report.d.c();
                                                }
                                                AnonymousClass2 r14 = AnonymousClass2.this;
                                                r14.f15291a.b((List<CampaignEx>) a.this.f15267Z);
                                                AnonymousClass2.this.f15291a.a(bVar);
                                                c.a(a.this.f15280q, bVar, AnonymousClass2.this.f15291a);
                                            }
                                        }
                                    });
                                }
                            });
                        }
                    }
                } else if (a.this.f15271h && !a.this.f15272i && a.this.f15288y != null) {
                    a.this.f15272i = true;
                    final String str7 = str;
                    final String str8 = str2;
                    final String str9 = str3;
                    final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = copyOnWriteArrayList;
                    a.this.f15288y.post(new Runnable() {
                        public final void run() {
                            com.mbridge.msdk.reward.adapter.b a5 = com.mbridge.msdk.reward.adapter.b.a();
                            com.mbridge.msdk.reward.adapter.b bVar = a5;
                            bVar.a(a.this.f15252I, a.this.f15288y, a.this.f15247D, a.this.f15248E, str9, AnonymousClass2.this.f15292b.getRequestIdNotice(), str7, str8, AnonymousClass2.this.f15292b.getCMPTEntryUrl(), a.this.f15289z, AnonymousClass2.this.f15292b, copyOnWriteArrayList3, H5DownLoadManager.getInstance().getH5ResAddress(AnonymousClass2.this.f15292b.getCMPTEntryUrl()), str8, a.this.f15277n, new b.j() {
                                public final void a(String str, String str2, String str3, String str4, String str5, a.C0208a aVar) {
                                    AnonymousClass2 r22 = AnonymousClass2.this;
                                    AnonymousClass2 r5 = AnonymousClass2.this;
                                    com.mbridge.msdk.reward.adapter.c cVar = r5.f15294d;
                                    if (cVar == null || !cVar.a((List<CampaignEx>) copyOnWriteArrayList3, r5.f15293c, r5.f15295e)) {
                                        a aVar2 = a.this;
                                        a.a(aVar2, str3, aVar2.aa);
                                        if (a.this.f15280q != null && !a.this.f15273j) {
                                            a.this.f15273j = true;
                                            com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3504 errorMessage: tpl temp preload success but isReady false");
                                            AnonymousClass2 r32 = AnonymousClass2.this;
                                            if (r32.f15291a == null) {
                                                r32.f15291a = new com.mbridge.msdk.foundation.same.report.d.c();
                                            }
                                            AnonymousClass2.this.f15291a.a(b5);
                                            AnonymousClass2 r33 = AnonymousClass2.this;
                                            AnonymousClass2.this.f15291a.b((List<CampaignEx>) copyOnWriteArrayList3);
                                            c.a(a.this.f15280q, b5, AnonymousClass2.this.f15291a);
                                        }
                                    } else if (a.this.f15280q != null && !a.this.f15274k) {
                                        a.this.f15274k = true;
                                        af.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                                        AnonymousClass2 r23 = AnonymousClass2.this;
                                        a.this.a((List<CampaignEx>) copyOnWriteArrayList3);
                                        AnonymousClass2 r24 = AnonymousClass2.this;
                                        com.mbridge.msdk.foundation.same.report.d.c cVar2 = AnonymousClass2.this.f15291a;
                                        if (cVar2 != null) {
                                            cVar2.b((List<CampaignEx>) copyOnWriteArrayList3);
                                        }
                                        a.this.f15280q.b(str2, str3, AnonymousClass2.this.f15291a);
                                    }
                                }

                                public final void a(String str, String str2, String str3, a.C0208a aVar, com.mbridge.msdk.foundation.c.b bVar) {
                                    AnonymousClass2 r12 = AnonymousClass2.this;
                                    a aVar2 = a.this;
                                    a.a(aVar2, str8, aVar2.aa);
                                    if (a.this.f15280q != null && !a.this.f15273j) {
                                        a.this.f15273j = true;
                                        if (bVar != null) {
                                            bVar.a("errorCode: 3302 errorMessage: tpl preload failed");
                                        }
                                        AnonymousClass2 r13 = AnonymousClass2.this;
                                        if (r13.f15291a == null) {
                                            r13.f15291a = new com.mbridge.msdk.foundation.same.report.d.c();
                                        }
                                        AnonymousClass2 r14 = AnonymousClass2.this;
                                        AnonymousClass2.this.f15291a.b((List<CampaignEx>) copyOnWriteArrayList3);
                                        AnonymousClass2.this.f15291a.a(bVar);
                                        c.a(a.this.f15280q, bVar, AnonymousClass2.this.f15291a);
                                    }
                                }
                            }, true);
                        }
                    });
                }
            }

            public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.c.b bVar) {
                a.this.f15270g = false;
                a aVar = a.this;
                a.a(aVar, aVar.f15282s, a.this.aa);
                if (a.this.f15280q != null && !a.this.f15273j) {
                    a.this.f15273j = true;
                    if (this.f15291a == null) {
                        this.f15291a = new com.mbridge.msdk.foundation.same.report.d.c();
                    }
                    this.f15291a.b((List<CampaignEx>) copyOnWriteArrayList);
                    if (bVar != null) {
                        bVar.a("errorCode: 3201 errorMessage: campaign resource download failed");
                    }
                    this.f15291a.a(bVar);
                    c.a(a.this.f15280q, bVar, this.f15291a);
                }
            }
        };
        boolean z7 = z4;
        AnonymousClass3 r02 = new b.i(campaignEx, copyOnWriteArrayList2, z7, nscpt) {

            /* renamed from: a  reason: collision with root package name */
            com.mbridge.msdk.foundation.same.report.d.c f15310a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CampaignEx f15311b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ CopyOnWriteArrayList f15312c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ boolean f15313d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f15314e;

            {
                this.f15311b = r2;
                this.f15312c = r3;
                this.f15313d = r4;
                this.f15314e = r5;
                this.f15310a = com.mbridge.msdk.foundation.same.report.d.d.a().b().get(r2.getLocalRequestId());
            }

            public final void a(String str, String str2, String str3, String str4) {
            }

            public final void a(String str, String str2, com.mbridge.msdk.foundation.c.b bVar) {
                String unitId = bVar == null ? "" : bVar.d().getUnitId();
                a aVar = a.this;
                a.a(aVar, unitId, aVar.aa);
                if (bVar != null) {
                    bVar.a("errorCode: 3202 errorMessage: temp resource download failed");
                }
                if (this.f15310a == null) {
                    this.f15310a = new com.mbridge.msdk.foundation.same.report.d.c();
                }
                this.f15310a.b((List<CampaignEx>) this.f15312c);
                this.f15310a.a(bVar);
                if (this.f15313d || a.this.f15280q == null) {
                    if (this.f15314e == 1 && !a.this.f15273j && a.this.f15280q != null) {
                        a.this.f15273j = true;
                        c.a(a.this.f15280q, bVar, this.f15310a);
                    }
                } else if (!a.this.f15273j) {
                    a.this.f15273j = true;
                    c.a(a.this.f15280q, bVar, this.f15310a);
                }
            }
        };
        boolean z8 = z7;
        int i6 = nscpt;
        boolean z9 = z6;
        AnonymousClass3 r12 = r02;
        com.mbridge.msdk.reward.adapter.b bVar2 = bVar;
        CampaignEx campaignEx2 = campaignEx;
        bVar2.a(context3, z8, i6, z9, i5, str, str2, requestId, copyOnWriteArrayList2, r11, r12);
        int i7 = i6;
        if (!isEmpty) {
            com.mbridge.msdk.reward.adapter.b a6 = com.mbridge.msdk.reward.adapter.b.a();
            CampaignEx campaignEx3 = campaignEx2;
            a6.a(this.f15275l, campaignEx3, this.f15285v, this.f15282s, campaignEx2.getRequestId(), new b.i(campaignEx3, copyOnWriteArrayList, cVar, z8, i7) {

                /* renamed from: a  reason: collision with root package name */
                com.mbridge.msdk.foundation.same.report.d.c f15316a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ CampaignEx f15317b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ CopyOnWriteArrayList f15318c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ com.mbridge.msdk.reward.adapter.c f15319d;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ boolean f15320e;

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ int f15321f;

                {
                    this.f15317b = r2;
                    this.f15318c = r3;
                    this.f15319d = r4;
                    this.f15320e = r5;
                    this.f15321f = r6;
                    this.f15316a = com.mbridge.msdk.foundation.same.report.d.d.a().b().get(r2.getLocalRequestId());
                }

                public final void a(final String str, final String str2, final String str3, String str4) {
                    a.this.f15271h = true;
                    if (a.this.f15270g && !a.this.f15272i && a.this.f15288y != null) {
                        a.this.f15272i = true;
                        a.this.f15288y.post(new Runnable() {
                            public final void run() {
                                com.mbridge.msdk.reward.adapter.b a5 = com.mbridge.msdk.reward.adapter.b.a();
                                boolean l4 = a.this.f15252I;
                                Handler k4 = a.this.f15288y;
                                boolean c5 = a.this.f15247D;
                                boolean e5 = a.this.f15248E;
                                String str = str3;
                                String requestIdNotice = AnonymousClass4.this.f15317b.getRequestIdNotice();
                                String str2 = str;
                                String str3 = str2;
                                String cMPTEntryUrl = AnonymousClass4.this.f15317b.getCMPTEntryUrl();
                                int m4 = a.this.f15289z;
                                AnonymousClass4 r12 = AnonymousClass4.this;
                                CampaignEx campaignEx = r12.f15317b;
                                CopyOnWriteArrayList copyOnWriteArrayList = r12.f15318c;
                                String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(AnonymousClass4.this.f15317b.getCMPTEntryUrl());
                                String str4 = str2;
                                com.mbridge.msdk.videocommon.d.c i4 = a.this.f15277n;
                                com.mbridge.msdk.reward.adapter.b bVar = a5;
                                com.mbridge.msdk.videocommon.d.c cVar = i4;
                                CampaignEx campaignEx2 = campaignEx;
                                CopyOnWriteArrayList copyOnWriteArrayList2 = copyOnWriteArrayList;
                                bVar.a(l4, k4, c5, e5, str, requestIdNotice, str2, str3, cMPTEntryUrl, m4, campaignEx2, copyOnWriteArrayList2, h5ResAddress, str4, cVar, new b.j() {
                                    public final void a(String str, String str2, String str3, String str4, String str5, a.C0208a aVar) {
                                        AnonymousClass4 r22 = AnonymousClass4.this;
                                        com.mbridge.msdk.reward.adapter.c cVar = r22.f15319d;
                                        if (cVar == null || !cVar.a((List<CampaignEx>) r22.f15318c, r22.f15320e, r22.f15321f)) {
                                            a aVar2 = a.this;
                                            a.a(aVar2, str3, aVar2.aa);
                                            if (a.this.f15280q != null && !a.this.f15273j) {
                                                a.this.f15273j = true;
                                                com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                                AnonymousClass4 r32 = AnonymousClass4.this;
                                                if (r32.f15316a == null) {
                                                    r32.f15316a = new com.mbridge.msdk.foundation.same.report.d.c();
                                                }
                                                AnonymousClass4 r33 = AnonymousClass4.this;
                                                r33.f15316a.b((List<CampaignEx>) r33.f15318c);
                                                AnonymousClass4.this.f15316a.a(b5);
                                                c.a(a.this.f15280q, b5, AnonymousClass4.this.f15316a);
                                            }
                                        } else if (a.this.f15280q != null && !a.this.f15274k) {
                                            a.this.f15274k = true;
                                            af.a("RewardVideoController", "Cache onVideoLoadSuccess");
                                            AnonymousClass4 r23 = AnonymousClass4.this;
                                            a.this.a((List<CampaignEx>) r23.f15318c);
                                            AnonymousClass4 r24 = AnonymousClass4.this;
                                            com.mbridge.msdk.foundation.same.report.d.c cVar2 = r24.f15316a;
                                            if (cVar2 != null) {
                                                cVar2.b((List<CampaignEx>) r24.f15318c);
                                            }
                                            a.this.f15280q.b(str2, str3, AnonymousClass4.this.f15316a);
                                        }
                                    }

                                    public final void a(String str, String str2, String str3, a.C0208a aVar, com.mbridge.msdk.foundation.c.b bVar) {
                                        AnonymousClass1 r12 = AnonymousClass1.this;
                                        a aVar2 = a.this;
                                        a.a(aVar2, str2, aVar2.aa);
                                        if (a.this.f15280q != null && !a.this.f15273j) {
                                            a.this.f15273j = true;
                                            if (bVar != null) {
                                                bVar.a("errorCode: 3303 errorMessage: tpl temp preload failed");
                                            }
                                            AnonymousClass4 r13 = AnonymousClass4.this;
                                            if (r13.f15316a == null) {
                                                r13.f15316a = new com.mbridge.msdk.foundation.same.report.d.c();
                                            }
                                            AnonymousClass4 r14 = AnonymousClass4.this;
                                            r14.f15316a.b((List<CampaignEx>) r14.f15318c);
                                            AnonymousClass4.this.f15316a.a(bVar);
                                            c.a(a.this.f15280q, bVar, AnonymousClass4.this.f15316a);
                                        }
                                    }
                                }, true);
                            }
                        });
                    }
                }

                public final void a(String str, String str2, com.mbridge.msdk.foundation.c.b bVar) {
                    String str3;
                    if (bVar != null) {
                        str3 = bVar.d().getUnitId();
                        bVar.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
                    } else {
                        str3 = "";
                    }
                    a aVar = a.this;
                    a.a(aVar, str3, aVar.aa);
                    if (this.f15316a == null) {
                        this.f15316a = new com.mbridge.msdk.foundation.same.report.d.c();
                    }
                    this.f15316a.a(bVar);
                    this.f15316a.b((List<CampaignEx>) this.f15318c);
                    a.this.f15271h = false;
                    if (a.this.f15280q != null && !a.this.f15273j) {
                        a.this.f15273j = true;
                        c.a(a.this.f15280q, bVar, this.f15316a);
                    }
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.Queue<java.lang.Integer> r12, boolean r13, java.lang.String r14, com.mbridge.msdk.foundation.same.report.d.c r15) {
        /*
            r11 = this;
            java.lang.String r1 = "RewardVideoController"
            r2 = 1
            java.lang.String r3 = "load mv api error:"
            r4 = 880020(0xd6d94, float:1.23317E-39)
            if (r12 == 0) goto L_0x0023
            int r0 = r12.size()     // Catch:{ Exception -> 0x001e }
            if (r0 <= 0) goto L_0x0023
            java.lang.Object r12 = r12.poll()     // Catch:{ Exception -> 0x001e }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ Exception -> 0x001e }
            if (r12 == 0) goto L_0x0023
            int r12 = r12.intValue()     // Catch:{ Exception -> 0x001e }
            r7 = r12
            goto L_0x0027
        L_0x001e:
            r0 = move-exception
            r12 = r0
            r5 = r11
            r10 = r15
            goto L_0x0064
        L_0x0023:
            r12 = 25
            r7 = 25
        L_0x0027:
            r6 = 1
            r5 = r11
            r8 = r13
            r9 = r14
            r10 = r15
            r5.a((int) r6, (int) r7, (boolean) r8, (java.lang.String) r9, (com.mbridge.msdk.foundation.same.report.d.c) r10)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0091
        L_0x0030:
            r0 = move-exception
            r12 = r0
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052 }
            r13.<init>()     // Catch:{ Exception -> 0x0052 }
            r13.append(r3)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r14 = r12.getMessage()     // Catch:{ Exception -> 0x0052 }
            r13.append(r14)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0052 }
            com.mbridge.msdk.foundation.c.b r13 = com.mbridge.msdk.foundation.c.a.b(r4, r13)     // Catch:{ Exception -> 0x0052 }
            if (r10 == 0) goto L_0x0055
            r10.a((com.mbridge.msdk.foundation.c.b) r13)     // Catch:{ Exception -> 0x0052 }
            r10.c((boolean) r2)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0055
        L_0x0052:
            r0 = move-exception
            r12 = r0
            goto L_0x0064
        L_0x0055:
            r11.a((com.mbridge.msdk.foundation.c.b) r13, (com.mbridge.msdk.foundation.same.report.d.c) r10)     // Catch:{ Exception -> 0x0052 }
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0052 }
            if (r13 == 0) goto L_0x0091
            java.lang.String r12 = r12.getMessage()     // Catch:{ Exception -> 0x0052 }
            com.mbridge.msdk.foundation.tools.af.b(r1, r12)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0091
        L_0x0064:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r3)
            java.lang.String r14 = r12.getMessage()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            com.mbridge.msdk.foundation.c.b r13 = com.mbridge.msdk.foundation.c.a.b(r4, r13)
            if (r10 == 0) goto L_0x0083
            r10.a((com.mbridge.msdk.foundation.c.b) r13)
            r10.c((boolean) r2)
        L_0x0083:
            r11.a((com.mbridge.msdk.foundation.c.b) r13, (com.mbridge.msdk.foundation.same.report.d.c) r10)
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r13 == 0) goto L_0x0091
            java.lang.String r12 = r12.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r12)
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(java.util.Queue, boolean, java.lang.String, com.mbridge.msdk.foundation.same.report.d.c):void");
    }

    /* access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f15280q != null) {
            this.f15265X = true;
            this.f15280q.a(bVar, cVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031 A[Catch:{ Exception -> 0x0011 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r9, int r10, boolean r11, java.lang.String r12, com.mbridge.msdk.foundation.same.report.d.c r13) {
        /*
            r8 = this;
            com.mbridge.msdk.reward.adapter.c r0 = r8.f15276m     // Catch:{ Exception -> 0x0011 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = r8.f15282s     // Catch:{ Exception -> 0x0011 }
            java.lang.String r0 = r0.a()     // Catch:{ Exception -> 0x0011 }
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x0011 }
            if (r0 != 0) goto L_0x002d
            goto L_0x0014
        L_0x0011:
            r0 = move-exception
            goto L_0x0082
        L_0x0014:
            com.mbridge.msdk.reward.adapter.c r0 = new com.mbridge.msdk.reward.adapter.c     // Catch:{ Exception -> 0x0011 }
            android.content.Context r2 = r8.f15275l     // Catch:{ Exception -> 0x0011 }
            java.lang.String r3 = r8.f15285v     // Catch:{ Exception -> 0x0011 }
            java.lang.String r4 = r8.f15282s     // Catch:{ Exception -> 0x0011 }
            r0.<init>(r2, r3, r4)     // Catch:{ Exception -> 0x0011 }
            r8.f15276m = r0     // Catch:{ Exception -> 0x0011 }
            boolean r2 = r8.f15247D     // Catch:{ Exception -> 0x0011 }
            r0.b((boolean) r2)     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.adapter.c r0 = r8.f15276m     // Catch:{ Exception -> 0x0011 }
            boolean r2 = r8.f15248E     // Catch:{ Exception -> 0x0011 }
            r0.c((boolean) r2)     // Catch:{ Exception -> 0x0011 }
        L_0x002d:
            boolean r0 = r8.f15247D     // Catch:{ Exception -> 0x0011 }
            if (r0 == 0) goto L_0x003c
            com.mbridge.msdk.reward.adapter.c r0 = r8.f15276m     // Catch:{ Exception -> 0x0011 }
            int r2 = r8.f15244A     // Catch:{ Exception -> 0x0011 }
            int r3 = r8.f15245B     // Catch:{ Exception -> 0x0011 }
            int r4 = r8.f15246C     // Catch:{ Exception -> 0x0011 }
            r0.a((int) r2, (int) r3, (int) r4)     // Catch:{ Exception -> 0x0011 }
        L_0x003c:
            com.mbridge.msdk.reward.adapter.c r0 = r8.f15276m     // Catch:{ Exception -> 0x0011 }
            int r2 = r8.f15289z     // Catch:{ Exception -> 0x0011 }
            r0.a((int) r2)     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.adapter.c r0 = r8.f15276m     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.videocommon.d.c r2 = r8.f15277n     // Catch:{ Exception -> 0x0011 }
            r0.a((com.mbridge.msdk.videocommon.d.c) r2)     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.b.a$a r0 = new com.mbridge.msdk.reward.b.a$a     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.adapter.c r2 = r8.f15276m     // Catch:{ Exception -> 0x0011 }
            r1 = r8
            r3 = r9
            r4 = r11
            r5 = r12
            r6 = r13
            r0.<init>(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0011 }
            r7 = r0
            r7.a(r10)     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.b.a$b r0 = new com.mbridge.msdk.reward.b.a$b     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.adapter.c r1 = r8.f15276m     // Catch:{ Exception -> 0x0011 }
            r0.<init>(r1, r11)     // Catch:{ Exception -> 0x0011 }
            r8.f15268a = r0     // Catch:{ Exception -> 0x0011 }
            r0.a(r7)     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.adapter.c r0 = r8.f15276m     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.b.a$b r1 = r8.f15268a     // Catch:{ Exception -> 0x0011 }
            r0.a((com.mbridge.msdk.reward.adapter.a) r1)     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.adapter.c r0 = r8.f15276m     // Catch:{ Exception -> 0x0011 }
            boolean r5 = r8.f15252I     // Catch:{ Exception -> 0x0011 }
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r6 = r13
            r0.a((int) r1, (int) r2, (boolean) r3, (java.lang.String) r4, (boolean) r5, (com.mbridge.msdk.foundation.same.report.d.c) r6)     // Catch:{ Exception -> 0x0011 }
            android.os.Handler r0 = r8.f15288y     // Catch:{ Exception -> 0x0011 }
            int r1 = r10 * 1000
            long r1 = (long) r1     // Catch:{ Exception -> 0x0011 }
            r0.postDelayed(r7, r1)     // Catch:{ Exception -> 0x0011 }
            return
        L_0x0082:
            r1 = 880020(0xd6d94, float:1.23317E-39)
            java.lang.String r2 = r0.getMessage()
            com.mbridge.msdk.foundation.c.b r1 = com.mbridge.msdk.foundation.c.a.b(r1, r2)
            if (r13 == 0) goto L_0x0096
            r13.a((com.mbridge.msdk.foundation.c.b) r1)
            r2 = 1
            r13.c((boolean) r2)
        L_0x0096:
            r8.a((com.mbridge.msdk.foundation.c.b) r1, (com.mbridge.msdk.foundation.same.report.d.c) r13)
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x00a6
            java.lang.String r1 = "RewardVideoController"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r0)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(int, int, boolean, java.lang.String, com.mbridge.msdk.foundation.same.report.d.c):void");
    }

    private void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        com.mbridge.msdk.videocommon.d.c cVar2;
        com.mbridge.msdk.videocommon.d.c cVar3;
        boolean z4;
        boolean z5;
        try {
            if (this.f15276m == null) {
                r();
            }
            if (this.f15276m != null) {
                af.b("RewardVideoController", "controller 819");
                if (this.f15248E) {
                    z4 = e(false);
                } else {
                    z4 = this.f15276m.b();
                }
                if (z4) {
                    af.c("RewardVideoController", "invoke adapter show isReady");
                    d dVar = new d(this, this.f15288y);
                    f15243f.put(this.f15282s, dVar);
                    this.f15276m.a((com.mbridge.msdk.video.bt.module.b.h) dVar, str, this.f15281r, this.f15289z, this.f15284u, cVar);
                    this.f15269c = false;
                    return;
                }
                if (this.f15248E) {
                    if (this.f15276m == null) {
                        r();
                    }
                    List<com.mbridge.msdk.foundation.entity.c> a5 = com.mbridge.msdk.videocommon.a.a.a().a(this.f15282s);
                    if (a5 != null && a5.size() > 0) {
                        Iterator<com.mbridge.msdk.foundation.entity.c> it = a5.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            com.mbridge.msdk.foundation.entity.c next = it.next();
                            if (next != null) {
                                this.f15276m.a(next.a());
                                this.f15276m.f15157d = next.d();
                                if (this.f15276m.c()) {
                                    z5 = true;
                                    break;
                                }
                                com.mbridge.msdk.videocommon.a.a.a().c(this.f15282s, next.a());
                            }
                        }
                    }
                    z5 = false;
                } else {
                    z5 = this.f15276m.c();
                }
                if (z5) {
                    af.c("RewardVideoController", "invoke adapter show isSpareOfferReady");
                    d dVar2 = new d(this, this.f15288y);
                    f15243f.put(this.f15282s, dVar2);
                    this.f15276m.a((com.mbridge.msdk.video.bt.module.b.h) dVar2, str, this.f15281r, this.f15289z, this.f15284u, cVar);
                    this.f15269c = false;
                    return;
                }
            }
            this.f15269c = false;
            a("2000131", cVar, this.f15279p, "can't show because load is failed");
            if (this.f15279p != null) {
                try {
                    this.f15279p.onShowFail(cVar, this.f15283t, "can't show because load is failed");
                } catch (Exception e5) {
                    Exception exc = e5;
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoController", exc.getMessage());
                    }
                }
            }
            if (!this.f15247D && !this.f15248E && (cVar3 = this.f15277n) != null && cVar3.s(4) && this.f15280q != null && this.f15280q.f15343c.get() != 1 && this.f15280q.f15343c.get() != 3) {
                a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 94, this.f15282s, true, 1));
            }
        } catch (Exception e6) {
            Exception exc2 = e6;
            this.f15269c = false;
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoController", exc2.getLocalizedMessage());
            }
            a("2000131", cVar, this.f15279p, "show exception");
            if (this.f15279p != null) {
                try {
                    this.f15279p.onShowFail(cVar, this.f15283t, "show exception");
                } catch (Exception unused) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoController", exc2.getMessage());
                    }
                }
            }
            if (!this.f15247D && !this.f15248E && (cVar2 = this.f15277n) != null && cVar2.s(4) && this.f15280q != null && this.f15280q.f15343c.get() != 1 && this.f15280q.f15343c.get() != 3) {
                a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 94, this.f15282s, true, 1));
            }
        }
    }

    private boolean a(List<com.mbridge.msdk.foundation.entity.c> list, String str) {
        if (list == null) {
            return false;
        }
        for (com.mbridge.msdk.foundation.entity.c next : list) {
            if (next != null && str.equals(next.b())) {
                this.f15276m.a(next.a());
                this.f15276m.f15157d = next.d();
                if (this.f15276m.b()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x015a, code lost:
        if (r11.f15248E != false) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x015c, code lost:
        r12 = r11.f15277n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x015e, code lost:
        if (r12 == null) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0164, code lost:
        if (r12.s(4) == false) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0168, code lost:
        if (r11.f15280q == null) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0170, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.f15280q) == 1) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0178, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.f15280q) == 3) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x017a, code lost:
        a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 94, r11.f15282s, true, 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x018c, code lost:
        r11.f15269c = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0196, code lost:
        if (android.text.TextUtils.isEmpty(r11.f15281r) == false) goto L_0x019e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0198, code lost:
        r11.f15281r = com.mbridge.msdk.foundation.tools.f.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        r13 = new java.text.SimpleDateFormat("dd").format(new java.util.Date());
        r14 = (java.lang.String) com.mbridge.msdk.foundation.tools.an.a(r11.f15275l, "reward_date", "0");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01be, code lost:
        if (android.text.TextUtils.isEmpty(r14) != false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01c4, code lost:
        if (android.text.TextUtils.isEmpty(r13) != false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01ca, code lost:
        if (r14.equals(r13) != false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01cc, code lost:
        com.mbridge.msdk.foundation.tools.an.b(r11.f15275l, "reward_date", r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01d4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01d5, code lost:
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01d8, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01da, code lost:
        com.mbridge.msdk.foundation.tools.af.b("RewardVideoController", r13.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01e3, code lost:
        a(r12, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r13 = r11.f15275l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        if (r13 != null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        a("2000131", r15, r11.f15279p, "context is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        if (r11.f15279p == null) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r11.f15279p.onShowFail(r15, r11.f15283t, "context is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0060, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0061, code lost:
        r12 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0064, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0066, code lost:
        com.mbridge.msdk.foundation.tools.af.b("RewardVideoController", r12.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0076, code lost:
        if (r11.f15247D != false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007a, code lost:
        if (r11.f15248E != false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007c, code lost:
        r12 = r11.f15277n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x007e, code lost:
        if (r12 == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0084, code lost:
        if (r12.s(4) == false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0088, code lost:
        if (r11.f15280q == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0090, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.f15280q) == 1) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0098, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.f15280q) == 3) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009a, code lost:
        a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 94, r11.f15282s, true, 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ac, code lost:
        r11.f15269c = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b2, code lost:
        if (r11.f15247D == false) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b8, code lost:
        if (com.mbridge.msdk.foundation.tools.ak.l(r13) != false) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c4, code lost:
        if (com.mbridge.msdk.foundation.tools.ah.a().a("s_a_w_n_c", true) == false) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c6, code lost:
        a("2000131", r15, r11.f15279p, "network exception");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d1, code lost:
        if (r11.f15279p == null) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r11.f15279p.onShowFail(r15, r11.f15283t, "network exception");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00dd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00de, code lost:
        r12 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e1, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00e3, code lost:
        com.mbridge.msdk.foundation.tools.af.b("RewardVideoController", r12.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00ee, code lost:
        if (r11.f15247D != false) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00f2, code lost:
        if (r11.f15248E != false) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f4, code lost:
        r12 = r11.f15277n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00f6, code lost:
        if (r12 == null) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00fc, code lost:
        if (r12.s(4) == false) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0100, code lost:
        if (r11.f15280q == null) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0108, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.f15280q) == 1) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0110, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.f15280q) == 3) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0112, code lost:
        a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 94, r11.f15282s, true, 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0124, code lost:
        r11.f15269c = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x012c, code lost:
        if (s() == false) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x012e, code lost:
        a("2000131", r15, r11.f15279p, "Play more than limit");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0139, code lost:
        if (r11.f15279p == null) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        r11.f15279p.onShowFail(r15, r11.f15283t, "Play more than limit");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0145, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0146, code lost:
        r12 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0149, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x014b, code lost:
        com.mbridge.msdk.foundation.tools.af.b("RewardVideoController", r12.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0156, code lost:
        if (r11.f15247D != false) goto L_0x018c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r12, java.lang.String r13, java.lang.String r14, com.mbridge.msdk.foundation.same.report.d.e r15) {
        /*
            r11 = this;
            com.mbridge.msdk.foundation.same.report.d.c r15 = r11.a((com.mbridge.msdk.foundation.same.report.d.e) r15)
            r1 = 3
            r2 = 4
            r3 = 1
            r4 = 0
            r11.f15286w = r12     // Catch:{ Exception -> 0x0070 }
            r11.f15281r = r13     // Catch:{ Exception -> 0x0070 }
            r11.f15284u = r14     // Catch:{ Exception -> 0x0070 }
            java.lang.Object r13 = r11.f15255L     // Catch:{ Exception -> 0x0070 }
            monitor-enter(r13)     // Catch:{ Exception -> 0x0070 }
            boolean r14 = r11.f15269c     // Catch:{ all -> 0x002c }
            if (r14 == 0) goto L_0x0042
            java.lang.String r12 = "2000131"
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r14 = r11.f15279p     // Catch:{ all -> 0x002c }
            java.lang.String r0 = "campaing is show progressing "
            r11.a((java.lang.String) r12, (com.mbridge.msdk.foundation.same.report.d.c) r15, (com.mbridge.msdk.videocommon.listener.InterVideoOutListener) r14, (java.lang.String) r0)     // Catch:{ all -> 0x002c }
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f15279p     // Catch:{ all -> 0x002c }
            if (r12 == 0) goto L_0x003f
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f15279p     // Catch:{ Exception -> 0x0030 }
            com.mbridge.msdk.out.MBridgeIds r14 = r11.f15283t     // Catch:{ Exception -> 0x0030 }
            java.lang.String r0 = "campaing is show progressing "
            r12.onShowFail(r15, r14, r0)     // Catch:{ Exception -> 0x0030 }
            goto L_0x003f
        L_0x002c:
            r0 = move-exception
            r12 = r0
            goto L_0x01e7
        L_0x0030:
            r0 = move-exception
            r12 = r0
            boolean r14 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x002c }
            if (r14 == 0) goto L_0x003f
            java.lang.String r14 = "RewardVideoController"
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x002c }
            com.mbridge.msdk.foundation.tools.af.b(r14, r12)     // Catch:{ all -> 0x002c }
        L_0x003f:
            monitor-exit(r13)     // Catch:{ all -> 0x002c }
            goto L_0x0255
        L_0x0042:
            r11.f15269c = r3     // Catch:{ all -> 0x002c }
            monitor-exit(r13)     // Catch:{ all -> 0x002c }
            android.content.Context r13 = r11.f15275l     // Catch:{ Exception -> 0x0070 }
            if (r13 != 0) goto L_0x00b0
            java.lang.String r12 = "2000131"
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r13 = r11.f15279p     // Catch:{ Exception -> 0x0070 }
            java.lang.String r14 = "context is null"
            r11.a((java.lang.String) r12, (com.mbridge.msdk.foundation.same.report.d.c) r15, (com.mbridge.msdk.videocommon.listener.InterVideoOutListener) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f15279p     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x0074
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f15279p     // Catch:{ Exception -> 0x0060 }
            com.mbridge.msdk.out.MBridgeIds r13 = r11.f15283t     // Catch:{ Exception -> 0x0060 }
            java.lang.String r14 = "context is null"
            r12.onShowFail(r15, r13, r14)     // Catch:{ Exception -> 0x0060 }
            goto L_0x0074
        L_0x0060:
            r0 = move-exception
            r12 = r0
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0070 }
            if (r13 == 0) goto L_0x0074
            java.lang.String r13 = "RewardVideoController"
            java.lang.String r12 = r12.getMessage()     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.foundation.tools.af.b(r13, r12)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r0 = move-exception
            r12 = r0
            goto L_0x01e9
        L_0x0074:
            boolean r12 = r11.f15247D     // Catch:{ Exception -> 0x0070 }
            if (r12 != 0) goto L_0x00ac
            boolean r12 = r11.f15248E     // Catch:{ Exception -> 0x0070 }
            if (r12 != 0) goto L_0x00ac
            com.mbridge.msdk.videocommon.d.c r12 = r11.f15277n     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x00ac
            boolean r12 = r12.s(r2)     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x00ac
            com.mbridge.msdk.reward.b.a$c r12 = r11.f15280q     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x00ac
            com.mbridge.msdk.reward.b.a$c r12 = r11.f15280q     // Catch:{ Exception -> 0x0070 }
            int r12 = r12.f15343c.get()     // Catch:{ Exception -> 0x0070 }
            if (r12 == r3) goto L_0x00ac
            com.mbridge.msdk.reward.b.a$c r12 = r11.f15280q     // Catch:{ Exception -> 0x0070 }
            int r12 = r12.f15343c.get()     // Catch:{ Exception -> 0x0070 }
            if (r12 == r1) goto L_0x00ac
            com.mbridge.msdk.foundation.same.report.d.d r5 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0070 }
            java.lang.String r8 = r11.f15282s     // Catch:{ Exception -> 0x0070 }
            r9 = 1
            r10 = 1
            r6 = 0
            r7 = 94
            com.mbridge.msdk.foundation.same.report.d.e r12 = r5.a((int) r6, (int) r7, (java.lang.String) r8, (boolean) r9, (int) r10)     // Catch:{ Exception -> 0x0070 }
            r11.a((boolean) r4, (com.mbridge.msdk.foundation.same.report.d.e) r12)     // Catch:{ Exception -> 0x0070 }
        L_0x00ac:
            r11.f15269c = r4     // Catch:{ Exception -> 0x0070 }
            goto L_0x0255
        L_0x00b0:
            boolean r14 = r11.f15247D     // Catch:{ Exception -> 0x0070 }
            if (r14 == 0) goto L_0x0128
            boolean r13 = com.mbridge.msdk.foundation.tools.ak.l((android.content.Context) r13)     // Catch:{ Exception -> 0x0070 }
            if (r13 != 0) goto L_0x0128
            com.mbridge.msdk.foundation.tools.ah r13 = com.mbridge.msdk.foundation.tools.ah.a()     // Catch:{ Exception -> 0x0070 }
            java.lang.String r14 = "s_a_w_n_c"
            boolean r13 = r13.a((java.lang.String) r14, (boolean) r3)     // Catch:{ Exception -> 0x0070 }
            if (r13 == 0) goto L_0x0128
            java.lang.String r12 = "2000131"
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r13 = r11.f15279p     // Catch:{ Exception -> 0x0070 }
            java.lang.String r14 = "network exception"
            r11.a((java.lang.String) r12, (com.mbridge.msdk.foundation.same.report.d.c) r15, (com.mbridge.msdk.videocommon.listener.InterVideoOutListener) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f15279p     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x00ec
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f15279p     // Catch:{ Exception -> 0x00dd }
            com.mbridge.msdk.out.MBridgeIds r13 = r11.f15283t     // Catch:{ Exception -> 0x00dd }
            java.lang.String r14 = "network exception"
            r12.onShowFail(r15, r13, r14)     // Catch:{ Exception -> 0x00dd }
            goto L_0x00ec
        L_0x00dd:
            r0 = move-exception
            r12 = r0
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0070 }
            if (r13 == 0) goto L_0x00ec
            java.lang.String r13 = "RewardVideoController"
            java.lang.String r12 = r12.getMessage()     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.foundation.tools.af.b(r13, r12)     // Catch:{ Exception -> 0x0070 }
        L_0x00ec:
            boolean r12 = r11.f15247D     // Catch:{ Exception -> 0x0070 }
            if (r12 != 0) goto L_0x0124
            boolean r12 = r11.f15248E     // Catch:{ Exception -> 0x0070 }
            if (r12 != 0) goto L_0x0124
            com.mbridge.msdk.videocommon.d.c r12 = r11.f15277n     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x0124
            boolean r12 = r12.s(r2)     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x0124
            com.mbridge.msdk.reward.b.a$c r12 = r11.f15280q     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x0124
            com.mbridge.msdk.reward.b.a$c r12 = r11.f15280q     // Catch:{ Exception -> 0x0070 }
            int r12 = r12.f15343c.get()     // Catch:{ Exception -> 0x0070 }
            if (r12 == r3) goto L_0x0124
            com.mbridge.msdk.reward.b.a$c r12 = r11.f15280q     // Catch:{ Exception -> 0x0070 }
            int r12 = r12.f15343c.get()     // Catch:{ Exception -> 0x0070 }
            if (r12 == r1) goto L_0x0124
            com.mbridge.msdk.foundation.same.report.d.d r5 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0070 }
            java.lang.String r8 = r11.f15282s     // Catch:{ Exception -> 0x0070 }
            r9 = 1
            r10 = 1
            r6 = 0
            r7 = 94
            com.mbridge.msdk.foundation.same.report.d.e r12 = r5.a((int) r6, (int) r7, (java.lang.String) r8, (boolean) r9, (int) r10)     // Catch:{ Exception -> 0x0070 }
            r11.a((boolean) r4, (com.mbridge.msdk.foundation.same.report.d.e) r12)     // Catch:{ Exception -> 0x0070 }
        L_0x0124:
            r11.f15269c = r4     // Catch:{ Exception -> 0x0070 }
            goto L_0x0255
        L_0x0128:
            boolean r13 = r11.s()     // Catch:{ Exception -> 0x0070 }
            if (r13 == 0) goto L_0x0190
            java.lang.String r12 = "2000131"
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r13 = r11.f15279p     // Catch:{ Exception -> 0x0070 }
            java.lang.String r14 = "Play more than limit"
            r11.a((java.lang.String) r12, (com.mbridge.msdk.foundation.same.report.d.c) r15, (com.mbridge.msdk.videocommon.listener.InterVideoOutListener) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f15279p     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x0154
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f15279p     // Catch:{ Exception -> 0x0145 }
            com.mbridge.msdk.out.MBridgeIds r13 = r11.f15283t     // Catch:{ Exception -> 0x0145 }
            java.lang.String r14 = "Play more than limit"
            r12.onShowFail(r15, r13, r14)     // Catch:{ Exception -> 0x0145 }
            goto L_0x0154
        L_0x0145:
            r0 = move-exception
            r12 = r0
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0070 }
            if (r13 == 0) goto L_0x0154
            java.lang.String r13 = "RewardVideoController"
            java.lang.String r12 = r12.getMessage()     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.foundation.tools.af.b(r13, r12)     // Catch:{ Exception -> 0x0070 }
        L_0x0154:
            boolean r12 = r11.f15247D     // Catch:{ Exception -> 0x0070 }
            if (r12 != 0) goto L_0x018c
            boolean r12 = r11.f15248E     // Catch:{ Exception -> 0x0070 }
            if (r12 != 0) goto L_0x018c
            com.mbridge.msdk.videocommon.d.c r12 = r11.f15277n     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x018c
            boolean r12 = r12.s(r2)     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x018c
            com.mbridge.msdk.reward.b.a$c r12 = r11.f15280q     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x018c
            com.mbridge.msdk.reward.b.a$c r12 = r11.f15280q     // Catch:{ Exception -> 0x0070 }
            int r12 = r12.f15343c.get()     // Catch:{ Exception -> 0x0070 }
            if (r12 == r3) goto L_0x018c
            com.mbridge.msdk.reward.b.a$c r12 = r11.f15280q     // Catch:{ Exception -> 0x0070 }
            int r12 = r12.f15343c.get()     // Catch:{ Exception -> 0x0070 }
            if (r12 == r1) goto L_0x018c
            com.mbridge.msdk.foundation.same.report.d.d r5 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0070 }
            java.lang.String r8 = r11.f15282s     // Catch:{ Exception -> 0x0070 }
            r9 = 1
            r10 = 1
            r6 = 0
            r7 = 94
            com.mbridge.msdk.foundation.same.report.d.e r12 = r5.a((int) r6, (int) r7, (java.lang.String) r8, (boolean) r9, (int) r10)     // Catch:{ Exception -> 0x0070 }
            r11.a((boolean) r4, (com.mbridge.msdk.foundation.same.report.d.e) r12)     // Catch:{ Exception -> 0x0070 }
        L_0x018c:
            r11.f15269c = r4     // Catch:{ Exception -> 0x0070 }
            goto L_0x0255
        L_0x0190:
            java.lang.String r13 = r11.f15281r     // Catch:{ Exception -> 0x0070 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0070 }
            if (r13 == 0) goto L_0x019e
            java.lang.String r13 = com.mbridge.msdk.foundation.tools.f.c()     // Catch:{ Exception -> 0x0070 }
            r11.f15281r = r13     // Catch:{ Exception -> 0x0070 }
        L_0x019e:
            java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01d4 }
            java.lang.String r14 = "dd"
            r13.<init>(r14)     // Catch:{ Exception -> 0x01d4 }
            java.util.Date r14 = new java.util.Date     // Catch:{ Exception -> 0x01d4 }
            r14.<init>()     // Catch:{ Exception -> 0x01d4 }
            java.lang.String r13 = r13.format(r14)     // Catch:{ Exception -> 0x01d4 }
            android.content.Context r14 = r11.f15275l     // Catch:{ Exception -> 0x01d4 }
            java.lang.String r0 = "reward_date"
            java.lang.String r5 = "0"
            java.lang.Object r14 = com.mbridge.msdk.foundation.tools.an.a(r14, r0, r5)     // Catch:{ Exception -> 0x01d4 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x01d4 }
            boolean r0 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x01d4 }
            if (r0 != 0) goto L_0x01e3
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x01d4 }
            if (r0 != 0) goto L_0x01e3
            boolean r14 = r14.equals(r13)     // Catch:{ Exception -> 0x01d4 }
            if (r14 != 0) goto L_0x01e3
            android.content.Context r14 = r11.f15275l     // Catch:{ Exception -> 0x01d4 }
            java.lang.String r0 = "reward_date"
            com.mbridge.msdk.foundation.tools.an.b(r14, r0, r13)     // Catch:{ Exception -> 0x01d4 }
            goto L_0x01e3
        L_0x01d4:
            r0 = move-exception
            r13 = r0
            boolean r14 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0070 }
            if (r14 == 0) goto L_0x01e3
            java.lang.String r14 = "RewardVideoController"
            java.lang.String r13 = r13.getMessage()     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.foundation.tools.af.b(r14, r13)     // Catch:{ Exception -> 0x0070 }
        L_0x01e3:
            r11.a((java.lang.String) r12, (com.mbridge.msdk.foundation.same.report.d.c) r15)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0255
        L_0x01e7:
            monitor-exit(r13)     // Catch:{ all -> 0x002c }
            throw r12     // Catch:{ Exception -> 0x0070 }
        L_0x01e9:
            r11.f15269c = r4
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r13 == 0) goto L_0x01f8
            java.lang.String r13 = "RewardVideoController"
            java.lang.String r14 = r12.getLocalizedMessage()
            com.mbridge.msdk.foundation.tools.af.b(r13, r14)
        L_0x01f8:
            java.lang.String r13 = "2000131"
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r14 = r11.f15279p
            java.lang.String r0 = "show exception"
            r11.a((java.lang.String) r13, (com.mbridge.msdk.foundation.same.report.d.c) r15, (com.mbridge.msdk.videocommon.listener.InterVideoOutListener) r14, (java.lang.String) r0)
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r13 = r11.f15279p
            if (r13 == 0) goto L_0x021d
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r13 = r11.f15279p     // Catch:{ Exception -> 0x020f }
            com.mbridge.msdk.out.MBridgeIds r14 = r11.f15283t     // Catch:{ Exception -> 0x020f }
            java.lang.String r0 = "show exception"
            r13.onShowFail(r15, r14, r0)     // Catch:{ Exception -> 0x020f }
            goto L_0x021d
        L_0x020f:
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r13 == 0) goto L_0x021d
            java.lang.String r13 = "RewardVideoController"
            java.lang.String r12 = r12.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r13, r12)
        L_0x021d:
            boolean r12 = r11.f15247D
            if (r12 != 0) goto L_0x0255
            boolean r12 = r11.f15248E
            if (r12 != 0) goto L_0x0255
            com.mbridge.msdk.videocommon.d.c r12 = r11.f15277n
            if (r12 == 0) goto L_0x0255
            boolean r12 = r12.s(r2)
            if (r12 == 0) goto L_0x0255
            com.mbridge.msdk.reward.b.a$c r12 = r11.f15280q
            if (r12 == 0) goto L_0x0255
            com.mbridge.msdk.reward.b.a$c r12 = r11.f15280q
            int r12 = r12.f15343c.get()
            if (r12 == r3) goto L_0x0255
            com.mbridge.msdk.reward.b.a$c r12 = r11.f15280q
            int r12 = r12.f15343c.get()
            if (r12 == r1) goto L_0x0255
            com.mbridge.msdk.foundation.same.report.d.d r5 = com.mbridge.msdk.foundation.same.report.d.d.a()
            java.lang.String r8 = r11.f15282s
            r9 = 1
            r10 = 1
            r6 = 0
            r7 = 94
            com.mbridge.msdk.foundation.same.report.d.e r12 = r5.a((int) r6, (int) r7, (java.lang.String) r8, (boolean) r9, (int) r10)
            r11.a((boolean) r4, (com.mbridge.msdk.foundation.same.report.d.e) r12)
        L_0x0255:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(java.lang.String, java.lang.String, java.lang.String, com.mbridge.msdk.foundation.same.report.d.e):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.foundation.same.report.d.c a(com.mbridge.msdk.foundation.same.report.d.e r7) {
        /*
            r6 = this;
            r0 = 0
            com.mbridge.msdk.videocommon.download.b r1 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r2 = r6.f15282s     // Catch:{ Exception -> 0x0023 }
            java.util.concurrent.CopyOnWriteArrayList r1 = r1.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0025
            int r3 = r1.size()     // Catch:{ Exception -> 0x0023 }
            if (r3 <= 0) goto L_0x0025
            r3 = 0
            java.lang.Object r3 = r1.get(r3)     // Catch:{ Exception -> 0x0023 }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3     // Catch:{ Exception -> 0x0023 }
            if (r3 == 0) goto L_0x0025
            java.lang.String r2 = r3.getCurrentLocalRid()     // Catch:{ Exception -> 0x0023 }
            goto L_0x0025
        L_0x0023:
            r7 = move-exception
            goto L_0x0096
        L_0x0025:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0023 }
            if (r3 != 0) goto L_0x003a
            com.mbridge.msdk.foundation.same.report.d.d r3 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0023 }
            java.util.LinkedHashMap r3 = r3.b()     // Catch:{ Exception -> 0x0023 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ Exception -> 0x0023 }
            com.mbridge.msdk.foundation.same.report.d.c r3 = (com.mbridge.msdk.foundation.same.report.d.c) r3     // Catch:{ Exception -> 0x0023 }
            r0 = r3
        L_0x003a:
            java.lang.String r3 = "2000128"
            if (r0 == 0) goto L_0x0054
            r0.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r1)     // Catch:{ Exception -> 0x0023 }
            r0.a(r3, r7)     // Catch:{ Exception -> 0x0023 }
            r0.c((java.lang.String) r2)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r7 = r6.f15282s     // Catch:{ Exception -> 0x0023 }
            r0.d((java.lang.String) r7)     // Catch:{ Exception -> 0x0023 }
            com.mbridge.msdk.reward.c.a.a r7 = com.mbridge.msdk.reward.c.a.a.a()     // Catch:{ Exception -> 0x0023 }
            r7.a(r3, r0)     // Catch:{ Exception -> 0x0023 }
            return r0
        L_0x0054:
            com.mbridge.msdk.foundation.same.report.d.c r4 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x0023 }
            r4.<init>()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r0 = r6.f15282s     // Catch:{ Exception -> 0x007a }
            r4.d((java.lang.String) r0)     // Catch:{ Exception -> 0x007a }
            java.lang.String r0 = "metrics_data_reason"
            java.lang.String r5 = "未获取到待展示的campaign信息 本地new metricsData"
            r7.a(r0, r5)     // Catch:{ Exception -> 0x007a }
            r4.a(r3, r7)     // Catch:{ Exception -> 0x007a }
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x007a }
            if (r7 == 0) goto L_0x007d
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.ak.d()     // Catch:{ Exception -> 0x007a }
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r7)     // Catch:{ Exception -> 0x007a }
            r4.c((java.lang.String) r7)     // Catch:{ Exception -> 0x007a }
            goto L_0x008e
        L_0x007a:
            r7 = move-exception
            r0 = r4
            goto L_0x0096
        L_0x007d:
            r4.c((java.lang.String) r2)     // Catch:{ Exception -> 0x007a }
            r4.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r1)     // Catch:{ Exception -> 0x007a }
            com.mbridge.msdk.foundation.same.report.d.d r7 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x007a }
            java.util.LinkedHashMap r7 = r7.b()     // Catch:{ Exception -> 0x007a }
            r7.put(r2, r4)     // Catch:{ Exception -> 0x007a }
        L_0x008e:
            com.mbridge.msdk.reward.c.a.a r7 = com.mbridge.msdk.reward.c.a.a.a()     // Catch:{ Exception -> 0x007a }
            r7.a(r3, r4)     // Catch:{ Exception -> 0x007a }
            return r4
        L_0x0096:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x00a3
            java.lang.String r1 = "RewardVideoController"
            java.lang.String r7 = r7.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r7)
        L_0x00a3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(com.mbridge.msdk.foundation.same.report.d.e):com.mbridge.msdk.foundation.same.report.d.c");
    }

    public final void a(List<CampaignEx> list) {
        if (list != null && list.size() > 0) {
            this.f15256M = list;
        }
    }

    private String a(String str) {
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                str2 = SameMD5.getMD5(ak.d());
            }
            String[] split = str.split("_");
            if (split != null && split.length >= 3) {
                str2 = split[2];
            }
            return TextUtils.isEmpty(str2) ? SameMD5.getMD5(ak.d()) : str2;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            return str2;
        }
    }

    public final com.mbridge.msdk.foundation.same.report.d.c a(Message message) {
        com.mbridge.msdk.foundation.same.report.d.c cVar = null;
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    cVar = com.mbridge.msdk.foundation.same.report.d.d.a().a(data.getString("metrics_data_lrid"), "");
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
        return cVar == null ? new com.mbridge.msdk.foundation.same.report.d.c() : cVar;
    }

    /* access modifiers changed from: private */
    public void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar, InterVideoOutListener interVideoOutListener, String str2) {
        if (cVar == null) {
            try {
                cVar = new com.mbridge.msdk.foundation.same.report.d.c();
                cVar.b(this.f15256M);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                    return;
                }
                return;
            }
        }
        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
        if (!TextUtils.isEmpty(str2)) {
            eVar.a("reason", str2);
        }
        if (interVideoOutListener != null) {
            eVar.a("listener_state", 1);
        } else {
            eVar.a("listener_state", 2);
        }
        cVar.a(str, eVar);
        com.mbridge.msdk.reward.c.a.a.a().a(str, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f A[Catch:{ Exception -> 0x002b }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040 A[Catch:{ Exception -> 0x002b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.foundation.same.report.d.c a(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r5, com.mbridge.msdk.foundation.same.report.d.c r6) {
        /*
            r4 = this;
            com.mbridge.msdk.foundation.same.report.d.c r0 = new com.mbridge.msdk.foundation.same.report.d.c
            r0.<init>()
            java.lang.String r1 = ""
            if (r5 == 0) goto L_0x0038
            int r2 = r5.size()     // Catch:{ Exception -> 0x002b }
            if (r2 <= 0) goto L_0x0038
            r2 = 0
            java.lang.Object r3 = r5.get(r2)     // Catch:{ Exception -> 0x002b }
            if (r3 == 0) goto L_0x002e
            java.lang.Object r1 = r5.get(r2)     // Catch:{ Exception -> 0x002b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch:{ Exception -> 0x002b }
            java.lang.String r1 = r1.getLocalRequestId()     // Catch:{ Exception -> 0x002b }
            java.lang.Object r2 = r5.get(r2)     // Catch:{ Exception -> 0x002b }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = r2.getNLRid()     // Catch:{ Exception -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r5 = move-exception
            goto L_0x00a2
        L_0x002e:
            r2 = r1
        L_0x002f:
            r0.c((java.lang.String) r1)     // Catch:{ Exception -> 0x002b }
            r0.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r5)     // Catch:{ Exception -> 0x002b }
            r5 = r1
            r1 = r2
            goto L_0x0039
        L_0x0038:
            r5 = r1
        L_0x0039:
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x002b }
            if (r1 == 0) goto L_0x0040
            return r6
        L_0x0040:
            com.mbridge.msdk.foundation.same.report.d.e r6 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x002b }
            r6.<init>()     // Catch:{ Exception -> 0x002b }
            java.lang.String r1 = "cache"
            r2 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x002b }
            r6.a(r1, r3)     // Catch:{ Exception -> 0x002b }
            java.lang.String r1 = "hb"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x002b }
            r6.a(r1, r2)     // Catch:{ Exception -> 0x002b }
            java.lang.String r1 = "auto_load"
            r2 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x002b }
            r6.a(r1, r2)     // Catch:{ Exception -> 0x002b }
            java.lang.String r1 = "2000127"
            r0.a(r1, r6)     // Catch:{ Exception -> 0x002b }
            java.lang.String r1 = "2000048"
            r0.a(r1, r6)     // Catch:{ Exception -> 0x002b }
            boolean r6 = r4.f15247D     // Catch:{ Exception -> 0x002b }
            if (r6 == 0) goto L_0x0073
            r6 = 287(0x11f, float:4.02E-43)
            goto L_0x0075
        L_0x0073:
            r6 = 94
        L_0x0075:
            r0.b((int) r6)     // Catch:{ Exception -> 0x002b }
            java.lang.String r6 = "1"
            r0.i(r6)     // Catch:{ Exception -> 0x002b }
            java.lang.String r6 = "2"
            r0.b((java.lang.String) r6)     // Catch:{ Exception -> 0x002b }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x002b }
            if (r6 != 0) goto L_0x00a9
            com.mbridge.msdk.foundation.same.report.d.d r6 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x002b }
            java.util.LinkedHashMap r6 = r6.b()     // Catch:{ Exception -> 0x002b }
            boolean r6 = r6.containsKey(r5)     // Catch:{ Exception -> 0x002b }
            if (r6 != 0) goto L_0x00a9
            com.mbridge.msdk.foundation.same.report.d.d r6 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x002b }
            java.util.LinkedHashMap r6 = r6.b()     // Catch:{ Exception -> 0x002b }
            r6.put(r5, r0)     // Catch:{ Exception -> 0x002b }
            return r0
        L_0x00a2:
            boolean r6 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r6 == 0) goto L_0x00a9
            r5.printStackTrace()
        L_0x00a9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(java.util.List, com.mbridge.msdk.foundation.same.report.d.c):com.mbridge.msdk.foundation.same.report.d.c");
    }

    static /* synthetic */ void a(a aVar, String str, List list) {
        if (list != null) {
            try {
                if (list.size() > 0 && !aVar.f15263V) {
                    e.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a((List<CampaignEx>) list, str);
                }
            } catch (Throwable th) {
                af.b("RewardVideoController", th.getMessage());
            }
        }
    }

    static /* synthetic */ void a(a aVar, String str, com.mbridge.msdk.foundation.same.report.d.c cVar, InterVideoOutListener interVideoOutListener) {
        if (aVar.f15251H) {
            if (cVar == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.d.c();
                cVar.b(aVar.f15256M);
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                if (interVideoOutListener != null) {
                    eVar.a("listener_state", 1);
                } else {
                    eVar.a("listener_state", 2);
                }
                cVar.a(str, eVar);
                com.mbridge.msdk.reward.c.a.a.a().a(str, cVar);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }
}
