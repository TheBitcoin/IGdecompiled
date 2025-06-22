package com.mbridge.msdk.tracker.network;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.tracker.network.ae;
import com.mbridge.msdk.tracker.network.b;
import com.mbridge.msdk.tracker.network.toolbox.e;
import com.mbridge.msdk.tracker.network.w;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class u<T> implements Comparable<u<T>> {

    /* renamed from: a  reason: collision with root package name */
    private c f15625a;

    /* renamed from: b  reason: collision with root package name */
    private String f15626b;

    /* renamed from: c  reason: collision with root package name */
    private volatile q f15627c;

    /* renamed from: d  reason: collision with root package name */
    private long f15628d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f15629e;

    /* renamed from: f  reason: collision with root package name */
    private final ae.a f15630f;

    /* renamed from: g  reason: collision with root package name */
    private int f15631g;

    /* renamed from: h  reason: collision with root package name */
    private final String f15632h;

    /* renamed from: i  reason: collision with root package name */
    private final int f15633i;

    /* renamed from: j  reason: collision with root package name */
    private final String f15634j;

    /* renamed from: k  reason: collision with root package name */
    private final int f15635k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f15636l;

    /* renamed from: m  reason: collision with root package name */
    private w.a f15637m;

    /* renamed from: n  reason: collision with root package name */
    private Integer f15638n;

    /* renamed from: o  reason: collision with root package name */
    private v f15639o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f15640p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f15641q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f15642r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f15643s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f15644t;

    /* renamed from: u  reason: collision with root package name */
    private z f15645u;

    /* renamed from: v  reason: collision with root package name */
    private b.a f15646v;

    /* renamed from: w  reason: collision with root package name */
    private a f15647w;

    /* renamed from: x  reason: collision with root package name */
    private long f15648x;

    interface a {
        void a(u<?> uVar);

        void a(u<?> uVar, w<?> wVar);
    }

    public enum b {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public u(int i4, String str) {
        this(i4, str, 0);
    }

    /* access modifiers changed from: protected */
    public abstract w<T> a(r rVar);

    /* access modifiers changed from: protected */
    public Map<String, String> a() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t4);

    /* access modifiers changed from: package-private */
    public final void b(int i4) {
        v vVar = this.f15639o;
        if (vVar != null) {
            vVar.a(this, i4);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(String str) {
        v vVar = this.f15639o;
        if (vVar != null) {
            vVar.b(this);
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        u uVar = (u) obj;
        b e5 = e();
        b e6 = uVar.e();
        if (e5 == e6) {
            return this.f15638n.intValue() - uVar.f15638n.intValue();
        }
        return e6.ordinal() - e5.ordinal();
    }

    public boolean d() {
        return false;
    }

    public b e() {
        return b.NORMAL;
    }

    public final String f() {
        return this.f15634j;
    }

    public final long g() {
        return SystemClock.elapsedRealtime() - this.f15628d;
    }

    public final int h() {
        return this.f15633i;
    }

    public final int i() {
        return this.f15631g;
    }

    public final int j() {
        return this.f15635k;
    }

    public final String k() {
        return this.f15632h;
    }

    public final String l() {
        if (!TextUtils.isEmpty(this.f15626b)) {
            return this.f15626b;
        }
        if (this.f15625a == null) {
            this.f15625a = new e();
        }
        String a5 = this.f15625a.a(this);
        this.f15626b = a5;
        return a5;
    }

    public final b.a m() {
        return this.f15646v;
    }

    public final boolean n() {
        boolean z4;
        synchronized (this.f15636l) {
            z4 = this.f15641q;
        }
        return z4;
    }

    public final String o() {
        return "application/x-www-form-urlencoded; charset=" + C.UTF8_NAME;
    }

    public final byte[] p() {
        Map<String, String> a5 = a();
        if (a5 == null || a5.size() <= 0) {
            this.f15648x = 0;
            return null;
        }
        byte[] a6 = a(a5, C.UTF8_NAME);
        this.f15648x = (long) a6.length;
        return a6;
    }

    public final long q() {
        return this.f15648x;
    }

    public final boolean r() {
        return this.f15640p;
    }

    public final boolean s() {
        return this.f15643s;
    }

    public final boolean t() {
        return this.f15644t;
    }

    public String toString() {
        String str;
        String str2 = "0x" + Integer.toHexString(this.f15635k);
        StringBuilder sb = new StringBuilder();
        if (n()) {
            str = "[X] ";
        } else {
            str = "[ ] ";
        }
        sb.append(str);
        sb.append(this.f15632h);
        sb.append(" ");
        sb.append(str2);
        sb.append(" ");
        sb.append(e());
        sb.append(" ");
        sb.append(this.f15638n);
        return sb.toString();
    }

    public final int u() {
        z b5 = b();
        if (b5 == null) {
            return 30000;
        }
        return b5.a();
    }

    public final long v() {
        z b5 = b();
        if (b5 == null) {
            return WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        }
        long b6 = b5.b();
        if (b6 < 0) {
            return WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        }
        return b6;
    }

    public final void w() {
        synchronized (this.f15636l) {
            this.f15642r = true;
        }
    }

    public final boolean x() {
        boolean z4;
        synchronized (this.f15636l) {
            z4 = this.f15642r;
        }
        return z4;
    }

    /* access modifiers changed from: package-private */
    public final void y() {
        a aVar;
        synchronized (this.f15636l) {
            aVar = this.f15647w;
        }
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final q z() {
        return this.f15627c;
    }

    public u(int i4, String str, int i5) {
        this(i4, str, i5, "un_known");
    }

    public final void a(w.a aVar) {
        this.f15637m = aVar;
    }

    public final u<?> d(boolean z4) {
        this.f15644t = z4;
        return this;
    }

    public u(int i4, String str, int i5, String str2) {
        Uri parse;
        String host;
        this.f15630f = null;
        this.f15636l = new Object();
        int i6 = 0;
        this.f15640p = false;
        this.f15641q = false;
        this.f15642r = false;
        this.f15643s = false;
        this.f15644t = false;
        this.f15646v = null;
        this.f15648x = 0;
        this.f15631g = i4;
        this.f15632h = str;
        this.f15633i = i5;
        this.f15634j = str2;
        this.f15645u = new e();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i6 = host.hashCode();
        }
        this.f15635k = i6;
        this.f15628d = SystemClock.elapsedRealtime();
    }

    public final void a(int i4) {
        this.f15631g = i4;
    }

    public final u<?> b(boolean z4) {
        this.f15640p = z4;
        return this;
    }

    public final u<?> c(int i4) {
        this.f15638n = Integer.valueOf(i4);
        return this;
    }

    public final String d(String str) {
        if (this.f15629e != null && !TextUtils.isEmpty(str)) {
            try {
                return this.f15629e.get(str);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public final u<?> a(v vVar) {
        this.f15639o = vVar;
        return this;
    }

    public z b() {
        return this.f15645u;
    }

    public Map<String, String> c() {
        return Collections.EMPTY_MAP;
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            int i4 = 0;
            for (Map.Entry next : map.entrySet()) {
                i4++;
                if (next.getKey() != null) {
                    sb.append(URLEncoder.encode((String) next.getKey(), str));
                    sb.append('=');
                    sb.append(URLEncoder.encode(next.getValue() == null ? "" : (String) next.getValue(), str));
                    if (i4 <= map.size() - 1) {
                        sb.append('&');
                    }
                }
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e5) {
            throw new RuntimeException("Encoding not supported: " + str, e5);
        }
    }

    public final void b(ad adVar) {
        w.a aVar;
        synchronized (this.f15636l) {
            aVar = this.f15637m;
        }
        if (aVar != null) {
            aVar.a(adVar);
        }
    }

    public final u<?> c(boolean z4) {
        this.f15643s = z4;
        return this;
    }

    public final void c(String str, String str2) {
        if (this.f15629e == null) {
            this.f15629e = new HashMap();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.f15629e.put(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(w<?> wVar) {
        a aVar;
        synchronized (this.f15636l) {
            aVar = this.f15647w;
        }
        if (aVar != null) {
            aVar.a(this, wVar);
        }
    }

    public final void a(q qVar) {
        this.f15627c = qVar;
    }
}
