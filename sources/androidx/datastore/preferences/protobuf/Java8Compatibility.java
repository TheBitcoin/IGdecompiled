package androidx.datastore.preferences.protobuf;

import java.nio.Buffer;

final class Java8Compatibility {
    private Java8Compatibility() {
    }

    static void clear(Buffer buffer) {
        buffer.clear();
    }

    static void flip(Buffer buffer) {
        buffer.flip();
    }

    static void limit(Buffer buffer, int i4) {
        buffer.limit(i4);
    }

    static void mark(Buffer buffer) {
        buffer.mark();
    }

    static void position(Buffer buffer, int i4) {
        buffer.position(i4);
    }

    static void reset(Buffer buffer) {
        buffer.reset();
    }
}
