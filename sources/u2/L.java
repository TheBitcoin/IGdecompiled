package u2;

import K1.c;
import W1.C1610f;
import W1.s;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g2.C2048f;
import g2.C2050h;
import g2.C2061t;
import g2.C2063v;
import g2.C2067z;
import g2.N;
import g2.P;
import g2.U;
import g2.r;
import h2.C2072d;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import m3.d;
import m3.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v2.C2331b;

public final class L {

    /* renamed from: b  reason: collision with root package name */
    public static final a f21898b = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f21899a;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final byte[] a(String str) {
            m.e(str, TypedValues.Custom.S_STRING);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            byte[] bytes = str.getBytes(d.f21160b);
            m.d(bytes, "getBytes(...)");
            gZIPOutputStream.write(bytes);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            m.b(byteArray);
            return byteArray;
        }

        /* JADX WARNING: Removed duplicated region for block: B:62:0x00db A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String b(java.lang.String r7) {
            /*
                r6 = this;
                java.lang.String r0 = "en"
                if (r7 != 0) goto L_0x0005
                return r0
            L_0x0005:
                int r1 = r7.hashCode()
                java.lang.String r2 = "in"
                java.lang.String r3 = "id"
                java.lang.String r4 = "kr"
                java.lang.String r5 = "cn"
                switch(r1) {
                    case 3121: goto L_0x00d3;
                    case 3179: goto L_0x00cb;
                    case 3201: goto L_0x00c1;
                    case 3241: goto L_0x00bd;
                    case 3246: goto L_0x00b3;
                    case 3276: goto L_0x00a9;
                    case 3329: goto L_0x009f;
                    case 3355: goto L_0x0097;
                    case 3365: goto L_0x008f;
                    case 3371: goto L_0x0085;
                    case 3383: goto L_0x0079;
                    case 3428: goto L_0x006e;
                    case 3431: goto L_0x0065;
                    case 3588: goto L_0x0058;
                    case 3645: goto L_0x004d;
                    case 3651: goto L_0x0042;
                    case 3700: goto L_0x0037;
                    case 3710: goto L_0x002c;
                    case 3763: goto L_0x0021;
                    case 3886: goto L_0x0016;
                    default: goto L_0x0014;
                }
            L_0x0014:
                goto L_0x00db
            L_0x0016:
                java.lang.String r1 = "zh"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x0020
                goto L_0x00db
            L_0x0020:
                return r5
            L_0x0021:
                java.lang.String r1 = "vi"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x002b
                goto L_0x00db
            L_0x002b:
                return r1
            L_0x002c:
                java.lang.String r1 = "tr"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x0036
                goto L_0x00db
            L_0x0036:
                return r1
            L_0x0037:
                java.lang.String r1 = "th"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x0041
                goto L_0x00db
            L_0x0041:
                return r1
            L_0x0042:
                java.lang.String r1 = "ru"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x004c
                goto L_0x00db
            L_0x004c:
                return r1
            L_0x004d:
                java.lang.String r1 = "ro"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x0057
                goto L_0x00db
            L_0x0057:
                return r1
            L_0x0058:
                java.lang.String r1 = "pt"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x0062
                goto L_0x00db
            L_0x0062:
                java.lang.String r7 = "br"
                return r7
            L_0x0065:
                boolean r7 = r7.equals(r4)
                if (r7 != 0) goto L_0x006d
                goto L_0x00db
            L_0x006d:
                return r4
            L_0x006e:
                java.lang.String r1 = "ko"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x0078
                goto L_0x00db
            L_0x0078:
                return r4
            L_0x0079:
                java.lang.String r1 = "ja"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x0082
                goto L_0x00db
            L_0x0082:
                java.lang.String r7 = "jp"
                return r7
            L_0x0085:
                java.lang.String r1 = "it"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x008e
                goto L_0x00db
            L_0x008e:
                return r1
            L_0x008f:
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x0096
                goto L_0x00db
            L_0x0096:
                return r3
            L_0x0097:
                boolean r7 = r7.equals(r3)
                if (r7 != 0) goto L_0x009e
                goto L_0x00db
            L_0x009e:
                return r3
            L_0x009f:
                java.lang.String r1 = "hi"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x00a8
                goto L_0x00db
            L_0x00a8:
                return r2
            L_0x00a9:
                java.lang.String r1 = "fr"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x00b2
                goto L_0x00db
            L_0x00b2:
                return r1
            L_0x00b3:
                java.lang.String r1 = "es"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x00bc
                goto L_0x00db
            L_0x00bc:
                return r1
            L_0x00bd:
                r7.equals(r0)
                goto L_0x00db
            L_0x00c1:
                java.lang.String r1 = "de"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x00ca
                goto L_0x00db
            L_0x00ca:
                return r1
            L_0x00cb:
                boolean r7 = r7.equals(r5)
                if (r7 != 0) goto L_0x00d2
                goto L_0x00db
            L_0x00d2:
                return r5
            L_0x00d3:
                java.lang.String r1 = "ar"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x00dc
            L_0x00db:
                return r0
            L_0x00dc:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: u2.L.a.b(java.lang.String):java.lang.String");
        }

        public final String c(Context context) {
            m.e(context, "context");
            return m3.m.w("https://www.uptodown.com/turbo?platform=android", "www", b(com.uptodown.activities.preferences.a.f18818a.p(context)), false, 4, (Object) null);
        }

        private a() {
        }
    }

    public L(Context context) {
        m.e(context, "context");
        this.f21899a = context;
    }

    private final JSONObject D(g2.L l4, String str) {
        String d5 = l4.d();
        if (!(d5 == null || d5.length() == 0)) {
            try {
                String d6 = l4.d();
                m.b(d6);
                return new JSONObject(d6);
            } catch (JSONException unused) {
                Bundle bundle = new Bundle();
                bundle.putString("type", "jsonException");
                bundle.putString("url", str);
                new x(this.f21899a).d("apiRead", bundle);
            }
        }
        return null;
    }

    private final g2.L E(String str, HashMap hashMap, String str2) {
        HashMap hashMap2;
        String str3;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        g2.L l4 = new g2.L();
        if (hashMap == null) {
            try {
                hashMap2 = new HashMap();
            } catch (SocketTimeoutException unused) {
                l4.h("SocketTimeoutException");
            } catch (IllegalStateException unused2) {
                l4.h("IllegalStateException");
            } catch (IllegalArgumentException unused3) {
                l4.h("IllegalArgumentException");
            } catch (SecurityException unused4) {
                l4.h("SecurityException");
            } catch (NullPointerException unused5) {
                l4.h("NullPointerException");
            } catch (MalformedURLException unused6) {
                l4.h("MalformedURLException");
            } catch (ProtocolException unused7) {
                l4.h("ProtocolException");
            } catch (SSLHandshakeException unused8) {
                l4.h("SSLHandshakeException");
            } catch (IOException unused9) {
                l4.h("IOException");
            } catch (Exception unused10) {
                l4.h("Exception");
            } catch (Throwable th) {
                c.f7281a.a(str, hashMap, l4);
                throw th;
            }
        } else {
            hashMap2 = hashMap;
        }
        if (!hashMap2.containsKey("lang")) {
            hashMap2.put("lang", f21898b.b(com.uptodown.activities.preferences.a.f18818a.p(this.f21899a)));
        }
        if (!hashMap2.containsKey("id_plataforma")) {
            hashMap2.put("id_plataforma", "13");
        }
        if (m3.m.p(str2, ShareTarget.METHOD_GET, true)) {
            str3 = str + '?' + O(hashMap2);
        } else {
            str3 = str;
        }
        new C2314D().a(this.f21899a);
        URLConnection openConnection = new URL(str3).openConnection();
        m.c(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
        httpsURLConnection.setReadTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
        httpsURLConnection.setConnectTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
        httpsURLConnection.setRequestMethod(str2);
        httpsURLConnection.setDoInput(true);
        if (m3.m.p(str2, ShareTarget.METHOD_POST, true)) {
            httpsURLConnection.setDoOutput(true);
        }
        u.f21949a.a(httpsURLConnection);
        String J4 = com.uptodown.activities.preferences.a.f18818a.J(this.f21899a);
        String string = this.f21899a.getSharedPreferences("SharedPreferencesUser", 0).getString("is_turbo", "");
        httpsURLConnection.setRequestProperty("Identificador", "Uptodown_Android");
        httpsURLConnection.setRequestProperty("Identificador-Version", "671");
        if (J4 != null) {
            if (J4.length() != 0) {
                httpsURLConnection.setRequestProperty("UTOKEN", J4);
            }
        }
        if (string != null) {
            if (string.length() != 0) {
                httpsURLConnection.setRequestProperty("TURBOTOKEN", string);
            }
        }
        httpsURLConnection.setRequestProperty("APIKEY", F.f21886a.e());
        if (m3.m.p(str2, ShareTarget.METHOD_POST, true) && (outputStream = httpsURLConnection.getOutputStream()) != null) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, C.UTF8_NAME));
            bufferedWriter.write(O(hashMap2));
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
        }
        int responseCode = httpsURLConnection.getResponseCode();
        l4.k(responseCode);
        if (responseCode < 200 || responseCode >= 300) {
            bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getErrorStream()));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                l4.i(sb.toString());
                l4.a(this.f21899a);
                c.f7281a.a(str, hashMap, l4);
                return l4;
            }
        }
        c.f7281a.a(str, hashMap, l4);
        return l4;
    }

    private final g2.L F(String str, HashMap hashMap) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : hashMap.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        g2.L a5 = new C2331b().a(jSONObject, (C2072d) null, this.f21899a, str);
        a5.a(this.f21899a);
        c.f7281a.a(str, hashMap, a5);
        return a5;
    }

    private final JSONArray N0(ArrayList arrayList) {
        try {
            JSONArray jSONArray = new JSONArray();
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                JSONObject jSONObject = new JSONObject();
                if (((C2048f) arrayList.get(i4)).c() != null) {
                    jSONObject.put(RewardPlus.NAME, ((C2048f) arrayList.get(i4)).c());
                } else if (((C2048f) arrayList.get(i4)).m() != null) {
                    jSONObject.put(RewardPlus.NAME, ((C2048f) arrayList.get(i4)).m());
                } else if (((C2048f) arrayList.get(i4)).o() != null) {
                    jSONObject.put(RewardPlus.NAME, ((C2048f) arrayList.get(i4)).o());
                }
                jSONObject.put("packagename", ((C2048f) arrayList.get(i4)).o());
                if (((C2048f) arrayList.get(i4)).o() != null) {
                    m mVar = new m();
                    Context context = this.f21899a;
                    String o4 = ((C2048f) arrayList.get(i4)).o();
                    m.b(o4);
                    String h4 = mVar.h(context, o4);
                    if (new m().x(h4)) {
                        jSONObject.put("installerPackagename", h4);
                    }
                }
                jSONObject.put("versionCode", ((C2048f) arrayList.get(i4)).A());
                jSONObject.put("versionName", ((C2048f) arrayList.get(i4)).B());
                jSONObject.put("isSystemApp", ((C2048f) arrayList.get(i4)).E());
                jSONObject.put("sha256Base", ((C2048f) arrayList.get(i4)).r());
                jSONObject.put("md5Signature", ((C2048f) arrayList.get(i4)).k());
                jSONObject.put("minSDKVersion", ((C2048f) arrayList.get(i4)).l());
                if (((C2048f) arrayList.get(i4)).x() > 0) {
                    jSONObject.put("targetSDKVersion", ((C2048f) arrayList.get(i4)).x());
                }
                if (((C2048f) arrayList.get(i4)).n() != null) {
                    ArrayList n4 = ((C2048f) arrayList.get(i4)).n();
                    m.b(n4);
                    if (!n4.isEmpty()) {
                        JSONArray jSONArray2 = new JSONArray();
                        ArrayList n5 = ((C2048f) arrayList.get(i4)).n();
                        m.b(n5);
                        Iterator it = n5.iterator();
                        m.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            m.d(next, "next(...)");
                            C2063v vVar = (C2063v) next;
                            if (vVar.c() != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(RewardPlus.NAME, vVar.b());
                                jSONObject2.put("sha256", vVar.c());
                                jSONArray2.put(jSONObject2);
                            }
                        }
                        if (jSONArray2.length() > 0) {
                            jSONObject.put("obbs", jSONArray2);
                        }
                    }
                }
                if (((C2048f) arrayList.get(i4)).v() != null) {
                    ArrayList v4 = ((C2048f) arrayList.get(i4)).v();
                    m.b(v4);
                    if (!v4.isEmpty()) {
                        JSONArray jSONArray3 = new JSONArray();
                        ArrayList v5 = ((C2048f) arrayList.get(i4)).v();
                        m.b(v5);
                        Iterator it2 = v5.iterator();
                        m.d(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            Object next2 = it2.next();
                            m.d(next2, "next(...)");
                            C2063v vVar2 = (C2063v) next2;
                            if (vVar2.c() != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(RewardPlus.NAME, vVar2.b());
                                jSONObject3.put("sha256", vVar2.c());
                                jSONArray3.put(jSONObject3);
                            }
                        }
                        if (jSONArray3.length() > 0) {
                            jSONObject.put("splits", jSONArray3);
                        }
                    }
                }
                if (jSONObject.length() > 0) {
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private final String O(HashMap hashMap) {
        StringBuilder sb = new StringBuilder();
        boolean z4 = true;
        for (Map.Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (z4) {
                z4 = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(str, C.UTF8_NAME));
            sb.append("=");
            sb.append(URLEncoder.encode(str2, C.UTF8_NAME));
        }
        String sb2 = sb.toString();
        m.d(sb2, "toString(...)");
        return sb2;
    }

    private final String O0(r rVar) {
        String jSONObject = rVar.l().toString(2);
        m.d(jSONObject, "toString(...)");
        return jSONObject;
    }

    private final String P0(C2067z zVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (zVar.c() > 0) {
                jSONObject.put("total_memory", zVar.c());
            }
            if (zVar.a() > 0) {
                jSONObject.put("free_memory", zVar.a());
            }
            if (zVar.d() > 0) {
                jSONObject.put("total_ram_memory", zVar.d());
            }
            if (zVar.a() > 0) {
                jSONObject.put("free_ram_memory", zVar.b());
            }
            return jSONObject.toString(2);
        } catch (JSONException e5) {
            e5.printStackTrace();
            return "";
        }
    }

    private final JSONObject R0(P p4) {
        if (p4 == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lang", p4.d());
            if (p4.i()) {
                jSONObject.put("notifications_on", 1);
            } else {
                jSONObject.put("notifications_on", 0);
            }
            jSONObject.put("notifications_frecuency", Integer.parseInt(p4.c()));
            if (p4.j()) {
                jSONObject.put("only_wifi", 1);
            } else {
                jSONObject.put("only_wifi", 0);
            }
            jSONObject.put("download_updates_options", p4.g());
            if (p4.f()) {
                jSONObject.put("delete_apk", 1);
            } else {
                jSONObject.put("delete_apk", 0);
            }
            if (p4.h()) {
                jSONObject.put("install_apk_root", 1);
            } else {
                jSONObject.put("install_apk_root", 0);
            }
            jSONObject.put("versioncode", p4.e());
            return jSONObject;
        } catch (JSONException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private final HashMap s() {
        HashMap hashMap = new HashMap();
        r rVar = new r();
        rVar.k(this.f21899a);
        String c5 = rVar.c();
        if (!(c5 == null || c5.length() == 0)) {
            hashMap.put("countryIsoCode", c5);
        }
        return hashMap;
    }

    public final g2.L A() {
        g2.L E4 = E(r.f21923a.a() + "/eapi/home/features", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/home/features"));
        return E4;
    }

    public final g2.L A0(String str) {
        m.e(str, "fileId");
        g2.L E4 = E(r.f21923a.a() + "/eapi/v2/virus-total/" + str + "/report", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/v2/virus-total/fileId/report"));
        return E4;
    }

    public final g2.L B() {
        g2.L E4 = E(r.f21923a.a() + "/eapi/v2/app/interstitial-banner", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/v2/app/interstitial-banner"));
        return E4;
    }

    public final g2.L B0(String str) {
        m.e(str, "sha256");
        g2.L E4 = E(r.f21923a.a() + "/eapi/v2/virus-total-by-sha256/" + str + "/report", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/v2/virus-total-by-sha256/sha256/report"));
        return E4;
    }

    public final JSONObject C(g2.L l4, String str) {
        String d5;
        m.e(l4, "responseJson");
        m.e(str, "urlEndpoint");
        if (!(l4.b() || (d5 = l4.d()) == null || d5.length() == 0)) {
            try {
                String d6 = l4.d();
                m.b(d6);
                return new JSONObject(d6);
            } catch (JSONException unused) {
                Bundle bundle = new Bundle();
                bundle.putString("type", "jsonException");
                bundle.putString("url", str);
                new x(this.f21899a).d("apiRead", bundle);
            }
        }
        return null;
    }

    public final g2.L C0(int i4, int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        g2.L E4 = E(r.f21923a.a() + "/eapi/my-wishlist", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/my-wishlist"));
        return E4;
    }

    public final g2.L D0(long j4) {
        g2.L E4 = E(r.f21923a.b() + "/dwn/" + j4 + "/native-external/increase", (HashMap) null, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/dwn/appID/native-external/increase"));
        return E4;
    }

    public final g2.L E0(long j4) {
        g2.L E4 = E(r.f21923a.b() + "/dwn/" + j4 + "/native-external-update/increase", (HashMap) null, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/dwn/appID/native-external-update/increase"));
        return E4;
    }

    public final g2.L F0() {
        g2.L E4 = E("https://adservice.google.com/getconfig/pubvendors", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "adservice.google.com/getconfig/pubvendors"));
        return E4;
    }

    public final g2.L G(int i4, int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        g2.L E4 = E(r.f21923a.a() + "/eapi/apps/latest-updates", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/apps/latest-updates"));
        return E4;
    }

    public final g2.L G0(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/answer/" + j4 + "/like", (HashMap) null, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/answer/idReply/like"));
        return E4;
    }

    public final g2.L H(int i4, int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        g2.L E4 = E(r.f21923a.a() + "/eapi/apps/latest-updates-home", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/apps/latest-updates-home"));
        return E4;
    }

    public final g2.L H0(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/comment/" + j4 + "/like", (HashMap) null, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/comment/idReview/like"));
        return E4;
    }

    public final g2.L I(int i4, int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        g2.L E4 = E(r.f21923a.a() + "/eapi/my-recommended-list", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/my-recommended-list"));
        return E4;
    }

    public final g2.L I0(ArrayList arrayList) {
        m.e(arrayList, "events");
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            C2061t tVar = (C2061t) next;
            if (tVar.b() != null) {
                String b5 = tVar.b();
                m.b(b5);
                jSONArray.put(new JSONObject(b5));
            }
        }
        hashMap.put("events", jSONArray.toString());
        g2.L E4 = E(r.f21923a.a() + "/eapi/logs/event", hashMap, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/logs/event"));
        return E4;
    }

    public final g2.L J(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/app/" + j4 + "/my-comment", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/app/appID/my-comment"));
        return E4;
    }

    public final g2.L J0(ArrayList arrayList) {
        m.e(arrayList, "errors");
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            C2061t tVar = (C2061t) next;
            if (tVar.b() != null) {
                String b5 = tVar.b();
                m.b(b5);
                jSONArray.put(new JSONObject(b5));
            }
        }
        hashMap.put("errors", jSONArray.toString());
        g2.L E4 = E(r.f21923a.a() + "/eapi/logs/error", hashMap, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/logs/error"));
        return E4;
    }

    public final g2.L K(int i4, int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        g2.L E4 = E(r.f21923a.a() + "/eapi/apps/new-releases", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/apps/new-releases"));
        return E4;
    }

    public final g2.L K0(String str, String str2) {
        m.e(str, NotificationCompat.CATEGORY_EMAIL);
        m.e(str2, "pass");
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, str);
        String f4 = C1610f.f8672a.f(str2);
        m.b(f4);
        hashMap.put("password", f4);
        r rVar = new r();
        rVar.j(this.f21899a);
        if (rVar.d() != null) {
            String d5 = rVar.d();
            m.b(d5);
            hashMap.put("deviceIdentifier", d5);
        }
        g2.L E4 = E(r.f21923a.a() + "/eapi/v2/user/login", hashMap, ShareTarget.METHOD_POST);
        if (E4.b()) {
            E4.j(D(E4, "/eapi/v2/user/login"));
            return E4;
        }
        E4.j(C(E4, "/eapi/v2/user/login"));
        return E4;
    }

    public final g2.L L(int i4, int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        g2.L E4 = E(r.f21923a.a() + "/eapi/apps/new-releases-home", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/apps/new-releases-home"));
        return E4;
    }

    public final g2.L L0() {
        g2.L E4 = E(r.f21923a.a() + "/eapi/main-app", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/main-app"));
        return E4;
    }

    public final g2.L M(long j4, int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put("page", String.valueOf(i4));
        g2.L E4 = E(r.f21923a.a() + "/eapi/organization/" + j4 + "/apps", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/organization/organizationId/apps"));
        return E4;
    }

    public final g2.L M0(long j4, int i4, int i5) {
        r rVar = new r();
        rVar.j(this.f21899a);
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        g2.L E4 = E(r.f21923a.a() + "/eapi/app/" + j4 + "/device/" + rVar.d() + "/compatible/versions", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/app/appID/device/identifier/compatible/versions"));
        return E4;
    }

    public final g2.L N(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/organization/" + j4, (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/organization/organizationId"));
        return E4;
    }

    public final g2.L P(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/apps/" + j4 + "/permissions", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/apps/appId/permissions"));
        return E4;
    }

    public final g2.L Q(String str) {
        m.e(str, "identifier");
        g2.L E4 = E(r.f21923a.a() + "/eapi/v2/virus-total-by-identifier/" + str + "/report", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/v2/virus-total-by-identifier/identifier/report"));
        return E4;
    }

    public final ArrayList Q0(g2.L l4) {
        m.e(l4, "res");
        ArrayList arrayList = new ArrayList();
        if (!l4.b() && l4.e() != null) {
            JSONObject e5 = l4.e();
            m.b(e5);
            JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
            JSONObject e6 = l4.e();
            m.b(e6);
            if (e6.optInt("success") == 1 && optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                    m.d(optJSONObject, "optJSONObject(...)");
                    arrayList.add(C2050h.b.b(C2050h.f20600F0, optJSONObject, (Context) null, 2, (Object) null));
                }
            }
        }
        return arrayList;
    }

    public final g2.L R() {
        g2.L E4 = E(r.f21923a.a() + "/eapi/pre-register-apps-by-user", s(), ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/pre-register-apps-by-user"));
        return E4;
    }

    public final g2.L S(int i4, int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        g2.L E4 = E(r.f21923a.a() + "/eapi/my-profile-wishlist", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/my-profile-wishlist"));
        return E4;
    }

    public final g2.L S0(long j4, String str) {
        String str2;
        m.e(str, MimeTypes.BASE_TYPE_TEXT);
        HashMap hashMap = new HashMap();
        hashMap.put(MimeTypes.BASE_TYPE_TEXT, str);
        try {
            PackageManager packageManager = this.f21899a.getPackageManager();
            m.d(packageManager, "getPackageManager(...)");
            String packageName = this.f21899a.getPackageName();
            m.d(packageName, "getPackageName(...)");
            PackageInfo d5 = s.d(packageManager, packageName, 0);
            str2 = ' ' + d5.versionName;
        } catch (Exception e5) {
            e5.printStackTrace();
            str2 = "";
        }
        hashMap.put("uagent", "uptodownandroid" + str2);
        g2.L E4 = E(r.f21923a.a() + "/eapi/comments/" + j4 + "/answers", hashMap, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/comments/idReply/answers/post"));
        return E4;
    }

    public final g2.L T(long j4) {
        if (j4 == 0) {
            g2.L l4 = new g2.L();
            l4.k(MBridgeCommon.CampaignState.STATE_LOAD_FAILED_RESOURCE_DOWNLOAD_ERROR);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", 0);
            l4.i(jSONObject.toString());
            return l4;
        }
        HashMap hashMap = new HashMap();
        r rVar = new r();
        rVar.k(this.f21899a);
        String c5 = rVar.c();
        if (!(c5 == null || c5.length() == 0)) {
            hashMap.put("countryIsoCode", c5);
        }
        return E(r.f21923a.a() + "/eapi/v2/apps/" + j4 + "/device/" + rVar.d(), hashMap, ShareTarget.METHOD_GET);
    }

    public final g2.L T0(long j4, N n4) {
        String str;
        String str2;
        m.e(n4, "review");
        HashMap hashMap = new HashMap();
        if (n4.i() != null) {
            String i4 = n4.i();
            m.b(i4);
            if (i4.length() > 0) {
                String i5 = n4.i();
                m.b(i5);
                hashMap.put(MimeTypes.BASE_TYPE_TEXT, i5);
            }
        }
        hashMap.put(CampaignEx.JSON_KEY_STAR, String.valueOf(n4.h()));
        try {
            PackageManager packageManager = this.f21899a.getPackageManager();
            m.d(packageManager, "getPackageManager(...)");
            String packageName = this.f21899a.getPackageName();
            m.d(packageName, "getPackageName(...)");
            PackageInfo d5 = s.d(packageManager, packageName, 0);
            str = ' ' + d5.versionName;
        } catch (Exception e5) {
            e5.printStackTrace();
            str = "";
        }
        hashMap.put("uagent", "uptodownandroid" + str);
        U e6 = U.f20468m.e(this.f21899a);
        if (e6 != null) {
            str2 = e6.g();
        } else {
            str2 = null;
        }
        if (str2 != null) {
            String g4 = e6.g();
            m.b(g4);
            hashMap.put("id_user", g4);
        }
        g2.L E4 = E(r.f21923a.a() + "/eapi/apps/" + j4 + "/comments", hashMap, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/apps/appId/comments/post"));
        return E4;
    }

    public final g2.L U() {
        String str = "/eapi/promo-assign/provider/" + 1;
        g2.L E4 = E(r.f21923a.a() + str, (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, str));
        return E4;
    }

    public final g2.L U0(String str, String str2) {
        m.e(str, NotificationCompat.CATEGORY_EMAIL);
        m.e(str2, "email2");
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, str);
        hashMap.put("email2", str2);
        g2.L E4 = E(r.f21923a.a() + "/eapi/user/recoverPasswordMail", hashMap, ShareTarget.METHOD_POST);
        if (E4.b()) {
            E4.j(D(E4, "/eapi/user/recoverPasswordMail"));
            return E4;
        }
        E4.j(C(E4, "/eapi/user/recoverPasswordMail"));
        return E4;
    }

    public final g2.L V(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/v2/apps/" + j4 + "/promoted", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/v2/apps/appID/promoted"));
        return E4;
    }

    public final g2.L V0(long j4, long j5, List list) {
        m.e(list, "devicesID");
        HashMap hashMap = new HashMap();
        hashMap.put("deviceID", String.valueOf(j5));
        hashMap.put("targetDeviceIDs", list.toString());
        String str = "/eapi/app/" + j4 + "/remote-install";
        g2.L E4 = E(r.f21923a.a() + str, hashMap, ShareTarget.METHOD_POST);
        E4.j(C(E4, str));
        return E4;
    }

    public final g2.L W(int i4, int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        String str = "/eapi/categories/" + i4 + "/apps/news";
        g2.L E4 = E(r.f21923a.a() + str, hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, str));
        return E4;
    }

    public final g2.L W0(long j4) {
        String str = "/eapi/app/" + j4 + "/recommended/delete";
        g2.L E4 = E(r.f21923a.a() + str, (HashMap) null, ShareTarget.METHOD_POST);
        E4.j(C(E4, str));
        return E4;
    }

    public final g2.L X(int i4, int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        g2.L E4 = E(r.f21923a.a() + "/eapi/v2/apps/recent/featured", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/v2/apps/recent/featured"));
        return E4;
    }

    public final g2.L X0(r rVar, boolean z4) {
        m.e(rVar, "device");
        JSONObject l4 = rVar.l();
        String str = r.f21923a.c() + "/eapi/v2/tracker/device";
        HashMap hashMap = new HashMap();
        hashMap.put("device", l4.toString());
        if (z4) {
            return F(str, hashMap);
        }
        return E(str, hashMap, ShareTarget.METHOD_POST);
    }

    public final g2.L Y(String str, int i4, int i5) {
        m.e(str, "userID");
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        g2.L E4 = E(r.f21923a.a() + "/eapi/user/" + str + "/recommended-list", hashMap, ShareTarget.METHOD_GET);
        StringBuilder sb = new StringBuilder();
        sb.append("/eapi/user/");
        sb.append(str);
        sb.append("/recommended-list");
        E4.j(C(E4, sb.toString()));
        return E4;
    }

    public final g2.L Y0(ArrayList arrayList, String str, boolean z4) {
        m.e(arrayList, "apps");
        m.e(str, "identifier");
        String str2 = r.f21923a.c() + "/eapi/v3/tracker/apps/save";
        JSONArray N02 = N0(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("identifier", str);
        hashMap.put("apps", String.valueOf(N02));
        hashMap.put("app_version", "671");
        if (z4) {
            return F(str2, hashMap);
        }
        return E(str2, hashMap, ShareTarget.METHOD_POST);
    }

    public final g2.L Z(long j4) {
        r rVar = new r();
        rVar.j(this.f21899a);
        String str = "/eapi/app/" + j4 + "/my-devices/" + rVar.d();
        g2.L E4 = E(r.f21923a.a() + str, (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, str));
        return E4;
    }

    public final g2.L Z0(String str, int i4, int i5) {
        String str2;
        int i6;
        boolean z4;
        m.e(str, MimeTypes.BASE_TYPE_TEXT);
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        try {
            String g4 = new j("\\n").g(str, " ");
            int length = g4.length() - 1;
            int i7 = 0;
            boolean z5 = false;
            while (true) {
                if (i7 > length) {
                    break;
                }
                if (!z5) {
                    i6 = i7;
                } else {
                    i6 = length;
                }
                if (m.g(g4.charAt(i6), 32) <= 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!z5) {
                    if (!z4) {
                        z5 = true;
                    } else {
                        i7++;
                    }
                } else if (!z4) {
                    break;
                } else {
                    length--;
                }
            }
            str2 = URLEncoder.encode(g4.subSequence(i7, length + 1).toString(), C.UTF8_NAME);
        } catch (UnsupportedEncodingException e5) {
            e5.printStackTrace();
            str2 = null;
        }
        g2.L E4 = E(r.f21923a.a() + "/eapi/v2/apps/search" + '/' + str2, hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/v2/apps/search"));
        return E4;
    }

    public final g2.L a(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/app/" + j4 + "/pre-register/add", s(), ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/app/appID/pre-register/add"));
        return E4;
    }

    public final g2.L a0(String str) {
        m.e(str, "identifier");
        g2.L E4 = E(r.f21923a.a() + "/eapi/my-remote-apps/" + str, (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/my-remote-apps/identifier"));
        return E4;
    }

    public final g2.L a1(r rVar, P p4) {
        m.e(rVar, "device");
        HashMap hashMap = new HashMap();
        hashMap.put("device", O0(rVar));
        JSONObject R02 = R0(p4);
        if (R02 != null) {
            hashMap.put("settings", R02.toString());
        }
        g2.L E4 = E(r.f21923a.c() + "/eapi/v2/tracker/identifier/" + rVar.d() + "/settings", hashMap, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/v2/tracker/identifier/identifier/settings"));
        return E4;
    }

    public final g2.L b(long j4) {
        String str = "/eapi/app/" + j4 + "/recommended/add";
        g2.L E4 = E(r.f21923a.a() + str, (HashMap) null, ShareTarget.METHOD_POST);
        E4.j(C(E4, str));
        return E4;
    }

    public final g2.L b0(long j4, int i4, int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        g2.L E4 = E(r.f21923a.a() + "/eapi/comments/" + j4 + "/answers", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/comments/idReview/answers"));
        return E4;
    }

    public final g2.L b1(String str, String str2, r rVar, C2067z zVar) {
        m.e(str, NotificationCompat.CATEGORY_EMAIL);
        m.e(str2, "suggestion");
        m.e(rVar, "device");
        m.e(zVar, "memory");
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, str);
        hashMap.put(NotificationCompat.CATEGORY_MESSAGE, str2);
        hashMap.put("device", O0(rVar));
        hashMap.put("memory", P0(zVar));
        g2.L E4 = E(r.f21923a.a() + "/eapi/nativeapp/sendsuggestion", hashMap, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/nativeapp/sendsuggestion"));
        return E4;
    }

    public final g2.L c(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/app/" + j4 + "/alternatives", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/app/appID/alternatives"));
        return E4;
    }

    public final g2.L c0(long j4, int i4, int i5, String str) {
        m.e(str, "ordination");
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        hashMap.put("order", str);
        g2.L E4 = E(r.f21923a.a() + "/eapi/apps/" + j4 + "/comments", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/apps/appId/comments"));
        return E4;
    }

    public final g2.L c1() {
        g2.L E4 = E(r.f21923a.a() + "/eapi/my-recommended-list/private", (HashMap) null, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/my-recommended-list/private"));
        return E4;
    }

    public final g2.L d() {
        g2.L E4 = E(r.f21923a.a() + "/eapi/event-log/version", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/event-log/version"));
        return E4;
    }

    public final g2.L d0(long j4, int i4, int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        g2.L E4 = E(r.f21923a.a() + "/eapi/apps/" + j4 + "/comments-with-text", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/apps/appId/comments-with-text"));
        return E4;
    }

    public final g2.L d1() {
        g2.L E4 = E(r.f21923a.a() + "/eapi/my-recommended-list/public", (HashMap) null, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/my-recommended-list/public"));
        return E4;
    }

    public final g2.L e(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/app/" + j4 + "/pre-register/cancel", s(), ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/app/appID/pre-register/cancel"));
        return E4;
    }

    public final g2.L e0(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/app/" + j4 + "/screenshots", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/app/appId/screenshots"));
        return E4;
    }

    public final g2.L e1(long j4) {
        HashMap hashMap = new HashMap();
        hashMap.put("avatarID", String.valueOf(j4));
        g2.L E4 = E(r.f21923a.a() + "/eapi/user/avatar", hashMap, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/user/avatar"));
        return E4;
    }

    public final g2.L f(String str, String str2) {
        m.e(str, "password");
        m.e(str2, "repeatPassword");
        HashMap hashMap = new HashMap();
        hashMap.put("password1", str);
        hashMap.put("password2", str2);
        g2.L E4 = E(r.f21923a.a() + "/eapi/user/set-new-password", hashMap, ShareTarget.METHOD_POST);
        if (E4.b()) {
            E4.j(D(E4, "/eapi/user/set-new-password"));
            return E4;
        }
        E4.j(C(E4, "/eapi/user/set-new-password"));
        return E4;
    }

    public final g2.L f0(String str) {
        m.e(str, "identifier");
        return E(r.f21923a.c() + "/eapi/v2/tracker/device/" + str + "/status", (HashMap) null, ShareTarget.METHOD_GET);
    }

    public final g2.L f1(String str, String str2, String str3) {
        m.e(str, RewardPlus.NAME);
        m.e(str2, "pass");
        m.e(str3, NotificationCompat.CATEGORY_EMAIL);
        HashMap hashMap = new HashMap();
        hashMap.put("username", str);
        String f4 = C1610f.f8672a.f(str2);
        m.b(f4);
        hashMap.put("password", f4);
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, str3);
        hashMap.put("terms", "1");
        g2.L E4 = E(r.f21923a.a() + "/eapi/user/signup", hashMap, ShareTarget.METHOD_POST);
        if (E4.b()) {
            E4.j(D(E4, "/eapi/user/signup"));
            return E4;
        }
        E4.j(C(E4, "/eapi/user/signup"));
        return E4;
    }

    public final g2.L g(String str, int i4) {
        m.e(str, "username");
        HashMap hashMap = new HashMap();
        hashMap.put("newUsername", str);
        hashMap.put("usernameFormatID", String.valueOf(i4));
        g2.L E4 = E(r.f21923a.a() + "/eapi/user/change-username", hashMap, ShareTarget.METHOD_POST);
        if (E4.b()) {
            E4.j(D(E4, "/eapi/user/change-username"));
            return E4;
        }
        E4.j(C(E4, "/eapi/user/change-username"));
        return E4;
    }

    public final g2.L g0(String str) {
        m.e(str, "userID");
        g2.L E4 = E(r.f21923a.a() + "/eapi/turbosubscription/get-url-portal/" + str + '/', (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/turbosubscription/get-url-portal/userID/"));
        return E4;
    }

    public final g2.L g1(String str, String str2) {
        m.e(str, "accessToken");
        m.e(str2, "provider");
        HashMap hashMap = new HashMap();
        hashMap.put("provider", str2);
        hashMap.put("accessToken", str);
        r rVar = new r();
        rVar.j(this.f21899a);
        if (rVar.d() != null) {
            String d5 = rVar.d();
            m.b(d5);
            hashMap.put("deviceIdentifier", d5);
        }
        g2.L E4 = E(r.f21923a.a() + "/eapi/user/usertokenSignup", hashMap, ShareTarget.METHOD_POST);
        if (E4.b()) {
            E4.j(D(E4, "/eapi/user/usertokenSignup"));
            return E4;
        }
        E4.j(C(E4, "/eapi/user/usertokenSignup"));
        return E4;
    }

    public final boolean h(g2.L l4) {
        long j4;
        m.e(l4, "res");
        boolean z4 = false;
        if (l4.b()) {
            if (l4.f() == 503) {
                String d5 = l4.d();
                if (!(d5 == null || d5.length() == 0)) {
                    try {
                        String d6 = l4.d();
                        m.b(d6);
                        JSONObject jSONObject = new JSONObject(d6);
                        if (!jSONObject.isNull("seconds")) {
                            j4 = jSONObject.optLong("seconds");
                            com.uptodown.activities.preferences.a.f18818a.k1(this.f21899a, j4);
                            t a5 = t.f21927u.a(this.f21899a);
                            a5.a();
                            a5.S();
                            a5.i();
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                j4 = 7200;
                com.uptodown.activities.preferences.a.f18818a.k1(this.f21899a, j4);
                t a52 = t.f21927u.a(this.f21899a);
                a52.a();
                a52.S();
                a52.i();
            }
            return false;
        }
        String d7 = l4.d();
        if (d7 == null || d7.length() == 0) {
            z4 = true;
        }
        return !z4;
    }

    public final g2.L h0(int i4, int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        g2.L E4 = E(r.f21923a.a() + "/eapi/v2/app/top-platform", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/v2/app/top-platform"));
        return E4;
    }

    public final g2.L h1(long j4, int i4, int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        g2.L E4 = E(r.f21923a.a() + "/eapi/" + j4 + "/similar", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/appID/similar"));
        return E4;
    }

    public final g2.L i(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/app/" + j4 + "/pre-registered", s(), ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/app/appID/pre-registered"));
        return E4;
    }

    public final g2.L i0(int i4, int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        String str = "/eapi/category/" + i4 + "/apps/top";
        g2.L E4 = E(r.f21923a.a() + str, hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, str));
        return E4;
    }

    public final g2.L i1(String str) {
        m.e(str, "deviceID");
        g2.L E4 = E(r.f21923a.a() + "/eapi/user-data/device/" + str + "/unlink", (HashMap) null, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/user-data/device/deviceID/unlink"));
        return E4;
    }

    public final g2.L j(ArrayList arrayList, int i4, int i5) {
        m.e(arrayList, "categories");
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        hashMap.put("categoryIDs", arrayList.toString());
        g2.L E4 = E(r.f21923a.a() + "/eapi/floating-category/additional/apps", hashMap, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/floating-category/additional/apps"));
        return E4;
    }

    public final g2.L j0(int i4, int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        String str = "/eapi/v2/leaf-category/" + i4 + "/apps/top";
        g2.L E4 = E(r.f21923a.a() + str, hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, str));
        return E4;
    }

    public final g2.L j1(String str, String str2) {
        m.e(str, "deviceID");
        m.e(str2, "newName");
        HashMap hashMap = new HashMap();
        hashMap.put(RewardPlus.NAME, str2);
        g2.L E4 = E(r.f21923a.a() + "/eapi/user-data/device/" + str + "/update-name", hashMap, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/user-data/device/deviceID/update-name"));
        return E4;
    }

    public final g2.L k(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/app/" + j4 + "/affiliated-app", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/app/appID/affiliated-app"));
        return E4;
    }

    public final g2.L k0(int i4, int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        String str = "/eapi/floating-category/" + i4 + "/apps";
        g2.L E4 = E(r.f21923a.a() + str, hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, str));
        return E4;
    }

    public final g2.L k1(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/app/" + j4 + "/wishlist/add", (HashMap) null, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/app/appID/wishlist/add"));
        return E4;
    }

    public final g2.L l(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/v2/app/" + j4 + "/abis", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/v2/app/appId/abis"));
        return E4;
    }

    public final g2.L l0(int i4, int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        String str = "/eapi/v2/apps/category/" + i4 + "/top/featured";
        g2.L E4 = E(r.f21923a.a() + str, hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, str));
        return E4;
    }

    public final g2.L l1(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/app/" + j4 + "/wishlist/delete", (HashMap) null, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/app/appID/wishlist/delete"));
        return E4;
    }

    public final g2.L m(String str) {
        m.e(str, "packagename");
        g2.L E4 = E(r.f21923a.a() + "/eapi/apps/byPackagename" + '/' + str, (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/apps/byPackagename"));
        return E4;
    }

    public final g2.L m0(int i4, int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        String str = "/eapi/floating-category/" + i4 + "/apps-list";
        g2.L E4 = E(r.f21923a.a() + str, hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, str));
        return E4;
    }

    public final g2.L n(String str) {
        m.e(str, "downloadURL");
        HashMap hashMap = new HashMap();
        hashMap.put("downloadURL", str);
        return E(r.f21923a.a() + "/eapi/app/get-by-download-url", hashMap, ShareTarget.METHOD_GET);
    }

    public final g2.L n0() {
        r rVar = new r();
        rVar.j(this.f21899a);
        g2.L E4 = E(r.f21923a.c() + "/eapi/androidtracker/device-apps-installed" + '/' + rVar.d(), (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/androidtracker/device-apps-installed"));
        return E4;
    }

    public final g2.L o(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/v2/app/" + j4 + "/languages", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/v2/app/appId/languages"));
        return E4;
    }

    public final g2.L o0(String str) {
        m.e(str, "identifier");
        return E(r.f21923a.c() + "/eapi/v2/tracker/updates/" + str, (HashMap) null, ShareTarget.METHOD_GET);
    }

    public final g2.L p() {
        g2.L E4 = E(r.f21923a.a() + "/eapi/v2/app/floating-banner", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/v2/app/floating-banner"));
        return E4;
    }

    public final g2.L p0(String str, int i4, String str2) {
        m.e(str, "fileId");
        m.e(str2, "appId");
        HashMap hashMap = new HashMap();
        hashMap.put("update", String.valueOf(i4));
        return E(r.f21923a.a() + "/eapi/apps/" + str2 + "/file/" + str + "/downloadUrl", hashMap, ShareTarget.METHOD_GET);
    }

    public final g2.L q() {
        HashMap hashMap = new HashMap();
        return E(r.f21923a.a() + "/eapi/categories/parents", hashMap, ShareTarget.METHOD_GET);
    }

    public final g2.L q0(String str, int i4, String str2) {
        m.e(str, "fileId");
        m.e(str2, "appId");
        HashMap hashMap = new HashMap();
        hashMap.put("update", String.valueOf(i4));
        return E(r.f21923a.a() + "/eapi/apps/" + str2 + "/file/" + str + "/resumeDownloadURL", hashMap, ShareTarget.METHOD_GET);
    }

    public final g2.L r(int i4) {
        String str = "/eapi/v2/categories/" + i4 + "/leaf-categories";
        g2.L E4 = E(r.f21923a.a() + str, (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, str));
        return E4;
    }

    public final g2.L r0(String str, String str2) {
        m.e(str, "packagename");
        m.e(str2, "md5signature");
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("packagename", str);
        jSONObject.put("md5Signature", str2);
        hashMap.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, jSONObject.toString());
        g2.L E4 = E(r.f21923a.a() + "/eapi/nativeapp/getappurlbypackagenamemd5signature", hashMap, ShareTarget.METHOD_POST);
        E4.j(C(E4, "/eapi/nativeapp/getappurlbypackagenamemd5signature"));
        return E4;
    }

    public final g2.L s0() {
        g2.L E4 = E(r.f21923a.a() + "/eapi/v2/user/avatars", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/v2/user/avatars"));
        return E4;
    }

    public final g2.L t(int i4, int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        String str = "/eapi/floating-category/" + i4 + "/data-and-apps-list";
        g2.L E4 = E(r.f21923a.a() + str, hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, str));
        return E4;
    }

    public final g2.L t0(String str, int i4, int i5) {
        m.e(str, "userID");
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i4));
        hashMap.put("page[offset]", String.valueOf(i5));
        g2.L E4 = E(r.f21923a.a() + "/eapi/user/" + str + "/comments", hashMap, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/user/userID/comments"));
        return E4;
    }

    public final g2.L u(String str) {
        m.e(str, "identifier");
        return E(r.f21923a.c() + "/eapi/v2/tracker/device/" + str, (HashMap) null, ShareTarget.METHOD_GET);
    }

    public final g2.L u0() {
        HashMap hashMap = new HashMap();
        r rVar = new r();
        rVar.j(this.f21899a);
        if (rVar.d() != null) {
            String d5 = rVar.d();
            m.b(d5);
            hashMap.put("deviceIdentifier", d5);
        }
        return E(r.f21923a.a() + "/eapi/user/getUpdatedData", hashMap, ShareTarget.METHOD_GET);
    }

    public final g2.L v(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/faq/" + j4, (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/faq/appId"));
        return E4;
    }

    public final g2.L v0(String str) {
        m.e(str, "userID");
        g2.L E4 = E(r.f21923a.a() + "/eapi/profile/" + str + "/data", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/profile/userID/data"));
        return E4;
    }

    public final g2.L w(String str) {
        m.e(str, "identifier");
        return E(r.f21923a.c() + "/eapi/v2/tracker/app-to-upload/" + str, (HashMap) null, ShareTarget.METHOD_GET);
    }

    public final g2.L w0(String str) {
        m.e(str, "deviceID");
        g2.L E4 = E(r.f21923a.a() + "/eapi/user-data/device" + '/' + str, (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/user-data/device"));
        return E4;
    }

    public final g2.L x() {
        g2.L E4 = E(r.f21923a.a() + "/eapi/categories/floating", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/categories/floating"));
        return E4;
    }

    public final g2.L x0() {
        g2.L E4 = E(r.f21923a.a() + "/eapi/user-data/devices", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/user-data/devices"));
        return E4;
    }

    public final g2.L y(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/floating-categories/app" + '/' + j4, (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/floating-categories/app"));
        return E4;
    }

    public final g2.L y0() {
        g2.L E4 = E(r.f21923a.a() + "/eapi/user/username-formats", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/user/username-formats"));
        return E4;
    }

    public final g2.L z(int i4) {
        String str = "/eapi/floating-category-related/" + i4;
        g2.L E4 = E(r.f21923a.a() + str, (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, str));
        return E4;
    }

    public final g2.L z0(long j4) {
        g2.L E4 = E(r.f21923a.a() + "/eapi/apps/" + j4 + "/video", (HashMap) null, ShareTarget.METHOD_GET);
        E4.j(C(E4, "/eapi/apps/appId/video"));
        return E4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public L(Context context, C2072d dVar) {
        this(context);
        m.e(context, "context");
    }
}
