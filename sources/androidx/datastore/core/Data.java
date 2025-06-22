package androidx.datastore.core;

import kotlin.jvm.internal.C2103g;

public final class Data<T> extends State<T> {
    private final int hashCode;
    private final T value;

    public Data(T t4, int i4, int i5) {
        super(i5, (C2103g) null);
        this.value = t4;
        this.hashCode = i4;
    }

    public final void checkHashCode() {
        int i4;
        T t4 = this.value;
        if (t4 != null) {
            i4 = t4.hashCode();
        } else {
            i4 = 0;
        }
        if (i4 != this.hashCode) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.");
        }
    }

    public final int getHashCode() {
        return this.hashCode;
    }

    public final T getValue() {
        return this.value;
    }
}
