package androidx.work;

import androidx.work.Data;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.m;

public final class OverwritingInputMerger extends InputMerger {
    public Data merge(List<Data> list) {
        m.e(list, "inputs");
        Data.Builder builder = new Data.Builder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Data keyValueMap : list) {
            Map<String, Object> keyValueMap2 = keyValueMap.getKeyValueMap();
            m.d(keyValueMap2, "input.keyValueMap");
            linkedHashMap.putAll(keyValueMap2);
        }
        builder.putAll((Map<String, Object>) linkedHashMap);
        Data build = builder.build();
        m.d(build, "output.build()");
        return build;
    }
}
