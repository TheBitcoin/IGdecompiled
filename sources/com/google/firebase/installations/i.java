package com.google.firebase.installations;

import T0.d;
import V0.a;
import V0.b;
import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class i {

    /* renamed from: b  reason: collision with root package name */
    public static final long f11209b = TimeUnit.HOURS.toSeconds(1);

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f11210c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* renamed from: d  reason: collision with root package name */
    private static i f11211d;

    /* renamed from: a  reason: collision with root package name */
    private final a f11212a;

    private i(a aVar) {
        this.f11212a = aVar;
    }

    public static i c() {
        return d(b.a());
    }

    public static i d(a aVar) {
        if (f11211d == null) {
            f11211d = new i(aVar);
        }
        return f11211d;
    }

    static boolean g(String str) {
        return f11210c.matcher(str).matches();
    }

    static boolean h(String str) {
        return str.contains(":");
    }

    public long a() {
        return this.f11212a.currentTimeMillis();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(d dVar) {
        if (!TextUtils.isEmpty(dVar.b()) && dVar.h() + dVar.c() >= b() + f11209b) {
            return false;
        }
        return true;
    }
}
