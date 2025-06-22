package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(21)
@SuppressLint({"SoonBlockedPrivateApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class WeightTypefaceApi21 {
    private static final String NATIVE_CREATE_FROM_TYPEFACE_METHOD = "nativeCreateFromTypeface";
    private static final String NATIVE_CREATE_WEIGHT_ALIAS_METHOD = "nativeCreateWeightAlias";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor<Typeface> sConstructor;
    private static final Method sNativeCreateFromTypeface;
    private static final Method sNativeCreateWeightAlias;
    private static final Field sNativeInstance;
    private static final Object sWeightCacheLock = new Object();
    @GuardedBy("sWeightCacheLock")
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache = new LongSparseArray<>(3);

    static {
        Method method;
        Field field;
        Constructor<Typeface> constructor;
        Method method2;
        Class<Typeface> cls = Typeface.class;
        try {
            field = cls.getDeclaredField(NATIVE_INSTANCE_FIELD);
            Class cls2 = Long.TYPE;
            Class cls3 = Integer.TYPE;
            try {
                method = cls.getDeclaredMethod(NATIVE_CREATE_FROM_TYPEFACE_METHOD, new Class[]{cls2, cls3});
                method.setAccessible(true);
                method2 = cls.getDeclaredMethod(NATIVE_CREATE_WEIGHT_ALIAS_METHOD, new Class[]{cls2, cls3});
                method2.setAccessible(true);
                constructor = cls.getDeclaredConstructor(new Class[]{cls2});
                constructor.setAccessible(true);
            } catch (NoSuchMethodException e5) {
                e = e5;
                Log.e(TAG, e.getClass().getName(), e);
                field = null;
                method2 = null;
                constructor = null;
                method = null;
                sNativeInstance = field;
                sNativeCreateFromTypeface = method;
                sNativeCreateWeightAlias = method2;
                sConstructor = constructor;
            }
        } catch (NoSuchFieldException | NoSuchMethodException e6) {
            e = e6;
        }
        sNativeInstance = field;
        sNativeCreateFromTypeface = method;
        sNativeCreateWeightAlias = method2;
        sConstructor = constructor;
    }

    private WeightTypefaceApi21() {
    }

    @Nullable
    private static Typeface create(long j4) {
        try {
            return sConstructor.newInstance(new Object[]{Long.valueOf(j4)});
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Nullable
    static Typeface createWeightStyle(@NonNull Typeface typeface, int i4, boolean z4) {
        Typeface typeface2;
        if (!isPrivateApiAvailable()) {
            return null;
        }
        boolean z5 = (i4 << 1) | z4;
        synchronized (sWeightCacheLock) {
            try {
                long nativeInstance = getNativeInstance(typeface);
                LongSparseArray<SparseArray<Typeface>> longSparseArray = sWeightTypefaceCache;
                SparseArray sparseArray = longSparseArray.get(nativeInstance);
                if (sparseArray == null) {
                    sparseArray = new SparseArray(4);
                    longSparseArray.put(nativeInstance, sparseArray);
                } else {
                    Typeface typeface3 = (Typeface) sparseArray.get(z5);
                    if (typeface3 != null) {
                        return typeface3;
                    }
                }
                if (z4 == typeface.isItalic()) {
                    typeface2 = create(nativeCreateWeightAlias(nativeInstance, i4));
                } else {
                    typeface2 = create(nativeCreateFromTypefaceWithExactStyle(nativeInstance, i4, z4));
                }
                sparseArray.put(z5 ? 1 : 0, typeface2);
                return typeface2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static long getNativeInstance(@NonNull Typeface typeface) {
        try {
            return sNativeInstance.getLong(typeface);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(e5);
        }
    }

    private static boolean isPrivateApiAvailable() {
        if (sNativeInstance != null) {
            return true;
        }
        return false;
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static long nativeCreateFromTypefaceWithExactStyle(long j4, int i4, boolean z4) {
        int i5;
        if (z4) {
            i5 = 2;
        } else {
            i5 = 0;
        }
        try {
            Long l4 = (Long) sNativeCreateFromTypeface.invoke((Object) null, new Object[]{Long.valueOf(j4), Integer.valueOf(i5)});
            l4.longValue();
            return ((Long) sNativeCreateWeightAlias.invoke((Object) null, new Object[]{l4, Integer.valueOf(i4)})).longValue();
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static long nativeCreateWeightAlias(long j4, int i4) {
        try {
            return ((Long) sNativeCreateWeightAlias.invoke((Object) null, new Object[]{Long.valueOf(j4), Integer.valueOf(i4)})).longValue();
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }
}
