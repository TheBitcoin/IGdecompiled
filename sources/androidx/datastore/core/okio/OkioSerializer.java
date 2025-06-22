package androidx.datastore.core.okio;

import N3.C2515f;
import N3.C2516g;
import V2.d;

public interface OkioSerializer<T> {
    T getDefaultValue();

    Object readFrom(C2516g gVar, d dVar);

    Object writeTo(T t4, C2515f fVar, d dVar);
}
