package com.mbridge.msdk.mbsignalcommon.windvane;

public enum e {
    JS("js", "application/x-javascript"),
    CSS("css", "text/css"),
    JPG("jpg", "image/jpeg"),
    JPEG("jpep", "image/jpeg"),
    PNG("png", "image/png"),
    WEBP("webp", "image/webp"),
    GIF("gif", "image/gif"),
    HTM("htm", "text/html"),
    HTML("html", "text/html");
    

    /* renamed from: j  reason: collision with root package name */
    private String f14166j;

    /* renamed from: k  reason: collision with root package name */
    private String f14167k;

    private e(String str, String str2) {
        this.f14166j = str;
        this.f14167k = str2;
    }

    public final String a() {
        return this.f14166j;
    }

    public final String b() {
        return this.f14167k;
    }
}
