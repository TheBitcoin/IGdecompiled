package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ArrayDecoders;
import java.io.IOException;

@CheckReturnValue
interface Schema<T> {
    boolean equals(T t4, T t5);

    int getSerializedSize(T t4);

    int hashCode(T t4);

    boolean isInitialized(T t4);

    void makeImmutable(T t4);

    void mergeFrom(T t4, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void mergeFrom(T t4, T t5);

    void mergeFrom(T t4, byte[] bArr, int i4, int i5, ArrayDecoders.Registers registers) throws IOException;

    T newInstance();

    void writeTo(T t4, Writer writer) throws IOException;
}
