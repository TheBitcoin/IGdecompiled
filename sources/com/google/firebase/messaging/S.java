package com.google.firebase.messaging;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.C1791e;
import java.util.Map;

public final class S extends N.a {
    public static final Parcelable.Creator<S> CREATOR = new T();

    /* renamed from: a  reason: collision with root package name */
    Bundle f11265a;

    /* renamed from: b  reason: collision with root package name */
    private Map f11266b;

    /* renamed from: c  reason: collision with root package name */
    private b f11267c;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f11268a;

        /* renamed from: b  reason: collision with root package name */
        private final String f11269b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f11270c;

        /* renamed from: d  reason: collision with root package name */
        private final String f11271d;

        /* renamed from: e  reason: collision with root package name */
        private final String f11272e;

        /* renamed from: f  reason: collision with root package name */
        private final String[] f11273f;

        /* renamed from: g  reason: collision with root package name */
        private final String f11274g;

        /* renamed from: h  reason: collision with root package name */
        private final String f11275h;

        /* renamed from: i  reason: collision with root package name */
        private final String f11276i;

        /* renamed from: j  reason: collision with root package name */
        private final String f11277j;

        /* renamed from: k  reason: collision with root package name */
        private final String f11278k;

        /* renamed from: l  reason: collision with root package name */
        private final String f11279l;

        /* renamed from: m  reason: collision with root package name */
        private final String f11280m;

        /* renamed from: n  reason: collision with root package name */
        private final Uri f11281n;

        /* renamed from: o  reason: collision with root package name */
        private final String f11282o;

        /* renamed from: p  reason: collision with root package name */
        private final Integer f11283p;

        /* renamed from: q  reason: collision with root package name */
        private final Integer f11284q;

        /* renamed from: r  reason: collision with root package name */
        private final Integer f11285r;

        /* renamed from: s  reason: collision with root package name */
        private final int[] f11286s;

        /* renamed from: t  reason: collision with root package name */
        private final Long f11287t;

        /* renamed from: u  reason: collision with root package name */
        private final boolean f11288u;

        /* renamed from: v  reason: collision with root package name */
        private final boolean f11289v;

        /* renamed from: w  reason: collision with root package name */
        private final boolean f11290w;

        /* renamed from: x  reason: collision with root package name */
        private final boolean f11291x;

        /* renamed from: y  reason: collision with root package name */
        private final boolean f11292y;

        /* renamed from: z  reason: collision with root package name */
        private final long[] f11293z;

        private static String[] b(J j4, String str) {
            Object[] g4 = j4.g(str);
            if (g4 == null) {
                return null;
            }
            String[] strArr = new String[g4.length];
            for (int i4 = 0; i4 < g4.length; i4++) {
                strArr[i4] = String.valueOf(g4[i4]);
            }
            return strArr;
        }

        public String a() {
            return this.f11271d;
        }

        public String c() {
            return this.f11268a;
        }

        private b(J j4) {
            this.f11268a = j4.p("gcm.n.title");
            this.f11269b = j4.h("gcm.n.title");
            this.f11270c = b(j4, "gcm.n.title");
            this.f11271d = j4.p("gcm.n.body");
            this.f11272e = j4.h("gcm.n.body");
            this.f11273f = b(j4, "gcm.n.body");
            this.f11274g = j4.p("gcm.n.icon");
            this.f11276i = j4.o();
            this.f11277j = j4.p("gcm.n.tag");
            this.f11278k = j4.p("gcm.n.color");
            this.f11279l = j4.p("gcm.n.click_action");
            this.f11280m = j4.p("gcm.n.android_channel_id");
            this.f11281n = j4.f();
            this.f11275h = j4.p("gcm.n.image");
            this.f11282o = j4.p("gcm.n.ticker");
            this.f11283p = j4.b("gcm.n.notification_priority");
            this.f11284q = j4.b("gcm.n.visibility");
            this.f11285r = j4.b("gcm.n.notification_count");
            this.f11288u = j4.a("gcm.n.sticky");
            this.f11289v = j4.a("gcm.n.local_only");
            this.f11290w = j4.a("gcm.n.default_sound");
            this.f11291x = j4.a("gcm.n.default_vibrate_timings");
            this.f11292y = j4.a("gcm.n.default_light_settings");
            this.f11287t = j4.j("gcm.n.event_time");
            this.f11286s = j4.e();
            this.f11293z = j4.q();
        }
    }

    public S(Bundle bundle) {
        this.f11265a = bundle;
    }

    public Map c() {
        if (this.f11266b == null) {
            this.f11266b = C1791e.a.a(this.f11265a);
        }
        return this.f11266b;
    }

    public b g() {
        if (this.f11267c == null && J.t(this.f11265a)) {
            this.f11267c = new b(new J(this.f11265a));
        }
        return this.f11267c;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        T.c(this, parcel, i4);
    }
}
