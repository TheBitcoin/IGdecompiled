package com.mbridge.msdk.videocommon.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.videocommon.d.b;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f16949a = "com.mbridge.msdk.videocommon.a.a";

    /* renamed from: b  reason: collision with root package name */
    private static a f16950b;

    /* renamed from: c  reason: collision with root package name */
    private e f16951c;

    private a() {
        try {
            Context c5 = c.m().c();
            if (c5 != null) {
                this.f16951c = e.a((f) g.a(c5));
            } else {
                af.b(f16949a, "RewardCampaignCache get Context is null");
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public static a a() {
        if (f16950b == null) {
            synchronized (a.class) {
                try {
                    if (f16950b == null) {
                        f16950b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f16950b;
    }

    public final int b(String str, int i4, boolean z4, String str2) {
        List<CampaignEx> list;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            if (z4) {
                list = this.f16951c.a(str, 0, 0, i4, str2);
            } else {
                list = this.f16951c.a(str, 0, 0, i4, false);
            }
            if (list == null) {
                return 0;
            }
            for (CampaignEx next : list) {
                if (next != null && next.getReadyState() == 0) {
                    arrayList.add(next);
                }
            }
            return arrayList.size();
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public final List<CampaignEx> c(String str, int i4, boolean z4, String str2) {
        long ad;
        List<CampaignEx> list;
        ArrayList arrayList = null;
        try {
            com.mbridge.msdk.c.g b5 = h.a().b(c.m().k());
            if (b5 != null) {
                ad = b5.ad();
            } else {
                h.a();
                ad = i.a().ad();
            }
            long j4 = ad * 1000;
            if (!TextUtils.isEmpty(str)) {
                if (z4) {
                    list = this.f16951c.a(str, 0, 0, i4, str2);
                } else {
                    list = this.f16951c.a(str, 0, 0, i4, false);
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (list != null) {
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        for (CampaignEx next : list) {
                            if (next != null && next.getReadyState() == 0) {
                                long plctb = next.getPlctb() * 1000;
                                long timestamp = currentTimeMillis - next.getTimestamp();
                                int i5 = (plctb > 0 ? 1 : (plctb == 0 ? 0 : -1));
                                if ((i5 <= 0 && j4 >= timestamp) || (i5 > 0 && plctb >= timestamp)) {
                                    arrayList2.add(next);
                                }
                            }
                        }
                        return arrayList2;
                    } catch (Exception e5) {
                        e = e5;
                        arrayList = arrayList2;
                        e.printStackTrace();
                        return arrayList;
                    }
                }
            }
            return null;
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
            return arrayList;
        }
    }

    public final CopyOnWriteArrayList<CampaignEx> a(String str, int i4) {
        List<CampaignEx> a5;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            if (TextUtils.isEmpty(str) || (a5 = this.f16951c.a(str, 0, 0, i4)) == null) {
                return null;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            try {
                for (CampaignEx next : a5) {
                    if (next != null) {
                        copyOnWriteArrayList2.add(next);
                    }
                }
                return copyOnWriteArrayList2;
            } catch (Exception e5) {
                e = e5;
                copyOnWriteArrayList = copyOnWriteArrayList2;
                e.printStackTrace();
                return copyOnWriteArrayList;
            }
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
            return copyOnWriteArrayList;
        }
    }

    public final List<CampaignEx> b(String str, int i4, boolean z4) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return this.f16951c.a(str, 0, 0, i4, z4);
            }
            return null;
        } catch (Exception e5) {
            af.b(f16949a, e5.getLocalizedMessage());
            return null;
        }
    }

    public final void a(String str, List<CampaignEx> list, String str2, int i4) {
        e eVar;
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && !TextUtils.isEmpty(str2) && (eVar = this.f16951c) != null) {
            eVar.a(str, list, str2, i4);
        }
    }

    public final void b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> f4 = this.f16951c.f(str);
                if (f4 != null && f4.size() > 0) {
                    com.mbridge.msdk.c.g b5 = h.a().b(c.m().k());
                    if (b5 == null) {
                        h.a();
                        b5 = i.a();
                    }
                    long ad = b5 != null ? b5.ad() : 0;
                    long currentTimeMillis = System.currentTimeMillis();
                    for (com.mbridge.msdk.foundation.entity.c next : f4.values()) {
                        if (next != null) {
                            long e5 = next.e();
                            if (e5 <= 0) {
                                e5 = ad;
                            }
                            if (next.f() + (e5 * 1000) < currentTimeMillis) {
                                if (!TextUtils.isEmpty(next.a())) {
                                    af.b("HBOPTIMIZE", "不在有效期范围内 删除" + next.a());
                                    c(str, next.a());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public final void a(String str, List<CampaignEx> list) {
        e eVar;
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && (eVar = this.f16951c) != null) {
            eVar.b(str, list);
        }
    }

    public final void a(String str, List<CampaignEx> list, String str2) {
        e eVar;
        try {
            if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && (eVar = this.f16951c) != null) {
                eVar.a(str, list, str2);
            }
        } catch (Exception e5) {
            af.b(f16949a, e5.getMessage());
        }
    }

    public final synchronized void c(String str, String str2) {
        try {
            this.f16951c.c(str2, str);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(String str, String str2) {
        if (this.f16951c != null && !TextUtils.isEmpty(str)) {
            this.f16951c.f(str, str2);
        }
    }

    public final synchronized void c(String str, int i4) {
        try {
            com.mbridge.msdk.c.g b5 = h.a().b(c.m().k());
            if (b5 == null) {
                h.a();
                b5 = i.a();
            }
            int m4 = b5.m();
            if (m4 != 0) {
                boolean z4 = false;
                List<CampaignEx> b6 = this.f16951c.b(str, i4, m4 == 2);
                if (b6 != null && b6.size() > 0) {
                    for (CampaignEx next : b6) {
                        String requestIdNotice = next.getRequestIdNotice();
                        String id = next.getId();
                        String campaignUnitId = next.getCampaignUnitId();
                        String cMPTEntryUrl = next.getCMPTEntryUrl();
                        com.mbridge.msdk.videocommon.a.b(campaignUnitId + "_" + id + "_" + requestIdNotice + "_" + cMPTEntryUrl);
                    }
                }
                e eVar = this.f16951c;
                if (m4 == 2) {
                    z4 = true;
                }
                eVar.a(str, i4, z4);
            }
        } catch (Exception e5) {
            af.b(f16949a, e5.getMessage());
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final List<CampaignEx> a(String str, int i4, boolean z4) {
        return a(str, i4, z4, "");
    }

    public final CopyOnWriteArrayList<CampaignEx> a(String str, int i4, boolean z4, String str2) {
        List<CampaignEx> list;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            com.mbridge.msdk.videocommon.d.a b5 = b.a().b();
            long f4 = b5 != null ? b5.f() : 0;
            if (!TextUtils.isEmpty(str)) {
                if (z4) {
                    list = this.f16951c.a(str, 0, 0, i4, str2);
                } else {
                    list = this.f16951c.a(str, 0, 0, i4, false);
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (list != null) {
                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                    try {
                        for (CampaignEx next : list) {
                            if (next != null) {
                                if (next.getReadyState() != 0) {
                                    if (next.getLoadTimeoutState() == 1) {
                                    }
                                }
                                long plct = next.getPlct() * 1000;
                                long timestamp = currentTimeMillis - next.getTimestamp();
                                int i5 = (plct > 0 ? 1 : (plct == 0 ? 0 : -1));
                                if ((i5 > 0 && plct >= timestamp) || (i5 <= 0 && f4 >= timestamp)) {
                                    copyOnWriteArrayList2.add(next);
                                }
                            }
                        }
                        return copyOnWriteArrayList2;
                    } catch (Exception e5) {
                        e = e5;
                        copyOnWriteArrayList = copyOnWriteArrayList2;
                        e.printStackTrace();
                        return copyOnWriteArrayList;
                    }
                }
            }
            return null;
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
            return copyOnWriteArrayList;
        }
    }

    public final void b(String str, String str2) {
        e eVar = this.f16951c;
        if (eVar != null) {
            eVar.e(str, str2);
        }
    }

    public final void b(String str, int i4) {
        int size;
        try {
            List<com.mbridge.msdk.foundation.entity.c> d5 = this.f16951c.d(str);
            if (d5 != null && d5.size() > 0 && (size = d5.size() - i4) > 0) {
                for (int i5 = 0; i5 < size; i5++) {
                    c(str, d5.get(i5).a());
                    com.mbridge.msdk.foundation.same.a.b.c(str, d5.get(i5).a());
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final List<CampaignEx> a(List<CampaignEx> list) {
        ArrayList arrayList = null;
        if (list != null) {
            try {
                com.mbridge.msdk.videocommon.d.a b5 = b.a().b();
                long f4 = b5 != null ? b5.f() : 0;
                long currentTimeMillis = System.currentTimeMillis();
                if (list.size() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        for (CampaignEx next : list) {
                            if (next != null) {
                                long plct = next.getPlct() * 1000;
                                long timestamp = currentTimeMillis - next.getTimestamp();
                                int i4 = (plct > 0 ? 1 : (plct == 0 ? 0 : -1));
                                if ((i4 > 0 && plct >= timestamp) || (i4 <= 0 && f4 >= timestamp)) {
                                    arrayList2.add(next);
                                }
                            }
                        }
                        return arrayList2;
                    } catch (Exception e5) {
                        e = e5;
                        arrayList = arrayList2;
                        e.printStackTrace();
                        return arrayList;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                e.printStackTrace();
                return arrayList;
            }
        }
        return arrayList;
    }

    public final List<com.mbridge.msdk.foundation.entity.c> a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return this.f16951c.d(str);
            }
            return null;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (campaignEx.isBidCampaign()) {
                        com.mbridge.msdk.foundation.same.a.b.c(str, campaignEx.getRequestId());
                    }
                    this.f16951c.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(campaignEx.getId())) {
                    this.f16951c.b(campaignEx.getId(), campaignEx.getRequestId());
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2, List<CampaignEx> list) {
        try {
            if (!TextUtils.isEmpty(str2) && list != null && list.size() > 0) {
                this.f16951c.a(list, str, str2, 0);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final synchronized void a(long j4, String str) {
        try {
            this.f16951c.a(j4, str);
        } catch (Exception e5) {
            e5.printStackTrace();
            af.b(f16949a, e5.getMessage());
        }
    }
}
