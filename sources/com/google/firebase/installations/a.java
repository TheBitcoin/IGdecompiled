package com.google.firebase.installations;

import com.google.firebase.installations.g;

final class a extends g {

    /* renamed from: a  reason: collision with root package name */
    private final String f11176a;

    /* renamed from: b  reason: collision with root package name */
    private final long f11177b;

    /* renamed from: c  reason: collision with root package name */
    private final long f11178c;

    static final class b extends g.a {

        /* renamed from: a  reason: collision with root package name */
        private String f11179a;

        /* renamed from: b  reason: collision with root package name */
        private Long f11180b;

        /* renamed from: c  reason: collision with root package name */
        private Long f11181c;

        b() {
        }

        public g a() {
            String str = "";
            if (this.f11179a == null) {
                str = str + " token";
            }
            if (this.f11180b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f11181c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new a(this.f11179a, this.f11180b.longValue(), this.f11181c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public g.a b(String str) {
            if (str != null) {
                this.f11179a = str;
                return this;
            }
            throw new NullPointerException("Null token");
        }

        public g.a c(long j4) {
            this.f11181c = Long.valueOf(j4);
            return this;
        }

        public g.a d(long j4) {
            this.f11180b = Long.valueOf(j4);
            return this;
        }
    }

    public String b() {
        return this.f11176a;
    }

    public long c() {
        return this.f11178c;
    }

    public long d() {
        return this.f11177b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.f11176a.equals(gVar.b()) && this.f11177b == gVar.d() && this.f11178c == gVar.c()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f11177b;
        long j5 = this.f11178c;
        return ((((this.f11176a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f11176a + ", tokenExpirationTimestamp=" + this.f11177b + ", tokenCreationTimestamp=" + this.f11178c + "}";
    }

    private a(String str, long j4, long j5) {
        this.f11176a = str;
        this.f11177b = j4;
        this.f11178c = j5;
    }
}
