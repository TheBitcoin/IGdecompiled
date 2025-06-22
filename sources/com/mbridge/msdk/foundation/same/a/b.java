package com.mbridge.msdk.foundation.same.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.c;
import com.mbridge.msdk.foundation.entity.d;
import com.mbridge.msdk.foundation.same.d.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ap;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, List<a>> f13156a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, List<a>> f13157b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, List<a>> f13158c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, c>> f13159d = null;

    /* renamed from: e  reason: collision with root package name */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, String>> f13160e = null;

    /* renamed from: f  reason: collision with root package name */
    public static ConcurrentHashMap<String, CopyOnWriteArrayList<String>> f13161f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Map<String, List<a>> f13162g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public static Map<String, List<a>> f13163h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, List<a>> f13164i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public static Map<String, List<a>> f13165j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    public static Map<String, Long> f13166k = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    public static Map<String, List<a>> f13167l = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    public static Map<String, List<a>> f13168m = new HashMap();

    /* renamed from: n  reason: collision with root package name */
    private static final String f13169n = "b";

    public static void a(String str, String str2, String str3, long j4, long j5, long j6) {
        if (f13159d == null) {
            f13159d = new ConcurrentHashMap<>();
        }
        try {
            if (f13159d.containsKey(str)) {
                Map map = f13159d.get(str);
                if (map != null) {
                    c cVar = (c) map.get(str2);
                    if (cVar == null) {
                        c cVar2 = new c();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str3);
                        cVar2.a((List<String>) arrayList);
                        cVar2.a(j4);
                        cVar2.b(j5);
                        cVar2.c(j6);
                        map.put(str2, cVar2);
                    } else if (cVar.c() != null) {
                        cVar.a(j4);
                        cVar.b(j5);
                        cVar.c(j6);
                        cVar.c().add(str3);
                    }
                }
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str3);
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                c cVar3 = new c();
                cVar3.a((List<String>) arrayList2);
                cVar3.a(j4);
                cVar3.b(j5);
                cVar3.c(j6);
                concurrentHashMap.put(str2, cVar3);
                f13159d.put(str, concurrentHashMap);
            }
        } catch (Throwable th) {
            af.b(f13169n, th.getMessage());
        }
    }

    public static String b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = f13161f) != null && concurrentHashMap.containsKey(str) && (copyOnWriteArrayList = f13161f.get(str)) != null && copyOnWriteArrayList.size() > 0) {
            return (String) copyOnWriteArrayList.get(0);
        }
        return "";
    }

    public static void c(String str, String str2) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, c>> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = f13159d) == null || !concurrentHashMap.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            f13159d.remove(str);
            return;
        }
        Map map = f13159d.get(str);
        if (map != null && map.containsKey(str2)) {
            map.remove(str2);
        }
    }

    private static Map<String, List<a>> d(String str) {
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1396342996:
                if (str.equals("banner")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1052618729:
                if (str.equals("native")) {
                    c5 = 1;
                    break;
                }
                break;
            case -934326481:
                if (str.equals("reward")) {
                    c5 = 2;
                    break;
                }
                break;
            case -895866265:
                if (str.equals("splash")) {
                    c5 = 3;
                    break;
                }
                break;
            case 538816457:
                if (str.equals("h5_native")) {
                    c5 = 4;
                    break;
                }
                break;
            case 604727084:
                if (str.equals("interstitial")) {
                    c5 = 5;
                    break;
                }
                break;
            case 1844104930:
                if (str.equals("interactive")) {
                    c5 = 6;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                return f13157b;
            case 1:
                return f13164i;
            case 2:
                return f13165j;
            case 3:
                return f13167l;
            case 4:
                return f13158c;
            case 5:
                return f13163h;
            case 6:
                return f13162g;
            default:
                return null;
        }
    }

    public static d b(String str, String str2) {
        ConcurrentHashMap concurrentHashMap;
        d dVar = new d();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = f13160e;
                if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str) && (concurrentHashMap = f13160e.get(str)) != null && concurrentHashMap.containsKey(str2)) {
                    dVar.a(1);
                    dVar.c((String) concurrentHashMap.get(str2));
                    return dVar;
                }
            } catch (Exception e5) {
                af.a(f13169n, e5.getMessage());
            }
        }
        return dVar;
    }

    public static void c(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = f13161f) != null && concurrentHashMap.containsKey(str) && (copyOnWriteArrayList = f13161f.get(str)) != null && copyOnWriteArrayList.size() > 0) {
            copyOnWriteArrayList.remove(0);
        }
    }

    public static void d(String str, String str2) {
        ConcurrentHashMap concurrentHashMap;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = f13160e;
                if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str) && (concurrentHashMap = f13160e.get(str2)) != null && concurrentHashMap.containsKey(str2)) {
                    concurrentHashMap.remove(str2);
                }
            } catch (Exception e5) {
                af.a(f13169n, e5.getMessage());
            }
        }
    }

    public static void a(String str, String str2, int i4) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            if (f13161f == null) {
                f13161f = new ConcurrentHashMap<>();
            }
            try {
                if (f13161f.containsKey(str)) {
                    copyOnWriteArrayList = f13161f.get(str);
                    copyOnWriteArrayList.add(str2);
                } else {
                    CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                    copyOnWriteArrayList2.add(str2);
                    f13161f.put(str, copyOnWriteArrayList2);
                    copyOnWriteArrayList = copyOnWriteArrayList2;
                }
                int size = copyOnWriteArrayList.size() - i4;
                if (size >= 0) {
                    for (int i5 = 0; i5 < size; i5++) {
                        copyOnWriteArrayList.remove(i5);
                    }
                }
            } catch (Exception e5) {
                af.a(f13169n, e5.getMessage());
            }
        }
    }

    public static void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                if (f13160e == null) {
                    f13160e = new ConcurrentHashMap<>();
                }
                if (!f13160e.containsKey(str)) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    concurrentHashMap.put(str2, str3);
                    f13160e.put(str, concurrentHashMap);
                } else if (f13160e.get(str) == null) {
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    concurrentHashMap2.put(str2, str3);
                    f13160e.put(str, concurrentHashMap2);
                }
            } catch (Exception e5) {
                af.a(f13169n, e5.getMessage());
            }
        }
    }

    public static String a(String str, String str2) {
        Map<String, List<a>> map;
        List list;
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            map = d(str2);
        } else if (f13164i.containsKey(str)) {
            map = f13164i;
        } else if (f13165j.containsKey(str)) {
            map = f13165j;
        } else if (f13162g.containsKey(str)) {
            map = f13162g;
        } else if (f13168m.containsKey(str)) {
            map = f13168m;
        } else if (f13163h.containsKey(str)) {
            map = f13163h;
        } else if (f13157b.containsKey(str)) {
            map = f13157b;
        } else if (f13167l.containsKey(str)) {
            map = f13167l;
        } else {
            map = f13158c.containsKey(str) ? f13158c : null;
        }
        if (map != null) {
            try {
                if (ap.b(str) && map.containsKey(str) && (list = map.get(str)) != null && list.size() > 0) {
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("2", ((a) list.get(i4)).a());
                        jSONObject.put("1", ((a) list.get(i4)).c());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public static ConcurrentHashMap<String, c> a(String str) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, c>> concurrentHashMap = f13159d;
        if (concurrentHashMap == null) {
            e a5 = e.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
            if (a5 != null) {
                a5.d(str, "");
                f13159d = new ConcurrentHashMap<>();
                return null;
            }
        } else if (concurrentHashMap.containsKey(str)) {
            return f13159d.get(str);
        }
        return null;
    }

    public static void a(String str, CampaignEx campaignEx, String str2) {
        Map<String, List<a>> d5 = d(str2);
        if (campaignEx != null && d5 != null) {
            try {
                if (!TextUtils.isEmpty(campaignEx.getId())) {
                    a aVar = new a(campaignEx.getId(), campaignEx.getRequestIdNotice());
                    if (d5.containsKey(str)) {
                        List list = d5.get(str);
                        if (list != null && list.size() == 20) {
                            list.remove(0);
                        }
                        if (list != null) {
                            list.add(aVar);
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(aVar);
                    d5.put(str, arrayList);
                }
            } catch (Throwable th) {
                af.b(f13169n, th.getMessage(), th);
            }
        }
    }
}
