package m0;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

abstract class H {
    static Object[] a(Object[] objArr, int i4, int i5, Object[] objArr2) {
        return Arrays.copyOfRange(objArr, i4, i5, objArr2.getClass());
    }

    static Object[] b(Object[] objArr, int i4) {
        return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i4);
    }

    static Map c() {
        return C2141i.s();
    }
}
