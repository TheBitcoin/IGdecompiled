package com.google.android.gms.internal.measurement;

import java.io.IOException;

public class B4 extends IOException {
    public B4(String str) {
        super(str);
    }

    static E4 a() {
        return new E4("Protocol message tag had invalid wire type.");
    }

    static B4 b() {
        return new B4("Protocol message contained an invalid tag (zero).");
    }

    static B4 c() {
        return new B4("Protocol message had invalid UTF-8.");
    }

    static B4 d() {
        return new B4("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static B4 e() {
        return new B4("Failed to parse the message.");
    }

    static B4 f() {
        return new B4("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    static B4 g() {
        return new B4("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
