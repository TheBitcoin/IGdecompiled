package androidx.work;

import S2.C1601o;
import S2.N;
import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.privacysandbox.ads.adservices.adid.a;
import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.work.impl.utils.DurationApi26Impl;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import j$.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class Constraints {
    public static final Companion Companion = new Companion((C2103g) null);
    public static final Constraints NONE = new Constraints((NetworkType) null, false, false, false, 15, (C2103g) null);
    @ColumnInfo(name = "trigger_max_content_delay")
    private final long contentTriggerMaxDelayMillis;
    @ColumnInfo(name = "trigger_content_update_delay")
    private final long contentTriggerUpdateDelayMillis;
    @ColumnInfo(name = "content_uri_triggers")
    private final Set<ContentUriTrigger> contentUriTriggers;
    @ColumnInfo(name = "required_network_type")
    private final NetworkType requiredNetworkType;
    @ColumnInfo(name = "requires_battery_not_low")
    private final boolean requiresBatteryNotLow;
    @ColumnInfo(name = "requires_charging")
    private final boolean requiresCharging;
    @ColumnInfo(name = "requires_device_idle")
    private final boolean requiresDeviceIdle;
    @ColumnInfo(name = "requires_storage_not_low")
    private final boolean requiresStorageNotLow;

    public static final class Builder {
        private Set<ContentUriTrigger> contentUriTriggers = new LinkedHashSet();
        private NetworkType requiredNetworkType = NetworkType.NOT_REQUIRED;
        private boolean requiresBatteryNotLow;
        private boolean requiresCharging;
        private boolean requiresDeviceIdle;
        private boolean requiresStorageNotLow;
        private long triggerContentMaxDelay = -1;
        private long triggerContentUpdateDelay = -1;

        public Builder() {
        }

        @RequiresApi(24)
        public final Builder addContentUriTrigger(Uri uri, boolean z4) {
            m.e(uri, "uri");
            this.contentUriTriggers.add(new ContentUriTrigger(uri, z4));
            return this;
        }

        public final Constraints build() {
            Set d5;
            long j4;
            long j5;
            boolean z4;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 24) {
                d5 = C1601o.d0(this.contentUriTriggers);
                j4 = this.triggerContentUpdateDelay;
                j5 = this.triggerContentMaxDelay;
            } else {
                d5 = N.d();
                j4 = -1;
                j5 = -1;
            }
            Set set = d5;
            boolean z5 = this.requiresCharging;
            if (i4 < 23 || !this.requiresDeviceIdle) {
                z4 = false;
            } else {
                z4 = true;
            }
            return new Constraints(this.requiredNetworkType, z5, z4, this.requiresBatteryNotLow, this.requiresStorageNotLow, j4, j5, set);
        }

        public final Builder setRequiredNetworkType(NetworkType networkType) {
            m.e(networkType, "networkType");
            this.requiredNetworkType = networkType;
            return this;
        }

        public final Builder setRequiresBatteryNotLow(boolean z4) {
            this.requiresBatteryNotLow = z4;
            return this;
        }

        public final Builder setRequiresCharging(boolean z4) {
            this.requiresCharging = z4;
            return this;
        }

        @RequiresApi(23)
        public final Builder setRequiresDeviceIdle(boolean z4) {
            this.requiresDeviceIdle = z4;
            return this;
        }

        public final Builder setRequiresStorageNotLow(boolean z4) {
            this.requiresStorageNotLow = z4;
            return this;
        }

        @RequiresApi(24)
        public final Builder setTriggerContentMaxDelay(long j4, TimeUnit timeUnit) {
            m.e(timeUnit, "timeUnit");
            this.triggerContentMaxDelay = timeUnit.toMillis(j4);
            return this;
        }

        @RequiresApi(24)
        public final Builder setTriggerContentUpdateDelay(long j4, TimeUnit timeUnit) {
            m.e(timeUnit, "timeUnit");
            this.triggerContentUpdateDelay = timeUnit.toMillis(j4);
            return this;
        }

        @RequiresApi(26)
        public final Builder setTriggerContentMaxDelay(Duration duration) {
            m.e(duration, TypedValues.TransitionType.S_DURATION);
            this.triggerContentMaxDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }

        @RequiresApi(26)
        public final Builder setTriggerContentUpdateDelay(Duration duration) {
            m.e(duration, TypedValues.TransitionType.S_DURATION);
            this.triggerContentUpdateDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(Constraints constraints) {
            m.e(constraints, "constraints");
            this.requiresCharging = constraints.requiresCharging();
            int i4 = Build.VERSION.SDK_INT;
            this.requiresDeviceIdle = i4 >= 23 && constraints.requiresDeviceIdle();
            this.requiredNetworkType = constraints.getRequiredNetworkType();
            this.requiresBatteryNotLow = constraints.requiresBatteryNotLow();
            this.requiresStorageNotLow = constraints.requiresStorageNotLow();
            if (i4 >= 24) {
                this.triggerContentUpdateDelay = constraints.getContentTriggerUpdateDelayMillis();
                this.triggerContentMaxDelay = constraints.getContentTriggerMaxDelayMillis();
                this.contentUriTriggers = C1601o.c0(constraints.getContentUriTriggers());
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public static final class ContentUriTrigger {
        private final boolean isTriggeredForDescendants;
        private final Uri uri;

        public ContentUriTrigger(Uri uri2, boolean z4) {
            m.e(uri2, "uri");
            this.uri = uri2;
            this.isTriggeredForDescendants = z4;
        }

        public boolean equals(Object obj) {
            Class<?> cls;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                cls = obj.getClass();
            } else {
                cls = null;
            }
            if (!m.a(ContentUriTrigger.class, cls)) {
                return false;
            }
            m.c(obj, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            ContentUriTrigger contentUriTrigger = (ContentUriTrigger) obj;
            if (m.a(this.uri, contentUriTrigger.uri) && this.isTriggeredForDescendants == contentUriTrigger.isTriggeredForDescendants) {
                return true;
            }
            return false;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return (this.uri.hashCode() * 31) + a.a(this.isTriggeredForDescendants);
        }

        public final boolean isTriggeredForDescendants() {
            return this.isTriggeredForDescendants;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Constraints(NetworkType networkType, boolean z4, boolean z5, boolean z6, int i4, C2103g gVar) {
        this((i4 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i4 & 2) != 0 ? false : z4, (i4 & 4) != 0 ? false : z5, (i4 & 8) != 0 ? false : z6);
    }

    @SuppressLint({"NewApi"})
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (m.a(Constraints.class, obj.getClass())) {
                Constraints constraints = (Constraints) obj;
                if (this.requiresCharging == constraints.requiresCharging && this.requiresDeviceIdle == constraints.requiresDeviceIdle && this.requiresBatteryNotLow == constraints.requiresBatteryNotLow && this.requiresStorageNotLow == constraints.requiresStorageNotLow && this.contentTriggerUpdateDelayMillis == constraints.contentTriggerUpdateDelayMillis && this.contentTriggerMaxDelayMillis == constraints.contentTriggerMaxDelayMillis && this.requiredNetworkType == constraints.requiredNetworkType) {
                    return m.a(this.contentUriTriggers, constraints.contentUriTriggers);
                }
                return false;
            }
        }
        return false;
    }

    @RequiresApi(24)
    public final long getContentTriggerMaxDelayMillis() {
        return this.contentTriggerMaxDelayMillis;
    }

    @RequiresApi(24)
    public final long getContentTriggerUpdateDelayMillis() {
        return this.contentTriggerUpdateDelayMillis;
    }

    @RequiresApi(24)
    public final Set<ContentUriTrigger> getContentUriTriggers() {
        return this.contentUriTriggers;
    }

    public final NetworkType getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean hasContentUriTriggers() {
        if (Build.VERSION.SDK_INT < 24 || !this.contentUriTriggers.isEmpty()) {
            return true;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public int hashCode() {
        long j4 = this.contentTriggerUpdateDelayMillis;
        long j5 = this.contentTriggerMaxDelayMillis;
        return (((((((((((((this.requiredNetworkType.hashCode() * 31) + (this.requiresCharging ? 1 : 0)) * 31) + (this.requiresDeviceIdle ? 1 : 0)) * 31) + (this.requiresBatteryNotLow ? 1 : 0)) * 31) + (this.requiresStorageNotLow ? 1 : 0)) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.contentUriTriggers.hashCode();
    }

    public final boolean requiresBatteryNotLow() {
        return this.requiresBatteryNotLow;
    }

    public final boolean requiresCharging() {
        return this.requiresCharging;
    }

    @RequiresApi(23)
    public final boolean requiresDeviceIdle() {
        return this.requiresDeviceIdle;
    }

    public final boolean requiresStorageNotLow() {
        return this.requiresStorageNotLow;
    }

    @SuppressLint({"NewApi"})
    public String toString() {
        return "Constraints{requiredNetworkType=" + this.requiredNetworkType + ", requiresCharging=" + this.requiresCharging + ", requiresDeviceIdle=" + this.requiresDeviceIdle + ", requiresBatteryNotLow=" + this.requiresBatteryNotLow + ", requiresStorageNotLow=" + this.requiresStorageNotLow + ", contentTriggerUpdateDelayMillis=" + this.contentTriggerUpdateDelayMillis + ", contentTriggerMaxDelayMillis=" + this.contentTriggerMaxDelayMillis + ", contentUriTriggers=" + this.contentUriTriggers + ", }";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Ignore
    @SuppressLint({"NewApi"})
    public Constraints(NetworkType networkType, boolean z4, boolean z5, boolean z6) {
        this(networkType, z4, false, z5, z6);
        m.e(networkType, "requiredNetworkType");
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean z4, boolean z5, boolean z6, boolean z7, int i4, C2103g gVar) {
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        NetworkType networkType2;
        Constraints constraints;
        networkType = (i4 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType;
        z4 = (i4 & 2) != 0 ? false : z4;
        z5 = (i4 & 4) != 0 ? false : z5;
        z6 = (i4 & 8) != 0 ? false : z6;
        if ((i4 & 16) != 0) {
            z8 = false;
            z10 = z5;
            z9 = z6;
            networkType2 = networkType;
            z11 = z4;
            constraints = this;
        } else {
            z8 = z7;
            z9 = z6;
            z11 = z4;
            z10 = z5;
            constraints = this;
            networkType2 = networkType;
        }
        new Constraints(networkType2, z11, z10, z9, z8);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RequiresApi(23)
    @Ignore
    @SuppressLint({"NewApi"})
    public Constraints(NetworkType networkType, boolean z4, boolean z5, boolean z6, boolean z7) {
        this(networkType, z4, z5, z6, z7, -1, 0, (Set) null, PsExtractor.AUDIO_STREAM, (C2103g) null);
        m.e(networkType, "requiredNetworkType");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Constraints(androidx.work.NetworkType r3, boolean r4, boolean r5, boolean r6, boolean r7, long r8, long r10, java.util.Set r12, int r13, kotlin.jvm.internal.C2103g r14) {
        /*
            r2 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x0006
            androidx.work.NetworkType r3 = androidx.work.NetworkType.NOT_REQUIRED
        L_0x0006:
            r14 = r13 & 2
            r0 = 0
            if (r14 == 0) goto L_0x000c
            r4 = 0
        L_0x000c:
            r14 = r13 & 4
            if (r14 == 0) goto L_0x0011
            r5 = 0
        L_0x0011:
            r14 = r13 & 8
            if (r14 == 0) goto L_0x0016
            r6 = 0
        L_0x0016:
            r14 = r13 & 16
            if (r14 == 0) goto L_0x001b
            r7 = 0
        L_0x001b:
            r14 = r13 & 32
            r0 = -1
            if (r14 == 0) goto L_0x0022
            r8 = r0
        L_0x0022:
            r14 = r13 & 64
            if (r14 == 0) goto L_0x0027
            r10 = r0
        L_0x0027:
            r13 = r13 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x002f
            java.util.Set r12 = S2.N.d()
        L_0x002f:
            r14 = r12
            r12 = r10
            r10 = r8
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r12, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Constraints.<init>(androidx.work.NetworkType, boolean, boolean, boolean, boolean, long, long, java.util.Set, int, kotlin.jvm.internal.g):void");
    }

    @RequiresApi(24)
    public Constraints(NetworkType networkType, boolean z4, boolean z5, boolean z6, boolean z7, long j4, long j5, Set<ContentUriTrigger> set) {
        m.e(networkType, "requiredNetworkType");
        m.e(set, "contentUriTriggers");
        this.requiredNetworkType = networkType;
        this.requiresCharging = z4;
        this.requiresDeviceIdle = z5;
        this.requiresBatteryNotLow = z6;
        this.requiresStorageNotLow = z7;
        this.contentTriggerUpdateDelayMillis = j4;
        this.contentTriggerMaxDelayMillis = j5;
        this.contentUriTriggers = set;
    }

    @SuppressLint({"NewApi"})
    public Constraints(Constraints constraints) {
        m.e(constraints, "other");
        this.requiresCharging = constraints.requiresCharging;
        this.requiresDeviceIdle = constraints.requiresDeviceIdle;
        this.requiredNetworkType = constraints.requiredNetworkType;
        this.requiresBatteryNotLow = constraints.requiresBatteryNotLow;
        this.requiresStorageNotLow = constraints.requiresStorageNotLow;
        this.contentUriTriggers = constraints.contentUriTriggers;
        this.contentTriggerUpdateDelayMillis = constraints.contentTriggerUpdateDelayMillis;
        this.contentTriggerMaxDelayMillis = constraints.contentTriggerMaxDelayMillis;
    }
}
