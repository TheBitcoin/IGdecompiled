package androidx.work;

import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import androidx.work.Data;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.m;

public final class ArrayCreatingInputMerger extends InputMerger {
    private final Object concatenateArrayAndNonArray(Object obj, Object obj2, Class<?> cls) {
        int length = Array.getLength(obj);
        Object newInstance = Array.newInstance(cls, length + 1);
        System.arraycopy(obj, 0, newInstance, 0, length);
        Array.set(newInstance, length, obj2);
        m.d(newInstance, "newArray");
        return newInstance;
    }

    private final Object concatenateArrays(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        Class<?> componentType = obj.getClass().getComponentType();
        m.b(componentType);
        Object newInstance = Array.newInstance(componentType, length + length2);
        System.arraycopy(obj, 0, newInstance, 0, length);
        System.arraycopy(obj2, 0, newInstance, length, length2);
        m.d(newInstance, "newArray");
        return newInstance;
    }

    private final Object createArrayFor(Object obj, Class<?> cls) {
        Object newInstance = Array.newInstance(cls, 1);
        Array.set(newInstance, 0, obj);
        m.d(newInstance, "newArray");
        return newInstance;
    }

    public Data merge(List<Data> list) {
        Class cls;
        m.e(list, "inputs");
        Data.Builder builder = new Data.Builder();
        HashMap hashMap = new HashMap();
        for (Data keyValueMap : list) {
            Map<String, Object> keyValueMap2 = keyValueMap.getKeyValueMap();
            m.d(keyValueMap2, "input.keyValueMap");
            Iterator<Map.Entry<String, Object>> it = keyValueMap2.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry next = it.next();
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (value != null) {
                        cls = value.getClass();
                    } else {
                        cls = String.class;
                    }
                    Object obj = hashMap.get(str);
                    m.d(str, LeanbackPreferenceDialogFragment.ARG_KEY);
                    if (obj != null) {
                        Class<?> cls2 = obj.getClass();
                        if (m.a(cls2, cls)) {
                            m.d(value, "value");
                            value = concatenateArrays(obj, value);
                        } else if (m.a(cls2.getComponentType(), cls)) {
                            value = concatenateArrayAndNonArray(obj, value, cls);
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } else if (!cls.isArray()) {
                        value = createArrayFor(value, cls);
                    }
                    m.d(value, "if (existingValue == nul…      }\n                }");
                    hashMap.put(str, value);
                }
            }
        }
        builder.putAll((Map<String, Object>) hashMap);
        Data build = builder.build();
        m.d(build, "output.build()");
        return build;
    }
}
