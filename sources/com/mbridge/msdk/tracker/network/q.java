package com.mbridge.msdk.tracker.network;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.report.c;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.Connection;
import com.mbridge.msdk.thrid.okhttp.Handshake;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.Route;
import com.mbridge.msdk.thrid.okhttp.TlsVersion;
import com.mbridge.msdk.tracker.e;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class q {

    /* renamed from: A  reason: collision with root package name */
    private volatile long f15554A;

    /* renamed from: B  reason: collision with root package name */
    private volatile long f15555B;

    /* renamed from: C  reason: collision with root package name */
    private volatile long f15556C;

    /* renamed from: D  reason: collision with root package name */
    private volatile long f15557D;

    /* renamed from: E  reason: collision with root package name */
    private volatile long f15558E;

    /* renamed from: F  reason: collision with root package name */
    private volatile long f15559F;

    /* renamed from: G  reason: collision with root package name */
    private volatile long f15560G;

    /* renamed from: H  reason: collision with root package name */
    private volatile List<InetAddress> f15561H;

    /* renamed from: I  reason: collision with root package name */
    private volatile InetSocketAddress f15562I;

    /* renamed from: J  reason: collision with root package name */
    private volatile Proxy f15563J;

    /* renamed from: K  reason: collision with root package name */
    private volatile Handshake f15564K;

    /* renamed from: L  reason: collision with root package name */
    private volatile Protocol f15565L;

    /* renamed from: M  reason: collision with root package name */
    private volatile IOException f15566M;

    /* renamed from: N  reason: collision with root package name */
    private volatile boolean f15567N = false;

    /* renamed from: O  reason: collision with root package name */
    private volatile Exception f15568O;

    /* renamed from: P  reason: collision with root package name */
    private volatile boolean f15569P = false;

    /* renamed from: Q  reason: collision with root package name */
    private long f15570Q;

    /* renamed from: R  reason: collision with root package name */
    private long f15571R;

    /* renamed from: S  reason: collision with root package name */
    private long f15572S;

    /* renamed from: T  reason: collision with root package name */
    private long f15573T;

    /* renamed from: a  reason: collision with root package name */
    protected volatile String f15574a = "";

    /* renamed from: b  reason: collision with root package name */
    private volatile String f15575b = "";

    /* renamed from: c  reason: collision with root package name */
    private volatile String f15576c = "";

    /* renamed from: d  reason: collision with root package name */
    private volatile String f15577d = "";

    /* renamed from: e  reason: collision with root package name */
    private volatile String f15578e = "";

    /* renamed from: f  reason: collision with root package name */
    private volatile long f15579f;

    /* renamed from: g  reason: collision with root package name */
    private volatile int f15580g = -1;

    /* renamed from: h  reason: collision with root package name */
    private volatile String f15581h = "";

    /* renamed from: i  reason: collision with root package name */
    private volatile int f15582i = -1;

    /* renamed from: j  reason: collision with root package name */
    private volatile String f15583j = "un_known";

    /* renamed from: k  reason: collision with root package name */
    private volatile String f15584k = "";

    /* renamed from: l  reason: collision with root package name */
    private volatile String f15585l = "okhttp";

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f15586m = false;

    /* renamed from: n  reason: collision with root package name */
    private final AtomicInteger f15587n = new AtomicInteger(0);

    /* renamed from: o  reason: collision with root package name */
    private volatile String f15588o = "";

    /* renamed from: p  reason: collision with root package name */
    private volatile long f15589p = 0;

    /* renamed from: q  reason: collision with root package name */
    private volatile long f15590q = 0;

    /* renamed from: r  reason: collision with root package name */
    private volatile long f15591r = 0;

    /* renamed from: s  reason: collision with root package name */
    private volatile long f15592s;

    /* renamed from: t  reason: collision with root package name */
    private volatile long f15593t;

    /* renamed from: u  reason: collision with root package name */
    private volatile IOException f15594u;

    /* renamed from: v  reason: collision with root package name */
    private volatile long f15595v;

    /* renamed from: w  reason: collision with root package name */
    private volatile long f15596w;

    /* renamed from: x  reason: collision with root package name */
    private volatile long f15597x;

    /* renamed from: y  reason: collision with root package name */
    private volatile long f15598y;

    /* renamed from: z  reason: collision with root package name */
    private volatile long f15599z;

    public q(String str, String str2) {
        this.f15583j = str;
        this.f15584k = str2;
        this.f15577d = UUID.randomUUID().toString();
    }

    private String g() {
        return TextUtils.isEmpty(this.f15576c) ? "" : this.f15576c;
    }

    private String h() {
        return TextUtils.isEmpty(this.f15575b) ? "" : this.f15575b;
    }

    private String i() {
        return TextUtils.isEmpty(this.f15577d) ? "" : this.f15577d;
    }

    private String j() {
        return TextUtils.isEmpty(this.f15578e) ? "" : this.f15578e;
    }

    private String k() {
        try {
            if (TextUtils.isEmpty(this.f15574a)) {
                return "";
            }
            return URLEncoder.encode(this.f15574a, C.UTF8_NAME);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    private String l() {
        if (TextUtils.isEmpty(this.f15583j)) {
            return "un_known";
        }
        return this.f15583j;
    }

    private String m() {
        if (TextUtils.isEmpty(this.f15584k)) {
            return "";
        }
        return this.f15584k;
    }

    private int n() {
        return this.f15587n.getAndAdd(0);
    }

    private String o() {
        if (this.f15561H == null || this.f15561H.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        while (i4 < this.f15561H.size()) {
            try {
                InetAddress inetAddress = this.f15561H.get(i4);
                if (inetAddress != null) {
                    sb.append(inetAddress.getHostAddress());
                    if (i4 != this.f15561H.size() - 1) {
                        sb.append(",");
                    }
                }
                i4++;
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("NetworkMonitor", "getDnsResult ", e5);
                }
            }
        }
        return sb.toString();
    }

    private String p() {
        if (this.f15562I != null) {
            try {
                InetAddress address = this.f15562I.getAddress();
                if (address == null) {
                    return "";
                }
                String hostAddress = address.getHostAddress();
                if (TextUtils.isEmpty(hostAddress)) {
                    return "";
                }
                return hostAddress;
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("NetworkMonitor", "getAddress ", e5);
                }
            }
        }
        return "";
    }

    private String q() {
        if (this.f15564K != null) {
            try {
                TlsVersion tlsVersion = this.f15564K.tlsVersion();
                if (tlsVersion == null) {
                    return "";
                }
                return tlsVersion.javaName();
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("NetworkMonitor", "getTlsVersion ", e5);
                }
            }
        }
        return "";
    }

    private String r() {
        try {
            if (this.f15566M != null) {
                String name = this.f15566M.getClass().getName();
                String message = this.f15566M.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    return a("connection: %s ", name, message);
                }
            }
            if (this.f15594u != null) {
                String name2 = this.f15594u.getClass().getName();
                String message2 = this.f15594u.getMessage();
                if (!TextUtils.isEmpty(message2)) {
                    return a("call: %s ", name2, message2);
                }
            }
            if (this.f15568O == null) {
                return "un_known";
            }
            String name3 = this.f15568O.getClass().getName();
            String message3 = this.f15568O.getMessage();
            if (!TextUtils.isEmpty(message3)) {
                return a("error: %s ", name3, message3);
            }
            return "un_known";
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return "un_known";
            }
            af.b("NetworkMonitor", "getError ", e5);
            return "un_known";
        }
    }

    public final void a(String str) {
        this.f15574a = str;
    }

    public final void b(long j4) {
        this.f15571R = j4;
    }

    public final void c(long j4) {
        this.f15572S = j4;
    }

    public final void d(long j4) {
        this.f15573T = j4;
    }

    public final void e(long j4) {
        this.f15556C = SystemClock.elapsedRealtime();
    }

    public final void f(long j4) {
        this.f15591r = j4;
    }

    public final void a(long j4) {
        this.f15570Q = j4;
    }

    public final void b(String str) {
        this.f15576c = str;
    }

    public final void c(String str) {
        this.f15575b = str;
    }

    public final void d(String str) {
        this.f15581h = str;
    }

    public final void e() {
        this.f15559F = SystemClock.elapsedRealtime();
    }

    public final long f() {
        return this.f15591r;
    }

    public final void g(long j4) {
        this.f15560G = SystemClock.elapsedRealtime();
    }

    public final void h(long j4) {
        this.f15590q = j4;
    }

    public final void i(long j4) {
        this.f15589p = j4;
    }

    public final void j(long j4) {
        this.f15578e = UUID.randomUUID().toString();
        this.f15579f = j4;
        this.f15587n.addAndGet(1);
        this.f15566M = null;
        this.f15594u = null;
        this.f15568O = null;
        this.f15592s = 0;
        this.f15593t = 0;
        this.f15595v = 0;
        this.f15596w = 0;
        this.f15597x = 0;
        this.f15598y = 0;
        this.f15599z = 0;
        this.f15554A = 0;
        this.f15555B = 0;
        this.f15556C = 0;
        this.f15557D = 0;
        this.f15558E = 0;
        this.f15559F = 0;
        this.f15560G = 0;
        this.f15590q = 0;
        this.f15591r = 0;
        this.f15586m = false;
        this.f15580g = -1;
        this.f15582i = -1;
        this.f15581h = "";
        this.f15588o = "";
        this.f15589p = 0;
        this.f15569P = false;
        this.f15569P = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(LeanbackPreferenceDialogFragment.ARG_KEY, "m_request_start");
            jSONObject.put("uuid", i());
            jSONObject.put("request_uuid", j());
            jSONObject.put("lrid", h());
            jSONObject.put("url", k());
            jSONObject.put("timeout", this.f15570Q);
            jSONObject.put("timeout_connection", this.f15571R);
            jSONObject.put("timeout_read", this.f15572S);
            jSONObject.put("timeout_write", this.f15573T);
            jSONObject.put("scene", l());
            jSONObject.put("method", m());
            jSONObject.put("adtp", g());
            jSONObject.put("http_stack", this.f15585l);
            jSONObject.put("retry_count", n() - 1);
            jSONObject.put("request_wait_duration", this.f15579f);
            e a5 = a(jSONObject, "m_request_start");
            if (MBridgeConstans.DEBUG) {
                af.a("NetworkMonitor_" + l(), "request start monitor = " + jSONObject.toString());
            }
            d.a().c().a(a5);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                af.b("NetworkMonitor", "reportRequestStart ", th);
            }
        }
    }

    public final void a(int i4) {
        this.f15582i = i4;
    }

    public final void b() {
        this.f15599z = SystemClock.elapsedRealtime();
    }

    public final void c() {
        this.f15555B = SystemClock.elapsedRealtime();
    }

    public final void d() {
        this.f15557D = SystemClock.elapsedRealtime();
    }

    public final void a(Call call) {
        this.f15592s = SystemClock.elapsedRealtime();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0104 A[Catch:{ all -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x012a A[Catch:{ all -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x019d A[Catch:{ all -> 0x00dd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(int r9) {
        /*
            r8 = this;
            java.lang.String r0 = "m_request_end"
            r8.f15580g = r9
            boolean r9 = r8.f15569P
            if (r9 != 0) goto L_0x000a
            goto L_0x01e1
        L_0x000a:
            r9 = 0
            r8.f15569P = r9
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ all -> 0x00dd }
            r9.<init>()     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "key"
            r9.put(r1, r0)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "uuid"
            java.lang.String r2 = r8.i()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "request_uuid"
            java.lang.String r2 = r8.j()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "url"
            java.lang.String r2 = r8.k()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "timeout"
            long r2 = r8.f15570Q     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "timeout_connection"
            long r2 = r8.f15571R     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "timeout_read"
            long r2 = r8.f15572S     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "timeout_write"
            long r2 = r8.f15573T     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "scene"
            java.lang.String r2 = r8.l()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "lrid"
            java.lang.String r2 = r8.h()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "method"
            java.lang.String r2 = r8.m()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "adtp"
            java.lang.String r2 = r8.g()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "http_stack"
            java.lang.String r2 = r8.f15585l     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "retry_count"
            int r2 = r8.n()     // Catch:{ all -> 0x00dd }
            r3 = 1
            int r2 = r2 - r3
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "request_wait_duration"
            long r4 = r8.f15579f     // Catch:{ all -> 0x00dd }
            r9.put(r1, r4)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "duration"
            long r4 = r8.f15593t     // Catch:{ all -> 0x00dd }
            long r6 = r8.f15592s     // Catch:{ all -> 0x00dd }
            long r4 = r4 - r6
            long r6 = r8.f15579f     // Catch:{ all -> 0x00dd }
            long r4 = r4 + r6
            r9.put(r1, r4)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "request_duration"
            long r4 = r8.f15593t     // Catch:{ all -> 0x00dd }
            long r6 = r8.f15592s     // Catch:{ all -> 0x00dd }
            long r4 = r4 - r6
            r9.put(r1, r4)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "response_code"
            int r2 = r8.f15582i     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = r8.o()     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = "dns_result"
            r9.put(r2, r1)     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = "dns_status"
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00dd }
            if (r1 == 0) goto L_0x00bc
            r1 = 2
            goto L_0x00bd
        L_0x00bc:
            r1 = 1
        L_0x00bd:
            r9.put(r2, r1)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "is_connection_acquired"
            boolean r2 = r8.f15586m     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "address"
            java.lang.String r2 = r8.p()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "port"
            java.net.InetSocketAddress r2 = r8.f15562I     // Catch:{ all -> 0x00dd }
            if (r2 == 0) goto L_0x00e0
            java.net.InetSocketAddress r2 = r8.f15562I     // Catch:{ all -> 0x00dd }
            int r2 = r2.getPort()     // Catch:{ all -> 0x00dd }
            goto L_0x00e1
        L_0x00dd:
            r9 = move-exception
            goto L_0x01d6
        L_0x00e0:
            r2 = -1
        L_0x00e1:
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "proxy"
            java.net.Proxy r2 = r8.f15563J     // Catch:{ all -> 0x00dd }
            java.lang.String r4 = ""
            if (r2 == 0) goto L_0x00fa
            java.net.Proxy r2 = r8.f15563J     // Catch:{ all -> 0x00dd }
            java.net.Proxy$Type r2 = r2.type()     // Catch:{ all -> 0x00dd }
            if (r2 != 0) goto L_0x00f5
            goto L_0x00fa
        L_0x00f5:
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00dd }
            goto L_0x00fb
        L_0x00fa:
            r2 = r4
        L_0x00fb:
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "protocol"
            com.mbridge.msdk.thrid.okhttp.Protocol r2 = r8.f15565L     // Catch:{ all -> 0x00dd }
            if (r2 == 0) goto L_0x010a
            com.mbridge.msdk.thrid.okhttp.Protocol r2 = r8.f15565L     // Catch:{ all -> 0x00dd }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x00dd }
        L_0x010a:
            r9.put(r1, r4)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "tls_version"
            java.lang.String r2 = r8.q()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "content_type"
            java.lang.String r2 = r8.f15588o     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.d.a((java.lang.String) r2)     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            int r1 = r8.f15580g     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = "result"
            r9.put(r2, r1)     // Catch:{ all -> 0x00dd }
            if (r1 == r3) goto L_0x013a
            java.lang.String r1 = "error_type"
            java.lang.String r2 = r8.f15581h     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "reason"
            java.lang.String r2 = r8.r()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
        L_0x013a:
            java.lang.String r1 = "dns_duration"
            long r2 = r8.f15596w     // Catch:{ all -> 0x00dd }
            long r4 = r8.f15595v     // Catch:{ all -> 0x00dd }
            long r2 = r2 - r4
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "connect_duration"
            long r2 = r8.f15598y     // Catch:{ all -> 0x00dd }
            long r4 = r8.f15597x     // Catch:{ all -> 0x00dd }
            long r2 = r2 - r4
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "request_header_duration"
            long r2 = r8.f15554A     // Catch:{ all -> 0x00dd }
            long r4 = r8.f15599z     // Catch:{ all -> 0x00dd }
            long r2 = r2 - r4
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "request_body_duration"
            long r2 = r8.f15556C     // Catch:{ all -> 0x00dd }
            long r4 = r8.f15555B     // Catch:{ all -> 0x00dd }
            long r2 = r2 - r4
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "request_body_size"
            long r2 = r8.f15589p     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "response_header_duration"
            long r2 = r8.f15558E     // Catch:{ all -> 0x00dd }
            long r4 = r8.f15557D     // Catch:{ all -> 0x00dd }
            long r2 = r2 - r4
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "response_body_duration"
            long r2 = r8.f15560G     // Catch:{ all -> 0x00dd }
            long r4 = r8.f15559F     // Catch:{ all -> 0x00dd }
            long r2 = r2 - r4
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "response_body_size"
            long r2 = r8.f15590q     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "transmission_duration"
            long r2 = r8.f15557D     // Catch:{ all -> 0x00dd }
            long r4 = r8.f15599z     // Catch:{ all -> 0x00dd }
            long r2 = r2 - r4
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "current_response_body_size"
            long r2 = r8.f15591r     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            com.mbridge.msdk.tracker.e r0 = a((org.json.JSONObject) r9, (java.lang.String) r0)     // Catch:{ all -> 0x00dd }
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x00dd }
            if (r1 == 0) goto L_0x01ca
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dd }
            r1.<init>()     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = "NetworkMonitor_"
            r1.append(r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = r8.l()     // Catch:{ all -> 0x00dd }
            r1.append(r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dd }
            r2.<init>()     // Catch:{ all -> 0x00dd }
            java.lang.String r3 = "request  end  monitor = "
            r2.append(r3)     // Catch:{ all -> 0x00dd }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00dd }
            r2.append(r9)     // Catch:{ all -> 0x00dd }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x00dd }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r1, (java.lang.String) r9)     // Catch:{ all -> 0x00dd }
        L_0x01ca:
            com.mbridge.msdk.foundation.same.report.d.d r9 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ all -> 0x00dd }
            com.mbridge.msdk.tracker.m r9 = r9.c()     // Catch:{ all -> 0x00dd }
            r9.a((com.mbridge.msdk.tracker.e) r0)     // Catch:{ all -> 0x00dd }
            return
        L_0x01d6:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x01e1
            java.lang.String r0 = "NetworkMonitor"
            java.lang.String r1 = "reportRequestEnd "
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r9)
        L_0x01e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.tracker.network.q.b(int):void");
    }

    public final void a() {
        this.f15595v = SystemClock.elapsedRealtime();
    }

    public final void a(List<InetAddress> list) {
        this.f15596w = SystemClock.elapsedRealtime();
        this.f15561H = list;
    }

    public final void a(InetSocketAddress inetSocketAddress, Proxy proxy) {
        this.f15597x = SystemClock.elapsedRealtime();
        this.f15562I = inetSocketAddress;
        this.f15563J = proxy;
        this.f15567N = true;
    }

    public final void a(Handshake handshake) {
        this.f15564K = handshake;
    }

    public final void a(Protocol protocol, IOException iOException) {
        this.f15598y = SystemClock.elapsedRealtime();
        this.f15565L = protocol;
        this.f15566M = iOException;
    }

    public final void a(Connection connection) {
        this.f15586m = !this.f15567N;
        if (this.f15586m && connection != null) {
            try {
                this.f15565L = connection.protocol();
                Route route = connection.route();
                if (route != null) {
                    this.f15562I = route.socketAddress();
                    this.f15563J = route.proxy();
                }
                this.f15564K = connection.handshake();
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("NetworkMonitor", "connectionAcquired ", e5);
                }
            }
        }
    }

    public final void a(Request request) {
        this.f15554A = SystemClock.elapsedRealtime();
    }

    public final void a(Response response) {
        this.f15558E = SystemClock.elapsedRealtime();
        if (response != null) {
            try {
                Headers headers = response.headers();
                if (headers != null) {
                    String str = headers.get("Content-Type");
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    this.f15588o = str;
                }
            } catch (Exception e5) {
                this.f15588o = EnvironmentCompat.MEDIA_UNKNOWN;
                if (MBridgeConstans.DEBUG) {
                    af.b("NetworkMonitor", "responseHeadersEnd ", e5);
                }
            }
        }
    }

    public final void a(IOException iOException) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f15593t = elapsedRealtime;
        this.f15594u = iOException;
        if (iOException != null) {
            if (this.f15595v == 0) {
                this.f15595v = elapsedRealtime;
            }
            if (this.f15596w == 0) {
                this.f15596w = elapsedRealtime;
            }
            if (this.f15597x == 0) {
                this.f15597x = elapsedRealtime;
            }
            if (this.f15598y == 0) {
                this.f15598y = elapsedRealtime;
            }
            if (this.f15599z == 0) {
                this.f15599z = elapsedRealtime;
            }
            if (this.f15554A == 0) {
                this.f15554A = elapsedRealtime;
            }
            if (this.f15555B == 0) {
                this.f15555B = elapsedRealtime;
            }
            if (this.f15556C == 0) {
                this.f15556C = elapsedRealtime;
            }
            if (this.f15557D == 0) {
                this.f15557D = elapsedRealtime;
            }
            if (this.f15558E == 0) {
                this.f15558E = elapsedRealtime;
            }
            if (this.f15559F == 0) {
                this.f15559F = elapsedRealtime;
            }
            if (this.f15560G == 0) {
                this.f15560G = elapsedRealtime;
            }
        }
    }

    private static String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str2)) {
            str2 = "IOException";
        }
        sb.append(String.format(str, new Object[]{str2}));
        sb.append(TextUtils.isEmpty(str3) ? "" : str3.replaceAll("[\\n\\r]", " "));
        return sb.toString();
    }

    public final void a(Exception exc) {
        this.f15568O = exc;
    }

    private static e a(JSONObject jSONObject, String str) {
        e eVar = new e(str);
        eVar.b(0);
        eVar.a(0);
        eVar.a(c.c());
        eVar.a(jSONObject);
        return eVar;
    }
}
