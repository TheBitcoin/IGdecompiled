package com.mbridge.msdk.click.entity;

import androidx.annotation.NonNull;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f12061a;

    /* renamed from: b  reason: collision with root package name */
    public String f12062b;

    /* renamed from: c  reason: collision with root package name */
    public String f12063c;

    /* renamed from: d  reason: collision with root package name */
    public String f12064d;

    /* renamed from: e  reason: collision with root package name */
    public int f12065e;

    /* renamed from: f  reason: collision with root package name */
    public int f12066f;

    /* renamed from: g  reason: collision with root package name */
    public String f12067g;

    /* renamed from: h  reason: collision with root package name */
    public String f12068h;

    public final String a() {
        return "statusCode=" + this.f12066f + ", location=" + this.f12061a + ", contentType=" + this.f12062b + ", contentLength=" + this.f12065e + ", contentEncoding=" + this.f12063c + ", referer=" + this.f12064d;
    }

    @NonNull
    public final String toString() {
        return "ClickResponseHeader{location='" + this.f12061a + '\'' + ", contentType='" + this.f12062b + '\'' + ", contentEncoding='" + this.f12063c + '\'' + ", referer='" + this.f12064d + '\'' + ", contentLength=" + this.f12065e + ", statusCode=" + this.f12066f + ", url='" + this.f12067g + '\'' + ", exception='" + this.f12068h + '\'' + '}';
    }
}
