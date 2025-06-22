package androidx.datastore.core;

import V2.d;
import java.io.InputStream;
import java.io.OutputStream;

public interface Serializer<T> {
    T getDefaultValue();

    Object readFrom(InputStream inputStream, d dVar);

    Object writeTo(T t4, OutputStream outputStream, d dVar);
}
