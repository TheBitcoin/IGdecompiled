package m0;

import java.util.Collection;

public abstract class v {
    private static Collection a(Iterable iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return x.g(iterable.iterator());
    }

    static Object[] b(Iterable iterable) {
        return a(iterable).toArray();
    }
}
