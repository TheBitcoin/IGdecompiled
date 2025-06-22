package com.google.android.datatransport.cct;

import K0.C1492a;
import K0.C1493b;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import o.C0962c;
import p.C1015a;
import p.n;
import p.o;
import p.p;
import p.q;
import p.r;
import p.s;
import p.t;
import p.u;
import p.v;
import p.w;
import p.x;
import q.h;
import q.i;
import r.C1023f;
import r.C1024g;
import r.C1030m;
import u.C1068a;
import v.C1070b;

final class d implements C1030m {

    /* renamed from: a  reason: collision with root package name */
    private final C1492a f1175a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectivityManager f1176b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1177c;

    /* renamed from: d  reason: collision with root package name */
    final URL f1178d;

    /* renamed from: e  reason: collision with root package name */
    private final A.a f1179e;

    /* renamed from: f  reason: collision with root package name */
    private final A.a f1180f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1181g;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final URL f1182a;

        /* renamed from: b  reason: collision with root package name */
        final n f1183b;

        /* renamed from: c  reason: collision with root package name */
        final String f1184c;

        a(URL url, n nVar, String str) {
            this.f1182a = url;
            this.f1183b = nVar;
            this.f1184c = str;
        }

        /* access modifiers changed from: package-private */
        public a a(URL url) {
            return new a(url, this.f1183b, this.f1184c);
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f1185a;

        /* renamed from: b  reason: collision with root package name */
        final URL f1186b;

        /* renamed from: c  reason: collision with root package name */
        final long f1187c;

        b(int i4, URL url, long j4) {
            this.f1185a = i4;
            this.f1186b = url;
            this.f1187c = j4;
        }
    }

    d(Context context, A.a aVar, A.a aVar2, int i4) {
        this.f1175a = n.b();
        this.f1177c = context;
        this.f1176b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f1178d = n(a.f1166c);
        this.f1179e = aVar2;
        this.f1180f = aVar;
        this.f1181g = i4;
    }

