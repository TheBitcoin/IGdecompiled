package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.videocommon.download.e;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class d {

    /* renamed from: c  reason: collision with root package name */
    private static d f17090c;

    /* renamed from: a  reason: collision with root package name */
    private CopyOnWriteArrayList<String> f17091a;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentMap<String, Object> f17092b;

    /* renamed from: d  reason: collision with root package name */
    private g f17093d;

    /* renamed from: e  reason: collision with root package name */
    private e f17094e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17095f = false;

    /* renamed from: g  reason: collision with root package name */
    private final String f17096g = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;

    /* renamed from: h  reason: collision with root package name */
    private final String f17097h = "down_type";

    private d() {
        try {
            this.f17093d = g.a();
            this.f17094e = e.a.f17100a;
            this.f17091a = new CopyOnWriteArrayList<>();
            this.f17092b = new ConcurrentHashMap();
            g b5 = h.a().b(c.m().k());
            if (b5 != null) {
                this.f17095f = b5.z(1);
            }
        } catch (Throwable th) {
            af.b("H5DownLoadManager", th.getMessage(), th);
        }
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            try {
                if (f17090c == null) {
                    f17090c = new d();
                }
                dVar = f17090c;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return dVar;
    }

    public final String a(String str) {
        try {
            if (!Patterns.WEB_URL.matcher(str).matches()) {
                if (URLUtil.isValidUrl(str)) {
                }
                return str;
            }
            Uri parse = Uri.parse(str);
            String path = parse.getPath();
            if (!TextUtils.isEmpty(path)) {
                if (TextUtils.isEmpty(parse.getQueryParameter("urlDebug"))) {
                    if (path.toLowerCase().endsWith(".zip")) {
                        g gVar = this.f17093d;
                        if (gVar != null) {
                            return gVar.a(str);
                        }
                        return null;
                    }
                    e eVar = this.f17094e;
                    if (eVar != null) {
                        return eVar.a(str);
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return str;
    }
}
