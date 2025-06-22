package com.google.firebase.installations;

import p0.m;

public class d extends m {

    /* renamed from: a  reason: collision with root package name */
    private final a f11201a;

    public enum a {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public d(a aVar) {
        this.f11201a = aVar;
    }

    public d(String str, a aVar) {
        super(str);
        this.f11201a = aVar;
    }
}
