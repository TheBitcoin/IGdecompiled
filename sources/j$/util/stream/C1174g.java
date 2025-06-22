package j$.util.stream;

import j$.util.i0;
import java.util.Iterator;

/* renamed from: j$.util.stream.g  reason: case insensitive filesystem */
public interface C1174g extends AutoCloseable {
    boolean isParallel();

    Iterator iterator();

    C1174g onClose(Runnable runnable);

    C1174g parallel();

    C1174g sequential();

    i0 spliterator();

    C1174g unordered();
}
