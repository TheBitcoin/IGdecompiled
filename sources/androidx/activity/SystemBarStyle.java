package androidx.activity;

import androidx.annotation.ColorInt;
import d3.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class SystemBarStyle {
    public static final Companion Companion = new Companion((C2103g) null);
    private final int darkScrim;
    private final l detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public static /* synthetic */ SystemBarStyle auto$default(Companion companion, int i4, int i5, l lVar, int i6, Object obj) {
            if ((i6 & 4) != 0) {
                lVar = SystemBarStyle$Companion$auto$1.INSTANCE;
            }
            return companion.auto(i4, i5, lVar);
        }

        public final SystemBarStyle auto(@ColorInt int i4, @ColorInt int i5) {
            return auto$default(this, i4, i5, (l) null, 4, (Object) null);
        }

        public final SystemBarStyle dark(@ColorInt int i4) {
            return new SystemBarStyle(i4, i4, 2, SystemBarStyle$Companion$dark$1.INSTANCE, (C2103g) null);
        }

        public final SystemBarStyle light(@ColorInt int i4, @ColorInt int i5) {
            return new SystemBarStyle(i4, i5, 1, SystemBarStyle$Companion$light$1.INSTANCE, (C2103g) null);
        }

        private Companion() {
        }

        public final SystemBarStyle auto(@ColorInt int i4, @ColorInt int i5, l lVar) {
            m.e(lVar, "detectDarkMode");
            return new SystemBarStyle(i4, i5, 0, lVar, (C2103g) null);
        }
    }

    public /* synthetic */ SystemBarStyle(int i4, int i5, int i6, l lVar, C2103g gVar) {
        this(i4, i5, i6, lVar);
    }

    public static final SystemBarStyle auto(@ColorInt int i4, @ColorInt int i5) {
        return Companion.auto(i4, i5);
    }

    public static final SystemBarStyle dark(@ColorInt int i4) {
        return Companion.dark(i4);
    }

    public static final SystemBarStyle light(@ColorInt int i4, @ColorInt int i5) {
        return Companion.light(i4, i5);
    }

    public final int getDarkScrim$activity_release() {
        return this.darkScrim;
    }

    public final l getDetectDarkMode$activity_release() {
        return this.detectDarkMode;
    }

    public final int getNightMode$activity_release() {
        return this.nightMode;
    }

    public final int getScrim$activity_release(boolean z4) {
        if (z4) {
            return this.darkScrim;
        }
        return this.lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean z4) {
        if (this.nightMode == 0) {
            return 0;
        }
        if (z4) {
            return this.darkScrim;
        }
        return this.lightScrim;
    }

    private SystemBarStyle(int i4, int i5, int i6, l lVar) {
        this.lightScrim = i4;
        this.darkScrim = i5;
        this.nightMode = i6;
        this.detectDarkMode = lVar;
    }

    public static final SystemBarStyle auto(@ColorInt int i4, @ColorInt int i5, l lVar) {
        return Companion.auto(i4, i5, lVar);
    }
}
