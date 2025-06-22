package com.mbridge.msdk.reward.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public final class b {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static ConcurrentHashMap<String, a> f14966b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final h f14967a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f14968c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14969d;

    /* renamed from: e  reason: collision with root package name */
    private final String f14970e;

    /* renamed from: f  reason: collision with root package name */
    private final String f14971f;

    /* renamed from: g  reason: collision with root package name */
    private volatile List<WindVaneWebView> f14972g;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f15007a;

        /* renamed from: b  reason: collision with root package name */
        boolean f15008b;

        /* renamed from: c  reason: collision with root package name */
        int f15009c;

        /* renamed from: d  reason: collision with root package name */
        int f15010d;

        /* renamed from: e  reason: collision with root package name */
        String f15011e;

        /* renamed from: f  reason: collision with root package name */
        String f15012f;

        /* renamed from: g  reason: collision with root package name */
        int f15013g;

        /* renamed from: h  reason: collision with root package name */
        CopyOnWriteArrayList<CampaignEx> f15014h;

        /* renamed from: i  reason: collision with root package name */
        CopyOnWriteArrayList<CampaignEx> f15015i;

        public a(boolean z4, boolean z5, int i4, int i5, String str, String str2, int i6, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f15007a = z4;
            this.f15008b = z5;
            this.f15009c = i4;
            this.f15010d = i5;
            this.f15011e = str;
            this.f15012f = str2;
            this.f15013g = i6;
            this.f15014h = copyOnWriteArrayList;
            this.f15015i = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        }
    }

    public interface c {
        void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList);

        void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.c.b bVar);
    }

    private static final class d implements H5DownLoadManager.IH5SourceDownloadListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f15036a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f15037b;

        /* renamed from: c  reason: collision with root package name */
        private final String f15038c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final String f15039d;

        /* renamed from: e  reason: collision with root package name */
        private final String f15040e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public CampaignEx f15041f;

        /* renamed from: g  reason: collision with root package name */
        private i f15042g;

        /* renamed from: h  reason: collision with root package name */
        private Handler f15043h;

        /* renamed from: i  reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f15044i;

        /* renamed from: j  reason: collision with root package name */
        private final long f15045j;

        public d(int i4, String str, String str2, String str3, CampaignEx campaignEx, i iVar, Handler handler, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f15037b = i4;
            this.f15038c = str;
            this.f15039d = str2;
            this.f15040e = str3;
            this.f15041f = campaignEx;
            this.f15042g = iVar;
            this.f15043h = handler;
            this.f15044i = copyOnWriteArrayList;
            this.f15045j = System.currentTimeMillis();
        }

        public final void onFailed(String str, String str2) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, false);
            int i4 = this.f15037b;
            if (i4 != 313) {
                if (i4 == 497) {
                    Message obtain = Message.obtain();
                    obtain.what = 201;
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15039d);
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f15038c);
                    bundle.putString("request_id", this.f15040e);
                    bundle.putString("url", str);
                    bundle.putString("message", str2);
                    obtain.setData(bundle);
                    this.f15043h.sendMessage(obtain);
                    if (this.f15036a) {
                        a(3, System.currentTimeMillis() - this.f15045j, str, "url download failed", "");
                        return;
                    }
                } else if (i4 == 859) {
                    Message obtain2 = Message.obtain();
                    obtain2.what = 205;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15039d);
                    bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f15038c);
                    bundle2.putString("request_id", this.f15040e);
                    bundle2.putString("message", str2);
                    obtain2.setData(bundle2);
                    this.f15043h.sendMessage(obtain2);
                    if (this.f15042g != null) {
                        try {
                            this.f15042g.a(str, this.f15040e, b.b(880006, new MBridgeIds(this.f15038c, this.f15039d, this.f15040e), str2, (Throwable) null, (CampaignEx) null));
                            return;
                        } catch (Exception e5) {
                            af.b("RewardCampaignsResourceManager", e5.getMessage());
                        }
                    }
                }
                return;
            }
            String str3 = str;
            Message obtain3 = Message.obtain();
            obtain3.what = 201;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15039d);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f15038c);
            bundle3.putString("request_id", this.f15040e);
            bundle3.putString("url", str3);
            bundle3.putString("message", str2);
            obtain3.setData(bundle3);
            this.f15043h.sendMessage(obtain3);
        }

        public final void onSuccess(String str, String str2, boolean z4) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
            int i4 = this.f15037b;
            if (i4 != 313) {
                if (i4 == 497) {
                    Message obtain = Message.obtain();
                    obtain.what = 101;
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15039d);
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f15038c);
                    bundle.putString("request_id", this.f15040e);
                    bundle.putString("url", str);
                    obtain.setData(bundle);
                    this.f15043h.sendMessage(obtain);
                    if (this.f15036a) {
                        a(1, System.currentTimeMillis() - this.f15045j, str, "", str2);
                        return;
                    }
                } else if (i4 == 859) {
                    Message obtain2 = Message.obtain();
                    obtain2.what = 105;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15039d);
                    bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f15038c);
                    bundle2.putString("request_id", this.f15040e);
                    obtain2.setData(bundle2);
                    this.f15043h.sendMessage(obtain2);
                    i iVar = this.f15042g;
                    if (iVar != null) {
                        iVar.a(this.f15038c, this.f15039d, this.f15040e, str);
                        return;
                    }
                }
                return;
            }
            String str3 = str;
            Message obtain3 = Message.obtain();
            obtain3.what = 101;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15039d);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f15038c);
            bundle3.putString("request_id", this.f15040e);
            bundle3.putString("url", str3);
            obtain3.setData(bundle3);
            this.f15043h.sendMessage(obtain3);
        }

        public final void a(boolean z4) {
            this.f15036a = z4;
        }

        private void a(int i4, long j4, String str, String str2, String str3) {
            final int i5 = i4;
            final long j5 = j4;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
                public final void run() {
                    if (d.this.f15041f != null) {
                        try {
                            int i4 = i5;
                            n nVar = new n("m_download_end", i4, j5 + "", str4, d.this.f15041f.getId(), d.this.f15039d, str5, "2");
                            nVar.f(d.this.f15041f.getRequestId());
                            nVar.s(d.this.f15041f.getCurrentLocalRid());
                            nVar.g(d.this.f15041f.getRequestIdNotice());
                            nVar.e(d.this.f15041f.getId());
                            nVar.c(d.this.f15041f.getAdSpaceT());
                            nVar.a("scenes", "1");
                            nVar.a("url", str4);
                            if (d.this.f15041f.getAdType() == 287) {
                                nVar.d(ExifInterface.GPS_MEASUREMENT_3D);
                            } else if (d.this.f15041f.getAdType() == 94) {
                                nVar.d("1");
                            }
                            if (!TextUtils.isEmpty(str6)) {
                                nVar.t(str6);
                            }
                            b.a(nVar, d.this.f15041f);
                            com.mbridge.msdk.foundation.same.report.g.a(nVar, d.this.f15039d, d.this.f15041f);
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("RewardCampaignsResourceManager", e5.getLocalizedMessage());
                            }
                        }
                    }
                }
            });
        }
    }

    private static final class e implements com.mbridge.msdk.foundation.same.c.c {

        /* renamed from: a  reason: collision with root package name */
        private Handler f15052a;

        /* renamed from: b  reason: collision with root package name */
        private int f15053b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f15054c;

        /* renamed from: d  reason: collision with root package name */
        private String f15055d;

        /* renamed from: e  reason: collision with root package name */
        private String f15056e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public CampaignEx f15057f;

        public e(Handler handler, int i4, String str, String str2, String str3, CampaignEx campaignEx) {
            this.f15052a = handler;
            this.f15053b = i4;
            this.f15055d = str;
            this.f15054c = str2;
            this.f15056e = str3;
            this.f15057f = campaignEx;
        }

        public final void onFailedLoad(final String str, String str2) {
            int i4;
            Message obtain = Message.obtain();
            if (this.f15053b == 0) {
                i4 = 202;
            } else {
                i4 = 204;
            }
            obtain.what = i4;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15054c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f15055d);
            bundle.putString("request_id", this.f15056e);
            obtain.setData(bundle);
            this.f15052a.sendMessage(obtain);
            AnonymousClass1 r5 = new Runnable() {
                public final void run() {
                    if (e.this.f15057f != null) {
                        try {
                            o a5 = o.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                            af.a("RewardCampaignsResourceManager", "campaign is null");
                            n nVar = new n();
                            nVar.a("2000044");
                            nVar.a(ab.m(com.mbridge.msdk.foundation.controller.c.m().c()));
                            nVar.e(e.this.f15057f.getId());
                            nVar.p(e.this.f15057f.getImageUrl());
                            nVar.f(e.this.f15057f.getRequestId());
                            nVar.s(e.this.f15057f.getCurrentLocalRid());
                            nVar.g(e.this.f15057f.getRequestIdNotice());
                            nVar.c(e.this.f15054c);
                            nVar.h(str);
                            nVar.a("scenes", "1");
                            a5.a(nVar);
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("RewardCampaignsResourceManager", e5.getLocalizedMessage());
                            }
                        }
                    }
                }
            };
            com.mbridge.msdk.foundation.controller.d.a();
            com.mbridge.msdk.foundation.same.f.a.b().execute(r5);
        }

        public final void onSuccessLoad(Bitmap bitmap, String str) {
            int i4;
            ResDownloadCheckManager.getInstance().setImageDownloadDone(str, true);
            Message obtain = Message.obtain();
            if (this.f15053b == 0) {
                i4 = 102;
            } else {
                i4 = 104;
            }
            obtain.what = i4;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15054c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f15055d);
            bundle.putString("request_id", this.f15056e);
            obtain.setData(bundle);
            this.f15052a.sendMessage(obtain);
        }
    }

    private static final class g implements H5DownLoadManager.ZipDownloadListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f15064a = false;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Context f15065b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f15066c;

        /* renamed from: d  reason: collision with root package name */
        private String f15067d;

        /* renamed from: e  reason: collision with root package name */
        private String f15068e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public CampaignEx f15069f;

        /* renamed from: g  reason: collision with root package name */
        private int f15070g;

        /* renamed from: h  reason: collision with root package name */
        private Handler f15071h;

        /* renamed from: i  reason: collision with root package name */
        private i f15072i;

        /* renamed from: j  reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f15073j;

        /* renamed from: k  reason: collision with root package name */
        private long f15074k;

        public g(Context context, String str, String str2, String str3, CampaignEx campaignEx, int i4, Handler handler, i iVar, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f15065b = context;
            this.f15067d = str;
            this.f15066c = str2;
            this.f15068e = str3;
            this.f15069f = campaignEx;
            this.f15070g = i4;
            this.f15071h = handler;
            this.f15072i = iVar;
            this.f15073j = copyOnWriteArrayList;
            this.f15074k = System.currentTimeMillis();
        }

        public final void onFailed(String str, String str2) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str2, false);
            long currentTimeMillis = System.currentTimeMillis() - this.f15074k;
            int i4 = this.f15070g;
            if (i4 != 313) {
                if (i4 == 497) {
                    Message obtain = Message.obtain();
                    obtain.what = 201;
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15066c);
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f15067d);
                    bundle.putString("request_id", this.f15068e);
                    bundle.putString("url", str2);
                    bundle.putString("message", str);
                    obtain.setData(bundle);
                    this.f15071h.sendMessage(obtain);
                    if (this.f15064a) {
                        a(3, currentTimeMillis, str2, "zip download failed", "");
                        return;
                    }
                } else if (i4 == 859) {
                    Message obtain2 = Message.obtain();
                    obtain2.what = 203;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15066c);
                    bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f15067d);
                    bundle2.putString("request_id", this.f15068e);
                    bundle2.putString("url", str2);
                    bundle2.putString("message", str);
                    obtain2.setData(bundle2);
                    this.f15071h.sendMessage(obtain2);
                    if (this.f15072i != null) {
                        try {
                            this.f15072i.a(str2, this.f15068e, b.b(880006, new MBridgeIds(this.f15067d, this.f15066c, this.f15068e), "", (Throwable) null, (CampaignEx) null));
                        } catch (Exception e5) {
                            af.b("RewardCampaignsResourceManager", e5.getMessage());
                        }
                    }
                    a(3, str2, str, "");
                }
                return;
            }
            String str3 = str2;
            Message obtain3 = Message.obtain();
            obtain3.what = 101;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15066c);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f15067d);
            bundle3.putString("request_id", this.f15068e);
            bundle3.putString("url", str3);
            bundle3.putString("message", str);
            obtain3.setData(bundle3);
            this.f15071h.sendMessage(obtain3);
        }

        public final void onSuccess(String str, String str2, boolean z4) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
            long currentTimeMillis = System.currentTimeMillis() - this.f15074k;
            int i4 = this.f15070g;
            if (i4 == 313) {
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15066c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f15067d);
                bundle.putString("request_id", this.f15068e);
                bundle.putString("url", str);
                obtain.setData(bundle);
                this.f15071h.sendMessage(obtain);
            } else if (i4 == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15066c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f15067d);
                bundle2.putString("request_id", this.f15068e);
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                this.f15071h.sendMessage(obtain2);
                if (this.f15064a) {
                    a(1, currentTimeMillis, str, "", str2);
                }
            } else if (i4 == 859) {
                Message obtain3 = Message.obtain();
                obtain3.what = 103;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15066c);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f15067d);
                bundle3.putString("request_id", this.f15068e);
                obtain3.setData(bundle3);
                this.f15071h.sendMessage(obtain3);
                i iVar = this.f15072i;
                if (iVar != null) {
                    iVar.a(this.f15067d, this.f15066c, this.f15068e, str);
                }
                if (!z4) {
                    a(1, str, "", str2);
                }
            }
        }

        public final void a(boolean z4) {
            this.f15064a = z4;
        }

        private void a(int i4, String str, String str2, String str3) {
            final int i5 = i4;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
                public final void run() {
                    if (g.this.f15069f != null && g.this.f15065b != null) {
                        try {
                            n nVar = new n();
                            nVar.a("m_download_end");
                            if (g.this.f15065b != null) {
                                nVar.a(ab.m(g.this.f15065b.getApplicationContext()));
                            }
                            nVar.b(i5);
                            if (g.this.f15069f != null) {
                                nVar.e(g.this.f15069f.getId());
                                nVar.f(g.this.f15069f.getRequestId());
                                nVar.s(g.this.f15069f.getCurrentLocalRid());
                                nVar.g(g.this.f15069f.getRequestIdNotice());
                            }
                            nVar.q(str4);
                            nVar.h(str5);
                            nVar.c(g.this.f15066c);
                            if (!TextUtils.isEmpty(str6)) {
                                nVar.t(str6);
                            }
                            nVar.e(2);
                            nVar.a("scenes", "1");
                            nVar.a("url", str4);
                            b.a(nVar, g.this.f15069f);
                            com.mbridge.msdk.foundation.same.report.d.d.a().a(nVar, g.this.f15069f);
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("RewardCampaignsResourceManager", e5.getLocalizedMessage());
                            }
                        }
                    }
                }
            });
        }

        private void a(int i4, long j4, String str, String str2, String str3) {
            final int i5 = i4;
            final long j5 = j4;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
                public final void run() {
                    if (g.this.f15069f != null) {
                        try {
                            int i4 = i5;
                            n nVar = new n("m_download_end", i4, j5 + "", str4, g.this.f15069f.getId(), g.this.f15066c, str5, "1");
                            nVar.f(g.this.f15069f.getRequestId());
                            nVar.s(g.this.f15069f.getCurrentLocalRid());
                            nVar.g(g.this.f15069f.getRequestIdNotice());
                            nVar.e(g.this.f15069f.getId());
                            nVar.c(g.this.f15069f.getAdSpaceT());
                            nVar.t(str6);
                            nVar.a("scenes", "1");
                            if (g.this.f15069f.getAdType() == 287) {
                                nVar.d(ExifInterface.GPS_MEASUREMENT_3D);
                            } else if (g.this.f15069f.getAdType() == 94) {
                                nVar.d("1");
                            }
                            nVar.a("url", str4);
                            nVar.e(3);
                            b.a(nVar, g.this.f15069f);
                            com.mbridge.msdk.foundation.same.report.g.a(nVar, g.this.f15066c, g.this.f15069f);
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("RewardCampaignsResourceManager", e5.getLocalizedMessage());
                            }
                        }
                    }
                }
            });
        }
    }

    private static final class h extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private Context f15086a;

        /* renamed from: b  reason: collision with root package name */
        private ConcurrentHashMap<String, c> f15087b = new ConcurrentHashMap<>();

        /* renamed from: c  reason: collision with root package name */
        private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> f15088c = new ConcurrentHashMap<>();

        public h(Looper looper) {
            super(looper);
        }

        public final void a(String str, String str2, String str3, c cVar) {
            ConcurrentHashMap<String, c> concurrentHashMap = this.f15087b;
            concurrentHashMap.put(str2 + "_" + str3, cVar);
        }

        public final void handleMessage(Message message) {
            boolean z4;
            int i4;
            CampaignEx campaignEx;
            CampaignEx campaignEx2;
            int i5;
            CampaignEx campaignEx3;
            Message message2 = message;
            Bundle data = message2.getData();
            String string = data.getString(MBridgeConstans.PLACEMENT_ID);
            String string2 = data.getString(MBridgeConstans.PROPERTIES_UNIT_ID);
            String string3 = data.getString("request_id");
            String str = string2 + "_" + string3;
            a aVar = (a) b.f14966b.get(str);
            c cVar = this.f15087b.get(str);
            CopyOnWriteArrayList copyOnWriteArrayList = this.f15088c.get(str);
            int i6 = message2.what;
            switch (i6) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                    break;
                default:
                    switch (i6) {
                        case 200:
                        case 201:
                        case 203:
                        case 205:
                            if (aVar != null && cVar != null) {
                                String string4 = data.getString("message");
                                if (string4 == null) {
                                    string4 = "";
                                }
                                int i7 = message2.what;
                                if (i7 == 200) {
                                    i4 = 880004;
                                } else if (i7 == 201) {
                                    i4 = 880007;
                                } else if (i7 == 203) {
                                    i4 = 880006;
                                } else if (i7 != 205) {
                                    i4 = 880024;
                                } else {
                                    i4 = 880005;
                                }
                                String str2 = "resource download failed " + b.b(message2.what) + " " + string4;
                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = aVar.f15014h;
                                if (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) {
                                    campaignEx = null;
                                } else {
                                    campaignEx = aVar.f15014h.get(0);
                                }
                                try {
                                    if (!aVar.f15007a || aVar.f15015i == null) {
                                        i5 = i4;
                                        try {
                                            String str3 = str;
                                            if (com.mbridge.msdk.videocommon.download.b.getInstance().a(94, aVar.f15011e, aVar.f15008b, aVar.f15010d, aVar.f15007a, aVar.f15009c, copyOnWriteArrayList)) {
                                                cVar.a(string, string2, string3, aVar.f15014h);
                                            } else {
                                                if (!(campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0)) {
                                                    int i8 = message2.what;
                                                    if (i8 != 200) {
                                                        if (i8 != 201) {
                                                            if (i8 != 203) {
                                                                if (i8 == 205) {
                                                                    if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                                        return;
                                                                    }
                                                                }
                                                            } else if (campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                                return;
                                                            }
                                                        } else if (campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                            return;
                                                        }
                                                    } else if (campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                        return;
                                                    }
                                                }
                                                campaignEx2 = null;
                                                cVar.a(aVar.f15014h, b.b(i5, new MBridgeIds(string, string2, string3), str2, (Throwable) null, (CampaignEx) null));
                                            }
                                            String str4 = str3;
                                            this.f15087b.remove(str4);
                                            b.f14966b.remove(str4);
                                            this.f15088c.remove(str4);
                                            return;
                                        } catch (Exception e5) {
                                            e = e5;
                                            campaignEx2 = null;
                                            cVar.a(aVar.f15014h, b.b(i5, new MBridgeIds(string, string2, string3), str2, e, campaignEx2));
                                            return;
                                        }
                                    } else if (aVar.f15009c == 1) {
                                        if (!(campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0)) {
                                            int i9 = message2.what;
                                            if (i9 != 200) {
                                                if (i9 != 201) {
                                                    if (i9 != 203) {
                                                        if (i9 == 205) {
                                                            if (!campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = aVar.f15014h;
                                                                if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
                                                                    CampaignEx campaignEx4 = aVar.f15014h.get(0);
                                                                    if (campaignEx4.getCMPTEntryUrl().equals(campaignEx4.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                                        return;
                                                                    }
                                                                }
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else if (campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                        return;
                                                    }
                                                } else if (campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                    return;
                                                }
                                            } else if (campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                return;
                                            }
                                        }
                                        try {
                                            campaignEx3 = null;
                                        } catch (Exception e6) {
                                            e = e6;
                                            campaignEx3 = null;
                                            i5 = i4;
                                            campaignEx2 = campaignEx3;
                                            cVar.a(aVar.f15014h, b.b(i5, new MBridgeIds(string, string2, string3), str2, e, campaignEx2));
                                            return;
                                        }
                                        try {
                                            cVar.a(aVar.f15014h, b.b(i4, new MBridgeIds(string, string2, string3), str2, (Throwable) null, (CampaignEx) null));
                                            this.f15087b.remove(str);
                                            b.f14966b.remove(str);
                                            this.f15088c.remove(str);
                                            return;
                                        } catch (Exception e7) {
                                            e = e7;
                                            i5 = i4;
                                            campaignEx2 = campaignEx3;
                                            cVar.a(aVar.f15014h, b.b(i5, new MBridgeIds(string, string2, string3), str2, e, campaignEx2));
                                            return;
                                        }
                                    } else {
                                        String string5 = data.getString("url");
                                        int i10 = message2.what;
                                        if (i10 == 200) {
                                            if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                                                if (campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                    af.c("RewardCampaignsResourceManager", "Is TPL but  video download fail but hit ignoreCheckRule");
                                                    return;
                                                }
                                            }
                                            for (int i11 = 0; i11 < aVar.f15015i.size(); i11++) {
                                                if (aVar.f15015i.get(i11).getVideoUrlEncode().equals(string5)) {
                                                    aVar.f15015i.remove(i11);
                                                }
                                            }
                                            b.f14966b.remove(str);
                                            b.f14966b.put(str, aVar);
                                        } else if (i10 != 201) {
                                            if (i10 != 203) {
                                                if (i10 == 205) {
                                                    if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                        aVar.f15015i.clear();
                                                        b.f14966b.remove(str);
                                                        b.f14966b.put(str, aVar);
                                                    } else {
                                                        af.c("RewardCampaignsResourceManager", "Is TPL but download BTL Template fail but hit ignoreCheckRule");
                                                        return;
                                                    }
                                                }
                                            } else if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                for (int i12 = 0; i12 < aVar.f15015i.size(); i12++) {
                                                    CampaignEx campaignEx5 = aVar.f15015i.get(i12);
                                                    if (campaignEx5.getRewardTemplateMode() != null && campaignEx5.getRewardTemplateMode().e().equals(string5)) {
                                                        aVar.f15015i.remove(i12);
                                                    }
                                                }
                                                b.f14966b.remove(str);
                                                b.f14966b.put(str, aVar);
                                            } else {
                                                af.c("RewardCampaignsResourceManager", "Is TPL but download template fail but hit ignoreCheckRule");
                                                return;
                                            }
                                        } else if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                            for (int i13 = 0; i13 < aVar.f15015i.size(); i13++) {
                                                CampaignEx campaignEx6 = aVar.f15015i.get(i13);
                                                if (campaignEx6.getRewardTemplateMode() != null && campaignEx6.getRewardTemplateMode().c().equals(string5)) {
                                                    aVar.f15015i.remove(i13);
                                                }
                                                if (!TextUtils.isEmpty(campaignEx6.getendcard_url()) && campaignEx6.getendcard_url().equals(string5)) {
                                                    aVar.f15015i.remove(i13);
                                                }
                                            }
                                            b.f14966b.remove(str);
                                            b.f14966b.put(str, aVar);
                                        } else {
                                            af.c("RewardCampaignsResourceManager", "Is TPL but download endcard fail but hit ignoreCheckRule");
                                            return;
                                        }
                                        i5 = i4;
                                        try {
                                            if (com.mbridge.msdk.videocommon.download.b.getInstance().a(94, aVar.f15011e, aVar.f15008b, aVar.f15010d, aVar.f15007a, aVar.f15009c, copyOnWriteArrayList)) {
                                                cVar.a(string, string2, string3, aVar.f15014h);
                                                this.f15087b.remove(str);
                                                b.f14966b.remove(str);
                                                this.f15088c.remove(str);
                                                return;
                                            } else if (aVar.f15015i.size() == 0) {
                                                campaignEx2 = null;
                                                try {
                                                    cVar.a(aVar.f15014h, b.b(i5, new MBridgeIds(string, string2, string3), str2, (Throwable) null, (CampaignEx) null));
                                                    this.f15087b.remove(str);
                                                    b.f14966b.remove(str);
                                                    this.f15088c.remove(str);
                                                    return;
                                                } catch (Exception e8) {
                                                    e = e8;
                                                    cVar.a(aVar.f15014h, b.b(i5, new MBridgeIds(string, string2, string3), str2, e, campaignEx2));
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        } catch (Exception e9) {
                                            e = e9;
                                            campaignEx2 = null;
                                            cVar.a(aVar.f15014h, b.b(i5, new MBridgeIds(string, string2, string3), str2, e, campaignEx2));
                                            return;
                                        }
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    i5 = i4;
                                    campaignEx2 = null;
                                    cVar.a(aVar.f15014h, b.b(i5, new MBridgeIds(string, string2, string3), str2, e, campaignEx2));
                                    return;
                                }
                            } else {
                                return;
                            }
                        case 202:
                        case 204:
                            break;
                        default:
                            return;
                    }
            }
            if (aVar != null && cVar != null) {
                String str5 = "RewardCampaignsResourceManager";
                try {
                    z4 = com.mbridge.msdk.videocommon.download.b.getInstance().a(94, aVar.f15011e, aVar.f15008b, aVar.f15010d, aVar.f15007a, aVar.f15009c, copyOnWriteArrayList);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        af.b(str5, e11.getLocalizedMessage());
                    }
                    z4 = false;
                }
                if (z4) {
                    cVar.a(string, string2, string3, aVar.f15014h);
                    this.f15087b.remove(str);
                    b.f14966b.remove(str);
                    this.f15088c.remove(str);
                }
            }
        }

        public final void a(Context context) {
            this.f15086a = context;
        }

        public final void a(String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f15088c.put(str, copyOnWriteArrayList);
        }
    }

    public interface i {
        void a(String str, String str2, com.mbridge.msdk.foundation.c.b bVar);

        void a(String str, String str2, String str3, String str4);
    }

    public interface j {
        void a(String str, String str2, String str3, a.C0208a aVar, com.mbridge.msdk.foundation.c.b bVar);

        void a(String str, String str2, String str3, String str4, String str5, a.C0208a aVar);
    }

    private static final class m {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f15132a = new b();
    }

    private b() {
        this.f14969d = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
        this.f14970e = "down_type";
        this.f14971f = "h3c";
        this.f14972g = new ArrayList(6);
        HandlerThread handlerThread = new HandlerThread("mb-reward-load-thread");
        f14966b = new ConcurrentHashMap<>();
        handlerThread.start();
        this.f14967a = new h(handlerThread.getLooper());
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockFinish
        jadx.core.utils.exceptions.JadxRuntimeException: Dominance frontier not set for block: B:13:0x0017
        	at jadx.core.dex.nodes.BlockNode.lock(BlockNode.java:75)
        	at jadx.core.utils.ImmutableList.forEach(ImmutableList.java:108)
        	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:472)
        	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:27)
        */
    public static synchronized java.lang.String b(int r2) {
        /*
            java.lang.Class<com.mbridge.msdk.reward.adapter.b> r0 = com.mbridge.msdk.reward.adapter.b.class
            monitor-enter(r0)
            r1 = 200(0xc8, float:2.8E-43)
            if (r2 == r1) goto L_0x0025
            r1 = 201(0xc9, float:2.82E-43)
            if (r2 == r1) goto L_0x0021
            r1 = 203(0xcb, float:2.84E-43)
            if (r2 == r1) goto L_0x001d
            r1 = 205(0xcd, float:2.87E-43)
            if (r2 == r1) goto L_0x0019
            java.lang.String r2 = "unknown"
            monitor-exit(r0)
            return r2
        L_0x0017:
            r2 = move-exception
            goto L_0x0029
        L_0x0019:
            java.lang.String r2 = "tpl"
            monitor-exit(r0)
            return r2
        L_0x001d:
            java.lang.String r2 = "temp"
            monitor-exit(r0)
            return r2
        L_0x0021:
            java.lang.String r2 = "zip/html"
            monitor-exit(r0)
            return r2
        L_0x0025:
            java.lang.String r2 = "video"
            monitor-exit(r0)
            return r2
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.b(int):java.lang.String");
    }

    public static b a() {
        return m.f15132a;
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void a(Context context, boolean z4, int i4, boolean z5, int i5, String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, c cVar, i iVar) {
        String str4 = str2;
        String str5 = str3;
        synchronized (this) {
            try {
                String str6 = str4 + "_" + str5;
                String str7 = str2;
                final String str8 = str7;
                f14966b.put(str6, new a(z4, z5, i4, copyOnWriteArrayList.size(), str7, str5, i5, copyOnWriteArrayList));
                String str9 = str;
                this.f14967a.a(str9, str8, str5, cVar);
                this.f14967a.a(context);
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = copyOnWriteArrayList;
                this.f14967a.a(str6, copyOnWriteArrayList2);
                final Context context2 = context;
                final int i6 = i5;
                final String str10 = str5;
                final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = copyOnWriteArrayList2;
                final String str11 = str9;
                final i iVar2 = iVar;
                this.f14967a.post(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:104:0x026d A[SYNTHETIC, Splitter:B:104:0x026d] */
                    /* JADX WARNING: Removed duplicated region for block: B:119:0x029c  */
                    /* JADX WARNING: Removed duplicated region for block: B:59:0x015c  */
                    /* JADX WARNING: Removed duplicated region for block: B:69:0x01b0  */
                    /* JADX WARNING: Removed duplicated region for block: B:88:0x0236 A[SYNTHETIC, Splitter:B:88:0x0236] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                            r22 = this;
                            r1 = r22
                            java.lang.String r2 = "RewardCampaignsResourceManager"
                            java.util.concurrent.CopyOnWriteArrayList r0 = r2
                            if (r0 == 0) goto L_0x039b
                            int r0 = r0.size()
                            if (r0 <= 0) goto L_0x039b
                            com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager r0 = com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager.getInstance()     // Catch:{ Exception -> 0x0041 }
                            java.util.concurrent.CopyOnWriteArrayList r3 = r2     // Catch:{ Exception -> 0x0041 }
                            r0.setCampaignList((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)     // Catch:{ Exception -> 0x0041 }
                            com.mbridge.msdk.videocommon.download.b r4 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch:{ Exception -> 0x0041 }
                            android.content.Context r5 = r3     // Catch:{ Exception -> 0x0041 }
                            java.lang.String r6 = r4     // Catch:{ Exception -> 0x0041 }
                            java.util.concurrent.CopyOnWriteArrayList r7 = r2     // Catch:{ Exception -> 0x0041 }
                            int r8 = r5     // Catch:{ Exception -> 0x0041 }
                            com.mbridge.msdk.reward.adapter.b$f r9 = new com.mbridge.msdk.reward.adapter.b$f     // Catch:{ Exception -> 0x0041 }
                            com.mbridge.msdk.reward.adapter.b r0 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x0041 }
                            com.mbridge.msdk.reward.adapter.b$h r0 = r0.f14967a     // Catch:{ Exception -> 0x0041 }
                            java.lang.String r3 = r6     // Catch:{ Exception -> 0x0041 }
                            java.lang.String r10 = r4     // Catch:{ Exception -> 0x0041 }
                            java.lang.String r11 = r7     // Catch:{ Exception -> 0x0041 }
                            r9.<init>(r0, r3, r10, r11)     // Catch:{ Exception -> 0x0041 }
                            r4.createUnitCache((android.content.Context) r5, (java.lang.String) r6, (java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r7, (int) r8, (com.mbridge.msdk.videocommon.listener.a) r9)     // Catch:{ Exception -> 0x0041 }
                            com.mbridge.msdk.videocommon.download.b r0 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch:{ Exception -> 0x0041 }
                            java.lang.String r3 = r4     // Catch:{ Exception -> 0x0041 }
                            r0.load(r3)     // Catch:{ Exception -> 0x0041 }
                            goto L_0x004d
                        L_0x0041:
                            r0 = move-exception
                            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r3 == 0) goto L_0x004d
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                        L_0x004d:
                            java.util.concurrent.CopyOnWriteArrayList r0 = r2
                            java.util.Iterator r3 = r0.iterator()
                        L_0x0053:
                            boolean r0 = r3.hasNext()
                            if (r0 == 0) goto L_0x039b
                            java.lang.Object r0 = r3.next()
                            r9 = r0
                            com.mbridge.msdk.foundation.entity.CampaignEx r9 = (com.mbridge.msdk.foundation.entity.CampaignEx) r9
                            if (r9 != 0) goto L_0x0063
                            goto L_0x0053
                        L_0x0063:
                            android.os.Message r0 = android.os.Message.obtain()     // Catch:{ Exception -> 0x0092 }
                            r4 = 106(0x6a, float:1.49E-43)
                            r0.what = r4     // Catch:{ Exception -> 0x0092 }
                            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ Exception -> 0x0092 }
                            r4.<init>()     // Catch:{ Exception -> 0x0092 }
                            java.lang.String r5 = "unit_id"
                            java.lang.String r6 = r4     // Catch:{ Exception -> 0x0092 }
                            r4.putString(r5, r6)     // Catch:{ Exception -> 0x0092 }
                            java.lang.String r5 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ Exception -> 0x0092 }
                            java.lang.String r6 = r6     // Catch:{ Exception -> 0x0092 }
                            r4.putString(r5, r6)     // Catch:{ Exception -> 0x0092 }
                            java.lang.String r5 = "request_id"
                            java.lang.String r6 = r7     // Catch:{ Exception -> 0x0092 }
                            r4.putString(r5, r6)     // Catch:{ Exception -> 0x0092 }
                            r0.setData(r4)     // Catch:{ Exception -> 0x0092 }
                            com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x0092 }
                            com.mbridge.msdk.reward.adapter.b$h r4 = r4.f14967a     // Catch:{ Exception -> 0x0092 }
                            r4.sendMessage(r0)     // Catch:{ Exception -> 0x0092 }
                            goto L_0x0093
                        L_0x0092:
                        L_0x0093:
                            com.mbridge.msdk.foundation.entity.CampaignEx$c r14 = r9.getRewardTemplateMode()
                            java.lang.String r15 = ".zip"
                            r4 = 2
                            java.lang.String r5 = ""
                            r6 = 1
                            java.lang.String r7 = "dyview"
                            if (r14 == 0) goto L_0x00c9
                            java.lang.String r0 = r14.e()
                            int r8 = r14.f()
                            boolean r10 = r9.isDynamicView()
                            if (r10 == 0) goto L_0x00d4
                            boolean r10 = com.mbridge.msdk.foundation.tools.ak.a((java.lang.String) r7, (java.lang.String) r0)
                            if (r10 == 0) goto L_0x00d4
                            com.mbridge.msdk.reward.adapter.b r10 = com.mbridge.msdk.reward.adapter.b.this
                            java.lang.StringBuilder r11 = new java.lang.StringBuilder
                            r11.<init>()
                            r11.append(r8)
                            r11.append(r5)
                            java.lang.String r8 = r11.toString()
                            r10.a(r6, r9, r8, r0)
                        L_0x00c9:
                            r21 = r3
                            r18 = r5
                            r16 = r14
                            r17 = r15
                            r14 = r7
                            goto L_0x019e
                        L_0x00d4:
                            boolean r8 = android.text.TextUtils.isEmpty(r0)
                            if (r8 != 0) goto L_0x00c9
                            java.lang.String r8 = "cmpt=1"
                            boolean r8 = r0.contains(r8)
                            if (r8 != 0) goto L_0x00c9
                            com.mbridge.msdk.reward.adapter.b r8 = com.mbridge.msdk.reward.adapter.b.this
                            com.mbridge.msdk.foundation.same.report.d.c r8 = r8.a((com.mbridge.msdk.foundation.entity.CampaignEx) r9, (int) r4)
                            boolean r10 = r0.contains(r15)
                            if (r10 == 0) goto L_0x0164
                            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r10 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()     // Catch:{ Exception -> 0x0152 }
                            r11 = 2
                            com.mbridge.msdk.reward.adapter.b$g r4 = new com.mbridge.msdk.reward.adapter.b$g     // Catch:{ Exception -> 0x0152 }
                            r12 = r5
                            android.content.Context r5 = r3     // Catch:{ Exception -> 0x0147 }
                            r13 = 1
                            java.lang.String r6 = r6     // Catch:{ Exception -> 0x0147 }
                            r16 = r7
                            java.lang.String r7 = r4     // Catch:{ Exception -> 0x013b }
                            r17 = r8
                            java.lang.String r8 = r7     // Catch:{ Exception -> 0x013b }
                            com.mbridge.msdk.reward.adapter.b r11 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x013b }
                            com.mbridge.msdk.reward.adapter.b$h r11 = r11.f14967a     // Catch:{ Exception -> 0x013b }
                            r18 = r12
                            com.mbridge.msdk.reward.adapter.b$i r12 = r8     // Catch:{ Exception -> 0x012f }
                            r19 = 1
                            java.util.concurrent.CopyOnWriteArrayList r13 = r2     // Catch:{ Exception -> 0x012f }
                            r20 = r10
                            r10 = 859(0x35b, float:1.204E-42)
                            r21 = r16
                            r16 = r14
                            r14 = r21
                            r21 = r17
                            r17 = r15
                            r15 = r21
                            r21 = r3
                            r3 = r20
                            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x012d }
                            r3.downloadH5Res(r15, r0, r4)     // Catch:{ Exception -> 0x012d }
                            goto L_0x019e
                        L_0x012d:
                            r0 = move-exception
                            goto L_0x0158
                        L_0x012f:
                            r0 = move-exception
                            r17 = r16
                            r16 = r14
                            r14 = r17
                            r21 = r3
                        L_0x0138:
                            r17 = r15
                            goto L_0x0158
                        L_0x013b:
                            r0 = move-exception
                            r17 = r16
                            r16 = r14
                            r14 = r17
                            r21 = r3
                            r18 = r12
                            goto L_0x0138
                        L_0x0147:
                            r0 = move-exception
                            r21 = r3
                            r18 = r12
                        L_0x014c:
                            r16 = r14
                            r17 = r15
                            r14 = r7
                            goto L_0x0158
                        L_0x0152:
                            r0 = move-exception
                            r21 = r3
                            r18 = r5
                            goto L_0x014c
                        L_0x0158:
                            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r3 == 0) goto L_0x019e
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                            goto L_0x019e
                        L_0x0164:
                            r21 = r3
                            r18 = r5
                            r16 = r14
                            r17 = r15
                            r14 = r7
                            r15 = r8
                            java.lang.String r3 = "开始下载 html 类型的 template"
                            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r2, (java.lang.String) r3)
                            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r3 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()     // Catch:{ Exception -> 0x0192 }
                            com.mbridge.msdk.reward.adapter.b$d r4 = new com.mbridge.msdk.reward.adapter.b$d     // Catch:{ Exception -> 0x0192 }
                            java.lang.String r6 = r6     // Catch:{ Exception -> 0x0192 }
                            java.lang.String r7 = r4     // Catch:{ Exception -> 0x0192 }
                            java.lang.String r8 = r7     // Catch:{ Exception -> 0x0192 }
                            com.mbridge.msdk.reward.adapter.b$i r10 = r8     // Catch:{ Exception -> 0x0192 }
                            com.mbridge.msdk.reward.adapter.b r5 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x0192 }
                            com.mbridge.msdk.reward.adapter.b$h r11 = r5.f14967a     // Catch:{ Exception -> 0x0192 }
                            java.util.concurrent.CopyOnWriteArrayList r12 = r2     // Catch:{ Exception -> 0x0192 }
                            r5 = 859(0x35b, float:1.204E-42)
                            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0192 }
                            r3.downloadH5Res(r15, r0, r4)     // Catch:{ Exception -> 0x0192 }
                            goto L_0x019e
                        L_0x0192:
                            r0 = move-exception
                            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r3 == 0) goto L_0x019e
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                        L_0x019e:
                            java.lang.String r10 = r9.getendcard_url()
                            boolean r0 = r9.isDynamicView()
                            boolean r3 = com.mbridge.msdk.foundation.tools.ak.l((java.lang.String) r10)
                            boolean r4 = android.text.TextUtils.isEmpty(r10)
                            if (r4 != 0) goto L_0x020a
                            if (r0 != 0) goto L_0x01c4
                            com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this
                            android.content.Context r5 = r3
                            java.lang.String r6 = r6
                            java.lang.String r7 = r4
                            java.lang.String r8 = r7
                            com.mbridge.msdk.reward.adapter.b$i r11 = r8
                            java.util.concurrent.CopyOnWriteArrayList r12 = r2
                            com.mbridge.msdk.reward.adapter.b.a(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                            goto L_0x020a
                        L_0x01c4:
                            if (r3 == 0) goto L_0x01d8
                            com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this
                            android.content.Context r5 = r3
                            java.lang.String r6 = r6
                            java.lang.String r7 = r4
                            java.lang.String r8 = r7
                            com.mbridge.msdk.reward.adapter.b$i r11 = r8
                            java.util.concurrent.CopyOnWriteArrayList r12 = r2
                            com.mbridge.msdk.reward.adapter.b.a(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                            goto L_0x020a
                        L_0x01d8:
                            boolean r0 = com.mbridge.msdk.foundation.tools.ak.a((java.lang.String) r14, (java.lang.String) r10)
                            if (r0 == 0) goto L_0x020a
                            java.lang.String r0 = "ecid"
                            java.lang.String r0 = com.mbridge.msdk.foundation.tools.aq.a(r10, r0)     // Catch:{ all -> 0x01e9 }
                            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x01e9 }
                            goto L_0x01f3
                        L_0x01e9:
                            r0 = move-exception
                            java.lang.String r0 = r0.getMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                            r0 = 404(0x194, float:5.66E-43)
                        L_0x01f3:
                            com.mbridge.msdk.reward.adapter.b r3 = com.mbridge.msdk.reward.adapter.b.this
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            r4.<init>()
                            r4.append(r0)
                            r12 = r18
                            r4.append(r12)
                            java.lang.String r0 = r4.toString()
                            r11 = 2
                            r3.a(r11, r9, r0, r10)
                        L_0x020a:
                            java.lang.String r0 = r9.getEndScreenUrl()
                            boolean r0 = android.text.TextUtils.isEmpty(r0)
                            if (r0 != 0) goto L_0x022c
                            boolean r0 = r9.isDynamicView()
                            if (r0 != 0) goto L_0x022c
                            com.mbridge.msdk.reward.adapter.b r0 = com.mbridge.msdk.reward.adapter.b.this
                            r3 = 6
                            com.mbridge.msdk.foundation.same.report.d.c r0 = r0.a((com.mbridge.msdk.foundation.entity.CampaignEx) r9, (int) r3)
                            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r3 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()
                            java.lang.String r4 = r9.getEndScreenUrl()
                            r3.download(r0, r4)
                        L_0x022c:
                            java.lang.String r0 = r9.getIconUrl()
                            boolean r3 = android.text.TextUtils.isEmpty(r0)
                            if (r3 != 0) goto L_0x0263
                            android.content.Context r3 = r3     // Catch:{ Exception -> 0x0254 }
                            com.mbridge.msdk.foundation.same.c.b r3 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r3)     // Catch:{ Exception -> 0x0254 }
                            com.mbridge.msdk.reward.adapter.b$e r4 = new com.mbridge.msdk.reward.adapter.b$e     // Catch:{ Exception -> 0x0254 }
                            com.mbridge.msdk.reward.adapter.b r5 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x0254 }
                            com.mbridge.msdk.reward.adapter.b$h r5 = r5.f14967a     // Catch:{ Exception -> 0x0254 }
                            java.lang.String r7 = r6     // Catch:{ Exception -> 0x0254 }
                            java.lang.String r8 = r4     // Catch:{ Exception -> 0x0254 }
                            r10 = r9
                            java.lang.String r9 = r7     // Catch:{ Exception -> 0x0256 }
                            r6 = 0
                            r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0256 }
                            r9 = r10
                            r3.a(r0, r4)     // Catch:{ Exception -> 0x0254 }
                            goto L_0x0263
                        L_0x0254:
                            r0 = move-exception
                            goto L_0x0258
                        L_0x0256:
                            r0 = move-exception
                            r9 = r10
                        L_0x0258:
                            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r3 == 0) goto L_0x0263
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                        L_0x0263:
                            java.lang.String r0 = r9.getImageUrl()
                            boolean r3 = android.text.TextUtils.isEmpty(r0)
                            if (r3 != 0) goto L_0x029a
                            android.content.Context r3 = r3     // Catch:{ Exception -> 0x028b }
                            com.mbridge.msdk.foundation.same.c.b r3 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r3)     // Catch:{ Exception -> 0x028b }
                            com.mbridge.msdk.reward.adapter.b$e r4 = new com.mbridge.msdk.reward.adapter.b$e     // Catch:{ Exception -> 0x028b }
                            com.mbridge.msdk.reward.adapter.b r5 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x028b }
                            com.mbridge.msdk.reward.adapter.b$h r5 = r5.f14967a     // Catch:{ Exception -> 0x028b }
                            java.lang.String r7 = r6     // Catch:{ Exception -> 0x028b }
                            java.lang.String r8 = r4     // Catch:{ Exception -> 0x028b }
                            r10 = r9
                            java.lang.String r9 = r7     // Catch:{ Exception -> 0x028d }
                            r6 = 0
                            r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x028d }
                            r9 = r10
                            r3.a(r0, r4)     // Catch:{ Exception -> 0x028b }
                            goto L_0x029a
                        L_0x028b:
                            r0 = move-exception
                            goto L_0x028f
                        L_0x028d:
                            r0 = move-exception
                            r9 = r10
                        L_0x028f:
                            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r3 == 0) goto L_0x029a
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                        L_0x029a:
                            if (r16 == 0) goto L_0x0397
                            java.lang.String r0 = r16.c()
                            boolean r3 = android.text.TextUtils.isEmpty(r0)
                            if (r3 != 0) goto L_0x0329
                            boolean r3 = r9.isDynamicView()
                            if (r3 != 0) goto L_0x0329
                            com.mbridge.msdk.foundation.entity.AabEntity r3 = r9.getAabEntity()
                            if (r3 == 0) goto L_0x02b9
                            com.mbridge.msdk.foundation.entity.AabEntity r3 = r9.getAabEntity()
                            int r3 = r3.h3c
                            goto L_0x02ba
                        L_0x02b9:
                            r3 = 0
                        L_0x02ba:
                            com.mbridge.msdk.foundation.same.report.d.c r14 = new com.mbridge.msdk.foundation.same.report.d.c
                            r13 = 1
                            r14.<init>(r13)
                            r14.c((int) r3)
                            r3 = r17
                            boolean r3 = r0.contains(r3)
                            if (r3 == 0) goto L_0x02fe
                            java.lang.String r3 = "开始下载 zip 类型的 pause"
                            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r2, (java.lang.String) r3)
                            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r3 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()     // Catch:{ Exception -> 0x02f1 }
                            com.mbridge.msdk.reward.adapter.b$g r4 = new com.mbridge.msdk.reward.adapter.b$g     // Catch:{ Exception -> 0x02f1 }
                            android.content.Context r5 = r3     // Catch:{ Exception -> 0x02f1 }
                            java.lang.String r6 = r6     // Catch:{ Exception -> 0x02f1 }
                            java.lang.String r7 = r4     // Catch:{ Exception -> 0x02f1 }
                            java.lang.String r8 = r7     // Catch:{ Exception -> 0x02f1 }
                            com.mbridge.msdk.reward.adapter.b r10 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x02f1 }
                            com.mbridge.msdk.reward.adapter.b$h r11 = r10.f14967a     // Catch:{ Exception -> 0x02f1 }
                            com.mbridge.msdk.reward.adapter.b$i r12 = r8     // Catch:{ Exception -> 0x02f1 }
                            java.util.concurrent.CopyOnWriteArrayList r13 = r2     // Catch:{ Exception -> 0x02f1 }
                            r10 = 313(0x139, float:4.39E-43)
                            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x02f1 }
                            r3.downloadH5Res(r14, r0, r4)     // Catch:{ Exception -> 0x02f1 }
                            goto L_0x0329
                        L_0x02f1:
                            r0 = move-exception
                            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r3 == 0) goto L_0x0329
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                            goto L_0x0329
                        L_0x02fe:
                            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r3 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()     // Catch:{ Exception -> 0x031d }
                            com.mbridge.msdk.reward.adapter.b$d r4 = new com.mbridge.msdk.reward.adapter.b$d     // Catch:{ Exception -> 0x031d }
                            java.lang.String r6 = r6     // Catch:{ Exception -> 0x031d }
                            java.lang.String r7 = r4     // Catch:{ Exception -> 0x031d }
                            java.lang.String r8 = r7     // Catch:{ Exception -> 0x031d }
                            com.mbridge.msdk.reward.adapter.b$i r10 = r8     // Catch:{ Exception -> 0x031d }
                            com.mbridge.msdk.reward.adapter.b r5 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x031d }
                            com.mbridge.msdk.reward.adapter.b$h r11 = r5.f14967a     // Catch:{ Exception -> 0x031d }
                            java.util.concurrent.CopyOnWriteArrayList r12 = r2     // Catch:{ Exception -> 0x031d }
                            r5 = 313(0x139, float:4.39E-43)
                            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x031d }
                            r3.downloadH5Res(r14, r0, r4)     // Catch:{ Exception -> 0x031d }
                            goto L_0x0329
                        L_0x031d:
                            r0 = move-exception
                            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r3 == 0) goto L_0x0329
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                        L_0x0329:
                            java.util.List r0 = r16.a()
                            if (r0 == 0) goto L_0x0397
                            int r3 = r0.size()
                            if (r3 <= 0) goto L_0x0397
                            java.util.Iterator r3 = r0.iterator()
                        L_0x0339:
                            boolean r0 = r3.hasNext()
                            if (r0 == 0) goto L_0x0397
                            java.lang.Object r0 = r3.next()
                            com.mbridge.msdk.foundation.entity.CampaignEx$c$a r0 = (com.mbridge.msdk.foundation.entity.CampaignEx.c.a) r0
                            if (r0 == 0) goto L_0x0339
                            java.util.List<java.lang.String> r4 = r0.f12964a
                            if (r4 == 0) goto L_0x0339
                            int r4 = r4.size()
                            if (r4 <= 0) goto L_0x0339
                            java.util.List<java.lang.String> r0 = r0.f12964a
                            java.util.Iterator r11 = r0.iterator()
                        L_0x0357:
                            boolean r0 = r11.hasNext()
                            if (r0 == 0) goto L_0x0339
                            java.lang.Object r0 = r11.next()
                            java.lang.String r0 = (java.lang.String) r0
                            boolean r4 = android.text.TextUtils.isEmpty(r0)
                            if (r4 != 0) goto L_0x0357
                            android.content.Context r4 = r3     // Catch:{ Exception -> 0x0387 }
                            com.mbridge.msdk.foundation.same.c.b r12 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r4)     // Catch:{ Exception -> 0x0387 }
                            com.mbridge.msdk.reward.adapter.b$e r4 = new com.mbridge.msdk.reward.adapter.b$e     // Catch:{ Exception -> 0x0387 }
                            com.mbridge.msdk.reward.adapter.b r5 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x0387 }
                            com.mbridge.msdk.reward.adapter.b$h r5 = r5.f14967a     // Catch:{ Exception -> 0x0387 }
                            java.lang.String r7 = r6     // Catch:{ Exception -> 0x0387 }
                            java.lang.String r8 = r4     // Catch:{ Exception -> 0x0387 }
                            r10 = r9
                            java.lang.String r9 = r7     // Catch:{ Exception -> 0x0389 }
                            r6 = 1
                            r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0389 }
                            r9 = r10
                            r12.a(r0, r4)     // Catch:{ Exception -> 0x0387 }
                            goto L_0x0357
                        L_0x0387:
                            r0 = move-exception
                            goto L_0x038b
                        L_0x0389:
                            r0 = move-exception
                            r9 = r10
                        L_0x038b:
                            boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r4 == 0) goto L_0x0357
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                            goto L_0x0357
                        L_0x0397:
                            r3 = r21
                            goto L_0x0053
                        L_0x039b:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.AnonymousClass1.run():void");
                    }
                });
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static com.mbridge.msdk.foundation.c.b b(int i4, MBridgeIds mBridgeIds, String str, Throwable th, CampaignEx campaignEx) {
        com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(i4);
        bVar.a(mBridgeIds);
        bVar.a(th);
        bVar.a(str);
        bVar.a(campaignEx);
        return bVar;
    }

    private static final class f implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a  reason: collision with root package name */
        private Handler f15060a;

        /* renamed from: b  reason: collision with root package name */
        private final String f15061b;

        /* renamed from: c  reason: collision with root package name */
        private final String f15062c;

        /* renamed from: d  reason: collision with root package name */
        private final String f15063d;

        public f(Handler handler, String str, String str2, String str3) {
            this.f15060a = handler;
            this.f15062c = str;
            this.f15061b = str2;
            this.f15063d = str3;
        }

        public final void a(String str) {
            ResDownloadCheckManager.getInstance().setVideoDownloadDone(str, true);
            Message obtain = Message.obtain();
            obtain.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15061b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f15062c);
            bundle.putString("request_id", this.f15063d);
            bundle.putString("url", str);
            obtain.setData(bundle);
            this.f15060a.sendMessage(obtain);
        }

        public final void a(String str, String str2) {
            ResDownloadCheckManager.getInstance().setVideoDownloadDone(str2, false);
            Message obtain = Message.obtain();
            obtain.what = 200;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f15061b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f15062c);
            bundle.putString("request_id", this.f15063d);
            bundle.putString("url", str2);
            bundle.putString("message", str);
            obtain.setData(bundle);
            this.f15060a.sendMessage(obtain);
        }
    }

    /* access modifiers changed from: private */
    public void a(final int i4, final CampaignEx campaignEx, String str, String str2) {
        com.mbridge.msdk.foundation.tools.o.a(i4, str, str2, new o.a() {
            public final void a(String str, String str2, String str3, String str4, boolean z4) {
                if (!z4) {
                    try {
                        n nVar = new n();
                        int i4 = i4;
                        if (i4 == 0) {
                            nVar.e(1);
                            nVar.b(1);
                            nVar.a("m_download_end");
                        } else if (i4 == 1) {
                            nVar.e(2);
                            nVar.b(1);
                            nVar.a("m_download_end");
                        } else if (i4 == 2) {
                            nVar.e(3);
                            nVar.b(1);
                            nVar.a("m_download_end");
                            nVar.d(campaignEx.isMraid() ? n.f13061a : n.f13062b);
                            nVar.o("1");
                        }
                        nVar.g(campaignEx.getRequestIdNotice());
                        nVar.a("url", str);
                        nVar.a("scenes", "1");
                        com.mbridge.msdk.foundation.same.report.d.d.a().a(nVar, campaignEx);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardCampaignsResourceManager", e5.getMessage());
                        }
                    }
                }
            }

            public final void a(String str, DownloadError downloadError) {
                String str2 = "";
                if (downloadError != null) {
                    try {
                        if (downloadError.getException() != null) {
                            str2 = downloadError.getException().getMessage();
                        }
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                            return;
                        }
                        return;
                    }
                }
                n nVar = new n();
                int i4 = i4;
                if (i4 == 0) {
                    nVar.e(1);
                    nVar.b(3);
                    nVar.a("m_download_end");
                } else if (i4 == 1) {
                    nVar.e(2);
                    nVar.b(3);
                    nVar.a("m_download_end");
                } else if (i4 == 2) {
                    nVar.e(3);
                    nVar.b(3);
                    nVar.a("m_download_end");
                    nVar.d(campaignEx.isMraid() ? n.f13061a : n.f13062b);
                    nVar.o("1");
                }
                b.a(nVar, campaignEx);
                nVar.g(campaignEx.getRequestIdNotice());
                nVar.h(str2);
                nVar.a("scenes", "1");
                nVar.a("url", str);
                com.mbridge.msdk.foundation.same.report.d.d.a().a(nVar, campaignEx);
            }
        }, campaignEx);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0073, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.content.Context r12, com.mbridge.msdk.foundation.entity.CampaignEx r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, com.mbridge.msdk.reward.adapter.b.i r17) {
        /*
            r11 = this;
            r4 = r16
            r5 = r17
            monitor-enter(r11)
            com.mbridge.msdk.reward.adapter.b$h r0 = r11.f14967a     // Catch:{ all -> 0x0039 }
            r0.a(r12)     // Catch:{ all -> 0x0039 }
            r0 = 1
            if (r13 == 0) goto L_0x0074
            java.lang.String r1 = r13.getCMPTEntryUrl()     // Catch:{ all -> 0x0039 }
            boolean r2 = r13.isDynamicView()     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x0074
            java.lang.String r12 = "dyview"
            boolean r12 = com.mbridge.msdk.foundation.tools.ak.a((java.lang.String) r12, (java.lang.String) r1)     // Catch:{ all -> 0x0039 }
            if (r12 == 0) goto L_0x003d
            int r12 = r13.getMof_tplid()     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r2.<init>()     // Catch:{ all -> 0x0039 }
            r2.append(r12)     // Catch:{ all -> 0x0039 }
            java.lang.String r12 = ""
            r2.append(r12)     // Catch:{ all -> 0x0039 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x0039 }
            r2 = 0
            r11.a(r2, r13, r12, r1)     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r0 = move-exception
            r12 = r0
            goto L_0x00c8
        L_0x003d:
            com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager r12 = com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager.getInstance()     // Catch:{ all -> 0x0039 }
            r12.setZipDownloadDone(r1, r0)     // Catch:{ all -> 0x0039 }
            android.os.Message r12 = android.os.Message.obtain()     // Catch:{ all -> 0x0039 }
            r13 = 105(0x69, float:1.47E-43)
            r12.what = r13     // Catch:{ all -> 0x0039 }
            android.os.Bundle r13 = new android.os.Bundle     // Catch:{ all -> 0x0039 }
            r13.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = "unit_id"
            r13.putString(r0, r15)     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ all -> 0x0039 }
            r13.putString(r0, r14)     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = "request_id"
            r13.putString(r0, r4)     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = "url"
            r13.putString(r0, r1)     // Catch:{ all -> 0x0039 }
            r12.setData(r13)     // Catch:{ all -> 0x0039 }
            com.mbridge.msdk.reward.adapter.b$h r13 = r11.f14967a     // Catch:{ all -> 0x0039 }
            r13.sendMessage(r12)     // Catch:{ all -> 0x0039 }
            if (r5 == 0) goto L_0x0072
            r5.a(r14, r15, r4, r1)     // Catch:{ all -> 0x0039 }
        L_0x0072:
            monitor-exit(r11)
            return
        L_0x0074:
            if (r13 == 0) goto L_0x00c6
            java.lang.String r1 = r13.getCMPTEntryUrl()     // Catch:{ all -> 0x0039 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0039 }
            if (r1 != 0) goto L_0x00c6
            com.mbridge.msdk.foundation.same.report.d.d r1 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r2 = r13.getCurrentLocalRid()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r3 = ""
            com.mbridge.msdk.foundation.same.report.d.c r1 = r1.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0097 }
            if (r1 != 0) goto L_0x0095
            com.mbridge.msdk.foundation.same.report.d.c r1 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x0097 }
            r1.<init>()     // Catch:{ Exception -> 0x0097 }
        L_0x0095:
            r8 = r1
            goto L_0x009a
        L_0x0097:
            r0 = move-exception
            r12 = r0
            goto L_0x00bd
        L_0x009a:
            r8.a((com.mbridge.msdk.foundation.entity.CampaignEx) r13)     // Catch:{ Exception -> 0x0097 }
            r8.a((int) r0)     // Catch:{ Exception -> 0x0097 }
            int r0 = r11.a((com.mbridge.msdk.foundation.entity.CampaignEx) r13)     // Catch:{ Exception -> 0x0097 }
            r8.c((int) r0)     // Catch:{ Exception -> 0x0097 }
            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r9 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r10 = r13.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0097 }
            com.mbridge.msdk.reward.adapter.b$3 r0 = new com.mbridge.msdk.reward.adapter.b$3     // Catch:{ Exception -> 0x0097 }
            r1 = r11
            r6 = r12
            r7 = r13
            r3 = r14
            r2 = r15
            r0.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0097 }
            r9.downloadH5Res(r8, r10, r0)     // Catch:{ Exception -> 0x0097 }
            goto L_0x00c6
        L_0x00bd:
            java.lang.String r13 = "RewardCampaignsResourceManager"
            java.lang.String r12 = r12.getLocalizedMessage()     // Catch:{ all -> 0x0039 }
            com.mbridge.msdk.foundation.tools.af.b(r13, r12)     // Catch:{ all -> 0x0039 }
        L_0x00c6:
            monitor-exit(r11)
            return
        L_0x00c8:
            monitor-exit(r11)     // Catch:{ all -> 0x0039 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.a(android.content.Context, com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.String, java.lang.String, java.lang.String, com.mbridge.msdk.reward.adapter.b$i):void");
    }

    /* renamed from: com.mbridge.msdk.reward.adapter.b$b  reason: collision with other inner class name */
    private static class C0199b extends com.mbridge.msdk.mbsignalcommon.b.a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f15016a;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f15017b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f15018c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f15019d;

        /* renamed from: e  reason: collision with root package name */
        private int f15020e;

        /* renamed from: f  reason: collision with root package name */
        private String f15021f;

        /* renamed from: g  reason: collision with root package name */
        private String f15022g;

        /* renamed from: h  reason: collision with root package name */
        private String f15023h;

        /* renamed from: i  reason: collision with root package name */
        private String f15024i;

        /* renamed from: j  reason: collision with root package name */
        private a.C0208a f15025j;

        /* renamed from: k  reason: collision with root package name */
        private CampaignEx f15026k;

        /* renamed from: l  reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f15027l;

        /* renamed from: m  reason: collision with root package name */
        private com.mbridge.msdk.videocommon.d.c f15028m;

        /* renamed from: n  reason: collision with root package name */
        private final j f15029n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f15030o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f15031p;

        /* renamed from: q  reason: collision with root package name */
        private boolean f15032q;

        /* renamed from: r  reason: collision with root package name */
        private int f15033r = 0;

        /* renamed from: s  reason: collision with root package name */
        private boolean f15034s;

        /* renamed from: t  reason: collision with root package name */
        private long f15035t;

        public C0199b(boolean z4, Handler handler, Runnable runnable, boolean z5, boolean z6, int i4, String str, String str2, String str3, String str4, a.C0208a aVar, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.videocommon.d.c cVar, j jVar, boolean z7, long j4) {
            this.f15016a = handler;
            this.f15017b = runnable;
            this.f15018c = z5;
            this.f15019d = z6;
            this.f15020e = i4;
            this.f15021f = str;
            this.f15023h = str2;
            this.f15022g = str3;
            this.f15024i = str4;
            this.f15025j = aVar;
            this.f15026k = campaignEx;
            this.f15027l = copyOnWriteArrayList;
            this.f15028m = cVar;
            this.f15029n = jVar;
            this.f15030o = z7;
            this.f15034s = z4;
            this.f15035t = j4;
        }

        public final void a(WebView webView, int i4) {
            Runnable runnable;
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("type", 1);
                eVar.a("result", Integer.valueOf(i4));
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000155", this.f15026k, eVar);
            } catch (Throwable th) {
                af.b("RVWindVaneWebView", th.getMessage());
            }
            if (!this.f15032q) {
                String str = this.f15022g + "_" + this.f15021f;
                if (i4 == 1) {
                    if (this.f15030o) {
                        com.mbridge.msdk.videocommon.a.e(this.f15022g + "_" + this.f15024i);
                    } else {
                        com.mbridge.msdk.videocommon.a.d(this.f15022g + "_" + this.f15024i);
                    }
                    com.mbridge.msdk.videocommon.a.a(this.f15022g + "_" + this.f15024i + "_" + this.f15021f, this.f15025j, true, this.f15030o);
                    Handler handler = this.f15016a;
                    if (!(handler == null || (runnable = this.f15017b) == null)) {
                        handler.removeCallbacks(runnable);
                    }
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f15022g + "_" + this.f15024i + "_" + this.f15021f, true);
                    a.C0208a aVar = this.f15025j;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    j jVar = this.f15029n;
                    if (jVar != null) {
                        jVar.a(str, this.f15023h, this.f15022g, this.f15024i, this.f15021f, this.f15025j);
                    }
                } else {
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f15022g + "_" + this.f15024i + "_" + this.f15021f, false);
                    a.C0208a aVar2 = this.f15025j;
                    if (aVar2 != null) {
                        aVar2.a(false);
                    }
                    if (this.f15029n != null) {
                        this.f15029n.a(str, this.f15024i, this.f15021f, this.f15025j, b.b(880008, new MBridgeIds(this.f15023h, this.f15022g, this.f15024i), "readyState:" + i4, (Throwable) null, this.f15026k));
                    }
                }
                this.f15032q = true;
            }
        }

        public final void a(WebView webView, String str, String str2, int i4, int i5) {
            boolean z4 = true;
            if (i4 == 1) {
                try {
                    com.mbridge.msdk.reward.b.a aVar = new com.mbridge.msdk.reward.b.a();
                    aVar.b(false);
                    if (i5 != 2) {
                        z4 = false;
                    }
                    aVar.a(z4);
                    aVar.b(str, str2);
                    aVar.a((InterVideoOutListener) new com.mbridge.msdk.video.bt.module.b.a((com.mbridge.msdk.video.bt.module.b.g) null));
                    aVar.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, i5, str2, true, 1));
                } catch (Exception e5) {
                    Exception exc = e5;
                    if (MBridgeConstans.DEBUG) {
                        af.b("RVWindVaneWebView", exc.getMessage());
                    }
                }
            }
        }

        public final void a(Object obj, String str) {
            Object obj2 = obj;
            if (obj2 != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        String optString = new JSONObject(str).optString("id");
                        com.mbridge.msdk.video.bt.a.d.c().a(obj2, optString);
                        String c5 = com.mbridge.msdk.video.bt.a.d.c().c(optString);
                        CampaignEx a5 = com.mbridge.msdk.video.bt.a.d.c().a(optString);
                        com.mbridge.msdk.videocommon.d.c b5 = com.mbridge.msdk.video.bt.a.d.c().b(optString);
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        copyOnWriteArrayList.add(a5);
                        WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj2).f14150b;
                        if (windVaneWebView != null) {
                            b a6 = m.f15132a;
                            boolean z4 = this.f15034s;
                            int i4 = this.f15033r == 0 ? 3 : 6;
                            b bVar = a6;
                            boolean z5 = z4;
                            if (!(a5 == null || b5 == null)) {
                                if (a5.getRewardTemplateMode() != null) {
                                    if (!TextUtils.isEmpty(c5)) {
                                        if (TextUtils.isEmpty(a5.getRewardTemplateMode().e())) {
                                            JSONObject jSONObject = new JSONObject();
                                            jSONObject.put("id", optString);
                                            JSONObject jSONObject2 = new JSONObject();
                                            jSONObject2.put("result", 1);
                                            jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "data is null");
                                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                                            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                                        } else if (TextUtils.isEmpty(a5.getRewardTemplateMode().e()) || !a5.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY)) {
                                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(z5, windVaneWebView, a5, copyOnWriteArrayList, c5, b5, optString) {

                                                /* renamed from: a  reason: collision with root package name */
                                                final /* synthetic */ boolean f14999a;

                                                /* renamed from: b  reason: collision with root package name */
                                                final /* synthetic */ WindVaneWebView f15000b;

                                                /* renamed from: c  reason: collision with root package name */
                                                final /* synthetic */ CampaignEx f15001c;

                                                /* renamed from: d  reason: collision with root package name */
                                                final /* synthetic */ CopyOnWriteArrayList f15002d;

                                                /* renamed from: e  reason: collision with root package name */
                                                final /* synthetic */ String f15003e;

                                                /* renamed from: f  reason: collision with root package name */
                                                final /* synthetic */ com.mbridge.msdk.videocommon.d.c f15004f;

                                                /* renamed from: g  reason: collision with root package name */
                                                final /* synthetic */ String f15005g;

                                                {
                                                    this.f14999a = r2;
                                                    this.f15000b = r3;
                                                    this.f15001c = r4;
                                                    this.f15002d = r5;
                                                    this.f15003e = r6;
                                                    this.f15004f = r7;
                                                    this.f15005g = r8;
                                                }

                                                public final void run() {
                                                    WindVaneWebView windVaneWebView;
                                                    com.mbridge.msdk.video.signal.a.k kVar;
                                                    boolean z4 = this.f14999a;
                                                    WindVaneWebView windVaneWebView2 = this.f15000b;
                                                    String e5 = this.f15001c.getRewardTemplateMode().e();
                                                    CampaignEx campaignEx = this.f15001c;
                                                    CopyOnWriteArrayList copyOnWriteArrayList = this.f15002d;
                                                    String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(this.f15001c.getRewardTemplateMode().e());
                                                    String str = this.f15003e;
                                                    com.mbridge.msdk.videocommon.d.c cVar = this.f15004f;
                                                    String str2 = this.f15005g;
                                                    boolean b5 = b.this.f14968c;
                                                    try {
                                                        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                                                        eVar.a("type", 2);
                                                        com.mbridge.msdk.foundation.same.report.d.d.a().a("2000154", campaignEx, eVar);
                                                        a.C0208a aVar = new a.C0208a();
                                                        WindVaneWebView windVaneWebView3 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.c.m().c());
                                                        if (campaignEx != null) {
                                                            windVaneWebView3.setLocalRequestId(campaignEx.getCurrentLocalRid());
                                                        }
                                                        windVaneWebView3.setTempTypeForMetrics(2);
                                                        aVar.a(windVaneWebView3);
                                                        String str3 = "";
                                                        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                                                            windVaneWebView = windVaneWebView2;
                                                            kVar = new com.mbridge.msdk.video.signal.a.k((Activity) null, campaignEx);
                                                            if (campaignEx != null) {
                                                                str3 = campaignEx.getRequestId();
                                                            }
                                                        } else {
                                                            CopyOnWriteArrayList<CampaignEx> a5 = com.mbridge.msdk.videocommon.download.b.getInstance().a(str);
                                                            if (a5 != null && a5.size() > 0) {
                                                                int i4 = 0;
                                                                while (i4 < copyOnWriteArrayList.size()) {
                                                                    CampaignEx campaignEx2 = (CampaignEx) copyOnWriteArrayList.get(i4);
                                                                    for (CampaignEx next : a5) {
                                                                        WindVaneWebView windVaneWebView4 = windVaneWebView2;
                                                                        if (next.getId().equals(campaignEx2.getId()) && next.getRequestId().equals(campaignEx2.getRequestId())) {
                                                                            campaignEx2.setReady(true);
                                                                            copyOnWriteArrayList.set(i4, campaignEx2);
                                                                        }
                                                                        windVaneWebView2 = windVaneWebView4;
                                                                    }
                                                                    WindVaneWebView windVaneWebView5 = windVaneWebView2;
                                                                    i4++;
                                                                }
                                                            }
                                                            windVaneWebView = windVaneWebView2;
                                                            kVar = new com.mbridge.msdk.video.signal.a.k((Activity) null, campaignEx, copyOnWriteArrayList);
                                                            str3 = ((CampaignEx) copyOnWriteArrayList.get(0)).getRequestId();
                                                        }
                                                        kVar.a(0);
                                                        kVar.a(str);
                                                        kVar.c(str2);
                                                        kVar.a(cVar);
                                                        kVar.d(z4);
                                                        windVaneWebView3.setWebViewListener(new l(str2, false, windVaneWebView, e5, str, aVar, campaignEx, b5, str3));
                                                        windVaneWebView3.setObject(kVar);
                                                        windVaneWebView3.loadUrl(h5ResAddress);
                                                        windVaneWebView3.setRid(str3);
                                                    } catch (Exception e6) {
                                                        if (MBridgeConstans.DEBUG) {
                                                            af.b("RewardCampaignsResourceManager", e6.getLocalizedMessage());
                                                        }
                                                    }
                                                }
                                            }, (long) (i4 * 1000));
                                        } else {
                                            af.a("RewardCampaignsResourceManager", "getTeamplateUrl contains cmpt=1");
                                        }
                                        this.f15033r++;
                                    }
                                }
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            try {
                                jSONObject3.put("id", optString);
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("result", 2);
                                jSONObject4.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "data is null");
                                jSONObject3.put(DataSchemeDataSource.SCHEME_DATA, jSONObject4);
                                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                            } catch (Exception e5) {
                                if (MBridgeConstans.DEBUG) {
                                    af.b("RewardCampaignsResourceManager", e5.getLocalizedMessage());
                                }
                            }
                            this.f15033r++;
                        }
                    }
                } catch (Exception e6) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardCampaignsResourceManager", e6.getLocalizedMessage());
                    }
                } catch (Throwable th) {
                    af.b("RVWindVaneWebView", th.getMessage());
                }
            }
        }

        public final void a(WebView webView, String str) {
            Runnable runnable;
            super.a(webView, str);
            if (!this.f15031p) {
                String str2 = this.f15022g + "_" + this.f15021f;
                if (!str.contains("wfr=1")) {
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f15022g + "_" + this.f15024i + "_" + this.f15021f, true);
                    Handler handler = this.f15016a;
                    if (!(handler == null || (runnable = this.f15017b) == null)) {
                        handler.removeCallbacks(runnable);
                    }
                    a.C0208a aVar = this.f15025j;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    j jVar = this.f15029n;
                    if (jVar != null) {
                        jVar.a(str2, this.f15023h, this.f15022g, this.f15024i, this.f15021f, this.f15025j);
                    }
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
                this.f15031p = true;
            }
        }

        public final void a(WebView webView, int i4, String str, String str2) {
            super.a(webView, i4, str, str2);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f15022g + "_" + this.f15024i + "_" + this.f15021f, false);
            if (this.f15029n != null) {
                String str3 = this.f15022g + "_" + this.f15021f;
                a.C0208a aVar = this.f15025j;
                if (aVar != null) {
                    aVar.a(false);
                }
                this.f15029n.a(str3, this.f15024i, this.f15021f, this.f15025j, b.b(880008, new MBridgeIds(this.f15023h, this.f15022g, this.f15024i), "onReceivedError： " + i4 + "  " + str, (Throwable) null, this.f15026k));
            }
        }

        public final void a(WebView webView) {
            if (webView != null) {
                try {
                    LinkedHashMap<String, View> b5 = com.mbridge.msdk.video.bt.a.d.c().b(this.f15022g, this.f15024i);
                    if (b5 == null) {
                        return;
                    }
                    if (!b5.isEmpty()) {
                        for (View next : b5.values()) {
                            if (next instanceof MBridgeBTContainer) {
                                ((MBridgeBTContainer) next).addNativeCloseButtonWhenWebViewCrash();
                            }
                        }
                    }
                } catch (Throwable th) {
                    af.b("RVWindVaneWebView", th.getMessage());
                }
            }
        }
    }

    private static class k extends com.mbridge.msdk.mbsignalcommon.b.b {

        /* renamed from: a  reason: collision with root package name */
        private Handler f15089a;

        /* renamed from: b  reason: collision with root package name */
        private Runnable f15090b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f15091c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f15092d;

        /* renamed from: e  reason: collision with root package name */
        private String f15093e;

        /* renamed from: f  reason: collision with root package name */
        private final j f15094f;

        /* renamed from: g  reason: collision with root package name */
        private final WindVaneWebView f15095g;

        /* renamed from: h  reason: collision with root package name */
        private final String f15096h;

        /* renamed from: i  reason: collision with root package name */
        private final String f15097i;

        /* renamed from: j  reason: collision with root package name */
        private final String f15098j;

        /* renamed from: k  reason: collision with root package name */
        private final a.C0208a f15099k;

        /* renamed from: l  reason: collision with root package name */
        private final CampaignEx f15100l;

        /* renamed from: m  reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f15101m;

        /* renamed from: n  reason: collision with root package name */
        private long f15102n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f15103o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f15104p;

        /* renamed from: q  reason: collision with root package name */
        private final Runnable f15105q;

        /* renamed from: r  reason: collision with root package name */
        private final Runnable f15106r;

        public k(Handler handler, Runnable runnable, boolean z4, boolean z5, String str, j jVar, WindVaneWebView windVaneWebView, String str2, String str3, String str4, a.C0208a aVar, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, long j4) {
            this.f15089a = handler;
            this.f15090b = runnable;
            this.f15091c = z4;
            this.f15092d = z5;
            this.f15093e = str;
            this.f15094f = jVar;
            this.f15095g = windVaneWebView;
            final String str5 = str2;
            this.f15096h = str5;
            final String str6 = str4;
            this.f15097i = str6;
            final String str7 = str3;
            this.f15098j = str7;
            final a.C0208a aVar2 = aVar;
            this.f15099k = aVar2;
            this.f15100l = campaignEx;
            this.f15101m = copyOnWriteArrayList;
            this.f15102n = j4;
            final String str8 = str;
            final j jVar2 = jVar;
            AnonymousClass1 r10 = new Runnable() {
                public final void run() {
                    WindVaneWebView a5;
                    a.C0208a aVar;
                    if (!(jVar2 == null || (aVar = aVar2) == null)) {
                        aVar.a(true);
                        ResDownloadCheckManager instance = ResDownloadCheckManager.getInstance();
                        instance.setTemplatePreLoadDone(str6 + "_" + str8 + "_" + str5, true);
                        j jVar = jVar2;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str6);
                        sb.append("_");
                        sb.append(str5);
                        jVar.a(sb.toString(), str7, str6, str8, str5, aVar2);
                    }
                    a.C0208a aVar2 = aVar2;
                    if (aVar2 != null && (a5 = aVar2.a()) != null) {
                        try {
                            a5.release();
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("WindVaneWebView", e5.getMessage());
                            }
                        }
                    }
                }
            };
            this.f15106r = r10;
            this.f15105q = new Runnable() {
                public final void run() {
                    WindVaneWebView a5;
                    a.C0208a aVar;
                    if (!(jVar2 == null || (aVar = aVar2) == null)) {
                        aVar.a(true);
                        ResDownloadCheckManager instance = ResDownloadCheckManager.getInstance();
                        instance.setTemplatePreLoadDone(str6 + "_" + str8 + "_" + str5, true);
                        j jVar = jVar2;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str6);
                        sb.append("_");
                        sb.append(str5);
                        jVar.a(sb.toString(), str7, str6, str8, str5, aVar2);
                    }
                    a.C0208a aVar2 = aVar2;
                    if (aVar2 != null && (a5 = aVar2.a()) != null) {
                        try {
                            a5.release();
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("WindVaneWebView", e5.getMessage());
                            }
                        }
                    }
                }
            };
            if (handler != null) {
                handler.postDelayed(r10, 5000);
            }
        }

        public final void a(WebView webView, int i4) {
            Handler handler;
            Runnable runnable;
            Runnable runnable2;
            super.a(webView, i4);
            Handler handler2 = this.f15089a;
            if (!(handler2 == null || (runnable2 = this.f15105q) == null)) {
                handler2.removeCallbacks(runnable2);
            }
            Handler handler3 = this.f15089a;
            if (!(handler3 == null || (runnable = this.f15106r) == null)) {
                handler3.removeCallbacks(runnable);
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("type", 2);
                eVar.a("result", Integer.valueOf(i4));
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000155", this.f15100l, eVar);
            } catch (Throwable th) {
                af.b("WindVaneWebView", th.getMessage());
            }
            if (!this.f15104p) {
                String str = this.f15097i + "_" + this.f15096h;
                if (i4 == 1) {
                    Runnable runnable3 = this.f15090b;
                    if (!(runnable3 == null || (handler = this.f15089a) == null)) {
                        handler.removeCallbacks(runnable3);
                    }
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f15097i + "_" + this.f15093e + "_" + this.f15096h, true);
                    a.C0208a aVar = this.f15099k;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    if (this.f15091c) {
                        if (this.f15092d) {
                            com.mbridge.msdk.videocommon.a.a(287, this.f15100l.getRequestIdNotice(), this.f15099k);
                        } else {
                            com.mbridge.msdk.videocommon.a.b(287, this.f15100l.getRequestIdNotice(), this.f15099k);
                        }
                    } else if (this.f15092d) {
                        com.mbridge.msdk.videocommon.a.a(94, this.f15100l.getRequestIdNotice(), this.f15099k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(94, this.f15100l.getRequestIdNotice(), this.f15099k);
                    }
                    j jVar = this.f15094f;
                    if (jVar != null) {
                        jVar.a(str, this.f15098j, this.f15097i, this.f15093e, this.f15096h, this.f15099k);
                    }
                } else if (this.f15094f != null) {
                    this.f15094f.a(str, this.f15093e, this.f15096h, this.f15099k, b.b(880009, new MBridgeIds(this.f15098j, this.f15097i, this.f15093e), "readyState:" + i4, (Throwable) null, this.f15100l));
                }
                this.f15104p = true;
            }
        }

        public final void a(WebView webView, int i4, String str, String str2) {
            super.a(webView, i4, str, str2);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f15097i + "_" + this.f15093e + "_" + this.f15096h, false);
            Handler handler = this.f15089a;
            if (handler != null) {
                if (this.f15105q != null) {
                    handler.removeCallbacks(this.f15106r);
                }
                Runnable runnable = this.f15105q;
                if (runnable != null) {
                    this.f15089a.removeCallbacks(runnable);
                }
            }
            try {
                String str3 = this.f15097i + "_" + this.f15096h;
                a.C0208a aVar = this.f15099k;
                if (aVar != null) {
                    aVar.a(false);
                }
                if (this.f15094f != null) {
                    String str4 = str2;
                    this.f15094f.a(str3, this.f15093e, str4, this.f15099k, b.b(880009, new MBridgeIds(this.f15098j, this.f15097i, this.f15093e), i4 + "#" + str, (Throwable) null, this.f15100l));
                }
            } catch (Exception e5) {
                Exception exc = e5;
                if (MBridgeConstans.DEBUG) {
                    af.b("WindVaneWebView", exc.getLocalizedMessage());
                }
            }
        }

        public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.a(webView, sslErrorHandler, sslError);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f15097i + "_" + this.f15093e + "_" + this.f15096h, false);
            Handler handler = this.f15089a;
            if (handler != null) {
                if (this.f15105q != null) {
                    handler.removeCallbacks(this.f15106r);
                }
                Runnable runnable = this.f15105q;
                if (runnable != null) {
                    this.f15089a.removeCallbacks(runnable);
                }
            }
            try {
                String str = this.f15097i + "_" + this.f15096h;
                a.C0208a aVar = this.f15099k;
                if (aVar != null) {
                    aVar.a(false);
                }
                if (this.f15094f != null) {
                    MBridgeIds mBridgeIds = new MBridgeIds(this.f15098j, this.f15097i, this.f15093e);
                    StringBuilder sb = new StringBuilder();
                    sb.append("onReceivedSslError:");
                    sb.append(sslError == null ? "" : Integer.valueOf(sslError.getPrimaryError()));
                    this.f15094f.a(str, this.f15093e, this.f15096h, this.f15099k, b.b(880009, mBridgeIds, sb.toString(), (Throwable) null, this.f15100l));
                }
            } catch (Exception e5) {
                Exception exc = e5;
                if (MBridgeConstans.DEBUG) {
                    af.b("WindVaneWebView", exc.getLocalizedMessage());
                }
            }
        }

        public final void a(WebView webView, String str) {
            Runnable runnable;
            Handler handler;
            Runnable runnable2;
            super.a(webView, str);
            Handler handler2 = this.f15089a;
            if (!(handler2 == null || (runnable2 = this.f15106r) == null)) {
                handler2.removeCallbacks(runnable2);
            }
            if (!this.f15103o) {
                if (!str.contains("wfr=1")) {
                    String str2 = this.f15097i + "_" + this.f15096h;
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f15097i + "_" + this.f15093e + "_" + this.f15096h, true);
                    Runnable runnable3 = this.f15090b;
                    if (!(runnable3 == null || (handler = this.f15089a) == null)) {
                        handler.removeCallbacks(runnable3);
                    }
                    a.C0208a aVar = this.f15099k;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    if (this.f15091c) {
                        if (this.f15100l.isBidCampaign()) {
                            com.mbridge.msdk.videocommon.a.a(287, this.f15100l.getRequestIdNotice(), this.f15099k);
                        } else {
                            com.mbridge.msdk.videocommon.a.b(287, this.f15100l.getRequestIdNotice(), this.f15099k);
                        }
                    } else if (this.f15100l.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(94, this.f15100l.getRequestIdNotice(), this.f15099k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(94, this.f15100l.getRequestIdNotice(), this.f15099k);
                    }
                    j jVar = this.f15094f;
                    if (jVar != null) {
                        jVar.a(str2, this.f15098j, this.f15097i, this.f15093e, this.f15096h, this.f15099k);
                    }
                } else {
                    Handler handler3 = this.f15089a;
                    if (!(handler3 == null || (runnable = this.f15105q) == null)) {
                        handler3.postDelayed(runnable, 5000);
                    }
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
                this.f15103o = true;
            }
        }
    }

    private static class l extends com.mbridge.msdk.mbsignalcommon.b.b {

        /* renamed from: a  reason: collision with root package name */
        private String f15121a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f15122b;

        /* renamed from: c  reason: collision with root package name */
        private final WindVaneWebView f15123c;

        /* renamed from: d  reason: collision with root package name */
        private final String f15124d;

        /* renamed from: e  reason: collision with root package name */
        private final String f15125e;

        /* renamed from: f  reason: collision with root package name */
        private final a.C0208a f15126f;

        /* renamed from: g  reason: collision with root package name */
        private final CampaignEx f15127g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f15128h;

        /* renamed from: i  reason: collision with root package name */
        private String f15129i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f15130j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f15131k;

        public l(String str, boolean z4, WindVaneWebView windVaneWebView, String str2, String str3, a.C0208a aVar, CampaignEx campaignEx, boolean z5, String str4) {
            this.f15122b = z4;
            this.f15123c = windVaneWebView;
            this.f15124d = str2;
            this.f15125e = str3;
            this.f15126f = aVar;
            this.f15127g = campaignEx;
            this.f15121a = str;
            this.f15128h = z5;
            this.f15129i = str4;
        }

        public final void a(WebView webView, int i4) {
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("type", 2);
                eVar.a("result", Integer.valueOf(i4));
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000155", this.f15127g, eVar);
            } catch (Throwable th) {
                af.b("WindVaneWebView", th.getMessage());
            }
            if (!this.f15131k) {
                if (this.f15123c != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.f15121a);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", i4);
                        jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "");
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f15123c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("WindVaneWebView", e5.getLocalizedMessage());
                        }
                    }
                }
                String str = this.f15125e + "_" + this.f15127g.getId() + "_" + this.f15127g.getRequestId() + "_" + this.f15124d;
                if (i4 == 1) {
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f15125e + "_" + this.f15129i + "_" + this.f15124d, true);
                    a.C0208a aVar = this.f15126f;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    if (this.f15122b) {
                        if (this.f15127g.isBidCampaign()) {
                            com.mbridge.msdk.videocommon.a.a(str, this.f15126f, false, this.f15128h);
                        } else {
                            com.mbridge.msdk.videocommon.a.a(str, this.f15126f, false, this.f15128h);
                        }
                    } else if (this.f15127g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(str, this.f15126f, false, this.f15128h);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str, this.f15126f, false, this.f15128h);
                    }
                } else {
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f15125e + "_" + this.f15129i + "_" + this.f15124d, false);
                    a.C0208a aVar2 = this.f15126f;
                    if (aVar2 != null) {
                        aVar2.a(false);
                    }
                }
                this.f15131k = true;
            }
        }

        public final void a(WebView webView, int i4, String str, String str2) {
            ResDownloadCheckManager instance = ResDownloadCheckManager.getInstance();
            instance.setTemplatePreLoadDone(this.f15125e + "_" + this.f15129i + "_" + this.f15124d, false);
            a.C0208a aVar = this.f15126f;
            if (aVar != null) {
                aVar.a(false);
            }
            if (this.f15123c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f15121a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f15123c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("WindVaneWebView", e5.getLocalizedMessage());
                    }
                }
            }
        }

        public final void a(WebView webView, String str) {
            if (!this.f15130j) {
                if (!str.contains("wfr=1")) {
                    if (this.f15123c != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", this.f15121a);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("result", 1);
                            jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "");
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f15123c, "componentReact", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("WindVaneWebView", e5.getLocalizedMessage());
                            }
                        }
                    }
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f15125e + "_" + this.f15129i + "_" + this.f15124d, true);
                    a.C0208a aVar = this.f15126f;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    String str2 = this.f15125e + "_" + this.f15127g.getId() + "_" + this.f15127g.getRequestId() + "_" + this.f15124d;
                    if (this.f15122b) {
                        if (this.f15127g.isBidCampaign()) {
                            com.mbridge.msdk.videocommon.a.a(287, this.f15127g.getRequestIdNotice(), this.f15126f);
                        } else {
                            com.mbridge.msdk.videocommon.a.a(str2, this.f15126f, false, this.f15128h);
                        }
                    } else if (this.f15127g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(94, this.f15127g.getRequestIdNotice(), this.f15126f);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str2, this.f15126f, false, this.f15128h);
                    }
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
                this.f15130j = true;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0104 A[Catch:{ Exception -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(boolean r20, android.os.Handler r21, boolean r22, boolean r23, com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r24, java.lang.String r25, int r26, com.mbridge.msdk.foundation.entity.CampaignEx r27, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, com.mbridge.msdk.videocommon.d.c r34, com.mbridge.msdk.reward.adapter.b.j r35) {
        /*
            r19 = this;
            r6 = r25
            r12 = r27
            r13 = r28
            r4 = r31
            monitor-enter(r19)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r0.<init>()     // Catch:{ all -> 0x0034 }
            r0.append(r4)     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = "_"
            r0.append(r1)     // Catch:{ all -> 0x0034 }
            r0.append(r6)     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x0034 }
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0034 }
            boolean r0 = com.mbridge.msdk.foundation.tools.ak.i((java.lang.String) r6)     // Catch:{ Exception -> 0x018c }
            if (r0 == 0) goto L_0x0040
            if (r35 == 0) goto L_0x003e
            r7 = 0
            r3 = r30
            r5 = r32
            r1 = r35
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0037 }
            goto L_0x003e
        L_0x0034:
            r0 = move-exception
            goto L_0x01c2
        L_0x0037:
            r0 = move-exception
            r16 = r2
        L_0x003a:
            r5 = r32
            goto L_0x0191
        L_0x003e:
            monitor-exit(r19)
            return
        L_0x0040:
            r16 = r2
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x009d }
            r0.<init>()     // Catch:{ Exception -> 0x009d }
            java.lang.String r1 = "type"
            r2 = 2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x009d }
            r0.a(r1, r3)     // Catch:{ Exception -> 0x009d }
            com.mbridge.msdk.foundation.same.report.d.d r1 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x009d }
            java.lang.String r3 = "2000154"
            r1.a((java.lang.String) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r12, (com.mbridge.msdk.foundation.same.report.d.e) r0)     // Catch:{ Exception -> 0x009d }
            com.mbridge.msdk.videocommon.a$a r7 = new com.mbridge.msdk.videocommon.a$a     // Catch:{ Exception -> 0x009d }
            r7.<init>()     // Catch:{ Exception -> 0x009d }
            r0 = 1
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r1 = new com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView     // Catch:{ Exception -> 0x00fc, all -> 0x00f6 }
            com.mbridge.msdk.foundation.controller.c r3 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x00fc, all -> 0x00f6 }
            android.content.Context r3 = r3.c()     // Catch:{ Exception -> 0x00fc, all -> 0x00f6 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x00fc, all -> 0x00f6 }
            if (r12 == 0) goto L_0x0085
            java.lang.String r3 = r12.getCurrentLocalRid()     // Catch:{ Exception -> 0x007e, all -> 0x0077 }
            r1.setLocalRequestId(r3)     // Catch:{ Exception -> 0x007e, all -> 0x0077 }
            goto L_0x0085
        L_0x0077:
            r6 = r25
            r5 = r32
            goto L_0x0102
        L_0x007e:
            r6 = r25
            r5 = r32
            goto L_0x0147
        L_0x0085:
            r1.setTempTypeForMetrics(r2)     // Catch:{ Exception -> 0x00fc, all -> 0x00f6 }
            r7.a((com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView) r1)     // Catch:{ Exception -> 0x00f1 }
            r0 = 0
            if (r13 == 0) goto L_0x009f
            int r2 = r13.size()     // Catch:{ Exception -> 0x009d }
            if (r2 <= 0) goto L_0x009f
            com.mbridge.msdk.video.signal.a.k r2 = new com.mbridge.msdk.video.signal.a.k     // Catch:{ Exception -> 0x009d }
            r2.<init>(r0, r12, r13)     // Catch:{ Exception -> 0x009d }
        L_0x0099:
            r0 = r2
            r2 = r26
            goto L_0x00a5
        L_0x009d:
            r0 = move-exception
            goto L_0x003a
        L_0x009f:
            com.mbridge.msdk.video.signal.a.k r2 = new com.mbridge.msdk.video.signal.a.k     // Catch:{ Exception -> 0x00f1 }
            r2.<init>(r0, r12)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x0099
        L_0x00a5:
            r0.a((int) r2)     // Catch:{ Exception -> 0x00f1 }
            r0.a((java.lang.String) r4)     // Catch:{ Exception -> 0x00f1 }
            r2 = r34
            r0.a((com.mbridge.msdk.videocommon.d.c) r2)     // Catch:{ Exception -> 0x00f1 }
            r2 = r20
            r0.d((boolean) r2)     // Catch:{ Exception -> 0x00f1 }
            r2 = r0
            com.mbridge.msdk.reward.adapter.b$k r0 = new com.mbridge.msdk.reward.adapter.b$k     // Catch:{ Exception -> 0x00f1 }
            r3 = r2
            r2 = 0
            r8 = r25
            r9 = r30
            r5 = r32
            r6 = r35
            r17 = r1
            r18 = r3
            r10 = r4
            r11 = r7
            r1 = r21
            r3 = r22
            r4 = r23
            r7 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00ec }
            r6 = r8
            r4 = r10
            r1 = r17
            r1.setWebViewListener(r0)     // Catch:{ Exception -> 0x00e9 }
            r2 = r18
            r1.setObject(r2)     // Catch:{ Exception -> 0x00e9 }
            r0 = r29
            r1.loadUrl(r0)     // Catch:{ Exception -> 0x00e9 }
            r1.setRid(r5)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x01c0
        L_0x00e9:
            r0 = move-exception
            goto L_0x0191
        L_0x00ec:
            r0 = move-exception
            r6 = r8
            r4 = r10
            goto L_0x0191
        L_0x00f1:
            r0 = move-exception
            r6 = r25
            goto L_0x003a
        L_0x00f6:
            r6 = r25
            r5 = r32
            goto L_0x0102
        L_0x00fc:
            r6 = r25
            r5 = r32
            goto L_0x0147
        L_0x0102:
            if (r35 == 0) goto L_0x0145
            r7.a((boolean) r0)     // Catch:{ Exception -> 0x00e9 }
            com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager r1 = com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager.getInstance()     // Catch:{ Exception -> 0x00e9 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e9 }
            r2.<init>()     // Catch:{ Exception -> 0x00e9 }
            r2.append(r4)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ Exception -> 0x00e9 }
            r2.append(r5)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ Exception -> 0x00e9 }
            r2.append(r6)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00e9 }
            r1.setTemplatePreLoadDone(r2, r0)     // Catch:{ Exception -> 0x00e9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e9 }
            r0.<init>()     // Catch:{ Exception -> 0x00e9 }
            r0.append(r4)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r1 = "_"
            r0.append(r1)     // Catch:{ Exception -> 0x00e9 }
            r0.append(r6)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r2 = r0.toString()     // Catch:{ Exception -> 0x00e9 }
            r3 = r30
            r1 = r35
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00e9 }
        L_0x0145:
            monitor-exit(r19)
            return
        L_0x0147:
            if (r35 == 0) goto L_0x018a
            r7.a((boolean) r0)     // Catch:{ Exception -> 0x00e9 }
            com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager r1 = com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager.getInstance()     // Catch:{ Exception -> 0x00e9 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e9 }
            r2.<init>()     // Catch:{ Exception -> 0x00e9 }
            r2.append(r4)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ Exception -> 0x00e9 }
            r2.append(r5)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ Exception -> 0x00e9 }
            r2.append(r6)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00e9 }
            r1.setTemplatePreLoadDone(r2, r0)     // Catch:{ Exception -> 0x00e9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e9 }
            r0.<init>()     // Catch:{ Exception -> 0x00e9 }
            r0.append(r4)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r1 = "_"
            r0.append(r1)     // Catch:{ Exception -> 0x00e9 }
            r0.append(r6)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r2 = r0.toString()     // Catch:{ Exception -> 0x00e9 }
            r3 = r30
            r1 = r35
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00e9 }
        L_0x018a:
            monitor-exit(r19)
            return
        L_0x018c:
            r0 = move-exception
            r5 = r32
            r16 = r2
        L_0x0191:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x019e
            java.lang.String r1 = "RewardCampaignsResourceManager"
            java.lang.String r2 = r0.getLocalizedMessage()     // Catch:{ all -> 0x0034 }
            com.mbridge.msdk.foundation.tools.af.b(r1, r2)     // Catch:{ all -> 0x0034 }
        L_0x019e:
            if (r35 == 0) goto L_0x01c0
            com.mbridge.msdk.out.MBridgeIds r1 = new com.mbridge.msdk.out.MBridgeIds     // Catch:{ all -> 0x0034 }
            r3 = r30
            r1.<init>(r3, r4, r5)     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = ""
            r3 = 880009(0xd6d89, float:1.233155E-39)
            com.mbridge.msdk.foundation.c.b r0 = b(r3, r1, r2, r0, r12)     // Catch:{ all -> 0x0034 }
            r1 = 0
            r29 = r25
            r26 = r35
            r31 = r0
            r30 = r1
            r28 = r5
            r27 = r16
            r26.a(r27, r28, r29, r30, r31)     // Catch:{ all -> 0x0034 }
        L_0x01c0:
            monitor-exit(r19)
            return
        L_0x01c2:
            monitor-exit(r19)     // Catch:{ all -> 0x0034 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.a(boolean, android.os.Handler, boolean, boolean, com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView, java.lang.String, int, com.mbridge.msdk.foundation.entity.CampaignEx, java.util.concurrent.CopyOnWriteArrayList, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.mbridge.msdk.videocommon.d.c, com.mbridge.msdk.reward.adapter.b$j):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01b7 A[SYNTHETIC, Splitter:B:52:0x01b7] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(boolean r26, android.os.Handler r27, boolean r28, boolean r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, int r35, com.mbridge.msdk.foundation.entity.CampaignEx r36, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r37, java.lang.String r38, java.lang.String r39, com.mbridge.msdk.videocommon.d.c r40, com.mbridge.msdk.reward.adapter.b.j r41, boolean r42) {
        /*
            r25 = this;
            r1 = r25
            r5 = r33
            r14 = r36
            r15 = r37
            r0 = r42
            monitor-enter(r25)
            r1.f14968c = r0     // Catch:{ all -> 0x003c }
            long r19 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
            r2.<init>()     // Catch:{ all -> 0x003c }
            r2.append(r5)     // Catch:{ all -> 0x003c }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ all -> 0x003c }
            r7 = r34
            r2.append(r7)     // Catch:{ all -> 0x003c }
            java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x003c }
            r1.f14968c = r0     // Catch:{ all -> 0x003c }
            boolean r2 = com.mbridge.msdk.foundation.tools.ak.i((java.lang.String) r7)     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0041
            if (r41 == 0) goto L_0x003f
            r8 = 0
            r6 = r30
            r4 = r32
            r2 = r41
            r2.a(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x003c }
            goto L_0x003f
        L_0x003c:
            r0 = move-exception
            goto L_0x01e6
        L_0x003f:
            monitor-exit(r25)
            return
        L_0x0041:
            r21 = r3
            java.lang.String r2 = "RewardCampaignsResourceManager"
            java.lang.String r3 = "开始预加载大模板资源"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.foundation.same.report.d.e r2 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x007e }
            r2.<init>()     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = "type"
            r4 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x007e }
            r2.a(r3, r6)     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.foundation.same.report.d.d r3 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x007e }
            java.lang.String r6 = "2000154"
            r3.a((java.lang.String) r6, (com.mbridge.msdk.foundation.entity.CampaignEx) r14, (com.mbridge.msdk.foundation.same.report.d.e) r2)     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.videocommon.a$a r13 = new com.mbridge.msdk.videocommon.a$a     // Catch:{ Exception -> 0x007e }
            r13.<init>()     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = new com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.foundation.controller.c r3 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x007e }
            android.content.Context r3 = r3.c()     // Catch:{ Exception -> 0x007e }
            r2.<init>(r3)     // Catch:{ Exception -> 0x007e }
            if (r14 == 0) goto L_0x0083
            java.lang.String r3 = r14.getCurrentLocalRid()     // Catch:{ Exception -> 0x007e }
            r2.setLocalRequestId(r3)     // Catch:{ Exception -> 0x007e }
            goto L_0x0083
        L_0x007e:
            r0 = move-exception
            r6 = r30
            goto L_0x01b5
        L_0x0083:
            r2.setTempTypeForMetrics(r4)     // Catch:{ Exception -> 0x007e }
            r13.a((com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView) r2)     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.video.bt.a.d r3 = com.mbridge.msdk.video.bt.a.d.c()     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = r3.a()     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.video.bt.a.d r6 = com.mbridge.msdk.video.bt.a.d.c()     // Catch:{ Exception -> 0x007e }
            java.lang.String r6 = r6.a()     // Catch:{ Exception -> 0x007e }
            r13.a((java.lang.String) r6)     // Catch:{ Exception -> 0x007e }
            if (r15 == 0) goto L_0x0103
            int r8 = r15.size()     // Catch:{ Exception -> 0x007e }
            if (r8 <= 0) goto L_0x0103
            com.mbridge.msdk.videocommon.download.b r8 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch:{ Exception -> 0x007e }
            java.util.concurrent.CopyOnWriteArrayList r8 = r8.a((java.lang.String) r5)     // Catch:{ Exception -> 0x007e }
            if (r8 == 0) goto L_0x00fa
            int r9 = r8.size()     // Catch:{ Exception -> 0x007e }
            if (r9 <= 0) goto L_0x00fa
            r9 = 0
        L_0x00b5:
            int r10 = r15.size()     // Catch:{ Exception -> 0x007e }
            if (r9 >= r10) goto L_0x00fa
            java.lang.Object r10 = r15.get(r9)     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = (com.mbridge.msdk.foundation.entity.CampaignEx) r10     // Catch:{ Exception -> 0x007e }
            java.util.Iterator r11 = r8.iterator()     // Catch:{ Exception -> 0x007e }
        L_0x00c5:
            boolean r12 = r11.hasNext()     // Catch:{ Exception -> 0x007e }
            if (r12 == 0) goto L_0x00f6
            java.lang.Object r12 = r11.next()     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = (com.mbridge.msdk.foundation.entity.CampaignEx) r12     // Catch:{ Exception -> 0x007e }
            java.lang.String r7 = r12.getId()     // Catch:{ Exception -> 0x007e }
            java.lang.String r4 = r10.getId()     // Catch:{ Exception -> 0x007e }
            boolean r4 = r7.equals(r4)     // Catch:{ Exception -> 0x007e }
            if (r4 == 0) goto L_0x00f4
            java.lang.String r4 = r12.getRequestId()     // Catch:{ Exception -> 0x007e }
            java.lang.String r7 = r10.getRequestId()     // Catch:{ Exception -> 0x007e }
            boolean r4 = r4.equals(r7)     // Catch:{ Exception -> 0x007e }
            if (r4 == 0) goto L_0x00f4
            r4 = 1
            r10.setReady(r4)     // Catch:{ Exception -> 0x007e }
            r15.set(r9, r10)     // Catch:{ Exception -> 0x007e }
        L_0x00f4:
            r4 = 1
            goto L_0x00c5
        L_0x00f6:
            int r9 = r9 + 1
            r4 = 1
            goto L_0x00b5
        L_0x00fa:
            com.mbridge.msdk.video.signal.a.k r4 = new com.mbridge.msdk.video.signal.a.k     // Catch:{ Exception -> 0x007e }
            r7 = 0
            r4.<init>(r7, r14, r15)     // Catch:{ Exception -> 0x007e }
        L_0x0100:
            r8 = r35
            goto L_0x010a
        L_0x0103:
            com.mbridge.msdk.video.signal.a.k r4 = new com.mbridge.msdk.video.signal.a.k     // Catch:{ Exception -> 0x007e }
            r7 = 0
            r4.<init>(r7, r14)     // Catch:{ Exception -> 0x007e }
            goto L_0x0100
        L_0x010a:
            r4.a((int) r8)     // Catch:{ Exception -> 0x007e }
            r7 = r39
            r4.a((java.lang.String) r7)     // Catch:{ Exception -> 0x007e }
            r4.c((java.lang.String) r6)     // Catch:{ Exception -> 0x007e }
            r4.d((java.lang.String) r3)     // Catch:{ Exception -> 0x007e }
            r7 = 1
            r4.c((boolean) r7)     // Catch:{ Exception -> 0x007e }
            r7 = r40
            r4.a((com.mbridge.msdk.videocommon.d.c) r7)     // Catch:{ Exception -> 0x007e }
            r9 = r26
            r4.d((boolean) r9)     // Catch:{ Exception -> 0x007e }
            r10 = r2
            com.mbridge.msdk.reward.adapter.b$b r2 = new com.mbridge.msdk.reward.adapter.b$b     // Catch:{ Exception -> 0x007e }
            r5 = 0
            r12 = r30
            r11 = r33
            r17 = r41
            r18 = r0
            r22 = r3
            r24 = r4
            r23 = r6
            r16 = r7
            r3 = r9
            r0 = r10
            r4 = r27
            r6 = r28
            r7 = r29
            r10 = r32
            r9 = r34
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x01b2 }
            r5 = r11
            r6 = r12
            r0.setWebViewListener(r2)     // Catch:{ Exception -> 0x01b0 }
            r4 = r24
            r0.setObject(r4)     // Catch:{ Exception -> 0x01b0 }
            r2 = r38
            r0.loadUrl(r2)     // Catch:{ Exception -> 0x01b0 }
            r0.setRid(r6)     // Catch:{ Exception -> 0x01b0 }
            com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout r2 = new com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout     // Catch:{ Exception -> 0x01b0 }
            com.mbridge.msdk.foundation.controller.c r3 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x01b0 }
            android.content.Context r3 = r3.c()     // Catch:{ Exception -> 0x01b0 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x01b0 }
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams     // Catch:{ Exception -> 0x01b0 }
            r4 = -1
            r3.<init>(r4, r4)     // Catch:{ Exception -> 0x01b0 }
            r2.setLayoutParams(r3)     // Catch:{ Exception -> 0x01b0 }
            r3 = r22
            r2.setInstanceId(r3)     // Catch:{ Exception -> 0x01b0 }
            r2.setUnitId(r5)     // Catch:{ Exception -> 0x01b0 }
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r7 = new com.mbridge.msdk.video.bt.module.MBridgeBTLayout     // Catch:{ Exception -> 0x01b0 }
            com.mbridge.msdk.foundation.controller.c r8 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x01b0 }
            android.content.Context r8 = r8.c()     // Catch:{ Exception -> 0x01b0 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x01b0 }
            android.widget.FrameLayout$LayoutParams r8 = new android.widget.FrameLayout$LayoutParams     // Catch:{ Exception -> 0x01b0 }
            r8.<init>(r4, r4)     // Catch:{ Exception -> 0x01b0 }
            r7.setLayoutParams(r8)     // Catch:{ Exception -> 0x01b0 }
            r8 = r23
            r7.setInstanceId(r8)     // Catch:{ Exception -> 0x01b0 }
            r7.setUnitId(r5)     // Catch:{ Exception -> 0x01b0 }
            r7.setWebView(r0)     // Catch:{ Exception -> 0x01b0 }
            com.mbridge.msdk.video.bt.a.d r0 = com.mbridge.msdk.video.bt.a.d.c()     // Catch:{ Exception -> 0x01b0 }
            java.util.LinkedHashMap r0 = r0.b((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x01b0 }
            r0.put(r8, r7)     // Catch:{ Exception -> 0x01b0 }
            r0.put(r3, r2)     // Catch:{ Exception -> 0x01b0 }
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams     // Catch:{ Exception -> 0x01b0 }
            r0.<init>(r4, r4)     // Catch:{ Exception -> 0x01b0 }
            r2.addView(r7, r0)     // Catch:{ Exception -> 0x01b0 }
            goto L_0x01e4
        L_0x01b0:
            r0 = move-exception
            goto L_0x01b5
        L_0x01b2:
            r0 = move-exception
            r5 = r11
            r6 = r12
        L_0x01b5:
            if (r41 == 0) goto L_0x01d7
            com.mbridge.msdk.out.MBridgeIds r2 = new com.mbridge.msdk.out.MBridgeIds     // Catch:{ all -> 0x003c }
            r4 = r32
            r2.<init>(r4, r5, r6)     // Catch:{ all -> 0x003c }
            java.lang.String r3 = ""
            r4 = 880008(0xd6d88, float:1.233154E-39)
            com.mbridge.msdk.foundation.c.b r2 = b(r4, r2, r3, r0, r14)     // Catch:{ all -> 0x003c }
            r3 = 0
            r38 = r34
            r35 = r41
            r40 = r2
            r39 = r3
            r37 = r6
            r36 = r21
            r35.a(r36, r37, r38, r39, r40)     // Catch:{ all -> 0x003c }
        L_0x01d7:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x01e4
            java.lang.String r2 = "RewardCampaignsResourceManager"
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x003c }
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)     // Catch:{ all -> 0x003c }
        L_0x01e4:
            monitor-exit(r25)
            return
        L_0x01e6:
            monitor-exit(r25)     // Catch:{ all -> 0x003c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.a(boolean, android.os.Handler, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.mbridge.msdk.foundation.entity.CampaignEx, java.util.concurrent.CopyOnWriteArrayList, java.lang.String, java.lang.String, com.mbridge.msdk.videocommon.d.c, com.mbridge.msdk.reward.adapter.b$j, boolean):void");
    }

    private int a(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 0;
        }
        try {
            if (campaignEx.getAabEntity() != null) {
                return campaignEx.getAabEntity().h3c;
            }
            return 0;
        } catch (Throwable th) {
            af.b("RewardCampaignsResourceManager", th.getMessage());
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public com.mbridge.msdk.foundation.same.report.d.c a(CampaignEx campaignEx, int i4) {
        com.mbridge.msdk.foundation.same.report.d.c a5 = campaignEx != null ? com.mbridge.msdk.foundation.same.report.d.d.a().a(campaignEx.getCurrentLocalRid(), "") : null;
        if (a5 == null) {
            a5 = new com.mbridge.msdk.foundation.same.report.d.c();
        }
        a5.a(campaignEx);
        a5.c(a(campaignEx));
        a5.a(i4);
        return a5;
    }

    static /* synthetic */ void a(b bVar, Context context, String str, String str2, String str3, CampaignEx campaignEx, String str4, i iVar, CopyOnWriteArrayList copyOnWriteArrayList) {
        String str5 = str4;
        if (!TextUtils.isEmpty(str5) && !campaignEx.isMraid()) {
            CampaignEx campaignEx2 = campaignEx;
            com.mbridge.msdk.foundation.same.report.d.c a5 = bVar.a(campaignEx2, 3);
            if (!str5.contains(".zip") || !str5.contains(ResourceManager.KEY_MD5FILENAME)) {
                boolean isEmpty = TextUtils.isEmpty(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str5));
                try {
                    d dVar = new d(497, str, str2, str3, campaignEx, iVar, bVar.f14967a, copyOnWriteArrayList);
                    dVar.a(isEmpty);
                    H5DownLoadManager.getInstance().downloadH5Res(a5, str5, dVar);
                } catch (Exception e5) {
                    Exception exc = e5;
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardCampaignsResourceManager", exc.getLocalizedMessage());
                    }
                }
            } else {
                boolean isEmpty2 = TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str5));
                try {
                    g gVar = new g(context, str, str2, str3, campaignEx2, 497, bVar.f14967a, iVar, copyOnWriteArrayList);
                    gVar.a(isEmpty2);
                    H5DownLoadManager.getInstance().downloadH5Res(a5, str5, gVar);
                } catch (Exception e6) {
                    Exception exc2 = e6;
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardCampaignsResourceManager", exc2.getLocalizedMessage());
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(n nVar, CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.d.c a5 = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), campaignEx.getCampaignUnitId());
            if (a5 != null) {
                nVar.v(a5.l());
            }
            com.mbridge.msdk.videocommon.d.a b5 = com.mbridge.msdk.videocommon.d.b.a().b();
            if (b5 != null) {
                nVar.u(b5.c());
            }
        } catch (Exception e5) {
            af.b("RewardCampaignsResourceManager", e5.getMessage());
        }
    }

    static /* synthetic */ void a(b bVar, Context context, int i4, CampaignEx campaignEx, String str, String str2, String str3, String str4) {
        final Context context2 = context;
        final int i5 = i4;
        final CampaignEx campaignEx2 = campaignEx;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
            public final void run() {
                if (campaignEx2 != null && context2 != null) {
                    try {
                        n nVar = new n();
                        nVar.a("m_download_end");
                        Context context = context2;
                        if (context != null) {
                            nVar.a(ab.m(context.getApplicationContext()));
                        }
                        nVar.b(i5);
                        CampaignEx campaignEx = campaignEx2;
                        if (campaignEx != null) {
                            nVar.e(campaignEx.getId());
                            nVar.f(campaignEx2.getRequestId());
                            nVar.s(campaignEx2.getCurrentLocalRid());
                            nVar.g(campaignEx2.getRequestIdNotice());
                        }
                        nVar.a("url", str5);
                        nVar.q(str5);
                        nVar.h(str6);
                        nVar.c(str7);
                        if (!TextUtils.isEmpty(str8)) {
                            nVar.t(str8);
                        }
                        nVar.e(1);
                        nVar.a("scenes", "1");
                        com.mbridge.msdk.foundation.same.report.d.d.a().a(nVar, campaignEx2);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardCampaignsResourceManager", e5.getLocalizedMessage());
                        }
                    }
                }
            }
        });
    }
}
