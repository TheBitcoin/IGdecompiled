package com.uptodown.workers;

import N1.k;
import W1.C1610f;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import g2.C2060s;
import g2.S;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import u2.C2313C;
import u2.F;
import u2.t;
import u2.x;

public class DownloadWorker extends Worker {

    /* renamed from: d  reason: collision with root package name */
    public static final a f19459d = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static C2060s f19460e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static boolean f19461f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static boolean f19462g;

    /* renamed from: a  reason: collision with root package name */
    private Context f19463a;

    /* renamed from: b  reason: collision with root package name */
    private x f19464b;

    /* renamed from: c  reason: collision with root package name */
    private String f19465c;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final void a(C2060s sVar) {
            m.e(sVar, "download");
            if (sVar.h() > 0) {
                d(sVar.h());
            } else if (sVar.w() != null) {
                String w4 = sVar.w();
                m.b(w4);
                c(w4);
            }
        }

        public final void b() {
            r(false);
            p(true);
        }

        public final void c(String str) {
            String str2;
            m.e(str, "packagename");
            C2060s f4 = f();
            if (f4 != null) {
                str2 = f4.w();
            } else {
                str2 = null;
            }
            if (m.a(str2, str)) {
                b();
            }
        }

        public final void d(long j4) {
            if (j(j4)) {
                b();
            }
        }

        public final boolean e() {
            return DownloadWorker.f19461f;
        }

        public final C2060s f() {
            return DownloadWorker.f19460e;
        }

        public final C2060s g() {
            return f();
        }

        public final boolean h() {
            return DownloadWorker.f19462g;
        }

        public final boolean i() {
            return e();
        }

        public final boolean j(long j4) {
            if (f() == null) {
                return false;
            }
            C2060s f4 = f();
            m.b(f4);
            if (f4.h() == j4) {
                return true;
            }
            return false;
        }

        public final boolean k(long j4, long j5) {
            if (f() == null) {
                return false;
            }
            C2060s f4 = f();
            m.b(f4);
            if (f4.h() != j4) {
                return false;
            }
            C2060s f5 = f();
            m.b(f5);
            if (f5.E() == j5) {
                return true;
            }
            return false;
        }

        public final boolean l(C2060s sVar) {
            m.e(sVar, "d");
            if (f() != null && ((C2060s.c) sVar.o().get(0)).d() > 0) {
                C2060s f4 = f();
                m.b(f4);
                if (((C2060s.c) f4.o().get(0)).d() == ((C2060s.c) sVar.o().get(0)).d()) {
                    return true;
                }
            }
            return false;
        }

        public final boolean m(String str) {
            m.e(str, "packagename");
            if (f() == null) {
                return false;
            }
            C2060s f4 = f();
            m.b(f4);
            if (m.a(f4.w(), str)) {
                return true;
            }
            return false;
        }

        public final void n() {
            r(true);
        }

        public final void o() {
            r(false);
            p(false);
        }

        public final void p(boolean z4) {
            DownloadWorker.f19461f = z4;
        }

        public final void q(C2060s sVar) {
            DownloadWorker.f19460e = sVar;
        }

        public final void r(boolean z4) {
            DownloadWorker.f19462g = z4;
        }

