package com.mbridge.msdk.mbsignalcommon.mraid;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.mraid.a;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.a;
import j$.util.DesugarCollections;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f14115a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<String> f14116b = new ArrayList<>();

    public static a a(WindVaneWebView windVaneWebView, String str) {
        Set<String> set;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.contains(CampaignEx.JSON_KEY_MRAID)) {
            return null;
        }
        a aVar = new a();
        aVar.f14152d = z.a("n+ztLkxpVTzBLkxgHN==");
        aVar.f14153e = parse.getHost();
        int i4 = 0;
        if (f14116b.size() == 0) {
            for (Method name : b.class.getDeclaredMethods()) {
                f14116b.add(name.getName());
            }
        }
        if (f14116b.contains(aVar.f14153e) || windVaneWebView == null) {
            String encodedQuery = parse.getEncodedQuery();
            if (encodedQuery == null) {
                set = Collections.EMPTY_SET;
            } else {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                do {
                    int indexOf = encodedQuery.indexOf(38, i4);
                    if (indexOf == -1) {
                        indexOf = encodedQuery.length();
                    }
                    int indexOf2 = encodedQuery.indexOf(61, i4);
                    if (indexOf2 > indexOf || indexOf2 == -1) {
                        indexOf2 = indexOf;
                    }
                    linkedHashSet.add(Uri.decode(encodedQuery.substring(i4, indexOf2)));
                    i4 = indexOf + 1;
                } while (i4 < encodedQuery.length());
                set = DesugarCollections.unmodifiableSet(linkedHashSet);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                for (String str2 : set) {
                    jSONObject.put(str2, parse.getQueryParameter(str2));
                }
                aVar.f14154f = jSONObject.toString();
                return aVar;
            } catch (Exception e5) {
                e5.printStackTrace();
                return aVar;
            }
        } else {
            String campaignId = windVaneWebView.getCampaignId();
            String str3 = aVar.f14153e;
            if (!TextUtils.isEmpty(campaignId)) {
                if (f14115a.containsKey(campaignId)) {
                    String str4 = f14115a.get(campaignId);
                    if (!TextUtils.isEmpty(str3) && !str4.contains(str3)) {
                        if (str4.length() > 0) {
                            str4 = str4.concat(",");
                        }
                        f14115a.put(campaignId, str4.concat(str3));
                    }
                } else {
                    f14115a.put(campaignId, str3);
                }
            }
            a.C0190a.f14114a.a((WebView) windVaneWebView, aVar.f14153e);
            a.C0190a.f14114a.a((WebView) windVaneWebView, aVar.f14153e, "Specified command is not implemented");
            return null;
        }
    }

    public static void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            f14115a.remove(str);
        }
    }

    public static String a(String str) {
        if (f14115a.containsKey(str)) {
            return f14115a.get(str);
        }
        return null;
    }
}
