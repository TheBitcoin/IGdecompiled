package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;

public interface i0 {
    int characteristics();

    long estimateSize();

    void forEachRemaining(Consumer consumer);

    Comparator getComparator();

    long getExactSizeIfKnown();

    boolean hasCharacteristics(int i4);

    boolean tryAdvance(Consumer consumer);

    i0 trySplit();
}