    public static /* synthetic */ a d(a aVar, b bVar) {
        URL url = bVar.f1186b;
        if (url == null) {
            return null;
        }
        C1068a.b("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f1186b);
    }

    /* access modifiers changed from: private */
    public b e(a aVar) {
        OutputStream outputStream;
        GZIPOutputStream gZIPOutputStream;
        InputStream m4;
        C1068a.f("CctTransportBackend", "Making request to: %s", aVar.f1182a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f1182a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f1181g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
        httpURLConnection.setRequestProperty(Command.HTTP_HEADER_USER_AGENT, String.format("datatransport/%s android/", new Object[]{"3.3.0"}));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f1184c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            outputStream = httpURLConnection.getOutputStream();
            gZIPOutputStream = new GZIPOutputStream(outputStream);
            this.f1175a.a(aVar.f1183b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
            gZIPOutputStream.close();
            if (outputStream != null) {
                outputStream.close();
            }
            int responseCode = httpURLConnection.getResponseCode();
            C1068a.f("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
            C1068a.b("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
            C1068a.b("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
            if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0);
            }
            if (responseCode != 200) {
                return new b(responseCode, (URL) null, 0);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                m4 = m(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                b bVar = new b(responseCode, (URL) null, v.b(new BufferedReader(new InputStreamReader(m4))).c());
                if (m4 != null) {
                    m4.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return bVar;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
            throw th;
            throw th;
            throw th;
        } catch (ConnectException | UnknownHostException e5) {
            C1068a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e5);
            return new b(500, (URL) null, 0);
        } catch (C1493b | IOException e6) {
            C1068a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e6);
            return new b(400, (URL) null, 0);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private static String f(Context context) {
        String simOperator = k(context).getSimOperator();
        if (simOperator != null) {
            return simOperator;
        }
        return "";
    }

    private static int g(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return w.b.UNKNOWN_MOBILE_SUBTYPE.b();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return w.b.COMBINED.b();
        }
        if (w.b.a(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private static int h(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return w.c.NONE.b();
        }
        return networkInfo.getType();
    }

    private static int i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e5) {
            C1068a.d("CctTransportBackend", "Unable to find version code for package", e5);
            return -1;
        }
    }

    private n j(C1023f fVar) {
        t.a aVar;
        HashMap hashMap = new HashMap();
        for (i iVar : fVar.b()) {
            String n4 = iVar.n();
            if (!hashMap.containsKey(n4)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(iVar);
                hashMap.put(n4, arrayList);
            } else {
                ((List) hashMap.get(n4)).add(iVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            i iVar2 = (i) ((List) entry.getValue()).get(0);
            u.a b5 = u.a().f(x.DEFAULT).g(this.f1180f.a()).h(this.f1179e.a()).b(o.a().c(o.b.ANDROID_FIREBASE).b(C1015a.a().m(Integer.valueOf(iVar2.i("sdk-version"))).j(iVar2.b("model")).f(iVar2.b("hardware")).d(iVar2.b("device")).l(iVar2.b("product")).k(iVar2.b("os-uild")).h(iVar2.b("manufacturer")).e(iVar2.b("fingerprint")).c(iVar2.b("country")).g(iVar2.b("locale")).i(iVar2.b("mcc_mnc")).b(iVar2.b("application_build")).a()).a());
            try {
                b5.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                b5.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (i iVar3 : (List) entry.getValue()) {
                h e5 = iVar3.e();
                C0962c b6 = e5.b();
                if (b6.equals(C0962c.b("proto"))) {
                    aVar = t.l(e5.a());
                } else if (b6.equals(C0962c.b("json"))) {
                    aVar = t.k(new String(e5.a(), Charset.forName(C.UTF8_NAME)));
                } else {
                    C1068a.g("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b6);
                }
                aVar.d(iVar3.f()).e(iVar3.o()).j(iVar3.j("tz-offset")).g(w.a().c(w.c.a(iVar3.i("net-type"))).b(w.b.a(iVar3.i("mobile-subtype"))).a());
                if (iVar3.d() != null) {
                    aVar.c(iVar3.d());
                }
                if (iVar3.l() != null) {
                    aVar.b(p.a().b(s.a().b(r.a().b(iVar3.l()).a()).a()).c(p.b.EVENT_OVERRIDE).a());
                }
                if (!(iVar3.g() == null && iVar3.h() == null)) {
                    q.a a5 = q.a();
                    if (iVar3.g() != null) {
                        a5.b(iVar3.g());
                    }
                    if (iVar3.h() != null) {
                        a5.c(iVar3.h());
                    }
                    aVar.f(a5.a());
                }
                arrayList3.add(aVar.a());
            }
            b5.c(arrayList3);
            arrayList2.add(b5.a());
        }
        return n.a(arrayList2);
    }

    private static TelephonyManager k(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    static long l() {
        Calendar.getInstance();
        return (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000);
    }

    private static InputStream m(InputStream inputStream, String str) {
        if ("gzip".equals(str)) {
            return new GZIPInputStream(inputStream);
        }
        return inputStream;
    }

    private static URL n(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e5) {
            throw new IllegalArgumentException("Invalid url: " + str, e5);
        }
    }

    public C1024g a(C1023f fVar) {
        n j4 = j(fVar);
        URL url = this.f1178d;
        String str = null;
        if (fVar.c() != null) {
            try {
                a c5 = a.c(fVar.c());
                if (c5.d() != null) {
                    str = c5.d();
                }
                if (c5.e() != null) {
                    url = n(c5.e());
                }
            } catch (IllegalArgumentException unused) {
                return C1024g.a();
            }
        }
        try {
            b bVar = (b) C1070b.a(5, new a(url, j4, str), new b(this), new c());
            int i4 = bVar.f1185a;
            if (i4 == 200) {
                return C1024g.e(bVar.f1187c);
            }
            if (i4 < 500) {
                if (i4 != 404) {
                    if (i4 == 400) {
                        return C1024g.d();
                    }
                    return C1024g.a();
                }
            }
            return C1024g.f();
        } catch (IOException e5) {
            C1068a.d("CctTransportBackend", "Could not make request to the backend", e5);
            return C1024g.f();
        }
    }

    public i b(i iVar) {
        NetworkInfo activeNetworkInfo = this.f1176b.getActiveNetworkInfo();
        return iVar.p().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", l()).a("net-type", h(activeNetworkInfo)).a("mobile-subtype", g(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", f(this.f1177c)).c("application_build", Integer.toString(i(this.f1177c))).d();
    }

    d(Context context, A.a aVar, A.a aVar2) {
        this(context, aVar, aVar2, 130000);
    }
}
