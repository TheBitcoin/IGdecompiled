package com.google.gson.internal.sql;

import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.r;
import java.sql.Date;
import java.sql.Timestamp;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11727a;

    /* renamed from: b  reason: collision with root package name */
    public static final DefaultDateTypeAdapter.a f11728b;

    /* renamed from: c  reason: collision with root package name */
    public static final DefaultDateTypeAdapter.a f11729c;

    /* renamed from: d  reason: collision with root package name */
    public static final r f11730d;

    /* renamed from: e  reason: collision with root package name */
    public static final r f11731e;

    /* renamed from: f  reason: collision with root package name */
    public static final r f11732f;

    /* renamed from: com.google.gson.internal.sql.a$a  reason: collision with other inner class name */
    class C0172a extends DefaultDateTypeAdapter.a {
        C0172a(Class cls) {
            super(cls);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Date a(java.util.Date date) {
            return new Date(date.getTime());
        }
    }

    class b extends DefaultDateTypeAdapter.a {
        b(Class cls) {
            super(cls);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Timestamp a(java.util.Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z4;
        try {
            Class.forName("java.sql.Date");
            z4 = true;
        } catch (ClassNotFoundException unused) {
            z4 = false;
        }
        f11727a = z4;
        if (z4) {
            f11728b = new C0172a(Date.class);
            f11729c = new b(Timestamp.class);
            f11730d = SqlDateTypeAdapter.f11721b;
            f11731e = SqlTimeTypeAdapter.f11723b;
            f11732f = SqlTimestampTypeAdapter.f11725b;
            return;
        }
        f11728b = null;
        f11729c = null;
        f11730d = null;
        f11731e = null;
        f11732f = null;
    }
}
