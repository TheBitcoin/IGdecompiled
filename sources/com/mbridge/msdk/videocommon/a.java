package com.mbridge.msdk.videocommon;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0208a> f16937a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0208a> f16938b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0208a> f16939c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0208a> f16940d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0208a> f16941e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0208a> f16942f = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0208a> f16943g = new ConcurrentHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0208a> f16944h = new ConcurrentHashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0208a> f16945i = new ConcurrentHashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0208a> f16946j = new ConcurrentHashMap<>();

    /* renamed from: com.mbridge.msdk.videocommon.a$a  reason: collision with other inner class name */
    public static class C0208a {

        /* renamed from: a  reason: collision with root package name */
        private WindVaneWebView f16947a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f16948b;

        public final WindVaneWebView a() {
            return this.f16947a;
        }

        public final String b() {
            WindVaneWebView windVaneWebView = this.f16947a;
            if (windVaneWebView != null) {
                return (String) windVaneWebView.getTag();
            }
            return "";
        }

        public final boolean c() {
            return this.f16948b;
        }

        public final void a(WindVaneWebView windVaneWebView) {
            this.f16947a = windVaneWebView;
        }

        public final void a(String str) {
            WindVaneWebView windVaneWebView = this.f16947a;
            if (windVaneWebView != null) {
                windVaneWebView.setTag(str);
            }
        }

        public final void a(boolean z4) {
            this.f16948b = z4;
        }
    }

    public static C0208a a(String str) {
        if (f16943g.containsKey(str)) {
            return f16943g.get(str);
        }
        if (f16944h.containsKey(str)) {
            return f16944h.get(str);
        }
        if (f16945i.containsKey(str)) {
            return f16945i.get(str);
        }
        if (f16946j.containsKey(str)) {
            return f16946j.get(str);
        }
        return null;
    }

    public static void b(String str) {
        if (f16943g.containsKey(str)) {
            f16943g.remove(str);
        }
        if (f16945i.containsKey(str)) {
            f16945i.remove(str);
        }
        if (f16944h.containsKey(str)) {
            f16944h.remove(str);
        }
        if (f16946j.containsKey(str)) {
            f16946j.remove(str);
        }
    }

    public static void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String next : f16943g.keySet()) {
                if (!TextUtils.isEmpty(next) && next.startsWith(str)) {
                    f16943g.remove(next);
                }
            }
        } else {
            f16943g.clear();
        }
        f16944h.clear();
    }

    public static void d(String str) {
        for (Map.Entry next : f16943g.entrySet()) {
            if (((String) next.getKey()).contains(str)) {
                f16943g.remove(next.getKey());
            }
        }
    }

    public static void e(String str) {
        for (Map.Entry next : f16944h.entrySet()) {
            if (((String) next.getKey()).contains(str)) {
                f16944h.remove(next.getKey());
            }
        }
    }

    public static void a(String str, C0208a aVar, boolean z4, boolean z5) {
        if (z4) {
            if (z5) {
                f16944h.put(str, aVar);
            } else {
                f16943g.put(str, aVar);
            }
        } else if (z5) {
            f16946j.put(str, aVar);
        } else {
            f16945i.put(str, aVar);
        }
    }

    public static void b(int i4, CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                String requestIdNotice = campaignEx.getRequestIdNotice();
                if (i4 == 288) {
                    requestIdNotice = campaignEx.getKeyIaUrl();
                }
                if (i4 != 94) {
                    if (i4 != 287) {
                        if (i4 != 288) {
                            ConcurrentHashMap<String, C0208a> concurrentHashMap = f16937a;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.remove(requestIdNotice);
                                return;
                            }
                            return;
                        }
                        ConcurrentHashMap<String, C0208a> concurrentHashMap2 = f16940d;
                        if (concurrentHashMap2 != null) {
                            concurrentHashMap2.remove(requestIdNotice);
                        }
                    } else if (campaignEx.isBidCampaign()) {
                        ConcurrentHashMap<String, C0208a> concurrentHashMap3 = f16939c;
                        if (concurrentHashMap3 != null) {
                            concurrentHashMap3.remove(requestIdNotice);
                        }
                    } else {
                        ConcurrentHashMap<String, C0208a> concurrentHashMap4 = f16942f;
                        if (concurrentHashMap4 != null) {
                            concurrentHashMap4.remove(requestIdNotice);
                        }
                    }
                } else if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0208a> concurrentHashMap5 = f16938b;
                    if (concurrentHashMap5 != null) {
                        concurrentHashMap5.remove(requestIdNotice);
                    }
                } else {
                    ConcurrentHashMap<String, C0208a> concurrentHashMap6 = f16941e;
                    if (concurrentHashMap6 != null) {
                        concurrentHashMap6.remove(requestIdNotice);
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public static void a() {
        f16945i.clear();
        f16946j.clear();
    }

    public static C0208a a(int i4, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i4 == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i4 != 94) {
                if (i4 != 287) {
                    if (i4 != 288) {
                        ConcurrentHashMap<String, C0208a> concurrentHashMap = f16937a;
                        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                            return f16937a.get(requestIdNotice);
                        }
                    } else {
                        ConcurrentHashMap<String, C0208a> concurrentHashMap2 = f16940d;
                        if (concurrentHashMap2 != null && concurrentHashMap2.size() > 0) {
                            return f16940d.get(requestIdNotice);
                        }
                    }
                } else if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0208a> concurrentHashMap3 = f16939c;
                    if (concurrentHashMap3 != null && concurrentHashMap3.size() > 0) {
                        return f16939c.get(requestIdNotice);
                    }
                } else {
                    ConcurrentHashMap<String, C0208a> concurrentHashMap4 = f16942f;
                    if (concurrentHashMap4 != null && concurrentHashMap4.size() > 0) {
                        return f16942f.get(requestIdNotice);
                    }
                }
            } else if (campaignEx.isBidCampaign()) {
                ConcurrentHashMap<String, C0208a> concurrentHashMap5 = f16938b;
                if (concurrentHashMap5 != null && concurrentHashMap5.size() > 0) {
                    return f16938b.get(requestIdNotice);
                }
            } else {
                ConcurrentHashMap<String, C0208a> concurrentHashMap6 = f16941e;
                if (concurrentHashMap6 != null && concurrentHashMap6.size() > 0) {
                    return f16941e.get(requestIdNotice);
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        return null;
    }

    public static void b(int i4, String str, C0208a aVar) {
        if (i4 == 94) {
            if (f16941e == null) {
                f16941e = new ConcurrentHashMap<>();
            }
            f16941e.put(str, aVar);
        } else if (i4 == 287) {
            if (f16942f == null) {
                f16942f = new ConcurrentHashMap<>();
            }
            f16942f.put(str, aVar);
        } else if (i4 != 288) {
            try {
                if (f16937a == null) {
                    f16937a = new ConcurrentHashMap<>();
                }
                f16937a.put(str, aVar);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        } else {
            if (f16940d == null) {
                f16940d = new ConcurrentHashMap<>();
            }
            f16940d.put(str, aVar);
        }
    }

    public static void a(int i4, String str, C0208a aVar) {
        if (i4 == 94) {
            if (f16938b == null) {
                f16938b = new ConcurrentHashMap<>();
            }
            f16938b.put(str, aVar);
        } else if (i4 == 287) {
            try {
                if (f16939c == null) {
                    f16939c = new ConcurrentHashMap<>();
                }
                f16939c.put(str, aVar);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }
}
