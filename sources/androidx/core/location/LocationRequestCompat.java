package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.LocationRequest;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.util.TimeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class LocationRequestCompat {
    private static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1;
    public static final long PASSIVE_INTERVAL = Long.MAX_VALUE;
    public static final int QUALITY_BALANCED_POWER_ACCURACY = 102;
    public static final int QUALITY_HIGH_ACCURACY = 100;
    public static final int QUALITY_LOW_POWER = 104;
    final long mDurationMillis;
    final long mIntervalMillis;
    final long mMaxUpdateDelayMillis;
    final int mMaxUpdates;
    final float mMinUpdateDistanceMeters;
    final long mMinUpdateIntervalMillis;
    final int mQuality;

    private static class Api19Impl {
        private static Method sCreateFromDeprecatedProviderMethod;
        private static Class<?> sLocationRequestClass;
        private static Method sSetExpireInMethod;
        private static Method sSetFastestIntervalMethod;
        private static Method sSetNumUpdatesMethod;
        private static Method sSetQualityMethod;

        private Api19Impl() {
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static Object toLocationRequest(LocationRequestCompat locationRequestCompat, String str) {
            try {
                if (sLocationRequestClass == null) {
                    sLocationRequestClass = Class.forName("android.location.LocationRequest");
                }
                Method method = sCreateFromDeprecatedProviderMethod;
                Class cls = Long.TYPE;
                if (method == null) {
                    Method declaredMethod = sLocationRequestClass.getDeclaredMethod("createFromDeprecatedProvider", new Class[]{String.class, cls, Float.TYPE, Boolean.TYPE});
                    sCreateFromDeprecatedProviderMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                Object invoke = sCreateFromDeprecatedProviderMethod.invoke((Object) null, new Object[]{str, Long.valueOf(locationRequestCompat.getIntervalMillis()), Float.valueOf(locationRequestCompat.getMinUpdateDistanceMeters()), Boolean.FALSE});
                if (invoke == null) {
                    return null;
                }
                Method method2 = sSetQualityMethod;
                Class cls2 = Integer.TYPE;
                if (method2 == null) {
                    Method declaredMethod2 = sLocationRequestClass.getDeclaredMethod("setQuality", new Class[]{cls2});
                    sSetQualityMethod = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                sSetQualityMethod.invoke(invoke, new Object[]{Integer.valueOf(locationRequestCompat.getQuality())});
                if (sSetFastestIntervalMethod == null) {
                    Method declaredMethod3 = sLocationRequestClass.getDeclaredMethod("setFastestInterval", new Class[]{cls});
                    sSetFastestIntervalMethod = declaredMethod3;
                    declaredMethod3.setAccessible(true);
                }
                sSetFastestIntervalMethod.invoke(invoke, new Object[]{Long.valueOf(locationRequestCompat.getMinUpdateIntervalMillis())});
                if (locationRequestCompat.getMaxUpdates() < Integer.MAX_VALUE) {
                    if (sSetNumUpdatesMethod == null) {
                        Method declaredMethod4 = sLocationRequestClass.getDeclaredMethod("setNumUpdates", new Class[]{cls2});
                        sSetNumUpdatesMethod = declaredMethod4;
                        declaredMethod4.setAccessible(true);
                    }
                    sSetNumUpdatesMethod.invoke(invoke, new Object[]{Integer.valueOf(locationRequestCompat.getMaxUpdates())});
                }
                if (locationRequestCompat.getDurationMillis() < Long.MAX_VALUE) {
                    if (sSetExpireInMethod == null) {
                        Method declaredMethod5 = sLocationRequestClass.getDeclaredMethod("setExpireIn", new Class[]{cls});
                        sSetExpireInMethod = declaredMethod5;
                        declaredMethod5.setAccessible(true);
                    }
                    sSetExpireInMethod.invoke(invoke, new Object[]{Long.valueOf(locationRequestCompat.getDurationMillis())});
                }
                return invoke;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
    }

    @RequiresApi(31)
    private static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static LocationRequest toLocationRequest(LocationRequestCompat locationRequestCompat) {
            return new LocationRequest.Builder(locationRequestCompat.getIntervalMillis()).setQuality(locationRequestCompat.getQuality()).setMinUpdateIntervalMillis(locationRequestCompat.getMinUpdateIntervalMillis()).setDurationMillis(locationRequestCompat.getDurationMillis()).setMaxUpdates(locationRequestCompat.getMaxUpdates()).setMinUpdateDistanceMeters(locationRequestCompat.getMinUpdateDistanceMeters()).setMaxUpdateDelayMillis(locationRequestCompat.getMaxUpdateDelayMillis()).build();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Quality {
    }

    LocationRequestCompat(long j4, int i4, long j5, int i5, long j6, float f4, long j7) {
        this.mIntervalMillis = j4;
        this.mQuality = i4;
        this.mMinUpdateIntervalMillis = j6;
        this.mDurationMillis = j5;
        this.mMaxUpdates = i5;
        this.mMinUpdateDistanceMeters = f4;
        this.mMaxUpdateDelayMillis = j7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequestCompat)) {
            return false;
        }
        LocationRequestCompat locationRequestCompat = (LocationRequestCompat) obj;
        if (this.mQuality == locationRequestCompat.mQuality && this.mIntervalMillis == locationRequestCompat.mIntervalMillis && this.mMinUpdateIntervalMillis == locationRequestCompat.mMinUpdateIntervalMillis && this.mDurationMillis == locationRequestCompat.mDurationMillis && this.mMaxUpdates == locationRequestCompat.mMaxUpdates && Float.compare(locationRequestCompat.mMinUpdateDistanceMeters, this.mMinUpdateDistanceMeters) == 0 && this.mMaxUpdateDelayMillis == locationRequestCompat.mMaxUpdateDelayMillis) {
            return true;
        }
        return false;
    }

    @IntRange(from = 1)
    public long getDurationMillis() {
        return this.mDurationMillis;
    }

    @IntRange(from = 0)
    public long getIntervalMillis() {
        return this.mIntervalMillis;
    }

    @IntRange(from = 0)
    public long getMaxUpdateDelayMillis() {
        return this.mMaxUpdateDelayMillis;
    }

    @IntRange(from = 1, to = 2147483647L)
    public int getMaxUpdates() {
        return this.mMaxUpdates;
    }

    @FloatRange(from = 0.0d, to = 3.4028234663852886E38d)
    public float getMinUpdateDistanceMeters() {
        return this.mMinUpdateDistanceMeters;
    }

    @IntRange(from = 0)
    public long getMinUpdateIntervalMillis() {
        long j4 = this.mMinUpdateIntervalMillis;
        if (j4 == -1) {
            return this.mIntervalMillis;
        }
        return j4;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public int hashCode() {
        long j4 = this.mIntervalMillis;
        long j5 = this.mMinUpdateIntervalMillis;
        return (((this.mQuality * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)));
    }

    @RequiresApi(31)
    @NonNull
    public LocationRequest toLocationRequest() {
        return Api31Impl.toLocationRequest(this);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (this.mIntervalMillis != Long.MAX_VALUE) {
            sb.append("@");
            TimeUtils.formatDuration(this.mIntervalMillis, sb);
            int i4 = this.mQuality;
            if (i4 == 100) {
                sb.append(" HIGH_ACCURACY");
            } else if (i4 == 102) {
                sb.append(" BALANCED");
            } else if (i4 == 104) {
                sb.append(" LOW_POWER");
            }
        } else {
            sb.append("PASSIVE");
        }
        if (this.mDurationMillis != Long.MAX_VALUE) {
            sb.append(", duration=");
            TimeUtils.formatDuration(this.mDurationMillis, sb);
        }
        if (this.mMaxUpdates != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.mMaxUpdates);
        }
        long j4 = this.mMinUpdateIntervalMillis;
        if (j4 != -1 && j4 < this.mIntervalMillis) {
            sb.append(", minUpdateInterval=");
            TimeUtils.formatDuration(this.mMinUpdateIntervalMillis, sb);
        }
        if (((double) this.mMinUpdateDistanceMeters) > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.mMinUpdateDistanceMeters);
        }
        if (this.mMaxUpdateDelayMillis / 2 > this.mIntervalMillis) {
            sb.append(", maxUpdateDelay=");
            TimeUtils.formatDuration(this.mMaxUpdateDelayMillis, sb);
        }
        sb.append(']');
        return sb.toString();
    }

    @SuppressLint({"NewApi"})
    @Nullable
    public LocationRequest toLocationRequest(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return toLocationRequest();
        }
        return N.a(Api19Impl.toLocationRequest(this, str));
    }

    public static final class Builder {
        private long mDurationMillis;
        private long mIntervalMillis;
        private long mMaxUpdateDelayMillis;
        private int mMaxUpdates;
        private float mMinUpdateDistanceMeters;
        private long mMinUpdateIntervalMillis;
        private int mQuality;

        public Builder(long j4) {
            setIntervalMillis(j4);
            this.mQuality = 102;
            this.mDurationMillis = Long.MAX_VALUE;
            this.mMaxUpdates = Integer.MAX_VALUE;
            this.mMinUpdateIntervalMillis = -1;
            this.mMinUpdateDistanceMeters = 0.0f;
            this.mMaxUpdateDelayMillis = 0;
        }

        @NonNull
        public LocationRequestCompat build() {
            boolean z4;
            if (this.mIntervalMillis == Long.MAX_VALUE && this.mMinUpdateIntervalMillis == -1) {
                z4 = false;
            } else {
                z4 = true;
            }
            Preconditions.checkState(z4, "passive location requests must have an explicit minimum update interval");
            long j4 = this.mIntervalMillis;
            return new LocationRequestCompat(j4, this.mQuality, this.mDurationMillis, this.mMaxUpdates, Math.min(this.mMinUpdateIntervalMillis, j4), this.mMinUpdateDistanceMeters, this.mMaxUpdateDelayMillis);
        }

        @NonNull
        public Builder clearMinUpdateIntervalMillis() {
            this.mMinUpdateIntervalMillis = -1;
            return this;
        }

        @NonNull
        public Builder setDurationMillis(@IntRange(from = 1) long j4) {
            this.mDurationMillis = Preconditions.checkArgumentInRange(j4, 1, Long.MAX_VALUE, "durationMillis");
            return this;
        }

        @NonNull
        public Builder setIntervalMillis(@IntRange(from = 0) long j4) {
            this.mIntervalMillis = Preconditions.checkArgumentInRange(j4, 0, Long.MAX_VALUE, "intervalMillis");
            return this;
        }

        @NonNull
        public Builder setMaxUpdateDelayMillis(@IntRange(from = 0) long j4) {
            this.mMaxUpdateDelayMillis = j4;
            this.mMaxUpdateDelayMillis = Preconditions.checkArgumentInRange(j4, 0, Long.MAX_VALUE, "maxUpdateDelayMillis");
            return this;
        }

        @NonNull
        public Builder setMaxUpdates(@IntRange(from = 1, to = 2147483647L) int i4) {
            this.mMaxUpdates = Preconditions.checkArgumentInRange(i4, 1, Integer.MAX_VALUE, "maxUpdates");
            return this;
        }

        @NonNull
        public Builder setMinUpdateDistanceMeters(@FloatRange(from = 0.0d, to = 3.4028234663852886E38d) float f4) {
            this.mMinUpdateDistanceMeters = f4;
            this.mMinUpdateDistanceMeters = Preconditions.checkArgumentInRange(f4, 0.0f, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        @NonNull
        public Builder setMinUpdateIntervalMillis(@IntRange(from = 0) long j4) {
            this.mMinUpdateIntervalMillis = Preconditions.checkArgumentInRange(j4, 0, Long.MAX_VALUE, "minUpdateIntervalMillis");
            return this;
        }

        @NonNull
        public Builder setQuality(int i4) {
            boolean z4;
            if (i4 == 104 || i4 == 102 || i4 == 100) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "quality must be a defined QUALITY constant, not %d", Integer.valueOf(i4));
            this.mQuality = i4;
            return this;
        }

        public Builder(@NonNull LocationRequestCompat locationRequestCompat) {
            this.mIntervalMillis = locationRequestCompat.mIntervalMillis;
            this.mQuality = locationRequestCompat.mQuality;
            this.mDurationMillis = locationRequestCompat.mDurationMillis;
            this.mMaxUpdates = locationRequestCompat.mMaxUpdates;
            this.mMinUpdateIntervalMillis = locationRequestCompat.mMinUpdateIntervalMillis;
            this.mMinUpdateDistanceMeters = locationRequestCompat.mMinUpdateDistanceMeters;
            this.mMaxUpdateDelayMillis = locationRequestCompat.mMaxUpdateDelayMillis;
        }
    }
}
