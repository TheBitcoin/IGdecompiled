package com.google.firebase.messaging;

import M.C0333n;
import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

final class c0 {

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f11344d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a  reason: collision with root package name */
    private final String f11345a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11346b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11347c;

    private c0(String str, String str2) {
        this.f11345a = d(str2, str);
        this.f11346b = str;
        this.f11347c = str + "!" + str2;
    }

    static c0 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("!", -1);
        if (split.length != 2) {
            return null;
        }
        return new c0(split[0], split[1]);
    }

    private static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", new Object[]{str2}));
            str = str.substring(8);
        }
        if (str != null && f11344d.matcher(str).matches()) {
            return str;
        }
        throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", new Object[]{str, "[a-zA-Z0-9-_.~%]{1,900}"}));
    }

    public String b() {
        return this.f11346b;
    }

    public String c() {
        return this.f11345a;
    }

    public String e() {
        return this.f11347c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        if (!this.f11345a.equals(c0Var.f11345a) || !this.f11346b.equals(c0Var.f11346b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return C0333n.b(this.f11346b, this.f11345a);
    }
}
