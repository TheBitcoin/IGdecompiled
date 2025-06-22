package androidx.datastore.preferences.protobuf;

import java.util.List;

public interface ListValueOrBuilder extends MessageLiteOrBuilder {
    Value getValues(int i4);

    int getValuesCount();

    List<Value> getValuesList();
}
