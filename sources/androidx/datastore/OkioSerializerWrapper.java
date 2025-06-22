package androidx.datastore;

import N3.C2515f;
import N3.C2516g;
import R2.s;
import V2.d;
import W2.b;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.okio.OkioSerializer;
import kotlin.jvm.internal.m;

public final class OkioSerializerWrapper<T> implements OkioSerializer<T> {
    private final Serializer<T> delegate;

    public OkioSerializerWrapper(Serializer<T> serializer) {
        m.e(serializer, "delegate");
        this.delegate = serializer;
    }

    public T getDefaultValue() {
        return this.delegate.getDefaultValue();
    }

    public Object readFrom(C2516g gVar, d dVar) {
        return this.delegate.readFrom(gVar.inputStream(), dVar);
    }

    public Object writeTo(T t4, C2515f fVar, d dVar) {
        Object writeTo = this.delegate.writeTo(t4, fVar.outputStream(), dVar);
        if (writeTo == b.c()) {
            return writeTo;
        }
        return s.f8222a;
    }
}