        private a() {
        }
    }

    public interface b {
        void a(long j4);

        void b();

        void c(long j4);

        void d();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DownloadWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.e(context, "context");
        m.e(workerParameters, "params");
        this.f19463a = context;
    }

    private final HttpsURLConnection B(URL url) {
        URLConnection openConnection = url.openConnection();
        m.c(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
        J(httpsURLConnection);
        return httpsURLConnection;
    }

    private final void C(C2060s sVar, String str) {
        if (sVar != null) {
            sVar.I(this.f19463a);
            H(sVar);
            if (sVar.N()) {
                C2313C.f21882a.y(this.f19463a, sVar, str);
            }
        }
    }

    private final void D(C2060s sVar, C2060s.c cVar, String str, String str2, long j4, String str3) {
        S u4 = u();
        if (u4 != null) {
            Bundle bundle = new Bundle();
            bundle.putString("packagename", u4.h());
            F.f21886a.g().send(102, bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putString("exception", str);
            bundle2.putString("url", str3);
            y(u4, sVar, cVar, bundle2, str2, j4);
            return;
        }
        E(str, j4, str3);
    }

    private final void E(String str, long j4, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("exception", str);
        bundle.putString("type", "fail");
        bundle.putString("url", str2);
        l(" (109)", bundle, j4);
    }

    private final void F(String str, Bundle bundle, long j4, C2060s sVar) {
        C(sVar, str);
        if (j4 > 0) {
            bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j4) / ((long) 1000));
        }
        Bundle g4 = g(bundle);
        x xVar = this.f19464b;
        if (xVar != null) {
            xVar.d("download", g4);
        }
    }

    private final void J(HttpsURLConnection httpsURLConnection) {
        httpsURLConnection.setRequestProperty("Identificador", "Uptodown_Android");
        httpsURLConnection.setRequestProperty("Identificador-Version", "671");
        httpsURLConnection.setRequestProperty("APIKEY", F.f21886a.e());
        httpsURLConnection.setConnectTimeout(MBridgeCommon.DEFAULT_LOAD_TIMEOUT);
        httpsURLConnection.setReadTimeout(90000);
    }

    private final void i(InputStream inputStream, OutputStream outputStream, HttpsURLConnection httpsURLConnection) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
        httpsURLConnection.disconnect();
    }

    public static /* synthetic */ void k(DownloadWorker downloadWorker, long j4, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                j4 = 0;
            }
            downloadWorker.j(j4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteDownloadCancelNotificationAndSendToReceiver");
    }

    private final void n() {
        Bundle bundle = new Bundle();
        bundle.putString("type", "first_data");
        w(bundle, this.f19465c);
    }

    private final long o(HttpsURLConnection httpsURLConnection) {
        if (Build.VERSION.SDK_INT >= 24) {
            return httpsURLConnection.getContentLengthLong();
        }
        return (long) httpsURLConnection.getContentLength();
    }

    private final void z(int i4) {
        if (f19460e != null) {
            Data.Builder builder = new Data.Builder();
            builder.putInt("downloadProgress", i4);
            setProgressAsync(builder.build());
            if (u() == null) {
                C2313C.f21882a.j(this.f19463a);
            }
            C2060s sVar = f19460e;
            m.b(sVar);
            I(sVar, 201);
        }
    }

    public final boolean A(HttpsURLConnection httpsURLConnection, long j4) {
        m.e(httpsURLConnection, "urlConnection");
        httpsURLConnection.connect();
        int responseCode = httpsURLConnection.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "fail");
        bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, NotificationCompat.CATEGORY_STATUS);
        bundle.putString("responseCode", String.valueOf(responseCode));
        bundle.putString("url", httpsURLConnection.getURL().toString());
        if (u() != null) {
            bundle.putInt("update", 1);
        } else {
            bundle.putInt("update", 0);
        }
        l(" (105)", bundle, j4);
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v8, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v78, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v79, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v80, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v81, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v82, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v83, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v84, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v85, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final javax.net.ssl.HttpsURLConnection G(java.lang.String r19, long r20) {
        /*
            r18 = this;
            r1 = r18
            r7 = r19
            r4 = r20
            java.lang.String r8 = "redirect"
            java.lang.String r9 = "url"
            java.lang.String r10 = "error"
            java.lang.String r11 = "fail"
            java.lang.String r12 = "type"
            java.lang.String r0 = "urlApk"
            kotlin.jvm.internal.m.e(r7, r0)
            r13 = 0
            java.net.URL r0 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x0180, IllegalStateException -> 0x017c, IllegalArgumentException -> 0x0178, SecurityException -> 0x0174, MalformedURLException -> 0x0170, ProtocolException -> 0x016c, SSLHandshakeException -> 0x0168, IOException -> 0x0164 }
            r0.<init>(r7)     // Catch:{ SocketTimeoutException -> 0x0180, IllegalStateException -> 0x017c, IllegalArgumentException -> 0x0178, SecurityException -> 0x0174, MalformedURLException -> 0x0170, ProtocolException -> 0x016c, SSLHandshakeException -> 0x0168, IOException -> 0x0164 }
            java.lang.String r2 = r0.getHost()     // Catch:{ SocketTimeoutException -> 0x0180, IllegalStateException -> 0x017c, IllegalArgumentException -> 0x0178, SecurityException -> 0x0174, MalformedURLException -> 0x0170, ProtocolException -> 0x016c, SSLHandshakeException -> 0x0168, IOException -> 0x0164 }
            r1.f19465c = r2     // Catch:{ SocketTimeoutException -> 0x0180, IllegalStateException -> 0x017c, IllegalArgumentException -> 0x0178, SecurityException -> 0x0174, MalformedURLException -> 0x0170, ProtocolException -> 0x016c, SSLHandshakeException -> 0x0168, IOException -> 0x0164 }
            javax.net.ssl.HttpsURLConnection r2 = r1.B(r0)     // Catch:{ SocketTimeoutException -> 0x0180, IllegalStateException -> 0x017c, IllegalArgumentException -> 0x0178, SecurityException -> 0x0174, MalformedURLException -> 0x0170, ProtocolException -> 0x016c, SSLHandshakeException -> 0x0168, IOException -> 0x0164 }
            r0 = 0
            r2.setInstanceFollowRedirects(r0)     // Catch:{ SocketTimeoutException -> 0x0064, IllegalStateException -> 0x0060, IllegalArgumentException -> 0x005c, SecurityException -> 0x0058, MalformedURLException -> 0x0054, ProtocolException -> 0x0050, SSLHandshakeException -> 0x004c, IOException -> 0x0048 }
            int r3 = r2.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x0064, IllegalStateException -> 0x0060, IllegalArgumentException -> 0x005c, SecurityException -> 0x0058, MalformedURLException -> 0x0054, ProtocolException -> 0x0050, SSLHandshakeException -> 0x004c, IOException -> 0x0048 }
            r14 = 300(0x12c, float:4.2E-43)
            r15 = 200(0xc8, float:2.8E-43)
            if (r3 < r15) goto L_0x0038
            if (r3 >= r14) goto L_0x0038
            r16 = 1
            goto L_0x003a
        L_0x0038:
            r16 = 0
        L_0x003a:
            if (r16 != 0) goto L_0x015e
            com.uptodown.workers.DownloadWorker$a r16 = f19459d     // Catch:{ SocketTimeoutException -> 0x0064, IllegalStateException -> 0x0060, IllegalArgumentException -> 0x005c, SecurityException -> 0x0058, MalformedURLException -> 0x0054, ProtocolException -> 0x0050, SSLHandshakeException -> 0x004c, IOException -> 0x0048 }
            boolean r16 = r16.i()     // Catch:{ SocketTimeoutException -> 0x0064, IllegalStateException -> 0x0060, IllegalArgumentException -> 0x005c, SecurityException -> 0x0058, MalformedURLException -> 0x0054, ProtocolException -> 0x0050, SSLHandshakeException -> 0x004c, IOException -> 0x0048 }
            if (r16 == 0) goto L_0x0068
            r1.j(r4)     // Catch:{ SocketTimeoutException -> 0x0064, IllegalStateException -> 0x0060, IllegalArgumentException -> 0x005c, SecurityException -> 0x0058, MalformedURLException -> 0x0054, ProtocolException -> 0x0050, SSLHandshakeException -> 0x004c, IOException -> 0x0048 }
            return r13
        L_0x0048:
            r0 = move-exception
        L_0x0049:
            r13 = r2
            goto L_0x0184
        L_0x004c:
            r0 = move-exception
        L_0x004d:
            r13 = r2
            goto L_0x018a
        L_0x0050:
            r0 = move-exception
        L_0x0051:
            r13 = r2
            goto L_0x0190
        L_0x0054:
            r0 = move-exception
        L_0x0055:
            r13 = r2
            goto L_0x0196
        L_0x0058:
            r0 = move-exception
        L_0x0059:
            r13 = r2
            goto L_0x019c
        L_0x005c:
            r0 = move-exception
        L_0x005d:
            r13 = r2
            goto L_0x01a2
        L_0x0060:
            r0 = move-exception
        L_0x0061:
            r13 = r2
            goto L_0x01a8
        L_0x0064:
            r0 = move-exception
        L_0x0065:
            r13 = r2
            goto L_0x01ae
        L_0x0068:
            java.lang.String r0 = "Location"
            java.lang.String r0 = r2.getHeaderField(r0)     // Catch:{ SocketTimeoutException -> 0x0064, IllegalStateException -> 0x0060, IllegalArgumentException -> 0x005c, SecurityException -> 0x0058, MalformedURLException -> 0x0054, ProtocolException -> 0x0050, SSLHandshakeException -> 0x004c, IOException -> 0x0048 }
            java.lang.String r6 = "responseCode"
            if (r0 == 0) goto L_0x0127
            java.net.URL r3 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0119, IllegalArgumentException -> 0x0112, SecurityException -> 0x010b, MalformedURLException -> 0x0104, ProtocolException -> 0x00fd, SSLHandshakeException -> 0x00f6, IOException -> 0x00ef }
            r3.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0119, IllegalArgumentException -> 0x0112, SecurityException -> 0x010b, MalformedURLException -> 0x0104, ProtocolException -> 0x00fd, SSLHandshakeException -> 0x00f6, IOException -> 0x00ef }
            r17 = r13
            java.lang.String r13 = r3.getHost()     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0119, IllegalArgumentException -> 0x0112, SecurityException -> 0x010b, MalformedURLException -> 0x0104, ProtocolException -> 0x00fd, SSLHandshakeException -> 0x00f6, IOException -> 0x00ef }
            r1.f19465c = r13     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0119, IllegalArgumentException -> 0x0112, SecurityException -> 0x010b, MalformedURLException -> 0x0104, ProtocolException -> 0x00fd, SSLHandshakeException -> 0x00f6, IOException -> 0x00ef }
            javax.net.ssl.HttpsURLConnection r13 = r1.B(r3)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0119, IllegalArgumentException -> 0x0112, SecurityException -> 0x010b, MalformedURLException -> 0x0104, ProtocolException -> 0x00fd, SSLHandshakeException -> 0x00f6, IOException -> 0x00ef }
            int r3 = r13.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x00e8, IllegalStateException -> 0x00e1, IllegalArgumentException -> 0x00da, SecurityException -> 0x00d3, MalformedURLException -> 0x00cc, ProtocolException -> 0x00c5, SSLHandshakeException -> 0x00be, IOException -> 0x00b7 }
            if (r3 < r15) goto L_0x0099
            r2 = 400(0x190, float:5.6E-43)
            if (r3 >= r2) goto L_0x0099
            if (r3 >= r14) goto L_0x0091
            r0 = 1
            goto L_0x0092
        L_0x0091:
            r0 = 0
        L_0x0092:
            r16 = r0
            r2 = r13
            r13 = r17
            r0 = 0
            goto L_0x003a
        L_0x0099:
            r2 = r3
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ SocketTimeoutException -> 0x00e8, IllegalStateException -> 0x00e1, IllegalArgumentException -> 0x00da, SecurityException -> 0x00d3, MalformedURLException -> 0x00cc, ProtocolException -> 0x00c5, SSLHandshakeException -> 0x00be, IOException -> 0x00b7 }
            r3.<init>()     // Catch:{ SocketTimeoutException -> 0x00e8, IllegalStateException -> 0x00e1, IllegalArgumentException -> 0x00da, SecurityException -> 0x00d3, MalformedURLException -> 0x00cc, ProtocolException -> 0x00c5, SSLHandshakeException -> 0x00be, IOException -> 0x00b7 }
            r3.putString(r12, r11)     // Catch:{ SocketTimeoutException -> 0x00e8, IllegalStateException -> 0x00e1, IllegalArgumentException -> 0x00da, SecurityException -> 0x00d3, MalformedURLException -> 0x00cc, ProtocolException -> 0x00c5, SSLHandshakeException -> 0x00be, IOException -> 0x00b7 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ SocketTimeoutException -> 0x00e8, IllegalStateException -> 0x00e1, IllegalArgumentException -> 0x00da, SecurityException -> 0x00d3, MalformedURLException -> 0x00cc, ProtocolException -> 0x00c5, SSLHandshakeException -> 0x00be, IOException -> 0x00b7 }
            r3.putString(r6, r2)     // Catch:{ SocketTimeoutException -> 0x00e8, IllegalStateException -> 0x00e1, IllegalArgumentException -> 0x00da, SecurityException -> 0x00d3, MalformedURLException -> 0x00cc, ProtocolException -> 0x00c5, SSLHandshakeException -> 0x00be, IOException -> 0x00b7 }
            r3.putString(r10, r8)     // Catch:{ SocketTimeoutException -> 0x00e8, IllegalStateException -> 0x00e1, IllegalArgumentException -> 0x00da, SecurityException -> 0x00d3, MalformedURLException -> 0x00cc, ProtocolException -> 0x00c5, SSLHandshakeException -> 0x00be, IOException -> 0x00b7 }
            r3.putString(r9, r0)     // Catch:{ SocketTimeoutException -> 0x00e8, IllegalStateException -> 0x00e1, IllegalArgumentException -> 0x00da, SecurityException -> 0x00d3, MalformedURLException -> 0x00cc, ProtocolException -> 0x00c5, SSLHandshakeException -> 0x00be, IOException -> 0x00b7 }
            java.lang.String r2 = " (107)"
            g2.s r6 = f19460e     // Catch:{ SocketTimeoutException -> 0x00e8, IllegalStateException -> 0x00e1, IllegalArgumentException -> 0x00da, SecurityException -> 0x00d3, MalformedURLException -> 0x00cc, ProtocolException -> 0x00c5, SSLHandshakeException -> 0x00be, IOException -> 0x00b7 }
            r1.F(r2, r3, r4, r6)     // Catch:{ SocketTimeoutException -> 0x00e8, IllegalStateException -> 0x00e1, IllegalArgumentException -> 0x00da, SecurityException -> 0x00d3, MalformedURLException -> 0x00cc, ProtocolException -> 0x00c5, SSLHandshakeException -> 0x00be, IOException -> 0x00b7 }
            return r17
        L_0x00b7:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x0184
        L_0x00be:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x018a
        L_0x00c5:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x0190
        L_0x00cc:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x0196
        L_0x00d3:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x019c
        L_0x00da:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x01a2
        L_0x00e1:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x01a8
        L_0x00e8:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x01ae
        L_0x00ef:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x0049
        L_0x00f6:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x004d
        L_0x00fd:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x0051
        L_0x0104:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x0055
        L_0x010b:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x0059
        L_0x0112:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x005d
        L_0x0119:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x0061
        L_0x0120:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x0065
        L_0x0127:
            r0 = r3
            r17 = r13
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0119, IllegalArgumentException -> 0x0112, SecurityException -> 0x010b, MalformedURLException -> 0x0104, ProtocolException -> 0x00fd, SSLHandshakeException -> 0x00f6, IOException -> 0x00ef }
            r3.<init>()     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0119, IllegalArgumentException -> 0x0112, SecurityException -> 0x010b, MalformedURLException -> 0x0104, ProtocolException -> 0x00fd, SSLHandshakeException -> 0x00f6, IOException -> 0x00ef }
            r3.putString(r12, r11)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0119, IllegalArgumentException -> 0x0112, SecurityException -> 0x010b, MalformedURLException -> 0x0104, ProtocolException -> 0x00fd, SSLHandshakeException -> 0x00f6, IOException -> 0x00ef }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0119, IllegalArgumentException -> 0x0112, SecurityException -> 0x010b, MalformedURLException -> 0x0104, ProtocolException -> 0x00fd, SSLHandshakeException -> 0x00f6, IOException -> 0x00ef }
            r3.putString(r6, r0)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0119, IllegalArgumentException -> 0x0112, SecurityException -> 0x010b, MalformedURLException -> 0x0104, ProtocolException -> 0x00fd, SSLHandshakeException -> 0x00f6, IOException -> 0x00ef }
            java.lang.String r0 = "location_null"
            r3.putString(r10, r0)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0119, IllegalArgumentException -> 0x0112, SecurityException -> 0x010b, MalformedURLException -> 0x0104, ProtocolException -> 0x00fd, SSLHandshakeException -> 0x00f6, IOException -> 0x00ef }
            r3.putString(r9, r7)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0119, IllegalArgumentException -> 0x0112, SecurityException -> 0x010b, MalformedURLException -> 0x0104, ProtocolException -> 0x00fd, SSLHandshakeException -> 0x00f6, IOException -> 0x00ef }
            r13 = r2
            java.lang.String r2 = " (104)"
            g2.s r6 = f19460e     // Catch:{ SocketTimeoutException -> 0x00e8, IllegalStateException -> 0x00e1, IllegalArgumentException -> 0x00da, SecurityException -> 0x00d3, MalformedURLException -> 0x00cc, ProtocolException -> 0x00c5, SSLHandshakeException -> 0x00be, IOException -> 0x00b7 }
            r1 = r18
            r4 = r20
            r1.F(r2, r3, r4, r6)     // Catch:{ SocketTimeoutException -> 0x015c, IllegalStateException -> 0x015a, IllegalArgumentException -> 0x0158, SecurityException -> 0x0156, MalformedURLException -> 0x0154, ProtocolException -> 0x0152, SSLHandshakeException -> 0x0150, IOException -> 0x014e }
            return r17
        L_0x014e:
            r0 = move-exception
            goto L_0x0184
        L_0x0150:
            r0 = move-exception
            goto L_0x018a
        L_0x0152:
            r0 = move-exception
            goto L_0x0190
        L_0x0154:
            r0 = move-exception
            goto L_0x0196
        L_0x0156:
            r0 = move-exception
            goto L_0x019c
        L_0x0158:
            r0 = move-exception
            goto L_0x01a2
        L_0x015a:
            r0 = move-exception
            goto L_0x01a8
        L_0x015c:
            r0 = move-exception
            goto L_0x01ae
        L_0x015e:
            r17 = r13
            r13 = r2
            r0 = r17
            goto L_0x01b3
        L_0x0164:
            r0 = move-exception
            r17 = r13
            goto L_0x0184
        L_0x0168:
            r0 = move-exception
            r17 = r13
            goto L_0x018a
        L_0x016c:
            r0 = move-exception
            r17 = r13
            goto L_0x0190
        L_0x0170:
            r0 = move-exception
            r17 = r13
            goto L_0x0196
        L_0x0174:
            r0 = move-exception
            r17 = r13
            goto L_0x019c
        L_0x0178:
            r0 = move-exception
            r17 = r13
            goto L_0x01a2
        L_0x017c:
            r0 = move-exception
            r17 = r13
            goto L_0x01a8
        L_0x0180:
            r0 = move-exception
            r17 = r13
            goto L_0x01ae
        L_0x0184:
            r0.printStackTrace()
            java.lang.String r0 = "IOException"
            goto L_0x01b3
        L_0x018a:
            r0.printStackTrace()
            java.lang.String r0 = "SSLHandshakeException"
            goto L_0x01b3
        L_0x0190:
            r0.printStackTrace()
            java.lang.String r0 = "ProtocolException"
            goto L_0x01b3
        L_0x0196:
            r0.printStackTrace()
            java.lang.String r0 = "MalformedURLException"
            goto L_0x01b3
        L_0x019c:
            r0.printStackTrace()
            java.lang.String r0 = "SecurityException"
            goto L_0x01b3
        L_0x01a2:
            r0.printStackTrace()
            java.lang.String r0 = "IllegalArgumentException"
            goto L_0x01b3
        L_0x01a8:
            r0.printStackTrace()
            java.lang.String r0 = "IllegalStateException"
            goto L_0x01b3
        L_0x01ae:
            r0.printStackTrace()
            java.lang.String r0 = "SocketTimeoutException"
        L_0x01b3:
            if (r0 == 0) goto L_0x01d2
            r1.E(r0, r4, r7)
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            r3.putString(r12, r11)
            r3.putString(r10, r8)
            java.lang.String r2 = "exception"
            r3.putString(r2, r0)
            r3.putString(r9, r7)
            java.lang.String r2 = " (110)"
            g2.s r6 = f19460e
            r1.F(r2, r3, r4, r6)
        L_0x01d2:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadWorker.G(java.lang.String, long):javax.net.ssl.HttpsURLConnection");
    }

    public void H(C2060s sVar) {
        m.e(sVar, "download");
    }

    public void I(C2060s sVar, int i4) {
        m.e(sVar, "download");
    }

    public final void K(String str) {
        this.f19465c = str;
    }

    public ListenableWorker.Result doWork() {
        ListenableWorker.Result failure = ListenableWorker.Result.failure();
        m.d(failure, "failure(...)");
        return failure;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle g(android.os.Bundle r8) {
        /*
            r7 = this;
            java.lang.String r0 = "bundleParams"
            kotlin.jvm.internal.m.e(r8, r0)
            com.uptodown.UptodownApp$a r0 = com.uptodown.UptodownApp.f17422D
            g2.l r1 = r0.m()
            java.lang.String r2 = "deeplink"
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x002f
            g2.s r1 = f19460e
            if (r1 == 0) goto L_0x002f
            g2.l r0 = r0.m()
            kotlin.jvm.internal.m.b(r0)
            int r0 = r0.b()
            g2.s r1 = f19460e
            kotlin.jvm.internal.m.b(r1)
            int r1 = r1.q()
            if (r0 != r1) goto L_0x002f
            r8.putInt(r2, r3)
            goto L_0x0032
        L_0x002f:
            r8.putInt(r2, r4)
        L_0x0032:
            g2.A$a r0 = g2.C2033A.f20327f
            android.content.Context r1 = r7.f19463a
            g2.A r0 = r0.b(r1)
            if (r0 == 0) goto L_0x0058
            g2.s r1 = f19460e
            java.lang.String r2 = "notification_fcm"
            if (r1 == 0) goto L_0x0055
            int r0 = r0.c()
            g2.s r1 = f19460e
            kotlin.jvm.internal.m.b(r1)
            int r1 = r1.q()
            if (r0 != r1) goto L_0x0055
            r8.putInt(r2, r3)
            goto L_0x0058
        L_0x0055:
            r8.putInt(r2, r4)
        L_0x0058:
            g2.j$a r0 = g2.C2052j.f20686n
            android.content.Context r1 = r7.f19463a
            g2.j r0 = r0.d(r1)
            java.lang.String r1 = "adView"
            if (r0 == 0) goto L_0x007a
            g2.s r2 = f19460e
            if (r2 == 0) goto L_0x007a
            int r5 = r0.m()
            int r2 = r2.q()
            if (r5 != r2) goto L_0x007a
            java.lang.String r0 = r0.s()
            r8.putString(r1, r0)
            goto L_0x0099
        L_0x007a:
            g2.x$a r0 = g2.C2065x.f20781n
            android.content.Context r2 = r7.f19463a
            g2.x r0 = r0.d(r2)
            if (r0 == 0) goto L_0x0099
            g2.s r2 = f19460e
            if (r2 == 0) goto L_0x0099
            int r5 = r0.m()
            int r2 = r2.q()
            if (r5 != r2) goto L_0x0099
            java.lang.String r0 = r0.s()
            r8.putString(r1, r0)
        L_0x0099:
            java.lang.String r0 = r7.f19465c
            if (r0 == 0) goto L_0x00a2
            java.lang.String r1 = "host"
            r8.putString(r1, r0)
        L_0x00a2:
            g2.s r0 = f19460e
            if (r0 == 0) goto L_0x010e
            kotlin.jvm.internal.m.b(r0)
            java.util.ArrayList r0 = r0.o()
            java.lang.Object r0 = r0.get(r4)
            g2.s$c r0 = (g2.C2060s.c) r0
            long r0 = r0.d()
            r5 = 0
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x00d9
            g2.s r0 = f19460e
            kotlin.jvm.internal.m.b(r0)
            java.util.ArrayList r0 = r0.o()
            java.lang.Object r0 = r0.get(r4)
            g2.s$c r0 = (g2.C2060s.c) r0
            long r0 = r0.d()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "fileId"
            r8.putString(r1, r0)
        L_0x00d9:
            g2.s r0 = f19460e
            kotlin.jvm.internal.m.b(r0)
            java.util.ArrayList r0 = r0.o()
            java.lang.Object r0 = r0.get(r4)
            g2.s$c r0 = (g2.C2060s.c) r0
            long r0 = r0.i()
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x010e
            u2.y r0 = u2.y.f21955a
            g2.s r1 = f19460e
            kotlin.jvm.internal.m.b(r1)
            java.util.ArrayList r1 = r1.o()
            java.lang.Object r1 = r1.get(r4)
            g2.s$c r1 = (g2.C2060s.c) r1
            long r1 = r1.i()
            java.lang.String r0 = r0.e(r1)
            java.lang.String r1 = "size"
            r8.putString(r1, r0)
        L_0x010e:
            g2.S r0 = r7.u()
            java.lang.String r1 = "update"
            if (r0 == 0) goto L_0x011a
            r8.putInt(r1, r3)
            goto L_0x011d
        L_0x011a:
            r8.putInt(r1, r4)
        L_0x011d:
            u2.y r0 = u2.y.f21955a
            android.os.Bundle r8 = r0.a(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadWorker.g(android.os.Bundle):android.os.Bundle");
    }

    public final Bundle h(long j4, long j5, File file, long j6, String str) {
        Bundle bundle;
        Bundle bundle2;
        String str2 = str;
        File file2 = file;
        m.e(file2, "file");
        C2060s sVar = f19460e;
        m.b(sVar);
        I(sVar, 205);
        if (file2.length() > 0) {
            long j7 = j4 + j5;
            if (j6 == 0 || (j7 == j6 && file2.length() == j7)) {
                boolean z4 = false;
                String str3 = null;
                int i4 = 0;
                while (!z4 && i4 < 3) {
                    i4++;
                    if (file2.length() == j7 && (str3 = C1610f.f8672a.e(file2.getAbsolutePath())) != null && m3.m.p(str3, str2, true)) {
                        z4 = true;
                    }
                }
                if (str3 == null) {
                    bundle2 = new Bundle();
                    bundle2.putString("type", "fail");
                    bundle2.putString("filehash", str2);
                    bundle2.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "filehash_calculated_null");
                } else if (!z4) {
                    bundle2 = new Bundle();
                    bundle2.putString("type", "fail");
                    bundle2.putString("filehash", str2);
                    bundle2.putString("filehashCalculated", str3);
                    bundle2.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "filehash_not_match");
                } else {
                    bundle = null;
                }
                bundle = bundle2;
            } else {
                bundle = new Bundle();
                bundle.putString("type", "fail");
                bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "size_not_match");
            }
        } else {
            bundle = new Bundle();
            bundle.putString("type", "fail");
            bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "size_zero");
        }
        C2060s sVar2 = f19460e;
        m.b(sVar2);
        I(sVar2, 206);
        return bundle;
    }

    public final void j(long j4) {
        C2060s sVar = f19460e;
        if (sVar != null) {
            m.b(sVar);
            sVar.S(this.f19463a);
            t a5 = t.f21927u.a(this.f19463a);
            a5.a();
            C2060s sVar2 = f19460e;
            m.b(sVar2);
            if (sVar2.N()) {
                a5.z(f19460e);
            } else {
                C2060s sVar3 = f19460e;
                m.b(sVar3);
                Iterator it = sVar3.o().iterator();
                m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    C2060s.c cVar = (C2060s.c) next;
                    cVar.p(0);
                    cVar.l(0);
                    a5.x1(cVar);
                }
            }
            a5.i();
            if (f19462g) {
                f19459d.o();
            }
            C2313C.f21882a.e(this.f19463a);
            Bundle bundle = new Bundle();
            bundle.putString("type", "cancelled");
            if (j4 > 0) {
                bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j4) / ((long) 1000));
            }
            w(bundle, (String) null);
            C2060s sVar4 = f19460e;
            m.b(sVar4);
            I(sVar4, 207);
        }
    }

    public void l(String str, Bundle bundle, long j4) {
        m.e(str, "errorCode");
        m.e(bundle, "bundle");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: u2.t} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: u2.t} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: u2.t} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: u2.t} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: u2.t} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: u2.t} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v22, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: u2.t} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: u2.t} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v27, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: u2.t} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r37v0, types: [int] */
    /* JADX WARNING: type inference failed for: r37v1 */
    /* JADX WARNING: type inference failed for: r6v15 */
    /* JADX WARNING: type inference failed for: r6v20 */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0343, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0349, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x034f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0355, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0356, code lost:
        r32 = r6;
        r8 = r8;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x038d, code lost:
        java.lang.Thread.sleep(20000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0398, code lost:
        if (f19459d.i() != false) goto L_0x039a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x039a, code lost:
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x039c, code lost:
        r7 = u2.z.f21956a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x03a2, code lost:
        if (r7.d() != false) goto L_0x03a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x03ac, code lost:
        if (com.uptodown.activities.preferences.a.f18818a.Z(r1.f19463a) == false) goto L_0x03e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x03b9, code lost:
        if (r2.l() == 1) goto L_0x03bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x03bc, code lost:
        i(r15, r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x03c4, code lost:
        throw new java.io.IOException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x03c5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x03cb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x03d1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x03d7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x03dd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x03e4, code lost:
        r6 = r13.getURL();
        r8 = r25;
        kotlin.jvm.internal.m.d(r6, r8);
        r6 = B(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x03f1, code lost:
        r25 = r8;
        r7 = r43 + r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x03f7, code lost:
        if (r7 > 0) goto L_0x03f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:?, code lost:
        r13 = new java.lang.StringBuilder();
        r38 = r9;
        r9 = r28;
        r13.append(r9);
        r13.append(r7);
        r13.append('-');
        r6.setRequestProperty(r11, r13.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x0415, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x0416, code lost:
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0418, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x0419, code lost:
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x041b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x041c, code lost:
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x041e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x041f, code lost:
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x0421, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x0422, code lost:
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x0425, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x0426, code lost:
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x0429, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x042a, code lost:
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x042d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x042e, code lost:
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0430, code lost:
        r38 = r9;
        r9 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x0436, code lost:
        r6.connect();
        r8 = r6.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x043f, code lost:
        if (r8 < 200) goto L_0x056e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x0445, code lost:
        r15 = r6.getInputStream();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0449, code lost:
        if (r15 != null) goto L_0x044b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x044b, code lost:
        r4.d();
        r10 = 0;
        r0 = r15.read(r14, 0, 8192);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x0455, code lost:
        r13 = r6;
        r5 = r5;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x0456, code lost:
        if (r0 <= 0) goto L_0x0458;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:?, code lost:
        i((java.io.InputStream) null, r12, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x056d, code lost:
        throw new java.io.IOException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x056e, code lost:
        i(r15, r12, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x0576, code lost:
        throw new java.io.IOException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:?, code lost:
        i(r15, r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x057f, code lost:
        throw new java.io.IOException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x0580, code lost:
        i(r15, r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x0588, code lost:
        throw new java.io.IOException(r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x021d A[SYNTHETIC, Splitter:B:140:0x021d] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x031e A[LOOP:0: B:222:0x031e->B:472:0x031e, LOOP_START, SYNTHETIC, Splitter:B:222:0x031e] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x0343 A[Catch:{ IOException -> 0x0355, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343 }, ExcHandler: SecurityException (e java.lang.SecurityException), PHI: r13 r15 r29 
      PHI: (r13v95 javax.net.ssl.HttpsURLConnection) = (r13v50 javax.net.ssl.HttpsURLConnection), (r13v60 javax.net.ssl.HttpsURLConnection), (r13v80 javax.net.ssl.HttpsURLConnection), (r13v80 javax.net.ssl.HttpsURLConnection), (r13v96 javax.net.ssl.HttpsURLConnection), (r13v96 javax.net.ssl.HttpsURLConnection) binds: [B:217:0x0306, B:315:0x0479, B:248:0x037c, B:374:0x0577, B:222:0x031e, B:242:0x0363] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r15v32 java.io.InputStream) = (r15v2 java.io.InputStream), (r15v12 java.io.InputStream), (r15v19 java.io.InputStream), (r15v19 java.io.InputStream), (r15v33 java.io.InputStream), (r15v33 java.io.InputStream) binds: [B:217:0x0306, B:315:0x0479, B:248:0x037c, B:374:0x0577, B:222:0x031e, B:242:0x0363] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r29v40 long) = (r29v18 long), (r29v29 long), (r29v36 long), (r29v36 long), (r29v41 long), (r29v41 long) binds: [B:217:0x0306, B:315:0x0479, B:248:0x037c, B:374:0x0577, B:222:0x031e, B:242:0x0363] A[DONT_GENERATE, DONT_INLINE], Splitter:B:217:0x0306] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x0349 A[Catch:{ IOException -> 0x0355, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343 }, ExcHandler: IllegalArgumentException (e java.lang.IllegalArgumentException), PHI: r13 r15 r29 
      PHI: (r13v94 javax.net.ssl.HttpsURLConnection) = (r13v50 javax.net.ssl.HttpsURLConnection), (r13v60 javax.net.ssl.HttpsURLConnection), (r13v80 javax.net.ssl.HttpsURLConnection), (r13v80 javax.net.ssl.HttpsURLConnection), (r13v96 javax.net.ssl.HttpsURLConnection), (r13v96 javax.net.ssl.HttpsURLConnection) binds: [B:217:0x0306, B:315:0x0479, B:248:0x037c, B:374:0x0577, B:222:0x031e, B:242:0x0363] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r15v31 java.io.InputStream) = (r15v2 java.io.InputStream), (r15v12 java.io.InputStream), (r15v19 java.io.InputStream), (r15v19 java.io.InputStream), (r15v33 java.io.InputStream), (r15v33 java.io.InputStream) binds: [B:217:0x0306, B:315:0x0479, B:248:0x037c, B:374:0x0577, B:222:0x031e, B:242:0x0363] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r29v39 long) = (r29v18 long), (r29v29 long), (r29v36 long), (r29v36 long), (r29v41 long), (r29v41 long) binds: [B:217:0x0306, B:315:0x0479, B:248:0x037c, B:374:0x0577, B:222:0x031e, B:242:0x0363] A[DONT_GENERATE, DONT_INLINE], Splitter:B:217:0x0306] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x034f A[Catch:{ IOException -> 0x0355, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343 }, ExcHandler: IllegalStateException (e java.lang.IllegalStateException), PHI: r13 r15 r29 
      PHI: (r13v93 javax.net.ssl.HttpsURLConnection) = (r13v50 javax.net.ssl.HttpsURLConnection), (r13v60 javax.net.ssl.HttpsURLConnection), (r13v80 javax.net.ssl.HttpsURLConnection), (r13v80 javax.net.ssl.HttpsURLConnection), (r13v96 javax.net.ssl.HttpsURLConnection), (r13v96 javax.net.ssl.HttpsURLConnection) binds: [B:217:0x0306, B:315:0x0479, B:248:0x037c, B:374:0x0577, B:222:0x031e, B:242:0x0363] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r15v30 java.io.InputStream) = (r15v2 java.io.InputStream), (r15v12 java.io.InputStream), (r15v19 java.io.InputStream), (r15v19 java.io.InputStream), (r15v33 java.io.InputStream), (r15v33 java.io.InputStream) binds: [B:217:0x0306, B:315:0x0479, B:248:0x037c, B:374:0x0577, B:222:0x031e, B:242:0x0363] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r29v38 long) = (r29v18 long), (r29v29 long), (r29v36 long), (r29v36 long), (r29v41 long), (r29v41 long) binds: [B:217:0x0306, B:315:0x0479, B:248:0x037c, B:374:0x0577, B:222:0x031e, B:242:0x0363] A[DONT_GENERATE, DONT_INLINE], Splitter:B:217:0x0306] */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x038d A[Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x04b6 A[SYNTHETIC, Splitter:B:324:0x04b6] */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x0506  */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x0580 A[Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x0594 A[Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x05ac A[Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:470:0x072e  */
    /* JADX WARNING: Removed duplicated region for block: B:471:0x0748  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long m(javax.net.ssl.HttpsURLConnection r43, java.io.File r44, g2.C2060s r45, g2.C2060s.c r46, java.lang.String r47, long r48, com.uptodown.workers.DownloadWorker.b r50) {
        /*
            r42 = this;
            r1 = r42
            r0 = r44
            r2 = r45
            r3 = r46
            r5 = r47
            r6 = r48
            r4 = r50
            java.lang.String r8 = "toString(...)"
            java.lang.String r9 = "type"
            java.lang.String r10 = "urlConnectionParam"
            r11 = r43
            kotlin.jvm.internal.m.e(r11, r10)
            java.lang.String r10 = "file"
            kotlin.jvm.internal.m.e(r0, r10)
            java.lang.String r10 = "download"
            kotlin.jvm.internal.m.e(r2, r10)
            java.lang.String r10 = "downloadFile"
            kotlin.jvm.internal.m.e(r3, r10)
            java.lang.String r10 = "host"
            kotlin.jvm.internal.m.e(r5, r10)
            java.lang.String r10 = "downloadListener"
            kotlin.jvm.internal.m.e(r4, r10)
            long r12 = r3.i()
            java.lang.String r10 = r0.getAbsolutePath()
            r3.k(r10)
            r16 = -1
            r14 = 0
            boolean r18 = r0.exists()     // Catch:{ SocketTimeoutException -> 0x06ed, IllegalStateException -> 0x06e2, IllegalArgumentException -> 0x06d7, SecurityException -> 0x06cc, MalformedURLException -> 0x06c1, ProtocolException -> 0x06b5, SSLHandshakeException -> 0x06a9, IOException -> 0x069d }
            if (r18 != 0) goto L_0x0093
            java.io.File r18 = r0.getParentFile()     // Catch:{ SocketTimeoutException -> 0x008b, IllegalStateException -> 0x0083, IllegalArgumentException -> 0x007b, SecurityException -> 0x0073, MalformedURLException -> 0x006b, ProtocolException -> 0x0063, SSLHandshakeException -> 0x005b, IOException -> 0x0053 }
            if (r18 == 0) goto L_0x0050
            r18.mkdirs()     // Catch:{ SocketTimeoutException -> 0x008b, IllegalStateException -> 0x0083, IllegalArgumentException -> 0x007b, SecurityException -> 0x0073, MalformedURLException -> 0x006b, ProtocolException -> 0x0063, SSLHandshakeException -> 0x005b, IOException -> 0x0053 }
        L_0x0050:
            r18 = r14
            goto L_0x00a6
        L_0x0053:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x0057:
            r10 = 0
            r12 = 0
            goto L_0x06f8
        L_0x005b:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x005f:
            r10 = 0
            r12 = 0
            goto L_0x0702
        L_0x0063:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x0067:
            r10 = 0
            r12 = 0
            goto L_0x0708
        L_0x006b:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x006f:
            r10 = 0
            r12 = 0
            goto L_0x070e
        L_0x0073:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x0077:
            r10 = 0
            r12 = 0
            goto L_0x0714
        L_0x007b:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x007f:
            r10 = 0
            r12 = 0
            goto L_0x071a
        L_0x0083:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x0087:
            r10 = 0
            r12 = 0
            goto L_0x0720
        L_0x008b:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x008f:
            r10 = 0
            r12 = 0
            goto L_0x0726
        L_0x0093:
            long r18 = r0.length()     // Catch:{ SocketTimeoutException -> 0x06ed, IllegalStateException -> 0x06e2, IllegalArgumentException -> 0x06d7, SecurityException -> 0x06cc, MalformedURLException -> 0x06c1, ProtocolException -> 0x06b5, SSLHandshakeException -> 0x06a9, IOException -> 0x069d }
            long r20 = r3.h()     // Catch:{ SocketTimeoutException -> 0x06ed, IllegalStateException -> 0x06e2, IllegalArgumentException -> 0x06d7, SecurityException -> 0x06cc, MalformedURLException -> 0x06c1, ProtocolException -> 0x06b5, SSLHandshakeException -> 0x06a9, IOException -> 0x069d }
            int r22 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r22 == 0) goto L_0x0050
            r0.delete()     // Catch:{ SocketTimeoutException -> 0x008b, IllegalStateException -> 0x0083, IllegalArgumentException -> 0x007b, SecurityException -> 0x0073, MalformedURLException -> 0x006b, ProtocolException -> 0x0063, SSLHandshakeException -> 0x005b, IOException -> 0x0053 }
            r3.p(r14)     // Catch:{ SocketTimeoutException -> 0x008b, IllegalStateException -> 0x0083, IllegalArgumentException -> 0x007b, SecurityException -> 0x0073, MalformedURLException -> 0x006b, ProtocolException -> 0x0063, SSLHandshakeException -> 0x005b, IOException -> 0x0053 }
            goto L_0x0050
        L_0x00a6:
            long r14 = r0.length()     // Catch:{ SocketTimeoutException -> 0x0693, IllegalStateException -> 0x0689, IllegalArgumentException -> 0x067f, SecurityException -> 0x0675, MalformedURLException -> 0x066b, ProtocolException -> 0x0661, SSLHandshakeException -> 0x0657, IOException -> 0x064d }
            int r20 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r20 > 0) goto L_0x00eb
            long r12 = r42.o(r43)     // Catch:{ SocketTimeoutException -> 0x00e4, IllegalStateException -> 0x00dd, IllegalArgumentException -> 0x00d6, SecurityException -> 0x00cf, MalformedURLException -> 0x00c8, ProtocolException -> 0x00c1, SSLHandshakeException -> 0x00ba, IOException -> 0x00b3 }
            goto L_0x00eb
        L_0x00b3:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x00b7:
            r14 = r18
            goto L_0x0057
        L_0x00ba:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x00be:
            r14 = r18
            goto L_0x005f
        L_0x00c1:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x00c5:
            r14 = r18
            goto L_0x0067
        L_0x00c8:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x00cc:
            r14 = r18
            goto L_0x006f
        L_0x00cf:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x00d3:
            r14 = r18
            goto L_0x0077
        L_0x00d6:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x00da:
            r14 = r18
            goto L_0x007f
        L_0x00dd:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x00e1:
            r14 = r18
            goto L_0x0087
        L_0x00e4:
            r0 = move-exception
            r31 = r8
            r13 = r11
        L_0x00e8:
            r14 = r18
            goto L_0x008f
        L_0x00eb:
            java.lang.String r10 = "bytes="
            java.lang.String r11 = "Range"
            r22 = r12
            java.lang.String r12 = "getURL(...)"
            int r24 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r24 <= 0) goto L_0x01ee
            int r24 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r24 >= 0) goto L_0x01b5
            java.net.URL r13 = r43.getURL()     // Catch:{ SocketTimeoutException -> 0x01b1, IllegalStateException -> 0x01ad, IllegalArgumentException -> 0x01a9, SecurityException -> 0x01a5, MalformedURLException -> 0x01a1, ProtocolException -> 0x019d, SSLHandshakeException -> 0x0199, IOException -> 0x0195 }
            kotlin.jvm.internal.m.d(r13, r12)     // Catch:{ SocketTimeoutException -> 0x01b1, IllegalStateException -> 0x01ad, IllegalArgumentException -> 0x01a9, SecurityException -> 0x01a5, MalformedURLException -> 0x01a1, ProtocolException -> 0x019d, SSLHandshakeException -> 0x0199, IOException -> 0x0195 }
            javax.net.ssl.HttpsURLConnection r13 = r1.B(r13)     // Catch:{ SocketTimeoutException -> 0x01b1, IllegalStateException -> 0x01ad, IllegalArgumentException -> 0x01a9, SecurityException -> 0x01a5, MalformedURLException -> 0x01a1, ProtocolException -> 0x019d, SSLHandshakeException -> 0x0199, IOException -> 0x0195 }
            r25 = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0190, IllegalStateException -> 0x018b, IllegalArgumentException -> 0x0186, SecurityException -> 0x0181, MalformedURLException -> 0x017c, ProtocolException -> 0x0177, SSLHandshakeException -> 0x0172, IOException -> 0x016d }
            r12.<init>()     // Catch:{ SocketTimeoutException -> 0x0190, IllegalStateException -> 0x018b, IllegalArgumentException -> 0x0186, SecurityException -> 0x0181, MalformedURLException -> 0x017c, ProtocolException -> 0x0177, SSLHandshakeException -> 0x0172, IOException -> 0x016d }
            r12.append(r10)     // Catch:{ SocketTimeoutException -> 0x0190, IllegalStateException -> 0x018b, IllegalArgumentException -> 0x0186, SecurityException -> 0x0181, MalformedURLException -> 0x017c, ProtocolException -> 0x0177, SSLHandshakeException -> 0x0172, IOException -> 0x016d }
            r12.append(r14)     // Catch:{ SocketTimeoutException -> 0x0190, IllegalStateException -> 0x018b, IllegalArgumentException -> 0x0186, SecurityException -> 0x0181, MalformedURLException -> 0x017c, ProtocolException -> 0x0177, SSLHandshakeException -> 0x0172, IOException -> 0x016d }
            r26 = r14
            r14 = 45
            r12.append(r14)     // Catch:{ SocketTimeoutException -> 0x0190, IllegalStateException -> 0x018b, IllegalArgumentException -> 0x0186, SecurityException -> 0x0181, MalformedURLException -> 0x017c, ProtocolException -> 0x0177, SSLHandshakeException -> 0x0172, IOException -> 0x016d }
            java.lang.String r12 = r12.toString()     // Catch:{ SocketTimeoutException -> 0x0190, IllegalStateException -> 0x018b, IllegalArgumentException -> 0x0186, SecurityException -> 0x0181, MalformedURLException -> 0x017c, ProtocolException -> 0x0177, SSLHandshakeException -> 0x0172, IOException -> 0x016d }
            r13.setRequestProperty(r11, r12)     // Catch:{ SocketTimeoutException -> 0x0190, IllegalStateException -> 0x018b, IllegalArgumentException -> 0x0186, SecurityException -> 0x0181, MalformedURLException -> 0x017c, ProtocolException -> 0x0177, SSLHandshakeException -> 0x0172, IOException -> 0x016d }
            java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ SocketTimeoutException -> 0x0190, IllegalStateException -> 0x018b, IllegalArgumentException -> 0x0186, SecurityException -> 0x0181, MalformedURLException -> 0x017c, ProtocolException -> 0x0177, SSLHandshakeException -> 0x0172, IOException -> 0x016d }
            r14 = 1
            r12.<init>(r0, r14)     // Catch:{ SocketTimeoutException -> 0x0190, IllegalStateException -> 0x018b, IllegalArgumentException -> 0x0186, SecurityException -> 0x0181, MalformedURLException -> 0x017c, ProtocolException -> 0x0177, SSLHandshakeException -> 0x0172, IOException -> 0x016d }
            java.lang.String r0 = "resume"
        L_0x0129:
            r43 = r26
            goto L_0x01fd
        L_0x012d:
            r0 = move-exception
        L_0x012e:
            r31 = r8
            r14 = r18
            r10 = 0
            goto L_0x06f8
        L_0x0135:
            r0 = move-exception
        L_0x0136:
            r31 = r8
            r14 = r18
            r10 = 0
            goto L_0x0702
        L_0x013d:
            r0 = move-exception
        L_0x013e:
            r31 = r8
            r14 = r18
            r10 = 0
            goto L_0x0708
        L_0x0145:
            r0 = move-exception
        L_0x0146:
            r31 = r8
            r14 = r18
            r10 = 0
            goto L_0x070e
        L_0x014d:
            r0 = move-exception
        L_0x014e:
            r31 = r8
            r14 = r18
            r10 = 0
            goto L_0x0714
        L_0x0155:
            r0 = move-exception
        L_0x0156:
            r31 = r8
            r14 = r18
            r10 = 0
            goto L_0x071a
        L_0x015d:
            r0 = move-exception
        L_0x015e:
            r31 = r8
            r14 = r18
            r10 = 0
            goto L_0x0720
        L_0x0165:
            r0 = move-exception
        L_0x0166:
            r31 = r8
            r14 = r18
            r10 = 0
            goto L_0x0726
        L_0x016d:
            r0 = move-exception
        L_0x016e:
            r31 = r8
            goto L_0x00b7
        L_0x0172:
            r0 = move-exception
        L_0x0173:
            r31 = r8
            goto L_0x00be
        L_0x0177:
            r0 = move-exception
        L_0x0178:
            r31 = r8
            goto L_0x00c5
        L_0x017c:
            r0 = move-exception
        L_0x017d:
            r31 = r8
            goto L_0x00cc
        L_0x0181:
            r0 = move-exception
        L_0x0182:
            r31 = r8
            goto L_0x00d3
        L_0x0186:
            r0 = move-exception
        L_0x0187:
            r31 = r8
            goto L_0x00da
        L_0x018b:
            r0 = move-exception
        L_0x018c:
            r31 = r8
            goto L_0x00e1
        L_0x0190:
            r0 = move-exception
        L_0x0191:
            r31 = r8
            goto L_0x00e8
        L_0x0195:
            r0 = move-exception
            r13 = r43
            goto L_0x016e
        L_0x0199:
            r0 = move-exception
            r13 = r43
            goto L_0x0173
        L_0x019d:
            r0 = move-exception
            r13 = r43
            goto L_0x0178
        L_0x01a1:
            r0 = move-exception
            r13 = r43
            goto L_0x017d
        L_0x01a5:
            r0 = move-exception
            r13 = r43
            goto L_0x0182
        L_0x01a9:
            r0 = move-exception
            r13 = r43
            goto L_0x0187
        L_0x01ad:
            r0 = move-exception
            r13 = r43
            goto L_0x018c
        L_0x01b1:
            r0 = move-exception
            r13 = r43
            goto L_0x0191
        L_0x01b5:
            r25 = r12
            r0.delete()     // Catch:{ SocketTimeoutException -> 0x01b1, IllegalStateException -> 0x01ad, IllegalArgumentException -> 0x01a9, SecurityException -> 0x01a5, MalformedURLException -> 0x01a1, ProtocolException -> 0x019d, SSLHandshakeException -> 0x0199, IOException -> 0x0195 }
            java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ SocketTimeoutException -> 0x01b1, IllegalStateException -> 0x01ad, IllegalArgumentException -> 0x01a9, SecurityException -> 0x01a5, MalformedURLException -> 0x01a1, ProtocolException -> 0x019d, SSLHandshakeException -> 0x0199, IOException -> 0x0195 }
            r12.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x01b1, IllegalStateException -> 0x01ad, IllegalArgumentException -> 0x01a9, SecurityException -> 0x01a5, MalformedURLException -> 0x01a1, ProtocolException -> 0x019d, SSLHandshakeException -> 0x0199, IOException -> 0x0195 }
            java.lang.String r0 = "reset"
            r13 = r43
            r43 = r18
            goto L_0x01fd
        L_0x01c6:
            r0 = move-exception
            r13 = r43
            goto L_0x012e
        L_0x01cb:
            r0 = move-exception
            r13 = r43
            goto L_0x0136
        L_0x01d0:
            r0 = move-exception
            r13 = r43
            goto L_0x013e
        L_0x01d5:
            r0 = move-exception
            r13 = r43
            goto L_0x0146
        L_0x01da:
            r0 = move-exception
            r13 = r43
            goto L_0x014e
        L_0x01df:
            r0 = move-exception
            r13 = r43
            goto L_0x0156
        L_0x01e4:
            r0 = move-exception
            r13 = r43
            goto L_0x015e
        L_0x01e9:
            r0 = move-exception
            r13 = r43
            goto L_0x0166
        L_0x01ee:
            r25 = r12
            r26 = r14
            java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ SocketTimeoutException -> 0x0693, IllegalStateException -> 0x0689, IllegalArgumentException -> 0x067f, SecurityException -> 0x0675, MalformedURLException -> 0x066b, ProtocolException -> 0x0661, SSLHandshakeException -> 0x0657, IOException -> 0x064d }
            r12.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x0693, IllegalStateException -> 0x0689, IllegalArgumentException -> 0x067f, SecurityException -> 0x0675, MalformedURLException -> 0x066b, ProtocolException -> 0x0661, SSLHandshakeException -> 0x0657, IOException -> 0x064d }
            java.lang.String r0 = "new"
            r13 = r43
            goto L_0x0129
        L_0x01fd:
            android.os.Bundle r14 = new android.os.Bundle     // Catch:{ SocketTimeoutException -> 0x060e, IllegalStateException -> 0x0607, IllegalArgumentException -> 0x0600, SecurityException -> 0x05f9, MalformedURLException -> 0x05f2, ProtocolException -> 0x05eb, SSLHandshakeException -> 0x05e4, IOException -> 0x05dd }
            r14.<init>()     // Catch:{ SocketTimeoutException -> 0x060e, IllegalStateException -> 0x0607, IllegalArgumentException -> 0x0600, SecurityException -> 0x05f9, MalformedURLException -> 0x05f2, ProtocolException -> 0x05eb, SSLHandshakeException -> 0x05e4, IOException -> 0x05dd }
            r14.putString(r9, r0)     // Catch:{ SocketTimeoutException -> 0x060e, IllegalStateException -> 0x0607, IllegalArgumentException -> 0x0600, SecurityException -> 0x05f9, MalformedURLException -> 0x05f2, ProtocolException -> 0x05eb, SSLHandshakeException -> 0x05e4, IOException -> 0x05dd }
            r1.w(r14, r5)     // Catch:{ SocketTimeoutException -> 0x060e, IllegalStateException -> 0x0607, IllegalArgumentException -> 0x0600, SecurityException -> 0x05f9, MalformedURLException -> 0x05f2, ProtocolException -> 0x05eb, SSLHandshakeException -> 0x05e4, IOException -> 0x05dd }
            long r14 = r1.o(r13)     // Catch:{ SocketTimeoutException -> 0x060e, IllegalStateException -> 0x0607, IllegalArgumentException -> 0x0600, SecurityException -> 0x05f9, MalformedURLException -> 0x05f2, ProtocolException -> 0x05eb, SSLHandshakeException -> 0x05e4, IOException -> 0x05dd }
            java.net.URL r0 = r13.getURL()     // Catch:{ SocketTimeoutException -> 0x060e, IllegalStateException -> 0x0607, IllegalArgumentException -> 0x0600, SecurityException -> 0x05f9, MalformedURLException -> 0x05f2, ProtocolException -> 0x05eb, SSLHandshakeException -> 0x05e4, IOException -> 0x05dd }
            java.lang.String r0 = r0.toString()     // Catch:{ SocketTimeoutException -> 0x060e, IllegalStateException -> 0x0607, IllegalArgumentException -> 0x0600, SecurityException -> 0x05f9, MalformedURLException -> 0x05f2, ProtocolException -> 0x05eb, SSLHandshakeException -> 0x05e4, IOException -> 0x05dd }
            kotlin.jvm.internal.m.d(r0, r8)     // Catch:{ SocketTimeoutException -> 0x060e, IllegalStateException -> 0x0607, IllegalArgumentException -> 0x0600, SecurityException -> 0x05f9, MalformedURLException -> 0x05f2, ProtocolException -> 0x05eb, SSLHandshakeException -> 0x05e4, IOException -> 0x05dd }
            long r14 = r43 + r14
            int r26 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r26 == 0) goto L_0x023d
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ SocketTimeoutException -> 0x0165, IllegalStateException -> 0x015d, IllegalArgumentException -> 0x0155, SecurityException -> 0x014d, MalformedURLException -> 0x0145, ProtocolException -> 0x013d, SSLHandshakeException -> 0x0135, IOException -> 0x012d }
            r4.<init>()     // Catch:{ SocketTimeoutException -> 0x0165, IllegalStateException -> 0x015d, IllegalArgumentException -> 0x0155, SecurityException -> 0x014d, MalformedURLException -> 0x0145, ProtocolException -> 0x013d, SSLHandshakeException -> 0x0135, IOException -> 0x012d }
            java.lang.String r10 = "fail"
            r4.putString(r9, r10)     // Catch:{ SocketTimeoutException -> 0x0165, IllegalStateException -> 0x015d, IllegalArgumentException -> 0x0155, SecurityException -> 0x014d, MalformedURLException -> 0x0145, ProtocolException -> 0x013d, SSLHandshakeException -> 0x0135, IOException -> 0x012d }
            java.lang.String r9 = "error"
            java.lang.String r10 = "content_length_not_match"
            r4.putString(r9, r10)     // Catch:{ SocketTimeoutException -> 0x0165, IllegalStateException -> 0x015d, IllegalArgumentException -> 0x0155, SecurityException -> 0x014d, MalformedURLException -> 0x0145, ProtocolException -> 0x013d, SSLHandshakeException -> 0x0135, IOException -> 0x012d }
            java.lang.String r9 = "url"
            r4.putString(r9, r0)     // Catch:{ SocketTimeoutException -> 0x0165, IllegalStateException -> 0x015d, IllegalArgumentException -> 0x0155, SecurityException -> 0x014d, MalformedURLException -> 0x0145, ProtocolException -> 0x013d, SSLHandshakeException -> 0x0135, IOException -> 0x012d }
            java.lang.String r0 = " (105)"
            r1.l(r0, r4, r6)     // Catch:{ SocketTimeoutException -> 0x0165, IllegalStateException -> 0x015d, IllegalArgumentException -> 0x0155, SecurityException -> 0x014d, MalformedURLException -> 0x0145, ProtocolException -> 0x013d, SSLHandshakeException -> 0x0135, IOException -> 0x012d }
            r4 = 0
            r1.i(r4, r4, r13)     // Catch:{ SocketTimeoutException -> 0x0165, IllegalStateException -> 0x015d, IllegalArgumentException -> 0x0155, SecurityException -> 0x014d, MalformedURLException -> 0x0145, ProtocolException -> 0x013d, SSLHandshakeException -> 0x0135, IOException -> 0x012d }
            return r16
        L_0x023d:
            r9 = 8192(0x2000, float:1.14794E-41)
            byte[] r14 = new byte[r9]     // Catch:{ SocketTimeoutException -> 0x060e, IllegalStateException -> 0x0607, IllegalArgumentException -> 0x0600, SecurityException -> 0x05f9, MalformedURLException -> 0x05f2, ProtocolException -> 0x05eb, SSLHandshakeException -> 0x05e4, IOException -> 0x05dd }
            long r26 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x060e, IllegalStateException -> 0x0607, IllegalArgumentException -> 0x0600, SecurityException -> 0x05f9, MalformedURLException -> 0x05f2, ProtocolException -> 0x05eb, SSLHandshakeException -> 0x05e4, IOException -> 0x05dd }
            java.io.InputStream r15 = r13.getInputStream()     // Catch:{ SocketTimeoutException -> 0x060e, IllegalStateException -> 0x0607, IllegalArgumentException -> 0x0600, SecurityException -> 0x05f9, MalformedURLException -> 0x05f2, ProtocolException -> 0x05eb, SSLHandshakeException -> 0x05e4, IOException -> 0x05dd }
            r5 = 0
            int r0 = r15.read(r14, r5, r9)     // Catch:{ SocketTimeoutException -> 0x02ed, IllegalStateException -> 0x02e5, IllegalArgumentException -> 0x02dd, SecurityException -> 0x02d5, MalformedURLException -> 0x02cd, ProtocolException -> 0x02c5, SSLHandshakeException -> 0x02bd, IOException -> 0x02b5 }
            if (r0 <= 0) goto L_0x02f5
            r28 = r10
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x02ed, IllegalStateException -> 0x02e5, IllegalArgumentException -> 0x02dd, SecurityException -> 0x02d5, MalformedURLException -> 0x02cd, ProtocolException -> 0x02c5, SSLHandshakeException -> 0x02bd, IOException -> 0x02b5 }
            r4.c(r9)     // Catch:{ SocketTimeoutException -> 0x02ed, IllegalStateException -> 0x02e5, IllegalArgumentException -> 0x02dd, SecurityException -> 0x02d5, MalformedURLException -> 0x02cd, ProtocolException -> 0x02c5, SSLHandshakeException -> 0x02bd, IOException -> 0x02b5 }
            r1.n()     // Catch:{ SocketTimeoutException -> 0x02ed, IllegalStateException -> 0x02e5, IllegalArgumentException -> 0x02dd, SecurityException -> 0x02d5, MalformedURLException -> 0x02cd, ProtocolException -> 0x02c5, SSLHandshakeException -> 0x02bd, IOException -> 0x02b5 }
            r12.write(r14, r5, r0)     // Catch:{ SocketTimeoutException -> 0x02ed, IllegalStateException -> 0x02e5, IllegalArgumentException -> 0x02dd, SecurityException -> 0x02d5, MalformedURLException -> 0x02cd, ProtocolException -> 0x02c5, SSLHandshakeException -> 0x02bd, IOException -> 0x02b5 }
            long r5 = (long) r0
            long r29 = r3.h()     // Catch:{ SocketTimeoutException -> 0x02b1, IllegalStateException -> 0x02ad, IllegalArgumentException -> 0x02a9, SecurityException -> 0x02a5, MalformedURLException -> 0x02a1, ProtocolException -> 0x029d, SSLHandshakeException -> 0x0299, IOException -> 0x0295 }
            r31 = r8
            long r7 = r29 + r5
            r3.p(r7)     // Catch:{ SocketTimeoutException -> 0x0290, IllegalStateException -> 0x028b, IllegalArgumentException -> 0x0286, SecurityException -> 0x0281, MalformedURLException -> 0x027c, ProtocolException -> 0x0277, SSLHandshakeException -> 0x0272, IOException -> 0x026d }
            goto L_0x02fc
        L_0x026d:
            r0 = move-exception
        L_0x026e:
            r10 = r15
            r14 = r5
            goto L_0x06f8
        L_0x0272:
            r0 = move-exception
        L_0x0273:
            r10 = r15
            r14 = r5
            goto L_0x0702
        L_0x0277:
            r0 = move-exception
        L_0x0278:
            r10 = r15
            r14 = r5
            goto L_0x0708
        L_0x027c:
            r0 = move-exception
        L_0x027d:
            r10 = r15
            r14 = r5
            goto L_0x070e
        L_0x0281:
            r0 = move-exception
        L_0x0282:
            r10 = r15
            r14 = r5
            goto L_0x0714
        L_0x0286:
            r0 = move-exception
        L_0x0287:
            r10 = r15
            r14 = r5
            goto L_0x071a
        L_0x028b:
            r0 = move-exception
        L_0x028c:
            r10 = r15
            r14 = r5
            goto L_0x0720
        L_0x0290:
            r0 = move-exception
        L_0x0291:
            r10 = r15
            r14 = r5
            goto L_0x0726
        L_0x0295:
            r0 = move-exception
            r31 = r8
            goto L_0x026e
        L_0x0299:
            r0 = move-exception
            r31 = r8
            goto L_0x0273
        L_0x029d:
            r0 = move-exception
            r31 = r8
            goto L_0x0278
        L_0x02a1:
            r0 = move-exception
            r31 = r8
            goto L_0x027d
        L_0x02a5:
            r0 = move-exception
            r31 = r8
            goto L_0x0282
        L_0x02a9:
            r0 = move-exception
            r31 = r8
            goto L_0x0287
        L_0x02ad:
            r0 = move-exception
            r31 = r8
            goto L_0x028c
        L_0x02b1:
            r0 = move-exception
            r31 = r8
            goto L_0x0291
        L_0x02b5:
            r0 = move-exception
            r31 = r8
            r10 = r15
        L_0x02b9:
            r14 = r18
            goto L_0x06f8
        L_0x02bd:
            r0 = move-exception
            r31 = r8
            r10 = r15
        L_0x02c1:
            r14 = r18
            goto L_0x0702
        L_0x02c5:
            r0 = move-exception
            r31 = r8
            r10 = r15
        L_0x02c9:
            r14 = r18
            goto L_0x0708
        L_0x02cd:
            r0 = move-exception
            r31 = r8
            r10 = r15
        L_0x02d1:
            r14 = r18
            goto L_0x070e
        L_0x02d5:
            r0 = move-exception
            r31 = r8
            r10 = r15
        L_0x02d9:
            r14 = r18
            goto L_0x0714
        L_0x02dd:
            r0 = move-exception
            r31 = r8
            r10 = r15
        L_0x02e1:
            r14 = r18
            goto L_0x071a
        L_0x02e5:
            r0 = move-exception
            r31 = r8
            r10 = r15
        L_0x02e9:
            r14 = r18
            goto L_0x0720
        L_0x02ed:
            r0 = move-exception
            r31 = r8
            r10 = r15
        L_0x02f1:
            r14 = r18
            goto L_0x0726
        L_0x02f5:
            r31 = r8
            r28 = r10
            r5 = r18
            r9 = r5
        L_0x02fc:
            u2.t$a r7 = u2.t.f21927u     // Catch:{ SocketTimeoutException -> 0x05d8, IllegalStateException -> 0x05d3, IllegalArgumentException -> 0x05ce, SecurityException -> 0x05c9, MalformedURLException -> 0x05c4, ProtocolException -> 0x05bf, SSLHandshakeException -> 0x05ba, IOException -> 0x05b5 }
            android.content.Context r8 = r1.getApplicationContext()     // Catch:{ SocketTimeoutException -> 0x05d8, IllegalStateException -> 0x05d3, IllegalArgumentException -> 0x05ce, SecurityException -> 0x05c9, MalformedURLException -> 0x05c4, ProtocolException -> 0x05bf, SSLHandshakeException -> 0x05ba, IOException -> 0x05b5 }
            r29 = r5
            java.lang.String r5 = "getApplicationContext(...)"
            kotlin.jvm.internal.m.d(r8, r5)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            u2.t r5 = r7.a(r8)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            r5.a()     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            r33 = r18
            r6 = 0
            r8 = 0
        L_0x0314:
            com.uptodown.workers.DownloadWorker$a r7 = f19459d     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            boolean r7 = r7.i()     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            if (r7 != 0) goto L_0x0458
            if (r0 <= 0) goto L_0x0458
        L_0x031e:
            boolean r0 = f19462g     // Catch:{ IOException -> 0x0355, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343 }
            if (r0 == 0) goto L_0x035b
            r0 = 211(0xd3, float:2.96E-43)
            r1.I(r2, r0)     // Catch:{ IOException -> 0x0355, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343 }
            r35 = 1000(0x3e8, double:4.94E-321)
            java.lang.Thread.sleep(r35)     // Catch:{ IOException -> 0x0355, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343 }
            com.uptodown.workers.DownloadWorker$a r0 = f19459d     // Catch:{ IOException -> 0x0355, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343 }
            boolean r0 = r0.i()     // Catch:{ IOException -> 0x0355, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343 }
            if (r0 == 0) goto L_0x0335
            goto L_0x035b
        L_0x0335:
            g2.S r0 = r1.u()     // Catch:{ IOException -> 0x0355, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343 }
            if (r0 != 0) goto L_0x031e
            u2.C r0 = u2.C2313C.f21882a     // Catch:{ IOException -> 0x0355, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343 }
            android.content.Context r7 = r1.f19463a     // Catch:{ IOException -> 0x0355, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343 }
            r0.j(r7)     // Catch:{ IOException -> 0x0355, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343 }
            goto L_0x031e
        L_0x0343:
            r0 = move-exception
        L_0x0344:
            r10 = r15
            r14 = r29
            goto L_0x0714
        L_0x0349:
            r0 = move-exception
        L_0x034a:
            r10 = r15
            r14 = r29
            goto L_0x071a
        L_0x034f:
            r0 = move-exception
        L_0x0350:
            r10 = r15
            r14 = r29
            goto L_0x0720
        L_0x0355:
            r0 = move-exception
            r32 = r6
        L_0x0358:
            r6 = 1000(0x3e8, float:1.401E-42)
            goto L_0x037c
        L_0x035b:
            kotlin.jvm.internal.m.b(r15)     // Catch:{ IOException -> 0x0355, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343 }
            r32 = r6
            r6 = 0
            r7 = 8192(0x2000, float:1.14794E-41)
            int r0 = r15.read(r14, r6, r7)     // Catch:{ IOException -> 0x037a, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343 }
            r6 = 1000(0x3e8, float:1.401E-42)
            if (r0 > 0) goto L_0x036d
            goto L_0x0465
        L_0x036d:
            r37 = r8
            r38 = r9
            r9 = r28
            r7 = 45
            r8 = 8192(0x2000, float:1.14794E-41)
            r10 = 0
            goto L_0x045d
        L_0x037a:
            r0 = move-exception
            goto L_0x0358
        L_0x037c:
            long r35 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            long r35 = r35 - r48
            r37 = r8
            long r7 = (long) r6     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            long r35 = r35 / r7
            r7 = 3600(0xe10, double:1.7786E-320)
            int r38 = (r35 > r7 ? 1 : (r35 == r7 ? 0 : -1))
            if (r38 > 0) goto L_0x0580
            r7 = 20000(0x4e20, double:9.8813E-320)
            java.lang.Thread.sleep(r7)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            com.uptodown.workers.DownloadWorker$a r7 = f19459d     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            boolean r7 = r7.i()     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            if (r7 == 0) goto L_0x039c
            goto L_0x0465
        L_0x039c:
            u2.z r7 = u2.z.f21956a     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            boolean r8 = r7.d()     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            if (r8 == 0) goto L_0x0577
            com.uptodown.activities.preferences.a$a r8 = com.uptodown.activities.preferences.a.f18818a     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            android.content.Context r6 = r1.f19463a     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            boolean r6 = r8.Z(r6)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            if (r6 == 0) goto L_0x03e3
            boolean r6 = r7.f()     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            if (r6 != 0) goto L_0x03e3
            int r6 = r2.l()     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            r7 = 1
            if (r6 != r7) goto L_0x03bc
            goto L_0x03e4
        L_0x03bc:
            r1.i(r15, r12, r13)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            java.io.IOException r4 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            r4.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            throw r4     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
        L_0x03c5:
            r0 = move-exception
        L_0x03c6:
            r10 = r15
            r14 = r29
            goto L_0x06f8
        L_0x03cb:
            r0 = move-exception
        L_0x03cc:
            r10 = r15
            r14 = r29
            goto L_0x0702
        L_0x03d1:
            r0 = move-exception
        L_0x03d2:
            r10 = r15
            r14 = r29
            goto L_0x0708
        L_0x03d7:
            r0 = move-exception
        L_0x03d8:
            r10 = r15
            r14 = r29
            goto L_0x070e
        L_0x03dd:
            r0 = move-exception
        L_0x03de:
            r10 = r15
            r14 = r29
            goto L_0x0726
        L_0x03e3:
            r7 = 1
        L_0x03e4:
            java.net.URL r6 = r13.getURL()     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            r8 = r25
            kotlin.jvm.internal.m.d(r6, r8)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            javax.net.ssl.HttpsURLConnection r6 = r1.B(r6)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            r25 = r8
            long r7 = r43 + r29
            int r13 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r13 <= 0) goto L_0x0430
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            r13.<init>()     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            r38 = r9
            r9 = r28
            r13.append(r9)     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            r13.append(r7)     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            r7 = 45
            r13.append(r7)     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            java.lang.String r8 = r13.toString()     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            r6.setRequestProperty(r11, r8)     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            goto L_0x0436
        L_0x0415:
            r0 = move-exception
            r13 = r6
            goto L_0x03c6
        L_0x0418:
            r0 = move-exception
            r13 = r6
            goto L_0x03cc
        L_0x041b:
            r0 = move-exception
            r13 = r6
            goto L_0x03d2
        L_0x041e:
            r0 = move-exception
            r13 = r6
            goto L_0x03d8
        L_0x0421:
            r0 = move-exception
            r13 = r6
            goto L_0x0344
        L_0x0425:
            r0 = move-exception
            r13 = r6
            goto L_0x034a
        L_0x0429:
            r0 = move-exception
            r13 = r6
            goto L_0x0350
        L_0x042d:
            r0 = move-exception
            r13 = r6
            goto L_0x03de
        L_0x0430:
            r38 = r9
            r9 = r28
            r7 = 45
        L_0x0436:
            r6.connect()     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            int r8 = r6.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            r10 = 200(0xc8, float:2.8E-43)
            if (r8 < r10) goto L_0x056e
            r10 = 300(0x12c, float:4.2E-43)
            if (r8 >= r10) goto L_0x056e
            java.io.InputStream r15 = r6.getInputStream()     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            if (r15 == 0) goto L_0x0564
            r4.d()     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            r8 = 8192(0x2000, float:1.14794E-41)
            r10 = 0
            int r0 = r15.read(r14, r10, r8)     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            r13 = r6
            if (r0 > 0) goto L_0x045d
        L_0x0458:
            r10 = r22
            r7 = 0
            goto L_0x0589
        L_0x045d:
            com.uptodown.workers.DownloadWorker$a r6 = f19459d     // Catch:{ SocketTimeoutException -> 0x0501, IllegalStateException -> 0x04fc, IllegalArgumentException -> 0x04f7, SecurityException -> 0x04f2, MalformedURLException -> 0x04ed, ProtocolException -> 0x04e8, SSLHandshakeException -> 0x04e3, IOException -> 0x04de }
            boolean r6 = r6.i()     // Catch:{ SocketTimeoutException -> 0x0501, IllegalStateException -> 0x04fc, IllegalArgumentException -> 0x04f7, SecurityException -> 0x04f2, MalformedURLException -> 0x04ed, ProtocolException -> 0x04e8, SSLHandshakeException -> 0x04e3, IOException -> 0x04de }
            if (r6 == 0) goto L_0x0466
        L_0x0465:
            goto L_0x0458
        L_0x0466:
            r12.write(r14, r10, r0)     // Catch:{ SocketTimeoutException -> 0x0501, IllegalStateException -> 0x04fc, IllegalArgumentException -> 0x04f7, SecurityException -> 0x04f2, MalformedURLException -> 0x04ed, ProtocolException -> 0x04e8, SSLHandshakeException -> 0x04e3, IOException -> 0x04de }
            long r7 = (long) r0     // Catch:{ SocketTimeoutException -> 0x0501, IllegalStateException -> 0x04fc, IllegalArgumentException -> 0x04f7, SecurityException -> 0x04f2, MalformedURLException -> 0x04ed, ProtocolException -> 0x04e8, SSLHandshakeException -> 0x04e3, IOException -> 0x04de }
            long r29 = r29 + r7
            long r40 = r3.h()     // Catch:{ SocketTimeoutException -> 0x0501, IllegalStateException -> 0x04fc, IllegalArgumentException -> 0x04f7, SecurityException -> 0x04f2, MalformedURLException -> 0x04ed, ProtocolException -> 0x04e8, SSLHandshakeException -> 0x04e3, IOException -> 0x04de }
            long r7 = r40 + r7
            r3.p(r7)     // Catch:{ SocketTimeoutException -> 0x0501, IllegalStateException -> 0x04fc, IllegalArgumentException -> 0x04f7, SecurityException -> 0x04f2, MalformedURLException -> 0x04ed, ProtocolException -> 0x04e8, SSLHandshakeException -> 0x04e3, IOException -> 0x04de }
            long r6 = r29 + r43
            if (r32 != 0) goto L_0x04a2
            long r40 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            r8 = 30000(0x7530, float:4.2039E-41)
            r28 = r11
            long r10 = (long) r8     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            long r10 = r38 + r10
            int r8 = (r40 > r10 ? 1 : (r40 == r10 ? 0 : -1))
            if (r8 <= 0) goto L_0x049f
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            long r10 = r10 - r38
            r36 = r9
            r40 = r10
            r8 = 1000(0x3e8, float:1.401E-42)
            long r9 = (long) r8     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            long r10 = r40 / r9
            long r8 = r6 / r10
            r4.a(r8)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            r32 = 1
            goto L_0x04a5
        L_0x049f:
            r36 = r9
            goto L_0x04a5
        L_0x04a2:
            r28 = r11
            goto L_0x049f
        L_0x04a5:
            double r8 = (double) r6
            r10 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r8 = r8 * r10
            r10 = r22
            r22 = r8
            double r8 = (double) r10
            double r8 = r22 / r8
            int r8 = (int) r8
            int r9 = r37 + 10
            if (r8 > r9) goto L_0x0506
            long r22 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x0501, IllegalStateException -> 0x04fc, IllegalArgumentException -> 0x04f7, SecurityException -> 0x04f2, MalformedURLException -> 0x04ed, ProtocolException -> 0x04e8, SSLHandshakeException -> 0x04e3, IOException -> 0x04de }
            r35 = r13
            r40 = r14
            r9 = 1000(0x3e8, float:1.401E-42)
            long r13 = (long) r9
            long r13 = r26 + r13
            int r9 = (r22 > r13 ? 1 : (r22 == r13 ? 0 : -1))
            if (r9 <= 0) goto L_0x04cc
            int r9 = (r6 > r33 ? 1 : (r6 == r33 ? 0 : -1))
            if (r9 <= 0) goto L_0x04cc
            goto L_0x050a
        L_0x04cc:
            r22 = r10
            r11 = r28
            r6 = r32
            r13 = r35
            r28 = r36
            r8 = r37
        L_0x04d8:
            r9 = r38
            r14 = r40
            goto L_0x0314
        L_0x04de:
            r0 = move-exception
            r35 = r13
            goto L_0x03c6
        L_0x04e3:
            r0 = move-exception
            r35 = r13
            goto L_0x03cc
        L_0x04e8:
            r0 = move-exception
            r35 = r13
            goto L_0x03d2
        L_0x04ed:
            r0 = move-exception
            r35 = r13
            goto L_0x03d8
        L_0x04f2:
            r0 = move-exception
            r35 = r13
            goto L_0x0344
        L_0x04f7:
            r0 = move-exception
            r35 = r13
            goto L_0x034a
        L_0x04fc:
            r0 = move-exception
            r35 = r13
            goto L_0x0350
        L_0x0501:
            r0 = move-exception
            r35 = r13
            goto L_0x03de
        L_0x0506:
            r35 = r13
            r40 = r14
        L_0x050a:
            long r26 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x055c, IllegalStateException -> 0x0554, IllegalArgumentException -> 0x054c, SecurityException -> 0x0544, MalformedURLException -> 0x053c, ProtocolException -> 0x0534, SSLHandshakeException -> 0x052c, IOException -> 0x0524 }
            r3.p(r6)     // Catch:{ SocketTimeoutException -> 0x055c, IllegalStateException -> 0x0554, IllegalArgumentException -> 0x054c, SecurityException -> 0x0544, MalformedURLException -> 0x053c, ProtocolException -> 0x0534, SSLHandshakeException -> 0x052c, IOException -> 0x0524 }
            r5.x1(r3)     // Catch:{ SocketTimeoutException -> 0x055c, IllegalStateException -> 0x0554, IllegalArgumentException -> 0x054c, SecurityException -> 0x0544, MalformedURLException -> 0x053c, ProtocolException -> 0x0534, SSLHandshakeException -> 0x052c, IOException -> 0x0524 }
            r1.z(r8)     // Catch:{ SocketTimeoutException -> 0x055c, IllegalStateException -> 0x0554, IllegalArgumentException -> 0x054c, SecurityException -> 0x0544, MalformedURLException -> 0x053c, ProtocolException -> 0x0534, SSLHandshakeException -> 0x052c, IOException -> 0x0524 }
            r33 = r6
            r22 = r10
            r11 = r28
            r6 = r32
            r13 = r35
            r28 = r36
            goto L_0x04d8
        L_0x0524:
            r0 = move-exception
            r10 = r15
            r14 = r29
            r13 = r35
            goto L_0x06f8
        L_0x052c:
            r0 = move-exception
            r10 = r15
            r14 = r29
            r13 = r35
            goto L_0x0702
        L_0x0534:
            r0 = move-exception
            r10 = r15
            r14 = r29
            r13 = r35
            goto L_0x0708
        L_0x053c:
            r0 = move-exception
            r10 = r15
            r14 = r29
            r13 = r35
            goto L_0x070e
        L_0x0544:
            r0 = move-exception
            r10 = r15
            r14 = r29
            r13 = r35
            goto L_0x0714
        L_0x054c:
            r0 = move-exception
            r10 = r15
            r14 = r29
            r13 = r35
            goto L_0x071a
        L_0x0554:
            r0 = move-exception
            r10 = r15
            r14 = r29
            r13 = r35
            goto L_0x0720
        L_0x055c:
            r0 = move-exception
            r10 = r15
            r14 = r29
            r13 = r35
            goto L_0x0726
        L_0x0564:
            r7 = 0
            r1.i(r7, r12, r6)     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            java.io.IOException r4 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            r4.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            throw r4     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
        L_0x056e:
            r1.i(r15, r12, r6)     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            java.io.IOException r4 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            r4.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
            throw r4     // Catch:{ SocketTimeoutException -> 0x042d, IllegalStateException -> 0x0429, IllegalArgumentException -> 0x0425, SecurityException -> 0x0421, MalformedURLException -> 0x041e, ProtocolException -> 0x041b, SSLHandshakeException -> 0x0418, IOException -> 0x0415 }
        L_0x0577:
            r1.i(r15, r12, r13)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            java.io.IOException r4 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            r4.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            throw r4     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
        L_0x0580:
            r1.i(r15, r12, r13)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            java.io.IOException r4 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            r4.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            throw r4     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
        L_0x0589:
            r1.i(r15, r12, r13)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            com.uptodown.workers.DownloadWorker$a r0 = f19459d     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            boolean r0 = r0.i()     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            if (r0 != 0) goto L_0x05ac
            long r8 = r43 + r29
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x05a6
            r2.V()     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            r5.w1(r2)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            r3.p(r10)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            r5.x1(r3)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
        L_0x05a6:
            r0 = 100
            r1.z(r0)     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            goto L_0x05af
        L_0x05ac:
            r4.b()     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
        L_0x05af:
            r5.i()     // Catch:{ SocketTimeoutException -> 0x03dd, IllegalStateException -> 0x034f, IllegalArgumentException -> 0x0349, SecurityException -> 0x0343, MalformedURLException -> 0x03d7, ProtocolException -> 0x03d1, SSLHandshakeException -> 0x03cb, IOException -> 0x03c5 }
            r4 = r7
            goto L_0x072c
        L_0x05b5:
            r0 = move-exception
            r29 = r5
            goto L_0x03c6
        L_0x05ba:
            r0 = move-exception
            r29 = r5
            goto L_0x03cc
        L_0x05bf:
            r0 = move-exception
            r29 = r5
            goto L_0x03d2
        L_0x05c4:
            r0 = move-exception
            r29 = r5
            goto L_0x03d8
        L_0x05c9:
            r0 = move-exception
            r29 = r5
            goto L_0x0344
        L_0x05ce:
            r0 = move-exception
            r29 = r5
            goto L_0x034a
        L_0x05d3:
            r0 = move-exception
            r29 = r5
            goto L_0x0350
        L_0x05d8:
            r0 = move-exception
            r29 = r5
            goto L_0x03de
        L_0x05dd:
            r0 = move-exception
            r31 = r8
            r7 = 0
        L_0x05e1:
            r10 = r7
            goto L_0x02b9
        L_0x05e4:
            r0 = move-exception
            r31 = r8
            r7 = 0
        L_0x05e8:
            r10 = r7
            goto L_0x02c1
        L_0x05eb:
            r0 = move-exception
            r31 = r8
            r7 = 0
        L_0x05ef:
            r10 = r7
            goto L_0x02c9
        L_0x05f2:
            r0 = move-exception
            r31 = r8
            r7 = 0
        L_0x05f6:
            r10 = r7
            goto L_0x02d1
        L_0x05f9:
            r0 = move-exception
            r31 = r8
            r7 = 0
        L_0x05fd:
            r10 = r7
            goto L_0x02d9
        L_0x0600:
            r0 = move-exception
            r31 = r8
            r7 = 0
        L_0x0604:
            r10 = r7
            goto L_0x02e1
        L_0x0607:
            r0 = move-exception
            r31 = r8
            r7 = 0
        L_0x060b:
            r10 = r7
            goto L_0x02e9
        L_0x060e:
            r0 = move-exception
            r31 = r8
            r7 = 0
        L_0x0612:
            r10 = r7
            goto L_0x02f1
        L_0x0615:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            goto L_0x05e1
        L_0x061c:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            goto L_0x05e8
        L_0x0623:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            goto L_0x05ef
        L_0x062a:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            goto L_0x05f6
        L_0x0631:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            goto L_0x05fd
        L_0x0638:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            goto L_0x0604
        L_0x063f:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            goto L_0x060b
        L_0x0646:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            goto L_0x0612
        L_0x064d:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x02b9
        L_0x0657:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x02c1
        L_0x0661:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x02c9
        L_0x066b:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x02d1
        L_0x0675:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x02d9
        L_0x067f:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x02e1
        L_0x0689:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x02e9
        L_0x0693:
            r0 = move-exception
            r31 = r8
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x02f1
        L_0x069d:
            r0 = move-exception
            r31 = r8
            r18 = r14
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x06f8
        L_0x06a9:
            r0 = move-exception
            r31 = r8
            r18 = r14
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x0702
        L_0x06b5:
            r0 = move-exception
            r31 = r8
            r18 = r14
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x0708
        L_0x06c1:
            r0 = move-exception
            r31 = r8
            r18 = r14
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x070e
        L_0x06cc:
            r0 = move-exception
            r31 = r8
            r18 = r14
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x0714
        L_0x06d7:
            r0 = move-exception
            r31 = r8
            r18 = r14
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x071a
        L_0x06e2:
            r0 = move-exception
            r31 = r8
            r18 = r14
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x0720
        L_0x06ed:
            r0 = move-exception
            r31 = r8
            r18 = r14
            r7 = 0
            r13 = r43
            r10 = r7
            r12 = r10
            goto L_0x0726
        L_0x06f8:
            r0.printStackTrace()
            java.lang.String r0 = "IOException"
        L_0x06fd:
            r4 = r0
            r29 = r14
            r15 = r10
            goto L_0x072c
        L_0x0702:
            r0.printStackTrace()
            java.lang.String r0 = "SSLHandshakeException"
            goto L_0x06fd
        L_0x0708:
            r0.printStackTrace()
            java.lang.String r0 = "ProtocolException"
            goto L_0x06fd
        L_0x070e:
            r0.printStackTrace()
            java.lang.String r0 = "MalformedURLException"
            goto L_0x06fd
        L_0x0714:
            r0.printStackTrace()
            java.lang.String r0 = "SecurityException"
            goto L_0x06fd
        L_0x071a:
            r0.printStackTrace()
            java.lang.String r0 = "IllegalArgumentException"
            goto L_0x06fd
        L_0x0720:
            r0.printStackTrace()
            java.lang.String r0 = "IllegalStateException"
            goto L_0x06fd
        L_0x0726:
            r0.printStackTrace()
            java.lang.String r0 = "SocketTimeoutException"
            goto L_0x06fd
        L_0x072c:
            if (r4 == 0) goto L_0x0748
            r1.i(r15, r12, r13)
            java.net.URL r0 = r13.getURL()
            java.lang.String r8 = r0.toString()
            r5 = r31
            kotlin.jvm.internal.m.d(r8, r5)
            r5 = r47
            r6 = r48
            r1.D(r2, r3, r4, r5, r6, r8)
            r14 = r16
            goto L_0x074a
        L_0x0748:
            r14 = r29
        L_0x074a:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadWorker.m(javax.net.ssl.HttpsURLConnection, java.io.File, g2.s, g2.s$c, java.lang.String, long, com.uptodown.workers.DownloadWorker$b):long");
    }

    public final Context p() {
        return this.f19463a;
    }

    public final String q(String str) {
        m.e(str, "url");
        String str2 = str;
        String str3 = str2;
        if (m3.m.R(str2, ".", 0, false, 6, (Object) null) == -1) {
            return "apk";
        }
        String substring = str3.substring(m3.m.R(str3, ".", 0, false, 6, (Object) null) + 1);
        m.d(substring, "substring(...)");
        if (substring.length() == 0) {
            return "apk";
        }
        return substring;
    }

    public final String r(String str) {
        m.e(str, "url");
        String str2 = str;
        String substring = str2.substring(m3.m.R(str2, "/", 0, false, 6, (Object) null) + 1);
        m.d(substring, "substring(...)");
        return substring;
    }

    public final x s() {
        return this.f19464b;
    }

    public final String t() {
        return this.f19465c;
    }

    public S u() {
        return null;
    }

    public final void v() {
        f19461f = false;
        f19462g = false;
        Context a5 = k.f7778g.a(this.f19463a);
        this.f19463a = a5;
        this.f19464b = new x(a5);
    }

    public final void w(Bundle bundle, String str) {
        m.e(bundle, "bundle");
        this.f19465c = str;
        Bundle g4 = g(bundle);
        x xVar = this.f19464b;
        if (xVar != null) {
            xVar.d("download", g4);
        }
    }

    public final void x(long j4, long j5, long j6, long j7) {
        Bundle bundle = new Bundle();
        bundle.putString("type", "completed");
        if (j4 == 0) {
            long currentTimeMillis = (System.currentTimeMillis() - j6) / ((long) 1000);
            if (currentTimeMillis > 0) {
                j4 = j7 / currentTimeMillis;
            }
        }
        bundle.putLong("speed", j4);
        bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j5) / ((long) 1000));
        w(bundle, this.f19465c);
    }

    public void y(S s4, C2060s sVar, C2060s.c cVar, Bundle bundle, String str, long j4) {
        m.e(s4, "update");
        m.e(sVar, "download");
        m.e(cVar, "df");
        m.e(bundle, "bundleParamsFail");
    }
}
