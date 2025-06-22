package U;

import M.C0335p;
import U.a;
import android.os.IBinder;
import java.lang.reflect.Field;

public final class b extends a.C0004a {

    /* renamed from: a  reason: collision with root package name */
    private final Object f640a;

    private b(Object obj) {
        this.f640a = obj;
    }

    public static Object k(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f640a;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i4 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i4++;
                field = field2;
            }
        }
        if (i4 == 1) {
            C0335p.l(field);
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return field.get(asBinder);
                } catch (NullPointerException e5) {
                    throw new IllegalArgumentException("Binder object is null.", e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e6);
                }
            } else {
                throw new IllegalArgumentException("IObjectWrapper declared field not private!");
            }
        } else {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
    }

    public static a l0(Object obj) {
        return new b(obj);
    }
}
