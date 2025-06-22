package androidx.datastore.preferences.protobuf;

import java.util.List;

public interface FieldMaskOrBuilder extends MessageLiteOrBuilder {
    String getPaths(int i4);

    ByteString getPathsBytes(int i4);

    int getPathsCount();

    List<String> getPathsList();
}
